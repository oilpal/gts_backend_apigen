package com.neofect.gts.web.cms.rest.attach;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imageresize4j.ImageResizeProcessor;
import com.neofect.gts.core.services.attach.domain.Attach;
import com.neofect.gts.core.services.attach.domain.AttachBag;
import com.neofect.gts.core.services.attach.service.AttachService;
import com.neofect.gts.core.services.attach.service.ReferenceTypeRegistry;
import com.neofect.gts.core.services.user.service.UserService;
import com.unvus.config.properties.AttachProperties;
import com.unvus.services.attach.filter.AttachFilterChain;
import com.unvus.services.attach.util.ImageResizeUtil;
import com.unvus.util.LfuCache;
import com.unvus.web.util.PaginationUtil;
import com.unvus.web.util.WebUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static com.unvus.services.attach.policy.impl.DateDirectoryPathPolicy.FILE_SEP;


@RestController
public class AttachResource {

    public final static String CACHE_SCALED_IMAGE = "AttachResource.scaledImage";

    private static final Logger log = LoggerFactory.getLogger(AttachResource.class);

    enum Watermark {
        SMALL,
        LARGE
    }

    private Map<Watermark, BufferedImage> watermarkImageMap = new HashMap();

    private final ObjectMapper objectMapper;

    private final AttachService attachService;

    private final AttachProperties attachProperties;

    private final CacheManager cacheManager;

    private final UserService userService;

    private static LfuCache<Object, Object> nullCache = new LfuCache(10000l, 300l, true);

    public static final String CKEDITOR_RESULT =
        "<script type=\"text/javascript\">" +
            "window.parent.CKEDITOR.tools.callFunction(%s, '%s');" +
            "</script>";

    public AttachResource(ObjectMapper objectMapper, AttachService attachService, AttachProperties attachProperties, CacheManager cacheManager, UserService userService) {
        this.objectMapper     = objectMapper;
        this.attachService    = attachService;
        this.attachProperties = attachProperties;
        this.cacheManager = cacheManager;

        this.userService = userService;
    }

    @PostMapping(value = "/api/u/attach/tmp")
    public ResponseEntity<Map<String, Object>> uploadTemp(
                    @RequestParam("refTarget") String refTarget,
                    @RequestParam(value = "refTargetType", required = false) String refTargetType,
                    @RequestParam(value = "filters", required = false) String filters,
                    @RequestParam("file") MultipartFile file,
                    HttpServletRequest request,
                    RedirectAttributes redirectAttributes) throws Exception {


        AttachFilterChain filterChain = null;

        if (filters != null) {
            Map<String, Map<String, Object>> filterMap = objectMapper.readValue(filters, new TypeReference<Map<String, Map<String, Object>>>() {
            });

            filterChain = extractToFilterChain(filterMap);
        }

        List<Map<String, Object>> files = new ArrayList();
        Map<String, Object> item = new HashMap<>();

        try {
            String filename = attachService.uploadTemp(file, ReferenceTypeRegistry.get(refTarget), refTargetType, filterChain);

            item.put("name", filename);
            item.put("displayName", file.getOriginalFilename());
            item.put("size", file.getSize());
            item.put("type", file.getContentType());
            item.put("url", null);
            item.put("thumbnailUrl", null);
            item.put("deleteUrl", null);
            item.put("deleteType", "DELETE");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            item.put("error", e.getMessage());
        }

        files.add(item);

        Map<String, Object> result = new HashMap<>();
        result.put("files", files);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/api/u/attach/{roomName}/{roomKey}")
    public ResponseEntity<Map<String, Object>> uploadSave(
        @PathVariable("roomName") String refType,
        @PathVariable("roomKey") Long refKey,
        @RequestBody AttachBag attachBag) throws Exception {

        List<Attach>  attachList = attachService.save(ReferenceTypeRegistry.get(refType), refKey, attachBag);


        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("attachList", attachList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value="/api/u/attach",
                   produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> remove(@RequestBody List<Attach> attaches) throws Exception{

        attachService.deleteAttach(attaches);

        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value="/api/u/attach/",
                produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> modify(@RequestBody List<Attach> attaches) throws Exception{

        for(Attach attach : attaches) {
            attachService.updateAttach(attach);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * GET    /attach/{refType}/{refKey} : 첨부 리스트 조회
     */
    @GetMapping(value="/api/u/attach",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attach>> list(@RequestParam Map<String, Object> param,
                                             @RequestParam(value = "roomKeyList", required = false) List<Long> roomKeyList,
                                             @RequestParam(value = "cabinetList", required = false) List<String> cabinetList) throws Exception{
        param.put("roomKeyList", roomKeyList);
        param.put("cabinetList", cabinetList);
        List<Attach> list = attachService.listAttach(param);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();
        return new ResponseEntity<List<Attach>>(list, headers, HttpStatus.OK);
    }


    /**
     * GET  /attach/{refType}/{refKey} : 첨부 상세 조회
     *
     * @param refType 제품 아이디 (시퀀스키값)
     * @return 제품 객체
     */
    @GetMapping(value = "/api/u/attach/{roomName}/{roomKey}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttachBag> getAttach(HttpServletRequest request,
                                               @PathVariable("roomName") String refType,
                                               @PathVariable("roomKey") Long refKey) {

        return getAttach(request, refType, refKey, null, null);
    }


    /**
     * GET  /attach/{refType}/{refKey} : 첨부 상세 조회
     *
     * @param refType 제품 아이디 (시퀀스키값)
     * @return 제품 객체
     */
    @GetMapping(value = "/api/u/attach/{roomName}/{roomKey}/{cabinetName}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttachBag> getAttach(HttpServletRequest request,
                                               @PathVariable("roomName") String refType,
                                               @PathVariable("roomKey") Long refKey,
                                               @PathVariable("cabinetName") String cabinetName,
                                               @RequestParam(value="q", required = false) Map<String, Object> param) {
        if(param != null && param.containsKey("roomKeys")){
            refKey = null;
        }

		AttachBag bag = attachService.getAttachBagByRef(refType, refKey, cabinetName, param);

        return Optional.ofNullable(bag)
            .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
            .orElse(
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
            );
    }

    @GetMapping(value = {
    			"/assets/attach/{action:view|download}/{id}"  /** Action Log 안 남길때(assets URL은 sso filter 실행 안됨 **/
//                , "/api/u/attach/{action:view|download}/{id}" /** Action Log를 남길때 **/
        }
    )
    public void view(@PathVariable("action") String action,
                     @PathVariable("id") Long id,
                     @RequestParam(value="w", required = false) Integer width,
                     @RequestParam(value="h", required = false) Integer height,
                     HttpServletRequest request,
                     HttpServletResponse response) throws Exception {

        boolean isDownload = "download".equals(action);

        SimpleDateFormat dateFormat = getCacheDateFormat();

        if (!WebUtil.needFreshResponse(request, dateFormat) && !isDownload) {
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            return;
        }

        Attach attach = attachService.getAttach(id);

        if (attach == null) {
            return;
        }

        File f = new File(attachProperties.getDirectory().getUploadBaseDir() + attach.getSavedDir() + attach.getSavedName());

        if (!f.exists()) {
            return;
        }

        String contentType = attachService.detectFile(f);

        File tf = convertScaledImage(width, height, attach.getId(), f, contentType);

        File result = tf;
        if(tf == null) {
            result = f;
        }

        writeFileToClient(response, isDownload, dateFormat, attach.getDisplayName(), result, contentType);
    }

    @GetMapping(value = "/assets/attachTemp/{action:view|download}/{id}")
    public void viewTemp(@PathVariable("action") String action,
                     @PathVariable("id") String id,
                     @RequestParam(value="w", required = false) Integer width,
                     @RequestParam(value="h", required = false) Integer height,
                     HttpServletRequest request,
                     HttpServletResponse response) throws Exception {

        boolean isDownload = "download".equals(action);

        SimpleDateFormat dateFormat = getCacheDateFormat();

        if (!WebUtil.needFreshResponse(request, dateFormat) && !isDownload) {
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            return;
        }


        File f = new File(attachProperties.getDirectory().getTmpDir(), id);

        if (!f.exists()) {
            return;
        }

        String contentType = attachService.detectFile(f);

        File tf = convertScaledImage(width, height, null, f, contentType);

        if(tf == null) {
            writeFileToClient(response, isDownload, dateFormat, id + StringUtils.substringAfter(contentType, "/"), f, contentType);
        }else {
            writeFileToClient(response, isDownload, dateFormat, id + StringUtils.substringAfter(contentType, "/"), tf, contentType);
        }

    }

    /**
     * 이미지 보기
     * <p>
     * /view/attach/product/271/thumbnail
     *
     * @param refType  참조타입코드 - 예) 상품 = product
     * @param refKey   참조키 - 예) 상품 아이디 : 271
     * @param mapCode  세부타입코드 - 예) 섬네일 이미지 : thumbnail
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping(value = "/assets/attach/{action:view|download}/{refType}/{refKey}/{mapCode}")
    public void viewByRefType(
        @PathVariable("action") String action,
        @PathVariable("refType") String refType,
        @PathVariable("refKey") Long refKey,
        @PathVariable("mapCode") String mapCode,
        @RequestParam(value="extAlt", required = false) String extAlt,
        @RequestParam(value="ext", required = false) String ext,
        @RequestParam(value="fmetaValue", required = false) String fmetaValue,
        @RequestParam(value="w", required = false) Integer width,
        @RequestParam(value="h", required = false) Integer height,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        viewByRefTypeOrder(action, refType, refKey, mapCode, 1, extAlt, ext, fmetaValue, width, height, request, response);
    }


    /**
     * 이미지 보기 - 여러개가 봔환되는 경우 특정 순서의 이미지 얻기 <br/>
     * 첫번째 이미지가 "1" 로 시작
     * <p>
     * /view/attach/product/271/thumbnail/2
     *
     * @param refType  참조타입코드 - 예) 상품 = product
     * @param refKey   참조키 - 예) 상품 아이디 : 271
     * @param mapCode  세부타입코드 - 예) 섬네일 이미지 : thumbnail
     * @param idx      획득하고자 하는 이미지 순서 인덱스 : "1" 로 시작
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping(value = "/assets/attach/{action:view|download}/{refType}/{refKey}/{mapCode}/{idx}")
    public void viewByRefTypeOrder(
        @PathVariable("action") String action,
        @PathVariable("refType") String refType,
        @PathVariable("refKey") Long refKey,
        @PathVariable("mapCode") String mapCode,
        @PathVariable("idx") Integer idx,
        @RequestParam(value="extAlt", required = false) String extAlt,
        @RequestParam(value="ext", required = false) String ext,
        @RequestParam(value="fmetaValue", required = false) String fmetaValue,
        @RequestParam(value="w", required = false) Integer width,
        @RequestParam(value="h", required = false) Integer height,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        boolean isDownload = "download".equals(action);

        SimpleDateFormat dateFormat = getCacheDateFormat();

        if (!WebUtil.needFreshResponse(request, dateFormat) && !isDownload) {
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            return;
        }

        List<String> altList = null;

        if(StringUtils.isNotBlank(extAlt)) {
            ext = null;
            altList = Arrays.asList(StringUtils.split(extAlt, ":"));

        }

        List<Attach> attachList = null;
        try {
            attachList = attachService.listAttachByRef(refType, refKey, mapCode, StringUtils.isNotBlank(ext)?ext:null, fmetaValue);
        }catch(SerializationException e) {
            cacheManager.getCache(AttachService.CACHE_LIST_ATTACH_BY_REF).clear();
            attachList = attachService.listAttachByRef(refType, refKey, mapCode, StringUtils.isNotBlank(ext)?ext:null, fmetaValue);
        }

        if(CollectionUtils.isEmpty(attachList)) {
            return;
        }

        Attach attach = null;

        if(altList != null) {
            // search by alt list

            for(String alt : altList) {
                for(Attach att : attachList) {
                    if(StringUtils.equals(alt, att.getExt())) {
                        attach = att;
                        break;
                    }
                }
                if(attach != null) {
                    break;
                }
            }

            if(attach == null) {
                attach = attachList.get(0);
            }
        }else if (attachList.size() >= idx) {
            // search by index

            attach = attachList.get(idx - 1);
        }

        if(attach == null) {
            return;
        }

        File f = new File(attachProperties.getDirectory().getUploadBaseDir() + attach.getSavedDir() + attach.getSavedName());

        if (!f.exists()) {
            return;
        }

        String contentType = attachService.detectFile(f);

        File tf = convertScaledImage(width, height, attach.getId(), f, contentType);

        File result = tf;
        if(tf == null) {
            result = f;
        }

        writeFileToClient(response, isDownload, dateFormat, attach.getDisplayName(), result, contentType);

    }

    private File convertScaledImage(Integer width, Integer height, Long key, File f, String contentType) {
        if(width == null) {
            width = 0;
         }
        if(height == null) {
            height = 0;
         }

        File tf = null;
        if(width > 0 || height > 0) {
            boolean imageCreated = false;
            // get path
            String base = attachProperties.getDirectory().getUploadBaseDir();
            String filePath = StringUtils.substringAfter(f.getAbsolutePath(), base);
            String fullPath = base + File.separator + "scaled" + StringUtils.substringBeforeLast(filePath, "/");
            String scaledName = "scaled_" + key + "_" + width + "_" + height;


            try {
                if(key != null) {
                    // cache 해당 안되는 애들은 똑같은 로직 타지 않도록 map 에 담아 바로 null 을 넘길 수 있도록. map size 제한
                    if(nullCache.containsKey(scaledName)) {
                        return null;
                       }
                    tf = new File(fullPath, scaledName);
                    if (tf.exists()) {
//                        log.info("CACHED_IMAGE_FROM:" + fullPath + File.separator + scaledName);
                        return tf;
                       }
                }else {
                    tf = File.createTempFile("scaled_", "_tmp", new File(attachProperties.getDirectory().getTmpDir()));
                  }

                BufferedImage bi = ImageIO.read(f);
                int actualWidth = bi.getWidth();
                int actualHeight = bi.getHeight();
                Dimension actualDimension = new Dimension(actualWidth, actualHeight);
                Dimension tobeDimension = ImageResizeUtil.getResizeDimension(actualDimension, width, height);

                if (actualDimension.getWidth() > tobeDimension.getWidth()) {
                    if(key != null) {
                        Path path = Paths.get(fullPath);

                        if (!Files.exists(path)) {
                            Files.createDirectories(path);
                           }
                       }

                    BufferedImage resizedBi = ImageResizeUtil.resizeIn2PhasesViaIR4J(
                        bi,
                        (int) tobeDimension.getWidth(),
                        (int) tobeDimension.getHeight(),
                        ImageResizeProcessor.TYPE_NEAREST_NEIGHBOR,
                        ImageResizeProcessor.TYPE_SHARP_5
                       );

                    ImageResizeUtil.write(resizedBi, tf, contentType);
                    imageCreated = true;
                  }
            } catch (Exception ignore) {
                log.warn(ignore.getMessage(), ignore);
             }

            if(!imageCreated && tf != null) {
                tf.delete();
                tf = null;
                if(key != null) {
                    nullCache.put(scaledName, true);
                  }
              }
          }

        return tf;
    }

    private File createTempOutFile(File file) {
        return new File(file.getParentFile().getAbsolutePath(), "_filter_" + file.getName());
    }

    private void moveTempFileToOriginalFile(File tempFile, File originalFile) {
        String filename = originalFile.getName();
        originalFile.delete();
        tempFile.renameTo(Paths.get(tempFile.getParentFile().getAbsolutePath(), filename).toFile());
    }


    @RequestMapping(
        value="/api/u/ckupload/drop",
        produces    = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> ckUploadDrop(MultipartFile upload, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filename = attachService.uploadEditorImage(upload, null);

        // drag & drop
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("fileName", "");
        resultMap.put("uploaded", 1);
        resultMap.put("url", "/assets/editor/image" + filename);

        return new ResponseEntity<>(resultMap, HttpStatus.OK);

    }

    @RequestMapping(
        value="/api/u/ckupload/modal",
        produces    = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String upload(MultipartFile upload, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filename = attachService.uploadEditorImage(upload, null);

        // dialog
        response.setContentType("text/html;charset=UTF-8");
        return String.format(CKEDITOR_RESULT, request.getParameter("CKEditorFuncNum"), "/assets/editor/image" + filename);

    }

    @RequestMapping("/assets/editor/image/**")
    public void imageDown(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        if (!WebUtil.needFreshResponse(request, dateFormat)) {
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            return;
        }

        String filePath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

        filePath = StringUtils.substringAfter(filePath, "/assets/editor/image");
        String baseDir = attachService.getBaseDir() + FILE_SEP + ReferenceTypeRegistry.CKEDITOR.getRoomName();

        File f = new File(baseDir + filePath);

        if(!f.exists()) {
            return;
        }

        writeFileToClient(response, false, dateFormat, null, f, attachService.detectFile(f));
    }

    @PostMapping("api/u/attach/copy/{roomName}/{roomKey}/{cabinetName}")
    public ResponseEntity<Object> imageCopy(
            @PathVariable("roomName") String refType,
            @PathVariable("roomKey") Long refKey,
            @PathVariable("cabinetName") String cabinetName,
            @RequestBody List<Long> copyIds,
            HttpServletRequest request) throws Exception {

        // vr 기존 게시 해재
        if(cabinetName.equals("vrphoto")) {
            List<Attach> postedList = attachService.listAttachByRef(refType, refKey, cabinetName, "10");
            if(postedList.size() > 0) {
                for(Attach attach : postedList) {
                    attach.setExt("00");
                    attachService.updateAttach(attach);
                }
            }
        }

    	attachService.copy(ReferenceTypeRegistry.get(refType), null, refKey, null, copyIds);

    	return new ResponseEntity<>(HttpStatus.OK);
    }

    private void writeFileToClient(HttpServletResponse response, boolean isDownload, SimpleDateFormat dateFormat, String displayName, File f, String contentType) throws Exception {
        writeFileToClient(response, isDownload, dateFormat, displayName, f, contentType, null);
    }

    private void writeFileToClient(HttpServletResponse response, boolean isDownload, SimpleDateFormat dateFormat, String displayName, File f, String contentType, BufferedImage waterMarkImage) throws Exception {
        response.setContentType(contentType);

        if (isDownload) {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(displayName, "UTF-8") + "\"");
        } else {
            WebUtil.setCacheHeader(response, dateFormat);
        }

        String[] contentTypeArr = StringUtils.split(contentType, "/");
        if(waterMarkImage != null && contentTypeArr.length == 2 && "image".equals(contentTypeArr[0])) {
            File waterMarkedFile = File.createTempFile("watermark_", "_tmp", new File(attachProperties.getDirectory().getTmpDir()));
            WebUtil.writeFileWithWatermark(f, waterMarkImage, waterMarkedFile, contentTypeArr[1]);

            response.setContentLength((int) waterMarkedFile.length());
            WebUtil.writeFile(response, waterMarkedFile);
        }else {
            response.setContentLength((int) f.length());
            WebUtil.writeFile(response, f);
        }
    }

    private AttachFilterChain extractToFilterChain(Map<String, Map<String, Object>> filterMap) {
        AttachFilterChain filterChain = new AttachFilterChain();

        filterMap.forEach((k, v) -> {
            Class filterClass = null;
            try {
                AttachProperties.Filter filter = attachProperties.getFilterMap().get(k);
                filterClass = Class.forName(filter.getClassName());
                if (v == null || v.isEmpty()) {
                    filterChain.addFilter(filterClass, filter.getConfig());
                } else {
                    filterChain.addFilter(filterClass, v);
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        });
        return filterChain;
    }

    private SimpleDateFormat getCacheDateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat;
    }

}

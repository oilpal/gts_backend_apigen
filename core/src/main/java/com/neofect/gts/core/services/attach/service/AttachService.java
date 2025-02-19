package com.neofect.gts.core.services.attach.service;



import com.neofect.gts.core.services.attach.domain.Attach;
import com.neofect.gts.core.services.attach.domain.AttachBag;
import com.neofect.gts.core.services.attach.repository.AttachRepository;
import com.unvus.event.UnvusEvent;
import com.unvus.event.UnvusEventPublisher;
import com.neofect.gts.core.services.attach.domain.Attach;
import com.neofect.gts.core.services.attach.domain.AttachBag;
import com.neofect.gts.core.services.attach.repository.AttachRepository;
import com.unvus.services.attach.domain.AttachRoom;
import com.unvus.services.attach.domain.RoomCabinet;
import com.unvus.services.attach.filter.AttachFilterChain;
import com.unvus.services.attach.policy.DirectoryPathPolicy;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Class Name : AttachService.java
 * Description :  서비스 클래스
 * Modification Information
 *
 * @author
 * @since 2016. 08. 16
 * @version 1.0
 *
 * Generated : Source Builder
 */

@Service
public class AttachService {

    public final static String CACHE_LIST_ATTACH_BY_REF = "AttachService.listAttachByRef";

    private final Logger log = LoggerFactory.getLogger(AttachService.class);

    public final static String DELETED_MAP_CODE = "_deleted";

//    public static final String FILE_SEP = System.getProperty("file.separator");
    public static final String FILE_SEP = "/";

    private final DirectoryPathPolicy directoryPathPolicy;

    private final AttachRepository attachRepository;

    private final UnvusEventPublisher eventPublisher;

    private static Tika tika = new Tika();

    public AttachService(DirectoryPathPolicy directoryPathPolicy, AttachRepository attachRepository, UnvusEventPublisher eventPublisher) {
        this.directoryPathPolicy    = directoryPathPolicy;
        this.attachRepository       = attachRepository;
        this.eventPublisher   = eventPublisher;
    }


    /**
     * 파일 업로드 프로세스 중 첫번째 단계인 <em>"임시파일 업로드"</em> 처리<br/>
     * 대략의 파일 업로드 프로세스
     * <ol>
     *     <li>임시 파일로 업로드</li>
     *     <li>uuid 반환</li>
     *     <li>form submit 시 uuid 전송</li>
     * </ol>
     *
     * @param file  첨부파일 객체
     * @param attachRoom <code>ReferenceTypeRegistry</code> 으로 부터 얻은 attachRomm 객체
     * @param cabinetName 상세 캐비넷 이름
     * @param filterChain 적용할 filterChain. 없으면 최초 설정(attach.yml)에 저장된 filterChain 사용
     * @return uuid
     * @throws Exception
     */
    public String uploadTemp(MultipartFile file, AttachRoom attachRoom, String cabinetName, AttachFilterChain filterChain) throws Exception {

        createDirectoryIfNotExists(directoryPathPolicy.getTempDir());

        if(StringUtils.isBlank(cabinetName)) {
            cabinetName = ReferenceTypeRegistry._DEFAULT_CABINET_NAME;
        }

        if (!file.isEmpty()) {
            InputStream is = file.getInputStream();
            try {
                String uuid = UUID.randomUUID().toString();
                Path path = Paths.get(directoryPathPolicy.getTempDir(), uuid);

                Files.copy(is, path);

                try {
                    if(filterChain == null || filterChain.size() == 0) {
                        RoomCabinet cabinet = attachRoom.getCabinet(cabinetName);
                        if(cabinet == null) {
                            attachRoom.addCabinet(cabinetName);
                        }
                        attachRoom.getCabinet(cabinetName).startFilter(path.toFile());
                    }else {
                        filterChain.startFilter(path.toFile());
                    }
                }catch(Exception e) {
                    log.error(e.getMessage(), e);
                    throw new RuntimeException(e.getMessage());
                }

                return uuid;
            } catch (IOException |RuntimeException e) {
                throw new Exception("Failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
            }finally {
                IOUtils.closeQuietly(is);
            }
        } else {
            throw new FileNotFoundException("Failed to upload " + file.getOriginalFilename() + " because it was empty");
        }
    }

    @Transactional
    public List<Attach> save(AttachRoom attachRoom, Long roomKey, Map<String, List<Attach>>  bag) throws Exception {
        return save(attachRoom, roomKey, bag, false);
    }

    @Transactional
//    @CacheEvict(cacheNames = CACHE_LIST_ATTACH_BY_REF, key = "{#attachRoom, #roomKey, #cabinetName, #ext, #fmetaValue}")
    public List<Attach> save(AttachRoom attachRoom, Long roomKey, Map<String, List<Attach>>  bag, boolean cleanRoom) throws Exception {
        List<Attach> newAttachList = new ArrayList();

        if(bag == null || bag.isEmpty()) {
            return newAttachList;
        }

        String saveDir = directoryPathPolicy.getBaseDir() + FILE_SEP + attachRoom.getRoomName() + FILE_SEP + directoryPathPolicy.getSubDir();

        boolean cleared = false;

        for(Map.Entry<String, List<Attach>> entry: bag.entrySet()) {
            String mapCode = entry.getKey();
            if(StringUtils.equals(mapCode, DELETED_MAP_CODE)) {
                deleteAttachPermanently(entry.getValue());
            }else {
                if(entry.getValue() == null ) {
                    continue;
                }
                for(Attach attach : entry.getValue()) {
                    if(attach.getId() != null || attach.getSavedName() == null) {
                        continue;
                       }

                    if(cleanRoom && !cleared) {
                        clearAttachByRoom(attachRoom.getRoomName(), roomKey);
                        cleared = true;
                       }

                    InputStream is = Files.newInputStream(Paths.get(directoryPathPolicy.getTempDir(), attach.getSavedName()));

                    Attach newAttach;
                    if (attach.getExt() == null || attach.getExt().equals("")) {
                        newAttach = persistFile(attachRoom.getRoomName(), roomKey, mapCode, attach.getDisplayName(), saveDir, is);
                    } else {
                        newAttach = persistFile(attachRoom.getRoomName(), roomKey, mapCode, attach.getDisplayName(), saveDir, is, attach.getExt(), null);
                       }
                    newAttachList.add(newAttach);
                 }
             }
        }

        Attach attach = new Attach();
        attach.setRefTarget(attachRoom.getRoomName());
        attach.setRefTargetKey(roomKey);
        eventPublisher.onUpdate(new UnvusEvent(UnvusEvent.TYPE.UPDATED, attach, ""));

        return newAttachList;
    }

    @Transactional
    public void copy(AttachRoom attachRoom, Long roomKey, Long newRoomKey, AttachBag bag, List<Long> ids) throws Exception {
        String saveDir = directoryPathPolicy.getBaseDir() + FILE_SEP + attachRoom.getRoomName() + FILE_SEP + directoryPathPolicy.getSubDir();

        Map<String, Object> param = new HashMap<>();

        if(CollectionUtils.isNotEmpty(ids)) {
            param.put("ids", ids);
        }else {
            param.put("refTarget", attachRoom.getRoomName());
            param.put("refTargetKey", roomKey);
        }

        List<Attach> attachList = attachRepository.listAttach(param);

        List<Long> deletedIdList = new ArrayList();

        if(bag != null) {
            List<Attach> deletedList = bag.get(DELETED_MAP_CODE);

            if(deletedList != null) {
                deletedIdList = deletedList.stream()
                        .map(Attach::getId).collect(Collectors.toList());
            }

            bag.remove(DELETED_MAP_CODE);
        }

        for(Attach attach : attachList) {
            if(deletedIdList.contains(attach.getId())) {
                continue;
            }
            try {
                InputStream is = Files.newInputStream(Paths.get(directoryPathPolicy.getBaseDir() + attach.getSavedDir(), attach.getSavedName()));
                String mapCode = attach.getRefTargetType();

                Attach newAttach = persistFile(attachRoom.getRoomName(), newRoomKey, mapCode, attach.getDisplayName(), saveDir, is, "10", attach.getCreatedDt());
            }catch(Exception e) {
                log.error(e.getMessage(), e);
            }

        }

    }

    public Attach persistFile(String refTarget, Long refTargetKey, String refTargetType, String displayName, String saveDir, InputStream is) throws Exception {
        return persistFile(refTarget, refTargetKey, refTargetType, displayName, saveDir, is, null, null);
    }

    public Attach persistFile(String refTarget, Long refTargetKey, String refTargetType, String displayName, String saveDir, InputStream is, String ext, LocalDateTime createdDt) throws Exception {
        createDirectoryIfNotExists(saveDir);

        String extension = StringUtils.substringAfterLast(displayName, ".");

        String fileName = (StringUtils.isNotBlank(refTargetType) ? refTargetType + "_" : "")
            + RandomStringUtils.randomAlphanumeric(20)
            + "."
            + extension;

        String uniqueName = getUniqueFileName(saveDir, fileName);

        Long size = Files.copy(is, Paths.get(saveDir, uniqueName));

        Attach attach = new Attach();
        attach.setRefTarget(refTarget);
        attach.setRefTargetKey(refTargetKey);
        attach.setRefTargetType(refTargetType);
        attach.setDisplayName(displayName);
        attach.setSavedName(uniqueName);
        attach.setSavedDir(StringUtils.removeStart(saveDir, directoryPathPolicy.getBaseDir()));
        attach.setFileSize(size);
        attach.setExt(ext);
        attach.setCreatedDt(createdDt);

        File file = new File(directoryPathPolicy.getBaseDir() + attach.getSavedDir() + attach.getSavedName());
        String fileType = detectFile(file);
        attach.setFileType(fileType);

        attachRepository.insertAttach(attach);

        return attach;
    }

    public String uploadEditorImage(MultipartFile upload, String dirPath) throws Exception {
        String baseDir = directoryPathPolicy.getBaseDir() + FILE_SEP + ReferenceTypeRegistry.CKEDITOR.getRoomName();

        if(dirPath == null) {
            dirPath = "";
        }else {
            dirPath = FILE_SEP + dirPath;
        }

        String subDir = dirPath + FILE_SEP + directoryPathPolicy.getSubDir();

        String saveDir = baseDir + subDir;

        if(upload != null && upload.getSize() != 0) {

            File dir = new File(saveDir);
            if(!dir.exists()) { // 경로 존재하지 않으면 강제로 만들어줌
                dir.mkdirs();
            }
            String orgName = upload.getOriginalFilename();

            String extension = StringUtils.substringAfterLast(orgName, ".");

            if(StringUtils.isEmpty(extension)) {
                extension = getFormatName(detectFile(upload.getInputStream()));
            }

            String fileName = RandomStringUtils.randomAlphanumeric(20) + "." + extension;

            String uniqueName = getUniqueFileName(saveDir, fileName);

            Files.copy(upload.getInputStream(), Paths.get(saveDir, uniqueName));
            return subDir + uniqueName;
        }
        return null;
    }

    public void deleteAttach(List<Attach> attaches) {
        deleteAttachPermanently(attaches);
        if(CollectionUtils.isNotEmpty(attaches)) {
            Attach attach = attaches.get(0);
            eventPublisher.onUpdate(new UnvusEvent(UnvusEvent.TYPE.UPDATED, attach, ""));
        }
    }

    public int updateAttach(Attach attach) {
        int cnt = attachRepository.updateAttach(attach);

        eventPublisher.onUpdate(new UnvusEvent(UnvusEvent.TYPE.UPDATED, attach, ""));

        return cnt;
    }


    private void deleteAttachPermanently(List<Attach> attaches) {
        for(Attach attach : attaches) {
            Attach savedAttach = attachRepository.getAttach(attach.getId());
            if(StringUtils.isNoneBlank(savedAttach.getSavedDir()) && StringUtils.isNoneBlank(savedAttach.getSavedName())) {
                File t = new File(savedAttach.getSavedDir()+savedAttach.getSavedName());
                if(t.exists()) {
                    t.delete();
                }
                attachRepository.deleteAttach(attach.getId());
            }else {
                throw new InvalidPathException("", "No path specified");
            }
        }
    }

    private void createDirectoryIfNotExists(String saveDir) throws IOException {
        Path path = Paths.get(saveDir);
        //if directory exists?
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }


    /**
     *  상세 조회
     * @param id
     * @return Attach
     */
    @Transactional(readOnly = true)
    public Attach getAttach(Long id) {
        return attachRepository.getAttach(id);
    }

    /**
     *  카운트 조회
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public int listAttachCnt(Map<String, Object> param) {
        return attachRepository.listAttachCnt(param);
    }

    /**
     *  목록 조회
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<Attach> listAttach(Map<String, Object> param) {
        List<Attach> result = attachRepository.listAttach(param);

        return result;
    }

    @Transactional(readOnly = true)
    public int listAttachCntByRef(String refTarget, Long refTargetKey, String refTargetType) {
        Map<String, Object> param = new HashMap();
        param.put("refTarget", refTarget);
        param.put("refTargetKey", refTargetKey);
        param.put("refTargetType", refTargetType);
        return attachRepository.listAttachCnt(param);
    }

    public List<Attach> listAttachByRef(String refTarget, Long refTargetKey, String refTargetType) {
        return listAttachByRef(refTarget, refTargetKey, refTargetType, null);
    }

//    @Cacheable(cacheNames = CACHE_LIST_ATTACH_BY_REF)
//    @CacheEvict(cacheNames = CACHE_LIST_ATTACH_BY_REF, key = "{#roomName}")
    public List<Attach> listAttachByRef(String refTarget, Long refTargetKey, String refTargetType, String ext, String fmetaValue) {
        Map<String, Object> param = new HashMap();
        param.put("refTarget", refTarget);
        param.put("refTargetKey", refTargetKey);
        param.put("refTargetType", refTargetType);
        param.put("ext", ext);
        param.put("fmetaValue", fmetaValue);
        List<Attach> list = attachRepository.listAttach(param);

//        CacheUtil.evictStartsWith(CACHE_LIST_ATTACH_BY_REF, roomName, roomKey);
        return list;
    }
    public List<Attach> listAttachByRef(String refTarget, Long refTargetKey, String refTargetType, String ext) {
        return listAttachByRef(refTarget, refTargetKey, refTargetType, ext, null);
    }

    public AttachBag getAttachBagByRef(String refTarget, Long refTargetKey, String refTargetType) {
        return getAttachBagByRef(refTarget, refTargetKey, refTargetType, new HashMap<>());
    }

    public AttachBag getAttachBagByRef(String refTarget, Long refTargetKey, String refTargetType, Map<String, Object> param) {
        if(param == null) {
            param = new HashMap<>();
        }
        param.put("refTarget", refTarget);
        param.put("refTargetKey", refTargetKey);
        if(StringUtils.isNotBlank(refTargetType)) {
            param.put("refTargetType", refTargetType);
        }
        List<Attach> list = attachRepository.listAttach(param);

        AttachBag bag = new AttachBag();

        if(CollectionUtils.isNotEmpty(list)) {
            for(Attach attach : list) {
                if(!bag.containsKey(attach.getRefTargetType())) {
                    bag.put(attach.getRefTargetType(), new ArrayList<>());
                }
                bag.get(attach.getRefTargetType()).add(attach);
            }
        }

        return bag;
    }

    public Map<Long, AttachBag> getAttachBagMapByRef(String refTarget, List<Long> refTargetKeyList) {
        Map<String, Object> param = new HashMap();
        param.put("refTarget", refTarget);
        param.put("roomKeyList", refTargetKeyList);
        List<Attach> list = attachRepository.listAttach(param);

        Map<Long, AttachBag> result = new HashMap<>();

        for(Attach attach : list) {
            if(!result.containsKey(attach.getRefTargetKey())) {
                result.put(attach.getRefTargetKey(), new AttachBag());
            }
            AttachBag bag = result.get(attach.getRefTargetKey());
            if(!bag.containsKey(attach.getRefTargetType())) {
                bag.put(attach.getRefTargetType(), new ArrayList<>());
            }
            bag.get(attach.getRefTargetType()).add(attach);
        }

        return result;
    }

    public int clearAttachByRoom(String refTarget, Long refTargetKey) {
        List<Attach> attachList = listAttachByRef(refTarget, refTargetKey, null);
        deleteAttachPermanently(attachList);
        return 1;
    }


    private String getUniqueFileName(String path, String fileName) {
        File tmpFile = new File(path + fileName);
        File parentDir = tmpFile.getParentFile();
        int count = 1;
        String extension = FilenameUtils.getExtension(tmpFile.getName());
        String baseName = FilenameUtils.getBaseName(tmpFile.getName());
        String uniqueName = baseName + "_" + count++ + "_." + extension;
        while(tmpFile.exists()) {
            tmpFile = new File(parentDir, uniqueName);
        }
        return uniqueName;
    }

    /**
     * 이미지 구분
     * @param stream
     * @return
     * @throws Exception
     */
    public static String detectFile(InputStream stream) {

        String contentType = null;
        try {
            synchronized (tika) {
                contentType = tika.detect(stream);
            }
        }catch (Exception ignore){}
        return contentType;
    }

    /**
     * 이미지 구분
     * @param filename
     * @return
     * @throws Exception
     */
    public static String detectFile(String filename)  {

        String contentType = null;
        try {
            synchronized (tika) {
                contentType = tika.detect(filename);
            }
        }catch (Exception ignore){}
        return contentType;
    }

    public static String detectFile(File file)  {

        String contentType = null;
        try {
            synchronized (tika) {
                contentType = tika.detect(file);
            }
        }catch (Exception ignore){}
        return contentType;
    }

    private String getFormatName(String contentType) {
        if(StringUtils.indexOf(contentType, "jpeg") >= 0) {
            return "jpg";
        }else if(StringUtils.indexOf(contentType, "jpg") >= 0) {
            return "jpg";
        }else if(StringUtils.indexOf(contentType, "gif") >= 0) {
            return "gif";
        }else if(StringUtils.indexOf(contentType, "png") >= 0) {
            return "png";
        }
        return "jpg";
    }

    public String getBaseDir() {
        return directoryPathPolicy.getBaseDir();
    }


}

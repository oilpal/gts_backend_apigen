package com.neofect.gts.web.cms.rest.attach;

import com.neofect.gts.core.services.attach.domain.AttachBag;
import com.neofect.gts.core.services.attach.service.AttachService;
import com.neofect.gts.core.services.attach.service.ReferenceTypeRegistry;
import com.unvus.config.mybatis.pagination.Pagination;
import com.unvus.web.util.PaginationUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class FileManageResource {

    private final AttachService attachService;
    private final String FILE_MANAGE_REF_TARGET = "file_manage";

    public FileManageResource (AttachService attachService) {
        this.attachService = attachService;
    }

    /**
     *
     */
    @GetMapping(value       = "/file-manage/{refTargetType}",
        produces    = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AttachBag>> listFileManage(@RequestParam(value="q", required = false) Map q,
                                                      @PathVariable("refTargetType") String refTargetType
                                                      ) throws URISyntaxException {
        if(q == null) {
            q = new HashMap();
        }

        q.put("refTarget", FILE_MANAGE_REF_TARGET);
        q.put("refTargetType", refTargetType);

        Pagination.off();
        List<AttachBag> attachBagList = attachService.listAttach(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(attachBagList, headers, HttpStatus.OK);
    }

    /**
     * 추가
     */
    @PostMapping("/file-manage")
    public ResponseEntity<Void> addFileManage(@RequestBody FileManage fileManage) throws Exception {
        attachService.save(ReferenceTypeRegistry.FILE_MANAGE, fileManage.getId(), fileManage.getAttachBag());
        return ResponseEntity.ok().build();
    }

    @Data
    static class FileManage {
        private Long id;
        private String label;
        private AttachBag attachBag;

    }
}

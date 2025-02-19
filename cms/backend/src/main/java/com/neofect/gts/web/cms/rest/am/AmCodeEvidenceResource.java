/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.am;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.common.collect.ImmutableMap;
import com.neofect.gts.core.services.am.domain.AmCodeEvidence;
import com.neofect.gts.core.services.am.service.AmCodeEvidenceService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link AmCodeEvidence}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class AmCodeEvidenceResource {

    private final AmCodeEvidenceService amCodeEvidenceService;

    public AmCodeEvidenceResource(AmCodeEvidenceService amCodeEvidenceService) {
        this.amCodeEvidenceService = amCodeEvidenceService;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeEvidence API

    /**
     *
     */
    @GetMapping(value = "/am-code-evidence", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AmCodeEvidence>> listAmCodeEvidence(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<AmCodeEvidence> amCodeEvidenceList = amCodeEvidenceService.listAmCodeEvidence(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(amCodeEvidenceList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/am-code-evidence/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = amCodeEvidenceService.listAmCodeEvidenceCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/am-code-evidence/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeEvidence> getEmptyAmCodeEvidence() {
        AmCodeEvidence amCodeEvidence = new AmCodeEvidence();
        return new ResponseEntity<>(amCodeEvidence, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/am-code-evidence/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeEvidence> getAmCodeEvidence(@PathVariable("id") Long id) {
        AmCodeEvidence amCodeEvidence = amCodeEvidenceService.getAmCodeEvidence(id);
        return new ResponseEntity<>(amCodeEvidence, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/am-code-evidence")
    public ResponseEntity<Void> addAmCodeEvidence(@RequestBody AmCodeEvidence amCodeEvidence) {
        amCodeEvidenceService.saveAmCodeEvidence(amCodeEvidence);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/am-code-evidence/{id}")
    public ResponseEntity<Void> updateAmCodeEvidence(@PathVariable("id") Long id, @RequestBody AmCodeEvidence amCodeEvidence) throws Exception {
        if (!id.equals(amCodeEvidence.getId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        amCodeEvidenceService.saveAmCodeEvidence(amCodeEvidence);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/am-code-evidence/{id}")
    public ResponseEntity<Void> removeAmCodeEvidence(@PathVariable("id") Long id) {
        amCodeEvidenceService.removeAmCodeEvidence(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

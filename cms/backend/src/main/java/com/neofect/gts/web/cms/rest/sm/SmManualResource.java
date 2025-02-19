/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.sm;

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
import com.neofect.gts.core.services.sm.domain.SmManual;
import com.neofect.gts.core.services.sm.service.SmManualService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link SmManual}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class SmManualResource {

    private final SmManualService smManualService;

    public SmManualResource(SmManualService smManualService) {
        this.smManualService = smManualService;
    }

    //region ------------------------------------------------------------------------------------------------ smManual API

    /**
     *
     */
    @GetMapping(value = "/sm-manual", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SmManual>> listSmManual(@RequestParam(value = "q", required = false) Map<String, Object> q) throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<SmManual> smManualList = smManualService.listSmManual(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(smManualList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/sm-manual/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = smManualService.listSmManualCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/sm-manual/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmManual> getEmptySmManual() {
        SmManual smManual = new SmManual();
        return new ResponseEntity<>(smManual, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/sm-manual/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmManual> getSmManual(@PathVariable("id") Long id) {
        SmManual smManual = smManualService.getSmManual(id);
        return new ResponseEntity<>(smManual, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/sm-manual")
    public ResponseEntity<Void> addSmManual(@RequestBody SmManual smManual) {
        smManualService.saveSmManual(smManual);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/sm-manual/{id}")
    public ResponseEntity<Void> updateSmManual(@PathVariable("id") Long id, @RequestBody SmManual smManual) throws Exception {
        // if (!id.equals(smManual.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        smManualService.saveSmManual(smManual);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/sm-manual/{id}")
    public ResponseEntity<Void> removeSmManual(@PathVariable("id") Long id) {
        smManualService.removeSmManual(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

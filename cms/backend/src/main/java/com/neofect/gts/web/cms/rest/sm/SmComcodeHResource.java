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
import com.neofect.gts.core.services.sm.domain.SmComcodeH;
import com.neofect.gts.core.services.sm.service.SmComcodeHService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link SmComcodeH}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class SmComcodeHResource {

    private final SmComcodeHService smComcodeHService;

    public SmComcodeHResource(SmComcodeHService smComcodeHService) {
        this.smComcodeHService = smComcodeHService;
    }

    //region ------------------------------------------------------------------------------------------------ smComcodeH API

    /**
     *
     */
    @GetMapping(value = "/sm-comcode-h", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SmComcodeH>> listSmComcodeH(@RequestParam(value = "q", required = false) Map<String, Object> q) throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<SmComcodeH> smComcodeHList = smComcodeHService.listSmComcodeH(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(smComcodeHList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/sm-comcode-h/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = smComcodeHService.listSmComcodeHCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/sm-comcode-h/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmComcodeH> getEmptySmComcodeH() {
        SmComcodeH smComcodeH = new SmComcodeH();
        return new ResponseEntity<>(smComcodeH, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/sm-comcode-h/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmComcodeH> getSmComcodeH(@PathVariable("id") Long id) {
        SmComcodeH smComcodeH = smComcodeHService.getSmComcodeH(id);
        return new ResponseEntity<>(smComcodeH, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/sm-comcode-h")
    public ResponseEntity<Void> addSmComcodeH(@RequestBody SmComcodeH smComcodeH) {
        smComcodeHService.saveSmComcodeH(smComcodeH);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/sm-comcode-h/{id}")
    public ResponseEntity<Void> updateSmComcodeH(@PathVariable("id") Long id, @RequestBody SmComcodeH smComcodeH) throws Exception {
        // if (!id.equals(smComcodeH.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        smComcodeHService.saveSmComcodeH(smComcodeH);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/sm-comcode-h/{id}")
    public ResponseEntity<Void> removeSmComcodeH(@PathVariable("id") Long id) {
        smComcodeHService.removeSmComcodeH(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

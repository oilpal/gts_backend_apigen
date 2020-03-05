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
import com.neofect.gts.core.services.sm.domain.SmAuthAct;
import com.neofect.gts.core.services.sm.service.SmAuthActService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link SmAuthAct}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class SmAuthActResource {

    private final SmAuthActService smAuthActService;

    public SmAuthActResource(SmAuthActService smAuthActService) {
        this.smAuthActService = smAuthActService;
    }

    //region ------------------------------------------------------------------------------------------------ smAuthAct API

    /**
     *
     */
    @GetMapping(value = "/sm-auth-act", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SmAuthAct>> listSmAuthAct(@RequestParam(value = "q", required = false) Map<String, Object> q) throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<SmAuthAct> smAuthActList = smAuthActService.listSmAuthAct(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(smAuthActList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/sm-auth-act/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = smAuthActService.listSmAuthActCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/sm-auth-act/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmAuthAct> getEmptySmAuthAct() {
        SmAuthAct smAuthAct = new SmAuthAct();
        return new ResponseEntity<>(smAuthAct, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/sm-auth-act/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmAuthAct> getSmAuthAct(@PathVariable("id") Long id) {
        SmAuthAct smAuthAct = smAuthActService.getSmAuthAct(id);
        return new ResponseEntity<>(smAuthAct, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/sm-auth-act")
    public ResponseEntity<Void> addSmAuthAct(@RequestBody SmAuthAct smAuthAct) {
        smAuthActService.saveSmAuthAct(smAuthAct);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/sm-auth-act/{id}")
    public ResponseEntity<Void> updateSmAuthAct(@PathVariable("id") Long id, @RequestBody SmAuthAct smAuthAct) throws Exception {
        // if (!id.equals(smAuthAct.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        smAuthActService.saveSmAuthAct(smAuthAct);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/sm-auth-act/{id}")
    public ResponseEntity<Void> removeSmAuthAct(@PathVariable("id") Long id) {
        smAuthActService.removeSmAuthAct(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

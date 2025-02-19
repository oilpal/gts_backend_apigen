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
import com.neofect.gts.core.services.am.domain.AmCodeAcntMast;
import com.neofect.gts.core.services.am.service.AmCodeAcntMastService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link AmCodeAcntMast}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class AmCodeAcntMastResource {

    private final AmCodeAcntMastService amCodeAcntMastService;

    public AmCodeAcntMastResource(AmCodeAcntMastService amCodeAcntMastService) {
        this.amCodeAcntMastService = amCodeAcntMastService;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeAcntMast API

    /**
     *
     */
    @GetMapping(value = "/am-code-acnt-mast", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AmCodeAcntMast>> listAmCodeAcntMast(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<AmCodeAcntMast> amCodeAcntMastList = amCodeAcntMastService.listAmCodeAcntMast(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(amCodeAcntMastList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/am-code-acnt-mast/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = amCodeAcntMastService.listAmCodeAcntMastCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/am-code-acnt-mast/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeAcntMast> getEmptyAmCodeAcntMast() {
        AmCodeAcntMast amCodeAcntMast = new AmCodeAcntMast();
        return new ResponseEntity<>(amCodeAcntMast, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/am-code-acnt-mast/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeAcntMast> getAmCodeAcntMast(@PathVariable("id") Long id) {
        AmCodeAcntMast amCodeAcntMast = amCodeAcntMastService.getAmCodeAcntMast(id);
        return new ResponseEntity<>(amCodeAcntMast, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/am-code-acnt-mast")
    public ResponseEntity<Void> addAmCodeAcntMast(@RequestBody AmCodeAcntMast amCodeAcntMast) {
        amCodeAcntMastService.saveAmCodeAcntMast(amCodeAcntMast);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/am-code-acnt-mast/{id}")
    public ResponseEntity<Void> updateAmCodeAcntMast(@PathVariable("id") Long id, @RequestBody AmCodeAcntMast amCodeAcntMast) throws Exception {
        if (!id.equals(amCodeAcntMast.getId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        amCodeAcntMastService.saveAmCodeAcntMast(amCodeAcntMast);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/am-code-acnt-mast/{id}")
    public ResponseEntity<Void> removeAmCodeAcntMast(@PathVariable("id") Long id) {
        amCodeAcntMastService.removeAmCodeAcntMast(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

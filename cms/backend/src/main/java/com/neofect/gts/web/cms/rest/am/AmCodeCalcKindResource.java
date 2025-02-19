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
import com.neofect.gts.core.services.am.domain.AmCodeCalcKind;
import com.neofect.gts.core.services.am.service.AmCodeCalcKindService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link AmCodeCalcKind}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class AmCodeCalcKindResource {

    private final AmCodeCalcKindService amCodeCalcKindService;

    public AmCodeCalcKindResource(AmCodeCalcKindService amCodeCalcKindService) {
        this.amCodeCalcKindService = amCodeCalcKindService;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeCalcKind API

    /**
     *
     */
    @GetMapping(value = "/am-code-calc-kind", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AmCodeCalcKind>> listAmCodeCalcKind(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<AmCodeCalcKind> amCodeCalcKindList = amCodeCalcKindService.listAmCodeCalcKind(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(amCodeCalcKindList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/am-code-calc-kind/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = amCodeCalcKindService.listAmCodeCalcKindCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/am-code-calc-kind/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeCalcKind> getEmptyAmCodeCalcKind() {
        AmCodeCalcKind amCodeCalcKind = new AmCodeCalcKind();
        return new ResponseEntity<>(amCodeCalcKind, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/am-code-calc-kind/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeCalcKind> getAmCodeCalcKind(@PathVariable("id") Long id) {
        AmCodeCalcKind amCodeCalcKind = amCodeCalcKindService.getAmCodeCalcKind(id);
        return new ResponseEntity<>(amCodeCalcKind, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/am-code-calc-kind")
    public ResponseEntity<Void> addAmCodeCalcKind(@RequestBody AmCodeCalcKind amCodeCalcKind) {
        amCodeCalcKindService.saveAmCodeCalcKind(amCodeCalcKind);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/am-code-calc-kind/{id}")
    public ResponseEntity<Void> updateAmCodeCalcKind(@PathVariable("id") Long id, @RequestBody AmCodeCalcKind amCodeCalcKind) throws Exception {
        if (!id.equals(amCodeCalcKind.getId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        amCodeCalcKindService.saveAmCodeCalcKind(amCodeCalcKind);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/am-code-calc-kind/{id}")
    public ResponseEntity<Void> removeAmCodeCalcKind(@PathVariable("id") Long id) {
        amCodeCalcKindService.removeAmCodeCalcKind(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

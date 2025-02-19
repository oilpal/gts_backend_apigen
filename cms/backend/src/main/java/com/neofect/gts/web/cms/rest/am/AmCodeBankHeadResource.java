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
import com.neofect.gts.core.services.am.domain.AmCodeBankHead;
import com.neofect.gts.core.services.am.service.AmCodeBankHeadService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link AmCodeBankHead}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class AmCodeBankHeadResource {

    private final AmCodeBankHeadService amCodeBankHeadService;

    public AmCodeBankHeadResource(AmCodeBankHeadService amCodeBankHeadService) {
        this.amCodeBankHeadService = amCodeBankHeadService;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeBankHead API

    /**
     *
     */
    @GetMapping(value = "/am-code-bank-head", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AmCodeBankHead>> listAmCodeBankHead(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<AmCodeBankHead> amCodeBankHeadList = amCodeBankHeadService.listAmCodeBankHead(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(amCodeBankHeadList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/am-code-bank-head/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = amCodeBankHeadService.listAmCodeBankHeadCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/am-code-bank-head/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeBankHead> getEmptyAmCodeBankHead() {
        AmCodeBankHead amCodeBankHead = new AmCodeBankHead();
        return new ResponseEntity<>(amCodeBankHead, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/am-code-bank-head/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeBankHead> getAmCodeBankHead(@PathVariable("id") Long id) {
        AmCodeBankHead amCodeBankHead = amCodeBankHeadService.getAmCodeBankHead(id);
        return new ResponseEntity<>(amCodeBankHead, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/am-code-bank-head")
    public ResponseEntity<Void> addAmCodeBankHead(@RequestBody AmCodeBankHead amCodeBankHead) {
        amCodeBankHeadService.saveAmCodeBankHead(amCodeBankHead);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/am-code-bank-head/{id}")
    public ResponseEntity<Void> updateAmCodeBankHead(@PathVariable("id") Long id, @RequestBody AmCodeBankHead amCodeBankHead) throws Exception {
        if (!id.equals(amCodeBankHead.getId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        amCodeBankHeadService.saveAmCodeBankHead(amCodeBankHead);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/am-code-bank-head/{id}")
    public ResponseEntity<Void> removeAmCodeBankHead(@PathVariable("id") Long id) {
        amCodeBankHeadService.removeAmCodeBankHead(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

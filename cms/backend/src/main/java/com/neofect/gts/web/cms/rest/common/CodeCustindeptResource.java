/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.common;

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
import com.neofect.gts.core.services.common.domain.CodeCustindept;
import com.neofect.gts.core.services.common.service.CodeCustindeptService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link CodeCustindept}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class CodeCustindeptResource {

    private final CodeCustindeptService codeCustindeptService;

    public CodeCustindeptResource(CodeCustindeptService codeCustindeptService) {
        this.codeCustindeptService = codeCustindeptService;
    }

    //region ------------------------------------------------------------------------------------------------ codeCustindept API

    /**
     *
     */
    @GetMapping(value = "/code-custindept", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CodeCustindept>> listCodeCustindept(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<CodeCustindept> codeCustindeptList = codeCustindeptService.listCodeCustindept(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(codeCustindeptList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/code-custindept/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = codeCustindeptService.listCodeCustindeptCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/code-custindept/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CodeCustindept> getEmptyCodeCustindept() {
        CodeCustindept codeCustindept = new CodeCustindept();
        return new ResponseEntity<>(codeCustindept, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/code-custindept/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CodeCustindept> getCodeCustindept(@PathVariable("id") Long id) {
        CodeCustindept codeCustindept = codeCustindeptService.getCodeCustindept(id);
        return new ResponseEntity<>(codeCustindept, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/code-custindept")
    public ResponseEntity<Void> addCodeCustindept(@RequestBody CodeCustindept codeCustindept) {
        codeCustindeptService.saveCodeCustindept(codeCustindept);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/code-custindept/{id}")
    public ResponseEntity<Void> updateCodeCustindept(@PathVariable("id") Long id, @RequestBody CodeCustindept codeCustindept) throws Exception {
        if (!id.equals(codeCustindept.getId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        codeCustindeptService.saveCodeCustindept(codeCustindept);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/code-custindept/{id}")
    public ResponseEntity<Void> removeCodeCustindept(@PathVariable("id") Long id) {
        codeCustindeptService.removeCodeCustindept(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

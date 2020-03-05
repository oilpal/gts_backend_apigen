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
import com.neofect.gts.core.services.common.domain.CodeAccountParent;
import com.neofect.gts.core.services.common.service.CodeAccountParentService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link CodeAccountParent}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class CodeAccountParentResource {

    private final CodeAccountParentService codeAccountParentService;

    public CodeAccountParentResource(CodeAccountParentService codeAccountParentService) {
        this.codeAccountParentService = codeAccountParentService;
    }

    //region ------------------------------------------------------------------------------------------------ codeAccountParent API

    /**
     *
     */
    @GetMapping(value = "/code-account-parent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CodeAccountParent>> listCodeAccountParent(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<CodeAccountParent> codeAccountParentList = codeAccountParentService.listCodeAccountParent(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(codeAccountParentList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/code-account-parent/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = codeAccountParentService.listCodeAccountParentCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/code-account-parent/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CodeAccountParent> getEmptyCodeAccountParent() {
        CodeAccountParent codeAccountParent = new CodeAccountParent();
        return new ResponseEntity<>(codeAccountParent, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/code-account-parent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CodeAccountParent> getCodeAccountParent(@PathVariable("id") Long id) {
        CodeAccountParent codeAccountParent = codeAccountParentService.getCodeAccountParent(id);
        return new ResponseEntity<>(codeAccountParent, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/code-account-parent")
    public ResponseEntity<Void> addCodeAccountParent(@RequestBody CodeAccountParent codeAccountParent) {
        codeAccountParentService.saveCodeAccountParent(codeAccountParent);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/code-account-parent/{id}")
    public ResponseEntity<Void> updateCodeAccountParent(@PathVariable("id") Long id, @RequestBody CodeAccountParent codeAccountParent) throws Exception {
        if (!id.equals(codeAccountParent.getId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        codeAccountParentService.saveCodeAccountParent(codeAccountParent);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/code-account-parent/{id}")
    public ResponseEntity<Void> removeCodeAccountParent(@PathVariable("id") Long id) {
        codeAccountParentService.removeCodeAccountParent(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

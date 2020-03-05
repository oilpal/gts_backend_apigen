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
import com.neofect.gts.core.services.common.domain.CodeCard;
import com.neofect.gts.core.services.common.service.CodeCardService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link CodeCard}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class CodeCardResource {

    private final CodeCardService codeCardService;

    public CodeCardResource(CodeCardService codeCardService) {
        this.codeCardService = codeCardService;
    }

    //region ------------------------------------------------------------------------------------------------ codeCard API

    /**
     *
     */
    @GetMapping(value = "/code-card", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CodeCard>> listCodeCard(@RequestParam(value = "q", required = false) Map<String, Object> q) throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<CodeCard> codeCardList = codeCardService.listCodeCard(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(codeCardList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/code-card/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = codeCardService.listCodeCardCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/code-card/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CodeCard> getEmptyCodeCard() {
        CodeCard codeCard = new CodeCard();
        return new ResponseEntity<>(codeCard, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/code-card/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CodeCard> getCodeCard(@PathVariable("id") Long id) {
        CodeCard codeCard = codeCardService.getCodeCard(id);
        return new ResponseEntity<>(codeCard, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/code-card")
    public ResponseEntity<Void> addCodeCard(@RequestBody CodeCard codeCard) {
        codeCardService.saveCodeCard(codeCard);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/code-card/{id}")
    public ResponseEntity<Void> updateCodeCard(@PathVariable("id") Long id, @RequestBody CodeCard codeCard) throws Exception {
        if (!id.equals(codeCard.getId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        codeCardService.saveCodeCard(codeCard);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/code-card/{id}")
    public ResponseEntity<Void> removeCodeCard(@PathVariable("id") Long id) {
        codeCardService.removeCodeCard(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

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
import com.neofect.gts.core.services.am.domain.AmCodeValidation;
import com.neofect.gts.core.services.am.service.AmCodeValidationService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link AmCodeValidation}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class AmCodeValidationResource {

    private final AmCodeValidationService amCodeValidationService;

    public AmCodeValidationResource(AmCodeValidationService amCodeValidationService) {
        this.amCodeValidationService = amCodeValidationService;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeValidation API

    /**
     *
     */
    @GetMapping(value = "/am-code-validation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AmCodeValidation>> listAmCodeValidation(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<AmCodeValidation> amCodeValidationList = amCodeValidationService.listAmCodeValidation(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(amCodeValidationList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/am-code-validation/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = amCodeValidationService.listAmCodeValidationCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/am-code-validation/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeValidation> getEmptyAmCodeValidation() {
        AmCodeValidation amCodeValidation = new AmCodeValidation();
        return new ResponseEntity<>(amCodeValidation, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/am-code-validation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeValidation> getAmCodeValidation(@PathVariable("id") Long id) {
        AmCodeValidation amCodeValidation = amCodeValidationService.getAmCodeValidation(id);
        return new ResponseEntity<>(amCodeValidation, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/am-code-validation")
    public ResponseEntity<Void> addAmCodeValidation(@RequestBody AmCodeValidation amCodeValidation) {
        amCodeValidationService.saveAmCodeValidation(amCodeValidation);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/am-code-validation/{id}")
    public ResponseEntity<Void> updateAmCodeValidation(@PathVariable("id") Long id, @RequestBody AmCodeValidation amCodeValidation) throws Exception {
        // if (!id.equals(amCodeValidation.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        amCodeValidationService.saveAmCodeValidation(amCodeValidation);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/am-code-validation/{id}")
    public ResponseEntity<Void> removeAmCodeValidation(@PathVariable("id") Long id) {
        amCodeValidationService.removeAmCodeValidation(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

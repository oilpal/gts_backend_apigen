/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.slip;

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
import com.neofect.gts.core.services.slip.domain.SlipSimple;
import com.neofect.gts.core.services.slip.service.SlipSimpleService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link SlipSimple}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class SlipSimpleResource {

    private final SlipSimpleService slipSimpleService;

    public SlipSimpleResource(SlipSimpleService slipSimpleService) {
        this.slipSimpleService = slipSimpleService;
    }

    //region ------------------------------------------------------------------------------------------------ slipSimple API

    /**
     *
     */
    @GetMapping(value = "/slip-simple", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SlipSimple>> listSlipSimple(@RequestParam(value = "q", required = false) Map<String, Object> q) throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<SlipSimple> slipSimpleList = slipSimpleService.listSlipSimple(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(slipSimpleList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/slip-simple/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = slipSimpleService.listSlipSimpleCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/slip-simple/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SlipSimple> getEmptySlipSimple() {
        SlipSimple slipSimple = new SlipSimple();
        return new ResponseEntity<>(slipSimple, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/slip-simple/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SlipSimple> getSlipSimple(@PathVariable("id") Long id) {
        SlipSimple slipSimple = slipSimpleService.getSlipSimple(id);
        return new ResponseEntity<>(slipSimple, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/slip-simple")
    public ResponseEntity<Void> addSlipSimple(@RequestBody SlipSimple slipSimple) {
        slipSimpleService.saveSlipSimple(slipSimple);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/slip-simple/{id}")
    public ResponseEntity<Void> updateSlipSimple(@PathVariable("id") Long id, @RequestBody SlipSimple slipSimple) throws Exception {
        if (!id.equals(slipSimple.getId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        slipSimpleService.saveSlipSimple(slipSimple);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/slip-simple/{id}")
    public ResponseEntity<Void> removeSlipSimple(@PathVariable("id") Long id) {
        slipSimpleService.removeSlipSimple(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

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
import com.neofect.gts.core.services.am.domain.AmCodeSlipKind;
import com.neofect.gts.core.services.am.service.AmCodeSlipKindService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link AmCodeSlipKind}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class AmCodeSlipKindResource {

    private final AmCodeSlipKindService amCodeSlipKindService;

    public AmCodeSlipKindResource(AmCodeSlipKindService amCodeSlipKindService) {
        this.amCodeSlipKindService = amCodeSlipKindService;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeSlipKind API

    /**
     *
     */
    @GetMapping(value = "/am-code-slip-kind", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AmCodeSlipKind>> listAmCodeSlipKind(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<AmCodeSlipKind> amCodeSlipKindList = amCodeSlipKindService.listAmCodeSlipKind(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(amCodeSlipKindList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/am-code-slip-kind/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = amCodeSlipKindService.listAmCodeSlipKindCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/am-code-slip-kind/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeSlipKind> getEmptyAmCodeSlipKind() {
        AmCodeSlipKind amCodeSlipKind = new AmCodeSlipKind();
        return new ResponseEntity<>(amCodeSlipKind, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/am-code-slip-kind/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeSlipKind> getAmCodeSlipKind(@PathVariable("id") Long id) {
        AmCodeSlipKind amCodeSlipKind = amCodeSlipKindService.getAmCodeSlipKind(id);
        return new ResponseEntity<>(amCodeSlipKind, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/am-code-slip-kind")
    public ResponseEntity<Void> addAmCodeSlipKind(@RequestBody AmCodeSlipKind amCodeSlipKind) {
        amCodeSlipKindService.saveAmCodeSlipKind(amCodeSlipKind);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/am-code-slip-kind/{id}")
    public ResponseEntity<Void> updateAmCodeSlipKind(@PathVariable("id") Long id, @RequestBody AmCodeSlipKind amCodeSlipKind) throws Exception {
        if (!id.equals(amCodeSlipKind.getId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        amCodeSlipKindService.saveAmCodeSlipKind(amCodeSlipKind);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/am-code-slip-kind/{id}")
    public ResponseEntity<Void> removeAmCodeSlipKind(@PathVariable("id") Long id) {
        amCodeSlipKindService.removeAmCodeSlipKind(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

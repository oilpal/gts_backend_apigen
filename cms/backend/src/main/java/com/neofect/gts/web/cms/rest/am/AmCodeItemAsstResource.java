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
import com.neofect.gts.core.services.am.domain.AmCodeItemAsst;
import com.neofect.gts.core.services.am.service.AmCodeItemAsstService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link AmCodeItemAsst}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class AmCodeItemAsstResource {

    private final AmCodeItemAsstService amCodeItemAsstService;

    public AmCodeItemAsstResource(AmCodeItemAsstService amCodeItemAsstService) {
        this.amCodeItemAsstService = amCodeItemAsstService;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeItemAsst API

    /**
     *
     */
    @GetMapping(value = "/am-code-item-asst", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AmCodeItemAsst>> listAmCodeItemAsst(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<AmCodeItemAsst> amCodeItemAsstList = amCodeItemAsstService.listAmCodeItemAsst(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(amCodeItemAsstList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/am-code-item-asst/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = amCodeItemAsstService.listAmCodeItemAsstCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/am-code-item-asst/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeItemAsst> getEmptyAmCodeItemAsst() {
        AmCodeItemAsst amCodeItemAsst = new AmCodeItemAsst();
        return new ResponseEntity<>(amCodeItemAsst, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/am-code-item-asst/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AmCodeItemAsst> getAmCodeItemAsst(@PathVariable("id") Long id) {
        AmCodeItemAsst amCodeItemAsst = amCodeItemAsstService.getAmCodeItemAsst(id);
        return new ResponseEntity<>(amCodeItemAsst, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/am-code-item-asst")
    public ResponseEntity<Void> addAmCodeItemAsst(@RequestBody AmCodeItemAsst amCodeItemAsst) {
        amCodeItemAsstService.saveAmCodeItemAsst(amCodeItemAsst);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/am-code-item-asst/{id}")
    public ResponseEntity<Void> updateAmCodeItemAsst(@PathVariable("id") Long id, @RequestBody AmCodeItemAsst amCodeItemAsst) throws Exception {
        // if (!id.equals(amCodeItemAsst.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        amCodeItemAsstService.saveAmCodeItemAsst(amCodeItemAsst);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/am-code-item-asst/{id}")
    public ResponseEntity<Void> removeAmCodeItemAsst(@PathVariable("id") Long id) {
        amCodeItemAsstService.removeAmCodeItemAsst(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

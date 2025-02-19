/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.xm;

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
import com.neofect.gts.core.services.xm.domain.XmExcelData;
import com.neofect.gts.core.services.xm.service.XmExcelDataService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link XmExcelData}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class XmExcelDataResource {

    private final XmExcelDataService xmExcelDataService;

    public XmExcelDataResource(XmExcelDataService xmExcelDataService) {
        this.xmExcelDataService = xmExcelDataService;
    }

    //region ------------------------------------------------------------------------------------------------ xmExcelData API

    /**
     *
     */
    @GetMapping(value = "/xm-excel-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<XmExcelData>> listXmExcelData(@RequestParam(value = "q", required = false) Map<String, Object> q) throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<XmExcelData> xmExcelDataList = xmExcelDataService.listXmExcelData(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(xmExcelDataList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/xm-excel-data/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = xmExcelDataService.listXmExcelDataCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/xm-excel-data/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<XmExcelData> getEmptyXmExcelData() {
        XmExcelData xmExcelData = new XmExcelData();
        return new ResponseEntity<>(xmExcelData, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/xm-excel-data/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<XmExcelData> getXmExcelData(@PathVariable("id") Long id) {
        XmExcelData xmExcelData = xmExcelDataService.getXmExcelData(id);
        return new ResponseEntity<>(xmExcelData, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/xm-excel-data")
    public ResponseEntity<Void> addXmExcelData(@RequestBody XmExcelData xmExcelData) {
        xmExcelDataService.saveXmExcelData(xmExcelData);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/xm-excel-data/{id}")
    public ResponseEntity<Void> updateXmExcelData(@PathVariable("id") Long id, @RequestBody XmExcelData xmExcelData) throws Exception {
        // if (!id.equals(xmExcelData.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        xmExcelDataService.saveXmExcelData(xmExcelData);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/xm-excel-data/{id}")
    public ResponseEntity<Void> removeXmExcelData(@PathVariable("id") Long id) {
        xmExcelDataService.removeXmExcelData(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

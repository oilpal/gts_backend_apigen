/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.rent;

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
import com.neofect.gts.core.services.rent.domain.RentReqMain;
import com.neofect.gts.core.services.rent.service.RentReqMainService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link RentReqMain}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class RentReqMainResource {

    private final RentReqMainService rentReqMainService;

    public RentReqMainResource(RentReqMainService rentReqMainService) {
        this.rentReqMainService = rentReqMainService;
    }

    //region ------------------------------------------------------------------------------------------------ rentReqMain API

    /**
     *
     */
    @GetMapping(value = "/rent-req-main", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RentReqMain>> listRentReqMain(@RequestParam(value = "q", required = false) Map<String, Object> q) throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<RentReqMain> rentReqMainList = rentReqMainService.listRentReqMain(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(rentReqMainList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/rent-req-main/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = rentReqMainService.listRentReqMainCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/rent-req-main/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentReqMain> getEmptyRentReqMain() {
        RentReqMain rentReqMain = new RentReqMain();
        return new ResponseEntity<>(rentReqMain, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/rent-req-main/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentReqMain> getRentReqMain(@PathVariable("id") Long id) {
        RentReqMain rentReqMain = rentReqMainService.getRentReqMain(id);
        return new ResponseEntity<>(rentReqMain, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/rent-req-main")
    public ResponseEntity<Void> addRentReqMain(@RequestBody RentReqMain rentReqMain) {
        rentReqMainService.saveRentReqMain(rentReqMain);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/rent-req-main/{id}")
    public ResponseEntity<Void> updateRentReqMain(@PathVariable("id") Long id, @RequestBody RentReqMain rentReqMain) throws Exception {
        // if (!id.equals(rentReqMain.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        rentReqMainService.saveRentReqMain(rentReqMain);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/rent-req-main/{id}")
    public ResponseEntity<Void> removeRentReqMain(@PathVariable("id") Long id) {
        rentReqMainService.removeRentReqMain(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

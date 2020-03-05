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
import com.neofect.gts.core.services.rent.domain.RentContract;
import com.neofect.gts.core.services.rent.service.RentContractService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link RentContract}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class RentContractResource {

    private final RentContractService rentContractService;

    public RentContractResource(RentContractService rentContractService) {
        this.rentContractService = rentContractService;
    }

    //region ------------------------------------------------------------------------------------------------ rentContract API

    /**
     *
     */
    @GetMapping(value = "/rent-contract", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RentContract>> listRentContract(@RequestParam(value = "q", required = false) Map<String, Object> q) throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<RentContract> rentContractList = rentContractService.listRentContract(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(rentContractList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/rent-contract/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = rentContractService.listRentContractCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/rent-contract/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentContract> getEmptyRentContract() {
        RentContract rentContract = new RentContract();
        return new ResponseEntity<>(rentContract, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/rent-contract/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentContract> getRentContract(@PathVariable("id") Long id) {
        RentContract rentContract = rentContractService.getRentContract(id);
        return new ResponseEntity<>(rentContract, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/rent-contract")
    public ResponseEntity<Void> addRentContract(@RequestBody RentContract rentContract) {
        rentContractService.saveRentContract(rentContract);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/rent-contract/{id}")
    public ResponseEntity<Void> updateRentContract(@PathVariable("id") Long id, @RequestBody RentContract rentContract) throws Exception {
        // if (!id.equals(rentContract.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        rentContractService.saveRentContract(rentContract);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/rent-contract/{id}")
    public ResponseEntity<Void> removeRentContract(@PathVariable("id") Long id) {
        rentContractService.removeRentContract(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

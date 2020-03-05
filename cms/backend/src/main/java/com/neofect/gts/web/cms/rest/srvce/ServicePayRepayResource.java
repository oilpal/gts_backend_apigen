/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.srvce;

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
import com.neofect.gts.core.services.srvce.domain.ServicePayRepay;
import com.neofect.gts.core.services.srvce.service.ServicePayRepayService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link ServicePayRepay}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ServicePayRepayResource {

    private final ServicePayRepayService servicePayRepayService;

    public ServicePayRepayResource(ServicePayRepayService servicePayRepayService) {
        this.servicePayRepayService = servicePayRepayService;
    }

    //region ------------------------------------------------------------------------------------------------ servicePayRepay API

    /**
     *
     */
    @GetMapping(value = "/service-pay-repay", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServicePayRepay>> listServicePayRepay(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<ServicePayRepay> servicePayRepayList = servicePayRepayService.listServicePayRepay(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(servicePayRepayList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/service-pay-repay/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = servicePayRepayService.listServicePayRepayCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/service-pay-repay/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServicePayRepay> getEmptyServicePayRepay() {
        ServicePayRepay servicePayRepay = new ServicePayRepay();
        return new ResponseEntity<>(servicePayRepay, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/service-pay-repay/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServicePayRepay> getServicePayRepay(@PathVariable("id") Long id) {
        ServicePayRepay servicePayRepay = servicePayRepayService.getServicePayRepay(id);
        return new ResponseEntity<>(servicePayRepay, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/service-pay-repay")
    public ResponseEntity<Void> addServicePayRepay(@RequestBody ServicePayRepay servicePayRepay) {
        servicePayRepayService.saveServicePayRepay(servicePayRepay);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/service-pay-repay/{id}")
    public ResponseEntity<Void> updateServicePayRepay(@PathVariable("id") Long id, @RequestBody ServicePayRepay servicePayRepay) throws Exception {
        // if (!id.equals(servicePayRepay.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        servicePayRepayService.saveServicePayRepay(servicePayRepay);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/service-pay-repay/{id}")
    public ResponseEntity<Void> removeServicePayRepay(@PathVariable("id") Long id) {
        servicePayRepayService.removeServicePayRepay(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

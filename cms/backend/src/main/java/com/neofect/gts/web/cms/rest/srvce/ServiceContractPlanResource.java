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
import com.neofect.gts.core.services.srvce.domain.ServiceContractPlan;
import com.neofect.gts.core.services.srvce.service.ServiceContractPlanService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link ServiceContractPlan}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ServiceContractPlanResource {

    private final ServiceContractPlanService serviceContractPlanService;

    public ServiceContractPlanResource(ServiceContractPlanService serviceContractPlanService) {
        this.serviceContractPlanService = serviceContractPlanService;
    }

    //region ------------------------------------------------------------------------------------------------ serviceContractPlan API

    /**
     *
     */
    @GetMapping(value = "/service-contract-plan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceContractPlan>> listServiceContractPlan(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<ServiceContractPlan> serviceContractPlanList = serviceContractPlanService.listServiceContractPlan(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(serviceContractPlanList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/service-contract-plan/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = serviceContractPlanService.listServiceContractPlanCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/service-contract-plan/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceContractPlan> getEmptyServiceContractPlan() {
        ServiceContractPlan serviceContractPlan = new ServiceContractPlan();
        return new ResponseEntity<>(serviceContractPlan, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/service-contract-plan/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceContractPlan> getServiceContractPlan(@PathVariable("id") Long id) {
        ServiceContractPlan serviceContractPlan = serviceContractPlanService.getServiceContractPlan(id);
        return new ResponseEntity<>(serviceContractPlan, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/service-contract-plan")
    public ResponseEntity<Void> addServiceContractPlan(@RequestBody ServiceContractPlan serviceContractPlan) {
        serviceContractPlanService.saveServiceContractPlan(serviceContractPlan);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/service-contract-plan/{id}")
    public ResponseEntity<Void> updateServiceContractPlan(@PathVariable("id") Long id, @RequestBody ServiceContractPlan serviceContractPlan) throws Exception {
        // if (!id.equals(serviceContractPlan.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        serviceContractPlanService.saveServiceContractPlan(serviceContractPlan);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/service-contract-plan/{id}")
    public ResponseEntity<Void> removeServiceContractPlan(@PathVariable("id") Long id) {
        serviceContractPlanService.removeServiceContractPlan(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

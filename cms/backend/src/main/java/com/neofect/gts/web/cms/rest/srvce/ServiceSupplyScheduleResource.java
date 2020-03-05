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
import com.neofect.gts.core.services.srvce.domain.ServiceSupplySchedule;
import com.neofect.gts.core.services.srvce.service.ServiceSupplyScheduleService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link ServiceSupplySchedule}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ServiceSupplyScheduleResource {

    private final ServiceSupplyScheduleService serviceSupplyScheduleService;

    public ServiceSupplyScheduleResource(ServiceSupplyScheduleService serviceSupplyScheduleService) {
        this.serviceSupplyScheduleService = serviceSupplyScheduleService;
    }

    //region ------------------------------------------------------------------------------------------------ serviceSupplySchedule API

    /**
     *
     */
    @GetMapping(value = "/service-supply-schedule", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceSupplySchedule>> listServiceSupplySchedule(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<ServiceSupplySchedule> serviceSupplyScheduleList = serviceSupplyScheduleService.listServiceSupplySchedule(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(serviceSupplyScheduleList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/service-supply-schedule/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = serviceSupplyScheduleService.listServiceSupplyScheduleCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/service-supply-schedule/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceSupplySchedule> getEmptyServiceSupplySchedule() {
        ServiceSupplySchedule serviceSupplySchedule = new ServiceSupplySchedule();
        return new ResponseEntity<>(serviceSupplySchedule, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/service-supply-schedule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceSupplySchedule> getServiceSupplySchedule(@PathVariable("id") Long id) {
        ServiceSupplySchedule serviceSupplySchedule = serviceSupplyScheduleService.getServiceSupplySchedule(id);
        return new ResponseEntity<>(serviceSupplySchedule, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/service-supply-schedule")
    public ResponseEntity<Void> addServiceSupplySchedule(@RequestBody ServiceSupplySchedule serviceSupplySchedule) {
        serviceSupplyScheduleService.saveServiceSupplySchedule(serviceSupplySchedule);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/service-supply-schedule/{id}")
    public ResponseEntity<Void> updateServiceSupplySchedule(@PathVariable("id") Long id, @RequestBody ServiceSupplySchedule serviceSupplySchedule)
            throws Exception {
        // if (!id.equals(serviceSupplySchedule.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        serviceSupplyScheduleService.saveServiceSupplySchedule(serviceSupplySchedule);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/service-supply-schedule/{id}")
    public ResponseEntity<Void> removeServiceSupplySchedule(@PathVariable("id") Long id) {
        serviceSupplyScheduleService.removeServiceSupplySchedule(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

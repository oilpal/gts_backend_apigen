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
import com.neofect.gts.core.services.srvce.domain.ServiceSummarySumTot;
import com.neofect.gts.core.services.srvce.service.ServiceSummarySumTotService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link ServiceSummarySumTot}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ServiceSummarySumTotResource {

    private final ServiceSummarySumTotService serviceSummarySumTotService;

    public ServiceSummarySumTotResource(ServiceSummarySumTotService serviceSummarySumTotService) {
        this.serviceSummarySumTotService = serviceSummarySumTotService;
    }

    //region ------------------------------------------------------------------------------------------------ serviceSummarySumTot API

    /**
     *
     */
    @GetMapping(value = "/service-summary-sum-tot", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceSummarySumTot>> listServiceSummarySumTot(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<ServiceSummarySumTot> serviceSummarySumTotList = serviceSummarySumTotService.listServiceSummarySumTot(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(serviceSummarySumTotList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/service-summary-sum-tot/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = serviceSummarySumTotService.listServiceSummarySumTotCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/service-summary-sum-tot/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceSummarySumTot> getEmptyServiceSummarySumTot() {
        ServiceSummarySumTot serviceSummarySumTot = new ServiceSummarySumTot();
        return new ResponseEntity<>(serviceSummarySumTot, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/service-summary-sum-tot/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceSummarySumTot> getServiceSummarySumTot(@PathVariable("id") Long id) {
        ServiceSummarySumTot serviceSummarySumTot = serviceSummarySumTotService.getServiceSummarySumTot(id);
        return new ResponseEntity<>(serviceSummarySumTot, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/service-summary-sum-tot")
    public ResponseEntity<Void> addServiceSummarySumTot(@RequestBody ServiceSummarySumTot serviceSummarySumTot) {
        serviceSummarySumTotService.saveServiceSummarySumTot(serviceSummarySumTot);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/service-summary-sum-tot/{id}")
    public ResponseEntity<Void> updateServiceSummarySumTot(@PathVariable("id") Long id, @RequestBody ServiceSummarySumTot serviceSummarySumTot)
            throws Exception {
        // if (!id.equals(serviceSummarySumTot.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        serviceSummarySumTotService.saveServiceSummarySumTot(serviceSummarySumTot);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/service-summary-sum-tot/{id}")
    public ResponseEntity<Void> removeServiceSummarySumTot(@PathVariable("id") Long id) {
        serviceSummarySumTotService.removeServiceSummarySumTot(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.form;

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
import com.neofect.gts.core.services.form.domain.FormContractPlan;
import com.neofect.gts.core.services.form.service.FormContractPlanService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link FormContractPlan}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class FormContractPlanResource {

    private final FormContractPlanService formContractPlanService;

    public FormContractPlanResource(FormContractPlanService formContractPlanService) {
        this.formContractPlanService = formContractPlanService;
    }

    //region ------------------------------------------------------------------------------------------------ formContractPlan API

    /**
     *
     */
    @GetMapping(value = "/form-contract-plan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FormContractPlan>> listFormContractPlan(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<FormContractPlan> formContractPlanList = formContractPlanService.listFormContractPlan(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(formContractPlanList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/form-contract-plan/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = formContractPlanService.listFormContractPlanCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/form-contract-plan/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormContractPlan> getEmptyFormContractPlan() {
        FormContractPlan formContractPlan = new FormContractPlan();
        return new ResponseEntity<>(formContractPlan, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/form-contract-plan/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormContractPlan> getFormContractPlan(@PathVariable("id") Long id) {
        FormContractPlan formContractPlan = formContractPlanService.getFormContractPlan(id);
        return new ResponseEntity<>(formContractPlan, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/form-contract-plan")
    public ResponseEntity<Void> addFormContractPlan(@RequestBody FormContractPlan formContractPlan) {
        formContractPlanService.saveFormContractPlan(formContractPlan);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/form-contract-plan/{id}")
    public ResponseEntity<Void> updateFormContractPlan(@PathVariable("id") Long id, @RequestBody FormContractPlan formContractPlan) throws Exception {
        // if (!id.equals(formContractPlan.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        formContractPlanService.saveFormContractPlan(formContractPlan);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/form-contract-plan/{id}")
    public ResponseEntity<Void> removeFormContractPlan(@PathVariable("id") Long id) {
        formContractPlanService.removeFormContractPlan(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

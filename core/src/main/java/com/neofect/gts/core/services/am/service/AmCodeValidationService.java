/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/service/Service.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.am.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neofect.gts.core.services.am.domain.AmCodeValidation;
import com.neofect.gts.core.services.am.repository.AmCodeValidationRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;

/**
 * Service for {@link AmCodeValidation}<br/>
 */
@Service
public class AmCodeValidationService {

    private final AmCodeValidationRepository amCodeValidationRepository;

    public AmCodeValidationService(AmCodeValidationRepository amCodeValidationRepository) {
        this.amCodeValidationRepository = amCodeValidationRepository;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeValidation CRUD

    @Transactional
    public AmCodeValidation saveAmCodeValidation(AmCodeValidation amCodeValidation) {
        // if (amCodeValidation.getId() == null) {
        //     addAmCodeValidation(amCodeValidation);
        // } else {
        //     modifyAmCodeValidation(amCodeValidation);
        // }

        return amCodeValidation;
    }

    private int addAmCodeValidation(AmCodeValidation amCodeValidation) {
        int result = amCodeValidationRepository.insertAmCodeValidation(amCodeValidation);
        return result;
    }

    private int modifyAmCodeValidation(AmCodeValidation amCodeValidation) {
        int result = amCodeValidationRepository.updateAmCodeValidation(amCodeValidation);
        return result;
    }

    @Transactional
    public int removeAmCodeValidation(Long id) {
        int rows = amCodeValidationRepository.deleteAmCodeValidation(id);
        return rows;
    }

    public AmCodeValidation getAmCodeValidation(Long id) {
        AmCodeValidation amCodeValidation = amCodeValidationRepository.getAmCodeValidation(id);

        return amCodeValidation;
    }

    public int listAmCodeValidationCnt(Map<String, Object> params) {
        int rows = amCodeValidationRepository.listAmCodeValidationCnt(params);
        return rows;
    }

    public List<AmCodeValidation> listAmCodeValidation(Map<String, Object> params) {
        List<AmCodeValidation> lists = amCodeValidationRepository.listAmCodeValidation(params);

        return lists;
    }

    public List<AmCodeValidation> listAmCodeValidationByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("VALIDATION_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("VALID_VALUE_CODE", ids));
        List<AmCodeValidation> lists = amCodeValidationRepository.listAmCodeValidation(params);

        return lists;
    }

    //endregion

}

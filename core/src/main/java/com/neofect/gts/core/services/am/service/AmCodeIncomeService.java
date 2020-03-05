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

import com.neofect.gts.core.services.am.domain.AmCodeIncome;
import com.neofect.gts.core.services.am.repository.AmCodeIncomeRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;

/**
 * Service for {@link AmCodeIncome}<br/>
 */
@Service
public class AmCodeIncomeService {

    private final AmCodeIncomeRepository amCodeIncomeRepository;

    public AmCodeIncomeService(AmCodeIncomeRepository amCodeIncomeRepository) {
        this.amCodeIncomeRepository = amCodeIncomeRepository;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeIncome CRUD

    @Transactional
    public AmCodeIncome saveAmCodeIncome(AmCodeIncome amCodeIncome) {
        if (amCodeIncome.getId() == null) {
            addAmCodeIncome(amCodeIncome);
        } else {
            modifyAmCodeIncome(amCodeIncome);
        }

        return amCodeIncome;
    }

    private int addAmCodeIncome(AmCodeIncome amCodeIncome) {
        int result = amCodeIncomeRepository.insertAmCodeIncome(amCodeIncome);
        return result;
    }

    private int modifyAmCodeIncome(AmCodeIncome amCodeIncome) {
        int result = amCodeIncomeRepository.updateAmCodeIncome(amCodeIncome);
        return result;
    }

    @Transactional
    public int removeAmCodeIncome(Long id) {
        int rows = amCodeIncomeRepository.deleteAmCodeIncome(id);
        return rows;
    }

    public AmCodeIncome getAmCodeIncome(Long id) {
        AmCodeIncome amCodeIncome = amCodeIncomeRepository.getAmCodeIncome(id);

        return amCodeIncome;
    }

    public int listAmCodeIncomeCnt(Map<String, Object> params) {
        int rows = amCodeIncomeRepository.listAmCodeIncomeCnt(params);
        return rows;
    }

    public List<AmCodeIncome> listAmCodeIncome(Map<String, Object> params) {
        List<AmCodeIncome> lists = amCodeIncomeRepository.listAmCodeIncome(params);

        return lists;
    }

    public List<AmCodeIncome> listAmCodeIncomeByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("INCOME_CODE", ids));
        List<AmCodeIncome> lists = amCodeIncomeRepository.listAmCodeIncome(params);

        return lists;
    }

    //endregion

}

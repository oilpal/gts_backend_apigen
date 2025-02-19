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

import com.neofect.gts.core.services.am.domain.AmCalcList;
import com.neofect.gts.core.services.am.repository.AmCalcListRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link AmCalcList}<br/>
 */
@Service
public class AmCalcListService {

    private final AmCalcListRepository amCalcListRepository;

    public AmCalcListService(AmCalcListRepository amCalcListRepository) {
        this.amCalcListRepository = amCalcListRepository;
    }

    //region ------------------------------------------------------------------------------------------------ amCalcList CRUD

    @Transactional
    public AmCalcList saveAmCalcList(AmCalcList amCalcList) {
        // if (amCalcList.getId() == null) {
        //     addAmCalcList(amCalcList);
        // } else {
        //     modifyAmCalcList(amCalcList);
        // }

        return amCalcList;
    }

    private int addAmCalcList(AmCalcList amCalcList) {
        int result = amCalcListRepository.insertAmCalcList(amCalcList);
        return result;
    }

    private int modifyAmCalcList(AmCalcList amCalcList) {
        int result = amCalcListRepository.updateAmCalcList(amCalcList);
        return result;
    }

    @Transactional
    public int removeAmCalcList(Long id) {
        int rows = amCalcListRepository.deleteAmCalcList(id);
        return rows;
    }

    public AmCalcList getAmCalcList(Long id) {
        AmCalcList amCalcList = amCalcListRepository.getAmCalcList(id);

        return amCalcList;
    }

    public int listAmCalcListCnt(Map<String, Object> params) {
        int rows = amCalcListRepository.listAmCalcListCnt(params);
        return rows;
    }

    public List<AmCalcList> listAmCalcList(Map<String, Object> params) {
        List<AmCalcList> lists = amCalcListRepository.listAmCalcList(params);

        return lists;
    }

    public List<AmCalcList> listAmCalcListByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("COMPANY_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("CALC_KIND_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("CALC_LIST_CODE", ids));
        List<AmCalcList> lists = amCalcListRepository.listAmCalcList(params);

        return lists;
    }

    //endregion

}

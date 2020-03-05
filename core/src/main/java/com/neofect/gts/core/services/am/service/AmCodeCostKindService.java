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

import com.neofect.gts.core.services.am.domain.AmCodeCostKind;
import com.neofect.gts.core.services.am.repository.AmCodeCostKindRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;

/**
 * Service for {@link AmCodeCostKind}<br/>
 */
@Service
public class AmCodeCostKindService {

    private final AmCodeCostKindRepository amCodeCostKindRepository;

    public AmCodeCostKindService(AmCodeCostKindRepository amCodeCostKindRepository) {
        this.amCodeCostKindRepository = amCodeCostKindRepository;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeCostKind CRUD

    @Transactional
    public AmCodeCostKind saveAmCodeCostKind(AmCodeCostKind amCodeCostKind) {
        // if (amCodeCostKind.getId() == null) {
        //     addAmCodeCostKind(amCodeCostKind);
        // } else {
        //     modifyAmCodeCostKind(amCodeCostKind);
        // }

        return amCodeCostKind;
    }

    private int addAmCodeCostKind(AmCodeCostKind amCodeCostKind) {
        int result = amCodeCostKindRepository.insertAmCodeCostKind(amCodeCostKind);
        return result;
    }

    private int modifyAmCodeCostKind(AmCodeCostKind amCodeCostKind) {
        int result = amCodeCostKindRepository.updateAmCodeCostKind(amCodeCostKind);
        return result;
    }

    @Transactional
    public int removeAmCodeCostKind(Long id) {
        int rows = amCodeCostKindRepository.deleteAmCodeCostKind(id);
        return rows;
    }

    public AmCodeCostKind getAmCodeCostKind(Long id) {
        AmCodeCostKind amCodeCostKind = amCodeCostKindRepository.getAmCodeCostKind(id);

        return amCodeCostKind;
    }

    public int listAmCodeCostKindCnt(Map<String, Object> params) {
        int rows = amCodeCostKindRepository.listAmCodeCostKindCnt(params);
        return rows;
    }

    public List<AmCodeCostKind> listAmCodeCostKind(Map<String, Object> params) {
        List<AmCodeCostKind> lists = amCodeCostKindRepository.listAmCodeCostKind(params);

        return lists;
    }

    public List<AmCodeCostKind> listAmCodeCostKindByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("COMPANY_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("COST_KIND_CODE", ids));
        List<AmCodeCostKind> lists = amCodeCostKindRepository.listAmCodeCostKind(params);

        return lists;
    }

    //endregion

}

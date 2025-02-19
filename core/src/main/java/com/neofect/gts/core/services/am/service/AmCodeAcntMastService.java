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

import com.neofect.gts.core.services.am.domain.AmCodeAcntMast;
import com.neofect.gts.core.services.am.repository.AmCodeAcntMastRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link AmCodeAcntMast}<br/>
 */
@Service
public class AmCodeAcntMastService {

    private final AmCodeAcntMastRepository amCodeAcntMastRepository;

    public AmCodeAcntMastService(AmCodeAcntMastRepository amCodeAcntMastRepository) {
        this.amCodeAcntMastRepository = amCodeAcntMastRepository;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeAcntMast CRUD

    @Transactional
    public AmCodeAcntMast saveAmCodeAcntMast(AmCodeAcntMast amCodeAcntMast) {
        if (amCodeAcntMast.getId() == null) {
            addAmCodeAcntMast(amCodeAcntMast);
        } else {
            modifyAmCodeAcntMast(amCodeAcntMast);
        }

        return amCodeAcntMast;
    }

    private int addAmCodeAcntMast(AmCodeAcntMast amCodeAcntMast) {
        int result = amCodeAcntMastRepository.insertAmCodeAcntMast(amCodeAcntMast);
        return result;
    }

    private int modifyAmCodeAcntMast(AmCodeAcntMast amCodeAcntMast) {
        int result = amCodeAcntMastRepository.updateAmCodeAcntMast(amCodeAcntMast);
        return result;
    }

    @Transactional
    public int removeAmCodeAcntMast(Long id) {
        int rows = amCodeAcntMastRepository.deleteAmCodeAcntMast(id);
        return rows;
    }

    public AmCodeAcntMast getAmCodeAcntMast(Long id) {
        AmCodeAcntMast amCodeAcntMast = amCodeAcntMastRepository.getAmCodeAcntMast(id);

        return amCodeAcntMast;
    }

    public int listAmCodeAcntMastCnt(Map<String, Object> params) {
        int rows = amCodeAcntMastRepository.listAmCodeAcntMastCnt(params);
        return rows;
    }

    public List<AmCodeAcntMast> listAmCodeAcntMast(Map<String, Object> params) {
        List<AmCodeAcntMast> lists = amCodeAcntMastRepository.listAmCodeAcntMast(params);

        return lists;
    }

    public List<AmCodeAcntMast> listAmCodeAcntMastByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("ACNT_CODE", ids));
        List<AmCodeAcntMast> lists = amCodeAcntMastRepository.listAmCodeAcntMast(params);

        return lists;
    }

    //endregion

}

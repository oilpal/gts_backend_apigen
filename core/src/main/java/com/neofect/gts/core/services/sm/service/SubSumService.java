/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/service/Service.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.sm.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neofect.gts.core.services.sm.domain.SubSum;
import com.neofect.gts.core.services.sm.repository.SubSumRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link SubSum}<br/>
 */
@Service
public class SubSumService {

    private final SubSumRepository subSumRepository;

    public SubSumService(SubSumRepository subSumRepository) {
        this.subSumRepository = subSumRepository;
    }

    //region ------------------------------------------------------------------------------------------------ subSum CRUD

    @Transactional
    public SubSum saveSubSum(SubSum subSum) {
        if (subSum.getId() == null) {
            addSubSum(subSum);
        } else {
            modifySubSum(subSum);
        }

        return subSum;
    }

    private int addSubSum(SubSum subSum) {
        int result = subSumRepository.insertSubSum(subSum);
        return result;
    }

    private int modifySubSum(SubSum subSum) {
        int result = subSumRepository.updateSubSum(subSum);
        return result;
    }

    @Transactional
    public int removeSubSum(Long id) {
        int rows = subSumRepository.deleteSubSum(id);
        return rows;
    }

    public SubSum getSubSum(Long id) {
        SubSum subSum = subSumRepository.getSubSum(id);

        return subSum;
    }

    public int listSubSumCnt(Map<String, Object> params) {
        int rows = subSumRepository.listSubSumCnt(params);
        return rows;
    }

    public List<SubSum> listSubSum(Map<String, Object> params) {
        List<SubSum> lists = subSumRepository.listSubSum(params);

        return lists;
    }

    public List<SubSum> listSubSumByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("NO1", ids));
        List<SubSum> lists = subSumRepository.listSubSum(params);

        return lists;
    }

    //endregion

}

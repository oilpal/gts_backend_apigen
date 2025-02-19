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

import com.neofect.gts.core.services.sm.domain.SmAuthGroup;
import com.neofect.gts.core.services.sm.repository.SmAuthGroupRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link SmAuthGroup}<br/>
 */
@Service
public class SmAuthGroupService {

    private final SmAuthGroupRepository smAuthGroupRepository;

    public SmAuthGroupService(SmAuthGroupRepository smAuthGroupRepository) {
        this.smAuthGroupRepository = smAuthGroupRepository;
    }

    //region ------------------------------------------------------------------------------------------------ smAuthGroup CRUD

    @Transactional
    public SmAuthGroup saveSmAuthGroup(SmAuthGroup smAuthGroup) {
        // if (smAuthGroup.getId() == null) {
        //     addSmAuthGroup(smAuthGroup);
        // } else {
        //     modifySmAuthGroup(smAuthGroup);
        // }

        return smAuthGroup;
    }

    private int addSmAuthGroup(SmAuthGroup smAuthGroup) {
        int result = smAuthGroupRepository.insertSmAuthGroup(smAuthGroup);
        return result;
    }

    private int modifySmAuthGroup(SmAuthGroup smAuthGroup) {
        int result = smAuthGroupRepository.updateSmAuthGroup(smAuthGroup);
        return result;
    }

    @Transactional
    public int removeSmAuthGroup(Long id) {
        int rows = smAuthGroupRepository.deleteSmAuthGroup(id);
        return rows;
    }

    public SmAuthGroup getSmAuthGroup(Long id) {
        SmAuthGroup smAuthGroup = smAuthGroupRepository.getSmAuthGroup(id);

        return smAuthGroup;
    }

    public int listSmAuthGroupCnt(Map<String, Object> params) {
        int rows = smAuthGroupRepository.listSmAuthGroupCnt(params);
        return rows;
    }

    public List<SmAuthGroup> listSmAuthGroup(Map<String, Object> params) {
        List<SmAuthGroup> lists = smAuthGroupRepository.listSmAuthGroup(params);

        return lists;
    }

    public List<SmAuthGroup> listSmAuthGroupByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("COMPANY_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("USER_GROUP_CODE", ids));
        List<SmAuthGroup> lists = smAuthGroupRepository.listSmAuthGroup(params);

        return lists;
    }

    //endregion

}

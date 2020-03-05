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

import com.neofect.gts.core.services.sm.domain.SmAuthUserMenuRecent;
import com.neofect.gts.core.services.sm.repository.SmAuthUserMenuRecentRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link SmAuthUserMenuRecent}<br/>
 */
@Service
public class SmAuthUserMenuRecentService {

    private final SmAuthUserMenuRecentRepository smAuthUserMenuRecentRepository;

    public SmAuthUserMenuRecentService(SmAuthUserMenuRecentRepository smAuthUserMenuRecentRepository) {
        this.smAuthUserMenuRecentRepository = smAuthUserMenuRecentRepository;
    }

    //region ------------------------------------------------------------------------------------------------ smAuthUserMenuRecent CRUD

    @Transactional
    public SmAuthUserMenuRecent saveSmAuthUserMenuRecent(SmAuthUserMenuRecent smAuthUserMenuRecent) {
        // if (smAuthUserMenuRecent.getId() == null) {
        //     addSmAuthUserMenuRecent(smAuthUserMenuRecent);
        // } else {
        //     modifySmAuthUserMenuRecent(smAuthUserMenuRecent);
        // }

        return smAuthUserMenuRecent;
    }

    private int addSmAuthUserMenuRecent(SmAuthUserMenuRecent smAuthUserMenuRecent) {
        int result = smAuthUserMenuRecentRepository.insertSmAuthUserMenuRecent(smAuthUserMenuRecent);
        return result;
    }

    private int modifySmAuthUserMenuRecent(SmAuthUserMenuRecent smAuthUserMenuRecent) {
        int result = smAuthUserMenuRecentRepository.updateSmAuthUserMenuRecent(smAuthUserMenuRecent);
        return result;
    }

    @Transactional
    public int removeSmAuthUserMenuRecent(Long id) {
        int rows = smAuthUserMenuRecentRepository.deleteSmAuthUserMenuRecent(id);
        return rows;
    }

    public SmAuthUserMenuRecent getSmAuthUserMenuRecent(Long id) {
        SmAuthUserMenuRecent smAuthUserMenuRecent = smAuthUserMenuRecentRepository.getSmAuthUserMenuRecent(id);

        return smAuthUserMenuRecent;
    }

    public int listSmAuthUserMenuRecentCnt(Map<String, Object> params) {
        int rows = smAuthUserMenuRecentRepository.listSmAuthUserMenuRecentCnt(params);
        return rows;
    }

    public List<SmAuthUserMenuRecent> listSmAuthUserMenuRecent(Map<String, Object> params) {
        List<SmAuthUserMenuRecent> lists = smAuthUserMenuRecentRepository.listSmAuthUserMenuRecent(params);

        return lists;
    }

    public List<SmAuthUserMenuRecent> listSmAuthUserMenuRecentByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("COMPANY_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("USER_ID", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("MENU_SEQ", ids));
        List<SmAuthUserMenuRecent> lists = smAuthUserMenuRecentRepository.listSmAuthUserMenuRecent(params);

        return lists;
    }

    //endregion

}

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

import com.neofect.gts.core.services.sm.domain.SmAuthUser;
import com.neofect.gts.core.services.sm.repository.SmAuthUserRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link SmAuthUser}<br/>
 */
@Service
public class SmAuthUserService {

    private final SmAuthUserRepository smAuthUserRepository;

    public SmAuthUserService(SmAuthUserRepository smAuthUserRepository) {
        this.smAuthUserRepository = smAuthUserRepository;
    }

    //region ------------------------------------------------------------------------------------------------ smAuthUser CRUD

    @Transactional
    public SmAuthUser saveSmAuthUser(SmAuthUser smAuthUser) {
        // if (smAuthUser.getId() == null) {
        //     addSmAuthUser(smAuthUser);
        // } else {
        //     modifySmAuthUser(smAuthUser);
        // }

        return smAuthUser;
    }

    private int addSmAuthUser(SmAuthUser smAuthUser) {
        int result = smAuthUserRepository.insertSmAuthUser(smAuthUser);
        return result;
    }

    private int modifySmAuthUser(SmAuthUser smAuthUser) {
        int result = smAuthUserRepository.updateSmAuthUser(smAuthUser);
        return result;
    }

    @Transactional
    public int removeSmAuthUser(Long id) {
        int rows = smAuthUserRepository.deleteSmAuthUser(id);
        return rows;
    }

    public SmAuthUser getSmAuthUser(Long id) {
        SmAuthUser smAuthUser = smAuthUserRepository.getSmAuthUser(id);

        return smAuthUser;
    }

    public int listSmAuthUserCnt(Map<String, Object> params) {
        int rows = smAuthUserRepository.listSmAuthUserCnt(params);
        return rows;
    }

    public List<SmAuthUser> listSmAuthUser(Map<String, Object> params) {
        List<SmAuthUser> lists = smAuthUserRepository.listSmAuthUser(params);

        return lists;
    }

    public List<SmAuthUser> listSmAuthUserByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("USER_ID", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("COMPANY_CODE", ids));
        List<SmAuthUser> lists = smAuthUserRepository.listSmAuthUser(params);

        return lists;
    }

    //endregion

}

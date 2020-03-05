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

import com.neofect.gts.core.services.sm.domain.SmComcodeD;
import com.neofect.gts.core.services.sm.repository.SmComcodeDRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link SmComcodeD}<br/>
 */
@Service
public class SmComcodeDService {

    private final SmComcodeDRepository smComcodeDRepository;

    public SmComcodeDService(SmComcodeDRepository smComcodeDRepository) {
        this.smComcodeDRepository = smComcodeDRepository;
    }

    //region ------------------------------------------------------------------------------------------------ smComcodeD CRUD

    @Transactional
    public SmComcodeD saveSmComcodeD(SmComcodeD smComcodeD) {
        // if (smComcodeD.getId() == null) {
        //     addSmComcodeD(smComcodeD);
        // } else {
        //     modifySmComcodeD(smComcodeD);
        // }

        return smComcodeD;
    }

    private int addSmComcodeD(SmComcodeD smComcodeD) {
        int result = smComcodeDRepository.insertSmComcodeD(smComcodeD);
        return result;
    }

    private int modifySmComcodeD(SmComcodeD smComcodeD) {
        int result = smComcodeDRepository.updateSmComcodeD(smComcodeD);
        return result;
    }

    @Transactional
    public int removeSmComcodeD(Long id) {
        int rows = smComcodeDRepository.deleteSmComcodeD(id);
        return rows;
    }

    public SmComcodeD getSmComcodeD(Long id) {
        SmComcodeD smComcodeD = smComcodeDRepository.getSmComcodeD(id);

        return smComcodeD;
    }

    public int listSmComcodeDCnt(Map<String, Object> params) {
        int rows = smComcodeDRepository.listSmComcodeDCnt(params);
        return rows;
    }

    public List<SmComcodeD> listSmComcodeD(Map<String, Object> params) {
        List<SmComcodeD> lists = smComcodeDRepository.listSmComcodeD(params);

        return lists;
    }

    public List<SmComcodeD> listSmComcodeDByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("SYS_ID", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("HCODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("DCODE", ids));
        List<SmComcodeD> lists = smComcodeDRepository.listSmComcodeD(params);

        return lists;
    }

    //endregion

}

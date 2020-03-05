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

import com.neofect.gts.core.services.am.domain.AmCodeItemAsst;
import com.neofect.gts.core.services.am.repository.AmCodeItemAsstRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;

/**
 * Service for {@link AmCodeItemAsst}<br/>
 */
@Service
public class AmCodeItemAsstService {

    private final AmCodeItemAsstRepository amCodeItemAsstRepository;

    public AmCodeItemAsstService(AmCodeItemAsstRepository amCodeItemAsstRepository) {
        this.amCodeItemAsstRepository = amCodeItemAsstRepository;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeItemAsst CRUD

    @Transactional
    public AmCodeItemAsst saveAmCodeItemAsst(AmCodeItemAsst amCodeItemAsst) {
        // if (amCodeItemAsst.getId() == null) {
        //     addAmCodeItemAsst(amCodeItemAsst);
        // } else {
        //     modifyAmCodeItemAsst(amCodeItemAsst);
        // }

        return amCodeItemAsst;
    }

    private int addAmCodeItemAsst(AmCodeItemAsst amCodeItemAsst) {
        int result = amCodeItemAsstRepository.insertAmCodeItemAsst(amCodeItemAsst);
        return result;
    }

    private int modifyAmCodeItemAsst(AmCodeItemAsst amCodeItemAsst) {
        int result = amCodeItemAsstRepository.updateAmCodeItemAsst(amCodeItemAsst);
        return result;
    }

    @Transactional
    public int removeAmCodeItemAsst(Long id) {
        int rows = amCodeItemAsstRepository.deleteAmCodeItemAsst(id);
        return rows;
    }

    public AmCodeItemAsst getAmCodeItemAsst(Long id) {
        AmCodeItemAsst amCodeItemAsst = amCodeItemAsstRepository.getAmCodeItemAsst(id);

        return amCodeItemAsst;
    }

    public int listAmCodeItemAsstCnt(Map<String, Object> params) {
        int rows = amCodeItemAsstRepository.listAmCodeItemAsstCnt(params);
        return rows;
    }

    public List<AmCodeItemAsst> listAmCodeItemAsst(Map<String, Object> params) {
        List<AmCodeItemAsst> lists = amCodeItemAsstRepository.listAmCodeItemAsst(params);

        return lists;
    }

    public List<AmCodeItemAsst> listAmCodeItemAsstByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("COMPANY_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("FA_KIND_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("FA_ITEM_CODE", ids));
        List<AmCodeItemAsst> lists = amCodeItemAsstRepository.listAmCodeItemAsst(params);

        return lists;
    }

    //endregion

}

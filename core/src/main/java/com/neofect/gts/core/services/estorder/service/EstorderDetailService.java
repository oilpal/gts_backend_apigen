/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/service/Service.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.estorder.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neofect.gts.core.services.estorder.domain.EstorderDetail;
import com.neofect.gts.core.services.estorder.repository.EstorderDetailRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link EstorderDetail}<br/>
 */
@Service
public class EstorderDetailService {

    private final EstorderDetailRepository estorderDetailRepository;

    public EstorderDetailService(EstorderDetailRepository estorderDetailRepository) {
        this.estorderDetailRepository = estorderDetailRepository;
    }

    //region ------------------------------------------------------------------------------------------------ estorderDetail CRUD

    @Transactional
    public EstorderDetail saveEstorderDetail(EstorderDetail estorderDetail) {
        // if (estorderDetail.getId() == null) {
        //     addEstorderDetail(estorderDetail);
        // } else {
        //     modifyEstorderDetail(estorderDetail);
        // }

        return estorderDetail;
    }

    private int addEstorderDetail(EstorderDetail estorderDetail) {
        int result = estorderDetailRepository.insertEstorderDetail(estorderDetail);
        return result;
    }

    private int modifyEstorderDetail(EstorderDetail estorderDetail) {
        int result = estorderDetailRepository.updateEstorderDetail(estorderDetail);
        return result;
    }

    @Transactional
    public int removeEstorderDetail(Long id) {
        int rows = estorderDetailRepository.deleteEstorderDetail(id);
        return rows;
    }

    public EstorderDetail getEstorderDetail(Long id) {
        EstorderDetail estorderDetail = estorderDetailRepository.getEstorderDetail(id);

        return estorderDetail;
    }

    public int listEstorderDetailCnt(Map<String, Object> params) {
        int rows = estorderDetailRepository.listEstorderDetailCnt(params);
        return rows;
    }

    public List<EstorderDetail> listEstorderDetail(Map<String, Object> params) {
        List<EstorderDetail> lists = estorderDetailRepository.listEstorderDetail(params);

        return lists;
    }

    public List<EstorderDetail> listEstorderDetailByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("ESLIP_DIV", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("SLIP_DATE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("DEPT_ID", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("SLIP_SEQ", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("SLIP_ITEM", ids));
        List<EstorderDetail> lists = estorderDetailRepository.listEstorderDetail(params);

        return lists;
    }

    //endregion

}

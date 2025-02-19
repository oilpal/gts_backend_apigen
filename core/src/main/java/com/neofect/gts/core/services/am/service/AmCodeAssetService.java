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

import com.neofect.gts.core.services.am.domain.AmCodeAsset;
import com.neofect.gts.core.services.am.repository.AmCodeAssetRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link AmCodeAsset}<br/>
 */
@Service
public class AmCodeAssetService {

    private final AmCodeAssetRepository amCodeAssetRepository;

    public AmCodeAssetService(AmCodeAssetRepository amCodeAssetRepository) {
        this.amCodeAssetRepository = amCodeAssetRepository;
    }

    //region ------------------------------------------------------------------------------------------------ amCodeAsset CRUD

    @Transactional
    public AmCodeAsset saveAmCodeAsset(AmCodeAsset amCodeAsset) {
        // if (amCodeAsset.getId() == null) {
        //     addAmCodeAsset(amCodeAsset);
        // } else {
        //     modifyAmCodeAsset(amCodeAsset);
        // }

        return amCodeAsset;
    }

    private int addAmCodeAsset(AmCodeAsset amCodeAsset) {
        int result = amCodeAssetRepository.insertAmCodeAsset(amCodeAsset);
        return result;
    }

    private int modifyAmCodeAsset(AmCodeAsset amCodeAsset) {
        int result = amCodeAssetRepository.updateAmCodeAsset(amCodeAsset);
        return result;
    }

    @Transactional
    public int removeAmCodeAsset(Long id) {
        int rows = amCodeAssetRepository.deleteAmCodeAsset(id);
        return rows;
    }

    public AmCodeAsset getAmCodeAsset(Long id) {
        AmCodeAsset amCodeAsset = amCodeAssetRepository.getAmCodeAsset(id);

        return amCodeAsset;
    }

    public int listAmCodeAssetCnt(Map<String, Object> params) {
        int rows = amCodeAssetRepository.listAmCodeAssetCnt(params);
        return rows;
    }

    public List<AmCodeAsset> listAmCodeAsset(Map<String, Object> params) {
        List<AmCodeAsset> lists = amCodeAssetRepository.listAmCodeAsset(params);

        return lists;
    }

    public List<AmCodeAsset> listAmCodeAssetByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("COMPANY_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("FA_KIND_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("FA_ITEM_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("FA_ASSET_CODE", ids));
        List<AmCodeAsset> lists = amCodeAssetRepository.listAmCodeAsset(params);

        return lists;
    }

    //endregion

}

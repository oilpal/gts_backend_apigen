/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/Repository.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.am.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.am.domain.AmCodeCostCenter;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link AmCodeCostCenter}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>AmCodeCostCenter getAmCodeCostCenter(Long id);</li>
 * <li>int listAmCodeCostCenterCnt(Map<String, Object> params);</li>
 * <li>List<AmCodeCostCenter> listAmCodeCostCenter(Map<String, Object> params);</li>
 * <li>int insertAmCodeCostCenter(AmCodeCostCenter amcodecostcenter);</li>
 * <li>int updateAmCodeCostCenter(AmCodeCostCenter amcodecostcenter);</li>
 * <li>int deleteAmCodeCostCenter(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface AmCodeCostCenterRepository extends AmCodeCostCenterRepository_ {
    AmCodeCostCenter getAmCodeCostCenter(Long id);

    int listAmCodeCostCenterCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listAmCodeCostCenterIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<AmCodeCostCenter> listAmCodeCostCenter(Map<String, Object> params);

    List<Long> listAmCodeCostCenterIds(Map<String, Object> params);

}

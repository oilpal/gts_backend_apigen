/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/Repository.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.estorder.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.estorder.domain.EstorderDetail;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link EstorderDetail}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>EstorderDetail getEstorderDetail(Long id);</li>
 * <li>int listEstorderDetailCnt(Map<String, Object> params);</li>
 * <li>List<EstorderDetail> listEstorderDetail(Map<String, Object> params);</li>
 * <li>int insertEstorderDetail(EstorderDetail estorderdetail);</li>
 * <li>int updateEstorderDetail(EstorderDetail estorderdetail);</li>
 * <li>int deleteEstorderDetail(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface EstorderDetailRepository extends EstorderDetailRepository_ {
    EstorderDetail getEstorderDetail(Long id);

    int listEstorderDetailCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listEstorderDetailIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<EstorderDetail> listEstorderDetail(Map<String, Object> params);

    List<Long> listEstorderDetailIds(Map<String, Object> params);

}

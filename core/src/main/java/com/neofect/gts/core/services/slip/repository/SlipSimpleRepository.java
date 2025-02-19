/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/Repository.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.slip.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.slip.domain.SlipSimple;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link SlipSimple}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>SlipSimple getSlipSimple(Long id);</li>
 * <li>int listSlipSimpleCnt(Map<String, Object> params);</li>
 * <li>List<SlipSimple> listSlipSimple(Map<String, Object> params);</li>
 * <li>int insertSlipSimple(SlipSimple slipsimple);</li>
 * <li>int updateSlipSimple(SlipSimple slipsimple);</li>
 * <li>int deleteSlipSimple(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface SlipSimpleRepository extends SlipSimpleRepository_ {
    SlipSimple getSlipSimple(Long id);

    int listSlipSimpleCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listSlipSimpleIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<SlipSimple> listSlipSimple(Map<String, Object> params);

    List<Long> listSlipSimpleIds(Map<String, Object> params);

}

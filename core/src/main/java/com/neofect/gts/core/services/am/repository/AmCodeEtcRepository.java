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

import com.neofect.gts.core.services.am.domain.AmCodeEtc;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link AmCodeEtc}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>AmCodeEtc getAmCodeEtc(Long id);</li>
 * <li>int listAmCodeEtcCnt(Map<String, Object> params);</li>
 * <li>List<AmCodeEtc> listAmCodeEtc(Map<String, Object> params);</li>
 * <li>int insertAmCodeEtc(AmCodeEtc amcodeetc);</li>
 * <li>int updateAmCodeEtc(AmCodeEtc amcodeetc);</li>
 * <li>int deleteAmCodeEtc(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface AmCodeEtcRepository extends AmCodeEtcRepository_ {
    AmCodeEtc getAmCodeEtc(Long id);

    int listAmCodeEtcCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listAmCodeEtcIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<AmCodeEtc> listAmCodeEtc(Map<String, Object> params);

    List<Long> listAmCodeEtcIds(Map<String, Object> params);

}

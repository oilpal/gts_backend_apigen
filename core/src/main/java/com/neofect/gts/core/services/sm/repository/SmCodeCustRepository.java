/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/Repository.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.sm.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.sm.domain.SmCodeCust;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link SmCodeCust}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>SmCodeCust getSmCodeCust(Long id);</li>
 * <li>int listSmCodeCustCnt(Map<String, Object> params);</li>
 * <li>List<SmCodeCust> listSmCodeCust(Map<String, Object> params);</li>
 * <li>int insertSmCodeCust(SmCodeCust smcodecust);</li>
 * <li>int updateSmCodeCust(SmCodeCust smcodecust);</li>
 * <li>int deleteSmCodeCust(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface SmCodeCustRepository extends SmCodeCustRepository_ {
    SmCodeCust getSmCodeCust(Long id);

    int listSmCodeCustCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listSmCodeCustIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<SmCodeCust> listSmCodeCust(Map<String, Object> params);

    List<Long> listSmCodeCustIds(Map<String, Object> params);

}

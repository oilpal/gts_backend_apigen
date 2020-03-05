/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/Repository.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.user.repository;

import java.util.List;
import java.util.Map;

import com.neofect.gts.core.services.user.domain.TermAgree;
import com.neofect.gts.core.services.user.domain.TermAgree;
import org.springframework.stereotype.Repository;

import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link TermAgree}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>TermAgree getTermAgree(Long id);</li>
 * <li>int listTermAgreeCnt(Map<String, Object> params);</li>
 * <li>List<TermAgree> listTermAgree(Map<String, Object> params);</li>
 * <li>int insertTermAgree(TermAgree termagree);</li>
 * <li>int updateTermAgree(TermAgree termagree);</li>
 * <li>int deleteTermAgree(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface TermAgreeRepository extends TermAgreeRepository_ {
    TermAgree getTermAgree(Long id);

    int listTermAgreeCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listTermAgreeIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<TermAgree> listTermAgree(Map<String, Object> params);

    List<Long> listTermAgreeIds(Map<String, Object> params);

}

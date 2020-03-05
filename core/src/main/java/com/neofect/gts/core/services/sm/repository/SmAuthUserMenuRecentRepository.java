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

import com.neofect.gts.core.services.sm.domain.SmAuthUserMenuRecent;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link SmAuthUserMenuRecent}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>SmAuthUserMenuRecent getSmAuthUserMenuRecent(Long id);</li>
 * <li>int listSmAuthUserMenuRecentCnt(Map<String, Object> params);</li>
 * <li>List<SmAuthUserMenuRecent> listSmAuthUserMenuRecent(Map<String, Object> params);</li>
 * <li>int insertSmAuthUserMenuRecent(SmAuthUserMenuRecent smauthusermenurecent);</li>
 * <li>int updateSmAuthUserMenuRecent(SmAuthUserMenuRecent smauthusermenurecent);</li>
 * <li>int deleteSmAuthUserMenuRecent(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface SmAuthUserMenuRecentRepository extends SmAuthUserMenuRecentRepository_ {
    SmAuthUserMenuRecent getSmAuthUserMenuRecent(Long id);

    int listSmAuthUserMenuRecentCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listSmAuthUserMenuRecentIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<SmAuthUserMenuRecent> listSmAuthUserMenuRecent(Map<String, Object> params);

    List<Long> listSmAuthUserMenuRecentIds(Map<String, Object> params);

}

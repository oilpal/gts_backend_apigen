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

import com.neofect.gts.core.services.sm.domain.SmAuthUserMenu;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link SmAuthUserMenu}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>SmAuthUserMenu getSmAuthUserMenu(Long id);</li>
 * <li>int listSmAuthUserMenuCnt(Map<String, Object> params);</li>
 * <li>List<SmAuthUserMenu> listSmAuthUserMenu(Map<String, Object> params);</li>
 * <li>int insertSmAuthUserMenu(SmAuthUserMenu smauthusermenu);</li>
 * <li>int updateSmAuthUserMenu(SmAuthUserMenu smauthusermenu);</li>
 * <li>int deleteSmAuthUserMenu(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface SmAuthUserMenuRepository extends SmAuthUserMenuRepository_ {
    SmAuthUserMenu getSmAuthUserMenu(Long id);

    int listSmAuthUserMenuCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listSmAuthUserMenuIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<SmAuthUserMenu> listSmAuthUserMenu(Map<String, Object> params);

    List<Long> listSmAuthUserMenuIds(Map<String, Object> params);

}

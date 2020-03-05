/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/Repository.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.common.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.common.domain.CodeDepositno;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link CodeDepositno}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>CodeDepositno getCodeDepositno(Long id);</li>
 * <li>int listCodeDepositnoCnt(Map<String, Object> params);</li>
 * <li>List<CodeDepositno> listCodeDepositno(Map<String, Object> params);</li>
 * <li>int insertCodeDepositno(CodeDepositno codedepositno);</li>
 * <li>int updateCodeDepositno(CodeDepositno codedepositno);</li>
 * <li>int deleteCodeDepositno(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface CodeDepositnoRepository extends CodeDepositnoRepository_ {
    CodeDepositno getCodeDepositno(Long id);

    int listCodeDepositnoCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listCodeDepositnoIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<CodeDepositno> listCodeDepositno(Map<String, Object> params);

    List<Long> listCodeDepositnoIds(Map<String, Object> params);

}

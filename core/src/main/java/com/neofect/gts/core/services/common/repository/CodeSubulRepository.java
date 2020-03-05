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

import com.neofect.gts.core.services.common.domain.CodeSubul;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link CodeSubul}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>CodeSubul getCodeSubul(Long id);</li>
 * <li>int listCodeSubulCnt(Map<String, Object> params);</li>
 * <li>List<CodeSubul> listCodeSubul(Map<String, Object> params);</li>
 * <li>int insertCodeSubul(CodeSubul codesubul);</li>
 * <li>int updateCodeSubul(CodeSubul codesubul);</li>
 * <li>int deleteCodeSubul(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface CodeSubulRepository extends CodeSubulRepository_ {
    CodeSubul getCodeSubul(Long id);

    int listCodeSubulCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listCodeSubulIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<CodeSubul> listCodeSubul(Map<String, Object> params);

    List<Long> listCodeSubulIds(Map<String, Object> params);

}

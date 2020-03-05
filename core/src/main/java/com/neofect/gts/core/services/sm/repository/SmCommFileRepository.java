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

import com.neofect.gts.core.services.sm.domain.SmCommFile;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link SmCommFile}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>SmCommFile getSmCommFile(Long id);</li>
 * <li>int listSmCommFileCnt(Map<String, Object> params);</li>
 * <li>List<SmCommFile> listSmCommFile(Map<String, Object> params);</li>
 * <li>int insertSmCommFile(SmCommFile smcommfile);</li>
 * <li>int updateSmCommFile(SmCommFile smcommfile);</li>
 * <li>int deleteSmCommFile(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface SmCommFileRepository extends SmCommFileRepository_ {
    SmCommFile getSmCommFile(Long id);

    int listSmCommFileCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listSmCommFileIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<SmCommFile> listSmCommFile(Map<String, Object> params);

    List<Long> listSmCommFileIds(Map<String, Object> params);

}

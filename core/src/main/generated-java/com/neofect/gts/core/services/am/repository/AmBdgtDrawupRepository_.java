/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/RepositoryBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.am.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.am.domain.AmBdgtDrawup;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link AmBdgtDrawup}
 * @see com.neofect.gts.core.services.am.repository.AmBdgtDrawupRepository
 */
@DefaultMapper
@Repository
public interface AmBdgtDrawupRepository_ {

    AmBdgtDrawup simpleGetAmBdgtDrawup(Long id);

    int simpleListAmBdgtDrawupCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listAmBdgtDrawupIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<AmBdgtDrawup> simpleListAmBdgtDrawup(Map<String, Object> params);

    int insertAmBdgtDrawup(AmBdgtDrawup amBdgtDrawup);

    int updateAmBdgtDrawup(AmBdgtDrawup amBdgtDrawup);

    int updateAmBdgtDrawupDynamic(AmBdgtDrawup amBdgtDrawup);

    int deleteAmBdgtDrawup(Long id);

}

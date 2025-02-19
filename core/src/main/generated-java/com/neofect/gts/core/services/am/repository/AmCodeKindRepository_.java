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

import com.neofect.gts.core.services.am.domain.AmCodeKind;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link AmCodeKind}
 * @see com.neofect.gts.core.services.am.repository.AmCodeKindRepository
 */
@DefaultMapper
@Repository
public interface AmCodeKindRepository_ {

    AmCodeKind simpleGetAmCodeKind(Long id);

    int simpleListAmCodeKindCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listAmCodeKindIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<AmCodeKind> simpleListAmCodeKind(Map<String, Object> params);

    int insertAmCodeKind(AmCodeKind amCodeKind);

    int updateAmCodeKind(AmCodeKind amCodeKind);

    int updateAmCodeKindDynamic(AmCodeKind amCodeKind);

    int deleteAmCodeKind(Long id);

}

/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/RepositoryBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.sm.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.sm.domain.SmCodeZip;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link SmCodeZip}
 * @see com.neofect.gts.core.services.sm.repository.SmCodeZipRepository
 */
@DefaultMapper
@Repository
public interface SmCodeZipRepository_ {

    SmCodeZip simpleGetSmCodeZip(Long id);

    int simpleListSmCodeZipCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listSmCodeZipIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<SmCodeZip> simpleListSmCodeZip(Map<String, Object> params);

    int insertSmCodeZip(SmCodeZip smCodeZip);

    int updateSmCodeZip(SmCodeZip smCodeZip);

    int updateSmCodeZipDynamic(SmCodeZip smCodeZip);

    int deleteSmCodeZip(Long id);

}

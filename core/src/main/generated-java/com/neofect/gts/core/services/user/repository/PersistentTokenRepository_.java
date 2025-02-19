/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/RepositoryBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.user.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;
import com.neofect.gts.core.services.user.domain.PersistentToken;

/**
 * Repository for {@link PersistentToken}
 * @see PersistentTokenRepository
 */
@DefaultMapper
@Repository
public interface PersistentTokenRepository_ {

    PersistentToken simpleGetPersistentToken(Long id);

    int simpleListPersistentTokenCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listPersistentTokenIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<PersistentToken> simpleListPersistentToken(Map<String, Object> params);

    int insertPersistentToken(PersistentToken persistentToken);

    int updatePersistentToken(PersistentToken persistentToken);

    int updatePersistentTokenDynamic(PersistentToken persistentToken);

    int deletePersistentToken(Long id);

}

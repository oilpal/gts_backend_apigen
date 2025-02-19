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
import com.neofect.gts.core.services.user.domain.SubscribeAgree;

/**
 * Repository for {@link SubscribeAgree}
 * @see SubscribeAgreeRepository
 */
@DefaultMapper
@Repository
public interface SubscribeAgreeRepository_ {

    SubscribeAgree simpleGetSubscribeAgree(Long id);

    int simpleListSubscribeAgreeCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listSubscribeAgreeIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<SubscribeAgree> simpleListSubscribeAgree(Map<String, Object> params);

    int insertSubscribeAgree(SubscribeAgree subscribeAgree);

    int updateSubscribeAgree(SubscribeAgree subscribeAgree);

    int updateSubscribeAgreeDynamic(SubscribeAgree subscribeAgree);

    int deleteSubscribeAgree(Long id);

}

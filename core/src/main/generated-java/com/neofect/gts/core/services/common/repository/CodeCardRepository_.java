/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/RepositoryBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.common.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.common.domain.CodeCard;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link CodeCard}
 * @see com.neofect.gts.core.services.common.repository.CodeCardRepository
 */
@DefaultMapper
@Repository
public interface CodeCardRepository_ {

    CodeCard simpleGetCodeCard(Long id);

    int simpleListCodeCardCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listCodeCardIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<CodeCard> simpleListCodeCard(Map<String, Object> params);

    int insertCodeCard(CodeCard codeCard);

    int updateCodeCard(CodeCard codeCard);

    int updateCodeCardDynamic(CodeCard codeCard);

    int deleteCodeCard(Long id);

}

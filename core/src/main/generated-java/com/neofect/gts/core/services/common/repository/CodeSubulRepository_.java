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

import com.neofect.gts.core.services.common.domain.CodeSubul;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link CodeSubul}
 * @see com.neofect.gts.core.services.common.repository.CodeSubulRepository
 */
@DefaultMapper
@Repository
public interface CodeSubulRepository_ {

    CodeSubul simpleGetCodeSubul(Long id);

    int simpleListCodeSubulCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listCodeSubulIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<CodeSubul> simpleListCodeSubul(Map<String, Object> params);

    int insertCodeSubul(CodeSubul codeSubul);

    int updateCodeSubul(CodeSubul codeSubul);

    int updateCodeSubulDynamic(CodeSubul codeSubul);

    int deleteCodeSubul(Long id);

}

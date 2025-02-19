/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/RepositoryBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.xg.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.xg.domain.XgComtnLoginlog;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link XgComtnLoginlog}
 * @see com.neofect.gts.core.services.xg.repository.XgComtnLoginlogRepository
 */
@DefaultMapper
@Repository
public interface XgComtnLoginlogRepository_ {

    XgComtnLoginlog simpleGetXgComtnLoginlog(Long id);

    int simpleListXgComtnLoginlogCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listXgComtnLoginlogIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<XgComtnLoginlog> simpleListXgComtnLoginlog(Map<String, Object> params);

    int insertXgComtnLoginlog(XgComtnLoginlog xgComtnLoginlog);

    int updateXgComtnLoginlog(XgComtnLoginlog xgComtnLoginlog);

    int updateXgComtnLoginlogDynamic(XgComtnLoginlog xgComtnLoginlog);

    int deleteXgComtnLoginlog(Long id);

}

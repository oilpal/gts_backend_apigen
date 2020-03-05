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

import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;
import com.neofect.gts.core.services.common.domain.ActionLog;

/**
 * Repository for {@link ActionLog}
 * @see ActionLogRepository
 */
@DefaultMapper
@Repository
public interface ActionLogRepository_ {

    ActionLog simpleGetActionLog(Long id);

    int simpleListActionLogCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listActionLogIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<ActionLog> simpleListActionLog(Map<String, Object> params);

    int insertActionLog(ActionLog actionLog);

    int updateActionLog(ActionLog actionLog);

    int updateActionLogDynamic(ActionLog actionLog);

    int deleteActionLog(Long id);

}

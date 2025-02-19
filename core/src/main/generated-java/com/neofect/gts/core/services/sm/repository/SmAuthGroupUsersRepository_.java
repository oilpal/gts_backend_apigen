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

import com.neofect.gts.core.services.sm.domain.SmAuthGroupUsers;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link SmAuthGroupUsers}
 * @see com.neofect.gts.core.services.sm.repository.SmAuthGroupUsersRepository
 */
@DefaultMapper
@Repository
public interface SmAuthGroupUsersRepository_ {

    SmAuthGroupUsers simpleGetSmAuthGroupUsers(Long id);

    int simpleListSmAuthGroupUsersCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listSmAuthGroupUsersIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<SmAuthGroupUsers> simpleListSmAuthGroupUsers(Map<String, Object> params);

    int insertSmAuthGroupUsers(SmAuthGroupUsers smAuthGroupUsers);

    int updateSmAuthGroupUsers(SmAuthGroupUsers smAuthGroupUsers);

    int updateSmAuthGroupUsersDynamic(SmAuthGroupUsers smAuthGroupUsers);

    int deleteSmAuthGroupUsers(Long id);

}

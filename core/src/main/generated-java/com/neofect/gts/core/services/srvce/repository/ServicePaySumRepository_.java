/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/RepositoryBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.srvce.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.srvce.domain.ServicePaySum;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link ServicePaySum}
 * @see com.neofect.gts.core.services.srvce.repository.ServicePaySumRepository
 */
@DefaultMapper
@Repository
public interface ServicePaySumRepository_ {

    ServicePaySum simpleGetServicePaySum(Long id);

    int simpleListServicePaySumCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listServicePaySumIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<ServicePaySum> simpleListServicePaySum(Map<String, Object> params);

    int insertServicePaySum(ServicePaySum servicePaySum);

    int updateServicePaySum(ServicePaySum servicePaySum);

    int updateServicePaySumDynamic(ServicePaySum servicePaySum);

    int deleteServicePaySum(Long id);

}

/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/Repository.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.srvce.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.srvce.domain.ServiceContract;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link ServiceContract}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>ServiceContract getServiceContract(Long id);</li>
 * <li>int listServiceContractCnt(Map<String, Object> params);</li>
 * <li>List<ServiceContract> listServiceContract(Map<String, Object> params);</li>
 * <li>int insertServiceContract(ServiceContract servicecontract);</li>
 * <li>int updateServiceContract(ServiceContract servicecontract);</li>
 * <li>int deleteServiceContract(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface ServiceContractRepository extends ServiceContractRepository_ {
    ServiceContract getServiceContract(Long id);

    int listServiceContractCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listServiceContractIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<ServiceContract> listServiceContract(Map<String, Object> params);

    List<Long> listServiceContractIds(Map<String, Object> params);

}

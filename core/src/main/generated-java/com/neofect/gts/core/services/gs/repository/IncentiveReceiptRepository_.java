/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/RepositoryBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.gs.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.gs.domain.IncentiveReceipt;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link IncentiveReceipt}
 * @see com.neofect.gts.core.services.gs.repository.IncentiveReceiptRepository
 */
@DefaultMapper
@Repository
public interface IncentiveReceiptRepository_ {

    IncentiveReceipt simpleGetIncentiveReceipt(Long id);

    int simpleListIncentiveReceiptCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listIncentiveReceiptIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<IncentiveReceipt> simpleListIncentiveReceipt(Map<String, Object> params);

    int insertIncentiveReceipt(IncentiveReceipt incentiveReceipt);

    int updateIncentiveReceipt(IncentiveReceipt incentiveReceipt);

    int updateIncentiveReceiptDynamic(IncentiveReceipt incentiveReceipt);

    int deleteIncentiveReceipt(Long id);

}

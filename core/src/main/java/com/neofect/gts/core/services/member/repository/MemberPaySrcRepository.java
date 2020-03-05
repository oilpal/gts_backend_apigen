/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/Repository.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.member.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.member.domain.MemberPaySrc;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link MemberPaySrc}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>MemberPaySrc getMemberPaySrc(Long id);</li>
 * <li>int listMemberPaySrcCnt(Map<String, Object> params);</li>
 * <li>List<MemberPaySrc> listMemberPaySrc(Map<String, Object> params);</li>
 * <li>int insertMemberPaySrc(MemberPaySrc memberpaysrc);</li>
 * <li>int updateMemberPaySrc(MemberPaySrc memberpaysrc);</li>
 * <li>int deleteMemberPaySrc(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface MemberPaySrcRepository extends MemberPaySrcRepository_ {
    MemberPaySrc getMemberPaySrc(Long id);

    int listMemberPaySrcCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listMemberPaySrcIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<MemberPaySrc> listMemberPaySrc(Map<String, Object> params);

    List<Long> listMemberPaySrcIds(Map<String, Object> params);

}

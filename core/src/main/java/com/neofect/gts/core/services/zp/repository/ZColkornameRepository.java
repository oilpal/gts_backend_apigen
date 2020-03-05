/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/repository/Repository.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.zp.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neofect.gts.core.services.zp.domain.ZColkorname;
import com.unvus.config.mybatis.pagination.Pageable;
import com.unvus.config.mybatis.support.DefaultMapper;

/**
 * Repository for {@link ZColkorname}<br/>
 * Available methods are.. <br/>
 * <ul>
 * <li>ZColkorname getZColkorname(Long id);</li>
 * <li>int listZColkornameCnt(Map<String, Object> params);</li>
 * <li>List<ZColkorname> listZColkorname(Map<String, Object> params);</li>
 * <li>int insertZColkorname(ZColkorname zcolkorname);</li>
 * <li>int updateZColkorname(ZColkorname zcolkorname);</li>
 * <li>int deleteZColkorname(Long id);</li>
 * </ul>
 */
@DefaultMapper
@Repository
public interface ZColkornameRepository extends ZColkornameRepository_ {
    ZColkorname getZColkorname(Long id);

    int listZColkornameCnt(Map<String, Object> params);

    /**
     * if yuou want to avoid result objects less than dataPerPage caused by "1:N mappings".. <br/>
     * add function that return "distinct id list" and name it with : <br/>
     * <code>List<Long> listZColkornameIds(Map<String, Object> params)</code> <br/>
     * and replace @Pageable with :  <br/>
     * <code>@Pageable(useMergeQuery = true)</code> <br/>
     */
    @Pageable
    List<ZColkorname> listZColkorname(Map<String, Object> params);

    List<Long> listZColkornameIds(Map<String, Object> params);

}

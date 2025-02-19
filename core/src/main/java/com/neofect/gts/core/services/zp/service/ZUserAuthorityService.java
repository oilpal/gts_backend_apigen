/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/service/Service.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.zp.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neofect.gts.core.services.zp.domain.ZUserAuthority;
import com.neofect.gts.core.services.zp.repository.ZUserAuthorityRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link ZUserAuthority}<br/>
 */
@Service
public class ZUserAuthorityService {

    private final ZUserAuthorityRepository zUserAuthorityRepository;

    public ZUserAuthorityService(ZUserAuthorityRepository zUserAuthorityRepository) {
        this.zUserAuthorityRepository = zUserAuthorityRepository;
    }

    //region ------------------------------------------------------------------------------------------------ zUserAuthority CRUD

    @Transactional
    public ZUserAuthority saveZUserAuthority(ZUserAuthority zUserAuthority) {
        // if (zUserAuthority.getId() == null) {
        //     addZUserAuthority(zUserAuthority);
        // } else {
        //     modifyZUserAuthority(zUserAuthority);
        // }

        return zUserAuthority;
    }

    private int addZUserAuthority(ZUserAuthority zUserAuthority) {
        int result = zUserAuthorityRepository.insertZUserAuthority(zUserAuthority);
        return result;
    }

    private int modifyZUserAuthority(ZUserAuthority zUserAuthority) {
        int result = zUserAuthorityRepository.updateZUserAuthority(zUserAuthority);
        return result;
    }

    @Transactional
    public int removeZUserAuthority(Long id) {
        int rows = zUserAuthorityRepository.deleteZUserAuthority(id);
        return rows;
    }

    public ZUserAuthority getZUserAuthority(Long id) {
        ZUserAuthority zUserAuthority = zUserAuthorityRepository.getZUserAuthority(id);

        return zUserAuthority;
    }

    public int listZUserAuthorityCnt(Map<String, Object> params) {
        int rows = zUserAuthorityRepository.listZUserAuthorityCnt(params);
        return rows;
    }

    public List<ZUserAuthority> listZUserAuthority(Map<String, Object> params) {
        List<ZUserAuthority> lists = zUserAuthorityRepository.listZUserAuthority(params);

        return lists;
    }

    public List<ZUserAuthority> listZUserAuthorityByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("COMPCODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("EMPNO", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("PGMCODE", ids));
        List<ZUserAuthority> lists = zUserAuthorityRepository.listZUserAuthority(params);

        return lists;
    }

    //endregion

}

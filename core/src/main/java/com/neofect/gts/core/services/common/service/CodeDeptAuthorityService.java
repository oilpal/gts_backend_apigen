/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/service/Service.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neofect.gts.core.services.common.domain.CodeDeptAuthority;
import com.neofect.gts.core.services.common.repository.CodeDeptAuthorityRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link CodeDeptAuthority}<br/>
 */
@Service
public class CodeDeptAuthorityService {

    private final CodeDeptAuthorityRepository codeDeptAuthorityRepository;

    public CodeDeptAuthorityService(CodeDeptAuthorityRepository codeDeptAuthorityRepository) {
        this.codeDeptAuthorityRepository = codeDeptAuthorityRepository;
    }

    //region ------------------------------------------------------------------------------------------------ codeDeptAuthority CRUD

    @Transactional
    public CodeDeptAuthority saveCodeDeptAuthority(CodeDeptAuthority codeDeptAuthority) {
        // if (codeDeptAuthority.getId() == null) {
        //     addCodeDeptAuthority(codeDeptAuthority);
        // } else {
        //     modifyCodeDeptAuthority(codeDeptAuthority);
        // }

        return codeDeptAuthority;
    }

    private int addCodeDeptAuthority(CodeDeptAuthority codeDeptAuthority) {
        int result = codeDeptAuthorityRepository.insertCodeDeptAuthority(codeDeptAuthority);
        return result;
    }

    private int modifyCodeDeptAuthority(CodeDeptAuthority codeDeptAuthority) {
        int result = codeDeptAuthorityRepository.updateCodeDeptAuthority(codeDeptAuthority);
        return result;
    }

    @Transactional
    public int removeCodeDeptAuthority(Long id) {
        int rows = codeDeptAuthorityRepository.deleteCodeDeptAuthority(id);
        return rows;
    }

    public CodeDeptAuthority getCodeDeptAuthority(Long id) {
        CodeDeptAuthority codeDeptAuthority = codeDeptAuthorityRepository.getCodeDeptAuthority(id);

        return codeDeptAuthority;
    }

    public int listCodeDeptAuthorityCnt(Map<String, Object> params) {
        int rows = codeDeptAuthorityRepository.listCodeDeptAuthorityCnt(params);
        return rows;
    }

    public List<CodeDeptAuthority> listCodeDeptAuthority(Map<String, Object> params) {
        List<CodeDeptAuthority> lists = codeDeptAuthorityRepository.listCodeDeptAuthority(params);

        return lists;
    }

    public List<CodeDeptAuthority> listCodeDeptAuthorityByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("MEMBER_ID", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("DEPT_ID", ids));
        List<CodeDeptAuthority> lists = codeDeptAuthorityRepository.listCodeDeptAuthority(params);

        return lists;
    }

    //endregion

}

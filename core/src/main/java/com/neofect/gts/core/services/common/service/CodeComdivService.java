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

import com.neofect.gts.core.services.common.domain.CodeComdiv;
import com.neofect.gts.core.services.common.repository.CodeComdivRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;

/**
 * Service for {@link CodeComdiv}<br/>
 */
@Service
public class CodeComdivService {

    private final CodeComdivRepository codeComdivRepository;

    public CodeComdivService(CodeComdivRepository codeComdivRepository) {
        this.codeComdivRepository = codeComdivRepository;
    }

    //region ------------------------------------------------------------------------------------------------ codeComdiv CRUD

    @Transactional
    public CodeComdiv saveCodeComdiv(CodeComdiv codeComdiv) {
        // if (codeComdiv.getId() == null) {
        //     addCodeComdiv(codeComdiv);
        // } else {
        //     modifyCodeComdiv(codeComdiv);
        // }

        return codeComdiv;
    }

    private int addCodeComdiv(CodeComdiv codeComdiv) {
        int result = codeComdivRepository.insertCodeComdiv(codeComdiv);
        return result;
    }

    private int modifyCodeComdiv(CodeComdiv codeComdiv) {
        int result = codeComdivRepository.updateCodeComdiv(codeComdiv);
        return result;
    }

    @Transactional
    public int removeCodeComdiv(Long id) {
        int rows = codeComdivRepository.deleteCodeComdiv(id);
        return rows;
    }

    public CodeComdiv getCodeComdiv(Long id) {
        CodeComdiv codeComdiv = codeComdivRepository.getCodeComdiv(id);

        return codeComdiv;
    }

    public int listCodeComdivCnt(Map<String, Object> params) {
        int rows = codeComdivRepository.listCodeComdivCnt(params);
        return rows;
    }

    public List<CodeComdiv> listCodeComdiv(Map<String, Object> params) {
        List<CodeComdiv> lists = codeComdivRepository.listCodeComdiv(params);

        return lists;
    }

    public List<CodeComdiv> listCodeComdivByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("COMSEC_CODE", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("COMDIV_CODE", ids));
        List<CodeComdiv> lists = codeComdivRepository.listCodeComdiv(params);

        return lists;
    }

    //endregion

}

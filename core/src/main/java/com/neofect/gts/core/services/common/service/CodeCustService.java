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

import com.neofect.gts.core.services.common.domain.CodeCust;
import com.neofect.gts.core.services.common.repository.CodeCustRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;

/**
 * Service for {@link CodeCust}<br/>
 */
@Service
public class CodeCustService {

    private final CodeCustRepository codeCustRepository;

    public CodeCustService(CodeCustRepository codeCustRepository) {
        this.codeCustRepository = codeCustRepository;
    }

    //region ------------------------------------------------------------------------------------------------ codeCust CRUD

    @Transactional
    public CodeCust saveCodeCust(CodeCust codeCust) {
        if (codeCust.getId() == null) {
            addCodeCust(codeCust);
        } else {
            modifyCodeCust(codeCust);
        }

        return codeCust;
    }

    private int addCodeCust(CodeCust codeCust) {
        int result = codeCustRepository.insertCodeCust(codeCust);
        return result;
    }

    private int modifyCodeCust(CodeCust codeCust) {
        int result = codeCustRepository.updateCodeCust(codeCust);
        return result;
    }

    @Transactional
    public int removeCodeCust(Long id) {
        int rows = codeCustRepository.deleteCodeCust(id);
        return rows;
    }

    public CodeCust getCodeCust(Long id) {
        CodeCust codeCust = codeCustRepository.getCodeCust(id);

        return codeCust;
    }

    public int listCodeCustCnt(Map<String, Object> params) {
        int rows = codeCustRepository.listCodeCustCnt(params);
        return rows;
    }

    public List<CodeCust> listCodeCust(Map<String, Object> params) {
        List<CodeCust> lists = codeCustRepository.listCodeCust(params);

        return lists;
    }

    public List<CodeCust> listCodeCustByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("CUST_ID", ids));
        List<CodeCust> lists = codeCustRepository.listCodeCust(params);

        return lists;
    }

    //endregion

}

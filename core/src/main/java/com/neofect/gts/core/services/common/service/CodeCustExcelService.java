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

import com.neofect.gts.core.services.common.domain.CodeCustExcel;
import com.neofect.gts.core.services.common.repository.CodeCustExcelRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;

/**
 * Service for {@link CodeCustExcel}<br/>
 */
@Service
public class CodeCustExcelService {

    private final CodeCustExcelRepository codeCustExcelRepository;

    public CodeCustExcelService(CodeCustExcelRepository codeCustExcelRepository) {
        this.codeCustExcelRepository = codeCustExcelRepository;
    }

    //region ------------------------------------------------------------------------------------------------ codeCustExcel CRUD

    @Transactional
    public CodeCustExcel saveCodeCustExcel(CodeCustExcel codeCustExcel) {
        // if (codeCustExcel.getId() == null) {
        //     addCodeCustExcel(codeCustExcel);
        // } else {
        //     modifyCodeCustExcel(codeCustExcel);
        // }

        return codeCustExcel;
    }

    private int addCodeCustExcel(CodeCustExcel codeCustExcel) {
        int result = codeCustExcelRepository.insertCodeCustExcel(codeCustExcel);
        return result;
    }

    private int modifyCodeCustExcel(CodeCustExcel codeCustExcel) {
        int result = codeCustExcelRepository.updateCodeCustExcel(codeCustExcel);
        return result;
    }

    @Transactional
    public int removeCodeCustExcel(Long id) {
        int rows = codeCustExcelRepository.deleteCodeCustExcel(id);
        return rows;
    }

    public CodeCustExcel getCodeCustExcel(Long id) {
        CodeCustExcel codeCustExcel = codeCustExcelRepository.getCodeCustExcel(id);

        return codeCustExcel;
    }

    public int listCodeCustExcelCnt(Map<String, Object> params) {
        int rows = codeCustExcelRepository.listCodeCustExcelCnt(params);
        return rows;
    }

    public List<CodeCustExcel> listCodeCustExcel(Map<String, Object> params) {
        List<CodeCustExcel> lists = codeCustExcelRepository.listCodeCustExcel(params);

        return lists;
    }

    public List<CodeCustExcel> listCodeCustExcelByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("JOB_ID", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("CUST_ID", ids));
        List<CodeCustExcel> lists = codeCustExcelRepository.listCodeCustExcel(params);

        return lists;
    }

    //endregion

}

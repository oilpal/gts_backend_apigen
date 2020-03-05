/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/service/Service.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.form.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neofect.gts.core.services.form.domain.FormContractText;
import com.neofect.gts.core.services.form.repository.FormContractTextRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;


/**
 * Service for {@link FormContractText}<br/>
 */
@Service
public class FormContractTextService {

    private final FormContractTextRepository formContractTextRepository;

    public FormContractTextService(FormContractTextRepository formContractTextRepository) {
        this.formContractTextRepository = formContractTextRepository;
    }

    //region ------------------------------------------------------------------------------------------------ formContractText CRUD

    @Transactional
    public FormContractText saveFormContractText(FormContractText formContractText) {
        // if (formContractText.getId() == null) {
        //     addFormContractText(formContractText);
        // } else {
        //     modifyFormContractText(formContractText);
        // }

        return formContractText;
    }

    private int addFormContractText(FormContractText formContractText) {
        int result = formContractTextRepository.insertFormContractText(formContractText);
        return result;
    }

    private int modifyFormContractText(FormContractText formContractText) {
        int result = formContractTextRepository.updateFormContractText(formContractText);
        return result;
    }

    @Transactional
    public int removeFormContractText(Long id) {
        int rows = formContractTextRepository.deleteFormContractText(id);
        return rows;
    }

    public FormContractText getFormContractText(Long id) {
        FormContractText formContractText = formContractTextRepository.getFormContractText(id);

        return formContractText;
    }

    public int listFormContractTextCnt(Map<String, Object> params) {
        int rows = formContractTextRepository.listFormContractTextCnt(params);
        return rows;
    }

    public List<FormContractText> listFormContractText(Map<String, Object> params) {
        List<FormContractText> lists = formContractTextRepository.listFormContractText(params);

        return lists;
    }

    public List<FormContractText> listFormContractTextByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("TEXT_ID", ids));
        QueryTool.setDefaultOrderBy(new OrderBy("TEXT_SEQ", ids));
        List<FormContractText> lists = formContractTextRepository.listFormContractText(params);

        return lists;
    }

    //endregion

}

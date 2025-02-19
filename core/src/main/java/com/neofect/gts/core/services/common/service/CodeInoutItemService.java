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

import com.neofect.gts.core.services.common.domain.CodeInoutItem;
import com.neofect.gts.core.services.common.repository.CodeInoutItemRepository;
import com.unvus.config.mybatis.pagination.OrderBy;
import com.unvus.query.QueryTool;

/**
 * Service for {@link CodeInoutItem}<br/>
 */
@Service
public class CodeInoutItemService {

    private final CodeInoutItemRepository codeInoutItemRepository;

    public CodeInoutItemService(CodeInoutItemRepository codeInoutItemRepository) {
        this.codeInoutItemRepository = codeInoutItemRepository;
    }

    //region ------------------------------------------------------------------------------------------------ codeInoutItem CRUD

    @Transactional
    public CodeInoutItem saveCodeInoutItem(CodeInoutItem codeInoutItem) {
        if (codeInoutItem.getId() == null) {
            addCodeInoutItem(codeInoutItem);
        } else {
            modifyCodeInoutItem(codeInoutItem);
        }

        return codeInoutItem;
    }

    private int addCodeInoutItem(CodeInoutItem codeInoutItem) {
        int result = codeInoutItemRepository.insertCodeInoutItem(codeInoutItem);
        return result;
    }

    private int modifyCodeInoutItem(CodeInoutItem codeInoutItem) {
        int result = codeInoutItemRepository.updateCodeInoutItem(codeInoutItem);
        return result;
    }

    @Transactional
    public int removeCodeInoutItem(Long id) {
        int rows = codeInoutItemRepository.deleteCodeInoutItem(id);
        return rows;
    }

    public CodeInoutItem getCodeInoutItem(Long id) {
        CodeInoutItem codeInoutItem = codeInoutItemRepository.getCodeInoutItem(id);

        return codeInoutItem;
    }

    public int listCodeInoutItemCnt(Map<String, Object> params) {
        int rows = codeInoutItemRepository.listCodeInoutItemCnt(params);
        return rows;
    }

    public List<CodeInoutItem> listCodeInoutItem(Map<String, Object> params) {
        List<CodeInoutItem> lists = codeInoutItemRepository.listCodeInoutItem(params);

        return lists;
    }

    public List<CodeInoutItem> listCodeInoutItemByIds(List<Long> ids, Map<String, Object> params) {
        params.put("ids", ids);
        QueryTool.setDefaultOrderBy(new OrderBy("ITEM_CODE", ids));
        List<CodeInoutItem> lists = codeInoutItemRepository.listCodeInoutItem(params);

        return lists;
    }

    //endregion

}

/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/FieldBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.common.domain.query.field;

import java.util.HashMap;
import java.util.Map;

import com.unvus.query.FieldUtil;
import com.unvus.query.frag.Field;

public interface CategoryField_ {

    Map<String, Field> _FIELD_MAP = new HashMap<String, Field>() {
        {
            FieldUtil.toMap(this, new Field("id", "cate_id"));
            FieldUtil.toMap(this, new Field("namespace", "cate_namespace"));
            FieldUtil.toMap(this, new Field("fullPath", "cate_full_path"));
            FieldUtil.toMap(this, new Field("code", "cate_code"));
            FieldUtil.toMap(this, new Field("parentId", "cate_parent_id"));
            FieldUtil.toMap(this, new Field("parentCode", "cate_parent_code"));
            FieldUtil.toMap(this, new Field("depth", "cate_depth"));
            FieldUtil.toMap(this, new Field("maxDepth", "cate_max_depth"));
            FieldUtil.toMap(this, new Field("fixed", "cate_fixed"));
            FieldUtil.toMap(this, new Field("name", "cate_name"));
            FieldUtil.toMap(this, new Field("desc", "cate_desc"));
            FieldUtil.toMap(this, new Field("value", "cate_value"));
            FieldUtil.toMap(this, new Field("ext", "cate_ext"));
            FieldUtil.toMap(this, new Field("sort", "cate_sort"));
            FieldUtil.toMap(this, new Field("deleted", "cate_deleted"));
            FieldUtil.toMap(this, new Field("createdBy", "cate_created_by"));
            FieldUtil.toMap(this, new Field("createdDt", "cate_created_dt"));
            FieldUtil.toMap(this, new Field("modifiedBy", "cate_modified_by"));
            FieldUtil.toMap(this, new Field("modifiedDt", "cate_modified_dt"));
        }
    };

    String prefix();

    /**
    * 카테고리ID
    */
    default Field id() {
        return new Field(prefix(), "id", "cate_id");
    }

    default Field id(String prefix) {
        return new Field(prefix, "id", "cate_id");
    }

    /**
    * 네임스페이스
    */
    default Field namespace() {
        return new Field(prefix(), "namespace", "cate_namespace");
    }

    default Field namespace(String prefix) {
        return new Field(prefix, "namespace", "cate_namespace");
    }

    /**
    * 카테고리전체경로
    */
    default Field fullPath() {
        return new Field(prefix(), "fullPath", "cate_full_path");
    }

    default Field fullPath(String prefix) {
        return new Field(prefix, "fullPath", "cate_full_path");
    }

    /**
    * 카테고리코드
    */
    default Field code() {
        return new Field(prefix(), "code", "cate_code");
    }

    default Field code(String prefix) {
        return new Field(prefix, "code", "cate_code");
    }

    /**
    * 상위카테고리 아이디
    */
    default Field parentId() {
        return new Field(prefix(), "parentId", "cate_parent_id");
    }

    default Field parentId(String prefix) {
        return new Field(prefix, "parentId", "cate_parent_id");
    }

    /**
    * 상위카테고리 코드
    */
    default Field parentCode() {
        return new Field(prefix(), "parentCode", "cate_parent_code");
    }

    default Field parentCode(String prefix) {
        return new Field(prefix, "parentCode", "cate_parent_code");
    }

    /**
    * 현재DEPTH
    */
    default Field depth() {
        return new Field(prefix(), "depth", "cate_depth");
    }

    default Field depth(String prefix) {
        return new Field(prefix, "depth", "cate_depth");
    }

    /**
    * 최대DEPTH
    */
    default Field maxDepth() {
        return new Field(prefix(), "maxDepth", "cate_max_depth");
    }

    default Field maxDepth(String prefix) {
        return new Field(prefix, "maxDepth", "cate_max_depth");
    }

    /**
    * 삭제불가여부
    */
    default Field fixed() {
        return new Field(prefix(), "fixed", "cate_fixed");
    }

    default Field fixed(String prefix) {
        return new Field(prefix, "fixed", "cate_fixed");
    }

    /**
    * 카테고리명
    */
    default Field name() {
        return new Field(prefix(), "name", "cate_name");
    }

    default Field name(String prefix) {
        return new Field(prefix, "name", "cate_name");
    }

    /**
    * 카테고리설명
    */
    default Field desc() {
        return new Field(prefix(), "desc", "cate_desc");
    }

    default Field desc(String prefix) {
        return new Field(prefix, "desc", "cate_desc");
    }

    /**
    * 카테고리값
    */
    default Field value() {
        return new Field(prefix(), "value", "cate_value");
    }

    default Field value(String prefix) {
        return new Field(prefix, "value", "cate_value");
    }

    /**
    * 카테고리확장값-json
    */
    default Field ext() {
        return new Field(prefix(), "ext", "cate_ext");
    }

    default Field ext(String prefix) {
        return new Field(prefix, "ext", "cate_ext");
    }

    /**
    * 정렬순서
    */
    default Field sort() {
        return new Field(prefix(), "sort", "cate_sort");
    }

    default Field sort(String prefix) {
        return new Field(prefix, "sort", "cate_sort");
    }

    /**
    * 삭제여부
    */
    default Field deleted() {
        return new Field(prefix(), "deleted", "cate_deleted");
    }

    default Field deleted(String prefix) {
        return new Field(prefix, "deleted", "cate_deleted");
    }

    /**
    * 등록자
    */
    default Field createdBy() {
        return new Field(prefix(), "createdBy", "cate_created_by");
    }

    default Field createdBy(String prefix) {
        return new Field(prefix, "createdBy", "cate_created_by");
    }

    /**
    * 등록일시
    */
    default Field createdDt() {
        return new Field(prefix(), "createdDt", "cate_created_dt");
    }

    default Field createdDt(String prefix) {
        return new Field(prefix, "createdDt", "cate_created_dt");
    }

    /**
    * 수정자
    */
    default Field modifiedBy() {
        return new Field(prefix(), "modifiedBy", "cate_modified_by");
    }

    default Field modifiedBy(String prefix) {
        return new Field(prefix, "modifiedBy", "cate_modified_by");
    }

    /**
    * 수정일시
    */
    default Field modifiedDt() {
        return new Field(prefix(), "modifiedDt", "cate_modified_dt");
    }

    default Field modifiedDt(String prefix) {
        return new Field(prefix, "modifiedDt", "cate_modified_dt");
    }

}

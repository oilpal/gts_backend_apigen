/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/FieldBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.site.domain.query.field;

import java.util.HashMap;
import java.util.Map;

import com.unvus.query.FieldUtil;
import com.unvus.query.frag.Field;

public interface SiteConfigField_ {

    Map<String, Field> _FIELD_MAP = new HashMap<String, Field>() {
        {
            FieldUtil.toMap(this, new Field("id", "sc_id"));
            FieldUtil.toMap(this, new Field("current", "sc_current"));
            FieldUtil.toMap(this, new Field("config", "sc_config"));
            FieldUtil.toMap(this, new Field("modifiedDt", "sc_modified_dt"));
            FieldUtil.toMap(this, new Field("modifiedBy", "sc_modified_by"));
        }
    };

    String prefix();

    /**
    * 아이디
    */
    default Field id() {
        return new Field(prefix(), "id", "sc_id");
    }

    default Field id(String prefix) {
        return new Field(prefix, "id", "sc_id");
    }

    /**
    * 현재 설정 여부
    */
    default Field current() {
        return new Field(prefix(), "current", "sc_current");
    }

    default Field current(String prefix) {
        return new Field(prefix, "current", "sc_current");
    }

    /**
    * 설정값
    */
    default Field config() {
        return new Field(prefix(), "config", "sc_config");
    }

    default Field config(String prefix) {
        return new Field(prefix, "config", "sc_config");
    }

    /**
    * 수정일시
    */
    default Field modifiedDt() {
        return new Field(prefix(), "modifiedDt", "sc_modified_dt");
    }

    default Field modifiedDt(String prefix) {
        return new Field(prefix, "modifiedDt", "sc_modified_dt");
    }

    /**
    * 수정자
    */
    default Field modifiedBy() {
        return new Field(prefix(), "modifiedBy", "sc_modified_by");
    }

    default Field modifiedBy(String prefix) {
        return new Field(prefix, "modifiedBy", "sc_modified_by");
    }

}

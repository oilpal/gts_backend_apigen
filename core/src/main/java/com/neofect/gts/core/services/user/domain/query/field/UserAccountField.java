/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/Field.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.user.domain.query.field;

import java.util.HashMap;
import java.util.Map;

import com.unvus.query.FieldSet;
import com.unvus.query.frag.Field;

public interface UserAccountField extends UserAccountField_, FieldSet {
    Map<String, Field> FIELD_MAP = new HashMap<String, Field>() {
        {
            putAll(_FIELD_MAP);
            /**
             * add your custom fields here
             **/
            // FieldUtil.toMap(this, new Field(prefix(), "custom_property", "custom_column"));
        }
    };

    /**
     * add your custom fields here
     **/
    // default Field MY_CUSTOM() {
    //     return new Field(prefix(), "custom_property", "custom_column");
    // }

    default String prefix() {
        return "";
    }

    default Field getField(String property) {
        return FIELD_MAP.get(property);
    }
}

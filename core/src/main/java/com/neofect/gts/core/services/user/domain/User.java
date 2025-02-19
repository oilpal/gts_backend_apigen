/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/Entity.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unvus.config.mybatis.pagination.Countable;
import com.neofect.gts.core.services.user.domain.query.field.UserField;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 사용자 상세
 */

@Alias("user")
@Data
public class User extends User_ implements Serializable, Countable {

    private static final long serialVersionUID = 1L;

    private int positionIdx = 0;

    @JsonIgnore
    public static UserField FIELDS(String prefix) {
        return new UserField() {
            public String prefix() {
                return prefix;
            }
        };
    }

    private UserAccount account;

}

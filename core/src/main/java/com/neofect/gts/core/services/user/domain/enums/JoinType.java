package com.neofect.gts.core.services.user.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.unvus.domain.EnumCode;

/**
 * 회원가입유형
 */
public enum JoinType implements EnumCode {

    GENERAL("g"),
    MINOR("m"),
    FOREIGNER("f")
    ;


    final String code;

    JoinType(String code) {
        this.code = code;
    }

    @JsonValue
    @Override
    public String getCode() {
        return code;
    }

    public static JoinType getByCode(String code) {
        for(JoinType c : values()) {
            if(c.code.equals(code)) return c;
        }
        return null;
    }
}

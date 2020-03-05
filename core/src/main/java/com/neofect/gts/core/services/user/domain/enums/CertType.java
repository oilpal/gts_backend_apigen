package com.neofect.gts.core.services.user.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.unvus.domain.EnumCode;

/**
 * 인증 방법
 */
public enum CertType implements EnumCode {

    CELL("c"),
    IPIN("i")
    ;


    final String code;

    CertType(String code) {
        this.code = code;
    }

    @JsonValue
    @Override
    public String getCode() {
        return code;
    }

    public static CertType getByCode(String code) {
        for(CertType c : values()) {
            if(c.code.equals(code)) return c;
        }
        return null;
    }
}

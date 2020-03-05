package com.neofect.gts.core.services.common.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.unvus.domain.EnumCode;


public enum RefTarget implements RefTargetIf {
    ADMIN("admin"),
    USER("user")
    ;


    final String code;

    RefTarget(String code) {
        this.code = code;
    }

    @JsonValue
    @Override
    public String getCode() {
        return code;
    }

    public static RefTarget getByCode(String code) {
        for(RefTarget c : values()) {
            if(c.code.equals(code)) return c;
        }
        return null;
    }
}



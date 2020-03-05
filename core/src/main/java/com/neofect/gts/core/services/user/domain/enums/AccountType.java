package com.neofect.gts.core.services.user.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 회원 계정 구분
 */
public enum AccountType implements AccountTypeIf {

    // 관리자
    ADMIN("a"),
    // 일반회원
    MEMBER("m")
    ;


    final String code;

    AccountType(String code) {
        this.code = code;
    }

    @JsonValue
    @Override
    public String getCode() {
        return code;
    }

    public static AccountType getByCode(String code) {
        for(AccountType c : values()) {
            if(c.code.equals(code)) return c;
        }
        return null;
    }
}

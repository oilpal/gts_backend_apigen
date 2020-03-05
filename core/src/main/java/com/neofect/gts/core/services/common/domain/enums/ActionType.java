package com.neofect.gts.core.services.common.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionType implements ActionTypeIf {
    /** 보기 */
    VIEW("view"),
    /** 공유 */
    SHARE("share"),
    /** 다운로드 */
    DOWNLOAD("download"),
    /** 출력 */
    PRINT("print"),
    /** 로그인 */
    LOGIN("login"),
    /** 로그아웃 */
    LOGOUT("logout"),
    /** 가입 */
    JOIN("join"),
    /** 탈퇴 */
    WITHDRAW("withdraw"),
    /** 삭제 */
    DELETE("delete"),
    /** 수정 */
    MODIFY("modify"),
    /** 로그인실패 */
    LOGIN_FAIL("login_fail"),
    /** 리스트 조회 */
    LIST("list"),
    /** 리스트 조회 */
    EXCEL("excel"),
    /** 삭제 유저 로그인 시도 */
    LOGIN_DEL("login_del")
    ;

    final String code;

    ActionType(String code) {
        this.code = code;
    }

    @JsonValue
    @Override
    public String getCode() {
        return code;
    }

    public static ActionType getByCode(String code) {
        for(ActionType c : values()) {
            if(c.code.equals(code)) return c;
        }
        return null;
    }
}

/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/EntityBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.sm.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * SM_코드_사용자
 */

/**
 * @see com.neofect.gts.core.services.sm.domain.SmAuthUser
 */
@Alias("sm_smAuthUser_")
@Data
public abstract class SmAuthUser_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 사번
    */
    protected String userId;
    /**
    * 성명
    */
    protected String userName;
    /**
    * 사용자 설명
    */
    protected String userDesc;
    /**
    * 로그인 ID
    */
    protected String loginId;
    /**
    * 비밀번호
    */
    protected String userPassword;
    /**
    * 사용구분
    */
    protected String useYn;
    /**
    * 회사코드
    */
    protected String companyCode;
    /**
    * 부서코드
    */
    protected String deptCode;
    /**
    * 회계부서조회구분
    */
    protected String amDeptDiv;
    /**
    * 회계담당자구분
    */
    protected String amUserDiv;
    /**
    * 도움말편집권한
    */
    protected String helpEditYn;
    /**
    * 로그인 시각
    */
    protected String loginTime;
    /**
    * IP 주소
    */
    protected String ipAddr;
    /**
    * Lock 번호
    */
    protected String lockNo;
    /**
    * 로그아웃 시각
    */
    protected String logoutTime;
    protected String infoPassword;
    protected String eisYn;
    protected String ammasterYn;
    protected String hrmasterYn;
    protected String epmasterYn;
    protected String amCompanyCode;
    protected String hrCompanyCode;
    protected String amDeptCode;
    protected String hrDeptCode;
    protected String rowInputEmpNo;
    protected LocalDateTime rowInputDate;
    protected String rowInputIp;
    protected String rowUpdateEmpNo;
    protected String rowUpdateDate;
    protected String rowUpdateIp;

    protected Map<String, Object> _meta = new HashMap();
}

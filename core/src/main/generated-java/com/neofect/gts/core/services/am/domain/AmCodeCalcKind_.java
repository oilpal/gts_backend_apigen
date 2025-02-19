/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/EntityBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.am.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * AM_재무제표_산식종류
 */

/**
 * @see com.neofect.gts.core.services.am.domain.AmCodeCalcKind
 */
@Alias("am_amCodeCalcKind_")
@Data
public abstract class AmCodeCalcKind_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 산식종류코드
    */
    protected String id;
    /**
    * 원가종류코드
    */
    protected String costKindCode;
    /**
    * 산식종류명칭
    */
    protected String calcKindName;
    /**
    * 표현금액단위
    */
    protected Integer amtUnit;
    /**
    * 절사구분
    */
    protected String cutDiv;
    /**
    * 입력담당
    */
    protected String inputDutyId;
    /**
    * 입력일시
    */
    protected String inputDate;
    /**
    * 변경담당
    */
    protected String chgDutyId;
    /**
    * 변경일시
    */
    protected String chgDate;
    protected String rowInputEmpNo;
    protected LocalDateTime rowInputDate;
    protected String rowInputIp;
    protected String rowUpdateEmpNo;
    protected String rowUpdateDate;
    protected String rowUpdateIp;

    protected Map<String, Object> _meta = new HashMap();
}

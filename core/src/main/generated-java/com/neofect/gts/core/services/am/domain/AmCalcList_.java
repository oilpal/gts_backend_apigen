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
 * AM_재무제표_산식종류별내역
 */

/**
 * @see com.neofect.gts.core.services.am.domain.AmCalcList
 */
@Alias("am_amCalcList_")
@Data
public abstract class AmCalcList_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    protected String companyCode;
    /**
    * 산식종류코드
    */
    protected String calcKindCode;
    /**
    * 산식내역코드
    */
    protected String calcListCode;
    /**
    * 산식내역명칭
    */
    protected String calcListName;
    /**
    * 출력위치
    */
    protected String printLoc;
    /**
    * 출력라인
    */
    protected String printLine;
    /**
    * 정산차대
    */
    protected String printDrcr;
    /**
    * 출력유무
    */
    protected String printYn;
    /**
    * bold_유무
    */
    protected String boldYn;
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

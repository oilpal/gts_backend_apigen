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
 * AM_코드_증빙
 */

/**
 * @see com.neofect.gts.core.services.am.domain.AmCodeEvidence
 */
@Alias("am_amCodeEvidence_")
@Data
public abstract class AmCodeEvidence_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 증빙코드
    */
    protected String id;
    /**
    * 증빙명칭
    */
    protected String evidenceName;
    /**
    * 증빙종류
    */
    protected String evidenceKind;
    /**
    * 매출매입구분
    */
    protected String salesDiv;
    /**
    * 과세분류구분
    */
    protected String evidenceDiv;
    /**
    * 세액발생여부
    */
    protected String vatYn;
    /**
    * 공급가+세액여부
    */
    protected String vatAddYn;
    /**
    * 회사세무차대구분
    */
    protected String taxCompDrcr;
    /**
    * 회사세무필수여부
    */
    protected String taxCompYn;
    /**
    * 거래처차대구분
    */
    protected String custDrcr;
    /**
    * 거래처필수여부
    */
    protected String custYn;
    /**
    * 사용여부
    */
    protected String useYn;
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

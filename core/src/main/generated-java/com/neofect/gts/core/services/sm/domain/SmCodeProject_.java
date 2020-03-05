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
 * SM_코드_차수사업
 */

/**
 * @see com.neofect.gts.core.services.sm.domain.SmCodeProject
 */
@Alias("sm_smCodeProject_")
@Data
public abstract class SmCodeProject_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 회사코드
    */
    protected String companyCode;
    /**
    * 차수사업코드
    */
    protected String projCode;
    /**
    * 차수사업명칭
    */
    protected String projName;
    /**
    * 차수사업단명칭
    */
    protected String projShortName;
    /**
    * 사업종류
    */
    protected String projDiv;
    /**
    * 총괄사업코드
    */
    protected String businessCode;
    /**
    * 원가사업코드
    */
    protected String costProjCode;
    /**
    * PM부서코드
    */
    protected String pmDeptCode;
    /**
    * 원가종류코드
    */
    protected String costKindCode;
    /**
    * 불공제율
    */
    protected Double undeductRate;
    /**
    * 공동공사여부
    */
    protected String joincontYn;
    /**
    * 면세여부
    */
    protected String vatYn;
    /**
    * 건설중인자산여부
    */
    protected String assetYn;
    /**
    * 사용여부
    */
    protected String useYn;
    /**
    * 사용종료일
    */
    protected String terminateDate;
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

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
 * @see com.neofect.gts.core.services.sm.domain.SmManualDetail
 */
@Alias("sm_smManualDetail_")
@Data
public abstract class SmManualDetail_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 회사코드
    */
    protected String companyCode;
    /**
    * 시스템코드
    */
    protected String sysId;
    /**
    * 메뉴코드
    */
    protected String pgmCode;
    /**
    * 메뉴구분
    */
    protected String menuTag;
    /**
    * 번호
    */
    protected Integer menuSeq;
    /**
    * 항목
    */
    protected String menuTitle;
    /**
    * 내용
    */
    protected String menuContent;
    /**
    * 순서
    */
    protected Integer sortOrder;
    /**
    * 입력일자
    */
    protected LocalDateTime rowInputDate;
    /**
    * 입력IP
    */
    protected String rowInputIp;
    /**
    * 입력사번
    */
    protected String rowInputEmpNo;
    /**
    * 수정일자
    */
    protected LocalDateTime rowUpdateDate;
    /**
    * 수정IP
    */
    protected String rowUpdateIp;
    /**
    * 수정사번
    */
    protected String rowUpdateEmpNo;

    protected Map<String, Object> _meta = new HashMap();
}

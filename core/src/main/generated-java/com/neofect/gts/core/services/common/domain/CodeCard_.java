/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/EntityBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * 코드_법인카드
 */

/**
 * @see com.neofect.gts.core.services.common.domain.CodeCard
 */
@Alias("common_codeCard_")
@Data
public abstract class CodeCard_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 카드번호
    */
    protected String id;
    /**
    * 카드회사코드
    */
    protected String cardDiv;
    /**
    * 결제계좌번호
    */
    protected String depositno;
    /**
    * 월결제일
    */
    protected String dd;
    /**
    * 유효기간
    */
    protected String yyyymm;
    /**
    * 사용여부
    */
    protected String useYn;
    /**
    * 지사ID
    */
    protected String deptId;
    /**
    * 사번
    */
    protected String memberId;
    protected String rowInputEmpNo;
    protected LocalDateTime rowInputDate;
    protected String rowInputIp;
    protected String rowUpdateEmpNo;
    protected String rowUpdateDate;
    protected String rowUpdateIp;

    protected Map<String, Object> _meta = new HashMap();
}

/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/EntityBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.member.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * 사원_근태
 */

/**
 * @see com.neofect.gts.core.services.member.domain.MemberClock
 */
@Alias("member_memberClock_")
@Data
public abstract class MemberClock_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 사번
    */
    protected String memberId;
    /**
    * 출결일자
    */
    protected LocalDateTime clockDate;
    /**
    * 출결구분코드
    */
    protected String clockDiv;
    /**
    * 출결여부
    */
    protected String clockYn;
    /**
    * 비고
    */
    protected String remark;
    protected String ip;
    protected String rowInputEmpNo;
    protected LocalDateTime rowInputDate;
    protected String rowInputIp;
    protected String rowUpdateEmpNo;
    protected String rowUpdateDate;
    protected String rowUpdateIp;

    protected Map<String, Object> _meta = new HashMap();
}

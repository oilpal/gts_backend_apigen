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
 * @see com.neofect.gts.core.services.common.domain.CodeAccount
 */
@Alias("common_codeAccount_")
@Data
public abstract class CodeAccount_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 계정코드
    */
    protected String id;
    /**
    * 차대구분 C:대변, D:차변
    */
    protected String cd;
    /**
    * 계정명
    */
    protected String acntName;
    /**
    * 상위계정코드
    */
    protected String acntParent;
    /**
    * 사용여부 Y:사용 N:미사용
    */
    protected String useYn;
    protected String rowInputEmpNo;
    protected LocalDateTime rowInputDate;
    protected String rowInputIp;
    protected String rowUpdateEmpNo;
    protected String rowUpdateDate;
    protected String rowUpdateIp;

    protected Map<String, Object> _meta = new HashMap();
}

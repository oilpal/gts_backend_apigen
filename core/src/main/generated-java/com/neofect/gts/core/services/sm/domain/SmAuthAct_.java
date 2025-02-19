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
 * @see com.neofect.gts.core.services.sm.domain.SmAuthAct
 */
@Alias("sm_smAuthAct_")
@Data
public abstract class SmAuthAct_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    protected String companyCode;
    protected String actCode;
    protected String actName;
    protected LocalDateTime rowInputDate;
    protected String rowInputEmpNo;
    protected String rowInputIp;
    protected LocalDateTime rowUpdateDate;
    protected String rowUpdateEmpNo;
    protected String rowUpdateIp;
    protected String actTag1;
    protected String actTag2;
    protected String actTag3;
    protected String actTag4;
    protected String actTag5;

    protected Map<String, Object> _meta = new HashMap();
}

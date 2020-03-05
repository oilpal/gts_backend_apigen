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
 * @see com.neofect.gts.core.services.sm.domain.SmAuthActUser
 */
@Alias("sm_smAuthActUser_")
@Data
public abstract class SmAuthActUser_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    protected String companyCode;
    protected String actCode;
    protected String userId;
    protected LocalDateTime rowInputDate;
    protected String rowInputEmpNo;
    protected String rowInputIp;
    protected LocalDateTime rowUpdateDate;
    protected String rowUpdateEmpNo;
    protected String rowUpdateIp;

    protected Map<String, Object> _meta = new HashMap();
}

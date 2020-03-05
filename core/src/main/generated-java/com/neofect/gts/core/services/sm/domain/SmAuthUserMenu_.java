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
 * @see com.neofect.gts.core.services.sm.domain.SmAuthUserMenu
 */
@Alias("sm_smAuthUserMenu_")
@Data
public abstract class SmAuthUserMenu_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    protected String companyCode;
    protected String userId;
    protected String sysId;
    protected String pgmCode;
    protected String authI;
    protected String authR;
    protected String authD;
    protected String authP;
    protected String authE;
    protected String menuCode;
    protected String menuName;
    protected Integer sortOrder;
    protected LocalDateTime rowInputDate;
    protected String rowInputEmpNo;
    protected String rowInputIp;
    protected LocalDateTime rowUpdateDate;
    protected String rowUpdateIp;
    protected String rowUpdateEmpNo;
    protected String masterYn;
    protected String authYn;
    protected String rootId;

    protected Map<String, Object> _meta = new HashMap();
}

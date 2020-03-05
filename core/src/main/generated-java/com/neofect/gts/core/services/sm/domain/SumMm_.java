/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/EntityBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.sm.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * @see com.neofect.gts.core.services.sm.domain.SumMm
 */
@Alias("sm_sumMm_")
@Data
public abstract class SumMm_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    protected String deptId;
    protected String yyyymm;
    protected String acntCode;
    protected Long amt;
    /**
    * 1:예정 9:확정
    */
    protected String status;

    protected Map<String, Object> _meta = new HashMap();
}

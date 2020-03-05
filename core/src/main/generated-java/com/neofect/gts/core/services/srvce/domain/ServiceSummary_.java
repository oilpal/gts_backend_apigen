/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/EntityBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.srvce.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * @see com.neofect.gts.core.services.srvce.domain.ServiceSummary
 */
@Alias("srvce_serviceSummary_")
@Data
public abstract class ServiceSummary_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    protected Integer custId;
    protected String deptId;
    protected String yyyymm;
    protected Integer seq;
    protected String stime;
    protected String smin;
    protected String etime;
    protected String emin;
    protected Integer productId;
    protected Integer serviceAmt;
    protected String serviceDiv;
    protected String productCode;
    protected String productName;
    protected String custLevel;
    protected String appRate;
    protected Integer serviceCnt;
    protected Integer totalAmt;
    protected String serviceDays;
    protected Integer totalBAmt;
    protected String memberId;
    protected String serviceYn;

    protected Map<String, Object> _meta = new HashMap();
}

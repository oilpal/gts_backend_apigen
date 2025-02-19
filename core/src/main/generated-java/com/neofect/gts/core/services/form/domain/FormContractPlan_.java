/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/EntityBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.form.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * @see com.neofect.gts.core.services.form.domain.FormContractPlan
 */
@Alias("form_formContractPlan_")
@Data
public abstract class FormContractPlan_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    protected Integer formSeq;
    protected Integer planSeq;
    protected String monYn;
    protected String tueYn;
    protected String wedYn;
    protected String thuYn;
    protected String friYn;
    protected String satYn;
    protected String sunYn;
    protected String fromHour;
    protected String fromMin;
    protected String toHour;
    protected String toMin;
    protected String weekYn;
    protected String week2Yn;
    protected String monthYn;
    protected String rowInputEmpNo;
    protected LocalDateTime rowInputDate;
    protected String rowInputIp;
    protected String rowUpdateEmpNo;
    protected String rowUpdateDate;
    protected String rowUpdateIp;

    protected Map<String, Object> _meta = new HashMap();
}

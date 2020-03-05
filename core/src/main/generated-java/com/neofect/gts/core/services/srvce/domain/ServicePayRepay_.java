/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/EntityBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.srvce.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * @see com.neofect.gts.core.services.srvce.domain.ServicePayRepay
 */
@Alias("srvce_servicePayRepay_")
@Data
public abstract class ServicePayRepay_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 지사ID
    */
    protected String deptId;
    /**
    * 고객ID
    */
    protected Integer custId;
    /**
    * 집계년월
    */
    protected String yyyymm;
    /**
    * 지불일자
    */
    protected LocalDateTime payDate;
    /**
    * 지불금액
    */
    protected Integer payAmt;
    /**
    * 현금결재
    */
    protected Integer cashAmt;
    /**
    * 카드결재
    */
    protected Integer cardAmt;
    /**
    * 구청청구금
    */
    protected Integer reqAmt;
    /**
    * 입력자
    */
    protected Long enterId;
    /**
    * 입력일자
    */
    protected LocalDateTime enterDate;
    /**
    * 수정자
    */
    protected Long editId;
    /**
    * 수정일자
    */
    protected LocalDateTime editDate;
    /**
    * 적요
    */
    protected String remark;
    /**
    * 무통장결재
    */
    protected Integer bankAmt;
    /**
    * 카드결재
    */
    protected String depositno;
    protected String rowInputEmpNo;
    protected LocalDateTime rowInputDate;
    protected String rowInputIp;
    protected String rowUpdateEmpNo;
    protected String rowUpdateDate;
    protected String rowUpdateIp;

    protected Map<String, Object> _meta = new HashMap();
}

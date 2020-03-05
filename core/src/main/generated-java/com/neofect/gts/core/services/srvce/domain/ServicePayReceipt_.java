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
 * @see com.neofect.gts.core.services.srvce.domain.ServicePayReceipt
 */
@Alias("srvce_servicePayReceipt_")
@Data
public abstract class ServicePayReceipt_ implements Serializable {

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
    protected String checkYn;
    protected String rowInputEmpNo;
    protected LocalDateTime rowInputDate;
    protected String rowInputIp;
    protected String rowUpdateEmpNo;
    protected String rowUpdateDate;
    protected String rowUpdateIp;
    /**
    * 청구일자
    */
    protected String reqYymm;
    /**
    * 입금자
    */
    protected String depositName;
    /**
    * 지불금액_비급여
    */
    protected Integer payAmtB;
    /**
    * 현금결재_비급여
    */
    protected Integer cashAmtB;
    /**
    * 카드결재_비급여
    */
    protected Integer cardAmtB;
    /**
    * 무통장결재_비급여
    */
    protected Integer bankAmtB;
    /**
    * 가상계좌결제
    */
    protected Integer vbankAmt;
    /**
    * 지로결제
    */
    protected Integer jiroAmt;
    /**
    * 결제가상계좌
    */
    protected String vbankDeposit;

    protected Map<String, Object> _meta = new HashMap();
}

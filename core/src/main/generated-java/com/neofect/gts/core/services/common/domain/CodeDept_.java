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
 * 코드_지사코드
 */

/**
 * @see com.neofect.gts.core.services.common.domain.CodeDept
 */
@Alias("common_codeDept_")
@Data
public abstract class CodeDept_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 지사ID
    */
    protected String id;
    /**
    * 지사명
    */
    protected String deptName;
    /**
    * 직영구분
    */
    protected String operDiv;
    /**
    * 기관코드
    */
    protected String serviceCode;
    /**
    * 우편번호
    */
    protected String zipCode;
    /**
    * 주소1
    */
    protected String addr1;
    /**
    * 주소2
    */
    protected String addr2;
    /**
    * 전화번호
    */
    protected String phone;
    /**
    * 팩스번호
    */
    protected String fax;
    /**
    * 지사장명
    */
    protected String ownerName;
    /**
    * 지사장핸드폰
    */
    protected String ownerHp;
    /**
    * 소장명
    */
    protected String managerName;
    /**
    * 소장핸드폰
    */
    protected String managerHp;
    /**
    * 사업자번호
    */
    protected String bizNo;
    /**
    * 사업자명
    */
    protected String bizName;
    /**
    * 업태
    */
    protected String bizUptae;
    /**
    * 업종
    */
    protected String bizUpjong;
    /**
    * 사업장주소1
    */
    protected String bizAddr1;
    /**
    * 사업장주소2
    */
    protected String bizAddr2;
    /**
    * 임차보증금
    */
    protected Long rentBamt;
    /**
    * 월임대료
    */
    protected Long remtMamt;
    /**
    * 초기운영비
    */
    protected Long operAmt;
    protected String proxyDeptid;
    /**
    * 물류센터 여부
    */
    protected String salecenterYn;
    /**
    * 물류센터 ID
    */
    protected String upperDeptid;
    protected String useYn;
    /**
    * 물품요청 초기선택 물류센터
    */
    protected String salecenterMain;
    protected String rowInputEmpNo;
    protected LocalDateTime rowInputDate;
    protected String rowInputIp;
    protected String rowUpdateEmpNo;
    protected String rowUpdateDate;
    protected String rowUpdateIp;
    /**
    * 담당자
    */
    protected String chargeMan;
    /**
    * 담당자번호
    */
    protected String chargeTel;
    /**
    * 담당자FAX
    */
    protected String chargeFax;
    /**
    * 급여지급방법
    */
    protected String payCalcDiv;
    protected String oldDeptId;

    protected Map<String, Object> _meta = new HashMap();
}

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
 * 코드_구분코드
 */

/**
 * @see com.neofect.gts.core.services.common.domain.CodeComdiv
 */
@Alias("common_codeComdiv_")
@Data
public abstract class CodeComdiv_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 분류코드
    */
    protected String comsecCode;
    /**
    * 구분코드
    */
    protected String comdivCode;
    /**
    * 입력시사용여부
    */
    protected String inputYn;
    /**
    * 구분명칭
    */
    protected String comdivName;
    /**
    * 대중소구분
    */
    protected String lmsTag;
    /**
    * 구분종류1
    */
    protected String kind1;
    /**
    * 구분내용1
    */
    protected String name1;
    /**
    * 구분종류2
    */
    protected String kind2;
    /**
    * 구분내용2
    */
    protected String name2;
    /**
    * 적용시작일
    */
    protected LocalDateTime startDate;
    /**
    * 적용종료일
    */
    protected LocalDateTime endDate;
    /**
    * 사용 Y
    */
    protected String useYn;
    /**
    * 출력순번
    */
    protected Integer printSeq;
    protected String rowInputEmpNo;
    protected LocalDateTime rowInputDate;
    protected String rowInputIp;
    protected String rowUpdateEmpNo;
    protected String rowUpdateDate;
    protected String rowUpdateIp;
    /**
    * 비고
    */
    protected String remark;

    protected Map<String, Object> _meta = new HashMap();
}

/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/domain/EntityBase.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.core.services.common.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.neofect.gts.core.services.common.repository.AddrRepository;
import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * 공통-주소
 */

/**
 * Generated Files
 * <dl>
 *     <dt>model_</dt>
 *     <dd>
 *         @see Addr_
 *     </dd>
 *     <dt>repository_</dt>
 *     <dd>
 *         @see AddrRepository
 *     </dd>
 * </ul>
 *
 * Extended Files
 * <dl>
 *     <dt>model</dt>
 *     <dd>
 *         @see Addr
 *     </dd>
 *     <dt>repository</dt>
 *     <dd>
 *         @see AddrRepository
 *     </dd>
 * </ul>
 *
 */
@Alias("common_addr_")
@Data
public abstract class Addr_ implements Serializable {

    private static final long serialVersionUID = 1L;

    // Raw attributes
    /**
    * 아이디
    */
    protected Long id;
    /**
    * 참조대상
    */
    protected String refTarget;
    /**
    * 참조키
    */
    protected Long refTargetKey;
    /**
    * 참조타입
    */
    protected String refTargetType;
    /**
    * 주소별칭
    */
    protected String aliasName;
    /**
    * 시도코드
    */
    protected String sidoCode;
    /**
    * 구군코드
    */
    protected String gugunCode;
    /**
    * 법정동코드
    */
    protected String lglCode;
    /**
    * 시도
    */
    protected String sido;
    /**
    * 구군
    */
    protected String gugun;
    /**
    * 읍면동
    */
    protected String dong;
    /**
    * 도로명 주소-우편번호
    */
    protected String roadZip;
    /**
    * 도로명 주소-주소고정
    */
    protected String roadAddress;
    /**
    * 지번 주소-우편번호
    */
    protected String ltnoZip;
    /**
    * 지번 주소-주소고정
    */
    protected String ltnoAddress;
    /**
    * 주소상세
    */
    protected String addressDetail;
    /**
    * GIS 좌표
    */
    protected Object point;
    /**
    * 정렬순서
    */
    protected Integer sort;

    protected Map<String, Object> _meta = new HashMap();
}

/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.member;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.common.collect.ImmutableMap;
import com.neofect.gts.core.services.member.domain.MemberVacationDate;
import com.neofect.gts.core.services.member.service.MemberVacationDateService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link MemberVacationDate}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class MemberVacationDateResource {

    private final MemberVacationDateService memberVacationDateService;

    public MemberVacationDateResource(MemberVacationDateService memberVacationDateService) {
        this.memberVacationDateService = memberVacationDateService;
    }

    //region ------------------------------------------------------------------------------------------------ memberVacationDate API

    /**
     *
     */
    @GetMapping(value = "/member-vacation-date", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MemberVacationDate>> listMemberVacationDate(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<MemberVacationDate> memberVacationDateList = memberVacationDateService.listMemberVacationDate(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(memberVacationDateList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/member-vacation-date/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = memberVacationDateService.listMemberVacationDateCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/member-vacation-date/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberVacationDate> getEmptyMemberVacationDate() {
        MemberVacationDate memberVacationDate = new MemberVacationDate();
        return new ResponseEntity<>(memberVacationDate, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/member-vacation-date/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberVacationDate> getMemberVacationDate(@PathVariable("id") Long id) {
        MemberVacationDate memberVacationDate = memberVacationDateService.getMemberVacationDate(id);
        return new ResponseEntity<>(memberVacationDate, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/member-vacation-date")
    public ResponseEntity<Void> addMemberVacationDate(@RequestBody MemberVacationDate memberVacationDate) {
        memberVacationDateService.saveMemberVacationDate(memberVacationDate);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/member-vacation-date/{id}")
    public ResponseEntity<Void> updateMemberVacationDate(@PathVariable("id") Long id, @RequestBody MemberVacationDate memberVacationDate) throws Exception {
        // if (!id.equals(memberVacationDate.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        memberVacationDateService.saveMemberVacationDate(memberVacationDate);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/member-vacation-date/{id}")
    public ResponseEntity<Void> removeMemberVacationDate(@PathVariable("id") Long id) {
        memberVacationDateService.removeMemberVacationDate(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

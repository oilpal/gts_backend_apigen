/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.sm;

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
import com.neofect.gts.core.services.sm.domain.SmAuthGroupUsers;
import com.neofect.gts.core.services.sm.service.SmAuthGroupUsersService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link SmAuthGroupUsers}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class SmAuthGroupUsersResource {

    private final SmAuthGroupUsersService smAuthGroupUsersService;

    public SmAuthGroupUsersResource(SmAuthGroupUsersService smAuthGroupUsersService) {
        this.smAuthGroupUsersService = smAuthGroupUsersService;
    }

    //region ------------------------------------------------------------------------------------------------ smAuthGroupUsers API

    /**
     *
     */
    @GetMapping(value = "/sm-auth-group-users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SmAuthGroupUsers>> listSmAuthGroupUsers(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<SmAuthGroupUsers> smAuthGroupUsersList = smAuthGroupUsersService.listSmAuthGroupUsers(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(smAuthGroupUsersList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/sm-auth-group-users/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = smAuthGroupUsersService.listSmAuthGroupUsersCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/sm-auth-group-users/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmAuthGroupUsers> getEmptySmAuthGroupUsers() {
        SmAuthGroupUsers smAuthGroupUsers = new SmAuthGroupUsers();
        return new ResponseEntity<>(smAuthGroupUsers, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/sm-auth-group-users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmAuthGroupUsers> getSmAuthGroupUsers(@PathVariable("id") Long id) {
        SmAuthGroupUsers smAuthGroupUsers = smAuthGroupUsersService.getSmAuthGroupUsers(id);
        return new ResponseEntity<>(smAuthGroupUsers, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/sm-auth-group-users")
    public ResponseEntity<Void> addSmAuthGroupUsers(@RequestBody SmAuthGroupUsers smAuthGroupUsers) {
        smAuthGroupUsersService.saveSmAuthGroupUsers(smAuthGroupUsers);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/sm-auth-group-users/{id}")
    public ResponseEntity<Void> updateSmAuthGroupUsers(@PathVariable("id") Long id, @RequestBody SmAuthGroupUsers smAuthGroupUsers) throws Exception {
        // if (!id.equals(smAuthGroupUsers.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        smAuthGroupUsersService.saveSmAuthGroupUsers(smAuthGroupUsers);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/sm-auth-group-users/{id}")
    public ResponseEntity<Void> removeSmAuthGroupUsers(@PathVariable("id") Long id) {
        smAuthGroupUsersService.removeSmAuthGroupUsers(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

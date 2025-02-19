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
import com.neofect.gts.core.services.sm.domain.SmAuthUserMenu;
import com.neofect.gts.core.services.sm.service.SmAuthUserMenuService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link SmAuthUserMenu}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class SmAuthUserMenuResource {

    private final SmAuthUserMenuService smAuthUserMenuService;

    public SmAuthUserMenuResource(SmAuthUserMenuService smAuthUserMenuService) {
        this.smAuthUserMenuService = smAuthUserMenuService;
    }

    //region ------------------------------------------------------------------------------------------------ smAuthUserMenu API

    /**
     *
     */
    @GetMapping(value = "/sm-auth-user-menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SmAuthUserMenu>> listSmAuthUserMenu(@RequestParam(value = "q", required = false) Map<String, Object> q)
            throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<SmAuthUserMenu> smAuthUserMenuList = smAuthUserMenuService.listSmAuthUserMenu(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(smAuthUserMenuList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/sm-auth-user-menu/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = smAuthUserMenuService.listSmAuthUserMenuCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/sm-auth-user-menu/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmAuthUserMenu> getEmptySmAuthUserMenu() {
        SmAuthUserMenu smAuthUserMenu = new SmAuthUserMenu();
        return new ResponseEntity<>(smAuthUserMenu, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/sm-auth-user-menu/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmAuthUserMenu> getSmAuthUserMenu(@PathVariable("id") Long id) {
        SmAuthUserMenu smAuthUserMenu = smAuthUserMenuService.getSmAuthUserMenu(id);
        return new ResponseEntity<>(smAuthUserMenu, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/sm-auth-user-menu")
    public ResponseEntity<Void> addSmAuthUserMenu(@RequestBody SmAuthUserMenu smAuthUserMenu) {
        smAuthUserMenuService.saveSmAuthUserMenu(smAuthUserMenu);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/sm-auth-user-menu/{id}")
    public ResponseEntity<Void> updateSmAuthUserMenu(@PathVariable("id") Long id, @RequestBody SmAuthUserMenu smAuthUserMenu) throws Exception {
        // if (!id.equals(smAuthUserMenu.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        smAuthUserMenuService.saveSmAuthUserMenu(smAuthUserMenu);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/sm-auth-user-menu/{id}")
    public ResponseEntity<Void> removeSmAuthUserMenu(@PathVariable("id") Long id) {
        smAuthUserMenuService.removeSmAuthUserMenu(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

/*
 * Source code generated by UnvUS.
 * Copyright(c) 2017 unvus.com All rights reserved.
 * Template skrull-pack-mybatis:src/main/java/rest/Rest.e.vm.java
 * Template is part of project: https://git.unvus.com/unvus/opensource/pack-unvus-mybatis
 */
package com.neofect.gts.web.cms.rest.zp;

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
import com.neofect.gts.core.services.zp.domain.ZAuth;
import com.neofect.gts.core.services.zp.service.ZAuthService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link ZAuth}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ZAuthResource {

    private final ZAuthService zAuthService;

    public ZAuthResource(ZAuthService zAuthService) {
        this.zAuthService = zAuthService;
    }

    //region ------------------------------------------------------------------------------------------------ zAuth API

    /**
     *
     */
    @GetMapping(value = "/z-auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZAuth>> listZAuth(@RequestParam(value = "q", required = false) Map<String, Object> q) throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<ZAuth> zAuthList = zAuthService.listZAuth(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(zAuthList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/z-auth/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = zAuthService.listZAuthCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/z-auth/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZAuth> getEmptyZAuth() {
        ZAuth zAuth = new ZAuth();
        return new ResponseEntity<>(zAuth, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/z-auth/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZAuth> getZAuth(@PathVariable("id") Long id) {
        ZAuth zAuth = zAuthService.getZAuth(id);
        return new ResponseEntity<>(zAuth, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/z-auth")
    public ResponseEntity<Void> addZAuth(@RequestBody ZAuth zAuth) {
        zAuthService.saveZAuth(zAuth);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/z-auth/{id}")
    public ResponseEntity<Void> updateZAuth(@PathVariable("id") Long id, @RequestBody ZAuth zAuth) throws Exception {
        // if (!id.equals(zAuth.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        zAuthService.saveZAuth(zAuth);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/z-auth/{id}")
    public ResponseEntity<Void> removeZAuth(@PathVariable("id") Long id) {
        zAuthService.removeZAuth(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

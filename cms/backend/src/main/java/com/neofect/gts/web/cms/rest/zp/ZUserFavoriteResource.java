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
import com.neofect.gts.core.services.zp.domain.ZUserFavorite;
import com.neofect.gts.core.services.zp.service.ZUserFavoriteService;
import com.unvus.web.util.PaginationUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest for {@link ZUserFavorite}<br/>
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ZUserFavoriteResource {

    private final ZUserFavoriteService zUserFavoriteService;

    public ZUserFavoriteResource(ZUserFavoriteService zUserFavoriteService) {
        this.zUserFavoriteService = zUserFavoriteService;
    }

    //region ------------------------------------------------------------------------------------------------ zUserFavorite API

    /**
     *
     */
    @GetMapping(value = "/z-user-favorite", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZUserFavorite>> listZUserFavorite(@RequestParam(value = "q", required = false) Map<String, Object> q) throws URISyntaxException {
        if (q == null) {
            q = new HashMap();
        }

        List<ZUserFavorite> zUserFavoriteList = zUserFavoriteService.listZUserFavorite(q);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();

        return new ResponseEntity<>(zUserFavoriteList, headers, HttpStatus.OK);
    }

    /**
     * get count
     * @return
     */
    @GetMapping(value = "/z-user-favorite/_count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCount(@RequestParam(value = "q", required = false) Map<String, Object> q) {
        int count = zUserFavoriteService.listZUserFavoriteCnt(q);

        return new ResponseEntity<>(ImmutableMap.of("count", count), HttpStatus.OK);
    }

    /**
     * get empty object
     * @return
     */
    @GetMapping(value = "/z-user-favorite/_empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZUserFavorite> getEmptyZUserFavorite() {
        ZUserFavorite zUserFavorite = new ZUserFavorite();
        return new ResponseEntity<>(zUserFavorite, HttpStatus.OK);
    }

    /**
     * get
     */
    @GetMapping(value = "/z-user-favorite/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZUserFavorite> getZUserFavorite(@PathVariable("id") Long id) {
        ZUserFavorite zUserFavorite = zUserFavoriteService.getZUserFavorite(id);
        return new ResponseEntity<>(zUserFavorite, HttpStatus.OK);
    }

    /**
     * add
     */
    @PostMapping("/z-user-favorite")
    public ResponseEntity<Void> addZUserFavorite(@RequestBody ZUserFavorite zUserFavorite) {
        zUserFavoriteService.saveZUserFavorite(zUserFavorite);

        return ResponseEntity.ok().build();
    }

    /**
     * modify
     */
    @PutMapping("/z-user-favorite/{id}")
    public ResponseEntity<Void> updateZUserFavorite(@PathVariable("id") Long id, @RequestBody ZUserFavorite zUserFavorite) throws Exception {
        // if (!id.equals(zUserFavorite.getId())) {
        //     return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // }
        zUserFavoriteService.saveZUserFavorite(zUserFavorite);
        return ResponseEntity.ok().build();
    }

    /**
     * delete
     */
    @DeleteMapping("/z-user-favorite/{id}")
    public ResponseEntity<Void> removeZUserFavorite(@PathVariable("id") Long id) {
        zUserFavoriteService.removeZUserFavorite(id);
        return ResponseEntity.ok().build();
    }

    //endregion

}

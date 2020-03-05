package com.neofect.gts.web.cms.rest.user;

import com.neofect.gts.core.services.common.service.ActionLogService;
import com.neofect.gts.core.services.user.domain.User;
import com.neofect.gts.core.services.user.domain.UserAccount;
import com.neofect.gts.core.services.user.service.UserService;
import com.unvus.util.SecurityUtils;
import com.unvus.web.util.PaginationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserResource {


    private final UserService userService;
    private final ActionLogService actionLogService;

    public UserResource(UserService userService, ActionLogService actionLogService) {
        this.userService = userService;
        this.actionLogService = actionLogService;
    }


    /**
     * listUser : 전체회원 조회
     * @param params
     * @return
     * @throws URISyntaxException
     */
    @GetMapping(value="/user"  ,produces    = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> listUser(@RequestParam(value="q")  Map<String, Object> params) throws URISyntaxException {

    	List<User> userList = userService.listUser(params);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();
        return new ResponseEntity<>(userList,headers,HttpStatus.OK);
    }

    /**
     * getUser : 한 회원 조회
     * @param id
     * @return
     * @throws URISyntaxException
     */
    @GetMapping(value="/user/{id}"  ,produces    = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) throws URISyntaxException {
        User user = userService.getUser(id);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();
        return new ResponseEntity<>(user,headers,HttpStatus.OK);
    }

    /**
     * updateUser: 한 회원 수정
     * @param id
     * @param user
     * @return
     * @throws Exception
     */
    @PutMapping("/user/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_CMS')")
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
        if (!id.equals(user.getId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    /**
     * idcheck : 아이디 중복
     * @param params
     * @return
     * @throws URISyntaxException
     */
    @GetMapping(value="/user/_count"  ,produces    = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getUserCnt(@RequestParam(value="q")  Map<String, Object> params) throws URISyntaxException {
        Integer result = userService.listUserCnt(params);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders();
        return new ResponseEntity<>(result,headers,HttpStatus.OK);
    }


    /**
     * @param userAccount
     * @return
     */
    @PostMapping("/user")
    public ResponseEntity<Void> addUser(@RequestBody UserAccount userAccount) throws Exception {
        userService.saveUserAccount(userAccount);
        return  ResponseEntity.ok().build();
    }

}

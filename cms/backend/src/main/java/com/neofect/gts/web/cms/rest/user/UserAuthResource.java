package com.neofect.gts.web.cms.rest.user;

import com.neofect.gts.web.cms.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserAuthResource {

    @Value("${application.recaptcha-key}")
    private String recaptchaKey;

    @GetMapping("/authenticate/fail")
    public ResponseEntity<Map> getAuthenticationFailureInfo(HttpServletRequest request) {

        HttpSession session = request.getSession();

        Integer failureCount = 0;
        if (session.getAttribute(Constants.LOGIN_FAILURE_COUNT) != null) {
            failureCount = (Integer) session.getAttribute(Constants.LOGIN_FAILURE_COUNT);
        }

        Map res = new HashMap();
        res.put("failureCount", failureCount);
        res.put("reCaptchaKey", this.recaptchaKey);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}

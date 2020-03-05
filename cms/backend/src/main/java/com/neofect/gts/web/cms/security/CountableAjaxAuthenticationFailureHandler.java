package com.neofect.gts.web.cms.security;

import com.neofect.gts.core.services.common.domain.enums.ActionType;
import com.neofect.gts.core.services.common.domain.enums.RefTarget;
import com.neofect.gts.core.services.common.service.ActionLogService;
import com.neofect.gts.core.services.user.service.UserService;
import com.neofect.gts.web.cms.config.Constants;
import com.unvus.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class CountableAjaxAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Value("${application.recaptcha-key}")
    private String recaptchaKey;
    protected final ActionLogService actionLogService;
    protected final String siteType;

    @Autowired
    UserService userService;

    public CountableAjaxAuthenticationFailureHandler(ActionLogService actionLogService, String siteType) {
        this.actionLogService = actionLogService;
        this.siteType = siteType;
    }

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

    	String loginId = request.getParameter("j_username");
        try {
            actionLogService.addActionLog(RefTarget.ADMIN, siteType, ActionType.LOGIN_FAIL, loginId);
        }catch(Exception e){
            e.printStackTrace();
        }

        addLoginFailureCount(request.getSession());
        Integer failureCount = getLoginFailureCount(request.getSession());

        HashMap<String, Object> errorMessage = new HashMap<String, Object>();
        errorMessage.put("reCaptchaKey", recaptchaKey);
        errorMessage.put("failureCount", failureCount);
        response.sendError(401, JsonUtil.toJson(errorMessage));

    }

    protected Integer getLoginFailureCount(HttpSession session) {
        Integer failureCount = 0;
        if (session.getAttribute(Constants.LOGIN_FAILURE_COUNT) != null) {
            failureCount = (Integer) session.getAttribute(Constants.LOGIN_FAILURE_COUNT);
        }
        return failureCount;
    }

    protected void addLoginFailureCount(HttpSession session) {
        Integer failureCount = getLoginFailureCount(session);
        failureCount ++;
        session.setAttribute(Constants.LOGIN_FAILURE_COUNT, failureCount);
    }
}

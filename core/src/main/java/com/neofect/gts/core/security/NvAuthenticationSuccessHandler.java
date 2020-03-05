package com.neofect.gts.core.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neofect.gts.core.config.Constants;
import com.neofect.gts.core.config.Constants;
import com.neofect.gts.core.services.common.domain.ActionLog;
import com.neofect.gts.core.services.common.domain.enums.ActionType;
import com.neofect.gts.core.services.common.domain.enums.RefTarget;
import com.neofect.gts.core.services.common.service.ActionLogService;
import com.neofect.gts.core.services.user.domain.User;
import com.neofect.gts.core.services.user.domain.UserAccount;
import com.neofect.gts.core.services.user.domain.enums.AccountType;
import com.neofect.gts.core.services.user.service.UserService;
import com.unvus.web.util.WebUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class NvAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    protected final ObjectMapper mapper;
    protected final UserService userService;
    protected final ActionLogService actionLogService;
    protected final String siteType;

    private RequestCache requestCache = new HttpSessionRequestCache();

    public NvAuthenticationSuccessHandler(ObjectMapper mapper, UserService userService, ActionLogService actionLogService, String siteType) {
        this.mapper = mapper;
        this.userService = userService;
        this.actionLogService = actionLogService;
        this.siteType = siteType;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
        throws IOException, ServletException {

        UserAccount account = (UserAccount)authentication.getPrincipal();

        // 로그인 실패 횟수 초기화
        request.getSession().setAttribute(Constants.SESSION_AUTHENTICATION_FAILURE_COUNT, 0);

        // 로그인 actionLog 남기기
        try {
            ActionLog actionLog = new ActionLog();
            actionLog.setAction(ActionType.LOGIN);
            actionLog.setRefTarget(RefTarget.ADMIN);
            actionLog.setRefTargetKey(account.getId());
            actionLog.setRefTargetType(siteType);
            actionLogService.addActionLog(actionLog, request);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if(WebUtil.isAjax(request)) {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(response.getWriter(), account);
        }else {
            super.onAuthenticationSuccess(request, response, authentication);
        }

    }
}

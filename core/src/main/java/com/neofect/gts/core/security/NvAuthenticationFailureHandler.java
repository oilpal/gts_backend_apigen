package com.neofect.gts.core.security;

import com.neofect.gts.core.config.Constants;
import com.neofect.gts.core.config.Constants;

import com.neofect.gts.core.services.common.service.ActionLogService;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NvAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private String ACTIVATE_USER_URI = "/page/find/activate";
    protected final ActionLogService actionLogService;
    protected final String siteType;

    public NvAuthenticationFailureHandler(ActionLogService actionLogService, String siteType){
        this.actionLogService = actionLogService;
        this.siteType = siteType;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        try{
            // 액션로그
        }catch (Exception e){
            e.printStackTrace();
        }


        if (exception instanceof LockedException) {
            // 탈퇴계정
        }

        if(exception instanceof DisabledException) {
            // 휴면계정
            response.sendRedirect(request.getContextPath() + ACTIVATE_USER_URI);
        } else {
            HttpSession session = request.getSession();
            Integer failureCount = 0;

            if (session.getAttribute(Constants.SESSION_AUTHENTICATION_FAILURE_COUNT) != null) {
                failureCount = (Integer) session.getAttribute(Constants.SESSION_AUTHENTICATION_FAILURE_COUNT) + 1;
            }

            session.setAttribute(Constants.SESSION_AUTHENTICATION_FAILURE_COUNT, failureCount);
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}

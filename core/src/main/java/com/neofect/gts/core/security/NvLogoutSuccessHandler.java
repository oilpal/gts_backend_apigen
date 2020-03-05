package com.neofect.gts.core.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neofect.gts.core.services.common.domain.ActionLog;
import com.neofect.gts.core.services.common.domain.enums.ActionType;
import com.neofect.gts.core.services.common.domain.enums.RefTarget;
import com.neofect.gts.core.services.common.service.ActionLogService;
import com.neofect.gts.core.services.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Slf4j
public class NvLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
    implements LogoutSuccessHandler {

    protected final ActionLogService actionLogService;
    protected final String siteType;

    public NvLogoutSuccessHandler(ActionLogService actionLogService, String siteType){
        this.actionLogService = actionLogService;
        this.siteType = siteType;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication)
        throws IOException, ServletException {

        User user = (User)authentication.getPrincipal();

        try {
            ActionLog actionLog = new ActionLog();
            actionLog.setAction(ActionType.LOGOUT);
            actionLog.setRefTarget(RefTarget.ADMIN);
            actionLog.setRefTargetKey(user.getId());
            actionLog.setRefTargetType(siteType);
            actionLogService.addActionLog(actionLog, request);
        }catch(Exception e){
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/");
    }
}

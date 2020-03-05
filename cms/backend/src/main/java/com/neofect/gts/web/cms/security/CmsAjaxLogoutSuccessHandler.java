package com.neofect.gts.web.cms.security;

import com.neofect.gts.core.services.common.domain.enums.ActionType;
import com.neofect.gts.core.services.common.domain.enums.RefTarget;
import com.neofect.gts.core.services.common.service.ActionLogService;
import com.neofect.gts.core.services.user.domain.User;
import com.neofect.gts.core.services.user.domain.UserAccount;
import io.github.jhipster.security.AjaxLogoutSuccessHandler;
import org.springframework.security.core.Authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CmsAjaxLogoutSuccessHandler extends AjaxLogoutSuccessHandler {

    protected final String siteType;
    protected final ActionLogService actionLogService;


    public CmsAjaxLogoutSuccessHandler(ActionLogService actionLogService, String siteType){
        this.actionLogService = actionLogService;
        this.siteType = siteType;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        UserAccount ac = (UserAccount)authentication.getPrincipal();

        try{
            actionLogService.addActionLog(RefTarget.ADMIN, ac.getId(), siteType, ActionType.LOGOUT);
        }catch(Exception e){
            e.printStackTrace();
        }

        response.setStatus(200);
    }


}

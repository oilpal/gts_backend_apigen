package com.neofect.gts.core.services.common.service;


import com.neofect.gts.core.services.common.domain.ActionLog;
import com.neofect.gts.core.services.common.domain.enums.ActionTypeIf;
import com.neofect.gts.core.services.common.domain.enums.RefTargetIf;
import com.unvus.domain.EnumCode;
import com.neofect.gts.core.services.common.domain.ActionLog;
import com.neofect.gts.core.services.common.domain.enums.ActionTypeIf;
import com.neofect.gts.core.services.common.domain.enums.RefTarget;
import com.neofect.gts.core.services.common.domain.enums.RefTargetIf;
import com.neofect.gts.core.services.common.repository.ActionLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ActionLogService {

	private final ActionLogRepository actionLogRepository;


	public ActionLogService(ActionLogRepository actionLogRepository) {
		this.actionLogRepository = actionLogRepository;
    }


    @Transactional
    public int addActionLog(RefTargetIf refTarget, Long id, ActionTypeIf action) throws Exception {
        return addActionLog(refTarget, id, null, action, null);
    }

    @Transactional
    public int addActionLog(RefTargetIf refTarget, String refTargetType, ActionTypeIf action, String message) throws Exception{
	    return addActionLog(refTarget, null, refTargetType, action, message);
    }

    @Transactional
    public int addActionLog(RefTargetIf refTarget, Long id, String refTargetType, ActionTypeIf action) throws Exception{
	    return addActionLog(refTarget, id, refTargetType, action, null);
    }

    @Transactional
    public int addActionLog(RefTargetIf refTarget, Long id, String refTargetType, ActionTypeIf action, String message) throws Exception {

        ActionLog actionLog = new ActionLog();
        actionLog.setAction(action);
        actionLog.setRefTarget(refTarget);
        actionLog.setRefTargetKey(id);
        actionLog.setRefTargetType(refTargetType);
        actionLog.setMessage(message);

        return addActionLog(actionLog);
    }

    @Transactional
    public int addActionLog(ActionLog actionLog) throws Exception {
        return addActionLog(actionLog, ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest());
    }


    @Transactional
    public int addActionLog(ActionLog actionLog, HttpServletRequest req) throws Exception {
        try {
            log.info("DEBUG_ACTION_LOG");
            String ip = req.getHeader("X-FORWARDED-FOR");
            if (ip == null) {
                ip = req.getHeader("X-REAL_IP");
                if (ip == null) {
                    ip = req.getRemoteAddr();
                }
            }
            Enumeration headerNames = req.getHeaderNames();
            while(headerNames.hasMoreElements()) {
                String headerName = (String)headerNames.nextElement();
                log.info(headerName + ": " + req.getHeader(headerName));
            }
            actionLog.setIp(ip);
        } catch(Exception e) {
            log.error(e.getMessage(), e);
        }

        int cnt =  actionLogRepository.insertActionLog(actionLog);


        return cnt;
    }


    @Transactional(readOnly = true)
    public List<ActionLog> listActionLog(Map<String, Object> q) {
        return actionLogRepository.listActionLog(q);
    }

    // 카운트 조회
    public int listActionLogCnt(Map<String, Object> q){ return actionLogRepository.listActionLogCnt(q); }


}

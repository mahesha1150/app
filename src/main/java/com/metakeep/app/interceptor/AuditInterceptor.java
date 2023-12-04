package com.metakeep.app.interceptor;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.metakeep.app.bean.AuditBean;
import com.metakeep.app.config.CustomConfiguration;
import com.metakeep.app.util.Utility;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
public class AuditInterceptor implements HandlerInterceptor {
	
	@Autowired
	private Utility utility;
	
	private Logger logger = LoggerFactory.getLogger(AuditInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
      throws Exception {
		/* logger.info("preHandle"); */
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
      throws Exception {
		/* logger.info("postHandle"); */
        String userId = request.getParameter("userId");
        utility.auditApiCall(
        		new AuditBean(
        				userId, 
        				new Date(), 
        				response.getStatus() == HttpStatus.OK.value() ?"success" :"failure", 
        			    "", request.getRequestURI(), response.getStatus()+""));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) 
      throws Exception {
		/* logger.info("afterCompletion"); */
    }
	

}

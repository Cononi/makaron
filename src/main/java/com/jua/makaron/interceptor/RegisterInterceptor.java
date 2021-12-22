package com.jua.makaron.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class RegisterInterceptor extends HandlerInterceptorAdapter {
	
	 private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 캐시 제거
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "0"); // Proxies.
		// 기존 세션을 받아 옵니다.
		HttpSession session = request.getSession();
		// 세션이 존재한다면 해당 페이지로감
		if(session.getAttribute("login") != null) {
			response.sendRedirect(request.getContextPath());
			return false;
		} else {
			return true;
		}
		
	}
	
}
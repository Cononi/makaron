package com.jua.makaron.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jua.makaron.domain.LoginDTO;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	 private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	// 로그인 페이지 이동 전, 현재 페이지를 Session에 저장
	private void saveDest(HttpServletRequest req) {

	    String uri = req.getRequestURI();
	    String query = req.getQueryString();
	    
	    // 기존 URI에 parameter가 있을 경우, 이를 포함
	    if(query == null || query.equals("null")) {
	    	query = "";
	    } else {
	        query = "?" + query;
	    }
	    
	    if(req.getMethod().equals("GET")) {
	        logger.info("dest: " + (uri + query));
	        req.getSession().setAttribute("dest", uri + query);
	    }
	}

	@Override
	public boolean preHandle(HttpServletRequest request, 
	    HttpServletResponse response,
	    Object handler) throws Exception {
		
	    HttpSession session = request.getSession();
	    
	    if(session.getAttribute("login") == null) {
	        
	        logger.info("current user is not logined");
	        
	        saveDest(request);
	        
	        // 로그인하지 않은 사용자일 경우 로그인 페이지로 이동
	        response.sendRedirect("/login");
	        return false;
	    }
	        
	    // 로그인한 사용자일 경우 Controller 호출
	    return true;
	}
}

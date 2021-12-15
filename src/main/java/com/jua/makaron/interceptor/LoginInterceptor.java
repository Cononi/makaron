package com.jua.makaron.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jua.makaron.domain.LoginDTO;
import com.jua.makaron.manager.LoginSessionManager;
import com.jua.makaron.vo.CustomerVO;

import lombok.extern.log4j.Log4j;


@Log4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	 private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 기존 세션을 받아 옵니다.
		HttpSession session = request.getSession();
		// 로그인 세션을 받아 옵니다.
//		Object userSession = session.getAttribute("login");
		
		// 로그인 차단 검증
		if(session.getAttribute("login") != null) {
			response.sendRedirect("/");
			return false;
		} else {
			return true;
		}
	}
	
	 
	
	/**
	 *  로그인후에 중복 접속을 체크합니다.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		// 기존 세션을 받아옴
		HttpSession session = request.getSession(false);
		// 기존 세션이 있다면 제거
		if(session != null)
			session.removeAttribute("login");
		// 로그인 정보를 받아와서 저장
		CustomerVO loginDTO = (CustomerVO)request.getAttribute("loginDTO");
	    // 이전 destination 불러오기
        // response.sendRedirect("/");        
        Object dest = session.getAttribute("dest");
        
		// 로그인 성공시 로직
		if (loginDTO != null) {
			// 로그인 세션 매니저 객체 생성 ( 싱글톤 )
			LoginSessionManager loginSessionManager = LoginSessionManager.getInstance();
			// 로그을 성공한 사용자 id가 있는지 확인
			HttpSession loginSession = loginSessionManager.getSession(loginDTO.getId());
			if (loginSession == null) {
				// 로그인 세션 생성
				session.setAttribute("login", loginDTO);
				// 로그인 성공한 사용자 추가
				loginSessionManager.setSession(loginDTO.getId(), session);
				System.out.println("새로운 접속!!");
			} else { // 로그인한 사용자가 있다면
				// 기존 접속자 세션 삭제
				loginSessionManager.removeSession(loginDTO.getId());
				// 현재 접속자 로그인 세션 생성
				session.setAttribute("login", loginDTO);
				// 로그인 성공한 사용자 추가
				loginSessionManager.setSession(loginDTO.getId(), session);
				System.out.println("기존 사용자 세션 삭제!!");
			}
			// 메인 페이지로 이동
			response.sendRedirect(dest != null ? (String)dest : "");
		}
	}
	
}
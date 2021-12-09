package com.jua.makaron.manager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * 
 * @author jeonhong-u
 * set - 세션 맵에 추가할 세션이 있는지 확인하고 없으면 추가합니다.
 * get - 세션 맵에 세션이 있으면 세션 맵을 통해서 세션을 가져옵니다.
 * remove - 세션 먑애서 삭제할 사용자 세션이 있는지 확인하고 있으면 사용자 세션을 무효화 하고 삭제합니다.
 */
public final class SessionManager {

	// 생성자 처리

	/**
	 * 생성자
	 */
	private SessionManager() {
	}

	/**
	 * SessionManager의 인스턴스를 가져옵니다.
	 * 
	 * @return SessionManager 객체
	 */
	public static SessionManager getInstance() {
		return InClassInstance.sessionManager;
	}

	private static class InClassInstance {
		private static final SessionManager sessionManager = new SessionManager();

	}
	
	// 세션
	/**
	 * 세션을 키,세션으로 구분할 맵, 사용자 세션을 사용자 id로 구분
	 */
	private Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();

	/**
	 * 사용자 세션을 추가합니다.
	 * 
	 * @param userId      사용자 Id
	 * @param httpSession 사용자 세션
	 * @return 추가 여부
	 */
	public boolean setSession(String userId, HttpSession httpSession) {
		boolean result = false;
		if (!sessionMap.containsKey(userId)) {
			if (null == sessionMap.put(userId, httpSession)) {
				result = false;
			} else {
				result = true;
			}
			System.out.println("Session Manager Count : " + sessionMap.size() + ", Add ID : " + userId
					+ ", Session ID : " + httpSession.getId());
		}
		return result;
	}

	/**
	 * 사용자 세션을 가져옵니다.
	 * 
	 * @param id 사용자 Id
	 * @return 사용자 세션
	 */
	public HttpSession getSession(String id) {
		HttpSession httpSession = null;
		if (sessionMap.containsKey(id)) {
			httpSession = sessionMap.get(id);
		}
		return httpSession;
	}

/**
 * 사용자 세션을 제거합니다. 
 * @param userId 사용자 Id
 * @return 추가 여부
 */
public boolean removeSession(String userId) {
	boolean result = false;
	if (sessionMap.containsKey(userId)) {
		String sessionID = "";
		HttpSession httpSession = sessionMap.get(userId);
		if (null != httpSession) {
			sessionID = httpSession.getId();
			httpSession.invalidate();
			result = true;
		}
		sessionMap.remove(userId);
		System.out.println("Session Manager Count : " + sessionMap.size() + ", Remove ID : " + userId + ", Session ID : " + sessionID);
	}
	return result;
}
}

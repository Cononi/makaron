package com.jua.makaron.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jua.makaron.service.PhoneCertService;
import com.jua.makaron.utilities.SHA256Util;
import com.jua.makaron.utilities.SMSKey;
import com.jua.makaron.utilities.SignatureCreate;
import com.jua.makaron.vo.CustomerPhoneHistoryVO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PhoneCertController {

	//인증 객체
	private SMSKey smskeys;
	
	// 휴대폰 인증
	private PhoneCertService service;
	
	/*
	 * 회원가입 핸드폰 인증 여부, 조회, 완료 처리
	 */
	@RequestMapping(value ="register/phone/check",	produces = "text/plain; charset=UTF-8"  ,method =RequestMethod.POST)
	public ResponseEntity<String> smsSummit(@ModelAttribute @Valid CustomerPhoneHistoryVO phoneCertVO, HttpServletRequest request, BindingResult result) {
		// 세션 생성 - 세션이 없으면 null
		HttpSession session = request.getSession(false);
		// 랜덤 객체
		Random rand = new Random();
		// 랜덤 암호 생성
		int number = rand.nextInt(999999);
		// 6자리로 변환
		String numberChange = String.format("%06d", number);
		// SMS 생성 객체
		SignatureCreate signatureCreate = new SignatureCreate();
		// 인증 횟수 카운팅
		int count = service.phoneCertHistoryCount(phoneCertVO.getPhone_no());
		// 인증 회원 조회
		int joinUser = service.phoneCertUserError(phoneCertVO.getPhone_no());
		
		if(joinUser == 1) {
			return ResponseEntity.status(200).body("이미 가입되어있는 회원 입니다. 자신의 번호이나 타인이 등록한 경우 고객센터에 문의 주세요.");
		} else 
			if(count >= 0) {
			return ResponseEntity.status(200).body("당일 최대 인증가능 횟수인 5회를 초과하여 더 이상 인증할 수 없습니다.");
		} else {
			// 만약 인증번호 발송후에 재인증 시도를 했을경우 기존 세션을 제거하고 새로운 세션으로 인증번호를 발송
			if(session != null) {
				session.removeAttribute("phoneCertNumberSession");
			}
			
			// 6자리 메세지 전송
			signatureCreate.sendSMS(smskeys,phoneCertVO.getPhone_no(),"[마카롱쥬아] 휴대폰 인증번호는 " + numberChange +" 입니다.");
			
			// 번호
			phoneCertVO.setPhone_no(phoneCertVO.getPhone_no());
			// 토큰값
			phoneCertVO.setToken(numberChange);
			// 토큰 암호화 및 저장
			String token = service.phoneCertInsert(phoneCertVO);
			
			session.setAttribute("phoneCertNumberSession", token);
			session.setMaxInactiveInterval(3*60);
			return ResponseEntity.status(200).body("인증 번호가 전송되었습니다.");
		}
	}
	
	
	/*
	 * 회원 가입페이지 휴대폰 인증번호 검증
	 */
	@ResponseBody
	@RequestMapping(value ="register/phone/check/success", produces = "text/plain; charset=UTF-8", method = RequestMethod.POST)
	public ResponseEntity<String> certSummit(@ModelAttribute @Valid CustomerPhoneHistoryVO token, Model model,  HttpServletRequest request) {
		// 세션 생성
		HttpSession session = request.getSession(false);
		// 인증 만료 및 인증 번호 검증
		String userSalt = service.phoneCertHistoryNumber(token.getPhone_no());
		// 유저 인증 번호
		String userCert =  token.getToken();
		// token 키값 변환 및 userSalt값이 있다면 실행
		if(userSalt != null) {
			// 인증 세션 값 저장
			String phoneSession = (String)session.getAttribute("phoneCertNumberSession");
			// 인증 내역 검증
			userCert = SHA256Util.getEncrypt(userCert,userSalt);
			if(phoneSession.equals(userCert)) {
				// 인증 세션 제거
				session.removeAttribute("phoneCertNumberSession");
				
				// 인증 완료 세션 생성
				session.setAttribute("phoneCertComplete", userCert);
				return ResponseEntity.status(200).body("인증이 완료되었습니다.");
			} else if(!phoneSession.equals(userCert)) {
				return ResponseEntity.status(202).body("인증 번호가 다릅니다.");
			} else {
				return ResponseEntity.status(202).body("잘못된 요청입니다.");	
			}
		}else { // 만료되었거나 요청하지 않은 경우
			return ResponseEntity.status(202).body("인증이 만료되었습니다. 재인증 바랍니다.");	
		}
	}
	
	
}

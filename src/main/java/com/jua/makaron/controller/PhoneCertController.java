package com.jua.makaron.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jua.makaron.phonecert.service.PhoneCertService;
import com.jua.makaron.utilities.SignatureCreate;
import com.jua.makaron.vo.PhoneCertVO;
import com.jua.makaron.vo.SMSKeyVO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PhoneCertController {

	//인증 객체
	SMSKeyVO smskeys;
	
	// 휴대폰 인증
	private PhoneCertService service;
	
	@RequestMapping(value ="/phone/check/{phone}", produces = "json/application; charset=UTF-8")
	public ResponseEntity<String> smsSummit(@PathVariable("phone") String phone, HttpSession session, Model model) {
		// 핸드폰 인증 정보 VO 객체
		PhoneCertVO phoneCertVO = new PhoneCertVO();
		// 랜덤 객체
		Random rand = new Random();
		// 랜덤 암호 생성
		int number = rand.nextInt(999999);
		// 6자리로 변환
		String numberChange = String.format("%06d", number);
		// SMS 생성 객체
		SignatureCreate signatureCreate = new SignatureCreate();
		
		// 인증 횟수 카운팅
		int count = service.phoneCertHistoryCount(phone);
		
		if(count >= 1) {
			return new ResponseEntity<String>("금일 전송 횟수 5회를 초과하여 더 이상 인증이 불가능 합니다.",HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			// 6자리 메세지 전송
			signatureCreate.sendSMS(smskeys,phone,"[마카롱쥬아] 휴대폰 인증번호는 " + numberChange +" 입니다.");
			
			// 6자리 토큰 암호화 저장
			// 번호
			phoneCertVO.setPhone_no(phone);
			// 토큰값
			phoneCertVO.setToken(numberChange);
			// 토큰 암호화 및 저장
			String token = service.phoneCertInsert(phoneCertVO);
			
			session.setAttribute("phoneCertNumSssion", token);
			session.setMaxInactiveInterval(3*60);
			return new ResponseEntity<String>("인증 번호가 전송되었습니다.",HttpStatus.OK);
		}
	}
}

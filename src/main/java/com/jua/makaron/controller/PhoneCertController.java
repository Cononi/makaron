package com.jua.makaron.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@Autowired
    private HttpSession session;
	
	@RequestMapping(value ="/phone/check", produces = "json/application; charset=UTF-8", method =RequestMethod.POST)
	public ResponseEntity<String> smsSummit(PhoneCertVO phoneCertVO, Model model) {
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
		
		if(count >= 5) {
			return new ResponseEntity<String>("금일 전송 횟수 5회를 초과하여 더 이상 인증이 불가능 합니다.",HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			// 6자리 메세지 전송
			signatureCreate.sendSMS(smskeys,phoneCertVO.getPhone_no(),"[마카롱쥬아] 휴대폰 인증번호는 " + numberChange +" 입니다.");
			
			// 번호
			phoneCertVO.setPhone_no(phoneCertVO.getPhone_no());
			// 토큰값
			phoneCertVO.setToken(numberChange);
			// 토큰 암호화 및 저장
			String token = service.phoneCertInsert(phoneCertVO);
			
			session.setAttribute("phoneCertNumSssion", token);
			session.setMaxInactiveInterval(3*60);
			
			model.addAttribute("p_no",phoneCertVO.getPhone_no());
			return new ResponseEntity<String>("인증 번호가 전송되었습니다.",HttpStatus.OK);
		}
	}
	
	@RequestMapping(value ="/phone/check/{token}/{phone}", produces = "json/application; charset=UTF-8", method = RequestMethod.POST)
	public ResponseEntity<String> certSummit(PhoneCertVO token,@PathVariable("phone") String phone, Model model) {
		// 인증 만료 및 인증 번호 검증
		PhoneCertVO phoneCertVO = service.phoneCertHistoryNumber(phone);
		
		// 인증 번호 
		
		// 인증 내역 검증
		return new ResponseEntity<String>("인증이 완료 되었습니다.",HttpStatus.OK);
	}
	
}

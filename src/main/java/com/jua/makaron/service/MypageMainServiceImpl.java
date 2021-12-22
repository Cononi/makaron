package com.jua.makaron.service;

import org.springframework.stereotype.Service;
import com.jua.makaron.mapper.MypageMainMapper;
import com.jua.makaron.vo.CustomerRatingVO;
import com.jua.makaron.vo.CustomerVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MypageMainServiceImpl implements MypageMainService {

	private MypageMainMapper mapper;
	
	@Override
	//유저 이름 얻기
	public CustomerVO getCustomerName(String id) {
		log.info("아이디 확인 : " + id);
		log.info("이름 확인 : " + mapper.getCustomerName(id));
		
		return mapper.getCustomerName(id);
	}

	@Override
	//유저 등급 얻기
	public CustomerRatingVO getCustomerRating(String id) {
		return mapper.getCustomerRating(id);
	}
	
	@Override
	//유저 쿠폰 갯수 얻기
	public int getCouponQuantity(String id) {
		log.info("아이디 확인 : " + id);
		log.info("쿠폰 갯수 확인 : " + mapper.getCouponQuantity(id));
		
		return mapper.getCouponQuantity(id);
	}


}

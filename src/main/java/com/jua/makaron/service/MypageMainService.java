package com.jua.makaron.service;

import com.jua.makaron.vo.CustomerRatingVO;
import com.jua.makaron.vo.CustomerVO;

public interface MypageMainService {
	
	//1. 유저 이름 얻기
	public CustomerVO getCustomerName(String id);
		
	//2. 유저 등급/혜택 얻기
	public CustomerRatingVO getCustomerRating(String id);
	//public Customer_ratingBenefitVO getCustomerRaingBenefit(String id); //VO만들어야함
		
	//3. 유저 적립금 잔액/내역 얻기
	//public int getPointBalance(String id);
	//public List<PointVO> getPointHistory(String id); //VO만들어야함
		
	//4. 유저 쿠폰 개수/내역 얻기
	public int getCouponQuantity(String id);
	//public List<CouponVO> getCouponHistory(String id);
}

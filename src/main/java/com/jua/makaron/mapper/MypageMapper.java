package com.jua.makaron.mapper;

import java.util.List;

import com.jua.makaron.vo.CustomerVO;

public interface MypageMapper {
	
	//0-1. 유저 이름 얻기
	public String getCustomerName(String id);
	
	//0-2. 유저 등급/혜택 얻기
	//public Customer_ratingVO getCustomerRating(String id);
	//public Customer_ratingBenefitVO getCustomerRaingBenefit(String id); //VO만들어야함
	
	//0-3. 유저 적립금 잔액/내역 얻기
	public int getPointBalance(String id);
	//public List<PointVO> getPointHistory(String id); //VO만들어야함
	
	//0-4. 유저 쿠폰 개수/내역 얻기
	public int getCouponQuantity(String id);
	//public List<CouponVO> getCouponHistory(String id);
	
	//1. 주문내역 불러오기
	
	//2-1. 배송지 불러오기
	//public ShippingVO getShipping(String id);
	
	//2-2. 배송지 추가하기
	//public void insertShipping(String id, String Nickname, String postal_code, String address_base, String address_sub, String address_type);
	
	//2-3. 배송지 삭제하기
	//public void deleteShipping(String no);
	
	//3-1. 후기 내역 불러오기

	
	//3-2. 후기 작성하기 / 후기 이미지 작성하기
	public void insertReview(String id, String product_title, String review_title, String review_content);
	//public void insertReviewImage(String id, String file_url, String file_name);
	
	//3-3. 후기 삭제하기
	public void deleteReview(String id, String no);
	
	//4-1. 상품 문의 내역 불러오기
	
	//4-2. 상품 문의 등록
	public void insertQuestion(String id, String product_title, String qna_title, String qna_content);
	
	//4-3. 상품 문의 삭제
	public void deleteQuestion(String id);
}

package com.jua.makaron.mapper;

import com.jua.makaron.vo.CustomerVO;
import com.jua.makaron.vo.Customer_ratingVO;
import com.jua.makaron.vo.OrderListVO;
import com.jua.makaron.vo.QuestionVO;
import com.jua.makaron.vo.ReviewVO;
import com.jua.makaron.vo.ShippingVO;

public interface MypageMapper {
	
	//0-1. 유저 이름 얻기
	public CustomerVO getCustomerName(String id);
	
	//0-2. 유저 등급 얻기
	public Customer_ratingVO getCustomerRating(String id);
	
	//0-3. 유저 적립금 잔액 얻기
	public int getPointBalance(String id);
	
	//0-4. 유저 쿠폰 개수 얻기
	public int getCouponQuantity(String id);
	
	//1. 주문내역 불러오기
	public OrderListVO getOrderList(String id);
	
	//2-1. 배송지 불러오기
	public ShippingVO getShipping(String id);
	
	//2-2. 배송지 추가하기
	public void insertShipping(String id);
	
	//2-3. 배송지 수정하기
	public void updateShipping(String id);
	
	//2-4. 배송지 삭제하기
	public void deleteShipping(String id);
	
	//3-1. 후기 내역 불러오기
	public ReviewVO getReviewList(String id);
	
	//3-2. 후기 작성하기
	public void insertReview(String id);
	
	//3-3. 후기 수정하기
	public void updateReview(String id);
	
	//3-4. 후기 삭제하기
	public void deleteReview(String id);
	
	//4-1. 상품 문의 내역 불러오기
	public QuestionVO getQuestionList(String id);
	
	//4-2. 상품 문의 등록
	public void insertQuestion(String id);
	
	//4-3. 상품 문의 삭제
	public void deleteQuestion(String id);
}

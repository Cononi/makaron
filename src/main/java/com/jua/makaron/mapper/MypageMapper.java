package com.jua.makaron.mapper;

import com.jua.makaron.vo.CustomerVO;
import com.jua.makaron.vo.Customer_ratingVO;
import com.jua.makaron.vo.OrderListVO;
import com.jua.makaron.vo.QuestionVO;
import com.jua.makaron.vo.ReviewVO;
import com.jua.makaron.vo.ShippingVO;

public interface MypageMapper {
	
	//0-1. ���� �̸� ���
	public CustomerVO getCustomerName(String id);
	
	//0-2. ���� ��� ���
	public Customer_ratingVO getCustomerRating(String id);
	
	//0-3. ���� ������ �ܾ� ���
	public int getPointBalance(String id);
	
	//0-4. ���� ���� ���� ���
	public int getCouponQuantity(String id);
	
	//1. �ֹ����� �ҷ�����
	public OrderListVO getOrderList(String id);
	
	//2-1. ����� �ҷ�����
	public ShippingVO getShipping(String id);
	
	//2-2. ����� �߰��ϱ�
	public void insertShipping(String id);
	
	//2-3. ����� �����ϱ�
	public void updateShipping(String id);
	
	//2-4. ����� �����ϱ�
	public void deleteShipping(String id);
	
	//3-1. �ı� ���� �ҷ�����
	public ReviewVO getReviewList(String id);
	
	//3-2. �ı� �ۼ��ϱ�
	public void insertReview(String id);
	
	//3-3. �ı� �����ϱ�
	public void updateReview(String id);
	
	//3-4. �ı� �����ϱ�
	public void deleteReview(String id);
	
	//4-1. ��ǰ ���� ���� �ҷ�����
	public QuestionVO getQuestionList(String id);
	
	//4-2. ��ǰ ���� ���
	public void insertQuestion(String id);
	
	//4-3. ��ǰ ���� ����
	public void deleteQuestion(String id);
}

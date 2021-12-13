package com.jua.makaron.mapper;

import java.util.List;

import com.jua.makaron.vo.CouponVO;
import com.jua.makaron.vo.CustomerVO;
import com.jua.makaron.vo.Customer_ratingBenefitVO;
import com.jua.makaron.vo.Customer_ratingVO;
import com.jua.makaron.vo.OrderListVO;
import com.jua.makaron.vo.PointVO;
import com.jua.makaron.vo.QuestionVO;
import com.jua.makaron.vo.ReviewVO;
import com.jua.makaron.vo.ShippingVO;

public interface MypageMapper {
	
	//0-1. ���� �̸� ���
	public String getCustomerName(String id);
	
	//0-2. ���� ���/���� ���
	public Customer_ratingVO getCustomerRating(String id);
	public Customer_ratingBenefitVO getCustomerRaingBenefit(String id);
	
	//0-3. ���� ������ �ܾ�/���� ���
	public int getPointBalance(String id);
	public List<PointVO> getPointHistory(String id);
	
	//0-4. ���� ���� ����/���� ���
	public int getCouponQuantity(String id);
	public List<CouponVO> getCouponHistory(String id);
	
	//1. �ֹ����� �ҷ�����
	public List<OrderListVO> getOrderList(String id);
	
	//2-1. ����� �ҷ�����
	public ShippingVO getShipping(String id);
	
	//2-2. ����� �߰��ϱ�
	public void insertShipping(String id, String Nickname, String postal_code, String address_base, String address_sub, String address_type);
	
	//2-3. ����� �����ϱ�
	public void deleteShipping(String no);
	
	//3-1. �ı� ���� �ҷ�����
	public ReviewVO getReviewList(String id);
	
	//3-2. �ı� �ۼ��ϱ�(��/�̹���)
	public void insertReview(String id, String product_title, String review_title, String review_content);
	public void insertReviewImage(String id, String file_url, String file_name);
	
	//3-3. �ı� �����ϱ�
	public void deleteReview(String id, String no);
	
	//4-1. ��ǰ ���� ���� �ҷ�����
	public QuestionVO getQuestionList(String id);
	
	//4-2. ��ǰ ���� ���
	public void insertQuestion(String id);
	
	//4-3. ��ǰ ���� ����
	public void deleteQuestion(String id);
}

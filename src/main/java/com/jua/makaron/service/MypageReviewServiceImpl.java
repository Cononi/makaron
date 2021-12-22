package com.jua.makaron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jua.makaron.mapper.MypageReviewMapper;
import com.jua.makaron.vo.ProductReviewVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MypageReviewServiceImpl implements MypageReviewService {

	private MypageReviewMapper mapper;
	
	@Override
	//후기 내역 불러오기
	public List<ProductReviewVO> getReviewList(String id) {
		log.info("아이디 확인 : " + id);
		log.info("리뷰 내역 확인 : " + mapper.getReviewList(id));
		
		return mapper.getReviewList(id);
	}
	
	@Override
	//작성할 수 있는 후기의 상품명, 주문번호 불러오기 
	public List<ProductReviewVO> chooseToWrite(String id) {
		return mapper.chooseToWrite(id);
	}
	
	@Override
	//후기 작성하기
	public void insertReview(String id, ProductReviewVO review) {
		log.info("입력값"+review);
		mapper.insertReview(id, review);
	}

	@Override
	//후기 삭제하기
	public void deleteReview(ProductReviewVO review) {
		mapper.deleteReview(review);
	}

}

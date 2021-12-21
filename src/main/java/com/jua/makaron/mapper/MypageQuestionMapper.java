package com.jua.makaron.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jua.makaron.vo.ProductQnaVO;
import com.jua.makaron.vo.ProductReviewVO;

public interface MypageQuestionMapper {
	
	//1. 상품 문의 내역 불러오기
	public List<ProductQnaVO> getQuestionList(String id); 
		
	//2. 상품명 불러오기 / 상품 문의 등록
	public List<ProductQnaVO> allProductName();
	public void insertQuestion(@Param("id") String id,  @Param("qna") ProductQnaVO qna);
		
	//3. 상품 문의 삭제
	public void deleteQuestion(ProductQnaVO qna);
}

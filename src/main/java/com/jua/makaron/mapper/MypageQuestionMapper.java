package com.jua.makaron.mapper;

import java.util.List;

import com.jua.makaron.vo.ProductQnaVO;

public interface MypageQuestionMapper {
	
	//1. 상품 문의 내역 불러오기
	public List<ProductQnaVO> getQuestionList(String id);
		
	//2. 상품 문의 등록
	public void insertQuestion(String id, ProductQnaVO qna);
		
	//3. 상품 문의 삭제
	public void deleteQuestion(ProductQnaVO qna);
}

package com.jua.makaron.mapper;

import com.jua.makaron.vo.QuestionVO;

public interface MypageQuestionMapper {
	
	//1. 상품 문의 내역 불러오기
	public QuestionVO getQuestionList(String id);
		
	//2. 상품 문의 등록
	public void insertQuestion(String id, String product_title, String qna_title, String qna_content);
		
	//3. 상품 문의 삭제
	public void deleteQuestion(String id);
}

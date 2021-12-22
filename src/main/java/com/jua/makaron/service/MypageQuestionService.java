package com.jua.makaron.service;

import java.util.List;

import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.vo.ProductQnaVO;

public interface MypageQuestionService {

	//1. 상품 문의 내역 불러오기 / 상품 문의 글 개수 구하기
	public List<ProductQnaVO> getQuestionList(String id, CriteriaDTO cri);
	public int getQuestionQuantity(String id);
			
	//2. 상품명 불러오기 / 상품 문의 등록
	public List<ProductQnaVO> allProductName();
	public void insertQuestion(String id, ProductQnaVO qna);
		
	//3. 상품 문의 삭제
	public void deleteQuestion(ProductQnaVO qna);
}

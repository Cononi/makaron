package com.jua.makaron.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.mapper.MypageQuestionMapper;
import com.jua.makaron.vo.ProductQnaVO;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MypageQuestionServiceImpl implements MypageQuestionService {

	private MypageQuestionMapper mapper;
	
	@Override
	//상품 문의 내역 불러오기
	public List<ProductQnaVO> getQuestionList(String id, CriteriaDTO cri) {
		return mapper.getQuestionList(id,cri);
	}
	
	@Override
	//상품 문의 글 개수 구하기
	public int getQuestionQuantity(String id) {
		return mapper.getQuestionQuantity(id);
	}
	
	@Override
	//상품명 불러오기
	public List<ProductQnaVO> allProductName() {
		return mapper.allProductName();
	}
	
	@Override
	//상품 문의 등록
	public void insertQuestion(String id, ProductQnaVO qna) {
		mapper.insertQuestion(id, qna);	
	}

	@Override
	//상품 문의 삭제
	public void deleteQuestion(ProductQnaVO qna) {
		mapper.deleteQuestion(qna);
	}

}

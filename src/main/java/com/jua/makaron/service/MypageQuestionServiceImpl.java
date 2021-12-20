package com.jua.makaron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jua.makaron.mapper.MypageMainMapper;
import com.jua.makaron.mapper.MypageQuestionMapper;
import com.jua.makaron.vo.ProductQnaVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MypageQuestionServiceImpl implements MypageQuestionMapper {

	private MypageQuestionMapper mapper;
	
	@Override
	//상품 문의 내역 불러오기
	public List<ProductQnaVO> getQuestionList(String id) {
		log.info("아이디 확인 : " + id);
		log.info("질문 확인 : " + mapper.getQuestionList(id));
		
		return mapper.getQuestionList(id);
	}

	@Override
	//상품 문의 등록
	public void insertQuestion(String id, ProductQnaVO qna) {
		log.info("아이디 확인 : " + id);
		log.info("상품명 확인 : " + qna.getProduct_title());
		log.info("상품 문의 제목 확인 : " + qna.getQna_title());
		log.info("상품 문의 내용 확인 : " + qna.getQna_content());
		
		mapper.insertQuestion(id, qna);	
	}

	@Override
	//상품 문의 삭제
	public void deleteQuestion(ProductQnaVO qna) {
		log.info("상품문의 번호 확인 : " + qna.getQna_no());
		
		mapper.deleteQuestion(qna);
		
	}

}

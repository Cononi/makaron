package com.jua.makaron.service;

import java.util.List;


import com.jua.makaron.vo.ProductVO;

public interface ProductService {
	//메인화면에서 제품보여주기
	public List<ProductVO> getList();
	
	//제품상세보기
	public ProductVO get(String product_id);
	
	//qna보기
	public List<ProductVO> qna(String product_id);
	
	//review보기
	public List<ProductVO> review(String product_id);
	
	//상품문의에 보여줄 프로덕트
	public List<ProductVO> product(String product_id);
	
	public List<ProductVO> mainReviewMax(); 
}



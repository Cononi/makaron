package com.jua.makaron.mapper;

import java.util.List;
import com.jua.makaron.vo.ProductVO;


public interface ProductMapper {
	//메인페이지에 product보여주기
	public List<ProductVO> getList();
	//제품상세
	public ProductVO get(String product_id);
	//qna
	public List<ProductVO> qna(String product_id);
	//review
	public List<ProductVO> review(String product_id);
	//상품문의에 보여줄 프로덕트
	public List<ProductVO> product(String product_id);
}

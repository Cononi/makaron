package com.jua.makaron.service;

import java.util.List;

import com.jua.makaron.vo.ProductImageVO;
import com.jua.makaron.vo.ProductVO;

public interface ProductService {
	//메인화면에서 제품보여주기
	public List<ProductVO> getList();
	
	//제품상세보기
	public ProductVO get(String product_id);
	
}

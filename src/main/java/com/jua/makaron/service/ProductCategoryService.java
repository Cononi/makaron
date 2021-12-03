package com.jua.makaron.service;

import java.util.List;

import com.jua.makaron.domain.ProductCategoryVO;

public interface ProductCategoryService {
	
	// 카테고리 계층 리스트
	public List<ProductCategoryVO> ctg_all_list();
	
	
}

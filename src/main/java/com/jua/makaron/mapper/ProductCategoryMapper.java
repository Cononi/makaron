package com.jua.makaron.mapper;

import java.util.List;

import com.jua.makaron.vo.ProductCategoryVO;

public interface ProductCategoryMapper {

	// 카테고리 계층 리스트
	public List<ProductCategoryVO> ctg_all_list();
	
}

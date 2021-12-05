package com.jua.makaron.productcategory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jua.makaron.mapper.ProductCategoryMapper;
import com.jua.makaron.vo.ProductCategoryVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService  {
	
	private ProductCategoryMapper product_mapper;
	
	@Override
	public List<ProductCategoryVO> ctg_all_list() {
		return product_mapper.ctg_all_list();
	}
	
	

}

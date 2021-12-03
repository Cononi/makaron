package com.jua.makaron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jua.makaron.domain.ProductCategoryVO;
import com.jua.makaron.mapper.ProductCategoryMapper;

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

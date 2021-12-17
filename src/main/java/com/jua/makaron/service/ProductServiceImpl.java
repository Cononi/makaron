package com.jua.makaron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jua.makaron.mapper.ProductMapper;
import com.jua.makaron.vo.ProductVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private ProductMapper mapper;
	@Override
	public List<ProductVO> getList() {
		//메인화면에서 제품보여주기
		return mapper.getList();
	}
	
	@Override
	public ProductVO get(String product_id) {
		//메인화면에서 제품보여주기
		return mapper.get(product_id);
	}
	

}

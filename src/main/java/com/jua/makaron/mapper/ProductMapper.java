package com.jua.makaron.mapper;

import java.util.List;
import com.jua.makaron.vo.ProductVO;


public interface ProductMapper {
	//메인페이지에 product보여주기
	public List<ProductVO> getList();
	//제품상세
	public ProductVO get(String product_id);
	
}

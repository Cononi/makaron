package com.jua.makaron.mapper;

import java.util.List;

import com.jua.makaron.domain.ProductVO;
import com.jua.makaron.domain.Criteria;

public interface ListMapper {

	public List<ProductVO> getList();
	
	public ProductVO read(String title);
	
	public List<ProductVO> getListWithPaging(Criteria cri);
	
	
}

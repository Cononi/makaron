package com.jua.makaron.service;

import java.util.List;

import com.jua.makaron.domain.Criteria;
import com.jua.makaron.domain.ProductVO;

public interface ListService {
	
	public ProductVO get(String title);
	
	public List<ProductVO> getList();
	
	public List<ProductVO> getList(Criteria cri);

}

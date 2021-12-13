package com.jua.makaron.service;

import java.util.List;

import com.jua.makaron.domain.Criteria;
import com.jua.makaron.domain.ProductVO;

public interface ListService {
	
	public ProductVO get(String ID);
		
	//목록보기
	public List<ProductVO> getList();
	
	//목록보기(페이징 처리)
	public List<ProductVO> getList(Criteria cri);
	
	//목록보기(페이지 단위로)
	public List<ProductVO> getListWithPaging(Criteria cri);


}

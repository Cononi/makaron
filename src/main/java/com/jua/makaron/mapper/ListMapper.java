package com.jua.makaron.mapper;

import java.util.List;

import com.jua.makaron.domain.ProductVO;
import com.jua.makaron.domain.Criteria;

public interface ListMapper {
	
	//전체조회(ID순)
	public List<ProductVO> getList();
	
	//검색 - 전체조회(ID순)
	public List<ProductVO> searchAllList(String keyword);
	
	//검색 - 인기순
	public List<ProductVO> PopularList(String keyword);
	
	//검색 - 가격낮은순
	public List<ProductVO> LowPriceList(String keyword);
	
	//검색 - 가격높은순
	public List<ProductVO> HighPriceList(String keyword);
	
	
	public List<ProductVO> getListWithPaging(Criteria cri);
	
	
}

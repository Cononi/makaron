package com.jua.makaron.mapper;

import java.util.List;

import com.jua.makaron.vo.ProductVO;
import com.jua.makaron.domain.CriteriaDTO;

public interface ListMapper {
	
	//전체조회(검색전)
	public List<ProductVO> getAllList(CriteriaDTO cri);
	
	//검색결과
	public List<ProductVO> searchList(CriteriaDTO cri);
	
	//페이지이동 인터페이스객체를 인스턴스화 하는데 필요한 상품 목록 총 개수
	public int getTotalCount(CriteriaDTO cri);
	
	//검색 - 인기순
	public List<ProductVO> PopularList(String keyword);
	
	//검색 - 가격낮은순
	public List<ProductVO> LowPriceList(String keyword);
	
	//검색 - 가격높은순
	public List<ProductVO> HighPriceList(String keyword);
	
	
	public List<ProductVO> getListPaging(CriteriaDTO cri);
	
//	//메인페이지 - top3리스트
//	public List<ProductVO> top3List(CriteriaDTO cri);

}

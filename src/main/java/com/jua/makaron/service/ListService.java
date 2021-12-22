package com.jua.makaron.service;

import java.util.List;

import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.vo.ProductVO;

public interface ListService {
	
	/* 상품 리스트 */
	public List<ProductVO> searchList(CriteriaDTO cri);

	/* 페이지이동 인터페이스객체를 인스턴스화 하는데 필요한 상품 목록 총 개수 */
	public int getTotal(CriteriaDTO cri);
	
	//검색 - 인기순
	public List<ProductVO> PopularList(String keyword);
	
	//검색 - 가격낮은순
	public List<ProductVO> LowPriceList(String keyword);
	
	//검색 - 가격높은순
	public List<ProductVO> HighPriceList(String keyword);
	
	//메인페이지 - top3리스트
//	public List<ProductVO> top3List(CriteriaDTO cri);
	//목록보기(페이징 처리)
	public List<ProductVO> getList(CriteriaDTO cri);
	
	//목록보기(페이지 단위로)
	public List<ProductVO> getListWithPaging(CriteriaDTO cri);
}

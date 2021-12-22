package com.jua.makaron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.vo.ProductVO;
import com.jua.makaron.mapper.ListMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class ListServiceImpl implements ListService {
	
	@Autowired
	private ListMapper ListMapper;
	
	//상품 리스트
	@Override
	public List<ProductVO> searchList(CriteriaDTO cri) {
		log.info("searchList()............");
		return ListMapper.searchList(cri);
	}
	
	//상품 총 개수
	@Override
	public int getTotal(CriteriaDTO cri) {
		
		log.info("get total count");
		return ListMapper.getTotalCount(cri);
	}
	
	
	//검색 - 인기순
	public List<ProductVO> PopularList(String keyword) {
		log.info("popularList()...........");
		return ListMapper.PopularList(keyword);
	}
	
	//검색 - 가격낮은순
	public List<ProductVO> LowPriceList(String keyword) {
		log.info("LowPriceList().............");
		return LowPriceList(keyword);
		
	}
	
	//검색 - 가격높은순
	public List<ProductVO> HighPriceList(String keyword) {
		log.info("HighPriceList().............");
		return HighPriceList(keyword);
	}
	
	
//	public List<ProductVO> top3List(CriteriaDTO cri) {
//		log.info("get top3 List");
//		return ListMapper.top3List(cri);
//	}
}

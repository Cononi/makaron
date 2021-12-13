package com.jua.makaron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jua.makaron.domain.Criteria;
import com.jua.makaron.domain.ProductVO;
import com.jua.makaron.mapper.ListMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ListServiceImpl implements ListService{
	
	private ListMapper mapper;

	public ListServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ProductVO> getList() {
		
		log.info("getList...........");
		
		return mapper.getList();
	}

	@Override
	public List<ProductVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVO get(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductVO> getListWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

}

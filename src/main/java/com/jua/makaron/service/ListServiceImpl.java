package com.jua.makaron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.mapper.ListMapper;
import com.jua.makaron.vo.ProductVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class ListServiceImpl implements ListService {

	private ListMapper mapper;
	
	@Override
	public List<ProductVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ProductVO get(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductVO> getList(CriteriaDTO cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductVO> getListWithPaging(CriteriaDTO cri) {
		// TODO Auto-generated method stub
		return null;
	}

}

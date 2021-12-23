package com.jua.makaron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.mapper.MypageOrderMapper;
import com.jua.makaron.vo.CustomerOrderDetatilsVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
public class MypageOrderServiceImpl implements MypageOrderService {

	private MypageOrderMapper mapper;
	
	@Override
	//주문 내역 불러오기
	public List<CustomerOrderDetatilsVO> getOrderList(String id, CriteriaDTO cri) {
		return mapper.getOrderList(id, cri);
	}
	
	@Override
	//주문 내역 개수 구하기
	public int getOrderQuantity(String id) {
		return mapper.getOrderQuantity(id);
	}

	@Override
	//주문 상세 내역 불러오기
	public CustomerOrderDetatilsVO getOrderDetails(String id, CustomerOrderDetatilsVO cod) {
		return mapper.getOrderDetails(id, cod);
	}
}

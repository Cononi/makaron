package com.jua.makaron.service;

import java.util.List;

import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.vo.CustomerOrderDetatilsVO;

public interface MypageOrderService {

	//1. 주문내역 불러오기 / 주문내역 개수 구하기
	public List<CustomerOrderDetatilsVO> getOrderList(String id, CriteriaDTO cri);
	public int getOrderQuantity(String id);
	
	//2. 주문 상세 내역 불러오기
	public CustomerOrderDetatilsVO getOrderDetails(String id, CustomerOrderDetatilsVO cod);
}

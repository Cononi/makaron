package com.jua.makaron.service;

import java.util.List;

import com.jua.makaron.vo.CustomerOrderDetatilsVO;

public interface MypageOrderService {

	//1. 주문내역 불러오기
	public List<CustomerOrderDetatilsVO> getOrderList(String id);
}

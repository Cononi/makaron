package com.jua.makaron.mapper;

import java.util.List;

import com.jua.makaron.vo.OrderListVO;

public interface MypageOrderMapper {
	
	//1. 주문내역 불러오기
	public List<OrderListVO> getOrderList(String id);
}

package com.jua.makaron.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.vo.CustomerOrderDetatilsVO;

public interface MypageOrderMapper {
	
	//1. 주문내역 불러오기 / 주문내역 개수 구하기
	public List<CustomerOrderDetatilsVO> getOrderList(@Param("id") String id, @Param("cri") CriteriaDTO cri);
	public int getOrderQuantity(String id);
	
	//2. 주문 상세 내역 불러오기
	public CustomerOrderDetatilsVO getOrderDetails(@Param("id") String id, @Param("cod") CustomerOrderDetatilsVO cod);
}

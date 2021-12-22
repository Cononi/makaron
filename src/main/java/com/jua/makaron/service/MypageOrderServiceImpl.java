package com.jua.makaron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jua.makaron.mapper.MypageOrderMapper;
import com.jua.makaron.vo.CustomerOrderDetatilsVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MypageOrderServiceImpl implements MypageOrderService {

	private MypageOrderMapper mapper;
	
	@Override
	//주문 내역 불러오기
	public List<CustomerOrderDetatilsVO> getOrderList(String id) {
		log.info("아이디 확인 : " + id);
		log.info("주문 내역 확인 : " + mapper.getOrderList(id));
		
		return mapper.getOrderList(id);
	}

}

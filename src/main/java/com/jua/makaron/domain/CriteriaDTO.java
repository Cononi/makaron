package com.jua.makaron.domain;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CriteriaDTO {
	
	/* 현재 페이지 */
	private int pageNum;
	
	/* 한 페이지 당 보여질 게시물 갯수 */
	private int amount;
	
	/* 검색 키워드 */
	private String keyword;
	
	/* 검색 타입 */
	private String type;
	
	/* 기본 생성자 -> 기봅 세팅 : pageNum = 1, amount = 10 */
	public CriteriaDTO() {
		this(1,10);
	}
	
	/* 생성자 => 원하는 pageNum, 원하는 amount */
	public CriteriaDTO(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}














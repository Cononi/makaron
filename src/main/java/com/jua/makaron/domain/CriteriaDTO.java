package com.jua.makaron.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CriteriaDTO {
	private int pageNum; //페이지 번호
	private int amount; //페이지당 개수
	
	private String type; //검색종류 ex>TCW or TC  or C
	private String keyword; //검색어
	private String itemName; //아이템이름
	
	//기본 생성자를 통한 초기값
	public CriteriaDTO(){
		//pageNum=1;
		//amount=10;
		this(1,10);
	}
	
	//값을 넣어서 생성
	public CriteriaDTO(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//type 종류 분해(배열로)
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split(""); //문자분리
		
	}
	
	
}













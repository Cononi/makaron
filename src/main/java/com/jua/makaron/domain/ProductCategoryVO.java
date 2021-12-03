package com.jua.makaron.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryVO {
	private int sort_order;
	private String state;
	private String id;
	private String categori_id;
	private String name;
	private String ctg_path;
	private String icon_name;
}

package com.jua.makaron.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryVO {
	private int sort_order;
	private String category_state;
	private String category_id;
	private String main_category_id;
	private String category_name;
	private String ctg_path;
}

package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReviewVO {
	
	private String review_no;
	private String product_id;
	private String customer_id;
	private String review_title;
	private String review_content;
	private String view_count;
	private Date create_date;
	private Date update_date;
	private String is_del;
}

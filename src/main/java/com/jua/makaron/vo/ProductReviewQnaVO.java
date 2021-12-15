package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReviewQnaVO {
	private String qna_no;
	private String product_id;
	private String customer_id;
	private String qna_title;
	private String qna_content;
	private Date create_date;
	private Date update_date;
	private String is_del;
}

package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImageVO {
	private long image_no;
	private String product_id;
	private String file_url;
	private String file_name;
	private String is_del;
	private Date create_date;
	private Date update_date;
}

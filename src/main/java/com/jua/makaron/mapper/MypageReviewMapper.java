package com.jua.makaron.mapper;

import com.jua.makaron.vo.ReviewVO;

public interface MypageReviewMapper {

	//1. 후기 내역 불러오기
	public ReviewVO getReviewList(String id);
		
	//2. 후기 작성하기 / 후기 이미지 작성하기
	public void insertReview(String id, String product_title, String review_title, String review_content);
	//public void insertReviewImage(String id, String file_url, String file_name);
		
	//3. 후기 삭제하기
	public void deleteReview(String id, String no);
}

package com.jua.makaron.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.vo.ProductQnaVO;
import com.jua.makaron.vo.ProductReviewVO;

public interface MypageReviewMapper {

	//1. 후기 내역 불러오기 / 후기 글 개수 구하기
	public List<ProductReviewVO> getReviewList(@Param("id") String id, @Param("cri") CriteriaDTO cri); 
	public int getReviewQuantity(String id);
		
	//2. 작성할 수 있는 후기의 상품명, 주문번호 불러오기 / 후기 작성하기 / 후기 이미지 작성하기
	public List<ProductReviewVO> chooseToWrite(String id);
	public void insertReview(@Param("id") String id, @Param("review") ProductReviewVO review);
	//public void insertReviewImage(String id, String file_url, String file_name);
		
	//3. 후기 삭제하기
	public void deleteReview(ProductReviewVO review);
}

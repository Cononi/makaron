<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ include file="../includes/header.jsp" %>

<!-- 헤더 끝 -->

	<!-- myPage -->
	<div class="myPage">

		<!-- myPageTop -->
		<div class="myPageTop">
			
			<!-- container -->
			<div class="container">
				
				<div class="item">
					<span class="user_infor">
						<h3><b>${customerName} 님,</b></h3>
						<br>
						<h4>환영합니다!</h4>
					</span>
				</div>
				
				<div class="item">
					<span class="user_infor">
						<h3><b>회원 등급</b></h3>
						<br>
						<h4>${customerRating}</h4>
					</span>
				</div>
				
				<div class="item">
					<span class="user_infor">
						<h3><b>쿠폰</b></h3>
						<br>
						<h4>${customerCoupon} 개</h4>
					</span>
				</div>
			
			<!-- container -->
			</div>
	
		<!-- myPageTop -->  
		</div>
		
		<!-- myPageMain -->
		<div class="myPageMain">
				
			<!-- container -->
			<div class="container">
				
				<!-- dropdown-->
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						MyPage Menu
					</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="/mypage/main">주문 내역</a>
						<a class="dropdown-item" href="/mypage/address">배송지 관리</a>
						<a class="dropdown-item" href="/mypage/review">상품 후기</a>
						<a class="dropdown-item" href="/mypage/question">상품 문의</a>
					</div>
				</div> 

				<!-- review -->
				<div class="review">
					<h3><b>상품 후기</b></h3>
					<span class="review_description" style="float:left">
						상품 후기는 구매확정 후 30일간 작성이 가능합니다.
					</span> 
					<span style="float:right">
						<button class="add_review" id="addReview" onclick="addReview();">+ 상품 후기 등록</button> 
					</span>
					<br>
					<hr style="border: solid 1px black;">
				</div> 
				
				<div class="reviewList">
					<table class="reviewTable" border="1">
						<tr>
							<td>후기 번호</td>
							<td>후기 작성일</td>
							<td>상품명</td>
							<td>상품 가격</td>
							<td>리뷰 제목</td>
							<td>리뷰 내용</td>
							<td>삭제 하기</td>
						</tr>
					<c:forEach items="${reviewList}" var="list">
						<tr>
							<td>${list.review_no}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.update_date}" /> </td>
							<td>${list.product_title} </td>
							<td>${list.product_price} </td>
							<td>${list.review_title} </td>
							<td>${list.review_content} </td>
							<td>
								<form action="deleteReview" method="post">
									<input type="hidden" name="review_no" value="${list.review_no}">
									<button type="submit">삭제</button>
								</form>
							</td> 
						</tr>
					</c:forEach>
					</table>
				</div>

			<!-- container  -->
			</div>
			
		<!-- myPageMain -->
		</div>
	
	<!-- my Page  -->	
	</div> 
	
	<script type="text/javascript">
		function addReview() {
			console.log("후기 작성 버튼 눌림");
			window.open("addReview", "후기 작성 페이지", "width=640, height=400");
		}
	</script>

<!-- 푸터 시작 -->
<%@ include file="../includes/footer.jsp" %>
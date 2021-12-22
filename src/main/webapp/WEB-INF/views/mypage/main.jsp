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
			
				<!-- order -->
				<div class="order">
					<h3><b>주문 내역</b></h3>
					<span class="order_description" style="float:left">
						지난 3년간의 주문을 조회할 수 있습니다.
					</span>
					<span style="float:right">
						<select class="order-term">
							<option id="all">전체기간</option>
							<option id="y2021">2021년</option>
							<option id="y2020">2020년</option>
							<option id="y2019">2019년</option>
						</select>
					</span>
					<br>
					<hr style="border: solid 1px black;">
				</div>
				
				<div class="orderList">
					<table class="orderTable" border="1">
						<tr>
							<td>주문일</td>
							<td>주문번호</td>
							<td>상품명</td>
							<td>상품 이미지</td>
							<td>상품 가격</td>
							<td>수량</td>
							<td>최종 가격</td>
							<td>주문 상태</td>
						</tr>
					<c:forEach items="${orderList}" var="list">
						<tr>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.order_date}" /> </td>
							<td>${list.order_id} </td>
							<td>${list.product_title} </td>
							<td class="product_img"><img src="${list.file_url}/${list.file_name}" style="width:250px; height:300px;" /></td>
							<td>${list.product_price} </td>
							<td>${list.total_count} </td>
							<td>${list.final_price} </td>
							<td>${list.state_list_name} </td>
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
		
<!-- 푸터 시작 -->
<%@ include file="../includes/footer.jsp" %>
					
					





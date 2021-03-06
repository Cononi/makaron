<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
						<h3><b>ㅇㅇㅇ님</b></h3>
						<br>
						<a href="grade"><h4>ㅇㅇ등급 혜택 보기 ></h4></a>
					</span>
				</div>
				
				<div class="item">
					<span class="user_infor">
						<h3><b>적립금</b></h3>
						<br>
						<a href="point"><h4>0원 ></h4></a>
					</span>
				</div>
				
				<div class="item">
					<span class="user_infor">
						<h3><b>쿠폰</b></h3>
						<br>
						<a href="coupon"><h4>0개 ></h4></a>
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
				<div class="address">
					<h3><b>배송지 관리</b></h3>
					<span class="address_description" style="float:left">
						배송지는 최대 5개까지 등록이 가능합니다.
					</span> 
					<span style="float:right">
						<button class="add_address">+ 새 배송지 추가</button> 
					</span>
					<br>
					<hr style="border: solid 1px black;">
				</div> 
				
			<!-- container  -->
			</div>
			
		<!-- myPageMain -->
		</div>
	
	<!-- my Page  -->	
	</div> 

<!-- 푸터 시작 -->
<%@ include file="../includes/footer.jsp" %>
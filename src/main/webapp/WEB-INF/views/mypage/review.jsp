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
						<thead>
							<tr>
								<th>후기 번호</th>
								<th>후기 작성일</th>
								<th>상품명</th>
								<th>상품 가격</th>
								<th>리뷰 제목</th>
								<th>리뷰 내용</th>
								<th>삭제 하기</th>
							</tr>
						</thead>
						
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
										<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum}"/>'>
										<input type="hidden" name="amount" value='<c:out value="${pageMaker.cri.amount}"/>'>
										<button type="submit">삭제</button>
									</form>
								</td> 
							</tr>
						</c:forEach>
					</table>
				</div>
				<br>

				<!-- paging -->
				<div class = "paging">
					<nav aria-label="Page navigation example">
						<ul class ="pagination justify-content-center">
								
							<c:if test = "${pageMaker.prev}">
								<li class="page-item"> 
									<a class="page-link" href="${pageMaker.startPage - 1}">&laquo;</a>
								</li>
							</c:if>
								
							<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
								<li class="page-item ${pageMaker.cri.pageNum == num ? 'active':''} "> 
									<a class="page-link" href="${num}">${num}</a>
								</li>
							</c:forEach>
								
							<c:if test = "${pageMaker.next}">
								<li class="page-item"> 
									<a class="page-link" href="${pageMaker.endPage + 1}">&raquo;</a>
								</li>
							</c:if>
								
						</ul>
					</nav>
				</div>
				
				<!-- paging 처리를 위한 pageNum, amount 전달 -->
				<form id="actionForm" action="/mypage/review" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				</form>

			<!-- container  -->
			</div>
			
		<!-- myPageMain -->
		</div>
	
	<!-- my Page  -->	
	</div> 
	
	<!-- 문의 작성 버튼 자바스크립트 -->
	<script type="text/javascript">
		function addReview() {
			console.log("후기 작성 버튼 눌림");
			window.open("addReview", "후기 작성 페이지", "width=640, height=400");
		}
	</script>
	
	<!-- paging 처리를 위한 jQuery -->
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
	    
			var actionForm = $("#actionForm"); //id가 actionForm인 것을 불러옴 => 여기서는 form태그의 id=actionForm
			
			$(".page-item a").on("click", function(e){
				
				e.preventDefault();
				
				console.log('click');
				
				actionForm.find("input[name='pageNum']").val($(this).attr("href"));
				actionForm.submit();
			});
			
		});
	</script>

<!-- 푸터 시작 -->
<%@ include file="../includes/footer.jsp" %>
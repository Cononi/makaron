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
	
		<!-- container -->
		<div class="container">
				
			<!-- orderDetails -->
			<div class="orderMain">
				<h3><b>주문 상세 내역</b></h3>
				<br>
				
				<table class="orderTable" border="1">
					<thead>
						<tr>
							<th>주문번호</th>
							<th>주문일</th>
							<th>상품명</th>
							<th>상품 이미지</th>
							<th>상품 가격</th>
							<th>수량</th>
							<th>최종 가격</th>
							<th>주문 상태</th>
						</tr>
					</thead>
							
						
						<tr>
							<td>${orderDetails.order_id} </td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${orderDetails.order_date}" /> </td>
							<td>${orderDetails.product_title} </td>
							<td class="product_img"><img src="${orderDetails.file_url}/${orderDetails.file_name}" style="width:250px; height:300px;" /></td>
							<td>${orderDetails.product_price} </td>
							<td>${orderDetails.total_count} </td>
							<td>${orderDetails.final_price} </td>
							<td>${orderDetails.state_list_name} </td>
						</tr>
							
				</table>
				
				<br>
				<hr style="border: solid 1px black;">
			</div>
					
			<div class="orderDetails">
				<table class="orderTable" border="1">
					<thead>
						<tr>
							<th>주문자</th>
							<th>받는 사람</th>
							<th>주소</th>
							<th>연락처</th>
							<th>운송장 번호</th>
							<th>배송 메모</th>
							<th>구매확정 날짜</th>
						</tr>
					</thead>
							
						<tr>
							<td>${orderDetails.name} </td>
							<td>${orderDetails.subject_name} </td>						
							<td>${orderDetails.address_base} ${orderDetails.address_sub}</td>
							<td>${orderDetails.subject_number} </td>
							<td>${orderDetails.invoice_number} </td>
							<td>${orderDetails.order_messege} </td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${orderDetails.confirmation_date}" /> </td>
						</tr>
				</table>
			</div>
					
		<!-- container  -->
		</div>
		
	<!-- my Page  -->	
	</div>

<!-- 푸터 시작 -->
<%@ include file="../includes/footer.jsp" %>
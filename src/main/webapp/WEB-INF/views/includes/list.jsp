<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ include file="header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="container">

		<div class='row'>
			<div class="col-lg-12">
				<form id='searchForm' action="/list" method='get'>
					<input type='text' name='keyword' /> <input type='hidden'
						name='pageNum' value='${pageMaker.cri.pageNum}'> <input
						type='hidden' name='amount' value='${pageMaker.cri.amount}'>
					<button class='btn btn-default'>검색</button>
				</form>
				<ul class="nav justify-content-end">
					<li class="nav-item"><a class="nav-link active" href="#">인기순</a></li>
					<li class="nav-item"><a class="nav-link" href="#">가격낮은순</a></li>
					<li class="nav-item"><a class="nav-link" href="#">가격낮은순</a></li>
				</ul>
			</div>
		</div>

		<div class="main-item-box">
			<c:forEach var="product" items="${list}">
				<div class="main-prd-box">
					<a class="link-prod"
						href="/makaron/list/?cmd=detail&prodNo=${productVO.ID}"></a> <img
						src="${productVO.priduct_image_id}" class="item-img" />
					<!-- 상품이미지 -->
					<ul class="itemList">
						<li class="title">${productVO.title}</li>
						<!-- 상품명 -->
						<li class="sub_title">${productVO.sub_title}</li>
						<!-- 서브제목 -->
						<li class="sale_price">${productVO.sale_price}</li>
						<!-- 할인율 -->
						<li class="final_price">${productVO.final_price}</li>
						<li class="price">${productVO.price}</li>
						<li class="max_count">${productVO.max_count}</li>
					</ul>
				</div>
			</c:forEach>



			<div class="dataTables_paginate paging_simple_numbers"
				id="dataTables-example_paginate">
				<ul class="pagination">

					<li
						class="paginate_button previous ${pageMaker.cri.pageNum==1 ? 'disabled' : ''  }  "
						aria-controls="dataTables-example" tabindex="0"
						id="dataTables-example_previous"><a
						href="${pageMaker.cri.pageNum-1 }">이전</a></li>


					<c:forEach begin="${pageMaker.startPage}"
						end="${pageMaker.endPage }" var="num">
						<li class="paginate_button ${pageMaker.cri.pageNum == num ? "
							active" : "" } " aria-controls="dataTables-example" tabindex="0">
							<a href="${num}">${num}</a>
						</li>
					</c:forEach>

					<li
						class="paginate_button next 
		                           	    ${pageMaker.next==false ? 'disabled' : '' } "
						aria-controls="dataTables-example" tabindex="0"
						id="dataTables-example_next"><a
						${pageMaker.next==false ? 'class="disabled"' : '' }
						href="${pageMaker.cri.pageNum+1 }">다음</a></li>
				</ul>
				<form id="actionForm" action="/board/list" method="get">
					<input type="hidden" name="pageNum"
						value="${pageMaker.cri.pageNum}"> <input type="hidden"
						name="amount" value="${pageMaker.cri.amount}">
				</form>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page trimDirectiveWhitespaces="true"%>
<link href="plugins/malihu-custom-scrollbar/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/categories.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/categories_responsive.css">
<%@ include file="./includes/header.jsp"%>
<br>
<br>
<br>
<br>
<br>
<br>
<br>






<div class="super_container">

	<div class="search_wrap">
		<div class="blockquote text-center">
			<form id="searchFrom"
				action="${pageContext.request.contextPath}/list" method="get">
				<div class="search_input">
					<input type="text" name="keyword"
						value='<c:out value="${pageMaker.cri.keyword}"></c:out>'>
					<button class='btn search_btn'>검 색</button>
				</div>
			</form>
		</div>
	</div>


	<!-- Products -->

	<div class="products">
		<div class="row">
			<div class="col-12">
				<div class="product_sorting clearfix">
					<div class="view">
						<div class="view_box box_view">
							<i class="fa fa-th-large" aria-hidden="true"></i>
						</div>
						<div class="view_box detail_view">
							<i class="fa fa-bars" aria-hidden="true"></i>
						</div>
					</div>
					<div class="sorting">
						<ul class="item_sorting">
							<li><span class="sorting_text">Show all</span> <i
								class="fa fa-caret-down" aria-hidden="true"></i>
								<ul>
									<li class="product_sorting_btn"
										data-isotope-option='{ "sortBy": "original-order" }'><span>전체보기</span></li>
									<li class="product_sorting_btn"
										data-isotope-option='{ "sortBy": "price" }'><span>인기순</span></li>
									<li class="product_sorting_btn"
										data-isotope-option='{ "sortBy": "stars" }'><span>낮은가격순</span></li>
									<li class="product_sorting_btn"
										data-isotope-option='{ "sortBy": "stars" }'><span>높은가격순</span></li>
								</ul></li>
							<li><span class="sorting_text">Show</span> <span
								class="num_sorting_text">12</span> <i class="fa fa-caret-down"
								aria-hidden="true"></i>
								<ul>
									<li class="num_sorting_btn"><span>3</span></li>
									<li class="num_sorting_btn"><span>6</span></li>
									<li class="num_sorting_btn"><span>12</span></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>



<div class="row products_container">
	<div class="col">

		<!-- Products -->

		<div class="product_grid">

			<c:forEach items="${list}" var="lists">
				<div class="product">
					<div class="product_image">
						<img
							src="${pageContext.request.contextPath}/resources/images/product_1.jpg"
							alt="">
					</div>
					<div class="product_content clearfix">
						<div class="product_info">
							<div class="product_name">
								<a href="product.html">${lists.product_title}</a>
							</div>
							<div class="product_price">${lists.product_price}원</div>
							<div class="product_count">${lists.max_count}개구매중</div>
							<div class="product_delivery">배송비 ${lists.delivery_charge}원</div>
						</div>
						<div class="product_options">
							<div class="product_buy product_option">
								<img src="images/shopping-bag-white.svg" alt="">
							</div>
							<div class="product_fav product_option">+</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>



</div>



<!-- Sidebar Right -->


<!-- Extra -->




<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/styles/bootstrap4/popper.js"></script>
<script src="${pageContext.request.contextPath}/resources/styles/bootstrap4/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/easing/easing.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/parallax-js-master/parallax.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/malihu-custom-scrollbar/jquery.mCustomScrollbar.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/categories_custom.js"></script>

<%@ include file="./includes/footer.jsp"%>
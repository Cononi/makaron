<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Product</title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Wish shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="resources/styles/bootstrap4/bootstrap.min.css">
<link href="resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/styles/product.css">
<link rel="stylesheet" type="text/css" href="resources/styles/product_responsive.css">
</head>
<body>

<div class="super_container">
	
	<!-- Header -->
	<header class="header"> 
		<div class="header_inner d-flex flex-row align-items-center justify-content-start">
			<div class="logo"><a href="/">Makaron</a></div>
			<nav class="main_nav">
				<ul>
				<c:forEach items="${category}" var="list">
					<c:if test="${list.main_category_id == '1000'}">
						<li class="menu_mm"><a href="cate?keyword=${list.category_id}">${list.category_name}</a></li>
					</c:if>
				</c:forEach>
					<li><a href="${pageContext.request.contextPath}/notice">notice</a></li>
				</ul>
			</nav>
			<div class="header_content ml-auto">
				<div class="search header_search">
					<form action="${pageContext.request.contextPath}/list">
							<input class="search_input" type="search" id="keyword" name="keyword" placeholder="검색어를 입력하세요" />
							<button id="search_button" type="submit" class="search_button"><img src="resources/images/magnifying-glass.svg" alt=""></button>
					</form>
					
				</div>
				<div class="shopping">
					<!-- Cart -->
					<a href="/cart">
						<div class="cart">
							<img src="${pageContext.request.contextPath}/resources/images/shopping-bag.svg" alt="">
							<div class="cart_num_container">
								<div class="cart_num_inner">
									<div class="cart_num">1</div>
								</div>
							</div>
						</div>
					</a>
					<!-- Star -->
					<a href="#">
						<div class="star">
							<img src="${pageContext.request.contextPath}/resources/images/star.svg" alt="">
							<div class="star_num_container">
								<div class="star_num_inner">
									<div class="star_num">0</div>
								</div>
							</div>
						</div>
					</a>
					<!-- Avatar -->
					<a href="${pageContext.request.contextPath}/mypage/main">
						<div class="avatar">
							<img src="${pageContext.request.contextPath}/resources/images/avatar.svg" alt="">
						</div>
					</a>
			<div class="user_logreg">
					<c:if test="${login == null}">
						<a href="${pageContext.request.contextPath}/login">로그인</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/register">회원가입</a>
					</c:if>
			</div>
				</div>
			</div>
			
			<div class="burger_container d-flex flex-column align-items-center justify-content-around menu_mm"><div></div><div></div><div></div></div>
		</div>
	</header>

	<!-- Menu -->

	<div class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
		<div class="menu_close_container"><div class="menu_close"><div></div><div></div></div></div>
		<div class="logo menu_mm"><a href="index.html">Makaron</a></div>
		<div class="list">
			<form action="${pageContext.request.contextPath}/list">
			
				<input type="search" class="search_input menu_mm" required="required">
				<button type="submit" id="search_button_menu" class="search_button menu_mm"><img class="menu_mm" src="${pageContext.request.contextPath}/resources/images/magnifying-glass.svg" alt=""></button>

			</form>
		</div>
		<nav class="menu_nav">
			<ul class="menu_mm">
				<c:forEach items="${category}" var="list">
					<c:if test="${list.main_category_id == '1000'}">
						<li class="menu_mm"><a href="#">${list.category_name}</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</nav>
		<div><a href="${pageContext.request.contextPath}/login">로그인</a>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/register">회원가입</a></div>
	</div>
</div>	
	<!-- H

	<!-- Product -->
	
	<div class="product">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="current_page">
						<ul>
							<li><a href="categories.html">Woman's Fashion</a></li>
							<li><a href="categories.html">Swimsuits</a></li>
							<li>2 Piece Swimsuits</li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="row product_row">

				<!-- Product Image -->
				<div class="col-lg-7">
					<div class="product_image">
						<div class="product_image_large"><img src="${product.file_url}/${product.file_name}" alt=""></div>
<!-- 					 	<div class="product_image_thumbnails d-flex flex-row align-items-start justify-content-start"> -->
<!-- 							<div class="product_image_thumbnail" style="background-image:url(images/product_image_1.jpg)" data-image="images/product_image_1.jpg"></div> -->
<!-- 							<div class="product_image_thumbnail" style="background-image:url(images/product_image_2.jpg)" data-image="images/product_image_2.jpg"></div> -->
<!-- 							<div class="product_image_thumbnail" style="background-image:url(images/product_image_4.jpg)" data-image="images/product_image_4.jpg"></div> -->
<!-- 						</div> -->
					</div>
				</div>
		
				<!-- Product Content -->
				<div class="col-lg-5">
					<div class="product_content">
						<div class="product_name">${product.product_title}</div>
						<div class="product_price">${product.product_price}</div>
						
						<div class="rating rating_4" data-rating="4">
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
						</div>
						<!-- In Stock -->
<!-- 						<div class="in_stock_container"> -->
<!-- 							<div class="in_stock in_stock_true"></div> -->
<!-- 							<span>in stock</span> -->
<!-- 						</div> -->
						<div class="product_text">
							<p>상품간단한 소개</p>
						</div>
						<!-- Product Quantity -->
						<div class="product_quantity_container">
							<span>수량</span>
							<div class="product_quantity clearfix">
								<input id="quantity_input" type="text" pattern="[0-9]*" value="1">
								<div class="quantity_buttons">
									<div id="quantity_inc_button" class="quantity_inc quantity_control"><i class="fa fa-caret-up" aria-hidden="true"></i></div>
									<div id="quantity_dec_button" class="quantity_dec quantity_control"><i class="fa fa-caret-down" aria-hidden="true"></i></div>
								</div>
							</div>
						</div>
						<!-- Product Size -->
						<div class="product_size_container">
<!-- 							<span>Size</span> -->
<!-- 							<div class="product_size"> -->
<!-- 								<ul class="d-flex flex-row align-items-start justify-content-start"> -->
<!-- 									<li> -->
<!-- 										<input type="radio" id="radio_1" name="product_radio" class="regular_radio radio_1"> -->
<!-- 										<label for="radio_1">XS</label> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<input type="radio" id="radio_2" name="product_radio" class="regular_radio radio_2" checked> -->
<!-- 										<label for="radio_2">S</label> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<input type="radio" id="radio_3" name="product_radio" class="regular_radio radio_3"> -->
<!-- 										<label for="radio_3">M</label> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<input type="radio" id="radio_4" name="product_radio" class="regular_radio radio_4"> -->
<!-- 										<label for="radio_4">L</label> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<input type="radio" id="radio_5" name="product_radio" class="regular_radio radio_5"> -->
<!-- 										<label for="radio_5">XL</label> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 							</div> -->
							
							<div class="button cart_button"><a href="/cart">장바구니에 추가</a></div>
							<div class="button cart_button btn2"><a href="/checkout">결제창가기</a></div>
							
						</div>
					</div>
				</div>
			</div>
			
			<!-- Reviews -->

			<div class="row roww">
				<div class="col">
					<div class="reviews">
					<ul class="nav nav-tabs" id="myTab" role="tablist">
								<li class="nav-item">
								  <a class="nav-link active coll" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true" >상세정보</a>
								</li>
								<li class="nav-item">
								  <a class="nav-link coll" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">상품평</a>
								</li>
								<li class="nav-item">
								  <a class="nav-link coll" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false" >상품문의</a>
								</li>
								<li class="nav-item">
								  <a class="nav-link coll" id="contact-tab" data-toggle="tab" href="#deli" role="tab" aria-controls="contact" aria-selected="false">배송/교환/반품 안내</a>
								</li>
					</ul>
					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">상세정보</div>
						<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
							<div class="reviews_container">
							<ul>
								<c:forEach items="${review}" var="rev">
									<!-- Review -->
									<li class=" review clearfix">
										<div class="review_image"><img src="resources/images/review_1.jpg" alt=""></div>
										<div class="review_content">
											<div class="review_name"><a href="#">${rev.customer_id}</a></div>
											<div class="review_title">${rev.review_title}</div>
											<div class="review_date">${rev.create_date}</div>
											<div class="rating rating_4 review_rating" data-rating="4">
												<i class="fa fa-star"></i>
												<i class="fa fa-star"></i>
												<i class="fa fa-star"></i>
												<i class="fa fa-star"></i>
												<i class="fa fa-star"></i>
											</div>
											<div class="review_text">
												<p>${rev.review_content}</p>
											</div>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
						</div>
						<div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
							<span style="float:right">
								 <button id="addQna" onclick="addQna()">문의하기</button>
							</span>
							<table class="table">
								<thead>
								 <tr>
								 	<th>번호</th>
								 	<th>상품명</th>
								 	<th>문의</th>
								 	<th>작성자</th>
								 	<th>작성일</th>
									
								 </tr>
								</thead>
								<tbody>
								<c:forEach var="qna1" items="${qna}">
								<tr>
									<td>${qna1.qna_no}</td>
									<td>${qna1.product_title}</td>
									<td>${qna1.qna_title}</td>
									<td>${qna1.customer_id}</td>
									
									<td><fmt:formatDate pattern="yyyy-MM-dd" value="${qna1.create_date}"/></td>
								</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="tab-pane fade" id="deli" role="tabpanel" aria-labelledby="contact-tab">배송</div>
					</div>
					</div>
				</div>
			</div>

			<!-- Leave a Review -->

			<div class="row">
				<div class="col">
					<div class="review_form_container">
						<div class="review_form_title">상품 문의</div>
						<div class="review_form_content">
							<form action="#" id="review_form" class="review_form">
								<div class="d-flex flex-md-row flex-column align-items-start justify-content-between">
									<input type="text" class="review_form_input" placeholder="Name" required="required">
									<input type="email" class="review_form_input" placeholder="E-mail" required="required">
									<input type="text" class="review_form_input" placeholder="Subject">
								</div>
								<textarea class="review_form_text" name="review_form_text" placeholder="Message"></textarea>
								<button type="submit" class="review_form_button">문의하기</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>		
	</div>

	<!-- Newsletter -->

	<!-- <div class="newsletter">
		<div class="newsletter_content">
			<div class="newsletter_image" style="background-image:url(images/newsletter.jpg)"></div>
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="section_title_container text-center">
							<div class="section_subtitle">only the best</div>
							<div class="section_title">subscribe for a 20% discount</div>
						</div>
					</div>
				</div>
				<div class="row newsletter_container">
					<div class="col-lg-10 offset-lg-1">
						<div class="newsletter_form_container">
							<form action="#">
								<input type="email" class="newsletter_input" required="required" placeholder="E-mail here">
								<button type="submit" class="newsletter_button">subscribe</button>
							</form>
						</div>
						<div class="newsletter_text">Integer ut imperdiet erat. Quisque ultricies lectus tellus, eu tristique magna pharetra nec. Fusce vel lorem libero. Integer ex mi, facilisis sed nisi ut, vestib ulum ultrices nulla. Aliquam egestas tempor leo.</div>
					</div>
				</div>
			</div>
		</div>
	</div>  -->

	<!-- Footer -->

	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col text-center">
				<!--  	<div class="footer_logo"><a href="/makaron">Makaron</a></div>
					<nav class="footer_nav">
						<ul>
							<li><a href="index.html">home</a></li>
							<li><a href="categories.html">clothes</a></li>
							<li><a href="categories.html">accessories</a></li>
							<li><a href="categories.html">lingerie</a></li>
							<li><a href="contact.html">contact</a></li>
						</ul>
					</nav>-->
					<div class="footer_social">
						<ul>
							<li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-reddit-alien" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
						</ul>
					</div>
					<div class="copyright"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></div>
				</div>
			</div>
		</div>
	</footer>
</div>
<script type="text/javascript">
	function addQna() {
		window.open("addQna?product_id=${product.product_id}","문의페이지", "width=650, height=500");
	}
</script>
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/styles/bootstrap4/popper.js"></script>
<script src="resources/styles/bootstrap4/bootstrap.min.js"></script>
<script src="resources/plugins/easing/easing.js"></script>
<script src="resources/plugins/parallax-js-master/parallax.min.js"></script>
<script src="resources/js/cart_custom.js"></script>
</body>
</html>
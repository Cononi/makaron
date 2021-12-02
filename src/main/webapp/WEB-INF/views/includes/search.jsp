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




	<div class="arrivals">
		<div class="container">

			<div class="row products_container">

				<!-- Product -->
				<div class="col-lg-4 product_col">
					<div class="product">
						<div class="product_image">
							<img src="resources/images/product_1.jpg" alt="">
						</div>
						<div class="rating rating_4">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product_content clearfix">
							<div class="product_info">
								<div class="product_name">
									<a href="product.html">Woman's Long Dress</a>
								</div>
								<div class="product_price">$45.00</div>
							</div>
							<div class="product_options">
								<div class="product_buy product_option">
									<img src="resources/images/shopping-bag-white.svg" alt="">
								</div>
								<div class="product_fav product_option">+</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Product -->
				<div class="col-lg-4 product_col">
					<div class="product">
						<div class="product_image">
							<img src="resources/images/product_2.jpg" alt="">
						</div>
						<div class="rating rating_4">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product_content clearfix">
							<div class="product_info">
								<div class="product_name">
									<a href="product.html">2 Piece Swimsuit</a>
								</div>
								<div class="product_price">$35.00</div>
							</div>
							<div class="product_options">
								<div class="product_buy product_option">
									<img src="resources/images/shopping-bag-white.svg" alt="">
								</div>
								<div class="product_fav product_option">+</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Product -->
				<div class="col-lg-4 product_col">
					<div class="product">
						<div class="product_image">
							<img src="resources/images/product_3.jpg" alt="">
						</div>
						<div class="rating rating_4">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product_content clearfix">
							<div class="product_info">
								<div class="product_name">
									<a href="product.html">Man Blue Jacket</a>
								</div>
								<div class="product_price">$145.00</div>
							</div>
							<div class="product_options">
								<div class="product_buy product_option">
									<img src="resources/images/shopping-bag-white.svg" alt="">
								</div>
								<div class="product_fav product_option">+</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>



	<%@ include file="footer.jsp"%>
</body>
</html>
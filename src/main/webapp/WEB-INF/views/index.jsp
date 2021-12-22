<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ include file="./includes/header.jsp" %>

	<!-- Home -->

	<div class="home">
		<!-- Home Slider -->

		<div class="home_slider_container">
			<div class="owl-carousel owl-theme home_slider">
				<!-- Home Slider Item -->
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(resources/images/home_slider_1.jpg)"></div>
					<div class="home_slider_content">
						<div class="home_slider_content_inner">
							<div class="home_slider_subtitle">Promo Prices</div>
							<div class="home_slider_title">New Collection</div>
						</div>	
					</div>
				</div>

				<!-- Home Slider Item -->
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(resources/images/home_slider_1.jpg)"></div>
					<div class="home_slider_content">
						<div class="home_slider_content_inner">
							<div class="home_slider_subtitle">Promo Prices</div>
							<div class="home_slider_title">New Collection</div>
						</div>	
					</div>
				</div>

				<!-- Home Slider Item -->
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(resources/images/home_slider_1.jpg)"></div>
					<div class="home_slider_content">
						<div class="home_slider_content_inner">
							<div class="home_slider_subtitle">Promo Prices</div>
							<div class="home_slider_title">New Collection</div>
							
						</div>	
					</div>
				</div>

			</div>
			
			<!-- Home Slider Nav -->

			<div class="home_slider_next d-flex flex-column align-items-center justify-content-center"><img src="resources/images/arrow_r.png" alt=""></div>

			<!-- Home Slider Dots -->

			<div class="home_slider_dots_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="home_slider_dots">
								<ul id="home_slider_custom_dots" class="home_slider_custom_dots">
									<li class="home_slider_custom_dot active">01.<div></div></li>
									<li class="home_slider_custom_dot">02.<div></div></li>
									<li class="home_slider_custom_dot">03.<div></div></li>
								</ul>
							</div>
						</div>
					</div>
				</div>		
			</div>
		</div>
	</div>


	<!-- Gallery -->

	<div class="gallery">
		<div class="gallery_image" style="background-image:url(resources/images/makaronback.jpg)"></div>
		<div class="container">
					<div class="row">
				<div class="col">
					<div class="section_title_container text-center align-items-center">
						<div class="section_subtitle">오늘 이거 어때요?</div>
						<div class="section_title">아주 달콤한 디저트</div>
					</div>
				</div>
			</div>
		</div>	
		<div class="gallery_slider_container">
			
			<!-- Gallery Slider -->
			<div class="owl-carousel owl-theme gallery_slider">
				
				<!-- Gallery Item -->
				<div class="owl-item gallery_item">
					<a class="colorbox" href="resources/images/gallery_1.jpg">
						<img src="resources/images/gallery_1.jpg" alt="">
					</a>
				</div>

				<!-- Gallery Item -->
				<div class="owl-item gallery_item">
					<a class="colorbox" href="resources/images/gallery_2.jpg">
						<img src="resources/images/gallery_2.jpg" alt="">
					</a>
				</div>

				<!-- Gallery Item -->
				<div class="owl-item gallery_item">
					<a class="colorbox" href="resources/images/gallery_3.jpg">
						<img src="resources/images/gallery_3.jpg" alt="">
					</a>
				</div>

				<!-- Gallery Item -->
				<div class="owl-item gallery_item">
					<a class="colorbox" href="resources/images/gallery_4.jpg">
						<img src="resources/images/gallery_4.jpg" alt="">
					</a>
				</div>

				<!-- Gallery Item -->
				<div class="owl-item gallery_item">
					<a class="colorbox" href="resources/images/gallery_5.jpg">
						<img src="resources/images/gallery_5.jpg" alt="">
					</a>
				</div>

				<!-- Gallery Item -->
				<div class="owl-item gallery_item">
					<a class="colorbox" href="resources/images/gallery_6.jpg">
						<img src="resources/images/gallery_6.jpg" alt="">
					</a>
				</div>

			</div>
		</div>	
	</div>		
	<!-- New Arrivals -->

	<div class="arrivals">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center align-items-center">
						<div class="section_subtitle">오늘 이거 어때요?</div>
						<div class="section_title">아주 달콤한 디저트</div>
					</div>
				</div>
			</div>
			<div class="row products_container">
				<div class="owl-carousel user_slider text-center">
				<c:forEach var="pro" items="${product}">
				<!-- Product -->
				<div class="owl-item">					
				<div class="col-lg-4 product_col">
					<div class="product">
						<div class="product_image">
							<a href="/product?product_id=${pro.product_id}"><img src="${pro.file_url}/${pro.file_name}" alt=""></a>
						</div>
						
						<div class="product_content clearfix">
				
							<div class="product_info">
								<div class="product_name"><a href="/product?product_id=${pro.product_id}">${pro.product_title}</a></div>
								<div class="product_price"><a href="/product?product_id=${pro.product_id}">${pro.product_price}</a></div>
							</div>
							<div class="product_options">
								<div class="product_buy product_option"><img src="resources/images/shopping-bag-white.svg" alt=""></div>
								<div class="product_fav product_option">+</div>
							</div>
						</div>
					</div>
				</div>
				</div>
				</c:forEach>
				<!--Product -->
<!-- 				<div class="owl-item"> -->
<!-- 				<div class="col-lg-4 product_col"> -->
<!-- 					<div class="product"> -->
<!-- 						<div class="product_image"> -->
<!-- 							<a href="/product"><img src="resources/images/cake2.jpg" alt=""></a> -->
<!-- 						</div> -->
<!-- 						<div class="rating rating_4"> -->
<!-- 							<i class="fa fa-star"></i> -->
<!-- 							<i class="fa fa-star"></i> -->
<!-- 							<i class="fa fa-star"></i> -->
<!-- 							<i class="fa fa-star"></i> -->
<!-- 							<i class="fa fa-star"></i> -->
<!-- 						</div> -->
<!-- 						<div class="product_content clearfix"> -->
<!-- 							<div class="product_info"> -->
<!-- 								<div class="product_name"><a href="product.html"></a></div> -->
<%-- 								<div class="product_price">${product.product_price}</div> --%>
<!-- 							</div> -->
<!-- 							<div class="product_options"> -->
<!-- 								<div class="product_buy product_option"><img src="resources/images/shopping-bag-white.svg" alt=""></div> -->
<!-- 								<div class="product_fav product_option">+</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				</div> -->
				
				<!-- Product -->
<!-- 				<div class="owl-item"> -->
<!-- 				<div class="col-lg-4 product_col"> -->
<!-- 					<div class="product"> -->
<!-- 						<div class="product_image"> -->
<!-- 							<a href="/product"><img src="resources/images/cake3.jpg" alt=""></a> -->
<!-- 						</div> -->
<!-- 						<div class="rating rating_4"> -->
<!-- 							<i class="fa fa-star"></i> -->
<!-- 							<i class="fa fa-star"></i> -->
<!-- 							<i class="fa fa-star"></i> -->
<!-- 							<i class="fa fa-star"></i> -->
<!-- 							<i class="fa fa-star"></i> -->
<!-- 						</div> -->
<!-- 						<div class="product_content clearfix"> -->
<!-- 							<div class="product_info"> -->
<!-- 								<div class="product_name"><a href="product.html">Man Blue Jacket</a></div> -->
<!-- 								<div class="product_price">$145.00</div> -->
<!-- 							</div> -->
<!-- 							<div class="product_options"> -->
<!-- 								<div class="product_buy product_option"><img src="resources/images/shopping-bag-white.svg" alt=""></div> -->
<!-- 								<div class="product_fav product_option">+</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				</div> -->
				</div>

			</div>
		</div>
	</div>




	<!-- Testimonials -->

	<div class="testimonials">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<div class="section_subtitle">only the best</div>
						<div class="section_title">testimonials</div>
					</div>
				</div>
			</div>
			<div class="row test_slider_container">
				<div class="col">

					<!-- Testimonials Slider -->
					<div class="owl-carousel owl-theme test_slider text-center">

						<c:forEach items="${reviewList}" var="rList">
							<div class="owl-item">
								<div class="test_text">“${rList.review_content}”</div>
								<div class="test_content">
									<div class="test_image"><a href="/product?product_id=${rList.product_id}"><img src="${rList.file_url}${rList.file_name}" alt=""></a></div>
									<div class="test_name">${rList.customer_id}</div>
									<div class="test_title">client</div>
								</div>
							</div>
						</c:forEach>
					</div>

				</div>
			</div>
		</div>
	</div>
	
<%@ include file="./includes/footer.jsp" %>

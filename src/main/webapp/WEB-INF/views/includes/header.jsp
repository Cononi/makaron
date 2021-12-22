<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html lang="kr">
<head>
<title>Makaron</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Wish shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/bootstrap4/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/OwlCarousel2-2.2.1/animate.css">
<link href="${pageContext.request.contextPath}/resources/plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/responsive.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/myPage.css">

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
					<a href="#">
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
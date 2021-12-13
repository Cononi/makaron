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

	<div id="main">
		<form name="searchList" onsubmit="return searchTracking(this)">
			<div class="search_box">
				<div class="tit">
					<label for="sword">검색조건</label>
				</div>
				<div>
					<input type="text" name="sword" class="inp" value="#">
				</div>
				<input type="button" class="styled-button search_button" value="검색하기">
			</div>
		</form>
	</div>








	<%@ include file="footer.jsp"%>
</body>
</html>
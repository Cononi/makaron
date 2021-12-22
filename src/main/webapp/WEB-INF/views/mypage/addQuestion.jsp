<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 문의 작성 페이지</title>
</head>
<body>
	* 카테고리명과 상품명을 잘 맞춰서 알맞게 선택 해주세요. 
	<hr>
	
	<form action="addQuestion" method="post">
		<b>문의할 카테고리명</b> 
		<br>
			<select name="category_name">
			<c:forEach items="${allProductName}" var="list">
				<option value="${list.category_name}">${list.category_name}</option>
			</c:forEach>
			</select>
			<br>
		
		<b>문의할 상품명</b> 
		<br>
			<select name="product_title">
			<c:forEach items="${allProductName}" var="list">
				<option value="${list.product_title}">카테고리명:${list.category_name} / 상품명: ${list.product_title}</option>
			</c:forEach>
			</select>
			<br>
			
		<b>문의 제목</b> 
		<br>
			<input type="text" name="qna_title"> 
			<br>
			
		<b>문의 내용</b> 
		<br>
			<textarea rows="5" name="qna_content"></textarea> 
			<br>
		
		<button type="reset">다시 작성 하기</button>
		<button type="submit">작성 하기</button>
	</form>
</body>
</html>
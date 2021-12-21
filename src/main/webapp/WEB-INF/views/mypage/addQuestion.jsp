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
	<form action="addQuestion" method="post">
		문의할 상품명 : 
		<select name="product_title">
		<c:forEach items="${allProductName}" var="list">
			<option value="${list.product_title}">${list.product_title}</option>
		</c:forEach>
		</select>
		<br>
		문의 제목 : <input type="text" name="qna_title"> <br>
		문의 내용 : <input type="text" name="qna_content"> <br>
		<button type="reset">다시 작성 하기</button>
		<button type="submit">작성 하기</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 작성 페이지</title>
</head>
<body>
	<form action="addReview" method="post">
		작성 가능한 후기 : 
		<select name="order_id">
		<c:forEach items="${chosetoWrite}" var="list">
			<option value="${list.order_id}">주문번호:${list.order_id} / 상품명:${list.product_title}</option>
		</c:forEach>
		</select>
		<br>
		후기 제목 : <input type="text" name="review_title"> <br>
		후기 내용 : <input type="text" name="review_content"> <br>
		<button type="reset">다시 작성 하기</button>
		<button type="submit">작성 하기</button>
	</form>
</body>
</html>
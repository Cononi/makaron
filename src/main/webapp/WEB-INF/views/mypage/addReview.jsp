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
	* 주문이 완료된 건에 대해서만 후기 작성이 가능합니다. <br>
	* 이미 작성된 건에 대해서는 중복 작성이 불가능하며, 삭제 후 재작성은 가능합니다.
	<hr>
	
	<form action="addReview" method="post">
		<b>작성 가능한 후기</b> 
		<br>
			<select name="order_id">
			<c:forEach items="${chosetoWrite}" var="list">
				<option value="${list.order_id}">주문번호:${list.order_id} / 상품명:${list.product_title}</option>
			</c:forEach>
			</select>
			<br>
			
		<b>후기 제목</b> 
		<br>
			<input type="text" name="review_title"> 
			<br>
		
		<b>후기 내용</b> 
		<br>
			<textarea rows="5" name="review_content"></textarea>
			<br>
		
		<button type="reset">다시 작성 하기</button>
		<button type="submit">작성 하기</button>
	</form>
</body>
</html>
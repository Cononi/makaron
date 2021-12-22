<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기 페이지</title>
</head>
<body>
	<form action="addQna" method="post">
		문의할 상품을 선택해주세요
		<select name="qna_id">
			<c:forEach var="list" items="${product}">
				<option value="${list.product_title}">${list.product_title}</option>
			</c:forEach>
		</select>
		<br>
		문의내용<br>
		<textarea rows="10px" cols="70px" placeholder="내용을 입력해주세요." style="resize:none;"></textarea>
		<br>
		<button type="reset">다시 작성하기</button>
		<button type="submit">작성하기</button>
	</form>
</body>
</html>
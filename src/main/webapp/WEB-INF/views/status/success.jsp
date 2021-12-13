<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../includes/header.jsp"%>


<div class="jumbotron user_register_msg">
  <h1 class="display-4">축하드립니다!</h1>
  <p class="lead"><b>${param.name}${name}</b>님 가입을 진심으로 축하드립니다. <br>저희 사이트에서 새롭게 이용하실 아이디는 <b>${param.id}</b> 입니다!</p>
  <hr class="my-4">
  <p>이제 저희 회원이 되셨으니까 지치고 힘들 때마다 달콤한 유혹에 이끌려 여기로 오실거죠?</p>
  <a class="btn btn-outline-success btn-lg" href="${pageContext.request.contextPath}/login" role="button">마카롱 구경가기!</a>
</div>


<%@ include file="../includes/footer.jsp"%>
<!-- login -->
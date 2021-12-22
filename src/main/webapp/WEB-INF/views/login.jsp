<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./includes/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="resources/styles/login.css">

<!-- All the files that are required -->
<div class="text-center login-form" style="padding:50px 0">

<form:form modelAttribute="userLoginForm" action="${pageContext.request.contextPath}/login" >
	<form:hidden path="id"/>
	<form:hidden path="password"/>
	<form:hidden path="autoLoginCheck"/>
</form:form >
	<span class="login-logo"><h1>Makaron</h1></span>
	<form action='<c:out value="${pageContext.request.contextPath}"/>/login' id="login-form" method="post">
	  <div class="form-group">
	    <label for="userid">아이디</label>
	   	<i class="fa fa-user fa-2x login-icon" aria-hidden="true"></i>
	    <input type="text" class="form-control" id="userid" name="id" value="<c:out value='${userLoginForm.id}'/>" autocomplete="off">
	  </div>
	  <div class="form-group">
	    <label for="userpassword">비밀번호</label>
	    <i class="fa fa-lock fa-2x login-icon" aria-hidden="true"></i>
	    <input type="password" class="form-control" id="userpassword" name="password" autocomplete="off">
	  </div>
 	  <div class="form-group auto-logincheck">
 	  	 <label for="autologin">자동 로그인</label>	
     	 <input type="checkbox" class="" id="autologin" name="autoLoginCheck">
	  </div> 
	  <div class="check_text_box active bad">
	  		 <span id="check_text_msg"><c:out value='${errorLoginMSG.loginError}'/></span>
	  </div>
	  <button type="submit" id="login-check" class="btn btn-primary">로그인</button>
	</form>
</div>

<%@ include file="./includes/footer.jsp"%>
<!-- login -->
<script src="${pageContext.request.contextPath}/resources/js/login.js"></script>

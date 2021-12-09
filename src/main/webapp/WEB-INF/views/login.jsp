<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./includes/header.jsp"%>
<link rel="stylesheet" type="text/css" href="resources/styles/login.css">

<!-- All the files that are required -->

<div class="text-center login-form" style="padding:50px 0">
	<span class="login-logo"><h1>Makaron</h1></span>
	<form id ="login-form" method="post">
	  <div class="form-group">
	    <label for="userid">아이디</label>
	   	<i class="fa fa-user fa-2x login-icon" aria-hidden="true"></i>
	    <input type="text" class="form-control" id="userid" name="id">
	  </div>
	  <div class="form-group">
	    <label for="userpassword">비밀번호</label>
	    <i class="fa fa-lock fa-2x login-icon" aria-hidden="true"></i>
	    <input type="password" class="form-control" id="userpassword" name="password">
	  </div>
<!-- 	  <div class="form-group">
      <input type="checkbox" class="" id="exampleCheck1">
	  </div> -->
	  <div class="check_text_box acitve">
		<span id="check_text_msg">테스트 테스</span>
	  </div>
	  <button type="button" id="login-check" class="btn btn-primary">로그인</button>
	</form>
</div>

<%@ include file="./includes/footer.jsp"%>
<!-- login -->
<script src="resources/js/login.js"></script>
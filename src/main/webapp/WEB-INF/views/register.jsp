<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="./includes/header.jsp"%>

<link rel="stylesheet" type="text/css"
	href="resources/styles/register.css">

<!-- regiset -->

<section class="section_register">
	<div class="register-line">
		<h2 class="text-center">회원 가입</h2>
		<form:form modelAttribute="joinUser" action="/register/check/success">
			<form:hidden path="id" value="${joinUser.id}"/>
			<form:hidden path="password"/>
			<form:hidden path="name"/>
			<form:hidden path="email"/>
			<form:hidden path="phone"/>
			<form:hidden path="address_type"/>
			<form:hidden path="selected_type"/>
			<form:hidden path="postal_code"/>
			<form:hidden path="address_base"/>
			<form:hidden path="address_sub"/>
			<form:hidden path="birthday"/>
			<form:hidden path="sex"/>
			<form:hidden path="category_id"/>
		</form:form>
		<form id="register-form">
			<table class="register-table table table-borderless">
				<!-- 아이디 -->
				<tr>
					<td>
						<div class="user_id md-3">
							<label for="userid">아이디</label> <input type="text" maxlength="16"
								class="form-control" id="userid" name="id" placeholder="아이디">
							<div class="check_text_box">
								<span id="check_text_msg"></span>
							</div>
						</div>
					</td>
				</tr>
				<!-- 비밀번호 -->
				<tr>
					<td>
						<div class="user_password md-3">
							<label for="userpassword">비밀번호</label> <input type="password"
								maxlength="16" class="form-control" id="userpassword"
								name="password" placeholder="비밀번호">
							<div class="check_text_box">
								<span id="check_text_msg"></span>
							</div>
						</div>
					</td>
				</tr>
				<!--  비밀번호 체크 -->
				<tr>
					<td>
						<div class="user_password_check md-3">
							<label for="userpassword_check">비밀번호 확인</label> <input
								type="password" maxlength="16" class="form-control"
								id="userpassword_check" placeholder="비밀번호 확인">
							<div class="check_text_box">
								<span id="check_text_msg"></span>
							</div>
						</div>
					</td>
				</tr>
				<!-- 이름 체크 -->
				<tr>
					<td>
						<div class="user_name md-3">
							<label for="username">이름</label> <input type="text"
								maxlength="15" class="form-control" id="username" name="name"
								placeholder="이름">
							<div class="check_text_box">
								<span id="check_text_msg"></span>
							</div>
						</div>
					</td>
				</tr>
				<!-- 이메일 체크 -->
				<tr>
					<td>
						<div class="user_email md-3">
							<label for="useremail">이메일</label> <input type="text"
								class="form-control" id="useremail" name="email"
								placeholder=" EX) makaron@makaron.kr">
							<div class="check_text_box">
								<span id="check_text_msg"></span>
							</div>
						</div>
					</td>
				</tr>
				<!-- 핸드폰 체크 -->
				<tr>
					<td>
						<div class="user_phone md-3">
							<label for="userphone">휴대폰 번호</label>
							<div class="inline_form">
								<input type="text" maxlength="11" class="form-control"
									id="userphone" name="phone" placeholder=" EX) 01077775555">
								<button class="btn btn-outline-info" id="phone-access_btn"
									type="button">인증번호전송</button>
							</div>
							<div class="inline_form cert">
								<input type="text" maxlength="6" disabled class="form-control"
									id="userphonecert" placeholder="6자리 기입">
								<button class="btn btn-outline-info phone-access_cert"
									id="phone-access_cert_btn" type="button">인증확인</button>
									<p id="phone_cert_time"></p>
							</div>
							<div class="check_text_box">
								<span id="check_text_msg"></span>
							</div>
						</div>
					</td>
				</tr>
				<!-- 주소 체크 -->
				<tr>
					<td class="address_item"><input type="text" id="address_types"
						name="address_type" placeholder="주소타입" hidden> <input
						type="text" id="selected_types" name="selected_type"
						placeholder="참고항목" hidden> <input type="text"
						id="postal_codes" name="postal_code" placeholder="우편번호" hidden>
						<div class="address_body">
							<label for="address_bases">기본 주소</label> <input type="text"
								class="form-control text-dark" name="address_base"
								id="address_bases" readonly> <br> <label
								for="address_subs">상세 주소</label> <input type="text"
								class="form-control text-dark" name="address_sub"
								id="address_subs" placeholder="상세 주소를 입력하세요" readonly> <br>
						</div> <!-- Button trigger modal -->
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#address_Modal2" hidden></button>
						<button type="button" class="btn btn-block btn-outline-info"
							onclick="DaumPostcode()" data-toggle="modal"
							data-target="#address_Modal">우편 주소 입력</button>
							<div class="check_text_box">
								<span id="check_text_msg">ㅇㅇㅇㅇ</span>
							</div>
							</td>
				
				</tr>
				<!-- 생년월일 체크 -->
				<tr>
					<td>
						<input type="hidden" name="birthday" id="birthdays">
						<div class="user_birth md-3">
							<label>생년 월일</label>
							<div class="birth-form">
								<input type="text" pattern="[0-9]*" size="4" maxlength="4"
									class="form-control birth-form-input" id="year"
									placeholder="YYYY"> <span class="bar"></span> <input size="2"
									pattern="[0-9]*" maxlength="2"
									class="form-control birth-form-input" id="month"
									placeholder="MM"> <span class="bar"></span> <input size="2"
									pattern="[0-9]*" maxlength="2"
									class="form-control birth-form-input" id="day" placeholder="DD">
							</div>
							<div class="check_text_box">
								<span id="check_text_msg"></span>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td id="sex_category"><label for="sex">성별&nbsp;</label> <select
						class="custom-select user_sex" name="sex">
							<option value="" selected>성별 선택</option>
							<option value="M">남자</option>
							<option value="W">여자</option>
					</select> &nbsp;&nbsp; <label for="category_id">선호도&nbsp;</label> <select
						class="custom-select user_category_id" name="category_id">
							<option value="" selected>선호 선택</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
					</select>
					<div class="check_text_box">
						<span id="check_text_msg"></span>
					</div></td>

				</tr>
				<tr>
					<td>
						<button type="button" class="btn btn-block btn-outline-info"
							id="summitbtt">가입완료</button>
					</td>
				</tr>
			</table>

			<!-- Modal -->
			
			<div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        ...
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
			
			
			<div class="modal fade" id="address_Modal" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div
							class="modal-body modal-dialog-scrollable modal-dialog-scrollable"
							id="wrap"></div>
					</div>
				</div>
			</div>


			<div class="modal fade" id="address_Modal2" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" id="address_modal2_btt"
								class="btn btn-primary" onclick="DaumPostcode()"
								data-toggle="modal" data-target="#address_Modal">우편 번호
								재검색</button>
						</div>
						<div
							class="modal-body modal-dialog-scrollable modal-dialog-scrollable"
							id="wraps">
							<input type="text" id="address_type2" placeholder="주소타입" hidden>
							<input type="text" id="selected_type2" placeholder="참고항목" hidden>
							<input type="text" class="form-control text-dark"
								id="postal_code2" placeholder="우편번호" readonly> <br>
							<input type="text" class="form-control text-dark"
								id="address_base2" readonly><br> <input type="text"
								class="form-control text-dark" id="address_sub2"
								placeholder="상세 주소 입력">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								id="address_modal2_btt_form" data-dismiss="modal">확인</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal" aria-label="Close">취소</button>
						</div>
					</div>
				</div>

			</div>
		</form>
	</div>



</section>
<!-- End #regiset  -->

<%@ include file="./includes/footer.jsp"%>
<!-- login -->
<script src="/resources/js/register_check.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
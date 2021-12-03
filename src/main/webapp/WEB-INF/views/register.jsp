<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="./includes/header.jsp" %>
<link rel="stylesheet" type="text/css" href="resources/styles/register.css">
    
 <!-- regiset -->
  <section class="section_register">
        <div class="register-line">
            <h2 class="text-center">회원 가입</h2>
            <form action="">
            <table class="register-table table table-borderless">
            <!-- 아이디 -->
                <tr>
                    <td>
                        <div class="user_id md-3">
                            <label for="userid">아이디</label>
                              <input type="text" maxlength="16" class="form-control text-dark" id="userid"
                                name="id" placeholder="아이디" >
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
                            <label for="userpassword">비밀번호</label>
                              <input type="password" maxlength="16" class="form-control text-dark" id="userpassword"
                                 name="password" placeholder="비밀번호" >
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
                            <label for="userpassword_check">비밀번호 확인</label>
                              <input type="password" maxlength="16" class="form-control text-dark" id="userpassword_check"
                                  placeholder="비밀번호 확인" >
                                 <div class="check_text_box">
                                    <span id="check_text_msg"></span>
                                </div>
                        </div>
                    </td>
                </tr>
               <!-- 이름 체크 -->
               <tr>
                <td>
                    <div class="user_name_c md-3">
                        <label for="username">이름</label>
                          <input type="text" maxlength="15" class="form-control text-dark" id="username"
                             name="name" placeholder="이름" >
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
                        <label for="useremail">이메일</label>
                          <input type="text" maxlength="15" class="form-control text-dark" id="useremail"
                             name="email"  placeholder=" EX) makaron@makaron.kr" >
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
                          <input type="text" maxlength="11" class="form-control text-dark" id="userphone"
                              name="phone" placeholder=" EX) 01077775555" >
                             <div class="check_text_box">
                                <span id="check_text_msg"></span>
                            </div>
                    </div>
                </td>
            </tr>
            <!-- 주소 체크 -->
            <tr>
                <td class="address_item">
                    <input type="text" id="address_type" name="address_type" placeholder="주소타입" hidden>
                    <input type="text" id="selected_type"  name="selected_type" placeholder="참고항목" hidden>
                    <input type="text" id="postal_code"  name="postal_code" placeholder="우편번호" hidden>
                    <label for="address_base">기본 주소</label>
                    <input type="text" class="form-control text-dark" name="address_base" id="address_base" readonly> <br>
            	    <label for="address_sub">상세 주소</label>
                    <input type="text" class="form-control text-dark" name="address_sub" id="address_sub" placeholder="상세 주소를 입력"> <br>
                                                         <!-- Button trigger modal -->
                 <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#address_Modal2" hidden>
                </button>
                <button type="button" class="btn btn-primary " onclick="DaumPostcode()" data-toggle="modal" data-target="#address_Modal">
                    우편 주소 검색
                </button>
            	</td>
            </tr>
            <tr>
                <tr>
                </tr>
            </tr>
            </table>
                    
                    <!-- Modal -->
                    <div class="modal fade" id="address_Modal" tabindex="-1" aria-hidden="true">
                        <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            </div>
                            <div class="modal-body modal-dialog-scrollable modal-dialog-scrollable" id="wrap">

                            </div>
                        </div>
                        </div>
                    </div>


                    <div class="modal fade" id="address_Modal2"  tabindex="-1" aria-hidden="true">
                        <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" id="address_modal2_btt" class="btn btn-primary" onclick="DaumPostcode()"  data-toggle="modal" data-target="#address_Modal">
                                    우편 번호 재검색
                                </button>
                            </div>
                            <div class="modal-body modal-dialog-scrollable modal-dialog-scrollable" id="wraps">
                                <input type="text" id="address_type2" placeholder="주소타입" hidden>
                                <input type="text" id="selected_type2"  placeholder="참고항목" hidden>
                                <input type="text" class="form-control text-dark" id="postal_code2" placeholder="우편번호" readonly> <br>
                                <input type="text" class="form-control text-dark" id="address_base2" readonly><br>
                                <input type="text" class="form-control text-dark" id="address_sub2" placeholder="상세 주소 입력">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" id="address_modal2_btt_form" data-dismiss="modal">확인</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal" aria-label="Close">취소</button>
                             </div>
                        </div>
                        </div>
                    </div>
                <!-- end 주소-->
        </div>
        <button>dk</button>
    </form>

</section><!-- End #regiset  -->
  
<%@ include file="./includes/footer.jsp" %>
  <!-- login -->
 <script src="/resources/js/register_check.js"></script>
 <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>

</html>
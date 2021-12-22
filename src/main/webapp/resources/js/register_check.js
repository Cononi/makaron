/**
 * 유효성 체크
 * 0. 아이디
 * 1. 비밀번호
 * 2. 이름
 * 3. 이메일
 * 4. 핸드폰번호
 * 우편번호
 * 기본주소
 * 7. 상세주소
 * 주소타입 (도로명, 지번)
 * 성별
 * 10. 생년월일
 * 폰인증 완료
 * 선호도 카테고리
 */


/*
    유효성 배열 1.아이디 2.비밀번호 3.이름 4.이메일 5.전화번호, 6생년월일
*/
const reg = [/^[a-z0-9]{5,16}$/
            ,/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/
            ,/^[가-힣]{1,15}$/
            ,/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
            ,/^01(?:0|1|[6-9])(?:\d{3}|\d{3,4})\d{4}$/
            ,/^(19|20)[\d]{2}$/
            ,/^(0[1-9]|1[0-2])$/
            ,/^(0[1-9]|[1-2][0-9]|3[0-1])$/];
/**
 * Easy selector helper function
 */
const select = (el, all = false) => {
  el = el.trim()
  if (all) {
    return [...document.querySelectorAll(el)]
  } else {
    return document.querySelector(el)
  }
}

const nextEl = (el) => {
  return el.nextElementSibling.classList
}

/**
 * Easy event listener function
 */
const on = (type, el, listener, all = false) => {
  let selectEl = select(el, all)
  if (selectEl) {
    if (all) {
      selectEl.forEach(e => e.addEventListener(type, listener))
    } else {
      selectEl.addEventListener(type, listener)
    }
  }
}

/**
 * Easy on scroll event listener 
 */
const onscroll = (el, listener) => {
  el.addEventListener('scroll', listener)
}

/**
 * Scrolls to an element with header offset
 */
const scrollto = (el) => {
  let header = select('#header')
  let offset = header.offsetHeight

  if (!header.classList.contains('header-scrolled')) {
    offset -= 16
  }

  let elementPos = select(el).offsetTop
  window.scrollTo({
    top: elementPos - offset,
    behavior: 'smooth'
  })
}

/*-----------------------------------------------------------------
      유효성 체크하는 부분 입니다. 
*/

on('focusout', '#userid', function (e) {checkU(this)})
on('focusout', '#userpassword', function (e) {checkU(this)}, true)
on('focusout', '#userpassword_check', function (e) {checkU(this)})
on('focusout', '#username', function (e) {checkU(this)})
on('focusout', '#useremail', function (e) {checkU(this)})
on('focusout', '#userphone', function (e) {checkU(this)})
on('click', '#address_modal2_btt_form', function (e) {checkU(this)})
on('focusout', '.birth-form-input', function (e) {checkU(this)},true)
on('focusout', 'select[name=sex]', function(e) {checkU(this)})
on('focusout', 'select[name=category_id]', function(e) {checkU(this)})
/**
 * button summit check
 */
on('click', '#summitbtt', function (e) {
  var user = [
  checkU(select('#userid'))
  ,checkU(select('#userpassword'))
  ,checkU(select('#userpassword_check'))
  ,checkU(select('#username'))
  ,checkU(select('#useremail'))
  ,checkU(select('#userphone'))
  ,checkU(select('#address_modal2_btt_form'))
  ,checkU(select('.birth-form-input',true))
  ,checkU(select('select[name=sex]'))
  ,checkU(select('select[name=category_id]'))
]


// JSON으로 변환
var arrayData = $('#register-form').serializeArray();
var json = {};
 
$.each (arrayData, function (i, e) {
    if (json[e.name]) {
        if (!json[e.name].push) {
            json[e.name] = [json[e.name]];
        }
        json[e.name].push(e.value || '');
    } else {
        json[e.name] = e.value || '';
    }
});

// 검증
$.ajax({
  url : 'register/check',
  type : 'post',
  dataType : 'json',
  data : JSON.stringify(json),
  contentType : "application/json; charset=uft-8",
  async : false,
  error: function(xhr, status, error){
  },
  success: function(data, status, xhr){
    var error_key = Object.keys(data);
    if(data.status==200){
      error_key = Object.keys(data)
      error_key.forEach(e => {
        if(e=="selected_type"){data[e].trim()}
        $("input[name="+ e +"]").val(data[e])
      })
      $('#joinUser').submit()
    }else if(data.status==400) {
        error_key.forEach(e => {
          if(e == "address_base"){$(".address_item .check_text_box span").html(data[e])
          } else{ $(".user_"+ e +" .check_text_box span").html(data[e]) }
          if (e == "sex" || e=="category_id"){ $('#sex_category .check_text_box span').html(data[e])
          } else{ $(".user_"+ e +" .check_text_box span").html(data[e])
          }
          if(error_key.length == 2){
            $("input[name="+ e +"]").focus();
          }
        });
      // $('#errorModal .modal-body').text(data['id'])
      // $('#errorModal').modal('show')
    } else if(data.status==500){
      alert("휴대폰 미인증 입니다. 인증해주시기 바랍니다.")
    }
  }
})
})


// 1차 검증
function checkU(e) {
  if($(e).attr('id') == 'userid'){
    var id_check = select('.user_id span')
    var msg = '',
    val = e.value
    nextEl(e).add('active')
    if (reg[0].test(val) && val.length > 4) {
      nextEl(e).add('good')
      nextEl(e).remove('bad')
      msg = GetAjaxID(val);
      id_check.textContent = msg;
    } else if (!reg[0].test(val) && val.length > 0) {
      nextEl(e).add('bad')
      nextEl(e).remove('good')
      msg = 'X 영문으로 시작 그리고 5자 이상의 영문(소문자)과 숫자만 가능, 최대 16자만 사용 가능합니다.'
    } else {
      nextEl(e).add('bad')
      nextEl(e).remove('good')
      msg = 'X 아이디는 필수 입력 값입니다'
    }
    id_check.textContent = msg;
  }
  //------------------

  if($(e).attr('id') == 'userpassword'){
    var pass_check = select('.user_password span')
    var pass_check_c = select('.user_password_check span')
    var msg = ''
    var msg_c = '',
      pass_c = select('#userpassword_check'),
      pass = e.value
    nextEl(e).add('active')
    if (reg[1].test(pass) && pass.length > 7) {
      nextEl(e).add('good')
      nextEl(e).remove('bad')
      msg = '사용가능한 패스워드 입니다.'
      pass_check.textContent = msg;
    } else if (!reg[1].test(pass) && pass.length > 0) {
      nextEl(e).add('bad')
      nextEl(e).remove('good')
      msg = '최소 8 자 ~ 최대 16 자, 최소 하나의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요.'
    } else {
      nextEl(e).add('bad')
      nextEl(e).remove('good')
      msg = 'X 필수 입력입니다.'
    }
    if (pass_c.value != pass && pass.length > 0) {
      msg_c = '비밀번호가 일치하지 않습니다!'
      nextEl(pass_c).remove('good')
      nextEl(pass_c).add('bad')
    }
    if (pass_c.value == pass && pass.length > 0) {
      msg_c = '비밀번호가 일치합니다!'
      nextEl(pass_c).remove('bad')
      nextEl(pass_c).add('good')
    }
    pass_check.textContent = msg;
    pass_check_c.textContent = msg_c;
  }

  if($(e).attr('id') == 'userpassword_check') {
    var pass_check = select('.user_password_check span')
    var msg = '',
      pass = e.value,
      pass_c = select('#userpassword')
    nextEl(e).add('active')
    if (pass == pass_c.value && pass.length > 0) {
      nextEl(e).add('good')
      nextEl(e).remove('bad')
      msg = '비밀번호가 일치합니다!'
      pass_check.textContent = msg;
    } else if (pass != pass_c.value && pass.length > 0) {
      nextEl(e).add('bad')
      nextEl(e).remove('good')
      msg = '비밀번호가 일치하지 않습니다!'
    } else {
      nextEl(e).add('bad')
      nextEl(e).remove('good')
      msg = 'X 필수 입력입니다.'
    }
    pass_check.textContent = msg;
  }
  //------------------
  if($(e).attr('id') == 'username'){
    var name_check = select('.user_name_s span')
    var msg = '',
      name = e.value
    nextEl(e).add('active')
    if (reg[2].test(name)) {
      nextEl(e).add('good')
      nextEl(e).remove('bad')
      msg = '✔ 이름 체크 완료'
      name_check.textContent = msg;
    } else if (!reg[2].test(name) && name.length > 0) {
      nextEl(e).add('bad')
      nextEl(e).remove('good')
      msg = 'X 최소 1 자, 최대 15 자 그리고 완성된 한글만 입력이 가능합니다.'
    } else {
      nextEl(e).add('bad')
      nextEl(e).remove('good')
      msg = 'X 필수 입력입니다.'
    }
    name_check.textContent = msg;
  }
//------------------
if($(e).attr('id') == 'useremail'){
  var email_check = select('.user_email span')
  var msg = '',
  email = e.value
  nextEl(e).add('active')
  if (reg[3].test(email)) {
    nextEl(e).add('good')
    nextEl(e).remove('bad')
    msg = '✔ 사용가능한 이메일 입니다.'
    email_check.textContent = msg;
  } else if (!reg[3].test(email)  && email.length > 0) {
    nextEl(e).add('bad')
    nextEl(e).remove('good')
    msg = 'X 이메일 형식에 맞게 정확하게 입력해주시기 바랍니다.'
  } else {
    nextEl(e).add('bad')
    nextEl(e).remove('good')
    msg = 'X 필수 입력입니다.'
  }
  email_check.textContent = msg;
}
//------------------
var goodToggle = function(e) {
  select('.user_phone .check_text_box').classList.add('good')
  select('.user_phone .check_text_box').classList.remove('bad')
}
var badToggle = function(e) {
  select('.user_phone .check_text_box').classList.add('bad')
  select('.user_phone .check_text_box').classList.remove('good')
}

if($(e).attr('id') == 'userphone'){
  var phone_check = select('.user_phone .check_text_box span')
  var msg = '',
  phone = e.value
  select('.user_phone .check_text_box').classList.add('active')
  if (reg[4].test(phone)) {
    goodToggle()
    msg = '✔ 전화번호가 정확히 입력되었습니다.'
    phone_check.textContent = msg;
  } else if (!reg[4].test(phone) && phone.length > 0) {
    badToggle()
    msg = 'X 10자리 또는 11자리의 휴대폰 번호를 정확히 입력해주세요.'
  } else {
    badToggle()
    msg = 'X 필수 입력입니다.'
  }
  phone_check.textContent = msg;
}
//------------------
if($(e).attr('id') == 'address_modal2_btt_form'){
  var address_check = select('.address_item div span')
  var address = select('#wraps input', true)
  var address_copy = select('.address_item input', true)
  var address_base = select('.address_item #address_bases')
  select('.address_item .check_text_box').classList.add('active')
  for (var i = 0; i < address.length; i++) {
    address_copy[i].value = address[i].value
  }
  if(address_base.value == null || address_base.value == ""){
    select('.address_item .check_text_box').classList.remove('good')
    select('.address_item .check_text_box').classList.add('bad')
    address_check.textContent = "X 주소는 필수 입력입니다."
  } else {
    select('.address_body').classList.remove('active')
    select('.address_body').classList.add('active')
    select('.address_item .check_text_box').classList.remove('bad')
    select('.address_item .check_text_box').classList.add('good')
    address_check.textContent = '✔ 조건이 충족합니다.'
  }
}
//------------------
var phomsgtoggle = function(e) {
  select('.user_birth .check_text_box').classList.add('bad')
select('.user_birth .check_text_box').classList.remove('good')
}
if($(e).attr('class') == 'form-control birth-form-input'){
  $('input[name="birthday"]').val($('#year').val() + $('#month').val() + $('#day').val());
var birth_check = select('.user_birth .check_text_box span')
  var msg = '',
  birth = select('.birth-form input', true)
  select('.user_birth .check_text_box').classList.add('active')
    if (!reg[5].test(birth[0].value) && birth[0].getAttribute('id') == 'year') {
      phomsgtoggle()
      msg = 'X 태어난 해를 2021과 같은 형식으로 입력해 주시기 바랍니다.'
    }
    else if (!reg[6].test(birth[1].value) && birth[1].getAttribute('id') == 'month') {
      phomsgtoggle()
      msg = 'X 태어난 월을 03과 같은 형식으로 입력해 주시기 바랍니다.'
    }
    else if (!reg[7].test(birth[2].value) && birth[2].getAttribute('id') == 'day') {
      phomsgtoggle()
      msg = 'X 태어난 월을 28과 같은 형식으로 입력해 주시기 바랍니다.'
    }
    else if(reg[5].test(birth[0].value) && reg[6].test(birth[1].value) && reg[7].test(birth[2].value)) {
      select('.user_birth .check_text_box').classList.remove('bad')
      select('.user_birth .check_text_box').classList.add('good')
      msg = '✔ 생년월일 입력이 정확합니다.'
    }
  birth_check.textContent = msg;
}

select_check = select('#sex_category .check_text_box span')
if($(e).attr('name') == 'sex' || $(e).attr('name') == 'category_id'){
    select('#sex_category .check_text_box').classList.add('active')
    if($("select[name=sex]").val() == ""){
      select('#sex_category .check_text_box').classList.remove('good')
      select('#sex_category .check_text_box').classList.add('bad')
      select_check.textContent = 'X 성별은 필수 선택 입니다.'
    } else if($("select[name=category_id]").val() == ""){
      select('#sex_category .check_text_box').classList.remove('good')
      select('#sex_category .check_text_box').classList.add('bad')
      select_check.textContent = 'X 선호도는 필수 선택 입니다.'
    }else {
      select('#sex_category .check_text_box').classList.remove('bad')
      select('#sex_category .check_text_box').classList.add('good')
      select_check.textContent = '✔ 조건이 충족합니다.'
    } 
  } 
}
//#-----------------------------------------------------------------


// ajax 1
var GetAjaxID = function (val) {
  console.log(val)
  var msg = ''
   $.ajax({
			url : 'idCheck',
			type : 'post',
      data : {"id" : val},
			dataType : 'text',
      async: false,
			success : function(result){
        if(result.trim() == 'false'){
          console.log(result)
          select('.user_id .check_text_box').classList.add('good')
          select('.user_id .check_text_box').classList.remove('bad')
          msg = "✔ " + val + '는 사용할 수 있는 아이디 입니다.'			
				} else {
          select('.user_id .check_text_box').classList.add('bad')
          select('.user_id .check_text_box').classList.remove('good')
					msg = "X " + val + '는 사용할 수 없는 아이디 입니다.'				
				}
			}
		})
  return msg
}




var phone_btt_status = false;
// acc on
on('click', '#phone-access_btn', function(e){
  var val = select('#userphone').value
  phone_btt_status = phone_btt_status == false ? true : false;
  if(reg[4].test(val) && val.length >= 10 && phone_btt_status){
  $.ajax({
    url : 'register/phone/check',
    type : 'post',
    dataType : 'text',
    data : {"phone_no" : val},
    async: false,
    success : function(data, status, xhr){
      if(xhr.status == 200){
        phoneCertTime();
        select('.phone-access_cert').classList.toggle("active")
        $('#userphonecert').removeAttr("disabled")
        $('[id=userphone]').attr('readonly',true)
        $('#phone-access_btn').html("재인증")
        phone_btt_status = true
        select('.user_phone .check_text_box span').textContent = data
        select('.user_phone .check_text_box').classList.add('good')
        select('.user_phone .check_text_box').classList.remove('bad')
      } else if(xhr.status==202) {
        phone_btt_status = false;
        select('.user_phone .check_text_box span').textContent = xhr.responseText;
        select('.user_phone .check_text_box').classList.add('bad')
        select('.user_phone .check_text_box').classList.remove('good')
      }
    }, error : function(xhr, status, error){
      if(xhr.status == 400){
        select('.user_phone .check_text_box span').textContent = "잘못된 요청 입니다.";
        select('.user_phone .check_text_box').classList.add('bad')
        select('.user_phone .check_text_box').classList.remove('good')
      }
    }
  })
} else if(reg[4].test(val) && val.length >= 10) {
  select('.phone-access_cert').classList.remove("active")
  $('[id=userphone]').attr('readonly',false)
  $('[id=userphonecert]').attr('disabled',true)
  $('[id=userphonecert]').attr('readonly',false);
  $('[id=phone-access_cert_btn]').html("인증 확인")
  $('[id=phone-access_cert_btn]').attr('disabled',false);
  $('#phone-access_btn').html("인증번호전송")
  select('.user_phone .check_text_box span').textContent = ""
  clearInterval(x)
  document.getElementById("phone_cert_time").innerHTML = ""
} else {
  phone_btt_status = false
}
})

// Timer
var x;
function phoneCertTime() {
  clearInterval(x);
  var time = 180;
  var min = "";
  var sec = "";
  x = setInterval(() => {
    min = parseInt(time/60);
    sec = time%60;
    document.getElementById("phone_cert_time").innerHTML =  min + "분&nbsp;" + sec +"초";
    time--;
    if(time < 0){
      clearInterval(x);
      document.getElementById("phone_cert_time").innerHTML = "시간 만료"
    }
  }, 1000); 
}

// acc
on('click', '.phone-access_cert', function(e){
  e.preventDefault();
  var varphone = select('#userphone').value
  var valcert = select('#userphonecert').value
  var json = {"phone_no" : varphone, "token" : valcert}
  if(valcert.length >= 6){
  $.ajax({
    url : 'register/phone/check/success',
    type : 'post',
    dataType : 'text',
    data : json, 
    success : function(data, status, xhr){
      if(xhr.status == 200){
        select('.user_phone .check_text_box span').textContent = data;
        clearInterval(x);
        document.getElementById("phone_cert_time").innerHTML = ""
        $('[id=phone-access_cert_btn]').html("인증 완료")
        $('[id=phone-access_cert_btn]').attr('disabled',true);
        $('[id=userphonecert]').attr('readonly',true);
        select('.user_phone .check_text_box').classList.add('good')
        select('.user_phone .check_text_box').classList.remove('bad')
      } else if (xhr.status == 202) {
        select('.user_phone .check_text_box span').textContent = xhr.responseText;
        select('.user_phone .check_text_box').classList.remove('good')
        select('.user_phone .check_text_box').classList.add('bad')
      }
    }, error : function(xhr, status, error){
    }
  })
}
})









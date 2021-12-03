/*
다음 주소 API
*/
    // 
    // 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function DaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
              
                document.getElementById("address_type2").value = data.userSelectedType;
                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
            
                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("selected_type2").value = extraAddr;
                
                } else {
                    document.getElementById("selected_type2").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postal_code2').value = data.zonecode;
                document.getElementById("address_base2").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("address_sub2").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                $('.modal').modal('hide')
                $('#address_modal2_btt').on('click', function(e) {
                  $('.modal').modal('hide')
                });
                $('#address_Modal2').modal('show')
                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
     
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

    }



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
 */
const reg = [/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/
            , /[가-힣]{3,}$/
            ,/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i
            ,/[0-9]$/];
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

/** 
* 1. ID Check
*/
on('input', '#userid', function (e) {
  var id_check = select('.user_id span')
  var msg = '',
    val = this.value
  nextEl(this).add('active')
  if (val.length >= 5) {
    nextEl(this).add('good')
    nextEl(this).remove('bad')
    msg = GetAjaxID(val);
  } else if (val.length > 0) {
    nextEl(this).add('bad')
    nextEl(this).remove('good')
    msg = '5자 이상의 영문과 숫자만 가능, 최대 16자'
  } else {
    nextEl(this).remove('bad')
    nextEl(this).remove('active')
  }
  id_check.textContent = msg;
})


var GetAjaxID = function (val) {
  $('#userid').blur(function () {
    console.log("포커스노")
  });
  // ajax func....
  return val + ' 사용가능'
}
// ID CHECK END


/** 
// 2. PASS CHECK
*/
on('input', '#userpassword', function (e) {
  var pass_check = select('.user_password span')
  var pass_check_c = select('.user_password_check span')
  var msg = ''
  var msg_c = '',
    pass_c = select('#userpassword_check'),
    pass = this.value

  nextEl(this).add('active')
  if (reg[0].test(pass) && pass.length > 7) {
    nextEl(this).add('good')
    nextEl(this).remove('bad')
    msg = '사용가능한 패스워드 입니다.'
  } else if (!reg[0].test(pass) && pass.length > 0) {
    nextEl(this).add('bad')
    nextEl(this).remove('good')
    msg = '최소 8 자 ~ 최대 16 자, 최소 하나의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요.'
  } else {
    nextEl(this).remove('bad')
    nextEl(this).remove('active')
  }
  if (pass_c.value != pass) {
    msg_c = '비밀번호가 일치하지 않습니다!'
    nextEl(pass_c).remove('good')
    nextEl(pass_c).add('bad')
  }
  if (pass_c.value == pass) {
    msg_c = '비밀번호가 일치합니다!'
    nextEl(pass_c).remove('bad')
    nextEl(pass_c).add('good')
  }
  pass_check.textContent = msg;
  pass_check_c.textContent = msg_c;
}, true)

on('input', '#userpassword_check', function (e) {
  var pass_check = select('.user_password_check span')
  var msg = '',
    pass = this.value,
    pass_c = select('#userpassword')
  nextEl(this).add('active')
  if (pass == pass_c.value && pass.length > 7) {
    nextEl(this).add('good')
    nextEl(this).remove('bad')
    msg = '비밀번호가 일치합니다!'
  } else if (pass != pass_c.value && pass.length > 0) {
    nextEl(this).add('bad')
    nextEl(this).remove('good')
    msg = '비밀번호가 일치하지 않습니다!'
  } else {
    nextEl(this).remove('bad')
    nextEl(this).remove('active')
  }
  pass_check.textContent = msg;
})
// PASS CHECK END

/* 
* 3. NAME CHECK
*/
on('input', '#username', function (e) {
  var name_check = select('.user_name_c span')
  var msg = '',
    name = this.value
  nextEl(this).add('active')
  if (reg[1].test(name)) {
    nextEl(this).add('good')
    nextEl(this).remove('bad')
    msg = '이름 체크 완료'
  } else if (!reg[1].test(name)) {
    nextEl(this).add('bad')
    nextEl(this).remove('good')
    msg = '최소 3 자, 최대 15 자 그리고 완성된 한글만 입력이 가능합니다.'
  } else {
    nextEl(this).remove('bad')
    nextEl(this).remove('active')
  }
  name_check.textContent = msg;
})
// NAME CHECK END

/*
* 4. EMAIL CHECK
*/
on('input', '#useremail', function(e) {
  var name_check = select('.user_email span')
  var msg = '',
  name = this.value
  nextEl(this).add('active')
  if (reg[2].test(name)) {
    nextEl(this).add('good')
    nextEl(this).remove('bad')
    msg = '사용가능한 이메일 입니다.'
  } else if (!reg[2].test(name)) {
    nextEl(this).add('bad')
    nextEl(this).remove('good')
    msg = '이메일 형식에 맞게 정확하게 입력해주시기 바랍니다.'
  } else {
    nextEl(this).remove('bad')
    nextEl(this).remove('active')
  }
  name_check.textContent = msg;
})
// EMAIL CHECK END


/*
 * 5. PHONE CHECK
*/
on('input', '#userphone', function(e) {
  var phone_check = select('.user_phone span')
  var msg = '',
  phone = this.value
  nextEl(this).add('active')
  if (reg[3].test(phone)) {
    nextEl(this).add('good')
    nextEl(this).remove('bad')
    msg = '전화번호가 정확히 입력되었습니다.'
  } else if (!reg[3].test(name)) {
    nextEl(this).add('bad')
    nextEl(this).remove('good')
    msg = '숫자만 사용가능 합니다.'
  } else {
    nextEl(this).remove('bad')
    nextEl(this).remove('active')
  }
  phone_check.textContent = msg;
})

var GetAjaxPhone = function (val) {
  $('#userphone').blur(function () {
    console.log("인증해윤")
  });
  // ajax func....
  return val + ' 사용가능'
}
/*
 * 6. ADDRESS CHECK
*/
on('click', '#address_modal2_btt_form', function(e){
  var address = select('#wraps input', true)
  var address_copy = select('.address_item input', true);
  for (var i = 0; i < address.length; i++) {
    address_copy[i].value = address[i].value
  }
 })

/*
* 7. BIRTHDAY CHECK
*/
on('input', '#userbirthday', function(e) {
  var phone_check = select('.user_phone span')
  var msg = '',
  phone = this.value
  nextEl(this).add('active')
  if (reg[3].test(phone)) {
    nextEl(this).add('good')
    nextEl(this).remove('bad')
    msg = '전화번호가 정확히 입력되었습니다.'
  } else if (!reg[3].test(name)) {
    nextEl(this).add('bad')
    nextEl(this).remove('good')
    msg = '숫자 또는 -만 사용가능 합니다.'
  } else {
    nextEl(this).remove('bad')
    nextEl(this).remove('active')
  }
  phone_check.textContent = msg;
})







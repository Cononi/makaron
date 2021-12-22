$('.login-form input').focus(function (e) { 
	$($(this).prev().addClass("active"))
});

$('.login-form input').focusout(function (e) { 
	$($(this).prev().removeClass("active"))
});



// // 폼 체크
// function errorCheck (errorClassObject, msgObject, msg, errorCode){
// 	// 객체를 보여줌
// 	errorClassObject.addClass("active");
// 	errorClassObject.addClass('bad');
// 	msgObject.html(msg)
// }
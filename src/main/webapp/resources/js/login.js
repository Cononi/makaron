$('.login-form input').focus(function (e) { 
	e.preventDefault();
	$($(this).prev().addClass("active"))
});

$('.login-form input').focusout(function (e) { 
	e.preventDefault();
	$($(this).prev().removeClass("active"))
});


$.ajax({
	type: "method",
	url: "url",
	data: "data",
	dataType: "dataType",
	success: function (response) {
		
	}
});
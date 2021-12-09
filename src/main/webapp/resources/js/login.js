$('.login-form input').focus(function (e) { 
	$($(this).prev().addClass("active"))
});

$('.login-form input').focusout(function (e) { 
	$($(this).prev().removeClass("active"))
});


/**
 * 
 * 로그인 부분
 * 
 */
$('#login-check').click(function (e) { 
	// JSON으로 변환
	var arrayData2 = $('#login-form').serialize();
	var arrayData = $('#login-form').serializeArray();
	console.log(arrayData);
	console.log(arrayData2);
	console.log($('#userpassword').val())
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
	$.ajax({
		url : '/login/check',
		type : 'post',
		dataType : 'json',
		data : JSON.stringify(json),
		contentType : "application/json; charset=uft-8",
		async : false,
		error: function(xhr, status, error){
		},
		success: function(data, status, xhr){
			console.log(data)
		}

	});
});
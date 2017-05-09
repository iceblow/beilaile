/**
 * login
 */

$(function() {
	// 登录
	login();
	// 忘记密码
	forgot();
	// 注册
	register();

});

function login() {
	$("#username").focus();
	$("#username").click(function() {
		$("#username").val("");
	});
	$("#password").click(function() {
		$("#password").val("");
	});
	$("#login_btn").click(function() {
		var name = $("#username").val();
		var psw = $("#password").val();
		$.ajax({
			url : $("#path").val() + '/userinfo/login.do',
			datatype : 'json',
			type : 'post',
			data : {
				username : name,
				password : psw
			},
			success : function(data) {
				if (data == 1) {
					$("#password").val("");
					window.location.href = "/index.html";
				} else {
					$("#password").val("");
					alert("账号或密码错误");
				}
			}
		});
	});
}
function forgot() {
	$("#forgot").click(function() {
		$("#email").val("");
	});
	$("#forgot_btn").click(function() {
		var email = $("#email").val();
		alert("请求已发送" + email);
	});
}

function register() {

	// 显示隐藏注册按钮
	document.getElementById("insert_btn").style.display = (document
			.getElementById("chk").checked == true) ? "block" : "none";
	$('#chk').click(function() {
		if ($('#chk').prop("checked")) {
			$("#insert_btn").show();
		} else {
			$("#insert_btn").hide();
		}
	});
	// 清空
	$("#uname").val("");
	$("#pwd").val("");
	$("#repwd").val("");
	// $("#emails").val("");
	// 获取值
	$("#insert_btn").click(function() {
		var name = $("#uname").val();
		var pwd = $("#pwd").val();
		var repwd = $("#repwd").val();
		var sex = $(":radio:checked").val();
		var department = $('#department option:selected').text();
		var position = $('#position option:selected').text();
		// var img = $("#img").val();
		// var email = $("#emails").val();
		// var birth = $("#birthday").val();
		// alert(name + " " + pwd + " " + repwd + " " + sex + " "
		// + department + " " + position);
		if (pwd != repwd) {
			alert("两次密码输入不一致!!");
			$("#pwd").val("");
			$("#repwd").val("");
		} else {
			alert("进入后台..0.0!");
			$.ajax({
				url : $("#path").val() + '/userinfo/addUser.do',
				datatype : 'json',
				type : 'post',
				data : {
					username : name,
					password : pwd,
					usex : sex,
					department : department,
					position : position
				},
				success : function(data) {
					window.location.href = "/user/login.html";
					alert("注册成功!");
				}
			});
		}
	});
}

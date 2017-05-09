$(function() {

});

function update() {
	// 获取form表单(带文件上传的)
	// var formData = new FormData($("#modifyByBuildProgress")[0]);
	// 获取form表单(不带文件上传);
	// var anyVal = $("#anyVal-from").serialize();
	var anyVal = $("#myUserMsessage").serialize();
	if ($("#password").val().length != 0 && $("#oldPassWord").val().length == 0) {
		alert("请输入旧密码");
		return;
	} else if ($("#password").val().length != 0
			&& $("#oldPassWord").val().length != 0) {
		if ($("#oldPassWord").val() != $("#myoldPassWord").val()) {
			alert("旧密码输入错误");
			return;
		}
	}
	$.ajax({
		url : $("#path").val() + '/userinfo/update.do',
		type : 'post',
		dataType : 'json',
		data : anyVal,
		success : function(data) {
			if (data == 0) {
				alert("修改失败");
			} else if (data == 1) {
				window.location.href = "/login.html";
			}
		}
	});
}
/**
 * Created by Beilaile on 2016/12/11.
 */
/**
 * 只能输入数字和一个小数点 onkeyup="chkNum(this)"
 * 
 * @param obj
 */
function chkNum(obj) {
	obj.value = obj.value.replace(/[^0-9.]/g, "").replace(".", "$#$").replace(
			/\./g, "").replace("$#$", ".");
};
function modifyCellByNumeric(modifyRequest, findMethod) {
	$(".modify-table-numeric")
			.on(
					"dblclick",
					function() {

						var id = $(this).parent().find("td:eq(0)").text();
						var originalValue = $(this).text().trim();
						var name = $(this).attr("value");
						$(this)
								.html(
										"<input  id='"
												+ id
												+ "' style='width: 50px' type='text' onkeyup='chkNum(this)' value='"
												+ originalValue + "' name='"
												+ name + "'> ");
						$("#" + id).focus();// 文本框获取光标事件
						cursorLeavesEvent(id, name, modifyRequest, findMethod);
					});
};
function modifyCellByChar(modifyRequest, findMethod) {
	$(".modify-table-char").on(
			"dblclick",
			function() {
				var id = $(this).parent().find("td:eq(0)").text();
				var originalValue = $(this).text().trim();
				var name = $(this).attr("value");
				$(this).html(
						"<input  id='" + id + "'  type='text' value='"
								+ originalValue + "' name='" + name + "'> ");
				$("#" + id).focus();// 文本框获取光标事件

				cursorLeavesEventChar(id, name, modifyRequest, findMethod);
			});
};
function modifyCellByDate(modifyRequest, findMethod) {
	$(".modify-table-date").on(
			"dblclick",
			function() {
				var id = $(this).parent().find("td:eq(0)").text();
				var originalValue = $(this).text().trim();
				var name = $(this).attr("value");
				$(this).html(
						"<input class='form-control input-date'  id='" + id
								+ "'  type='text' value='" + originalValue
								+ "' name='" + name + "'> ");
				$("#" + id).focus();// 文本框获取光标事件
				cursorLeavesEvent(id, name, modifyRequest, findMethod);
			});
};
// 光标离开事件
function cursorLeavesEventChar(id, name, modifyRequest, findMethod) {
	$("#" + id).blur(function() {
		var newtxt = $("#" + id).val();
		var data = {
			id : id
		};
		data[name] = newtxt;
		$.post(modifyRequest, data, function(result) {
			if (result = 0 || result < 0) {
				alert("修改失败：可能原因数据有错或者网络错误");
			} else {
				var pageNow = $("#pageNow").val();
				$("#pageSize").val(10);
				$("#pageNow").val(pageNow); // 給當前頁賦值
				var anyVal = $("#form-anyVal").serialize(); // 获取form表单
				// 調用方法
				findMethod(anyVal);
			}
		});
	});
};
//光标离开事件
function cursorLeavesEvent(id, name, modifyRequest, findMethod) {
	$("#" + id).blur(function() {
		var newtxt = $("#" + id).val();
		if (newtxt == "") {
			newtxt = 0;
		}
		var data = {
			id : id
		};
		data[name] = newtxt;
		$.post(modifyRequest, data, function(result) {
			if (result = 0 || result < 0) {
				alert("修改失败：可能原因数据有错或者网络错误");
			} else {
				var pageNow = $("#pageNow").val();
				$("#pageSize").val(10);
				$("#pageNow").val(pageNow); // 給當前頁賦值
				var anyVal = $("#form-anyVal").serialize(); // 获取form表单
				// 調用方法
				findMethod(anyVal);
			}
		});
	});
};

// 2016年12月27日10:12:06

function mydblclick() {
	$(".mydblClick").on(
			"dblclick",
			function() {
				var myid = $(this).parent().find("td:eq(0)").text();
				var numberOrder = $(this).parent().find("td:eq(10)").text();
				var nextName = $(this).next().attr("value");
				var thisText = $(this).text().trim();
				var thisName = $(this).attr("value");
				if ($(this).attr("class") == "mydblClick") {
					$(this).html(
							"<form id='dbUpdateForm'><input type='hidden' name='id' value="
									+ myid + " /><input type='text' id='my"
									+ thisName + "' name='" + thisName
									+ "' value='" + thisText
									+ "'><input type='hidden' name='"
									+ nextName + "'></form>");
					$(this).attr("class", "sn");
				}
				document.getElementById("my" + thisName).focus();
				myblur("my" + thisName, numberOrder);
			});
}

function myblur(id, numberOrder) {
	$("#" + id).blur(function() {
		var c = $("#dbUpdateForm>input:eq(1)").val();
		var b = c * numberOrder;
		$("#dbUpdateForm>input:eq(2)").val(b);
		var myform = $("#dbUpdateForm").serialize();
		$.ajax({
			url : 'modifyFabricMaterial.do',
			type : 'POST',
			dataType : 'json',
			data : myform,
			async : false,
			success : function(data) {
				if (data == 1) {
					var pageNow = $("#pageNow").val();
					$("#pageSize").val(10);
					$("#pageNow").val(pageNow); // 給當前頁賦值
					// window.location.reload();
					var anyVal4 = $("#form-anyVal").serialize();
					// 調用查询法传参带分页
					findFabricMaterial(anyVal4);
				} else {
					alert("修改失败");
				}
			}
		});
	});
}
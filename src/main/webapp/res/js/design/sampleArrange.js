$(function() {
	// 分页查询的方法
	loadPageDatas(1);
	// 模糊查询
	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	firstLoadData($("#path").val() + "/sampleArrange/getDataByPage.do",
			index); // 指定url
}
// 分页查询以后打印数据
function loadData(mydata) {
	$("tbody").empty();
	$.each(mydata, function(index, x) {
			var wave="<td>"+(x.wave==null?'':x.wave)+"</td>";//波次号
			var designImg="<td>"+(x.designImg==null?"":"<img src='"+x.designImg+"' width='120px' height='60px'>")+"</td>";//产品图
			var productCode="<td>"+(x.productCode==null?'':x.productCode)+"</td>";//产品编码
			var consignee="<td class='mydblClick' name='consignee'>"+(x.consignee==null?'':x.consignee)+"</td>";//收件人
			var shippingAddress="<td class='mydblClick' name='shippingAddress'>"+(x.shippingAddress==null?'':x.shippingAddress)+"</td>";//收货地址
			var ifGiveOut="<td>"+(x.ifGiveOut=='已发出'?x.ifGiveOut:"<a href='javascript:;' class='btn btn-danger btn-sm out' ><i class='icon-reply icon-only'></i>发出</a>")+"</td>";//是否发放
			$("tbody").append("<tr>" + wave + designImg + productCode + consignee + shippingAddress + ifGiveOut + "</tr>");
	});
	//双击修改方法
	mydblclick();
	//发出方法
	out();
}
var mySelectForm;
// 查詢按鈕點擊事件
function select() {
	$("#myselect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()+"/sampleArrange/getDataByPage.do?" + mySelectForm,1); // 指定url
			});
}


function mydblclick() {
	$(".mydblClick")
			.on(
					"dblclick",
					function() {
						var myid = $(this).parent().find("td:eq(0)").text()
								.trim();
						var thisText = $(this).text().trim();
						var thisName = $(this).attr("name");
						var thisVal = $(this).attr("value");
						// 如果双击修改的是时间类型的单元格对里面的内容重新计算 得到真正的日期
						if (thisVal == "time" && thisText != "") {
							var myval = thisText;
							var date = new Date();
							var yyyy = date.getFullYear();
							var mm = ((date.getMonth() + 1) / 10 < 1 ? "0"
									+ (date.getMonth() + 1)
									: (date.getMonth() + 1));
							var dd = (date.getDate() / 10 < 1 ? "0"
									+ date.getDate() : date.getDate());
							var nowDate = yyyy + "-" + mm + "-" + dd;
							var dateStart1 = new Date(nowDate);
							var asd = new Date(myval * (1000 * 3600 * 24)
									+ dateStart1.getTime());
							var yyyy1 = asd.getFullYear();
							var mm1 = ((asd.getMonth() + 1) / 10 < 1 ? "0"
									+ (asd.getMonth() + 1)
									: (asd.getMonth() + 1));
							var dd1 = (asd.getDate() / 10 < 1 ? "0"
									+ asd.getDate() : asd.getDate());
							thisText = yyyy1 + "-" + mm1 + "-" + dd1;
						}

						if (thisVal != "time") {
							$(this).html(
									"<form id='dbUpdateForm'><input type='hidden' name='wave' value="
											+ myid
											+ " /><input type='text' id='my"
											+ thisName + "' name='" + thisName
											+ "' value='" + thisText
											+ "'></form>");
							$(this).attr("class", "sn");
							
							myblur("my" + thisName);
						} else {
							$(this)
									.html(
											"<form id='dbUpdateForm'><input type='hidden' name='id' value="
													+ myid
													+ " /><input class='form-control input-date' type='text' id='my"
													+ thisName + "' name='"
													+ thisName + "' value='"
													+ thisText + "'></form>");
							$(this).attr("class", "sn");
							// 绑定时间控件
							var input_date = $(".input-date").datetimepicker({
								format : "yyyy-mm-dd",
								autoclose : true,
								todayBtn : true,
								todayHighlight : true,
								showMeridian : true,
								pickerPosition : "bottom-left",
								language : 'zh-CN', // 中文，需要引用zh-CN.js包
								startView : 2, // 月视图
								minView : 2
							// 日期时间选择器所能够提供的最精确的时间选择视图
							});
							var input_date_readOnly = $(".input-date").prop(
									"readOnly", "true");
							
							timeBlur("my" + thisName);
						}
						document.getElementById("my" + thisName).focus();
					});
}

function myblur(id) {
	$("#" + id).blur(
			function() {
				var myform = $("#dbUpdateForm").serialize();
				$.ajax({
					url : $("#path").val()
							+ '/sampleArrange/dbUpdate.do',
					type : 'POST',
					dataType : 'json',
					data : myform,
					async : false,
					success : function(data) {
						if (data == 1) {
							firstLoadData($("#path").val()
									+ "/sampleArrange/getDataByPage.do?"
									+ mySelectForm, $(".laypage_curr").text());
						} else {
							alert("修改失败");
						}
					}
				});
			});
}
function timeBlur(id) {
	$("#" + id).blur(function() {
		setTimeout('commitTime()', 200);
	});
}

function commitTime() {
	var myform = $("#dbUpdateForm").serialize();
	$.ajax({
		url : $("#path").val() + '/sampleArrange/dbUpdate.do',
		type : 'POST',
		dataType : 'json',
		data : myform,
		async : false,
		success : function(data) {
			if (data == 1) {
				firstLoadData($("#path").val()
						+ "/sampleArrange/getDataByPage.do?" + mySelectForm,
						$(".laypage_curr").text());
			} else {
				alert("未修改");
			}
		}
	});
}
//----------------------------------------发出--------------------------------------
function out(){
	$(".out").click(function(){
		var wave =$(this).parent().parent().find("td:eq(0)").text().trim();
		$.ajax({
			url:'sampleArrange/out.do',
			type:'post',
			dataType:'json',
			data:{
				wave:wave,
			},
			success:function(data){
				if(data==1){
					alert("修改成功");
					firstLoadData($("#path").val()
							+ "/sampleArrange/getDataByPage.do?" + mySelectForm,
							$(".laypage_curr").text());
				}
			}
		});
	});
}
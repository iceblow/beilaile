$(function() {
	loadPageDatas(1);

	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val() + "/productionProblem/getDataByPage.do",
			index); // 指定url
}

function loadData(data) {
	$("tbody").empty();
	$.each(data, function(index, x) {

		var id = "<td>" + (x.id == null ? '' : x.id) + "</td>";// 编号
		var wave = "<td>" + (x.wave == null ? '' : x.wave) + "</td>";// 波次
		var oringinalWave = "<td>"
				+ (x.oringinalWave == null ? '' : x.oringinalWave) + "</td>";// 原波次
		var designImg = "<td>"
				+ (x.designImg == null || x.designImg == "" ? "" : "<img src='"
						+ x.designImg + "' width='100px' height='80px' />")
				+ "</td>";// 产品图
		var craftsOrder = "<td>"
				+ (x.craftsOrder == null || x.craftsOrder == "" ? ""
						: "<a href='" + x.craftsOrder
								+ "' target='_blank'>工艺单</a>") + "</td>";// 工艺单
		var sizeChart = "<td>"
				+ (x.sizeChart == null || x.sizeChart == "" ? '' : "<a href='"
						+ x.sizeChart + "' target='_blank'>尺码图</a>") + "</td>";// 尺码图
		var orderDetails = "<td>"
				+ (x.orderDetails == null ? '' : x.orderDetails) + "</td>";// 订单明细
		var orders = "<td>" + (x.orders == null ? '' : x.orders) + "</td>";// 订单数量
		var cuttingMan = "<td>" + (x.cuttingMan == null ? '' : x.cuttingMan)
				+ "</td>";// 裁剪人
		var cuttingNum = "<td>" + (x.cuttingNum == null ? '' : x.cuttingNum)
				+ "</td>";// 裁剪数量
		var fabricGivingOutMan = "<td>"
				+ (x.fabricGivingOutMan == null ? '' : x.fabricGivingOutMan)
				+ "</td>";// 发料人
		var trackingMan = "<td>" + (x.trackingMan == null ? '' : x.trackingMan)
				+ "</td>";// 跟踪员
		var problem = "<td>" + (x.problem == null ? '' : x.problem) + "</td>";// 产生问题

		var problemTime = "<td>" + (x.problemTime == null ? '' : x.problemTime)
				+ "</td>";// 问题产生时间
		
		var completeType="<td>"+(x.completeType=="已解决"?"已解决":
			"<a href='javascript:;' class='label label-xlg label-primary arrowed arrowed-right complete'>解决</a>")+"</td>"

		var completeTime="<td>"+(x.completeTime==null?"":x.completeTime)+"</td>"
		$("tbody").append(
				"<tr>" + id + wave + oringinalWave + designImg + craftsOrder
						+ sizeChart + orderDetails + orders + cuttingMan
						+ cuttingNum + fabricGivingOutMan + trackingMan
						+ problem + problemTime + completeType + completeTime+ "</tr>");
	});
	mydblclick();
	//解决方法按钮点击事件
	completeClick();
}
var mySelectForm;
// 查詢按鈕點擊事件
function select() {
	$("#myselect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData(
						$("#path").val()
								+ "/productionProblem/getDataByPage.do?"
								+ mySelectForm, 1); // 指定url
				// -注释时间:2017年1月6日16:54:06
				// -注释原因:查询之后保留查询内容
				// $(".col-md-2>input").val("");
			});
}
// ----------------------------------------------------双击修改----------------------------------------------------
function getTime(date) {
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var strDate = date.getDate();

	return year + "-" + month + "-" + strDate
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
							+ '/productionProblem/updateDataByWave.do',
					type : 'POST',
					dataType : 'json',
					data : myform,
					async : false,
					success : function(data) {
						if (data == 1) {
							firstLoadData($("#path").val()
									+ "/productionProblem/getDataByPage.do?"
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
		url : $("#path").val() + '/productionProblem/updateDataByWave.do',
		type : 'POST',
		dataType : 'json',
		data : myform,
		async : false,
		success : function(data) {
			if (data == 1) {
				firstLoadData(
						$("#path").val()
								+ "/productionProblem/getDataByPage.do?"
								+ mySelectForm, $(".laypage_curr").text());
			} else {
				alert("未修改");
			}
		}
	});
}
// ----------------------------------------------------解决问题----------------------------------------------------
function completeClick() {
	$(".complete").click(function(){
		var id=$(this).parent().parent().find("td:eq(0)").text();
		var wave=$(this).parent().parent().find("td:eq(1)").text();
		var problem=$(this).parent().parent().find("td:eq(12)").text();
		layer.confirm("确认<font color='red'>"+wave+"</font>的问题<font color='red'>"+problem+"</font>已解决?",function(){
			$.ajax({
				url:'/productionProblem/complete.do',
				type:'post',
				dataType:'json',
				data:{
					id:id
				},
				success:function(data){
					firstLoadData(
							$("#path").val()
									+ "/productionProblem/getDataByPage.do?"
									+ mySelectForm, $(".laypage_curr").text());
					layer.msg('已解决',{
						icon : 6,
						time : 2000
					});
				}
			});
		},function(){
			layer.msg('未解决',{
				icon : 5,
				time : 2000
			});
		})
	});
}

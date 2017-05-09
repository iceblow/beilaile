$(function() {
	loadPageDatas(1);

	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val()
			+ "/printingCuttingCompleted/getDataByPage.do", index); // 指定url
}

function loadData(data) {
	$("tbody").empty();
	$
			.each(
					data,
					function(index, x) {

						wave = x.wave == null || x.wave == "" ? "<td></td>"
								: "<td>" + x.wave + "</td>";// 波次号

						cropCompletionDate = x.cropCompletionDate == null
								|| x.cropCompletionDate == "" ? "<td></td>"
								: "<td>" + x.cropCompletionDate + "</td>";// 裁剪完成日期

						cropNumber = x.cropNumber == null || x.cropNumber == "" ? "<td></td>"
								: "<td>" + x.cropNumber + "</td>";// 裁剪数

						piecesApproved = x.piecesApproved == null
								|| x.piecesApproved == "" ? "<td></td>"
								: "<td>" + x.piecesApproved + "</td>";// 印绣花类型

						image = x.image == null || x.image == "" ? "<td></td>"
								: "<td><img src='"
										+ x.image
										+ "' width='100px' height='80px'/></td>";// 产品图

						cutLargeReceiveDate = x.cutLargeReceiveDate == null
								|| x.cutLargeReceiveDate == "" ? "<td></td>"
								: "<td>" + x.cutLargeReceiveDate + "</td>";// 片印领料日期

						cutLargeReturnDate = x.cutLargeReturnDate == null
								|| x.cutLargeReturnDate == "" ? "<td></td>"
								: "<td>" + x.cutLargeReturnDate + "</td>";// 片印回料

						printingFactory = x.printingFactory == null
								|| x.printingFactory == "" ? "<td class='mydblClick' name='printingFactory'></td>"
								: "<td class='mydblClick' name='printingFactory'>"
										+ x.printingFactory + "</td>";// 印花工厂

						factory = x.factory == null || x.factory == "" ? "<td class='mydblClick' name='factory'></td>"
								: "<td class='mydblClick' name='factory'>"
										+ x.factory + "</td>";// 车缝工厂

						factoryPickingDate = x.factoryPickingDate == null
								|| x.factoryPickingDate == "" ? "<td></td>"
								: "<td>" + x.factoryPickingDate + "</td>";// 车缝领料日期

						remark = x.remark == null || x.remark == "" ? "<td class='mydblClick' name='remark'></td>"
								: "<td class='mydblClick' name='remark'>"
										+ x.remark + "</td>";// 备注

						$("tbody").append(
								"<tr>" + wave + cropCompletionDate + cropNumber
										+ piecesApproved + image
										+ cutLargeReceiveDate
										+ cutLargeReturnDate + printingFactory
										+ factory + factoryPickingDate + remark
										+ "</tr>");

					});
	mydblclick();
}
var mySelectForm;
// 查詢按鈕點擊事件
function select() {
	$("#myselect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()
						+ "/printingCuttingCompleted/getDataByPage.do?"
						+ mySelectForm, 1); // 指定url
				// -注释时间:2017年1月6日16:54:06
				// -注释原因:查询之后保留查询内容
				// $(".col-md-2>input").val("");
			});
}
//----------------------------------------------------双击修改----------------------------------------------------
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
	$("#" + id)
			.blur(
					function() {
						var myform = $("#dbUpdateForm").serialize();
						$
								.ajax({
									url : $("#path").val()
											+ '/printingCuttingCompleted/updateDataByWave.do',
									type : 'POST',
									dataType : 'json',
									data : myform,
									async : false,
									success : function(data) {
										if (data == 1) {
											firstLoadData(
													$("#path").val()
															+ "/printingCuttingCompleted/getDataByPage.do?"
															+ mySelectForm, $(
															".laypage_curr")
															.text());
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
		url : $("#path").val()
				+ '/printingCuttingCompleted/updateDataByWave.do',
		type : 'POST',
		dataType : 'json',
		data : myform,
		async : false,
		success : function(data) {
			if (data == 1) {
				firstLoadData($("#path").val()
						+ "/printingCuttingCompleted/getDataByPage.do?"
						+ mySelectForm, $(".laypage_curr").text());
			} else {
				alert("未修改");
			}
		}
	});
}
//----------------------------------------------------双击修改----------------------------------------------------
$(function() {
	// 分页查询的方法
	loadPageDatas(1);
	// 模糊查询
	select();
	// 修改按钮点击事件
	myupdate();
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	firstLoadData($("#path").val() + "/taskDistribution/getDataByPage.do",
			index); // 指定url
}
// 分页查询以后打印数据
function loadData(mydata) {
	var date = new Date();
	var yyyy = date.getFullYear();
	var mm = ((date.getMonth() + 1) / 10 < 1 ? "0" + (date.getMonth() + 1)
			: (date.getMonth() + 1));
	var dd = (date.getDate() / 10 < 1 ? "0" + date.getDate() : date.getDate());
	var nowDate = yyyy + "-" + mm + "-" + dd;
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, x) {
						var id = x.id == null ? "<td></td>" : "<td>" + x.id
								+ "</td>";// 编号
						var designer = x.designer == null ? "<td></td>"
								: "<td>" + x.designer + "</td>";// 设计师
						var oringinalWave = x.oringinalWave == null ? "<td></td>"
								: "<td>" + x.oringinalWave + "</td>";// 原波次
						var img = x.img == null ? "<td></td>"
								: "<td><img src='" + x.img
										+ "' width='100px' height='82px'></td>";// 图片
						var wave = x.wave == null ? "<td></td>" : "<td>"
								+ x.wave + "</td>";// 波次号
						var processImg = x.processImg == null
								|| x.processImg == "" ? "<td><a href=''></a></td>"
								: "<td><a href='" + x.processImg
										+ "' target='_blank'>工艺单</a></td>";// 工艺单
						var printedVersion = x.printedVersion == null
								|| x.printedVersion == "" ? "<td><a href=''></a></td>"
								: "<td><a href='" + x.printedVersion
										+ "' target='_blank'>印花稿</a></td>";// 印花稿
						var orderSum = x.orderSum == null ? "<td></td>"
								: "<td>" + x.orderSum + "</td>";// 订单数量--
						var orderDetals = x.orderDetals == null ? "<td></td>"
								: "<td>" + x.orderDetals + "</td>";// 订单明细--
						var folwerFactory = x.folwerFactory == null ? "<td class='mydblClick' name='folwerFactory'></td>"
								: "<td class='mydblClick' name='folwerFactory'>"
										+ x.folwerFactory + "</td>";// 印绣花工厂
						var pieceApproved = x.pieceApproved == null ? "<td class='mydblClick' name='pieceApproved'></td>"
								: "<td class='mydblClick' name='pieceApproved'>"
										+ x.pieceApproved + "</td>";// 印花或裁片
						var flowerPrice = x.flowerPrice == null ? "<td class='mydblClick' name='flowerPrice'></td>"
								: "<td class='mydblClick' name='flowerPrice'>"
										+ x.flowerPrice + "</td>";// 印绣花单价
						var printingPrice = x.printingPrice == null ? "<td class='mydblClick' name='printingPrice'></td>"
								: "<td class='mydblClick' name='printingPrice'>"
										+ x.printingPrice + "</td>";// 匹印单价
						var piecesPrice = x.piecesPrice == null ? "<td class='mydblClick' name='piecesPrice'></td>"
								: "<td class='mydblClick' name='piecesPrice'>"
										+ x.piecesPrice + "</td>";// 裁片印单价
						var orderType = x.orderType == null ? "<td class='mydblClick' name='orderType'></td>"
								: "<td class='mydblClick' name='orderType'>"
										+ x.orderType + "</td>";// 订单类型
						var releaseTime = x.releaseTime == null ? "<td></td>"
								: "<td>"
										+ getDiscrepantDays(x.releaseTime,
												nowDate) + "</td>";// 发版时间
						var proofingTime = x.proofingTime == null ? "<td class='mydblClick' name='proofingTime' value='time'></td>"
								: "<td class='mydblClick' name='proofingTime' value='time'>"
										+ getDiscrepantDays(x.proofingTime,
												nowDate) + "</td>";// 印绣花给样时间
						var proofingCompletionTime = x.proofingCompletionTime == null ? "<td class='mydblClick' name='proofingCompletionTime' value='time'></td>"
								: "<td class='mydblClick' name='proofingCompletionTime' value='time'>"
										+ getDiscrepantDays(
												x.proofingCompletionTime,
												nowDate) + "</td>";// 印绣花回样时间
						var cuttingTime = x.cuttingTime == null ? "<td class='mydblClick' name='cuttingTime' value='time'></td>"
								: "<td class='mydblClick' name='cuttingTime' value='time'>"
										+ getDiscrepantDays(x.cuttingTime,
												nowDate) + "</td>";// 制单/样衣->给到裁床日期

						var fabricStorageTime = x.fabricStorageTime == null ? "<td value='time'></td>"
								: "<td><a target='_blank'  href='fabricmanagement.html?wave="
										+ x.wave
										+ "'>"
										+ getDiscrepantDays(
												x.fabricStorageTime, nowDate)
										+ "</a></td>";// 面料入库时间
						var fabricReleaseTime = x.fabricReleaseTime == null ? "<td></td>"
								: "<td>"
										+ getDiscrepantDays(
												x.fabricReleaseTime, nowDate)
										+ "</td>";// 面料发放时间
						var largeCargoTime = x.largeCargoTime == null ? "<td></td>"
								: "<td>"
										+ getDiscrepantDays(x.largeCargoTime,
												nowDate) + "</td>";// 匹印领料
						var largeCargoCompletionTime = x.largeCargoCompletionTime == null ? "<td></td>"
								: "<td>"
										+ getDiscrepantDays(
												x.largeCargoCompletionTime,
												nowDate) + "</td>";// 匹印出货
						var cropCompletionTime = x.cropCompletionTime == null ? "<td></td>"
								: "<td>"
										+ getDiscrepantDays(
												x.cropCompletionTime, nowDate)
										+ "</td>";// 裁剪完成时间
						var cropNumber = x.cropNumber == null ? "<td></td>"
								: "<td>" + x.cropNumber + "</td>";// 裁剪数
						var cutLargeReceiveTime = x.cutLargeReceiveTime == null ? "<td></td>"
								: "<td>"
										+ getDiscrepantDays(
												x.cutLargeReceiveTime, nowDate)
										+ "</td>";// 片印领料
						var cutLargeReturnTime = x.cutLargeReturnTime == null ? "<td></td>"
								: "<td>"
										+ getDiscrepantDays(
												x.cutLargeReturnTime, nowDate)
										+ "</td>";// 片印回料
						var remark = x.remark == null ? "<td class='mydblClick' name='remark'></td>"
								: "<td class='mydblClick' name='remark'>"
										+ x.remark + "</td>";// 备注

						$("tbody")
								.append(
										"<tr>"
												+ id
												+ designer
												+ oringinalWave
												+ img
												+ wave
												+ processImg
												+ printedVersion
												+ orderSum
												+ orderDetals
												+ folwerFactory
												+ pieceApproved
												+ flowerPrice
												+ printingPrice
												+ piecesPrice
												+ orderType
												+ releaseTime
												+ proofingTime
												+ proofingCompletionTime
												+ cuttingTime
												+ fabricStorageTime
												+ fabricReleaseTime
												+ largeCargoTime
												+ largeCargoCompletionTime
												+ cropCompletionTime
												+ cropNumber
												+ cutLargeReceiveTime
												+ cutLargeReturnTime
												+ remark
												+ "<td><a href='javascript:void(0);' class='printProcessImg'>打印工艺单</a></td>"
												+ "<td><a href='javascript:void(0);' data-toggle='modal' data-target='#myModal1' class='update'>修改</a></td></tr>");

					});
	// + "<td><a href='javascript:void(0);'
	// class='printPrintedVersion'>打印印花稿</a></td>"
	processImg();
	printedVersion();
	update();
	mydblclick();
}
var mySelectForm;
// 查詢按鈕點擊事件
function select() {
	$("#myselect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()
						+ "/taskDistribution/getDataByPage.do?" + mySelectForm,
						1); // 指定url
				// -注释时间:2017年1月6日16:54:06
				// -注释原因:查询之后保留查询内容
				// $(".col-md-2>input").val("");
			});
}
// 打印工艺单
function processImg() {
	$(".printProcessImg").click(
			function() {
				var processImg = $(this).parent().parent().find("td:eq(5)>a")
						.attr("href");
				if (processImg.length != 0) {
					$("#printImg").attr("src", processImg);
					$("#printImg").jqprint();
				} else {
					alert("没有工艺单");
				}
			});
}
// 打印印花稿
function printedVersion() {
	$(".printPrintedVersion").click(
			function() {
				var processImg = $(this).parent().parent().find("td:eq(6)>a")
						.attr("href");
				if (processImg.length != 0) {
					$("#printImg").attr("src", processImg);
					$("#printImg").jqprint();
				} else {
					alert("没有工艺单");
				}
			});
}
function update() {
	$(".update").click(
			function() {
				var id = $(this).parent().parent().find("td:eq(0)").text()
						.trim();
				$
						.ajax({
							url : $("#path").val()
									+ '/taskDistribution/getOneByid.do',
							type : 'post',
							dataType : 'json',
							data : {
								id : id
							},
							success : function(data) {
								$("#id").val(data.id);
								$("#folwerFactory").val(data.folwerFactory);
								$("#pieceApproved").val(data.pieceApproved);
								$("#flowerPrice").val(data.flowerPrice);
								$("#printingPrice").val(data.printingPrice);
								$("#piecesPrice").val(data.piecesPrice);
								$("#orderType").val(data.orderType);
								$("#releaseTime").val(data.releaseTime);
								$("#proofingTime").val(data.proofingTime);
								$("#proofingCompletionTime").val(
										data.proofingCompletionTime);
								$("#cuttingTime").val(data.cuttingTime);
								$("#fabricStorageTime").val(
										data.fabricStorageTime);
								$("#fabricReleaseTime").val(
										data.fabricReleaseTime);
								$("#largeCargoTime").val(data.largeCargoTime);
								$("#largeCargoCompletionTime").val(
										data.largeCargoCompletionTime);
								$("#cropCompletionTime").val(
										data.cropCompletionTime);
								$("#cropNumber").val(data.cropNumber);
								$("#cutLargeReceiveTime").val(
										data.cutLargeReceiveTime);
								$("#cutLargeReturnTime").val(
										data.cutLargeReturnTime);
								$("#remark").val(data.remark);
							}
						});
			});
}

function myupdate() {
	$("#updateSub").click(
			function() {
				var data = $("#myUpdataForm").serialize();
				$.ajax({
					url : $("#path").val() + '/taskDistribution/update.do',
					type : 'post',
					dataType : 'json',
					data : data,
					success : function(data) {
						if (data == 1) {
							firstLoadData($("#path").val()
									+ "/taskDistribution/getDataByPage.do?"
									+ mySelectForm, $(".laypage_curr").text()
									.trim());
						} else {
							alert("修改信息失败");
						}
					}
				});
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
									"<form id='dbUpdateForm'><input type='hidden' name='id' value="
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
							+ '/taskDistribution/dbUpdateTask.do',
					type : 'POST',
					dataType : 'json',
					data : myform,
					async : false,
					success : function(data) {
						if (data == 1) {
							firstLoadData($("#path").val()
									+ "/taskDistribution/getDataByPage.do?"
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
		url : $("#path").val() + '/taskDistribution/dbUpdateTask.do',
		type : 'POST',
		dataType : 'json',
		data : myform,
		async : false,
		success : function(data) {
			if (data == 1) {
				firstLoadData($("#path").val()
						+ "/taskDistribution/getDataByPage.do?" + mySelectForm,
						$(".laypage_curr").text());
			} else {
				alert("未修改");
			}
		}
	});
}
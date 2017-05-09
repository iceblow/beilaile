$(function() {

	loadPageDatas(1);

	add();

	myselect();

	myupdate();

	productionProblem();
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	// 处理后的数据
	firstLoadData($("#path").val() + "/tracking/getConditionByPage.do", index);

}
// 查询完成,打印数据
function loadData(mydata) {

	// B种打印方式--打印处理后的数据
	testB(mydata);
}

function testB(mydata) {
	$("#orderSum").text(mydata.orderSum);
	$("#styleSum").text(mydata.styleSum);
	$("tbody").empty();
	$
			.each(
					mydata.list,
					function(index, x) {
						var id = "<td>" + x.id + "</td>";

						var fabricReserve = x.fabricReserve == null ? "<td></td>"
								: "<td>" + x.fabricReserve + "</td>";

						var clippingReserve = x.clippingReserve == null ? "<td></td>"
								: "<td class='mydblClick' name='clippingReserve'>"
										+ x.clippingReserve + "</td>";

						var designer = x.designer == null ? "<td></td>"
								: "<td>" + x.designer + "</td>";

						var trackingOfficer = x.trackingOfficer == null ? "<td></td>"
								: "<td>" + x.trackingOfficer + "</td>";

						var supplier = x.supplier == null ? "<td "+(x.orderType=="经销单"?"class='mydblClick' name='supplier'":'')+"></td>"
								: "<td "+(x.orderType=="经销单"?"class='mydblClick' name='supplier'":'')+">" + x.supplier + "</td>";

						var b_id = x.b_id == null ? "<td></td>" : "<td>"
								+ x.b_id + "</td>";

						var primaryWave = x.primaryWave == null ? "<td></td>"
								: "<td>" + x.primaryWave + "</td>";

						var img = x.img == null || x.img == ""
								|| x.img == "null" ? "<td></td>"
								: "<td><a href=" + x.img
										+ " target='_blank'>工艺单</a></td>";

						var image = x.image == null ? "<td></td>"
								: "<td><img src=" + x.image
										+ " width='100px' height='100px'></td>";

						var type = x.type == null ? "<td></td>" : "<td>"
								+ x.type + "</td>";

						var publishedTime = x.publishedTime == null ? "<td></td>"
								: "<td class='mydblClick' name='publishedTime'>"
										+ x.publishedTime + "</td>";

						var versionTime = x.versionTime == null ? "<td></td>"
								: "<td class='mydblClick' name='versionTime'>"
										+ x.versionTime + "</td>";

						var prenatalSample = x.prenatalSample == null ? "<td></td>"
								: "<td class='mydblClick' name='prenatalSample'>"
										+ x.prenatalSample + "</td>";

						var orderNum = x.orderNum == null ? "<td></td>"
								: "<td>" + x.orderNum + "</td>";

						var estimatedPrice = x.estimatedPrice == null ? "<td></td>"
								: "<td class='mydblClick' name='estimatedPrice'>"
										+ x.estimatedPrice + "</td>";

						var costPrice = x.costPrice == null ? "<td></td>"
								: "<td class='mydblClick' name='costPrice'>"
										+ x.costPrice + "</td>";

						var component = x.component == null ? "<td></td>"
								: "<td class='mydblClick' name='component'>"
										+ x.component + "</td>";

						var productionSchedule = x.productionSchedule == null ? "<td></td>"
								: "<td class='mydblClick' name='productionSchedule'>"
										+ x.productionSchedule + "</td>";

						var orderType = x.orderType == null ? "<td></td>"
								: "<td class='mydblClick' name='orderType'>"
										+ x.orderType + "</td>";

						var cutNum = x.cutNum == null ? "<td></td>"
								: "<td class='mydblClick' name='cutNum'>"
										+ x.cutNum + "</td>";

						var arrivalNumbe = x.arrivalNumbe == null ? "<td></td>"
								: "<td class='mydblClick' name='arrivalNumbe'>"
										+ x.arrivalNumbe + "</td>";
						
						var reportShipment = x.reportShipment == null ? "<td class='mydblClick' name='reportShipment'></td>"
								: "<td class='mydblClick' name='reportShipment'>"
										+ x.reportShipment + "</td>";

						var delivaTime = x.delivaTime == null ? "<td class='mydblClick' name='delivaTime'></td>"
								: "<td class='mydblClick' name='delivaTime'>"
										+ x.delivaTime + "</td>";

						var deliveryConfirmation = x.deliveryConfirmation == null ? "<td class='mydblClick' name='deliveryConfirmation'></td>"
								: "<td class='mydblClick' name='deliveryConfirmation'>"
										+ x.deliveryConfirmation + "</td>";

						var returnDate = x.returnDate == null ? "<td class='mydblClick' name='returnDate'></td>"
								: "<td class='mydblClick' name='returnDate'>"
										+ x.returnDate + "</td>";

						var releaseTime = x.releaseTime == null ? "<td></td>"
								: "<td>" + x.releaseTime + "</td>"

						var printingCompleteTime = x.printingCompleteTime == null ? "<td></td>"
								: "<td>" + x.printingCompleteTime + "</td>";

						var fabricAndAuxiliaryCompleteTime = x.fabricAndAuxiliaryCompleteTime == null ? "<td></td>"
								: "<td>" + x.fabricAndAuxiliaryCompleteTime
										+ "</td>";

						var color = x.color == null ? "<td></td>" : "<td>"
								+ x.color + "</td>";

						var sizeImg = x.sizeImg == "" || x.sizeImg == null ? "<td></td>"
								: "<td><a href=" + x.sizeImg
										+ " target='_blank'>尺码图</a></td>";

						var finish = x.deleteType == 1 ? "<td><a data-toggle='modal' href='javascript:;' class='finish'>点击完成</a></td>"
								: "<td>已完成</td>";

						var del = x.deleteType == 1 ? "<td><a data-toggle='modal' href='javascript:;' class='del'>删除</a></td>"
								: "<td>不可删除</td>";
						$("tbody")
								.append(
										"<tr "
												+ (x.urgent_state > 0 ? "style='background-color:#53FF53;'"
														: "")
												+ ">"
												+ id
												+ fabricReserve
												+ clippingReserve
												+ designer
												+ trackingOfficer
												+ supplier
												+ b_id
												+ primaryWave
												+ img
												+ image
												+ type
												+ publishedTime
												+ versionTime
												+ prenatalSample
												+ orderNum
												+ estimatedPrice
												+ costPrice
												+ component
												+ productionSchedule
												+ orderType
												+ cutNum
												+ arrivalNumbe
												+ reportShipment
												+ delivaTime
												+ deliveryConfirmation
												+ returnDate
												+ releaseTime
												+ color
												+ sizeImg
												+ printingCompleteTime
												+ fabricAndAuxiliaryCompleteTime
												+ finish
												+ del
												+ "<td><a data-toggle='modal' data-target='#myModal1' href='javascript:;' class='update'>修改</a></td></tr>");
					});
	update();
	del();
	mydblclick();
	finish();
}
// 添加方法
function add() {
	$("#addSub")
			.click(
					function() {
						// 取值
						var fabricReserve = $("#fabricReserve").val();
						var clippingReserve = $("#clippingReserve").val();
						var designer = $("#designer").val();
						var trackingOfficer = $("#trackingOfficer").val();
						var supplier = $("#supplier").val();
						var b_id = $("#b_id").val();
						var file = $("#file").val();
						var type = $("#type").val();
						var publishedTime = $("#publishedTime").val();
						var versionTime = $("#versionTime").val();
						var prenatalSample = $("#prenatalSample").val();
						var orderNum = $("#orderNum").val();
						var estimatedPrice = $("#estimatedPrice").val();
						var costPrice = $("#costPrice").val();
						var component = $("#component").val();
						var productionSchedule = $("#productionSchedule").val();
						var orderType = $("#orderType").val();
						var cutNum = $("#cutNum").val();
						var arrivalNumbe = $("#arrivalNumbe").val();
						var delivaTime = $("#delivaTime").val();
						var deliveryConfirmation = $("#deliveryConfirmation")
								.val();
						var returnDate = $("#returnDate").val();
						var printingCompleteTime = $("#printingCompleteTime")
								.val();
						var fabricAndAuxiliaryCompleteTime = $(
								"#fabricAndAuxiliaryCompleteTime").val();
						if (b_id.length == 0) {
							alert("波次号不能为空,请重新添加");
							Clear();
							return;
						}
						// 執行文件上傳方法
						$
								.ajaxFileUpload({
									url : $("#path").val()
											+ '/tracking/addTrack.do',
									secureuri : true,// 一般设置为false
									fileElementId : 'file',// 上传对象
									data : {
										"fabricReserve" : fabricReserve,
										"clippingReserve" : clippingReserve,
										"designer" : designer,
										"trackingOfficer" : trackingOfficer,
										"supplier" : supplier,
										"b_id" : b_id,
										"file" : file,
										"type" : type,
										"publishedTime" : publishedTime,
										"versionTime" : versionTime,
										"prenatalSample" : prenatalSample,
										"orderNum" : orderNum,
										"estimatedPrice" : estimatedPrice,
										"costPrice" : costPrice,
										"component" : component,
										"productionSchedule" : productionSchedule,
										"orderType" : orderType,
										"cutNum" : cutNum,
										"arrivalNumbe" : arrivalNumbe,
										"delivaTime" : delivaTime,
										"deliveryConfirmation" : deliveryConfirmation,
										"returnDate" : returnDate,
										"printingCompleteTime" : printingCompleteTime,
										"fabricAndAuxiliaryCompleteTime" : fabricAndAuxiliaryCompleteTime,
									},
									dataType : 'json',
									success : function(mydata) {
										loadPageDatas(1);
										Clear();
									},
									error : function(data) {
										Clear();
										alert("添加失敗");
									}
								});
					});
}
// 清空方法
function Clear() {
	$("#fabricReserve").val("");
	$("#clippingReserve").val("");
	$("#designer").val("");
	$("#trackingOfficer").val("");
	$("#supplier").val("");
	$("#b_id").val("");
	$("#file").val("");
	$("#type").val("");
	$("#publishedTime").val("");
	$("#versionTime").val("");
	$("#prenatalSample").val("");
	$("#orderNum").val("");
	$("#estimatedPrice").val("");
	$("#costPrice").val("");
	$("#component").val("");
	$("#productionSchedule").val("");
	$("#orderType").val("");
	$("#cutNum").val("");
	$("#arrivalNumbe").val("");
	$("#delivaTime").val("");
	$("#deliveryConfirmation").val("");
	$("#returnDate").val("");
	$("#printingCompleteTime").val("");
	$("#fabricAndAuxiliaryCompleteTime").val("");
}
// 得到修改以前的文件名字S
var myname = "";

function update() {
	$(".update")
			.click(
					function() {
						// 先清空再取值,保证数据的准确性
						$("#files").val("");
						var id = $(this).parent().parent().find("td:eq(0)")
								.text().trim();
						$
								.ajax({
									url : $("#path").val()
											+ '/tracking/getOne.do',
									type : 'POST',
									dataType : 'json',
									data : {
										id : id,
									},
									async : false,
									success : function(data) {
										myname = data.img;
										$("#ids").val(
												data.id == null ? "" : data.id);
										$("#fabricReserves").val(
												data.fabricReserve == null ? ""
														: data.fabricReserve);
										$("#clippingReserves")
												.val(
														data.clippingReserve == null ? ""
																: data.clippingReserve);
										$("#designers").val(
												data.designer == null ? ""
														: data.designer);
										$("#trackingOfficers")
												.val(
														data.trackingOfficer == null ? ""
																: data.trackingOfficer);
										$("#suppliers").val(
												data.supplier == null ? ""
														: data.supplier);
										$("#b_ids").val(
												data.b_id == null ? ""
														: data.b_id);
										$("#types").val(
												data.type == null ? ""
														: data.type);
										$("#publishedTimes").val(
												data.publishedTime == null ? ""
														: data.publishedTime);
										$("#versionTimes").val(
												data.versionTime == null ? ""
														: data.versionTime);
										$("#prenatalSamples")
												.val(
														data.prenatalSample == null ? ""
																: data.prenatalSample);
										$("#orderNums").val(
												data.orderNum == null ? ""
														: data.orderNum);
										$("#estimatedPrices")
												.val(
														data.estimatedPrice == null ? ""
																: data.estimatedPrice);
										$("#costPrices").val(
												data.costPrice == null ? ""
														: data.costPrice);
										$("#components").val(
												data.component == null ? ""
														: data.component);
										$("#productionSchedules")
												.val(
														data.productionSchedule == null ? ""
																: data.productionSchedule);
										$("#orderTypes").val(
												data.orderType == null ? ""
														: data.orderType);
										$("#cutNums").val(
												data.cutNum == null ? ""
														: data.cutNum);
										$("#arrivalNumbes").val(
												data.arrivalNumbe == null ? ""
														: data.arrivalNumbe);
										$("#reportShipments").val(
												data.reportShipment == null ? ""
														: data.reportShipment);
										$("#delivaTimes").val(
												data.delivaTime == null ? ""
														: data.delivaTime);
										$("#deliveryConfirmations")
												.val(
														data.deliveryConfirmation == null ? ""
																: data.deliveryConfirmation);
										$("#returnDates").val(
												data.returnDate == null ? ""
														: data.returnDate);
										$("#printingCompleteTimes")
												.val(
														data.printingCompleteTime == null ? ""
																: data.printingCompleteTime);
										$("#fabricAndAuxiliaryCompleteTimes")
												.val(
														data.fabricAndAuxiliaryCompleteTime == null ? ""
																: data.fabricAndAuxiliaryCompleteTime);
									}
								});
					});

}

function myupdate() {
	$("#updateSub")
			.click(
					function() {
						var id = $("#ids").val();
						var fabricReserve = $("#fabricReserves").val();
						var clippingReserve = $("#clippingReserves").val();
						var designer = $("#designers").val();
						var trackingOfficer = $("#trackingOfficers").val();
						var supplier = $("#suppliers").val();
						var b_id = $("#b_ids").val();
						var file = $("#files").val();
						var color = $("#colors").val();
						var type = $("#types").val();
						var publishedTime = $("#publishedTimes").val();
						var versionTime = $("#versionTimes").val();
						var prenatalSample = $("#prenatalSamples").val();
						var orderNum = $("#orderNums").val();
						var printingEmbroiderySupplier = $(
								"#printingEmbroiderySuppliers").val();
						var printingQuotation = $("#printingQuotations").val();
						var estimatedPrice = $("#estimatedPrices").val();
						var costPrice = $("#costPrices").val();
						var component = $("#components").val();
						var productionSchedule = $("#productionSchedules")
								.val();
						var orderType = $("#orderTypes").val();
						var cutNum = $("#cutNums").val();
						var arrivalNumbe = $("#arrivalNumbes").val();
						var delivaTime = $("#delivaTimes").val();
						var deliveryConfirmation = $("#deliveryConfirmations")
								.val();
						var returnDate = $("#returnDates").val();
						var printingCompleteTime = $("#printingCompleteTimes")
								.val();
						var fabricAndAuxiliaryCompleteTime = $(
								"#fabricAndAuxiliaryCompleteTimes").val();
						var reportShipment = $(
								"#reportShipments").val();
						// 執行文件上傳方法
						$
								.ajaxFileUpload({
									url : $("#path").val()
											+ '/tracking/updateTrack.do',
									secureuri : true,// 一般设置为false
									fileElementId : 'files',// 上传对象
									data : {
										"id" : id,
										"fabricReserve" : fabricReserve,
										"clippingReserve" : clippingReserve,
										"designer" : designer,
										"trackingOfficer" : trackingOfficer,
										"supplier" : supplier,
										"b_id" : b_id,
										"file" : file,
										"color" : color,
										"type" : type,
										"publishedTime" : publishedTime,
										"versionTime" : versionTime,
										"prenatalSample" : prenatalSample,
										"orderNum" : orderNum,
										"printingEmbroiderySupplier" : printingEmbroiderySupplier,
										"printingQuotation" : printingQuotation,
										"estimatedPrice" : estimatedPrice,
										"costPrice" : costPrice,
										"component" : component,
										"productionSchedule" : productionSchedule,
										"orderType" : orderType,
										"cutNum" : cutNum,
										"arrivalNumbe" : arrivalNumbe,
										"delivaTime" : delivaTime,
										"deliveryConfirmation" : deliveryConfirmation,
										"returnDate" : returnDate,
										"printingCompleteTime" : printingCompleteTime,
										"fabricAndAuxiliaryCompleteTime" : fabricAndAuxiliaryCompleteTime,
										"myname" : myname,
										"reportShipment":reportShipment,
									},
									dataType : 'json',
									success : function(mydata) {
										firstLoadData(
												$("#path").val()
														+ "/tracking/getConditionByPage.do?"
														+ mySelectForm, $(
														".laypage_curr").text()
														.trim());
									},
									error : function(data) {
										alert("修改失敗");
									}
								});
					});
}

var mySelectForm = "";

// 查询按钮点击事件
function myselect() {
	// 查询未完成
	$("#mySelectOffComplete")
			.click(
					function() {
						$("#mySelectDeleteType").val("1");
						mySelectForm = $("#mySelect_From").serialize();
						firstLoadData($("#path").val()
								+ "/tracking/getConditionByPage.do?"
								+ mySelectForm, 1);
						// $(".col-md-2 >input").val("");
					});
	// 查询已完成
	$("#mySelectOnComplete")
			.click(
					function() {
						$("#mySelectDeleteType").val("2");
						mySelectForm = $("#mySelect_From").serialize();
						firstLoadData($("#path").val()
								+ "/tracking/getConditionByPage.do?"
								+ mySelectForm, 1);
						// $(".col-md-2 >input").val("");
					});
}

function del() {
	$(".del").bind(
			"click",
			function() {
				id = $(this).parent().parent().find("td:eq(0)").text().trim();
				$.ajax({
					url : $("#path").val() + '/tracking/del.do',
					type : 'post',
					dataType : 'json',
					data : {
						id : id,
					},
					success : function(data) {
						alert("删除成功");
						firstLoadData($("#path").val()
								+ "/tracking/getConditionByPage.do?"
								+ mySelectForm, $(".laypage_curr").text()
								.trim());
					}
				});
			});
}

function mydblclick() {
	$(".mydblClick").on(
			"dblclick",
			function() {
				var myid = $(this).parent().find("td:eq(0)").text().trim();
				var thisText = $(this).text().trim();
				var thisName = $(this).attr("name");
				if ($(this).attr("class") == "mydblClick") {
					$(this).html(
							"<form id='dbUpdateForm'><input type='hidden' name='id' value="
									+ myid + " /><input type='text' id='my"
									+ thisName + "' name='" + thisName
									+ "' value='" + thisText + "'></form>");
					$(this).attr("class", "sn");
				}
				document.getElementById("my" + thisName).focus();
				myblur("my" + thisName);
			});
}

function myblur(id) {
	$("#" + id).blur(
			function() {
				var myform = $("#dbUpdateForm").serialize();
				$.ajax({
					url : $("#path").val() + '/tracking/dbUpdateTrack.do',
					type : 'POST',
					dataType : 'json',
					data : myform,
					async : false,
					success : function(data) {
						if (data == 1) {
							firstLoadData("/tracking/getConditionByPage.do?"
									+ mySelectForm, $(".laypage_curr").text());
						} else {
							alert("修改失败");
						}
					}
				});
			});
}
// 完成按钮点击事件
function finish() {
	$(".finish").click(
			function() {
				var id = $(this).parent().parent().find("td:eq(0)").text()
						.trim();
				$.ajax({
					url : $("#path").val() + '/tracking/dbUpdateTrack.do',
					type : 'POST',
					dataType : 'json',
					data : {
						"id" : id,
						"deleteType" : 2,
					},
					success : function(data) {
						if (data == 1) {
							firstLoadData("/tracking/getConditionByPage.do?"
									+ mySelectForm, $(".laypage_curr").text());
						} else {
							alert("修改失败");
						}
					}
				});
			});
}

function productionProblem() {
	$("#lookProblemForm").click(function() {
		$("#problemForm>div>div>input").val("");
		$("#problemForm>div>div>textarea").val("");
	});
	$("#problemBtn").click(
			function() {
				// $("#myModalProblem").hide();
				var wave = $("#problemForm>div").find("div:eq(0)")
						.find("input").val().trim();
				var time = $("#problemForm>div").find("div:eq(1)")
						.find("input").val().trim();
				var problem = $("#problemForm>div").find("div:eq(2)").find(
						"textarea").val().trim();
				if (wave == "") {
					layer.tips('请填写波次', $("#problemForm>div").find("div:eq(0)")
							.find("input"));
					return;
				}
				if (time == "") {
					layer.tips('请填写时间', $("#problemForm>div").find("div:eq(1)")
							.find("input"));
					return;
				}
				if (problem == "") {
					layer.tips('请填写问题', $("#problemForm>div").find("div:eq(2)")
							.find("textarea"));
					return;
				}
				if (wave != "" && time != "" && problem != "") {
					$("#problemBtn").attr('data-dismiss', 'modal');
				}

				var problemForm = $("#problemForm").serialize();
				$.ajax({
					url : $("#path").val() + '/productionProblem/insert.do',
					type : 'POST',
					dataType : 'json',
					data : problemForm,
					success : function(data) {
						if (data == 1) {
							$("#problemForm>div>div>input").val("");
							$("#problemForm>div>div>textarea").val("");
							firstLoadData("/tracking/getConditionByPage.do?"
									+ mySelectForm, $(".laypage_curr").text());
							layer.msg('问题反馈成功', {
								icon : 6,
								time : 2000, // 20s后自动关闭
							});
						} else {
							alayer.msg('问题反馈失败', {
								icon : 6,
								time : 2000, // 20s后自动关闭
							});
						}
					}
				});
			});
}

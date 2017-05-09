$(function() {
	loadPageDatas(1);
	// 点击查询方法
	mySelect();
	// 全选框勾选执行方法
	checkAll();
	// 导出excle的方法
	toExcle();
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	// 处理后的数据
	firstLoadData($("#path").val() + "/printingFabricArrange/getDataByPage.do",
			index);

}
// 查询完成,打印数据
function loadData(mydata) {

	// B种打印方式--打印处理后的数据
	testB(mydata);
}

function testB(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, x) {
						var id = "<td>"
								+ (x.id == null || x.id == "" ? '' : x.id)
								+ "</td>";
						var additionTime = "<td>"
								+ (x.additionTime == null
										|| x.additionTime == "" ? ''
										: x.additionTime) + "</td>";// 添加日期
						var wave = "<td>"
								+ (x.wave == null || x.wave == "" ? '' : x.wave)
								+ "</td>";// 波次
						var designImg = "<td>"
								+ (x.designImg == null || x.designImg == "" ? ''
										: "<img src='"
												+ x.designImg
												+ "' width='90px' height='60px'/>")
								+ "</td>";// 产品图
						var fabricMaterial = "<td>"
								+ (x.fabricMaterial == null
										|| x.fabricMaterial == "" ? ''
										: x.fabricMaterial) + "</td>";// 面料材质
						var colour = "<td>"
								+ (x.colour == null || x.colour == "" ? ''
										: x.colour) + "</td>";// 颜色
						var parameter1 = "<td class='mydblClick' name='parameter1' value='fabric'>"
								+ (x.parameter1 == null || x.parameter1 == ""
										|| x.parameter1 == 0 ? ''
										: x.parameter1) + "</td>";// 面料1
						var parameter2 = "<td class='mydblClick' name='parameter2' value='fabric'>"
								+ (x.parameter2 == null || x.parameter2 == ""
										|| x.parameter2 == 0 ? ''
										: x.parameter2) + "</td>";// 面料2
						var parameter3 = "<td class='mydblClick' name='parameter3' value='fabric'>"
								+ (x.parameter3 == null || x.parameter3 == ""
										|| x.parameter3 == 0 ? ''
										: x.parameter3) + "</td>";// 面料3
						var parameter4 = "<td class='mydblClick' name='parameter4' value='fabric'>"
								+ (x.parameter4 == null || x.parameter4 == ""
										|| x.parameter4 == 0 ? ''
										: x.parameter4) + "</td>";// 面料4
						var parameter5 = "<td class='mydblClick' name='parameter5' value='fabric'>"
								+ (x.parameter5 == null || x.parameter5 == ""
										|| x.parameter5 == 0 ? ''
										: x.parameter5) + "</td>";// 面料5
						var parameter6 = "<td class='mydblClick' name='parameter6' value='fabric'>"
								+ (x.parameter6 == null || x.parameter6 == ""
										|| x.parameter6 == 0 ? ''
										: x.parameter6) + "</td>";// 面料6
						var parameter7 = "<td class='mydblClick' name='parameter7' value='fabric'>"
								+ (x.parameter7 == null || x.parameter7 == ""
										|| x.parameter7 == 0 ? ''
										: x.parameter7) + "</td>";// 面料7
						var parameter8 = "<td class='mydblClick' name='parameter8' value='fabric'>"
								+ (x.parameter8 == null || x.parameter8 == ""
										|| x.parameter8 == 0 ? ''
										: x.parameter8) + "</td>";// 面料8
						var parameter9 = "<td class='mydblClick' name='parameter9' value='fabric'>"
								+ (x.parameter9 == null || x.parameter9 == ""
										|| x.parameter9 == 0 ? ''
										: x.parameter9) + "</td>";// 面料9
						var parameter10 = "<td class='mydblClick' name='parameter10' value='fabric'>"
								+ (x.parameter10 == null || x.parameter10 == ""
										|| x.parameter10 == 0 ? ''
										: x.parameter10) + "</td>";// 面料10
						var parameter11 = "<td class='mydblClick' name='parameter11' value='fabric'>"
								+ (x.parameter11 == null || x.parameter11 == ""
										|| x.parameter11 == 0 ? ''
										: x.parameter11) + "</td>";// 面料11
						var parameter12 = "<td class='mydblClick' name='parameter12' value='fabric'>"
								+ (x.parameter12 == null || x.parameter12 == ""
										|| x.parameter12 == 0 ? ''
										: x.parameter12) + "</td>";// 面料12
						var parameter13 = "<td class='mydblClick' name='parameter13' value='fabric'>"
								+ (x.parameter12 == null || x.parameter12 == ""
										|| x.parameter13 == 0 ? ''
										: x.parameter12) + "</td>";// 面料13
						var parameter14 = "<td class='mydblClick' name='parameter14' value='fabric'>"
								+ (x.parameter14 == null || x.parameter14 == ""
										|| x.parameter14 == 0 ? ''
										: x.parameter14) + "</td>";// 面料14
						var parameter15 = "<td class='mydblClick' name='parameter15' value='fabric'>"
								+ (x.parameter15 == null || x.parameter15 == ""
										|| x.parameter15 == 0 ? ''
										: x.parameter15) + "</td>";// 面料15
						var parameter16 = "<td class='mydblClick' name='parameter16' value='fabric'>"
								+ (x.parameter16 == null || x.parameter16 == ""
										|| x.parameter16 == 0 ? ''
										: x.parameter16) + "</td>";// 面料16
						var parameter17 = "<td class='mydblClick' name='parameter17' value='fabric'>"
								+ (x.parameter17 == null || x.parameter17 == ""
										|| x.parameter17 == 0 ? ''
										: x.parameter17) + "</td>";// 面料17
						var parameter18 = "<td class='mydblClick' name='parameter18' value='fabric'>"
								+ (x.parameter18 == null || x.parameter18 == ""
										|| x.parameter18 == 0 ? ''
										: x.parameter18) + "</td>";// 面料18
						var kgM = "<td>"
								+ (x.kgM == null || x.kgM == "" ? '' : x.kgM)
								+ "</td>";// 单位
						var totalCount = "<td>"
								+ (x.totalCount == null || x.totalCount == "" ? ''
										: x.totalCount) + "</td>";// 面料总条数
						var remarks = "<td  class='mydblClick' name='remarks'>"
								+ (x.remarks == null || x.remarks == "" ? ''
										: x.remarks) + "</td>";// 备注
						var materials = "<td>"
								+ (x.materials == null || x.materials == "" ? ''
										: x.materials) + "</td>";// 单件用料
						var numberOrder = "<td>"
								+ (x.numberOrder == null || x.numberOrder == "" ? ''
										: x.numberOrder) + "</td>";// 订单采购件数
						var supplier = "<td>"
								+ (x.supplier == null || x.supplier == "" ? ''
										: x.supplier) + "</td>";// 面料供应商 -----去除
						var scheduledNumber = "<td>"
								+ (x.scheduledNumber == null
										|| x.scheduledNumber == "" ? ''
										: x.scheduledNumber) + "</td>";// 预定条数
						var recipient = "<td>"
								+ (x.recipient == null || x.recipient == "" ? ''
										: x.recipient) + "</td>";// 收件人
						// ------去除
						var recipientAddress = "<td>"
								+ (x.recipientAddress == null
										|| x.recipientAddress == "" ? ''
										: x.recipientAddress) + "</td>";// 收货地址
						// ------去除
						var fabricType = "<td>"
								+ (x.fabricType == null || x.fabricType == "" ? ''
										: x.fabricType) + "</td>";// 用料位置
						// var
						// purchasingStatus="<td>"+(x.id==null||x.id==""?'':x.id)+"</td>";//
						// 采购状态
						var actualdosage = "<td>"
								+ (x.actualdosage == null
										|| x.actualdosage == "" ? ''
										: x.actualdosage) + "</td>";// 用料总米数
						// -----去除
						var fabricprices = "<td>"
								+ (x.fabricprices == null
										|| x.fabricprices == "" ? ''
										: x.fabricprices) + "</td>";// 面料单价
						// -----去除
						var weight = "<td>"
								+ (x.weight == null || x.weight == "" ? ''
										: x.weight) + "</td>";// 面料总重量
						var combinedwave = "<td>"
								+ (x.combinedwave == null
										|| x.combinedwave == "" ? ''
										: x.combinedwave) + "</td>";// 面料合用波次
						var difference = "<td>"
								+ (x.difference == null || x.difference == "" ? ''
										: x.difference) + "</td>";// 面料空差
						var totalweight = "<td>"
								+ (x.totalweight == null || x.totalweight == "" ? ''
										: x.totalweight) + "</td>";// 求和
						var totalmount = "<td>"
								+ (x.totalmount == null || x.totalmount == "" ? ''
										: x.totalmount) + "</td>";// 总金额
						// -----去除
						var purchasingOrderTime = "<td>"
								+ (x.purchasingOrderTime == null
										|| x.purchasingOrderTime == "" ? ''
										: x.purchasingOrderTime) + "</td>";// 下订单时间
						// -----去除
						var purchasingPaymentTime = "<td>"
								+ (x.purchasingPaymentTime == null
										|| x.purchasingPaymentTime == "" ? ''
										: x.purchasingPaymentTime) + "</td>";// 付款时间
						// -----去除
						var purchasingReceiptTime = "<td>"
								+ (x.purchasingReceiptTime == null
										|| x.purchasingReceiptTime == "" ? ''
										: x.purchasingReceiptTime) + "</td>";// 收货时间
						// -----去除
						var purchasingGiveoutTime = "<td>"
								+ (x.purchasingGiveoutTime == null
										|| x.purchasingGiveoutTime == "" ? ''
										: x.purchasingGiveoutTime) + "</td>";// 发出时间
						// -----去除
						var craftsOrder = "<td>"
								+ (x.craftsOrder == null || x.craftsOrder == "" ? ''
										: "<a href='" + x.craftsOrder
												+ "' target='_blank'>工艺单</a>")
								+ "</td>";// 工艺单
						var piecesApproved = "<td>"
								+ (x.piecesApproved == null
										|| x.piecesApproved == "" ? ''
										: x.piecesApproved) + "</td>";// 裁片类型
						var fabricfreight = "<td>"
								+ (x.fabricfreight == null
										|| x.fabricfreight == "" ? ''
										: x.fabricfreight) + "</td>";// 面料运费
						// -----去除
						var kindsOfFabric = "<td>"
								+ (x.kindsOfFabric == null
										|| x.kindsOfFabric == "" ? ''
										: x.kindsOfFabric) + "</td>";// 面料种类数--ABC料数
						var orderType = "<td>"
								+ (x.orderType == null || x.orderType == "" ? ''
										: x.orderType) + "</td>";// 订单类型
						var factory = "<td>"
								+ (x.factory == null || x.factory == "" ? ''
										: x.factory) + "</td>";// 车缝工厂
						var folwerFactory = "<td>"
								+ (x.folwerFactory == null
										|| x.folwerFactory == "" ? ''
										: x.folwerFactory) + "</td>";// 匹印工厂
						var fabricIsReadyStatus = "<td>"
								+ (x.fabricIsReadyStatus == '已配备' ? x.fabricIsReadyStatus
										: "<a href='javascript:;' class='remark btn btn-danger btn-sm completeReady' data-dismiss='model'>配备完成</a>")
								+ "</td>";// 面料已准备就绪状态
						var fabricIsReadyTime = "<td>"
								+ (x.fabricIsReadyTime == null
										|| x.fabricIsReadyTime == "" ? ''
										: x.fabricIsReadyTime) + "</td>";// 面料已准备就绪时间
						// -----去除
						var fabricFeedback = "<td  class='mydblClick' name='fabricFeedback'>"
								+ (x.fabricFeedback == null
										|| x.fabricFeedback == "" ? ''
										: x.fabricFeedback) + "</td>";// 面料反馈

						var fabrciIssueState = "<td>"
								+ (x.fabrciIssueState == "已发放" ? x.fabrciIssueState
										: "<a href='javascript:;' class='btn btn-primary icon-pencil completeSuccess'>发放</a>")
								+ "</td>"

						$("tbody")
								.append(
										"<tr>"
												+ "<td style='text-align: center;'>"
												+ "<input type='checkbox' class='check' name='check' /> "
												+ "</td>"
												+ id
												+ additionTime
												+ wave
												+ designImg
												+ craftsOrder
												+ fabricMaterial
												+ colour
												+ parameter1
												+ parameter2
												+ parameter3
												+ parameter4
												+ parameter5
												+ parameter6
												+ parameter7
												+ parameter8
												+ parameter9
												+ parameter10
												+ parameter11
												+ parameter12
												+ parameter13
												+ parameter14
												+ parameter15
												+ parameter16
												+ parameter17
												+ parameter18
												+ kgM
												+ totalCount
												+ remarks
												+ materials
												+ numberOrder
												// + supplier 面料供应商
												+ scheduledNumber
												// + recipient +
												// recipientAddress 收件人
												// 收货地址
												+ fabricType
												// + actualdosage + fabricprices
												// 实际用料
												// 用料总数
												+ weight
												+ combinedwave
												+ difference
												+ totalweight
												// + totalmount
												// + purchasingOrderTime 下单时间
												// + purchasingPaymentTime 付款时间
												// + purchasingReceiptTime 收货时间
												// + purchasingGiveoutTime 发出时间
												+ piecesApproved
												// + fabricfreight 面料运费
												+ kindsOfFabric
												+ orderType
												+ factory
												+ folwerFactory
												+ fabricFeedback
												// + fabricIsReadyTime
												+ fabricIsReadyStatus
												+ fabrciIssueState + "</tr>")
					});
	mydblclick();
	completeReady();
	completeSuccess()
}

function Clear() {
	$(".col-md-4 >input").val("");
}
var mySelectForm = "";
function mySelect() {
	$("#mySelectProduct").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()
						+ "/printingFabricArrange/getDataByPage.do?"
						+ mySelectForm, 1);
				//$(".col-md-2>input").val("");
			});
}
// -------------------------------------------双击修改---------------------------------------------
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
						if (thisVal != "fabric") {
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
							var num = 0;
							for (var i = 7; i < 25; i++) {
								if ($(this).parent().find("td:eq(" + i + ")")
										.text() > 0) {
									num++;
								}
							}
							$(this)
									.html(
											"<form id='dbUpdateForm'>"
													+ "<input type='hidden' name='id' value="
													+ myid
													+ " />"
													+ "<input type='hidden' name='totalCount' value='"
													+ num
													+ "'>"
													+ "<input  type='text' id='my"
													+ thisName + "' name='"
													+ thisName + "' value='"
													+ thisText + "'></form>");
							$(this).attr("class", "sn");

							fabricBlur("my" + thisName, thisText, num);
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
							+ '/printingFabricArrange/dbUpdateData.do',
					type : 'POST',
					dataType : 'json',
					data : myform,
					async : false,
					success : function(data) {
						if (data == 1) {
							firstLoadData($("#path").val()
									+ "/printingFabricArrange/getDataByPage.do?"
									+ mySelectForm, $(".laypage_curr").text());
						} else {
							alert("修改失败");
						}
					}
				});
			});
}
function fabricBlur(id, fabric, num) {
	$("#" + id).blur(function() {
		if ($("#" + id).val() == "") {
			$("#" + id).val("0");
		}
		if (fabric > 0 && ($("#" + id).val() <= 0 || $("#" + id).val() == "")) {
			num--;
			$("#dbUpdateForm").find("input:eq(1)").val(num);
		} else if ($("#" + id).val() >= 0 && (fabric <= 0 || fabric == "")) {
			num++;
			$("#dbUpdateForm").find("input:eq(1)").val(num);
		}
		setTimeout('commitTime()', 200);
	});
}

function commitTime() {
	var myform = $("#dbUpdateForm").serialize();
	$.ajax({
		url : $("#path").val() + '/printingFabricArrange/dbUpdateData.do',
		type : 'POST',
		dataType : 'json',
		data : myform,
		async : false,
		success : function(data) {
			if (data == 1) {
				firstLoadData($("#path").val()
						+ "/printingFabricArrange/getDataByPage.do?"
						+ mySelectForm, $(".laypage_curr").text());
			} else {
				alert("未修改");
			}
		}
	});
}
// -------------------------------------------配备完成按钮点击事件-----------------------------------------
function completeReady() {
	$(".completeReady").click(
			function() {
				var id = $(this).parent().parent().find('td:eq(1)').text();
				$.post($("#path").val()
						+ '/printingFabricArrange/completeReady.do', {
					id : id
				}, function(data) {
					if (data == 1) {
						alert('配备完成');
						firstLoadData($("#path").val()
								+ "/printingFabricArrange/getDataByPage.do?"
								+ mySelectForm, $(".laypage_curr").text());
					} else {
						alert('配备失败');
					}
				}, 'json');
			});
}
function completeSuccess() {
	$(".completeSuccess").click(
			function() {
				var id = $(this).parent().parent().find('td:eq(1)').text();
				$.post($("#path").val()
						+ '/printingFabricArrange/completeSuccess.do', {
					id : id
				}, function(data) {
					if (data == 1) {
						alert('发放完成');
						firstLoadData($("#path").val()
								+ "/printingFabricArrange/getDataByPage.do?"
								+ mySelectForm, $(".laypage_curr").text());
					} else {
						alert('配备失败');
					}
				}, 'json');
			});
}
// --------------------------------------------------全选按钮-------------------------------------
// 全选========点击id=checkbox 全部选中或取消
function checkAll() {
	$("#checkbox").attr("checked", false);
	$('#checkbox').click(function() {
		if (this.checked) {
			$("input[name='check']").each(function() {
				this.checked = true;
			});
		} else {
			$("input[name='check']").each(function() {
				this.checked = false;
			});
		}
	});
	$("[name='check']").click(function() {
		if ($("[name='check']").is("checked")) {
		} else {
			$('#checkbox').attr("checked", false);
		}
	});
}

// 生成工艺单
function toExcle() {
	$("#toExcle").on("click", function() {
		var ids = "";
		$("#tbody").find(":checkbox:checked").each(function() {
			var id = $(this).parent().parent().find("td:eq(1)").text().trim();
			ids += id + ",";
		});
		if (ids == "") {
			alert("请选择要导出的数据");
		} else {
			ids = ids.substr(0, ids.length - 1);
			if (confirm('确定导出这些数据吗?')) {
				window.open('/printingFabricArrange/toExcle.do?ids=' + ids);
			} else {
				return false;
			}
		}
	});
}
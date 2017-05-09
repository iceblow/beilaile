$(function() {
	// 分页查询
	loadPageDatas(1);
	// 理单完成按钮事件
	completeOrder();
	// 查询按钮点击事件
	mySelectBtnClick();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val()
			+ "/printingAndEmbroideredOrder/getDataByPage.do", index); // 指定url
}
// 打印数据
function loadData(data) {
	$("tbody").empty();
	$
			.each(
					data,
					function(index, x) {

						var id = "<input type='hidden' class='id' value="
								+ x.id + ">"

						var wave = x.wave == null ? "<td></td>" : "<td>"
								+ x.wave + "</td>";// 波次号

						var productCoed = x.productCoed == null ? "<td></td>"
								: "<td>" + x.productCoed + "</td>";// 商品编号

						var designer = x.designer == null ? "<td></td>"
								: "<td>" + x.designer + "</td>";// 设计师

						var referencePrinting = x.referencePrinting == null ? "<td></td>"
								: "<td>" + x.referencePrinting + "</td>";// 参考印花

						var designImg = "<td>"
								+ (x.designImg == null || x.designImg == "" ? ''
										: "<img src='"
												+ x.designImg
												+ "' width='90px' height='60px'/>");
						var sampleImg = x.sampleImg == null
								|| x.sampleImg == "" ? "<td></td>"
								: "<td><a href='" + x.sampleImg
										+ "' target='_blank'>工艺单</a></td>";// 工艺单

						var patternCraftsOrder = x.patternCraftsOrder == null
								|| x.patternCraftsOrder == "" ? "<td></td>"
								: "<td><a href='" + x.patternCraftsOrder
										+ "' target='_blank'>图样工艺单</a></td>";// 图样工艺单

						var orderDetails = x.orderDetails == null ? "<td></td>"
								: "<td>" + x.orderDetails + "</td>";// 订单明细(尺码详情)

						var orders = x.orders == null ? "<td></td>" : "<td>"
								+ x.orders + "</td>";// 订单数量

						var printingOrEmbroidered = x.printingOrEmbroidered == null ? "<td></td>"
								: "<td>" + x.printingOrEmbroidered + "</td>";// 是否有印绣花

						var ifPrinting = x.ifPrinting == null ? "<td></td>"
								: "<td>" + x.ifPrinting + "</td>";// 是匹印

						var fabricA = x.fabricA == null ? "<td></td>" : "<td>"
								+ x.fabricA + "</td>";// 面料A匹印

						var fabricB = x.fabricB == null ? "<td></td>" : "<td>"
								+ x.fabricB + "</td>";// 面料B匹印

						var fabricC = x.fabricC == null ? "<td></td>" : "<td>"
								+ x.fabricC + "</td>";// 面料C匹印

						var fabricD = x.fabricD == null ? "<td></td>" : "<td>"
								+ x.fabricD + "</td>";// 面料D匹印

						var fabricE = x.fabricE == null ? "<td></td>" : "<td>"
								+ x.fabricE + "</td>";// 面料E匹印

						var requirePrinting = x.requirePrinting == null ? "<td></td>"
								: "<td>" + x.requirePrinting + "</td>";// 匹印要求

						var ifSlice = x.ifSlice == null ? "<td></td>" : "<td>"
								+ x.ifSlice + "</td>";// 是否片印

						var sliceAddress = x.sliceAddress == null ? "<td></td>"
								: "<td>" + x.sliceAddress + "</td>";// 片印位置

						var requireSlice = x.requireSlice == null ? "<td></td>"
								: "<td>" + x.requireSlice + "</td>";// 片印要求

						var ifEmbroider = x.ifEmbroider == null ? "<td></td>"
								: "<td>" + x.ifEmbroider + "</td>";// 是否绣花

						var embroiderAddress = x.embroiderAddress == null ? "<td></td>"
								: "<td>" + x.embroiderAddress + "</td>";// 绣花位置

						var requireEmbroider = x.requireEmbroider == null ? "<td></td>"
								: "<td>" + x.requireEmbroider + "</td>";// 绣花要求

						var completeOrder = x.completeOrder == "理单完成" ? "<td>"
								+ x.completeOrder + "</td>"
								: "<td><button style='float: right;' class='label label-lg label-yellow arrowed-in order' data-toggle='modal' data-target='#myModal'>理单</button></td>";// 理单完成
						var orderAgain = x.completeOrder == "理单完成" ? "<td><button class='label label-lg label-pink arrowed-right' onclick='orderAgain(\""
								+ x.wave + "\")'>重新理单</button></td>"
								: "<td></td>";

						$("tbody").append("<tr>" + id + wave// 波次号
								+ productCoed// 商品编号
								+ designer// 设计师
								+ referencePrinting// 参考印花
								+ designImg// 设计图
								+ sampleImg// 工艺单
								+ patternCraftsOrder// 图样工艺单
								+ orderDetails// 订单明细(尺码详情)
								+ orders// 订单数量
								+ printingOrEmbroidered// 是否有印绣花
								+ ifPrinting// 是匹印
								+ fabricA// 面料A匹印
								+ fabricB// 面料B匹印
								+ fabricC// 面料C匹印
								+ fabricD// 面料D匹印
								+ fabricE// 面料E匹印
								+ requirePrinting// 匹印要求
								+ ifSlice// 是否片印
								+ sliceAddress// 片印位置
								+ requireSlice// 片印要求
								+ ifEmbroider// 是否绣花
								+ embroiderAddress// 绣花位置
								+ requireEmbroider// 绣花要求
								+ completeOrder// 理单完成
								+ orderAgain// 重新理单按钮
								+ "</tr>");

					});
	// 初始化控件
	initialize();
}

// 初始化控件
function initialize() {
	$(".order").click(
			function() {
				document.getElementById("ifPrinting").checked = false;
				document.getElementById("fabricA").checked = false;
				document.getElementById("fabricB").checked = false;
				document.getElementById("fabricC").checked = false;
				document.getElementById("fabricD").checked = false;
				document.getElementById("fabricE").checked = false;
				document.getElementById("ifSlice").checked = false;
				document.getElementById("ifEmbroider").checked = false;
				document.getElementById("ifFlase").checked = true;
				$("#requirePrinting").val("");// 清空匹印要求
				$("#sliceAddress").val("");// 清空片印位置
				$("#requireSlice").val("");// 清空片印要求
				$("#embroiderAddress").val("");// 清空绣花位置
				$("#requireEmbroider").val("");// 清空绣花要求
				$("#allPrintDiv").hide();
				$("#allSliceDiv").hide();
				$("#allEmbroiderDiv").hide();
				// 隐藏div
				$(".fabric").hide();
				$(".silce").hide();
				$(".embroider").hide();
				$(":radio").click(function() {
					var val = $(this).val();
					if (val == "无") {
						$("#allPrintDiv").hide();
						$("#allSliceDiv").hide();
						$("#allEmbroiderDiv").hide();
						// 去掉所有的选中状态
						document.getElementById("ifPrinting").checked = false;
						document.getElementById("fabricA").checked = false;
						document.getElementById("fabricB").checked = false;
						document.getElementById("fabricC").checked = false;
						document.getElementById("fabricD").checked = false;
						document.getElementById("fabricE").checked = false;
						document.getElementById("ifSlice").checked = false;
						document.getElementById("ifEmbroider").checked = false;
						// 隐藏div
						$(".fabric").hide();
						$(".silce").hide();
						$(".embroider").hide();
					} else if (val == "有") {
						$("#allPrintDiv").show();
						$("#allSliceDiv").show();
						$("#allEmbroiderDiv").show();
					}
				});
				$("#ifPrintingDiv").click(function() {
					var ifchecked = document.getElementById("ifPrinting");
					if (ifchecked.checked) {
						$(".fabric").show();
					} else {
						$(".fabric").hide();
					}
				});
				$("#ifSliceDiv").click(function() {
					var ifchecked = document.getElementById("ifSlice");
					if (ifchecked.checked) {
						$(".silce").show();
					} else {
						$(".silce").hide();
					}
				});
				$("#ifEmbroiderDiv").click(function() {
					var ifchecked = document.getElementById("ifEmbroider");
					if (ifchecked.checked) {
						$(".embroider").show();
					} else {
						$(".embroider").hide();
					}
				});
				$(".col-md-3>.text").val("");
				$("#wave").val(
						$(this).parent().parent().find("td:eq(0)").text()
								.trim());
				$("#id").val($(this).parent().parent().find(".id").val());
			});
}

// 理单完成
function completeOrder() {
	$("#completeOrder")
			.click(
					function() {
						var data = $("#myCompleteOrderForm").serialize();
						$
								.ajax({
									url : 'printingAndEmbroideredOrder/completeOrder.do',
									type : 'post',
									dataType : 'json',
									data : data,
									success : function(data) {
										firstLoadData(
												$("#path").val()
														+ "/printingAndEmbroideredOrder/getDataByPage.do?"
														+ selectForm, $(
														".laypage_curr").text()
														.trim()); // 指定url
									}
								});
					});
}
var selectForm="";
// 模糊查询
function mySelectBtnClick() {
	$("#mySelectBtn").click(
			function() {
				selectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()
						+ "/printingAndEmbroideredOrder/getDataByPage.do?"
						+ selectForm, 1); // 指定url
			});
}
// 重新理单事件
function orderAgain(wave) {
	layer.confirm('确定要重新理'+wave+'？', {
		  btn: ['是的','取消'] //按钮
		}, function(){
			$.ajax({
				url : 'printingAndEmbroideredOrder/orderAgain.do',
				type : 'post',
				data : {
					wave : wave,
				},
				success : function(data) {
					firstLoadData($("#path").val()
							+ "/printingAndEmbroideredOrder/getDataByPage.do?"
							+ selectForm, $(".laypage_curr").text().trim()); // 指定url
					layer.msg('重新理单成功');
				}
			});
		}, function(){
		  layer.msg('取消');
		});
}
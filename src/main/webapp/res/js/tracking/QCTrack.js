$(function() {

	myselect()

	myupdate();

	add();

});
var myimg = "";

function myselect() {
	var factory = $("#myfactory").val().trim();
	var qc = $("#myqc").val().trim();
	var b_id = $("#myb_id").val().trim();
	var outTime = $("#myoutTime").val().trim();
	var orderType = $("#myorderType").val().trim();
	var fabricToPlantTime = $("#myfabricToPlantTime").val().trim();
	var accessoriesToPlantTime = $("#myaccessoriesToPlantTime").val().trim();
	var printtingTime = $("#myprinttingTime").val().trim();
	var backToTheFactoryTime = $("#mybackToTheFactoryTime").val().trim();
	var cdPrintingTime = $("#mycdPrintingTime").val().trim();
	var embroideryAndPrintingBackToTheFactoryTime = $(
			"#myembroideryAndPrintingBackToTheFactoryTime").val().trim();
	var piecePickingTime = $("#mypiecePickingTime").val().trim();
	var cuttingTime = $("#mycuttingTime").val().trim();
	var cuttingDetail = $("#mycuttingDetail").val().trim();
	var workshopProductionTime = $("#myworkshopProductionTime").val().trim();
	var afterTheWholeTime = $("#myafterTheWholeTime").val().trim();
	var deliveryTime = $("#mydeliveryTime").val().trim();
	var outNum = $("#myoutNum").val().trim();
	var quality = $("#myquality").val().trim();

	firstLoadData($("#path").val() + "/qcTrack/getCondationByPage.do?factory="
			+ factory + "&qc=" + qc + "&b_id=" + b_id + "&outTime=" + outTime
			+ "&orderType=" + orderType + "&fabricToPlantTime="
			+ fabricToPlantTime + "&accessoriesToPlantTime="
			+ accessoriesToPlantTime + "&printtingTime=" + printtingTime
			+ "&backToTheFactoryTime=" + backToTheFactoryTime
			+ "&cdPrintingTime=" + cdPrintingTime
			+ "&embroideryAndPrintingBackToTheFactoryTime="
			+ embroideryAndPrintingBackToTheFactoryTime + "&piecePickingTime="
			+ piecePickingTime + "&cuttingTime=" + cuttingTime
			+ "&cuttingDetail=" + cuttingDetail + "&workshopProductionTime="
			+ workshopProductionTime + "&afterTheWholeTime="
			+ afterTheWholeTime + "&deliveryTime=" + deliveryTime + "&outNum="
			+ outNum + "&quality=" + quality, 1);

	$("#myfactory").val("");
	$("#myqc").val("");
	$("#myb_id").val("");
	$("#myoutTime").val("");
	$("#myorderType").val("");
	$("#myfabricToPlantTime").val("");
	$("#myaccessoriesToPlantTime").val("");
	$("#myprinttingTime").val("");
	$("#mybackToTheFactoryTime").val("");
	$("#mycdPrintingTime").val("");
	$("#myembroideryAndPrintingBackToTheFactoryTime").val("");
	$("#mypiecePickingTime").val("");
	$("#mycuttingTime").val("");
	$("#mycuttingDetail").val("");
	$("#myworkshopProductionTime").val("");
	$("#myafterTheWholeTime").val("");
	$("#mydeliveryTime").val("");
	$("#myoutNum").val("");
	$("#myquality").val("");
}

// 进入后台进行分页查询
function loadPageDatas(index) {

	// 处理后的数据
	firstLoadData($("#path").val() + "/qcTrack/getAllByPage.do", index);

}
// 分页查询以后前台页面打印
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
						var id = "<td>" + (x.id == null ? '' : x.id) + "</td>";
						var factory = "<td>"
								+ (x.factory == null ? '' : x.factory)
								+ "</td>";
						var qc = "<td>" + (x.qc == null ? '' : x.qc) + "</td>";
						var b_id = "<td>" + (x.b_id == null ? '' : x.b_id)
								+ "</td>";
						var img = "<td><img width='70px' height='40px' src='"
								+ (x.img == null ? '' : x.img) + "'/></td>";
						var order_date = "<td>"
								+ (x.order_date == null ? '' : x.order_date)
								+ "</td>";
						var outTime = "<td>"
								+ (x.outTime == null ? '' : x.outTime)
								+ "</td>";
						var orderType = "<td>"
								+ (x.orderType == null ? '' : x.orderType)
								+ "</td>";
						var fabricToPlantTime = "<td>"
								+ (x.fabricToPlantTime == null ? ''
										: x.fabricToPlantTime) + "</td>";
						var accessoriesToPlantTime = "<td>"
								+ (x.accessoriesToPlantTime == null ? ''
										: x.accessoriesToPlantTime) + "</td>";
						var printtingTime = "<td>"
								+ (x.printtingTime == null ? ''
										: x.printtingTime) + "</td>";
						var backToTheFactoryTime = "<td>"
								+ (x.backToTheFactoryTime == null ? ''
										: x.backToTheFactoryTime) + "</td>";
						var cdPrintingTime = "<td>"
								+ (x.cdPrintingTime == null ? ''
										: x.cdPrintingTime) + "</td>";
						var embroideryAndPrintingBackToTheFactoryTime = "<td>"
								+ (x.embroideryAndPrintingBackToTheFactoryTime == null ? ''
										: x.embroideryAndPrintingBackToTheFactoryTime)
								+ "</td>";
						var piecePickingTime = "<td>"
								+ (x.piecePickingTime == null ? ''
										: x.piecePickingTime) + "</td>";
						var cuttingTime = "<td>"
								+ (x.cuttingTime == null ? '' : x.cuttingTime)
								+ "</td>";
						var cuttingDetail = "<td>"
								+ (x.cuttingDetail == null ? ''
										: x.cuttingDetail) + "</td>";
						var workshopProductionTime = "<td>"
								+ (x.workshopProductionTime == null ? ''
										: x.workshopProductionTime) + "</td>";
						var afterTheWholeTime = "<td>"
								+ (x.afterTheWholeTime == null ? ''
										: x.afterTheWholeTime) + "</td>";
						var deliveryTime = "<td>"
								+ (x.deliveryTime == null ? '' : x.deliveryTime)
								+ "</td>";
						var outNum = "<td>"
								+ (x.outNum == null ? '' : x.outNum) + "</td>";
						var quality = "<td>"
								+ (x.quality == null ? '' : x.quality)
								+ "</td>";

						$("tbody")
								.append(
										"<tr>"
												+ id
												+ factory
												+ qc
												+ b_id
												+ img
												+ order_date
												+ outTime
												+ orderType
												+ fabricToPlantTime
												+ accessoriesToPlantTime
												+ printtingTime
												+ backToTheFactoryTime
												+ cdPrintingTime
												+ embroideryAndPrintingBackToTheFactoryTime
												+ piecePickingTime
												+ cuttingTime
												+ cuttingDetail
												+ workshopProductionTime
												+ afterTheWholeTime
												+ deliveryTime
												+ outNum
												+ quality

												+ "<td><a data-toggle='modal' data-target='#myModal1' href='javascript:;' class='update'>修改</a></td></tr>");
						// <a href='javascript:;' class='del'>删除</a>|
					});
	update();
}
// 添加方法
function add() {
	$("#add").click(function() {
		Clear();
	});
	$("#addSub")
			.click(
					function() {
						// 取值
						var factory = $("#factory").val();
						var qc = $("#qc").val();
						var b_id = $("#b_id").val();
						var img = $("#img").val();
						var orderDate = $("#orderDate").val();
						var outTime = $("#outTime").val();
						var orderType = $("#orderType").val();
						var fabricToPlantTime = $("#fabricToPlantTime").val();
						var accessoriesToPlantTime = $(
								"#accessoriesToPlantTime").val();
						var printtingTime = $("#printtingTime").val();
						var backToTheFactoryTime = $("#backToTheFactoryTime")
								.val();
						var cdPrintingTime = $("#cdPrintingTime").val();
						var embroideryAndPrintingBackToTheFactoryTime = $(
								"#embroideryAndPrintingBackToTheFactoryTime")
								.val();
						var piecePickingTime = $("#piecePickingTime").val();
						var cuttingTime = $("#cuttingTime").val();
						var cuttingDetail = $("#cuttingDetail").val();
						var workshopProductionTime = $(
								"#workshopProductionTime").val();
						var afterTheWholeTime = $("#afterTheWholeTime").val();
						var deliveryTime = $("#deliveryTime").val();
						var outNum = $("#outNum").val();
						var quality = $("#quality").val();

						// 執行文件上傳方法
						$
								.ajaxFileUpload({
									url : $("#path").val()
											+ '/qcTrack/addQCTrack.do',
									secureuri : false,// 一般设置为false
									fileElementId : 'file',// 上传对象
									data : {
										"factory" : factory,
										"qc" : qc,
										"b_id" : b_id,
										"order_date" : orderDate,
										"outTime" : outTime,
										"orderType" : orderType,
										"fabricToPlantTime" : fabricToPlantTime,
										"accessoriesToPlantTime" : accessoriesToPlantTime,
										"printtingTime" : printtingTime,
										"backToTheFactoryTime" : backToTheFactoryTime,
										"cdPrintingTime" : cdPrintingTime,
										"embroideryAndPrintingBackToTheFactoryTime" : embroideryAndPrintingBackToTheFactoryTime,
										"piecePickingTime" : piecePickingTime,
										"cuttingTime" : cuttingTime,
										"cuttingDetail" : cuttingDetail,
										"workshopProductionTime" : workshopProductionTime,
										"afterTheWholeTime" : afterTheWholeTime,
										"deliveryTime" : deliveryTime,
										"outNum" : outNum,
										"quality" : quality,

									},
									dataType : 'json',
									success : function(mydata) {
										loadPageDatas(1);
										Clear();
									},
									error : function(data) {
										alert("添加失敗");
									}
								});
					});
}

function Clear() {
	$("#factory").val("");
	$("#qc").val("");
	$("#b_id").val("");
	$("#file").val("");
	$("#orderDate").val("");
	$("#outTime").val("");
	$("#orderType").val("");
	$("#fabricToPlantTime").val("");
	$("#accessoriesToPlantTime").val("");
	$("#printtingTime").val("");
	$("#backToTheFactoryTime").val("");
	$("#cdPrintingTime").val("");
	$("#embroideryAndPrintingBackToTheFactoryTime").val("");
	$("#piecePickingTime").val("");
	$("#cuttingTime").val("");
	$("#cuttingDetail").val("");
	$("#workshopProductionTime").val("");
	$("#afterTheWholeTime").val("");
	$("#deliveryTime").val("");
	$("#outNum").val("");
	$("#quality").val("");
}

function update() {

	$(".update").click(
			function() {
				$("#id").val("");
				$("#factorys").val("");
				$("#qcs").val("");
				$("#b_ids").val("");
				$("#files").val("");
				$("#orderDates").val("");
				$("#outTimes").val("");
				$("#orderTypes").val("");
				$("#fabricToPlantTimes").val("");
				$("#accessoriesToPlantTimes").val("");
				$("#printtingTimes").val("");
				$("#backToTheFactoryTimes").val("");
				$("#cdPrintingTimes").val("");
				$("#embroideryAndPrintingBackToTheFactoryTimes").val("");
				$("#piecePickingTimes").val("");
				$("#cuttingTimes").val("");
				$("#cuttingDetails").val("");
				$("#workshopProductionTimes").val("");
				$("#afterTheWholeTimes").val("");
				$("#deliveryTimes").val("");
				$("#outNums").val("");
				$("#qualitys").val("");

				var id = $(this).parent().parent().find("td:eq(0)").text()
						.trim();
				var factory = $(this).parent().parent().find("td:eq(1)").text()
						.trim();
				var qc = $(this).parent().parent().find("td:eq(2)").text()
						.trim();
				var b_id = $(this).parent().parent().find("td:eq(3)").text()
						.trim();

				var file = $(this).parent().parent().find("td:eq(4)").find(
						"img").attr("src");
				var orderDate = $(this).parent().parent().find("td:eq(5)")
						.text().trim();
				var outTime = $(this).parent().parent().find("td:eq(6)").text()
						.trim();
				var orderType = $(this).parent().parent().find("td:eq(7)")
						.text().trim();
				var fabricToPlantTime = $(this).parent().parent().find(
						"td:eq(8)").text().trim();
				var accessoriesToPlantTime = $(this).parent().parent().find(
						"td:eq(9)").text().trim();
				var printtingTime = $(this).parent().parent().find("td:eq(10)")
						.text().trim();
				var backToTheFactoryTime = $(this).parent().parent().find(
						"td:eq(11)").text().trim();
				var cdPrintingTime = $(this).parent().parent()
						.find("td:eq(12)").text().trim();
				var embroideryAndPrintingBackToTheFactoryTime = $(this)
						.parent().parent().find("td:eq(13)").text().trim();
				var piecePickingTime = $(this).parent().parent().find(
						"td:eq(14)").text().trim();
				var cuttingTime = $(this).parent().parent().find("td:eq(15)")
						.text().trim();
				var cuttingDetail = $(this).parent().parent().find("td:eq(16)")
						.text().trim();
				var workshopProductionTime = $(this).parent().parent().find(
						"td:eq(17)").text().trim();
				var afterTheWholeTime = $(this).parent().parent().find(
						"td:eq(18)").text().trim();
				var deliveryTime = $(this).parent().parent().find("td:eq(19)")
						.text().trim();
				var outNum = $(this).parent().parent().find("td:eq(20)").text()
						.trim();
				var quality = $(this).parent().parent().find("td:eq(21)")
						.text().trim();

				$("#ids").val(id);
				$("#factorys").val(factory);
				$("#qcs").val(qc);
				$("#b_ids").val(b_id);
				$("#orderDates").val(orderDate);
				$("#outTimes").val(outTime);
				$("#orderTypes").val(orderType);
				$("#fabricToPlantTimes").val(fabricToPlantTime);
				$("#accessoriesToPlantTimes").val(accessoriesToPlantTime);
				$("#printtingTimes").val(printtingTime);
				$("#backToTheFactoryTimes").val(backToTheFactoryTime);
				$("#cdPrintingTimes").val(cdPrintingTime);
				$("#embroideryAndPrintingBackToTheFactoryTimes").val(
						embroideryAndPrintingBackToTheFactoryTime);
				$("#piecePickingTimes").val(piecePickingTime);
				$("#cuttingTimes").val(cuttingTime);
				$("#cuttingDetails").val(cuttingDetail);
				$("#workshopProductionTimes").val(workshopProductionTime);
				$("#afterTheWholeTimes").val(afterTheWholeTime);
				$("#deliveryTimes").val(deliveryTime);
				$("#outNums").val(outNum);
				$("#qualitys").val(quality);

				myimg = file;
			});
}

function myupdate() {
	$("#updateSub")
			.click(
					function() {
						var id = $("#ids").val();
						var factory = $("#factorys").val();
						var qc = $("#qcs").val();
						var b_id = $("#b_ids").val();
						var img = $("#imgs").val();
						
						var orderDate=$("#orderDates").val();
						
						var outTime = $("#outTimes").val();
						var orderType = $("#orderTypes").val();
						var fabricToPlantTime = $("#fabricToPlantTimes").val();
						var accessoriesToPlantTime = $(
								"#accessoriesToPlantTimes").val();
						var printtingTime = $("#printtingTimes").val();
						var backToTheFactoryTime = $("#backToTheFactoryTimes")
								.val();
						var cdPrintingTime = $("#cdPrintingTimes").val();
						var embroideryAndPrintingBackToTheFactoryTime = $(
								"#embroideryAndPrintingBackToTheFactoryTimes")
								.val();
						var piecePickingTime = $("#piecePickingTimes").val();
						var cuttingTime = $("#cuttingTimes").val();
						var cuttingDetail = $("#cuttingDetails").val();
						var workshopProductionTime = $(
								"#workshopProductionTimes").val();
						var afterTheWholeTime = $("#afterTheWholeTimes").val();
						var deliveryTime = $("#deliveryTimes").val();
						var outNum = $("#outNums").val();
						var quality = $("#qualitys").val();
						alert("----->"+orderDate);
						// 執行文件上傳方法
						$
								.ajaxFileUpload({
									url : $("#path").val()
											+ '/qcTrack/updateQCTrack.do',
									secureuri : false,// 一般设置为false
									fileElementId : 'files',// 上传对象
									data : {
										"id" : id,
										"factory" : factory,
										"qc" : qc,
										"b_id" : b_id,
										"order_date":orderDate,
										"outTime" : outTime,
										"orderType" : orderType,
										"fabricToPlantTime" : fabricToPlantTime,
										"accessoriesToPlantTime" : accessoriesToPlantTime,
										"printtingTime" : printtingTime,
										"backToTheFactoryTime" : backToTheFactoryTime,
										"cdPrintingTime" : cdPrintingTime,
										"embroideryAndPrintingBackToTheFactoryTime" : embroideryAndPrintingBackToTheFactoryTime,
										"piecePickingTime" : piecePickingTime,
										"cuttingTime" : cuttingTime,
										"cuttingDetail" : cuttingDetail,
										"workshopProductionTime" : workshopProductionTime,
										"afterTheWholeTime" : afterTheWholeTime,
										"deliveryTime" : deliveryTime,
										"outNum" : outNum,
										"quality" : quality,
										"myimg" : myimg,
									},
									dataType : 'json',
									success : function(mydata) {
										loadPageDatas(1);
										Clear();
									},
									error : function(data) {
										alert("添加失敗");
									}
								});
					});
}

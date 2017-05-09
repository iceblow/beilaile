$(function() {
	loadPageDatas(1);

	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val() + "/taisanCuttingOutflow/getDataByPage.do",
			index); // 指定url
}

function loadData(data) {
	$("tbody").empty();
	$
			.each(
					data,
					function(index, x) {
						var wave = "<td>" + (x.wave != null ? x.wave : "") + "</td>";// 波次号
						var productCode = "<td>"
								+ (x.productCode != null ? x.productCode : "")
								+ "</td>";// 商品编号
						var craftsOrder = "<td>"
								+ (x.craftsOrder != null ? "<a href='"
										+ x.craftsOrder
										+ "' target='_blank'>工艺单</a>" : "")
								+ "</td>";// 工艺单
						var oringinalWave = "<td>"
								+ (x.oringinalWave != null ? x.oringinalWave
										: "") + "</td>";// 原波次--
						var versionReferenceWave = "<td>"
								+ (x.versionReferenceWave != null ? x.versionReferenceWave
										: "") + "</td>";// 版型参考波次--
						var printingReferenceWave = "<td>"
								+ (x.printingReferenceWave != null ? x.printingReferenceWave
										: "") + "</td>";// 印花参考波次--
						var designImg = "<td>"
								+ (x.designImg != null ? "<img src='"
										+ x.designImg
										+ "' width='100px' height='80px'>" : "")
								+ "</td>";// 商品图片
						var cuttingDate = "<td>"
								+ (x.cuttingDate != null ? x.cuttingDate : "")
								+ "</td>";// 裁剪日期
						var cuttingNum = "<td>"
								+ (x.cuttingNum != null ? x.cuttingNum : "")
								+ "</td>";// 裁剪数
						var cuttingMan = "<td>"
								+ (x.cuttingMan != null ? x.cuttingMan : "")
								+ "</td>";// 裁剪人
						var packets = "<td>"
								+ (x.packets != null ? x.packets : "")
								+ "</td>";// 包数--
						var shelves = "<td>"
								+ (x.shelves != null ? x.shelves : "")
								+ "</td>";// 货架--
						var factory = "<td>"
								+ (x.factory != null ? x.factory : "")
								+ "</td>";// 车缝工厂--
						var arrangeFabricAndAssistMaterial = "<td>"
								+ (x.arrangeFabricAndAssistMaterial == '裁片辅料已安排' ? x.arrangeFabricAndAssistMaterial
										: "") + "</td>";// 安排裁片和辅料
						var arrangeFabricAndAssistMaterialTime = "<td>"
								+ (x.arrangeFabricAndAssistMaterialTime != null ? x.arrangeFabricAndAssistMaterialTime
										: "") + "</td>";// 安排裁片和辅料时间
						var cuttingPieceReady = "<td>"
								+ (x.cuttingPieceReady == '裁片已就绪' ? x.cuttingPieceReady
										: "<a class='btn btn-app btn-warning cuttingPieceReady' href='javascript:void(0);'>裁片就绪</a>")
								+ "</td>";// 裁片就绪
						var cuttingPieceReadyTime = "<td>"
								+ (x.cuttingPieceReadyTime != null ? x.cuttingPieceReadyTime : "") + "</td>";// 裁片就绪时间
						var cuttingPieceOut = "<td>"
								+ (x.cuttingPieceOut == '工厂已领(裁)' ? x.cuttingPieceOut
										: "<a class='btn btn-app btn-purple btn-sm cuttingPieceOut' href='javascript:void(0);'>裁片发放</a>")
								+ "</td>";// 裁片外发
						var cuttingPieceOutTime = "<td>"
								+ (x.cuttingPieceOutTime != null ? x.cuttingPieceOutTime
										: "") + "</td>";// 裁片外发时间
						
						var rowOfSingleAgain =x.rowOfSingleAgain == '需要重新排单' ? "<td ><button  onclick='updateById class='class='btn btn-app btn-purple btn-sm rowOfSingleAgain'>重新排单</button></td> " : "<td>"+(x.rowOfSingleAgain==null?'':x.rowOfSingleAgain)+"</td>";
							$("tbody").append(
								"<tr>" + wave + productCode + craftsOrder
										+ designImg + cuttingDate + cuttingNum
										+ cuttingMan + packets + shelves
										+ factory
										+ arrangeFabricAndAssistMaterialTime
										+ cuttingPieceReady
										+ cuttingPieceReadyTime
										+ cuttingPieceOut + cuttingPieceOutTime
										+ rowOfSingleAgain
										+ "</tr>");
					});
	// 裁片就绪
	cuttingPieceReadyClick();
	// 裁片发放
	cuttingPieceOutClick();
	updateRowOfSingleAgain();
}

//根据波次修改字段值
function updateRowOfSingleAgain(){
	$(".rowOfSingleAgain").click(function() {
	var wave = $(this).parent().parent().find("td:eq(0)").text().trim();
	$.ajax({
		url : "/taisanCuttingOutflow/updateRowOfSingleAgainByWave.do",
		type : 'post',
		dataType : 'json',
		data : {wave : wave,},
		success : function(data) {
			if (data == 1) {
				firstLoadData($("#path").val()
						+ "/taisanCuttingOutflow/getDataByPage.do?"
						+ mySelectForm, $(".laypage_curr").text());
			}else{
				alert("修改字段失败");
			}
		}
	});
	});
}




var mySelectForm;
// 查詢按鈕點擊事件
function select() {
	$("#myselect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()
						+ "/taisanCuttingOutflow/getDataByPage.do?"
						+ mySelectForm, 1); // 指定url
				// -注释时间:2017年1月6日16:54:06
				// -注释原因:查询之后保留查询内容
				// $(".col-md-2>input").val("");
			});
}

function cuttingPieceReadyClick() {
	$(".cuttingPieceReady").click(
			function() {
				var wave = $(this).parent().parent().find("td:eq(0)").text().trim();
				$.ajax({
					url : $("#path").val()
							+ "/taisanCuttingOutflow/cuttingPieceReady.do",
					type : 'post',
					dataType : 'json',
					data : {
						wave : wave,
					},
					success : function(data) {
						if (data == 1) {
							firstLoadData($("#path").val()
									+ "/taisanCuttingOutflow/getDataByPage.do?"
									+ mySelectForm, $(".laypage_curr").text());
							layer.msg('裁片已就绪', {
								icon : 6,
								time : 2000,
							})
						}
					},
					erroe : function() {
						layer.msg('修改失败', {
							icon : 5,
							time : 2000,
						})
					}
				});
			});
}

function cuttingPieceOutClick() {
	$(".cuttingPieceOut").click(
			function() {
				var wave = $(this).parent().parent().find("td:eq(0)").text()
						.trim();
				var cuttingPieceReady = $(this).parent().parent().find(
						"td:eq(11)").text().trim();

				if (cuttingPieceReady != '裁片已就绪') {
					layer.msg('裁片未就绪', {
						icon : 5,
						time : 2000,
					})
					return;
				}
				$.ajax({
					url : $("#path").val()
							+ "/taisanCuttingOutflow/cuttingPieceOut.do",
					type : 'post',
					dataType : 'json',
					data : {
						wave : wave,
					},
					success : function(data) {
						if (data == 1) {
							firstLoadData($("#path").val()
									+ "/taisanCuttingOutflow/getDataByPage.do?"
									+ mySelectForm, $(".laypage_curr").text());
							layer.msg('裁片已发放', {
								icon : 6,
								time : 2000,
							})
						}
					},
					erroe : function() {
						layer.msg('修改失败', {
							icon : 5,
							time : 2000,
						})
					}
				});
			});
}
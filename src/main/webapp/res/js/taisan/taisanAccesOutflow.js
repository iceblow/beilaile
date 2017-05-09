$(function() {
	loadPageDatas(1);

	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val() + "/taisanAccesOutflow/getDataByPage.do",
			index); // 指定url
}

function loadData(data) {
	$("tbody").empty();
	$
			.each(
					data,
					function(index, x) {
						var wave = "<td>" + (x.wave != null ? x.wave : "")
								+ "</td>";// 波次号
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
										: "") + "</td>";// 原波次
						var versionReferenceWave = "<td>"
								+ (x.versionReferenceWave != null ? x.versionReferenceWave
										: "") + "</td>";// 版型参考波次
						var printingReferenceWave = "<td>"
								+ (x.printingReferenceWave != null ? x.printingReferenceWave
										: "") + "</td>";// 印花参考波次
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
						var flowerType = "<td>"
								+ (x.flowerType != null ? x.flowerType : "")
								+ "</td>";// 印花类型
						var cutLargeReceiveDate = "<td>"
								+ (x.cutLargeReceiveDate != null ? x.cutLargeReceiveDate
										: "") + "</td>";// 片印领料日期
						var cutLargeReturnDate = "<td>"
								+ (x.cutLargeReturnDate != null ? x.cutLargeReturnDate
										: "") + "</td>";// 片印回料日期
						var flowerFactory = "<td>"
								+ (x.flowerFactory != null ? x.flowerFactory
										: "") + "</td>";// 印花工厂
						var factory = "<td>"
								+ (x.factory != null ? x.factory : "")
								+ "</td>";// 车缝工厂--
						var arrangeFabricAndAssistMaterial = "<td>"
								+ (x.arrangeFabricAndAssistMaterial == '裁片辅料已安排' ? x.arrangeFabricAndAssistMaterial
										: "")
								+ "</td>";// 安排裁片和辅料--
						var arrangeFabricAndAssistMaterialTime = "<td>"
								+ (x.arrangeFabricAndAssistMaterialTime != null ? x.arrangeFabricAndAssistMaterialTime
										: "") + "</td>";// 安排裁片和辅料时间
						
						var assistMaterialReady = "<td>"
								+ (x.assistMaterialReady == '辅料已就绪' ? x.assistMaterialReady
										: "<a class='btn btn-app btn-warning assistMaterialReady' href='javascript:void(0);'>辅料就绪</a>") + "</td>";// 辅料就绪--
						var assistMaterialReadyTime = "<td>"
								+ (x.assistMaterialReadyTime != null ? x.assistMaterialReadyTime
										: "") + "</td>";// 辅料就绪时间
						var assistOut = "<td>"
								+ (x.assistOut == '工厂已领(辅)' ? x.assistOut :
									"<a class='btn btn-app btn-purple btn-sm assistOut' href='javascript:void(0);'>辅料发放</a>")
								+ "</td>";// 辅料外发--
						var assistOutTime = "<td>"
								+ (x.assistOutTime != null ? x.assistOutTime
										: "") + "</td>";// 辅料外发时间
						var rowOfSingleAgain = "<td>"
							+ (x.rowOfSingleAgain == '需要重新排单' ?"<a class='btn btn-app btn-warning rowOfSingleAgain' href='javascript:void(0);'>同意排单</a>":(x.rowOfSingleAgain==null?'':x.rowOfSingleAgain)) + "</td>";// 重新排单--		
						$("tbody").append(
								"<tr>" + wave + productCode + craftsOrder
										+ oringinalWave + versionReferenceWave
										+ printingReferenceWave + designImg
										+ cuttingDate + cuttingNum + cuttingMan
										+ factory
										+ arrangeFabricAndAssistMaterial
										+ arrangeFabricAndAssistMaterialTime
										+ assistMaterialReady
										+ assistMaterialReadyTime + assistOut
										+ assistOutTime 
										+ rowOfSingleAgain
										+ "</tr>");
					});
	//辅料就绪
	assistMaterialReadyClick();
	//重新排单
	rowOfSingleAgainClick();
	//辅料发放
	assistOutClick();
}

// --------------------------------------------------------------------------------------------------------------
var mySelectForm;
// 查詢按鈕點擊事件
function select() {
	$("#myselect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()
						+ "/taisanAccesOutflow/getDataByPage.do?"
						+ mySelectForm, 1); // 指定url
				// -注释时间:2017年1月6日16:54:06
				// -注释原因:查询之后保留查询内容
				// $(".col-md-2>input").val("");
			});
}

function assistMaterialReadyClick(){
	$(".assistMaterialReady").click(function(){
		var wave=$(this).parent().parent().find("td:eq(0)").text().trim();
		$.ajax({
			url:$("#path").val()+ "/taisanAccesOutflow/assistMaterialReady.do",
			type:'post',
			dataType:'json',
			data:{
				wave:wave,
			},
			success:function(data){
				if(data==1){
					firstLoadData($("#path").val()
							+ "/taisanAccesOutflow/getDataByPage.do?"
							+ mySelectForm, $(".laypage_curr").text()); 
					layer.msg('辅料已就绪',{
						icon : 6,
						time : 2000,
					})
				}
			},
			erroe:function(){
				layer.msg('修改失败',{
					icon : 5,
					time : 2000,
				})
			}
		});
	});
}


function assistOutClick(){
	$(".assistOut").click(function(){
		var wave=$(this).parent().parent().find("td:eq(0)").text().trim();
		var assistMaterialReady=$(this).parent().parent().find("td:eq(13)").text().trim();
		
		if(assistMaterialReady!='辅料已就绪'){
			layer.msg('辅料未就绪',{
				icon : 5,
				time : 2000,
			})
			return;
		}
		$.ajax({
			url:$("#path").val()+ "/taisanAccesOutflow/assistOut.do",
			type:'post',
			dataType:'json',
			data:{
				wave:wave,
			},
			success:function(data){
				if(data==1){
					firstLoadData($("#path").val()
							+ "/taisanAccesOutflow/getDataByPage.do?"
							+ mySelectForm, $(".laypage_curr").text()); 
					layer.msg('辅料已发放',{
						icon : 6,
						time : 2000,
					})
				}
			},
			erroe:function(){
				layer.msg('修改失败',{
					icon : 5,
					time : 2000,
				})
			}
		});
	});
}



//重新排单
function rowOfSingleAgainClick(){
	$(".rowOfSingleAgain").click(function(){
		var wave=$(this).parent().parent().find("td:eq(0)").text().trim();
		
		$.ajax({
			url:$("#path").val()+ "/taisanAccesOutflow/rowOfSingleAgain.do",
			type:'post',
			dataType:'json',
			data:{
				wave:wave,
			},
			success:function(data){
				if(data==1){
					firstLoadData($("#path").val()
							+ "/taisanAccesOutflow/getDataByPage.do?"
							+ mySelectForm, $(".laypage_curr").text()); 
					layer.msg('等待重新排单',{
						icon : 6,
					})
				}
			},
		});
	});
}
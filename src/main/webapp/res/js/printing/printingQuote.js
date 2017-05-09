$(function() {
	// 进入页面进行查询
	loadPageDatas(1);
	
	// 模糊查询
	select();
})

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val() + "/printingQuote/getDataByPage.do", index); // 指定url
}
// 打印数据
function loadData(data) {
	$("tbody").empty();
	$.each(data, function(index, x) {
		var id = "<input type='hidden' class='id' value="+ x.id + ">"
		var wave = "<td>" + (x.wave == null ? '' : x.wave) + "</td>";// 波次
		var productCode = "<td>" + (x.productCode == null ? '' : x.productCode) + "</td>";// 商品编号
		var designer = "<td>" + (x.designer == null ? '' : x.designer) + "</td>";// 设计师
		var referencePrinting = "<td>" + (x.referencePrinting == null ? '' : x.referencePrinting) + "</td>";// 参考印花
		var designImg = "<td>"
			+ (x.designImg == null || x.designImg == "" ? ''
					: "<img src='"
							+ x.designImg
							+ "' width='90px' height='60px'/>");
		var sampleImg = "<td>" + (x.sampleImg == null ? '' : "<a href='"+x.sampleImg+"' target='_blank'>工艺单</a>") + "</td>";// 工艺单
		var patternCraftsOrder = "<td>" + (x.patternCraftsOrder == null ? '' : "<a href='"+x.patternCraftsOrder+"' target='_blank'>图样工艺单</a>") + "</td>";// 图样工艺单
		var orderDetails = "<td>" + (x.orderDetails == null ? '' : x.orderDetails) + "</td>";// 订单详情
		var orders = "<td>" + (x.orders == null ? '' : x.orders) + "</td>";// 订单数
		var printingType = "<td>" + (x.printingType == null ? '' : x.printingType) + "</td>";// 印花类型
		var printingAddress = "<td class='mydblClick' name='printingAddress'>" + (x.printingAddress == null ? '' : x.printingAddress) + "</td>";// 印花位置
		var printingRequire = "<td class='mydblClick' name='printingRequire'>" + (x.printingRequire == null ? '' : x.printingRequire) + "</td>";// 印花要求
		var printingFactory = "<td class='mydblClick' name='printingFactory'>" + (x.printingFactory == null ? '' : x.printingFactory) + "</td>";// 印花工厂
		var printingUnitPrice = "<td class='mydblClick' name='printingUnitPrice'>" + (x.printingUnitPrice == null ? '' : x.printingUnitPrice) + "</td>";// 印花单价
		var outSampleDate = "<td  class='mydblClick' name='outSampleDate' value='time'>" + (x.outSampleDate == null ? '' : x.outSampleDate) + "</td>";// 给样时间
		var inSampleDate = "<td class='mydblClick' name='inSampleDate' value='time'>" + (x.inSampleDate == null ? '' : x.inSampleDate) + "</td>";// 回样时间
		var confirmPiece = "<td>" + (x.confirmPiece == "已确认" ? x.confirmPiece:"<a class='btn btn-app btn-danger btn-sm confirmPiece'>确认报价</a>") + "</td>";// 确认报价
		var confirmPieceTime = "<td>" + (x.confirmPieceTime == null ? '' : x.confirmPieceTime) + "</td>";// 确认报价时间
		
		$("tbody").append("<tr>" + id// 编号
				+ wave// 波次
				+ productCode// 商品编号
				+ designer// 设计师
				+ referencePrinting// 参考印花
				+ designImg// 设计图
				+ sampleImg// 工艺单
				+ patternCraftsOrder// 图样工艺单
				+ orderDetails// 订单详情
				+ orders// 订单数
				+ printingType// 印花类型
				+ printingAddress// 印花位置
				+ printingRequire// 印花要求
				+ printingFactory// 印花工厂
				+ printingUnitPrice// 印花单价
				+ outSampleDate// 给样时间
				+ inSampleDate// 回样时间
				+ confirmPiece// 确认报价
				+ confirmPieceTime// 确认报价时间
				+ "</tr>");
	});
	//双击修改
	mydblclick();
	
	//确认报价
	confirmPiece();
}
//-----------------------------------------------点击查询-----------------------------------------------
var mySelectForm;
function select() {
	$("#mySelectBtn").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData("/printingQuote/getDataByPage.do?" + mySelectForm,1); // 指定url
			});
}
function confirmPiece(){
	$(".confirmPiece").click(function(){
		var id=$(this).parent().parent().find(".id").val();
		layer.confirm('是否确认报价?', {
			  btn: ['是','否'] //按钮
			}, function(){
				$.ajax({
					url : $("#path").val()
							+ '/printingQuote/confirmPiece.do',
					type : 'POST',
					dataType : 'json',
					data : {
						id:id
					},
					async : false,
					success : function(data) {
						if (data == 1) {
							firstLoadData("/printingQuote/getDataByPage.do?" 
									+ mySelectForm, $(".laypage_curr").text());
							layer.msg('已确认', {icon: 6});
						} else {
							alert("修改失败");
						}
					}
				});
			}, function(){
			  layer.msg('已取消', {icon: 5});
			});
	});
}
//-----------------------------------------------双击修改-----------------------------------------------
function mydblclick() {
	$(".mydblClick")
			.on(
					"dblclick",
					function() {
						var myid = $(this).parent().find(".id").val()
								.trim();
						var thisText = $(this).text().trim();
						var thisName = $(this).attr("name");
						var thisVal = $(this).attr("value");
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
					url : '/printingQuote/mydblClick.do',
					type : 'POST',
					dataType : 'json',
					data : myform,
					async : false,
					success : function(data) {
						if (data == 1) {
							firstLoadData($("#path").val()
									+ "/printingQuote/getDataByPage.do?"
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
		url : $("#path").val() + '/printingQuote/mydblClick.do',
		type : 'POST',
		dataType : 'json',
		data : myform,
		async : false,
		success : function(data) {
			if (data == 1) {
				firstLoadData($("#path").val()
						+ "/printingQuote/getDataByPage.do?" + mySelectForm,
						$(".laypage_curr").text());
			} else {
				alert("未修改");
			}
		}
	});
}
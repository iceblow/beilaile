$(function() {
	loadPageDatas(1);
	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val()
			+ "/distributionSetUp/distributionSetUpByLike.do", index); // 指定url
}

function loadData(data) {
	$("tbody").empty();
	$
			.each(
					data,
					function(index, x) {
						var oringinalWave = "<td>"
								+ (x.oringinalWave != null ? x.oringinalWave
										: "") + "</td>";// 原波次号
						var wave = "<td>" + (x.wave != null ? x.wave : "")
								+ "</td>";// 波次号
						var productImg = "<td>"
								+ (x.productImg == null || x.productImg == "" ? ''
										: "<img src='"
												+ x.productImg
												+ "' width='80px' height='80px'/>")
								+ "</td>";// 设计图
						var sampleImg = "<td>"
								+ (x.sampleImg == null || x.sampleImg == "" ? ''
										: "<a href='" + x.sampleImg
												+ "' target='_blank'>工艺单</a>")
								+ "</td>"// 工艺单
						var sizeImg = "<td>"
								+ (x.sizeImg == null || x.sizeImg == "" ? ''
										: "<a href='" + x.sizeImg
												+ "' target='_blank'>尺码表</a>")
								+ "</td>"// 尺码表
						var orderDetails = "<td>"
								+ (x.orderDetails != null ? x.orderDetails : "")
								+ "</td>";// 订单明细
						var orderNum = "<td>"
								+ (x.orderNum != null ? x.orderNum : "")
								+ "</td>";// 订单数
						var clothName = "<td>"
								+ (x.clothName != null ? x.clothName : "")
								+ "</td>";// 服装名
						var planInWarehouseTime = x.planInWarehouseTime == null ? "<td class='mydblClick' name='planInWarehouseTime'></td>"
								: "<td class='mydblClick' name='planInWarehouseTime'>"
										+ x.planInWarehouseTime + "</td>"; // 计划入库时间
						var orderGrade = "<td>"
								+ (x.orderGrade != null ? x.orderGrade : "")
								+ "</td>";// 订单等级
						var setUpDistribution = "<td align='center'>"
								+ (x.setUpDistribution == '经销单' ? x.setUpDistribution
										: "<button class='btn btn-info setUpDistribution' href='javascript:void(0);'>设置为经销单</button>")
								+ "</td>";// 设置经销单
						var releaseTime = "<td>"
								+ (x.releaseTime != null ? x.releaseTime : "")
								+ "</td>";// 下单(发版)日期
						var remark = "<td class='mydblClick' name='remark'>"
								+ (x.remark != null ? x.remark : "") + "</td>";// 备注
						var productCode = "<td>"
								+ (x.productCode != null ? x.productCode : "")
								+ "</td>";// 订单编号
						$("tbody")
								.append(
										"<tr>"
												+ productCode
												+ oringinalWave
												+ wave
												+ productImg
												+ sampleImg
												+ sizeImg
												+ orderDetails
												+ orderNum
												+ clothName
												+ planInWarehouseTime
												+ releaseTime
												+ remark
												+ orderGrade
												+ setUpDistribution
												+ "<input type='hidden' class='id' value='"
												+ x.id + "'/>");
					});
	// 修改
	updatedistributionSetUp();
	// 双击修改
	mydblclick();
}

// --------------------------------------------------------------------------------------------------------------
var mySelectForm;
// 查詢
function select() {
	$("#myselect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()
						+ "/distributionSetUp/distributionSetUpByLike.do?"
						+ mySelectForm, 1); // 指定url
			});
}
// 修改
function updatedistributionSetUp() {
	$(".setUpDistribution").bind(
			"click",
			function() {
				var setUpDistribution = '经销单';
				var id = $(this).parent().parent().find(".id").val();
				if (confirm('确认设置为经销单?')) {
					$.ajax({
						url : '/distributionSetUp/updatedistributionSetUp.do',
						dataType : 'json',
						type : 'post',
						data : {
							id : id,
							setUpDistribution : setUpDistribution
						},
						success : function(data) {
							firstLoadData(
									"/distributionSetUp/distributionSetUpByLike.do?"
											+ mySelectForm, $(".laypage_curr")
											.text());
						}
					});
				} else {
					return false;
				}
			});
}
// 设置文本框
function mydblclick() {
	$(".mydblClick")
			.on(
					"dblclick",
					function() {
						var myid = $(this).parent().find(".id").val();// 获取到id值
						var thisText = $(this).text().trim(); // 文本框中原有的值
						var thisName = $(this).attr("name"); // 获取文本框的属性名
						var thisVal = $(this).attr("value"); // 获取文本框属性值
						if (thisName == "problemSolving") {
							$(this).html(
									"<form id='dbUpdateForm'><input type='hidden' name='id' value="
											+ myid
											+ " /><input type='text' id='my"
											+ thisName + "' name='" + thisName
											+ "' value='" + thisText
											+ "'></form>");
							$(this).attr("class", "sn");
							twomyblur("my" + thisName);

						} else if (thisName != "estimatedDeliveryTime") {
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
						$("#my" + thisName).focus();
					});
}
// 提交对文本框中数据
function myblur(id) {
	$("#" + id).blur(
			function() {
				var myform = $("#dbUpdateForm").serialize();
				$.ajax({
					url : 'distributionSetUp/updateByText.do',// 指定路勁下的指定方法
					type : 'POST',
					dataType : 'json',
					data : myform,
					success : function(data) {
						if (data == 1) {
							firstLoadData(
									"/distributionSetUp/distributionSetUpByLike.do?"
											+ mySelectForm, $(".laypage_curr")
											.text()); // 指定url
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
		url : 'distributionSetUp/updateByText.do',
		type : 'POST',
		dataType : 'json',
		data : myform,
		async : false,
		success : function(data) {
			if (data == 1) {
				firstLoadData("/distributionSetUp/distributionSetUpByLike.do?"
						+ mySelectForm, $(".laypage_curr").text());
			} else {
				alert("未修改");
			}
		}
	});
}

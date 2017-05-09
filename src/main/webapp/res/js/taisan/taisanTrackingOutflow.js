$(function() {
	loadPageDatas(1);

	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val() + "/taisanTrackingOutflow/getDataByPage.do",
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
						//"+(x.factory==''||x.factory==null?"mydblClick":"")+"
						var factory = "<td class='"+(x.arrangeFabricAndAssistMaterial != '裁片辅料已安排'?"mydblClick":"")+"' name='factory'>"
								+ (x.factory != null ? x.factory : "")
								+ "</td>";// 车缝工厂--
						var arrangeFabricAndAssistMaterial = "<td>"
								+ (x.arrangeFabricAndAssistMaterial == '裁片辅料已安排' ? x.arrangeFabricAndAssistMaterial
										: "<a class='btn btn-app btn-warning arrangeFabricAndAssistMaterial' href='javascript:void(0);'>排单</a>")
								+ "</td>";// 安排裁片和辅料--
						var arrangeFabricAndAssistMaterialTime = "<td>"
								+ (x.arrangeFabricAndAssistMaterialTime != null ? x.arrangeFabricAndAssistMaterialTime
										: "") + "</td>";// 安排裁片和辅料时间
						var assistMaterialReady = "<td>"
								+ (x.assistMaterialReady != null ? x.assistMaterialReady
										: "") + "</td>";// 辅料就绪--
						var assistMaterialReadyTime = "<td>"
								+ (x.assistMaterialReadyTime != null ? x.assistMaterialReadyTime
										: "") + "</td>";// 辅料就绪时间
						var cuttingPieceReady = "<td>"
								+ (x.cuttingPieceReady != null ? x.cuttingPieceReady
										: "") + "</td>";// 裁片就绪--
						var cuttingPieceReadyTime = "<td>"
								+ (x.cuttingPieceReadyTime != null ? x.cuttingPieceReadyTime
										: "") + "</td>";// 裁片就绪时间
						var informFactoryTime = "<td>"
								+ (x.informFactoryTime != null ? x.informFactoryTime
										: "") + "</td>";//参考工厂 (通知工厂时间)--
						var assistOut = "<td>"
								+ (x.assistOut != null ? x.assistOut : "")
								+ "</td>";// 辅料外发--
						var assistOutTime = "<td>"
								+ (x.assistOutTime != null ? x.assistOutTime
										: "") + "</td>";// 辅料外发时间
						var cuttingPieceOut = "<td>"
								+ (x.cuttingPieceOut != null ? x.cuttingPieceOut
										: "") + "</td>";// 裁片外发--
						var cuttingPieceOutTime = "<td>"
								+ (x.cuttingPieceOutTime != null ? x.cuttingPieceOutTime
										: "") + "</td>";// 裁片外发时间
						var str;
						if(x.arrangeFabricAndAssistMaterial=="裁片辅料已安排"){
							str=x.rowOfSingleAgain==''||x.rowOfSingleAgain==null?"<button class='btn btn-danger rowOfSingleAgain'>申请重新排单</button>":x.rowOfSingleAgain;
						}else {
							str='';
						}
						var rowOfSingleAgain="<td>"+str+"</td>";
						$("tbody").append(
								"<tr>" + wave + productCode + craftsOrder
										+ oringinalWave + versionReferenceWave
										+ printingReferenceWave + designImg
										+ cuttingDate + cuttingNum + cuttingMan
										+ flowerType + cutLargeReceiveDate
										+ cutLargeReturnDate + flowerFactory
										+ informFactoryTime
										+ factory
										+ arrangeFabricAndAssistMaterial
										+ arrangeFabricAndAssistMaterialTime
										+ assistMaterialReady
										+ assistMaterialReadyTime
										+ cuttingPieceReady
										+ cuttingPieceReadyTime //+ informFactory
										+ assistOut
										+ assistOutTime + cuttingPieceOut
										+ cuttingPieceOutTime + rowOfSingleAgain + "</tr>");
					});
	// // 双击修改
	mydblclick();
	// 面辅料安排按钮点击事件
	arrangeFabricAndAssistMaterialClick();
	//通知工厂
	informFactory();
	//申请重新排单
	rowOfSingleAgain();
}

function arrangeFabricAndAssistMaterialClick() {
	$(".arrangeFabricAndAssistMaterial")
			.click(
					function() {
						var wave = $(this).parent().parent().find("td:eq(0)")
								.text().trim();
						layer
								.confirm(
										'您确认安排' + wave + '的面辅料',
										{
											area : '350px',
											btn : [ '安排', '取消' ]
										},
										function() {
											$
													.ajax({
														url : $("#path").val()
																+ '/taisanTrackingOutflow/getOneByWave.do',
														type : 'post',
														dataType : 'json',
														data : {
															wave : wave,
														},
														success : function(data) {
															// 1.判断是够符合安排的条件(没有片印
															// 裁剪完就行||有裁片印
															// 片印回料不能为空)
															if ((data.flowerType != "裁片")
																	|| (data.flowerType == "裁片"
																			&& data.cutLargeReturnDate != "" && data.cutLargeReturnDate != null)) {
																if(data.factory!=""&&data.factory!=null){
																	$.ajax({
																		url:$("#path").val()+'/taisanTrackingOutflow/arrangeFabricAndAssistMaterial.do',
																		type:'post',
																		dataType:'json',
																		data:{
																			wave:wave
																		},
																		success:function(data){
																			firstLoadData($("#path").val()+ "/taisanTrackingOutflow/getDataByPage.do?"
																							+ mySelectForm, $(".laypage_curr").text());
																			layer.msg('安排成功',{
																				icon:6,
																				time:2000
																			});
																		},error:function(){
																			layer.msg('安排错误,请联系管理员',{
																				icon:5,
																				time:2000
																			});
																		}
																	});
																}else{
																	layer.msg('请输入车缝工厂',{
																		icon:5,
																		time:2000
																	});
																}
																
															} else if (data.flowerType == "裁片"
																	&& (data.cutLargeReturnDate != "" || data.cutLargeReturnDate != null)) {
																layer.msg('片印尚未回料',{
																	icon:5,
																	time:2000
																});
															}
														},
														error : function() {
															layer.msg('数据错误,请通知管理员!', {
																icon : 5,
																time : 2000
															});
														}
													});
										}, function() {
											layer.msg('取消安排', {
												icon : 6,
												time : 2000, // 20s后自动关闭
											});
										});
					});
}

function informFactory(){
	
	$(".informFactory").click(function(){
		
		var wave=$(this).parent().parent().find("td:eq(0)").text().trim();
		
		var factory=$(this).parent().parent().find("td:eq(14)").text().trim();
		if(factory!=null&&factory!=""){
			layer
			.confirm(
					"您确认通知<font color='red'>" + factory + "</font>领取<font color='red'>"+wave+"</font>波的面辅料?",
					{
						area : '350px',
						btn : [ '确认', '取消' ]
					},
					function() {
						$.ajax({
									url : $("#path").val()
											+ '/taisanTrackingOutflow/getOneByWave.do',
									type : 'post',
									dataType : 'json',
									data : {
										wave : wave,
									},
									success : function(data) {
										if(data.cuttingPieceReady=='裁片已就绪'&&data.assistMaterialReady=='辅料已就绪'){
											$.ajax({
												url : $("#path").val()
														+ '/taisanTrackingOutflow/informFactory.do',
												type : 'post',
												dataType : 'json',
												data : {
													wave : wave,
												},
												success:function(mydata){
													if(mydata==1){
														firstLoadData($("#path").val()+ "/taisanTrackingOutflow/getDataByPage.do?"
																+ mySelectForm, $(".laypage_curr").text());
														layer.msg('通知工厂成功', {
															icon : 6,
															time : 2000
														});
													}
												},
												error:function(){
													layer.msg('系统故障,请通知管理员', {
														icon : 5,
														time : 2000
													});
												}
											})
										}else{
											layer.msg('辅料或裁片未就绪', {
												icon : 5,
												time : 2000
											});
										}
									},
									error : function() {
										layer.msg('数据错误,请通知管理员!', {
											icon : 5,
											time : 2000
										});
									}
								});
					}, function() {
						layer.msg('取消安排', {
							icon : 6,
							time : 2000, // 20s后自动关闭
						});
					});
		}else {
			layer.msg('请填写车缝工厂', {
				icon : 5,
				time : 2000, // 20s后自动关闭
			});
		}
	});
	
}

//--------------------------------------------------------------------------------------------------------------
var mySelectForm;
// 查詢按鈕點擊事件
function select() {
	$("#myselect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()
						+ "/taisanTrackingOutflow/getDataByPage.do?"
						+ mySelectForm, 1); // 指定url
				// -注释时间:2017年1月6日16:54:06
				// -注释原因:查询之后保留查询内容
				// $(".col-md-2>input").val("");
			});
}

// ----------------------------------------------------双击修改----------------------------------------------------
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
											+ '/taisanTrackingOutflow/updateFactory.do',
									type : 'POST',
									dataType : 'json',
									data : myform,
									async : false,
									success : function(data) {
										if (data == 1) {
											firstLoadData(
													$("#path").val()
															+ "/taisanTrackingOutflow/getDataByPage.do?"
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
		url : $("#path").val() + '/taisanTrackingOutflow/updateFactory.do',
		type : 'POST',
		dataType : 'json',
		data : myform,
		async : false,
		success : function(data) {
			if (data == 1) {
				firstLoadData($("#path").val()
						+ "/taisanTrackingOutflow/getDataByPage.do?"
						+ mySelectForm, $(".laypage_curr").text());
			} else {
				alert("未修改");
			}
		}
	});
}

function rowOfSingleAgain(){
	$(".rowOfSingleAgain").click(function(){
		var wave=$(this).parent().parent().find("td:eq(0)").text().trim();
		layer.confirm("确认申请<font color='red'>"+wave+"</font>重新排单",function(){
			$.ajax({
				url:'taisanTrackingOutflow/updateRowOfSingleAgain.do',
				type:'post',
				dataType:'json',
				data:{
					wave:wave
				},
				success:function(mydata){
					firstLoadData($("#path").val()
							+ "/taisanTrackingOutflow/getDataByPage.do?"
							+ mySelectForm, $(".laypage_curr").text());
					layer.msg('已确认');
				}
			});
		},function(){
			layer.msg('取消重新排单');
		});
	});
}
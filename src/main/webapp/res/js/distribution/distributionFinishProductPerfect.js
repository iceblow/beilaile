/**
 *返单样衣管理 
 */
$(function(){
	//分页查询
	$("#exportCurrentDistributionFinishData").on('click', function() {
	
		var anyVal = $("#mySelect_From").serialize();
		$("#mySelect_From").submit();
		
	})
	loadPageDatas(1);
	select();
})
//调用分页查询方法
function loadPageDatas(index){
	firstLoadData("/distributionFinishProductPerfect/getDataByPage.do",index);
}
//打印数据
function loadData(mydata){
	$("tbody").empty();
	$.each(mydata,function(index,x){
		var id="<input type='hidden' class='id' value='"+x.id+"'/>";// 序号
		var productCode="<td>"+(x.productCode==null?"":x.productCode)+"</td>";//商品编号
	    var clothName="<td>"+(x.clothName==null?"":x.clothName)+"</td>";//服装名
	    var oringinalWave="<td>"+(x.oringinalWave==null?"":x.oringinalWave)+"</td>";//原波次
	    var wave="<td>"+(x.wave==null?"":x.wave)+"</td>";//波次号
	    var productImg="<td>"+(x.productImg==null||x.productImg==""?"":"<img src='"+x.productImg+"' width='100px' height='80px'/>")+"</td>";//产品图
	    var sampleImg="<td>"+(x.sampleImg==null||x.sampleImg==""?"":"<a href='"+x.sampleImg+"' target='_blank'>工艺单</a>")+"</td>";//工艺单
	    var sizeImg="<td>"+(x.sizeImg==null||x.sizeImg==""?"":"<a href='"+x.sizeImg+"' target='_blank'>工艺单</a>")+"</td>";//尺码图
	    var orderDetails="<td>"+(x.orderDetails==null?"":x.orderDetails)+"</td>";//订单明细
	    var orderNum="<td>"+(x.orderNum==null?"":x.orderNum)+"</td>";//订单数量
	    var orderGrade="<td>"+(x.orderGrade==null?"":x.orderGrade)+"</td>";//订单数量
	    var orderType="<td>"+(x.orderType==null?"":x.orderType)+"</td>";//订单类型
	    var distributtionFactory="<td>"+(x.distributtionFactory==null?"":x.distributtionFactory)+"</td>";//经销工厂
	    var planInWarehouseTime="<td>"+(x.planInWarehouseTime==null?"":x.planInWarehouseTime)+"</td>";//计划入库时间
	    var trackingOfficer="<td style='text-align:center;' class='mydblClick' name='trackingOfficer'>"+(x.trackingOfficer == null ? '' : x.trackingOfficer)+"</td>";
	    var remark="<td style='text-align:center;' class='mydblClick' name='remark'>"+(x.remark == null ? '' : x.remark)+"</td>";
	    var orderId='<td style="text-align:center;">'+(x.orderId == null ? '' : x.orderId)+'</td>';
	    var releaseTime='<td style="text-align:center;">'+(x.releaseTime == null ? '' : x.releaseTime)+'</td>';
	    var tacheStartTime='<td style="text-align:center;">'+(x.tacheStartTime == null ? '' : x.tacheStartTime)+'</td>';
	    var factoryReportDeliver="<td class='mydblClick' name='factoryReportDeliver' value='time'>"+(x.factoryReportDeliver==null?"":x.factoryReportDeliver)+"</td>";//工厂报告出货日期
	    var startDeliver="<td style='text-align: center;'>"+(x.startDeliver==null?"<button class='btn btn-app btn-grey btn-xs radius-4 startDeliver'><i class='icon-save bigger-160'></i>开始出货<span class='badge badge-transparent'><i class='light-red icon-asterisk'></i></span></button>":x.startDeliver)+"</td>";//开始出货
	    var startDeliverTime="<td>"+(x.startDeliverTime==null?"":x.startDeliverTime)+"</td>";//开始出货日期
		
		$("tbody").append("<tr>"
				+id//序号
			    +productCode//商品编号
			    +clothName//服装名
			    +oringinalWave//原波次
			    +wave//波次号
			    +productImg//产品图
			    +sampleImg//工艺单
			    +sizeImg//尺码图
			    +orderDetails//订单明细
			    +orderNum//订单数量
			    +orderGrade//订单数量
			    +orderType//订单类型
			    +distributtionFactory//经销工厂
			    +planInWarehouseTime//计划入库时间
			    +trackingOfficer//跟踪员
			    +remark//备注
			    +orderId//下单号
			    +releaseTime//下单(发版)时间
			    +tacheStartTime//环节开始时间
			    +factoryReportDeliver//工厂报告出货日期
			    +startDeliver//开始出货
			    +startDeliverTime//开始出货日期
				+"</tr>");
	});
	//开始出货事件
	startDeliver();
	//双击修改
	mydblclick();
}

function startDeliver(){
	$(".startDeliver").click(function(){
		var id=$(this).parent().parent().find(".id").val();
		var wave=$(this).parent().parent().find("td:eq(3)").text();
		var startDeliver="开始出货";
		layer.confirm("确认<font color='red'>"+wave+"</font>开始出货?",function(){
			$.ajax({
				url:'/distributionFinishProductPerfect/dblUpdate.do',
				type:'post',
				dataType:'json',
				data:{
					id:id,
					startDeliver:startDeliver,
				},
				success:function(){
					firstLoadData("/distributionFinishProductPerfect/getDataByPage.do?"+ mySelectForm, $(".laypage_curr").text());// 指定url
					layer.msg('已确认');
				}
			});
		},function(){
			layer.msg('取消确认');
		});
	});
}
//定义查询条件
var mySelectForm;
/**
 * 查詢按鈕點擊事件
 */
function select() {
	$("#mySelect").click(
			function() {
		
				mySelectForm = $("#mySelect_From").serialize();
				
				firstLoadData("/distributionFinishProductPerfect/getDataByPage.do?"+ mySelectForm, 1); // 指定url
			});
}

function mydblclick() {
	$(".mydblClick")
			.on(
					"dblclick",
					function() {
						var myid = $(this).parent().find(".id").val().trim();
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
					url : $("#path").val()
							+ '/distributionFinishProductPerfect/dblUpdate.do',
					type : 'POST',
					dataType : 'json',
					data : myform,
					async : false,
					success : function(data) {
						if (data == 1) {
							firstLoadData($("#path").val()
									+ "/distributionFinishProductPerfect/getDataByPage.do?"
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
		url : '/distributionFinishProductPerfect/dblUpdate.do',
		type : 'POST',
		dataType : 'json',
		data : myform,
		async : false,
		success : function(data) {
			if (data == 1) {
				firstLoadData($("#path").val()
						+ "/distributionFinishProductPerfect/getDataByPage.do?" + mySelectForm,
						$(".laypage_curr").text());
			} else {
				alert("未修改");
			}
		}
	});
}


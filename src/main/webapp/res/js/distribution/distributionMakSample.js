$(function() {
	loadPageDatas(1);
	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val()
			+ "/distributionMakSample/distributionMakSampleByLike.do", index); // 指定url
}

function loadData(data) {
	$("tbody").empty();
	$.each(data,function(index, x) {
		var oringinalWave = "<td>" + (x.oringinalWave != null ? x.oringinalWave : "")+ "</td>";// 原波次号						
		var wave = "<td>" + (x.wave != null ? x.wave : "")+ "</td>";// 波次号
		var productCode = "<td>" + (x.productCode != null ? x.productCode : "")+ "</td>";// 波次号
		var productImg = "<td>"+ (x.productImg == null || x.productImg == "" ? '': "<img src='"+ x.productImg+ "' width='80px' height='80px'/>")+ "</td>";//设计图
		var sampleImg = "<td>"+ (x.sampleImg == null || x.sampleImg == "" ? '': "<a href='" + x.sampleImg + "' target='_blank'>工艺单</a>")+ "</td>"//工艺单
		var sizeImg = "<td>"+ (x.sizeImg == null || x.sizeImg == "" ? '': "<a href='" + x.sizeImg + "' target='_blank'>尺码表</a>")+ "</td>"//尺码表				
		var orderDetails = "<td>"+ (x.orderDetails != null ? x.orderDetails : "")+ "</td>";// 订单明细
		var orderNum = "<td>"+ (x.orderNum != null ? x.orderNum : "")+ "</td>";//订单数
		var clothName = "<td>"+ (x.clothName != null ? x.clothName : "")+ "</td>";// 服装名
		var orderType = "<td>"+ (x.orderType != null ? x.orderType : "")+ "</td>";// 订单类型
		var orderGrade = "<td>"+ (x.orderGrade != null ? x.orderGrade : "")+ "</td>";// 订单类型
		var planInWarehouseTime="<td>"+(x.planInWarehouseTime ==null ? '' :x.planInWarehouseTime )+"</td>" //计划入库时间
		//orderType的默认值是什么.它一定会有值吗
		if(x.orderType =='半经销'){
			var distributtionFactory =x.distributtionFactory == null ? "<td ></td>":"<td >" +  x.distributtionFactory + "</td>"; // 经销工厂
		} else {
			var distributtionFactory =x.distributtionFactory == null ? 
				"<td class='mydblClick' name='distributtionFactory'></td>"
				:"<td class='mydblClick' name='distributtionFactory'>" 
				+  x.distributtionFactory + "</td>"; // 经销工厂
		}
		var trackingOfficer="<td class='mydblClick' name='trackingOfficer'>" + (x.trackingOfficer != null ? x.trackingOfficer : "")+ "</td>";// 跟单人
		var releaseTime="<td>"+(x.releaseTime !=null ? x.releaseTime : "") +"</td>" //下单时间
		var remark="<td class='mydblClick' name='remark'>"+(x.remark== null ? '' : x.remark)+"</td>"
		var orderId ="<td >"+(x.orderId== null ? '' : x.orderId)+"</td>" //订单号
		var tacheStartTime="<td>"+( x.tacheStartTime!=null ? x.tacheStartTime : "" )+"</td>" //环节开始时间
		var modelSendTime = "<td>" + (x.modelSendTime != null ? x.modelSendTime : "")+ "</td>"; //字样发送时间
		//var addProofingFactory="<td>"+ (x.addProofingFactory!=null ? x.addProofingFactory : "" )+"</td>" //添加打样工厂
		var modelState="<td>"+ (x.modelState!=null ? x.modelState : "")+"</td>"		//纸样状态
		var mydate = new Date();
		var month = mydate.getMonth() + 1;
		var strDate = mydate.getDate();
			if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }
		var currentdate = mydate.getFullYear() + "-" + month + "-" + strDate;
		var makeRemainTime="<td>" + getDiscrepantDays(currentdate, x.planInWarehouseTime) + "</td>";;//报价剩余天数
		var makeConsumeTime="<td>" + getDiscrepantDays(currentdate, x.tacheStartTime) + "</td>";;//报价剩余天数
		var toMakeTheSample = "<td align='center'>"
			+ (x.toMakeTheSample != null ? x.toMakeTheSample: "<button class='btn btn-info updatedtoMakeTheSample' href='javascript:void(0);'>开始打样</button>")+ "</td>";//	确定衣服打样时间
		var toMakeTheSampleComplete = "<td class='orderType"+x.id+"' align='center'>"
			+ (x.toMakeTheSampleComplete != null ? x.toMakeTheSampleComplete
			: "<button class='btn btn-info updatedistributionMakSample' href='javascript:void(0);'>打样完成</button>")+ "</td>";// 衣服打样完成时间
		var addProofingFactory ="<td ><button  onclick='addFactory class='class='btn btn-info addFactory'>添加打样工厂</button></td> " ;
		$("tbody").append(							
			"<tr>" 	+  oringinalWave 
					+ wave 
					+ productImg 
					+ sampleImg 
					+ sizeImg 
					+ orderDetails
					+ orderNum
					+ clothName 
					+ productCode
					+ orderType
					+ orderGrade
					+ releaseTime
					+ planInWarehouseTime
					+ modelSendTime
					+ trackingOfficer
					+ remark
					+ orderId
					+ modelState
					+ tacheStartTime
					+ makeRemainTime
					+ makeConsumeTime
					+ distributtionFactory
					+ toMakeTheSample
					+ toMakeTheSampleComplete
					+ addProofingFactory
					+"<input type='hidden' class='id' value='" + x.id + "'/>");
			var orderType =x.orderType; 
			if (orderType =='半经销' ) {
				$(".orderType" +x.id).find('button').remove();
				$(".orderType" + x.id).append("<td>半经销无确认</td>");
			} 
						
		});
	// 修改
	updatedistributionMakSample();
	//双击修改
	mydblclick();
	addProofingFactory();
}

//添加打样工厂
function addProofingFactory(){
	$(".addFactory").click(function(){
		var id=$(this).parent().parent().find(".id").val();
		if (confirm('确定要打印经销工厂吗?')) {
		$.ajax({
			url : '/distributionMakSample/addProofingFactory.do',
			dataType : 'json',
			type : 'post',
			data : {id: id},
			success : function (data){
				if(data==1){
					firstLoadData("/distributionMakSample/distributionMakSampleByLike.do?"+ mySelectForm, $(".laypage_curr").text());
				}else{
					alert("添加打样工厂失败");
				}
			}
		});
		}else{
			return false;
		}
	});
}



// --------------------------------------------------------------------------------------------------------------
var mySelectForm;
// 查詢
function select() {
	$("#myselect").click(function() {
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData($("#path").val()
			+ "/distributionMakSample/distributionMakSampleByLike.do?"
			+ mySelectForm, 1); // 指定url
	});
}
// 修改
function updatedistributionMakSample() {
	$(".updatedistributionMakSample").bind("click",function() {
		var id = $(this).parent().parent().find(".id").val();
		var distributtionFactory=$(this).parent().parent().find("td:eq(10)").text().trim();
		alert("---distributtionFactory---"+distributtionFactory);
		var now = new Date();
		var state ='1';
		var date= now.getFullYear()+"-"+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
			if(distributtionFactory=='确认打样时间'){
				alert("未确定打样时间");
				return;
			}
			if (confirm('确认打样完成?')) {
				$.ajax({
					url : '/distributionMakSample/updatedistributionMakSample.do',
					dataType : 'json',
					type : 'post',
					data : {id : id,toMakeTheSampleComplete : date,state : state},
					success : function(data) {
						firstLoadData("/distributionMakSample/distributionMakSampleByLike.do?"+ mySelectForm, $(".laypage_curr").text());
					}
				});
			} 
		});
	
	$(".updatedtoMakeTheSample").bind(
			"click",
			function() {
				var id = $(this).parent().parent().find(".id").val();
				var distributtionFactory=$(this).parent().parent().find("td:eq(20)").text().trim();
				var now = new Date();
			    var date= now.getFullYear()+"-"+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
			    if(distributtionFactory==''){
			    	alert("未确定经销工厂");
					return;
			    }
			    if (confirm('确认打样时间?')) {
					$.ajax({
						url : '/distributionMakSample/updatedistributionMakSample.do',
						dataType : 'json',
						type : 'post',
						data : {id : id,toMakeTheSample : date},
						success : function(data) {
							firstLoadData(
									"/distributionMakSample/distributionMakSampleByLike.do?"+ mySelectForm, $(".laypage_curr").text());
						}
					});
				} else {
					return false;
				}
			});
}
//设置文本框
function mydblclick(){
	 $(".mydblClick").on("dblclick",function() {
		var myid= $(this).parent().find(".id").val();//获取到id值			
		var thisText = $(this).text().trim();    //文本框中原有的值
		var thisName = $(this).attr("name");    //获取文本框的属性名
		var thisVal = $(this).attr("value");   //获取文本框属性值
		$(this).html(
				"<form id='dbUpdateForm'><input type='hidden' name='id' value="+
					myid+" /><input type='text' id='my"+thisName +"' name='" + thisName+ "' value='" + thisText+ "'></form>");
		$(this).attr("class", "sn");
		myblur("my" + thisName);
		$("#my"+ thisName).focus();
	}); 
} 

//提交对文本框中数据
 function myblur(id){
	 $("#" + id).blur(function() {
		 var myform = $("#dbUpdateForm").serialize();
		 	$.ajax({
			url:'distributionMakSample/updateByText.do',
			dataType:'json',
			type:'post',
			data:myform,
			success : function(data){
				if(data==1){
					firstLoadData("/distributionMakSample/distributionMakSampleByLike.do?"+mySelectForm,$(".laypage_curr").text()); // 指定url
				}else{
					alert("修改失败");
				}
			}
		  });
	});
 }

 //问题解决并添加解决时间
 function twomyblur(id){
	 $("#" + id).blur(function() {
			var myform = $("#dbUpdateForm").serialize();
			var obj=$("#myproblemSolving");
			if(obj.val()=="" || obj.val()==null){
				firstLoadData("/distributionMakSample/distributionMakSampleByLike.do?"+mySelectForm,$(".laypage_curr").text()); // 指定url
			}else{
				$.ajax({
				url : '/distributionMakSample/updateAndTime.do',      
				type : 'POST',
				dataType : 'json',
				data : myform,
				success : function(data){
					if(data==1){
						firstLoadData("/distributionMakSample/distributionMakSampleByLike.do?"+mySelectForm,$(".laypage_curr").text()); // 指定url
					}else{
						 ("修改失败");
					}
				}
			}); 
		}
				 
	 });
 }
 

	
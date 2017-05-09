//页面加载就执行
$(function () {
	loadPageDatas(1);
 	selectButton();
 	exportExcelButton();
});

//模糊查询
var mySelectForm;
function selectButton() {
	$("#myselect").click(function() {
		mySelectForm= $("#form-anyVal").serialize();
		firstLoadData("DistributionProduction/getDistributionProductionPage.do?"+mySelectForm,1);
	});
}

//进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData("DistributionProduction/getDistributionProductionPage.do", index);
}
//查询完成,打印数据
function loadData(mydata) {
	$("#tbody").empty();
	$.each (mydata, function(index, x) {
		var id = "<td>" + x.id + "</td>";
		var productCode =x.productCode == null ? "<td></td>" : "<td>" + x.productCode + "</td>";	//商品编码
		var orderId =x.orderId == null ? "<td></td>" : "<td>" + x.orderId + "</td>";	//订单号
		var oringinalWave =x.oringinalWave == null ? "<td></td>" : "<td>" + x.oringinalWave + "</td>";	//原波次
		var wave =x.wave == null ? "<td></td>" : "<td>" + x.wave + "</td>";	//波次
		var clothName =x.orderDetails == null ? "<td></td>" : "<td>" + x.clothName + "</td>";	//商品名
		var productImg= "<td><img style='width: 50px; height: 50px' src='" + x.productImg + "'></td>";  //设计图
		var sampleImg= x.sampleImg == null ? "<td></td>" : "<td><a href='" + x.sampleImg + "' target='_blank'>工艺单</a></td>";//工艺单
		var sizeImg= x.sizeImg == null ? "<td></td>" : "<td><a href='" + x.sizeImg + "' target='_blank '>尺码图</a></td>";   //尺码图
		var orderDetails =x.orderDetails == null ? "<td></td>" : "<td>" + x.orderDetails + "</td>";	//ding
		var orderNum =x.orderNum == null ? "<td></td>" : "<td>" + x.orderNum + "</td>";	//订单数
		var orderGrade =x.orderGrade == null ? "<td></td>" : "<td>" + x.orderGrade + "</td>";	//商品编码
		var orderType =x.orderType == null ? "<td></td>" : "<td>" + x.orderType + "</td>";	//类型
		var distributtionFactory =x.distributtionFactory == null ? "<td></td>" : "<td>" + x.distributtionFactory + "</td>";	//经销工厂
		
		var s52 ="<td class='mydblClick' name='s52'>"+(x.s52==null ? '' : (x.s52==0 ? '': x.s52))+"</td>" ;	//备组
		var s59 ="<td class='mydblClick' name='s59'>"+(x.s59==null ? '' : (x.s59==0 ? '': x.s59))+"</td>" ;	//备组
		var s66 ="<td class='mydblClick' name='s66'>"+(x.s66==null ? '' : (x.s66==0 ? '': x.s66))+"</td>" ;	//备组
		var s73 ="<td class='mydblClick' name='s73'>"+(x.s73==null ? '' : (x.s73==0 ? '': x.s73))+"</td>" ;	//备组
		var s80 ="<td class='mydblClick' name='s80'>"+(x.s80==null ? '' : (x.s80==0 ? '': x.s80))+"</td>" ;	//备组
		var s90 ="<td class='mydblClick' name='s90'>"+(x.s90==null ? '' : (x.s90==0 ? '': x.s90))+"</td>" ;	//备组
		var s100 ="<td class='mydblClick' name='s100'>"+(x.s100==null ? '' : (x.s100==0 ? '': x.s100))+"</td>" ;	//备组
		var s110 ="<td class='mydblClick' name='s110'>"+(x.s110==null ? '' : (x.s110==0 ? '': x.s110))+"</td>" ;	//备组
		var s120 ="<td class='mydblClick' name='s120'>"+(x.s120==null ? '' : (x.s120==0 ? '': x.s120))+"</td>" ;	//备组
		var s130 ="<td class='mydblClick' name='s130'>"+(x.s130==null ? '' : (x.s130==0 ? '': x.s130))+"</td>" ;	//备组
		var s160 ="<td class='mydblClick' name='s160'>"+(x.s160==null ? '' : (x.s160==0 ? '': x.s160))+"</td>" ;	//备组
		var s170 ="<td class='mydblClick' name='s170'>"+(x.s170==null ? '' : (x.s170==0 ? '': x.s170))+"</td>" ;	//备组
		
		var planInWarehouseTime =x.planInWarehouseTime == null ? "<td></td>" : "<td>" + x.planInWarehouseTime + "</td>";		//计划入库时间
		var releaseTime ="<td>"+(x.releaseTime==null ? '' : x.releaseTime)+"</td>";	//环节开始时间
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
		var planStartMakeTime="<td>" + getDiscrepantDays(currentdate, x.planInWarehouseTime) + "</td>";;//报价剩余天数
		var tacheStartTimeLess="<td>" + getDiscrepantDays(currentdate, x.tacheStartTime) + "</td>";;//报价剩余天数
		
		var remark ="<td class='mydblClick' name='remark'>"+(x.remark==null ? '' : x.remark)+"</td>" ;	//备组
		var trackingOfficer ="<td class='mydblClick' name='trackingOfficer'>"+(x.trackingOfficer==null ? '' : x.trackingOfficer)+"</td>" ;	//跟单人
		var tacheStartTime ="<td >"+(x.tacheStartTime==null ? '' : x.tacheStartTime)+"</td>" ;	//环节开始时间
		$("tbody").append(
				"<tr>"
					+ id
					+ productCode
					+ orderId
					+ oringinalWave
					+ wave
					+ clothName
					+ productImg
					+ sampleImg
					+ sizeImg
					+ orderDetails
					+ orderNum
					+ orderGrade
					+ orderType
					+ distributtionFactory
					+ s52
					+ s59
					+ s66
					+ s73
					+ s80
					+ s90
					+ s100
					+ s110
					+ s120
					+ s130
					+ s160
					+ s170
					+ trackingOfficer
					+ remark
					+ orderId
					+ planInWarehouseTime
					+ tacheStartTime
					+ planStartMakeTime
					+ tacheStartTimeLess
					+ releaseTime
					+ "<td class='startMake"+x.id+"'><button class='btn btn-app btn-purple btn-sm deleteById'>确认上线</button></td> "
					+ "</tr>");
			var startMake =x.startMake;
			if ( x.startMake =='1') {
				$(".startMake" +x.id).parent().attr("bgcolor", "#00ffff");
				$(".startMake" +x.id).find('button').remove();
				$(".startMake" +x.id).append("<button class='btn icon-ok btn-inverse' disabled='disabled'>确定上线</button>");
			} 
	}); 
	topThread();
	mydblclick();
}

	//导出Excel表
function exportExcelButton(){
//	$("#exportExcel").click(function(){
//		mySelectForm= $("#form-anyVal").serialize();
//		window.open('/DistributionProduction/downDistributionProduction.do?'+mySelectForm);
//	});
}

//设置文本框
function mydblclick(){
	 $(".mydblClick").on("dblclick",function() {
		var myid= $(this).parent().find("td:eq(0)").text().trim();//获取到id值	
		var thisText = $(this).text().trim();    	//文本框中原有的值
		var thisName = $(this).attr("name");    	//获取文本框的属性名
		var thisVal = $(this).attr("value");   		//获取文本框属性值
		if(thisName == "remark" || thisName == "trackingOfficer"){
			$(this).html(
				"<form id='dbUpdateForm'><input type='hidden' name='id' value="+
					myid+" /><input type='text' id='my"+thisName +"' name='" + thisName+ "' value='" + thisText+ "'></form>");
			$(this).attr("class", "sn");
			myblur("my" + thisName);
			$("#my"+ thisName).focus();
		}else{
			$(this).html("<input type='text' id='"+myid +"' name='" + thisName+ "' value='" + thisText+ "'/>");
			myUpdateS(myid,name);
			$("#"+myid).focus();
		}
		}); 
} 
		//提交对文本框中数据
function myblur(id){
	$("#" + id).blur(function() {
	var myform = $("#dbUpdateForm").serialize();
	$.ajax({
		url : 'DistributionProduction/updateform.do',//指定路勁下的指定方法
		type : 'POST',
		dataType : 'json',
		data : myform ,
		success : function(data){
			if(data==1){
				firstLoadData("DistributionProduction/getDistributionProductionPage.do?"+mySelectForm,1);
			}else{
				alert("修改失败");
			}
		}
	});
	});
}

//提交对文本框中数据
function myUpdateS(id,name){
	$("#" + id).blur(function() {
		var newval=$(this).val();
		var name=$(this).attr("name");
		if(newval==null || newval==""){
			newval=0;
		}
		var data={id:id};
		data[name]=newval;
	$.ajax({
		url : 'DistributionProduction/updateform.do',//指定路勁下的指定方法
		type : 'POST',
		dataType : 'json',
		data : data ,
		success : function(data){
			if(data==1){
				firstLoadData("DistributionProduction/getDistributionProductionPage.do?"+mySelectForm,1);
			}else{
				alert("修改失败");
			}
		}
	});
	});
}



//上线
function topThread(){
	$(".deleteById").on("click",function(){	
	var id= $(this).parent().parent().find("td:eq(0)").text().trim();     //获取id
	var startMake='1';
	if(confirm("确定上线？")){
		$.ajax({
			url:'DistributionProduction/updateform.do',
			type:'post',
			data:{'id':id,'startMake':startMake},
			dataType:'json',
			success:function(data){
				if(data == 1){
					//添加成功,重新刷新页面加载数据
					firstLoadData("DistributionProduction/getDistributionProductionPage.do?"+mySelectForm,1);
				}else{
					alert("确认上线失败");
				}
			}
		});
	}
	});
}




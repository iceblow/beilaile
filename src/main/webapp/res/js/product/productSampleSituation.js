
$(function() {
	// 分页
	loadPageDatas(1);
	//查询
	search();
});

// 模糊查询
function search(){
	$("#checkbtn").click(		
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()
						+ "productSampleSituation/selectProductSampleSituationByLike.do?"
						+ mySelectForm, 1); // 指定url
			});
}


// 分页
function loadPageDatas(index) {
	firstLoadData($("#path").val() + "/productSampleSituation/selectProductSampleSituationByLike.do", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	Inputstorage(mydata);
}
function Inputstorage(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, s) {
		if(s.sampleTime!=null||s.delStatus!=null){
			var delStatus= s.delStatus == null ? "" : "已不能修改";   
		}else{
			var delStatus="<button  class='btn  delReturnRepairDoucuments' href='javascript:void(0);'>删除</button></td>";
		}
		if(s.sampleTime!=null||s.delStatus!=null){
			var remarks =s.remarks == null ? "<td></td>" : "<td>" + s.remarks + "</td>";	//备注
		}else{
			var remarks =s.remarks == null ? "<td class='mydblClick' name='remarks'></td>" : "<td class='mydblClick' name='remarks'>" + s.remarks + "</td>";
		}
		if(s.sampleTime!=null||s.delStatus!=null){
			var setUpin = s.sampleTime == null ? "" : "已发放";
		}else{
			var setUpin ="<button class='btn btn-info setUpin' href='javascript:void(0);'>确认发放</button>";
		}
			$("tbody").append("<tr "+(s.dataStatus!=null?"style='background:aquamarine;'":'')+">" 
					+ "<input type='hidden' class='id' value='"
					+ s.id + "'/>"
					+ "<input type='hidden' class='wave' value='"
					+ s.wave + "'/>"
					+ "<input type='hidden' class='productName' value='"
					+ s.productName + "'/>"
					+ "<td style='text-align: center;'>"
					+ (s.sid == null ? '' : s.sid)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.wave == null ? '' : s.wave)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.productCode == null ? '' : s.productCode)
					+ "</td>"
					+"<td style='text-align: center;'>"
					+ (s.designImg == null || s.designImg == "" ? '': "<img src='"
					+ s.designImg
					+ "' width='80px' height='80px'/>")
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.orderGrade == null ? '' : s.orderGrade)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.dataStatus == null ? '' : s.dataStatus)
					+ "</td>"
					+ remarks				
					+ "<td style='text-align: center;'>"
					+ (s.sampleTime == null ? '' : s.sampleTime)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.createTime == null ? '' : s.createTime)
					+ "</td>"
				    +"<td>"
					+ setUpin
//					+ "</td><td>"
//					+ delStatus
					+"</td>"
					+ "</tr>");
			});
	// 删除
	del();
	//确认入库
	toadd();
	//双击修改
	mydblclick();
}


//确认入库
function toadd() {
	$(".setUpin").bind("click", function() {
		var dataStatus = '已发放';
		var wave =  $(this).parent().parent().find(".wave").val();
		var id = $(this).parent().parent().find(".id").val();
		var now = new Date();
	    var sampleTime= now.getFullYear()+"-"+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate()+"&nbsp"+(now.getHours()<10?"0":"")+now.getHours()+":"+(now.getMinutes()<10?"0":"")+now.getMinutes()+":"+(now.getSeconds()<10?"0":"")+now.getSeconds();
		if (confirm('确定发放?')) {
			$.ajax({
				url : '/productSampleSituation/updateProductSampleSituation.do',
				dataType : 'json',
				type : 'post',
				data : {
					id : id,
					dataStatus : dataStatus,
					sampleTime :sampleTime
				},
				success : function(data) {
					firstLoadData("productSampleSituation/selectProductSampleSituationByLike.do",$(".laypage_curr").text());
				},error:function(){
					alert("发放失败!");
				}
			});
			
			$.ajax({
				url : '/productOnlineProgress/updateProductOnline.do',
				dataType : 'json',
				type : 'post',
				data : {
					wave : wave,
					sampleStatus : dataStatus,
					sampleTime :sampleTime
				},
				success : function(data) {
					firstLoadData("productSampleSituation/selectProductSampleSituationByLike.do",$(".laypage_curr").text());
				},error:function(){
					alert("发放失败!");
				}
			});
		} else {
			return false;
		}
	});
}



// 删除
function del() {
	$(".delReturnRepairDoucuments").bind("click", function() {
		var delStatus = '已删除';
		var id = $(this).parent().parent().find("input").val();
		if (confirm('确定要删除此条数据吗?')) {
			$.ajax({
				url : '/productSampleSituation/deleteProductSampleSituation.do',
				dataType : 'json',
				type : 'post',
				data : {
					id : id,
					delStatus : delStatus			
				},
				success : function(data) {
					firstLoadData("/productSampleSituation/selectProductSampleSituationByLike.do?",$(".laypage_curr").text());
				}
			});
		} else {
			return false;
		}
	});
}

// 双击修改
//设置文本框
function mydblclick(){
	 $(".mydblClick").on("dblclick",function() {
		var myid= $(this).parent().find(".id").val();//获取到id值			
		var thisText = $(this).text().trim();    //文本框中原有的值
		var thisName = $(this).attr("name");    //获取文本框的属性名
		var thisVal = $(this).attr("value");   //获取文本框属性值
		if(thisName == "problemSolving"){
			$(this).html(
					"<form id='dbUpdateForm'><input type='hidden' name='id' value="+
							myid+" /><input type='text' id='my"+thisName +"' name='" + thisName+ "' value='" + thisText+ "'></form>");
			$(this).attr("class", "sn");
			twomyblur("my" + thisName);
		
		} else if (thisName != "estimatedDeliveryTime") {
				$(this).html(
						"<form id='dbUpdateForm'><input type='hidden' name='id' value="+
								myid+" /><input type='text' id='my"+thisName +"' name='" + thisName+ "' value='" + thisText+ "'></form>");
				$(this).attr("class", "sn");
				myblur("my" + thisName);
		}  else {
		$(this).html(
					"<form id='dbUpdateForm'><input type='hidden' name='id' value="+ 
							myid+" /><input class='form-control input-date' type='text' id='my"+ thisName 
				+ "' name='"+ thisName + "' value='"+ thisText + "'></form>");
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
		var input_date_readOnly = $(".input-date").prop("readOnly", "true");
		timeBlur("my" + thisName);
		} 
		$("#my"+ thisName).focus();
	}); 
} 

//提交对文本框中数据
 function myblur(id){
	 $("#" + id).blur(function() {
				 var myform = $("#dbUpdateForm").serialize();			
				 $.ajax({
					url:'productSampleSituation/updateProductSampleSituation.do',
					dataType:'json',
					type:'post',
					data:myform,
					success : function(data){
						 if(data==1){
							 firstLoadData("productSampleSituation/selectProductSampleSituationByLike.do?",$(".laypage_curr").text()); // 指定url
						 }else{
							 alert("修改失败");
						 }
					 },error:function(){
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
			url :'productSampleSituation/updateProductSampleSituation.do',
			type : 'POST',
			dataType : 'json',
			data : myform,
			async : false,
			success : function(data) {
				if (data == 1) {
					firstLoadData("productSampleSituation/selectProductSampleSituationByLike.do?",$(".laypage_curr").text());
				} else {
					alert("未修改");
				}
			}
		});
	}



//确认入库
$(function() {
	loadPageDatas(1);
	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val()
			+ "/problemNotReceiveMaterial/problemNotReceiveMaterialbylike.do", index); // 指定url
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
						var image = "<td>"
								+ (x.image == null || x.image == "" ? ''
										: "<img src='"
											+ x.image
											+ "' width='80px' height='80px'/>")
								+ "</td>";//图片
						var factory = "<td>"
							+ (x.factory != null ? x.factory : "")
							+ "</td>";// 工厂
						var orderType = "<td>"
							+ (x.orderType != null ? x.orderType: "") 
							+ "</td>";// 订单类型
						var fabricStorageTime = "<td>"
								+ (x.fabricStorageTime != null ? x.fabricStorageTime
										: "") + "</td>";// 面料入库时间
						var releaseTime = "<td>"
								+ (x.releaseTime != null ? x.releaseTime : "")
								+ "</td>";// 发版日期
						var timeDifferece = "<td>"
								+ (x.timeDifferece != null ? x.timeDifferece : "")
								+ "</td>";// 间隔时间
						var problemFeedback =x.problemFeedback == null ? "<td class='mydblClick' name='problemFeedback'></td>" :"<td class='mydblClick' name='problemFeedback'>" +  x.problemFeedback + "</td>";
						var reasonForDelay =x.reasonForDelay == null ? "<td class='mydblClick' name='reasonForDelay'></td>" :"<td class='mydblClick' name='reasonForDelay'>" +  x.reasonForDelay + "</td>";
						var personInCharge =x.personInCharge == null ? "<td class='mydblClick' name='personInCharge'></td>" :"<td class='mydblClick' name='personInCharge'>" +  x.personInCharge + "</td>";
						var memo = x.memo == null ? "<td class='mydblClick' name='memo'></td>" :"<td class='mydblClick' name='memo'>" + x.memo + "</td>";																			
						var problemSolving = x.problemSolving == null ? "<td class='mydblClick' name='problemSolving'></td>" :"<td class='mydblClick' name='problemSolving'>" + x.problemSolving + "</td>";		
						var problemSolvingTime =x.problemSolvingTime == null ? "<td></td>" :"<td>" +  x.problemSolvingTime + "</td>";
						var problemState=x.problemState == null ? "<td> </td>" : "<td>" +  x.problemState + "</td>";
						$("tbody").append(							
								"<tr "+(x.problemState!=null?"style='background:aquamarine;'":'')+">" 
										+  wave + productCode +image+ factory + orderType 
										+ fabricStorageTime
										+ releaseTime
										+ timeDifferece 
										+ problemFeedback
										+ reasonForDelay
										+ personInCharge
										+ memo
										+ problemSolving
										+ problemSolvingTime
										+ problemState
										+"<input type='hidden' class='id' value='" + x.id
										+ "'/>"
										+"<td style='text-align: center;'><a class='deleteByProblemNotReceiveMaterialId'  href='javascript:;'>删除</a></td>"+ "</tr>");
					});
	// 删除
	deleteByProblemNotReceiveMaterialId();
	//双击修改
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
						+ "/problemNotReceiveMaterial/problemNotReceiveMaterialbylike.do?"
						+ mySelectForm, 1); // 指定url
			});
}
// 删除
function deleteByProblemNotReceiveMaterialId() {
	$(".deleteByProblemNotReceiveMaterialId").bind(
			"click",
			function() {
				var delState = '已删除';
				var id = $(this).parent().parent().find(".id").val();
				if (confirm('确定要删除此条数据吗?')) {
					$.ajax({
						url : '/problemNotReceiveMaterial/deleteByProblemNotReceiveMaterialId.do',
						dataType : 'json',
						type : 'post',
						data : {
							id : id,
							delState : delState
						},
						success : function(data) {
							firstLoadData(
									"problemNotReceiveMaterial/problemNotReceiveMaterialbylike.do?"
											+ mySelectForm, $(".laypage_curr")
											.text());
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
					url:'problemNotReceiveMaterial/updateByText.do',
					dataType:'json',
					type:'post',
					data:myform,
					success : function(data){
						 if(data==1){
							 firstLoadData(	"problemNotReceiveMaterial/problemNotReceiveMaterialbylike.do?"+mySelectForm,$(".laypage_curr").text()); // 指定url
						 }else{
							 alert("修改失败");
						 }
					 },error:function(){
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
				firstLoadData("/problemNotReceiveMaterial/problemNotGrantbylike.do?"+mySelectForm,$(".laypage_curr").text()); // 指定url
			}else{
				$.ajax({
				url : '/problemNotReceiveMaterial/updateAndTime.do',      //指定路勁下的指定方法
				type : 'POST',
				dataType : 'json',
				data : myform,
				success : function(data){
					if(data==1){
						firstLoadData(	"problemNotReceiveMaterial/problemNotReceiveMaterialbylike.do?"+mySelectForm,$(".laypage_curr").text()); // 指定url
					}else{
						 alert("修改失败");
					}
				}
			}); 
		}
				 
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
			url :'problemNotReceiveMaterial/updateByText.do',
			type : 'POST',
			dataType : 'json',
			data : myform,
			async : false,
			success : function(data) {
				if (data == 1) {
					firstLoadData(	"problemNotReceiveMaterial/problemNotReceiveMaterialbylike.do?"+mySelectForm,$(".laypage_curr").text());
				} else {
					alert("未修改");
				}
			}
		});
	}

//点击查询获取查询的条件 数据
$(function() {
	$("#anyVal-btn").on('click',function() { //点击事查詢事件
		$("#pageSize").attr('name', ""); 	 //去掉分页查询pageSize
		$("#pageNow").attr('name', ""); 	 //去掉分页查询pageNow
		var anyVal = $("#form-anyVal").serialize(); //獲取條件查詢字段
		$.post('DistributionBuyMaterial/getPageCount.do',anyVal,function(data) { //帶條件查詢縂條數
			$("#pageSize").attr('name',"pageSize"); //给pageSize赋值name
			$("#pageNow").attr('name',"pageNow"); //给pageNow赋name值
			$("#pageNow").val(1);
			var anyVal = $("#form-anyVal").serialize(); //獲取條件字段
			showData("---anyVal-----"+anyVal);
			$(".tcdPageCode").createPage({
				pageCount : data.totalPageCount,
				current : data.pageNow,
				backFn : function(p) {
					$("#pageSize").val(10);
					$("#pageNow").val(p); //給當前頁賦值
					var anyVal = $("#form-anyVal").serialize(); //获取form表单
					//調用方法
					showData(anyVal); //調用分頁查詢 在這裏才調用
				}
			});
		});
	});
		//导出Excel
	 exportExcel();
});


/*页面加载执行的方法*/
$.post('DistributionBuyMaterial/getPageCount.do', {}, function(data) {
	$("#pageSize").val(10); 
	$("#pageNow").val(data.pageNow);
	//获取form参数进行查询
	var anyVal = $("#form-anyVal").serialize();
	//調用方法传参
	showData(anyVal);
	// 进入后台进行分页查询
	$(".tcdPageCode").createPage({ 
		pageCount : data.totalPageCount,
		//总页数
		current : data.pageNow,
		//当前页
		backFn : function(p) {
			$("#pageSize").val(10);
			$("#pageNow").val(p);			 //給當前頁賦值
			var anyVal = $("#form-anyVal").serialize();		 //获取form表单
			showData(anyVal);
		}
	});
});
$("#val-input-empty").find('div').find('div').find(":input").each(
		function() {
			$(this).val("");
		})

//显示数据的方法
function showData(anyVal1){
	//发送请求得到订单信息，并显示
		$.post("/DistributionBuyMaterial/select.do", anyVal1, //from表单内容
		function (data) {
				$(".table_app").empty(); //清空原有的数据
			for(var i=0;i<data.length;i++){
				var s_order = '';
				s_order+='<tr>';
				s_order+="<input type='hidden' class='id' value='"+data[i].id+"'/>"
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].productCode == null ? '':data[i].productCode)+'</td>';
				
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].oringinalWave == null ? '':data[i].oringinalWave)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].wave == null ? '':data[i].wave)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].clothName == null ? '':data[i].clothName)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;"><img src="'+(data[i].productImg == null ? '':data[i].productImg)+'" height="80" width="120"/></td>';
				if(data[i].sampleImg == null){
					s_order+=' 	<td style="width:100px;vertical-align:middle;"></td>';
				}else{
					s_order+=' 	<td style="width:100px;vertical-align:middle;"><a href="'+(data[i].sampleImg == null ? '#':data[i].sampleImg)+'" target="_blank">工艺单</a></td>';
				}
				if(data[i].sizeImg == null){
					s_order+=' 	<td style="width:100px;vertical-align:middle;"></td>';
				}else{
					s_order+=' 	<td style="width:100px;vertical-align:middle;"><a href="'+(data[i].sizeImg == null ? '#':data[i].sizeImg)+'" target="_blank">尺码图</a></td>';
				}
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].orderDetails == null ? '' : data[i].orderDetails)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].orderNum == null ? '': data[i].orderNum)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].planInWarehouseTime == null ? '': data[i].planInWarehouseTime)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].orderGrade == null ? '' : data[i].orderGrade)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].orderType == null ? '' : data[i].orderType)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].distributtionFactory == null ? '' : data[i].distributtionFactory)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;" class="mydblClick" name="trackingOfficer">'+(data[i].trackingOfficer == null ? '' : data[i].trackingOfficer)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;" class="mydblClick" name="remark">'+(data[i].remark == null ? '' : data[i].remark)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].orderId == null ? '' : data[i].orderId)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].releaseTime == null ? '' : data[i].releaseTime)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].tacheStartTime == null ? '' : data[i].tacheStartTime)+'</td>';
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].fabricArriveFactoryTime == null ? '' : data[i].fabricArriveFactoryTime)+'</td>';
				//订单状态
				if(data[i].fabricArriveFactory == '0'){
					s_order+=' 	<td style="vertical-align:middle; text-align: center;"><button class="btn btn-success" onclick="plusfinish(\' '+data[i].id+' \')">面料到场</button><br></td>';
				}
				else if(data[i].fabricArriveFactory == '1'){
					s_order+=' 	<td style="vertical-align:middle; text-align: center;"><button class="btn btn-success"  disabled="disabled"  onclick="plusfinish(\' '+data[i].id+' \')">面料已到场</button><br></td>';
				}
				s_order+=' 	<td style="vertical-align:middle;">'+(data[i].accesArriveFactoryTime == null ? '' : data[i].accesArriveFactoryTime)+'</td>';
				//订单状态
				if(data[i].accesArriveFactory == '0'){
					s_order+=' 	<td style="vertical-align:middle; text-align: center;"><button class="btn btn-success" onclick="accessoryfinish(\' '+data[i].id+' \')">辅料到场</button><br></td>';
				}
				else if(data[i].accesArriveFactory == '1'){
					s_order+=' 	<td style="vertical-align:middle; text-align: center;"><button class="btn btn-success"  disabled="disabled"  onclick="accessoryfinish(\' '+data[i].id+' \')">辅料已到场</button><br></td>';
				}
				s_order+='</tr>';
				
				//转为jquery对象
				$order = $(s_order);
				//添加到tbody里
				$('.table_app').append($order);
				//绑定双击修改方法
			}
			mydblclick();
		
	});
}
//上线
function plusfinish(id){
	var fabricArriveFactory='1';
	if(confirm("确定面料到厂？")){
		$.ajax({
			url:'DistributionBuyMaterial/updateform.do',
			type:'post',
			data:{'id':id,'fabricArriveFactory':fabricArriveFactory},
			dataType:'json',
			success:function(data){
				if(data == 1){
					//添加成功,重新刷新页面加载数据
					var anyVal = $("#form-anyVal").serialize();		 //获取form表单
					showData(anyVal);
				}else{
					alert("确认失败");
				}
			}
		});
	}
}
//上线
function accessoryfinish(id){
	var accesArriveFactory='1';
	if(confirm("确定辅料到厂？")){
		$.ajax({
			url:'DistributionBuyMaterial/updateform.do',
			type:'post',
			data:{'id':id,'accesArriveFactory':accesArriveFactory},
			dataType:'json',
			success:function(data){
				if(data == 1){
					var anyVal = $("#form-anyVal").serialize();		 //获取form表单
					showData(anyVal);
				}else{
					alert("确认失败");
				}
			}
		});
	}
}

//导出Excel
function exportExcel(){
	$("#export-btn").click(function(){
		$("#form-anyVal").submit();
	});
}
//--------------------------------------------双击修改-----------------------------------------------
function mydblclick() {
	$(".mydblClick").on("dblclick",
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
					url :'DistributionBuyMaterial/updateform.do',
					type : 'POST',
					dataType : 'json',
					data : myform,
					async : false,
					success : function(data) {
						if (data == 1) {
							//发送请求
							$.ajax({
								url:'DistributionBuyMaterial/getPageCount.do',//发送这个请求，得到分页的page信息
								type:'post',
								data:$('#form-anyVal').serialize(),
								dataType:'json',
								success:function(data){
						            //显示主体数据
									var anyVal3 = $("#form-anyVal").serialize(); //获取form表单
						            showData(anyVal3);
						            //显示分页
						            showPage(data);
								}
							});
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
		url : 'DistributionBuyMaterial/updateform.do',
		type : 'POST',
		dataType : 'json',
		data : myform,
		async : false,
		success : function(data) {
			if (data == 1) {
				//发送请求
				$.ajax({
					url:'DistributionBuyMaterial/getPageCount.do',//发送这个请求，得到分页的page信息
					type:'post',
					data:$('#form-anyVal').serialize(),
					dataType:'json',
					success:function(data){
			            //显示主体数据
						var anyVal3 = $("#form-anyVal").serialize(); //获取form表单
			            showData(anyVal3);
			            //显示分页
			            showPage(data);
					}
				});
			} else {
				alert("未修改");
			}
		}
	});
}

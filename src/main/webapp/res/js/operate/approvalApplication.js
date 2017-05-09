$(function() {
	// 查询
	loadPageDatas(1);
	// 导入
	inputExcel();
	// 模糊查询
	loadPageDataByLike();
	//全选
	checkAll();
	//一键通过
	toThrough();
});

// 模糊查询
var mySelectForm = "";
var girard="";
function loadPageDataByLike() {
  $("#checkbtn").click(
	function() {
		mySelectForm = $("#mySelect_From").serialize();
		girard=$("#checkByGirard").val();
		firstLoadData("approvalApplication/approvalApplicationByLike.do?"+ mySelectForm, 1);
		$("#mySelect_From>input").val("");
		calculations(girard);
	});
}
// 分页
function loadPageDatas(index) {
	// 处理后的数据
	firstLoadData( "approvalApplication/approvalApplicationByLike.do", index);

}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	getapprovalApplication(mydata);
}
function getapprovalApplication(mydata) {
	$("tbody").empty();
	calculations("");
	$("#importFile").val("");
	$.each(mydata,function(index, a) {
		var sampleImg = "";
		if (a.sampleImg != null && a.sampleImg) {
			sampleImg = "<a href='" + a.sampleImg + "' target='_blank'>工艺单</a>";
		}
		var sizeChart = "";
		if (a.sizeChart != null) {
			sizeChart = "<a href='" + a.sizeChart + "'  target='_blank'>尺码表</a>";
		}
		var EMF = "";
		if (a.paperpatternEmfFile != null) {
			EMF = "<a href='" + a.paperpatternEmfFile + "'  target='_blank'>EMF</a>";
		}
		var PRJ = "";
		if (a.paperpatternPrjFile != null) {
			PRJ = "<a href='" + a.paperpatternPrjFile + "'  target='_blank'>PRJ</a>";
		}
		$("tbody").append(
			"<tr><input type='hidden' class='id' value='"
					+ a.id
					+ "'/>" 
					+"<td style='text-align: center;'>"
					+ "<input type='checkbox' class='check' name='check' /> "
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.returnTime == null ? '' : a.returnTime)
					+ "</td>"
					+ "<td style='text-align: center;' class='mydblclick' name='girard'>"
					+ (a.girard == null ? '' : a.girard)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.originalWave == null ? '' : a.originalWave)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.referWave == null ? '' : a.referWave)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.productId == null ? '' : a.productId)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.model == null ? '' : a.model)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.clothName == null ? '' : a.clothName)
					+ "</td>"
					+ "<td style='text-align:center;'>"
					+ "<img width='50px' height='40px' src='"
					+ a.designImg
					+ "' /></td>"
					+ "<td style='text-align: center;'>"
					+ sampleImg
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ sizeChart
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code52'>"
					+ (a.code52 == 0 ||a.code52==null? '' : a.code52)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code59'>"
					+ (a.code59 == 0 ||a.code59==null? '' : a.code59)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code66'>"
					+ (a.code66 == 0 ||a.code66==null? '' : a.code66)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code73'>"
					+ (a.code73 == 0 ||a.code73==null? '' : a.code73)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code80'>"
					+ (a.code80 == 0 ||a.code80==null? '' : a.code80)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code90'>"
					+ (a.code90 == 0 ||a.code90==null? '' : a.code90)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code100'>"
					+ (a.code100 == 0 ||a.code100==null? '' : a.code100)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code110'>"
					+ (a.code110 == 0 ||a.code110==null? '' : a.code110)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code120'>"
					+ (a.code120 == 0 ||a.code120==null? '' : a.code120)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code130'>"
					+ (a.code130 == 0 ||a.code130==null? '' : a.code130)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code160'>"
					+ (a.code160 == 0 ||a.code160==null? '' : a.code160)
					+ "</td>"
					+ "<td style='text-align: center;' class='dblclickNum' name='code170'>"
					+ (a.code170 == 0 ||a.code170==null? '' : a.code170)
					+ "</td>"
					+ "<td style='text-align: center;' >"
					+ a.count
					+ "</td>"
					+ "<td style='text-align: center;' class='mydblclick' name='expectTime'>"
					+ (a.expectTime == null ? '' : a.expectTime)
					+ "</td>"
					+ "<td style='text-align: center;' class='mydblclick' name='remark'>"
					+ (a.remark == null ? '' : a.remark)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ "<button class='btn btn-info btn-sm updateapprovalApplication' data-toggle='modal' data-target='#myModal1'>修  改</button>"
					+ "<button class='btn btn-danger btn-sm delapprovalApplication' data-toggle='modal'>删  除</button>"
					+ "</td>"
					+ "<td style='text-align:center;'>"
					+ "<button class='btn btn-default  pass' data-dismiss='modal'>通过</button>"
					+ "</td>"
					+"</tr>");
	});
	// 删除
	delapprovalApplication();
	// 获取修改的信息
	getupp();
	// 双击修改
	dbclickUppApparel();
	//双击修改数值
	dbclickUpNum();
	// 修改
	myupdate();
	//审批
	approval();
	
	modifyCell();
}
// 后台获取数据
function getupp() {
	$(".updateapprovalApplication").bind("click",function() {
		var myIndex = $(".laypage_curr").text().trim();
		$("#myIndex").val(myIndex);
		var id = $(this).parent().parent().find("input").val();
		var index = $(".laypage_curr").text();
		var status = 2;
		$.ajax({
			url : 'approvalApplication/selapprovalApplicationById.do',
			datatype : 'json',
			type : 'post',
			data : { id : id , status:status},
			success : function(data) {
				var record = eval(data);
				$("#id").val(record.id);
				$("#ugirard").val(record.girard);
				$("#uoriginalWave").val(record.originalWave);
				$("#ucode52").val(record.code52 == 0 ? '': record.code52);
				$("#ucode59").val(record.code59 == 0 ? '': record.code59);
				$("#ucode66").val(record.code66 == 0 ? '': record.code66);
				$("#ucode73").val(record.code73 == 0 ? '': record.code73);
				$("#ucode80").val(record.code80 == 0 ? '': record.code80);
				$("#ucode90").val(record.code90 == 0 ? '': record.code90);
				$("#ucode100").val(record.code100 == 0 ? '': record.code100);
				$("#ucode110").val(record.code110 == 0 ? '': record.code110);
				$("#ucode120").val(record.code120 == 0 ? '': record.code120);
				$("#ucode130").val(record.code130 == 0 ? '': record.code130);
				$("#ucode160").val(record.code160 == 0 ? '': record.code160);
				$("#ucode170").val(record.code170 == 0 ? '': record.code170);
				$("#uexpectTime").val(record.expectTime);
				$("#uremark").val(record.remark);
				$("#state").val(record.urgentState);
			}

		});
	});
}
// 删除 ==========delapprovalApplication
function delapprovalApplication() {
	$(".delapprovalApplication").bind("click",function() {
		var id = $(this).parent().parent().find("input").val();
		if (confirm('确定要删除此条数据吗?')) {
			$.ajax({
					url : 'approvalApplication/delapprovalApplication.do',
					datatype : 'json',
					type : 'post',
					data : { id : id },
					success : function(data) {
						firstLoadData("approvalApplication/approvalApplicationByLike.do?"
								+ mySelectForm, $(".laypage_curr").text());
						calculations(girard);
					}
				});
		} else {
			return false;
		}
	});
}
// 修改
function myupdate() {
	//点击修改事件
	$("#myupdates").off("click").on("click",function() {
		var state = $("#state").val();
		var id = $("#id").val();
		var girard = $("#ugirard").val();
		var originalWave = $("#uoriginalWave").val();
		var code52 = $("#ucode52").val() == '' ? 0 : $("#ucode52").val();
		var code59 = $("#ucode59").val() == '' ? 0 : $("#ucode59").val();
		var code66 = $("#ucode66").val() == '' ? 0 : $("#ucode66").val();
		var code73 = $("#ucode73").val() == '' ? 0 : $("#ucode73").val();
		var code80 = $("#ucode80").val() == '' ? 0 : $("#ucode80").val();
		var code90 = $("#ucode90").val() == '' ? 0 : $("#ucode90").val();
		var code100 = $("#ucode100").val() == '' ? 0 : $("#ucode100").val();
		var code110 = $("#ucode110").val() == '' ? 0 : $("#ucode110").val();
		var code120 = $("#ucode120").val() == '' ? 0 : $("#ucode120").val();
		var code130 = $("#ucode130").val() == '' ? 0 : $("#ucode130").val();
		var code160 = $("#ucode160").val() == '' ? 0 : $("#ucode160").val();
		var code170 = $("#ucode170").val() == '' ? 0 : $("#ucode170").val();
		var time = $("#uexpectTime").val();
		var remark = $("#uremark").val();
		var data = {
			id : id,
			girard : girard,
			originalWave : originalWave,
			code52 : code52,
			code59 : code59,
			code66 : code66,
			code73 : code73,
			code80 : code80,
			code90 : code90,
			code100 : code100,
			code110 : code110,
			code120 : code120,
			code130 : code130,
			code160 : code160,
			code170 : code170,
			expectTime : time,
			urgentState : state,
			remark : remark
		};
		$.ajax({
			url : 'approvalApplication/uppapprovalApplication.do',
			dataType : 'json',
			type : 'POST',
			data : data,
			success : function(data) {
				if (data != 1) {
					alert("修改失败！");
				}
				firstLoadData("approvalApplication/approvalApplicationByLike.do?"
					+ mySelectForm, $(".laypage_curr").text());
				calculations(girard);
			},
			error : function(data) {
				alert("修改失败！系统错误！");
			}
		});
	});
}
///////////////////////////////////// 导入Excel表/////////////////////////////////////
function inputExcel() {
	$("#ImportStockAlert").click(function() {
		$.ajaxFileUpload({
			url : 'approvalApplication/inputapprovalApplication.do',
			secureuri : false,
			fileElementId : "importFile",
			dataType : 'json',
			success : function(data, status) {
				if (data == "1") {
					alert("上传成功!");
					firstLoadData("approvalApplication/approvalApplicationByLike.do", 1);
				}else if(data=="0"){
					alert("上传失败,请更改Excel表里的时间格式:YYYY/mm/dd");
				}else{
					alert("格式不支持请上传.xls格式");
				}
			}, 
			error : function(data, status, e) {
				$.messager.alert("提示", "导入失败", 'error');
				return false;
			}
		});
		$("#importFile").val("");
	});
}

// /////////////////////////////////双击修改//////////////////////////////
function dbclickUppApparel() {
	$(".mydblclick").on("dblclick",function() {
		var id = $(this).parent().find(".id").val();
		var result = $(this).text().trim();
		var name = $(this).attr("name");
		$(this).html("<input id='" + id + "' type='text' value='" + result+ "' name='" + name + "' style='width:100px;'> ");
		uppblur(id, name);// 光标离开
		$("#" + id).focus();// 文本框获取光标事件
		});
}
// 光标离开
function uppblur(id, name) {
	$("#" + id).blur(function() {
		var newtxt = $(this).val();
		$(this).closest("td").text(newtxt);
		var data = { id : id };
		data[name] = newtxt;
		$.ajax({
			url : 'approvalApplication/dbluppapprovalApplication.do',
			dataType : 'json',
			type : 'post',
			data : data,
			success : function(mydata) {
				if (mydata != 1) {
					alert("修改失败！");
				}
				firstLoadData("approvalApplication/approvalApplicationByLike.do?"
						+ mySelectForm, $(".laypage_curr").text());
				calculations(girard);
			},
			error : function() {
				alert("修改失败，系统错误！！");
				firstLoadData("approvalApplication/approvalApplicationByLike.do?"
						+ mySelectForm, $(".laypage_curr").text());
			}
		});
	});
}
//双击修改数值
function dbclickUpNum(){
	$(".dblclickNum").on("dblclick",function(){
		var id = $(this).parent().find(".id").val();
		var result = $(this).text().trim();
		var name = $(this).attr("name");
		$(this).html("<input id='" + id + "' type='text' value='" + result
				+ "' name='" + name + "' style='width:50px;'> ");
		$(this).attr("class", "sn");
		$("#" + id).focus();// 文本框获取光标事件
		myblur(id, name);// 光标离开);
   });
}
function myblur(id, name) {
	$("#" + id).blur(function() {
		var newtxt = $(this).val();
		$(this).closest("td").text(newtxt);
		var data = { id : id };
		data[name] = newtxt;
		$.ajax({
			url : 'approvalApplication/dbluppapprovalApplicationCode.do',
			dataType : 'json',
			type : 'post',
			data : data,
			success : function(mydata) {
				if (mydata != 1) {
					alert("修改失败！");
				}
				firstLoadData("approvalApplication/approvalApplicationByLike.do?"
						+ mySelectForm, $(".laypage_curr").text());
				calculations(girard);
			},
			error : function() {
				alert("修改失败，系统错误！！");
				firstLoadData("approvalApplication/approvalApplicationByLike.do?"
						+ mySelectForm, $(".laypage_curr").text());
				calculations(girard);
			}
		});
	});
}
////////////////////////////////////////////////////////////////////////
//审批
function approval() {
	$(".pass").click(function() {
		var id = $(this).parent().parent().find(".id").val();
		if (confirm('是否确认通过？')) {
			$.ajax({
				url : 'approvalApplication/selapprovalApplicationById.do',
				dataType : 'json',
				type : 'post',
				data : {
					id : id,
					status : 3
				},success : function(data) {
					pass(data);
				},error : function() {
					alert("失败");
				}
			});
		} else {
			return false;
		}
	});
}
// 审批通过！生成工艺单
function pass(data) {
	var id = data.id;
	var girard = data.girard; 
	var girardold = data.originalWave;
	var sampleImg = data.sampleImg;
	var code52 = data.code52;
	var code59 = data.code59;
	var code66 = data.code66;
	var code73 = data.code73;
	var code80 = data.code80;
	var code90 = data.code90;
	var code100 = data.code100;
	var code110 = data.code110;
	var code120 = data.code120;
	var code130 = data.code130;
	var code160 = data.code160;
	var code170 = data.code170;
	var count = data.count;
	var datas = {
			id : id,
			girard : girard,
			originalWave : girardold,
			sampleImg:sampleImg,
			code52 : code52,
			code59 : code59,
			code66 : code66,
			code73 : code73,
			code80 : code80,
			code90 : code90,
			code100 : code100,
			code110 : code110,
			code120 : code120,
			code130 : code130,
			code160 : code160,
			code170 : code170,
			count : count,
	};
	$.ajax({
		url : 'approvalApplication/generateSampleImg.do',
		dataType : 'json',
		type : 'post',
		data : datas,
		success : function(data) {
			if(data==1){
			}else{
				alert("返单生成失败！");
			}
			firstLoadData("approvalApplication/approvalApplicationByLike.do?"
					+ mySelectForm, $(".laypage_curr").text());
			calculations(girard);
		},error:function(){
			alert("网络错误或系统错误！");
			firstLoadData("approvalApplication/approvalApplicationByLike.do?"
					+ mySelectForm, $(".laypage_curr").text());
			calculations(girard);
		}
	});
}	

// 全选========点击id=checkbox 全部选中或取消
function checkAll() {
	$("#checkbox").attr("checked", false);
	$('#checkbox').click(function() {
		if (this.checked) {
			$("input[name='check']").each(function() {
				this.checked = true;
			});
		} else {
			$("input[name='check']").each(function() {
				this.checked = false;
			});
		}
	});
	$("[name='check']").click(function() {
		if ($("[name='check']").is("checked")) {
		} else {
			$('#checkbox').attr("checked", false);
		}
	});
}
//////////////////////////////////////////一键通过///////////////////////////////
function toThrough() {
	$("#throughbtn").on("click", function() {
		$('#checkbox').attr("checked", false);
		var ids = "";
		$("#tbody").find(":checkbox:checked").each(function() {
			var id = $(this).parent().parent().find(".id").val();
			ids += id + ",";
		});
		if (ids == "") {
			alert("请选择要通过的数据");
		} else {
			if (confirm('是否确认通过？')) {
			$.ajax({
				url : 'approvalApplication/approvalApplicationThrough.do',
				datatype : 'json',
				type : 'post',
				data : {
					ids : ids
				},
				success : function(data) {
					if(data != 1){
						alert("通过失败》》");
					}
					firstLoadData("approvalApplication/approvalApplicationByLike.do?"
							+ mySelectForm, $(".laypage_curr").text());
				},error:function(){
					alert("通过失败！系统异常！");
				}
			});
		}else{
			return false;
		}
	 }
  });
}
//计算总订单
function calculations(girard){
	$.ajax({
		url:'approvalApplication/calculations.do',
		dataType:'json',
		type:'post',
		data:{
			girard:girard
		},
		success:function(data){	
			$("#sumOrderNumber").text (data);	
		},error:function(){
			alert("系统异常！！");
		}
	});
}

//双击修改时间
function modifyCell() {
	$(".mytimedbClick").on("dblclick",function() {
		var id = $(this).parent().find(".id").val();
		var result = $(this).text().trim();
		var name = $(this).attr("name");
		$(this).html("<input class='form-control input-date' id='" + id 
				+ "' type='text' value='" + result+ "' name='" + name + "' style='width:80px;'> ");	
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
		});
		var input_date_readOnly = $(".input-date").prop("readOnly", "true");
		$("#" + id).focus();// 文本框获取光标事件
		timeBlur(id,name);
		});
}
function timeBlur(id,name) {
	$("#" + id).blur(function(){
		setTimeout("cursorLeavesEvent(" + id + ",'" + name + "')", 2000);
	});
}
//光标离开事件
function cursorLeavesEvent(id,name) {
	var newtxt= $("#"+id).val();
	$(this).closest("td").text(newtxt);
	var data = {id : id};
	data[name] = newtxt;
	$.post('approvalApplication/dbluppapprovalApplication.do',data, function(mydata) {
		if (mydata !=1) {
			alert("修改失败");
		} else {
			firstLoadData("approvalApplication/approvalApplicationByLike.do?"+ mySelectForm, $(".laypage_curr").text());
		}
	});
}

//$.ajax({
//url : 'apparelDevelopmentReturn/addApparelDevelopmentReturn.do',
//dataType : 'json',
//type : 'post',
//data : datas,
//success : function(data) {
//	if (data == 1) {
//		alert("返单生成成功！");
//	} else {
//		alert("返单生成失败！");
//	}
//	firstLoadData("approvalApplication/approvalApplicationByLike.do?"
//			+ mySelectForm, $(".laypage_curr").text());
//},
//error : function() {
//	alert("返单生成失败！系统错误！！");
//	firstLoadData("approvalApplication/approvalApplicationByLike.do?"
//			+ mySelectForm, $(".laypage_curr").text());
//}
//});
//
//function excles() {
//	$("#dj").on(
//			"click",
//			function() {
//				var ids = "";
//				$("#tbody").find(":checkbox:checked").each(function() {
//					var id = $(this).parent().parent().find(".id").val();
//					ids += id + ",";
//				});
//				if (ids == "") {
//					alert("请选择要导出的数据！");
//				} else {
//					window.open("/approvalApplication/toExcel.do?ids="
//							+ ids, "#");
//				}
//				loadPageDatas($(".laypage_curr").text());
//			});
//}
// 添加 addApparelReturnbtn
/*
 * function myadd(){$("#addApparelReturnbtn").click(function(){var formData =
 * new FormData($("#add-form")[0]); $.ajax({ url :
 * '/apparelDevelopmentReturn/addApparelDevelopmentReturn.do',type : 'POST',data :
 * formData, async : false,cache : false,contentType : false, processData :
 * false,success : function(data) { loadPageDatas(1);},error : function(data)
 * {alert(data + "添加失败"); } }); }); }
 */

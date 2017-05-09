$(function() {
	// 查询
	loadPageDatas(1);
	// 清空添加框
	clear();
	// 导入
	//inputExcel();
	// 生成Excel表
	toExcel();
	// 全选
	checkAll();
	//生成Excel表
	excles();
	// 模糊查询
	loadPageDataByLike();
	//下载excel
	downExcel();
});
// 清空添加框
function clear() {
	$("#add").click(function() {
		$("#add_form_input").find('div').find('div').find(":input").each(function() {
					$(this).val("");});
	});
}
// 模糊查询
var mySelectForm = "";
function loadPageDataByLike() {
	//查询所有
	$("#checkbtn").click(function() {
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData("apparelDevelopmentReturn/apparelDevelopmentReturnBylike.do?"+ mySelectForm, 1);
		$("#mySelect_From>input").val("");
	});
	//完成查询
	$("#selover").click(function(){
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData("apparelDevelopmentReturn/apparelDevelopmentReturnBystate.do?type=1&"+ mySelectForm, 1);
		$("#mySelect_From>input").val("");
	});
	//采购中
	$("#seling").click(function(){
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData("apparelDevelopmentReturn/apparelDevelopmentReturnBystate.do?type=0&"+ mySelectForm, 1);
		$("#mySelect_From>input").val("");
	});
}


// 分页
function loadPageDatas(index) {
	// 处理后的数据
	firstLoadData("/apparelDevelopmentReturn/apparelDevelopmentReturnBylike.do",index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	getapparelDevelopmentReturn(mydata);
}
function getapparelDevelopmentReturn(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, a) {
		var sampleImg = "";
		if (a.sampleImg != null && a.sampleImg!="") {
			sampleImg = "<a href='" + a.sampleImg+ "' target='_blank'>工艺单</a>";
		}
		var sizeChart = "";
		if (a.sizeChart != null && a.sizeChart!="") {
			sizeChart = "<a href='" + a.sizeChart+ "'  target='_blank'>尺码表</a>";
		}
		var EMF = "";
		if (a.paperpatternEmfFile != null) {
			EMF = "<a href='" + a.paperpatternEmfFile+ "'  target='_blank'>EMF</a>";
		}
		var PRJ = "";
		if (a.paperpatternPrjFile != null) {
			PRJ = "<a href='" + a.paperpatternPrjFile+ "'  target='_blank'>PRJ</a>";
		}
		var state="";
		$("tbody").append(
			"<tr "+(a.storageTime!=null?"style='background:aquamarine;'":'')+">" 
					+"<input type='hidden' class='id' value='"
					+ a.id
					+ "'/><td style='text-align: center;'>"
					+ "<input type='checkbox' class='check' name='check' /> "
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.returnTime == null ? '': a.returnTime)
					+ "</td>"
//					+ "<td style='text-align: center;' class='mydblclick' name='designer'>"
//					+ (a.designer == null ? '': a.designer)+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.girard == null ? '': a.girard)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.originalWave == null ? '' :a.originalWave)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.referWave == null ? '': a.referWave)
					+ "</td>"
//					+ "<td style='text-align: center;' class='mydblclick' name='printWave'>"
//					+ (a.printWave == null ? '': a.printWave)+ "</td>"
//					+ "<td style='text-align: center;' class='mydblclick' name='vendorCode'>"
//					+ (a.vendorCode == null ? '': a.vendorCode)+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.productId == null ? '': a.productId)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.model == null ? '': a.model)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.clothName == null ? '': a.clothName)
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
//					+ "<td style='text-align: center;'>"+ EMF+ "</td>"
//					+ "<td style='text-align: center;'>"+ PRJ+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code52 == 0 ? '': a.code52)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code59 == 0 ? '': a.code59)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code66 == 0 ? '': a.code66)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code73 == 0 ? '': a.code73)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code80 == 0 ? '': a.code80)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code90 == 0 ? '': a.code90)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code100 == 0 ? '': a.code100)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code110 == 0 ? '': a.code110)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code120 == 0 ? '': a.code120)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code130 == 0 ? '': a.code130)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code160 == 0 ? '': a.code160)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.code170 == 0 ? '': a.code170)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ a.count
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.expectTime == null ? '': a.expectTime)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.storageTime==null?'':a.storageTime)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.storageNumber == null ? '': a.storageNumber)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (a.storageTime!=null?"完成":"采购中")
					+ "</td>"
					+ "<td style='text-align: center;' class='mydblclick' name='remark'>"
					+ (a.remark == null ? '': a.remark)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ "<button class='btn btn-warning btn-sm gogo' data-dismiss='modal'>加 急"
					+ (a.urgentState == 0 ? '': ' ★' + a.urgentState)
					+ "</button>"
					+ "<button class='btn btn-info btn-sm cancel' data-dismiss='modal'>取 消"
					+ "</button>"
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ "<button class='btn btn-info btn-sm printProcessImg' data-toggle='modal'>工艺单</button>"
					+ "</td>"
//					+ "<button class='btn btn-info btn-sm updateApparelDevelopmentReturn' data-toggle='modal' data-target='#myModal1'>修  改</button>"
//					+ "<button class='btn btn-danger btn-sm delApparelDevelopmentReturn' data-toggle='modal'>删  除</button>"
					+"</tr>");
	});
	// 删除
	delApparelDevelopmentReturn();
	// 获取修改的信息
	getupp();
	// 双击修改
	dbclickUppApparel();
	// 修改
	myupdate();
	//加急
	gogo();
	//取消加急
	cancel();
	//打印工艺单
	processImg();
}
	
// 后台获取数据
function getupp() {
	$(".updateApparelDevelopmentReturn").bind("click",function() {
		var myIndex = $(".laypage_curr").text().trim();
		$("#myIndex").val(myIndex);
		var id = $(this).parent().parent().find("input").val();
		var index = $(".laypage_curr").text();
		$.ajax({
			url : 'apparelDevelopmentReturn/selApparelDevelopmentReturnById.do',
			datatype : 'json',
			type : 'post',
			data : {
				id : id
			},
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
// 删除 ==========delApparelDevelopmentReturn
function delApparelDevelopmentReturn() {
	$(".delApparelDevelopmentReturn").bind("click",function() {
		var id = $(this).parent().parent().find("input").val();
		if (confirm('确定要删除此条数据吗?')) {
			$.ajax({
				url : 'apparelDevelopmentReturn/delApparelDevelopmentReturn.do',
				datatype : 'json',
				type : 'post',
				data : {
					id : id
				},
				success : function(data) {
					loadPageDatas($(".laypage_curr").text());
				}
			});
		} else {
			return false;
		}
	});
}
// 修改
function myupdate() {
	//取消加急
	$("#urgentState").click(function() {
		$("#state").val(0);
	});
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
			url : 'apparelDevelopmentReturn/uppApparelDevelopmentReturn.do',
			dataType : 'json',
			type : 'POST',
			data : data,
			success : function(data) {
				if (data != 1) {
					alert("修改失败！");
				}
				firstLoadData("apparelDevelopmentReturn/apparelDevelopmentReturnBylike.do?"
								+ mySelectForm, $(".laypage_curr").text());
			},
			error : function(data) {
				alert("修改失败！系统错误！");
				firstLoadData("apparelDevelopmentReturn/apparelDevelopmentReturnBylike.do?"
								+ mySelectForm, $(".laypage_curr").text());
			}
		});
	});
}
///////////////////////////////////// 导入Excel表/////////////////////////////////////
function inputExcel() {
	$("#ImportStockAlert").click(function() {
		$.ajaxFileUpload({
			url : '/apparelDevelopmentReturn/inputApparelDevelopmentReturn.do',
			secureuri : false,
			fileElementId : "importFile",
			dataType : 'json',
			success : function(data, status) {
				if (data == "1") {
					alert("上传成功!");
					firstLoadData("apparelDevelopmentReturn/apparelDevelopmentReturnBylike.do?"
							+ mySelectForm, $(".laypage_curr").text());
				}
			},
			error : function(data, status, e) {
				$.messager.alert("提示", "导入失败", 'error');
				return false;
			}
		});
	});
}

// /////////////////////////////////双击修改//////////////////////////////
function dbclickUppApparel() {
	$(".mydblclick").on(
			"dblclick",
			function() {
				var id = $(this).parent().find(".id").val();
				var result = $(this).text().trim();
				var name = $(this).attr("name");
				$(this).html(
						"<input id='" + id + "' type='text' value='" + result
								+ "' name='" + name + "'> ");
				$("#" + id).focus();// 文本框获取光标事件
				uppblur(id, name);// 光标离开
			});
}
// 光标离开
function uppblur(id, name) {
	$("#" + id).blur(function() {
		var newtxt = $(this).val();
		$(this).closest("td").text(newtxt);
		var data = {
			id : id
		};
		data[name] = newtxt;
		$.ajax({
			url : 'apparelDevelopmentReturn/uppApparelDevelopmentReturn.do',
			dataType : 'json',
			type : 'post',
			data : data,
			success : function(mydata) {
				if (mydata != 1) {
					alert("修改失败！");
				}
				firstLoadData(
						"apparelDevelopmentReturn/apparelDevelopmentReturnBylike.do?"
								+ mySelectForm, $(
								".laypage_curr").text());
			},
			error : function() {
				alert("修改失败，系统错误！！");
				loadPageDatas($(".laypage_curr").text());
			}
		});
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
////////////////////////////////////////下载Excel///////////////////////////////
// toExcel()====下面的获取的值
function toExcel() {
	$("#Excelbtn").on("click", function() {
		var ids = "";
		$("#tbody").find(":checkbox:checked").each(function() {
			var id = $(this).parent().parent().find(".id").val();
			ids += id + ",";
		});
		if (ids == "") {
			alert("请选择要导出的数据");
		} else {
			$.ajax({
				url : 'apparelDevelopmentReturn/selApparelReturnById.do',
				datatype : 'json',
				type : 'post',
				data : {
					ids : ids
				},
				success : function(data) {
					var form = $("<form>");// 定义一个form表单
					form.attr("style", "display:none");
					form.attr("name", "mainform");
					form.attr("target", "");
					form.attr("method", "post");
					form.attr("action", "/apparelDevelopmentReturn/tozip.do");
					var input1 = $("<input>");
					input1.attr("type", "hidden");
					input1.attr("name", "file");
					input1.attr("value", data);
					$("#excelss").append(form);// 将表单放置在web中
					form.append(input1);
					form.submit();// 表单提交
					loadPageDatas($(".laypage_curr").text());
				}
			});
		}
	});
}

function excles() {
//	$("#dj").on("click",function() {
//		var ids = "";
//		$("#tbody").find(":checkbox:checked").each(function() {
//			var id = $(this).parent().parent().find(".id").val();
//			ids += id + ",";
//		});
//		if (ids == "") {
//			alert("请选择要导出的数据！");
//		} else {
//			window.open("/apparelDevelopmentReturn/toExcel.do?ids="
//					+ ids, "#");
//		}
//		loadPageDatas($(".laypage_curr").text());
//	});
}

///////////////////////////////////加急状态//////////////////////////////
// 点击修改加急状态
function gogo() {
	$(".gogo").on("click",function() {
		var id = $(this).parent().parent().find(".id").val();
		$.ajax({
			url : 'apparelDevelopmentReturn/selApparelDevelopmentReturnById.do',
			datatype : 'json',
			type : 'post',
			data : {
				id : id
			},
			success : function(data) {
				if (data.urgentState < 5) {
					var state = data.urgentState + 1;
					go(id, state);
				} else {
					alert("已到达最高级别！");
				}
			}
		});
	});
}
function go(id, state) {
	$.ajax({
		url : 'apparelDevelopmentReturn/uppApparelDevelopmentReturn.do',
		dataType : 'json',
		type : 'POST',
		data : {
			id : id,
			urgentState : state
		},
		success : function(data) {
			if(data==0){
				alert("操作失败！！");
			}
			firstLoadData(
					"apparelDevelopmentReturn/apparelDevelopmentReturnBylike.do?"
							+ mySelectForm, $(".laypage_curr").text());
		},error:function(){
			alert("网络原因或系统错误！");
		}
	});
}
//取消加急
function cancel(){
	$(".cancel").on("click",function() {
	var id = $(this).parent().parent().find(".id").val();
		$.ajax({
			url : 'apparelDevelopmentReturn/uppApparelDevelopmentReturn.do',
			datatype : 'json',
			type : 'post',
			data : {
				id : id,
				urgentState : 0
			},
			success : function(data) {
				firstLoadData(
						"apparelDevelopmentReturn/apparelDevelopmentReturnBylike.do?"
								+ mySelectForm, $(".laypage_curr").text());
				}
		});
	});
}
//打印工艺单
function processImg() {
	$(".printProcessImg").click(function() {
		var processImg = $(this).parent().parent().find("td:eq(9)>a")
				.attr("href");
		if (processImg.length != 0) {
			$("#printImg").attr("src", processImg);
			$("#printImg").jqprint();
		} else {
			alert("没有工艺单");
		}
	});
}


function downExcel(){
	$("#downExcel").on('click',function(){
		var time=$("#returnTime").val();
		var girard=$("#girard").val();
		window.open("/apparelDevelopmentReturn/toExcel.do?returnTime="+ time+"&girard="+girard);
	});
}
// 添加 addApparelReturnbtn
/*
 * function myadd(){$("#addApparelReturnbtn").click(function(){var formData =
 * new FormData($("#add-form")[0]); $.ajax({ url :
 * '/apparelDevelopmentReturn/addApparelDevelopmentReturn.do',type : 'POST',data :
 * formData, async : false,cache : false,contentType : false, processData :
 * false,success : function(data) { loadPageDatas(1);},error : function(data)
 * {alert(data + "添加失败"); } }); }); }
 */

/**
 * 裁片印绣花领料日报表
 */
$(function() {
/*	//图片预览
	$("#imageFile").uploadPreview({
		Img : "ImgPr",
		Width : 120,
		Height : 120
	});*/
	// 分页
	loadPageDatas(1);
	// 添加
	addReturnRepairDoucuments();

	// 修改
	updateReturnRepairDoucuments();
	// 清空添加表单
	$("#add").click(
			function() {
				$("#add_form_input").find('div').find('div').find(":input")
						.each(function() {$(this).val("");});
			});
	// 模糊查询
	bylikeReturnRepairDoucuments();
});
function show() {
	$("#radio1").attr("checked", "true");
	$("#check2").hide();
	$("#radio2").removeAttr('checked');
	$("#radio1").click(function() {
		$("#check2").hide();
	});
	$("#radio2").click(function() {
		$("#check2").show();
	});

}

// 模糊查询
var mySelectForm = "";
function bylikeReturnRepairDoucuments() {
	$("#checkbtn").on("click",function() {
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData("ReturnRepairDoucuments/bylikeReturnRepairDoucuments.do?" + mySelectForm, 1);
		$("#mySelect_From>input").val("");
	});
}

// 分页
function loadPageDatas(index) {
	// 处理后的数据inputstorage
	if(index==''){
		index=1;
	}
	firstLoadData($("#path").val() + "/ReturnRepairDoucuments/bylikeReturnRepairDoucuments.do", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	Inputstorage(mydata);
}
function Inputstorage(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, s) {
		var img = (s.designImg == null? '' : "<img width='120px' height='120px' src='s.designImg'>");
			$("tbody").append("<tr>"
					+ "<input type='hidden' class='sid' value='"
					+ s.sid
					+ "'/>"
					+ "<input type='hidden' class='deleteTime' value='"
					+ s.deleteTime
					+ "'/>"
					+ "<td style='text-align: center;'>"
					+ (s.addTime == null ? '' : s.addTime)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.vendorCode == null ? '' : s.vendorCode)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.commoditycCode == null ? '' : s.commoditycCode)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.girard == null ? '' : s.girard)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.factory == null ? '' : s.factory)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ img
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code52 == null
							|| s.code52 == 0 ? '' : s.code52)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code59 == null
							|| s.code59 == 0 ? '' : s.code59)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code66 == null
							|| s.code66 == 0 ? '' : s.code66)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code73 == null
							|| s.code73 == 0 ? '' : s.code73)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code80 == null
							|| s.code80 == 0 ? '' : s.code80)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code90 == null
							|| s.code90 == 0 ? '' : s.code90)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code100 == null
							|| s.code100 == 0 ? '' : s.code100)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code110 == null
							|| s.code110 == 0 ? '' : s.code110)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code120 == null
							|| s.code120 == 0 ? '' : s.code120)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code130 == null
							|| s.code130 == 0 ? '' : s.code130)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code160 == null
							|| s.code160 == 0 ? '' : s.code160)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code170 == null
							|| s.code170 == 0 ? '' : s.code170)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.total == null ? '' : s.total)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.remarks == null ? '' : s.remarks)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.updateTime == null ? '' : s.updateTime)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.reEntry == null ? '' : s.reEntry)
					+ "</td>"
					+ "<td style='text-align: center;'><a class='delReturnRepairDoucuments'  href='javascript:;'>删除</a></td>"
					+ "<td style='text-align: center;'><a data-toggle='modal' data-target='#myModal1' class='selectByPrimaryKey' href='javascript:;'>修改</a></td>"
					+ "</tr>");
		
			});
	// 获取修改的信息
	getupp();
	// 删除
	delReturnRepairDoucuments();
}
// 添加
function addReturnRepairDoucuments() {
	$("#addInputstorage").click(function() {
		var girard = $("#girard").val();
		var date = $("#sdate").val();
		var factory = $("#factory").val();
		var remark = $("#remark").val();
		var vendorCode = $("#vendorCode").val();
		var commoditycCode = $("#commoditycCode").val();
		var designImg = $("#imageFile").val() == "" ? 0 : $("#imageFile").val();
		var code52 = $("#code52").val() == "" ? 0 : $("#code52").val();
		var code59 = $("#code59").val() == "" ? 0 : $("#code59").val();
		var code66 = $("#code66").val() == "" ? 0 : $("#code66").val();
		var code73 = $("#code73").val() == "" ? 0 : $("#code73").val();
		var code80 = $("#code80").val() == "" ? 0 : $("#code80").val();
		var code90 = $("#code90").val() == "" ? 0 : $("#code90").val();
		var code100 = $("#code100").val() == "" ? 0 : $("#code100").val();
		var code110 = $("#code110").val() == "" ? 0 : $("#code110").val();
		var code120 = $("#code120").val() == "" ? 0 : $("#code120").val();
		var code130 = $("#code130").val() == "" ? 0 : $("#code130").val();
		var code160 = $("#code160").val() == "" ? 0 : $("#code160").val();
		var code170 = $("#code170").val() == "" ? 0 : $("#code170").val();
		$.ajax({
			url : '/ReturnRepairDoucuments/addReturnRepairDoucuments.do',
			datatype : 'json',
			type : 'post',
			data : {
				addTime : date,
				girard : girard,
				vendorCode :  vendorCode,
				commoditycCode : commoditycCode, 
				factory : factory,
				designImg : designImg,
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
				remarks : remark
			},
			success : function(data) {	
				if(data==1){
					loadPageDatas($(".laypage_curr").text());
				}
				if(data==0){
					alert("波次号为空，请填写正确的波次号");
				}
				if(data==10){
					alert("波次号重复，请填写正确的波次号");
				}
			}
		});
	});

}
// 删除
function delReturnRepairDoucuments() {
	$(".delReturnRepairDoucuments").bind("click", function() {
		var orderStatus = '已删除';
		var deleteTime = $("#deleteTime").val();
		var id = $(this).parent().parent().find("input").val();
		var girard = $(this).parent().parent().find("td:eq(1)").text();
		if (confirm('确定要删除此条数据吗?')) {
			$.ajax({
				url : '/ReturnRepairDoucuments/deleteReturnRepairDoucuments.do',
				dataType : 'json',
				type : 'post',
				data : {
					sid : id,
					orderStatus : orderStatus,
					deleteTime : deleteTime
				},
				success : function(data) {
					firstLoadData("ReturnRepairDoucuments/bylikeReturnRepairDoucuments.do?" + mySelectForm,$(".laypage_curr").text());
				}
			});
		} else {
			return false;
		}
	});
}
// 后台获取数据
function getupp() {
	$(".selectByPrimaryKey").bind("click", function() {
		var id = $(this).parent().parent().find(".sid").val();
		$.ajax({
			url : '/ReturnRepairDoucuments/selectByPrimaryKey.do',
			dataType : 'json',
			type : 'post',
			data : {
				sid : id
			},
			success : function(data) {
				
				$("#sid").val(id);
				$("#usdate").val(data.updateTime);
				$("#ugirard").val(data.girard);
				$("#ufactory").val(data.factory);
				$("#imageFile").val(data.designImg == 0 ? "" : data.designImg);
				$("#ucode52").val(data.code52 == 0 ? "" : data.code52);
				$("#ucode59").val(data.code59 == 0 ? "" : data.code59);
				$("#ucode66").val(data.code66 == 0 ? "" : data.code66);
				$("#ucode73").val(data.code73 == 0 ? "" : data.code73);
				$("#ucode80").val(data.code80 == 0 ? "" : data.code80);
				$("#ucode90").val(data.code90 == 0 ? "" : data.code90);
				$("#ucode100").val(data.code100 == 0 ? "" : data.code100);
				$("#ucode110").val(data.code110 == 0 ? "" : data.code110);
				$("#ucode120").val(data.code120 == 0 ? "" : data.code120);
				$("#ucode130").val(data.code130 == 0 ? "" : data.code130);
				$("#ucode160").val(data.code160 == 0 ? "" : data.code160);
				$("#ucode170").val(data.code170 == 0 ? "" : data.code170);
				$("#uremark").val(data.remarks == 0 ? "" : data.remarks);
				$("#reEntry").val(data.reEntry == 0 ? "" : data.reEntry);
				
			}
		});
	});
}
// 修改
function updateReturnRepairDoucuments() {
	$("#uppInputstorage").click(function() {
		var id = $("#sid").val();
		var date = $("#usdate").val();
		var girard = $("#ugirard").val();
		var factory = $("#ufactory").val();
		var code52 = $("#ucode52").val() == "" ? 0 : $("#ucode52").val();
		var code59 = $("#ucode59").val() == "" ? 0 : $("#ucode59").val();
		var code66 = $("#ucode66").val() == "" ? 0 : $("#ucode66").val();
		var code73 = $("#ucode73").val() == "" ? 0 : $("#ucode73").val();
		var code80 = $("#ucode80").val() == "" ? 0 : $("#ucode80").val();
		var code90 = $("#ucode90").val() == "" ? 0 : $("#ucode90").val();
		var code100 = $("#ucode100").val() == "" ? 0 : $("#ucode100").val();
		var code110 = $("#ucode110").val() == "" ? 0 : $("#ucode110").val();
		var code120 = $("#ucode120").val() == "" ? 0 : $("#ucode120").val();
		var code130 = $("#ucode130").val() == "" ? 0 : $("#ucode130").val();
		var code160 = $("#ucode160").val() == "" ? 0 : $("#ucode160").val();
		var code170 = $("#ucode170").val() == "" ? 0 : $("#ucode170").val();
		var reEntry = $("#reEntry").val() == "" ? 0 : $("#reEntry").val();
		var remark = $("#uremark").val();
		$.ajax({
			url : '/ReturnRepairDoucuments/updateReturnRepairDoucuments.do',
			dataType : 'json',
			type : 'post',
			data : {
				sid : id,
				changeTime : date,
				updateTime : date,
				girard : girard,
				factory : factory,
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
				remarks : remark,
				reEntry : reEntry
			},
			success : function(data) {
				firstLoadData("ReturnRepairDoucuments/bylikeReturnRepairDoucuments.do?" + mySelectForm,$(".laypage_curr").text());
			}
		});
	});
}
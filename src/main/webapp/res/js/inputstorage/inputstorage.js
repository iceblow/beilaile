/**
 * 裁片印绣花领料日报表
 */
$(function() {
	// 分页
	loadPageDatas(1);
	// 添加
	addInputstorage();

	// 修改
	uppInputstorages();
	// 清空添加表单
	$("#add").click(
			function() {
				$("#add_form_input").find('div').find('div').find(":input")
						.each(function() {$(this).val("");});
			});
	// 模糊查询
	InputstorageBylike();
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
function InputstorageBylike() {
	$("#checkbtn").on("click",function() {
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData("inputstorage/InputstorageBylike.do?" + mySelectForm, 1);
		$("#mySelect_From>input").val("");
	});
}
//	$("#checkbtn").click(
//			function() {
//				var girard = $("#checkByGirard").val();
//				var factory = $("#checkByFactory").val();
//				var commoditycCode = $("#checkByCommoditycCode").val();
//				firstLoadData("/inputstorage/InputstorageBylike.do?girard="
//						+ girard + "&factory=" + factory + "&commoditycCode="
//						+ commoditycCode, 1);
//				$("#checkByGirard").val("");
//				$("#checkByFactory").val("");
//				$("#checkByCommoditycCode").val("");
//			});
//}

// 分页
function loadPageDatas(index) {
	// 处理后的数据inputstorage
	firstLoadData($("#path").val() + "/inputstorage/InputstorageBylike.do", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	Inputstorage(mydata);
}
function Inputstorage(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, s) {
			$("tbody").append("<tr>"
					+ "<input type='hidden' class='sid' value='"
					+ s.sid
					+ "'/>"
					+ "<input type='hidden' class='productShortName' value='"
					+ s.productShortName
					+ "'/>"
					+ "<td style='text-align: center;'>"
					+ (s.sdate == null ? '' : s.sdate)
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
					+ "<img width='60px' height='60px' src='"
					+ s.designImg
					+ "'/></td>"
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
					+ "<td style='text-align: center;'><a class='delInpurstorage'  href='javascript:;'>删除</a></td>"
					+ "<td style='text-align: center;'><a data-toggle='modal' data-target='#myModal1' class='updateInpurstorage' href='javascript:;'>修改</a></td>"
					+ "</tr>");
//			<td style='text-align: center; width:60px;'><a data-toggle='modal' data-target='#myModal2' class='printBar' href='javascript:;'>"
//			+ "<button  class='btn btn-default'>打印条码</button>"
//			+ "</a></td>
			});
	// 获取修改的信息
	getupp();
	// 删除
	delInpurstorage();
	// 打印条形码
	toprintBar();
}
// 添加
function addInputstorage() {
	$("#addInputstorage").click(function() {
		var girard = $("#girard").val();
		var date = $("#sdate").val();
		var factory = $("#factory").val();
		var remark = $("#remark").val();
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
			url : '/inputstorage/addInputstorage.do',
			datatype : 'json',
			type : 'post',
			data : {
				sdate : date,
				girard : girard,
				factory : factory,
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
				loadPageDatas($(".laypage_curr").text());
			}
		});
	});

}
// 删除
function delInpurstorage() {
	$(".delInpurstorage").bind("click", function() {
		var id = $(this).parent().parent().find("input").val();
		var girard = $(this).parent().parent().find("td:eq(1)").text();
		if (confirm('确定要删除此条数据吗?')) {
			$.ajax({
				url : '/inputstorage/delInputstorage.do',
				dataType : 'json',
				type : 'post',
				data : {
					sid : id
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
// 后台获取数据
function getupp() {
	$(".updateInpurstorage").bind("click", function() {
		var id = $(this).parent().parent().find(".sid").val();
		$.ajax({
			url : '/inputstorage/touppInputstorageById.do',
			dataType : 'json',
			type : 'post',
			data : {
				sid : id
			},
			success : function(data) {
				$("#sid").val(id);
				$("#usdate").val(data.sdate);
				$("#ugirard").val(data.girard);
				$("#ufactory").val(data.factory);
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
				$("#uremark").val(data.remarks);
			}
		});
	});
}
// 修改
function uppInputstorages() {
	$("#uppInputstorage").click(function() {
		var id = $("#sid").val();
		var date = $("#usdate").val();
		var girard = $("#ugirard").val();
		var factory = $("#ufactory").val();
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
		var remark = $("#uremark").val();
		$.ajax({
			url : '/inputstorage/uppInputstorage.do',
			dataType : 'json',
			type : 'post',
			data : {
				sid : id,
				sdate : date,
				girard : girard,
				factory : factory,
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
				firstLoadData("inputstorage/InputstorageBylike.do?" + mySelectForm,$(".laypage_curr").text());
			}
		});
	});
}
////////////////////////*****************************/////////////////////
// 打印
var id;
var code;
var girard;
var date;
var factory;
var commoditycCode;
var productShortName;
function toprintBar() {
	$(".mybdlclick").dblclick(function() {
		//获取值
		var num = $(this).parent("tr").children("td").index($(this));
		code = parseInt($("#head").children("th").eq(num).html()); //获取表头
		id = $(this).parent().find(".sid").val();
		date = $(this).parent().find("td:eq(0)").text();
		commoditycCode = $(this).parent().find("td:eq(2)").text();
		girard = $(this).parent().find("td:eq(3)").text();
		factory = $(this).parent().find("td:eq(4)").text();
		productShortName=$(this).parent().find(".productShortName").val();
		if(commoditycCode== null ||commoditycCode==""){
			alert("商品编码为空！不可打印");
		}else{
			if(productShortName==null || productShortName==""){
				alert("未找到商品名！");
			}else{	
				//赋值给模态框
				$("#code").text(code);
				//获取弹出模态框
				$(".mybdlclick").append("<a id='subBtn' data-toggle='modal' data-target='#myModal2' href='javascript:;'></a>");
				//$("#subBtn").trigger("click");
				$("#subBtn").click();
				show();
				$("#num").val("");
				
				barCode();
			}
		}
	});
}
	// 点击打印按钮
function barCode(){
	$("#printBarCode").unbind('click').bind('click', function() {
		var num = $("#num").val() == "" ? 0 : $("#num").val();
			$.ajax({
				url : 'inputstorage/selTotalById.do',
				dataType : 'json',
				type : 'post',
				data : {
					sid : id,
					girard : girard,
					sdate : date,
					factory : factory,
					commoditycCode : commoditycCode,
					productShortName : productShortName,
					code : code,
					num : num
				},
				success : function(data) {
					printImg(data);
				}
			});
	});
}
// 打印条形码
function printImg(t) {
	$.ajax({
		url : '/inputstorage/touppInputstorageById.do',
		datatype : 'json',
		type : 'post',
		data : {sid : id},
		success : function(data) {
			if (data.tempBar != null) {
				var string = "";
				var tempBar = "";
				for (var i = 0; i < t; i++) {
					string = string + "<img src='" + data.tempBar+ "' width='100%' height=100%>";
				}
				tempBar = $("<div>" + string + "</div>").get(0);
				$(tempBar).jqprint();
			}
			firstLoadData("inputstorage/InputstorageBylike.do?" + mySelectForm,$(".laypage_curr").text());
		}
	});
}
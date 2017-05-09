/**
 * 2016年12月23日13:33:26
 */
$(function() {
	loadPageDatas(1);
	// 查询
	mySelect();
	// 修改 uppProduct();

	// 导入销售数据
	inputSalesSku();
	// 导入库存数据
	inputSalesReport();
	// 分析
	analysis();
});
// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData("productBack/selProductBack.do?", index);// 处理后的数据
}
function loadData(data) {
	test(data);
}
function test(data) {
	$("#importSalesSkuData").val("");
	$("#importSalesReportData").val("");
	$("tbody").empty();
	$
			.each(
					data,
					function(index, a) {
						var status = "";
						if (a.delb == 3) {
							status = "style='background:aquamarine;'";
						} else if (a.delb == 2) {
							status = "style='background:gold;'";
						}
						$("tbody")
								.append(
										"<tr "
												+ status
												+ ">"
												+ "<input type='hidden' class='id' value='"
												+ a.id
												+ "'/>"
												+ "<td style='text-align: center;'>"
												+ (a.productcodes == null ? ''
														: a.productcodes)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.girard == null ? ''
														: a.girard)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.girardOld == null ? ''
														: a.girardOld)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock52 == null
														|| a.stock52 == 0 ? ''
														: a.stock52)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock59 == null
														|| a.stock59 == 0 ? ''
														: a.stock59)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock66 == null
														|| a.stock66 == 0 ? ''
														: a.stock66)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock73 == null
														|| a.stock73 == 0 ? ''
														: a.stock73)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock80 == null
														|| a.stock80 == 0 ? ''
														: a.stock80)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock90 == null
														|| a.stock90 == 0 ? ''
														: a.stock90)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock100 == null
														|| a.stock100 == 0 ? ''
														: a.stock100)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock110 == null
														|| a.stock110 == 0 ? ''
														: a.stock110)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock120 == null
														|| a.stock120 == 0 ? ''
														: a.stock120)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock130 == null
														|| a.stock130 == 0 ? ''
														: a.stock130)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock160 == null
														|| a.stock160 == 0 ? ''
														: a.stock160)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.stock170 == null
														|| a.stock170 == 0 ? ''
														: a.stock170)
												+ "</td>"
												// + "<td style='text-align:
												// center;'>"
												// + (a.productname == null ?
												// '': a.productname)
												// + "</td>"
												+ "<td style='text-align: center;'>"
												+ "<img width='50px' height='40px' src='"
												+ a.productimg
												+ "'/></td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale52 == null
														|| a.sale52 == 0 ? ''
														: a.sale52)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale59 == null
														|| a.sale59 == 0 ? ''
														: a.sale59)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale66 == null
														|| a.sale66 == 0 ? ''
														: a.sale66)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale73 == null
														|| a.sale73 == 0 ? ''
														: a.sale73)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale80 == null
														|| a.sale80 == 0 ? ''
														: a.sale80)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale90 == null
														|| a.sale90 == 0 ? ''
														: a.sale90)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale100 == null
														|| a.sale100 == 0 ? ''
														: a.sale100)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale110 == null
														|| a.sale110 == 0 ? ''
														: a.sale110)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale120 == null
														|| a.sale120 == 0 ? ''
														: a.sale120)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale130 == null
														|| a.sale130 == 0 ? ''
														: a.sale130)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale160 == null
														|| a.sale160 == 0 ? ''
														: a.sale160)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.sale170 == null
														|| a.sale170 == 0 ? ''
														: a.sale170)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ "<img width='50px' height='40px' src='"
												+ a.productimg
												+ "'/></td>"
												+ "<td style='text-align: center;'>"
												+ (a.code52 == null
														|| a.code52 == 0 ? ''
														: a.code52)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code59 == null
														|| a.code59 == 0 ? ''
														: a.code59)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code66 == null
														|| a.code66 == 0 ? ''
														: a.code66)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code73 == null
														|| a.code73 == 0 ? ''
														: a.code73)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code80 == null
														|| a.code80 == 0 ? ''
														: a.code80)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code90 == null
														|| a.code90 == 0 ? ''
														: a.code90)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code100 == null
														|| a.code100 == 0 ? ''
														: a.code100)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code110 == null
														|| a.code110 == 0 ? ''
														: a.code110)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code120 == null
														|| a.code120 == 0 ? ''
														: a.code120)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code130 == null
														|| a.code130 == 0 ? ''
														: a.code130)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code160 == null
														|| a.code160 == 0 ? ''
														: a.code160)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.code170 == null
														|| a.code170 == 0 ? ''
														: a.code170)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.total == null ? ''
														: a.total)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (a.expectTime == null ? ''
														: a.expectTime)
												+ "</td>"
												// + "<td style='text-align:
												// center;'>"
												// + "<button class='btn
												// btn-info btn-sm toupp'
												// data-toggle='modal'
												// data-target='#myModal1'>修
												// 改</button>"
												// + "<button class='btn
												// btn-danger btn-sm
												// delProductBack'
												// data-toggle='modal'>删
												// 除</button>"
												// +"</td>"
												+ "<td style='text-align:center;'>"
												+ "<button class='btn btn-info btn-sm toadd' data-toggle='modal' data-target='#myModal'>通过</button>"
												+ "</td>" + "</tr>");
					});
	// 修改前查询 touppProduct();
	// 删除 delProductBack();
	// 双击修改 dbclickUppApparel();
	// 审批
	approval();
}
// 查询
var mySelectForm = "";
function mySelect() {
	$("#mySelectProduct").click(function() {
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData("productBack/selProductBack.do?" + mySelectForm, 1);
		$(".col-md-2>input").val("");
	});
}

// 审批
function approval() {
	$(".toadd").unbind("click").bind("click", function() {
		var id = $(this).parent().parent().find(".id").val();
		$("#addSub").unbind("click").bind("click", function() {
			var expectTime = $("#expectTime").val();
			$.ajax({
				url : 'productBack/toProductBack.do',
				dataType : 'json',
				type : 'post',
				data : {
					id : id,
					delb : 3
				},
				success : function(data) {
					pass(data, expectTime);
				},
				error : function() {
					alert("失败");
				}
			});
		});
	});
}
// 审批通过！
function pass(data, expectTime) {
	var id = data.id;
	var code52 = data.code52 == null ? 0 : data.code52;
	var code59 = data.code59 == null ? 0 : data.code59;
	var code66 = data.code66 == null ? 0 : data.code66;
	var code73 = data.code73 == null ? 0 : data.code73;
	var code80 = data.code80 == null ? 0 : data.code80;
	var code90 = data.code90 == null ? 0 : data.code90;
	var code100 = data.code100 == null ? 0 : data.code100;
	var code110 = data.code110 == null ? 0 : data.code110;
	var code120 = data.code120 == null ? 0 : data.code120;
	var code130 = data.code130 == null ? 0 : data.code130;
	var code160 = data.code160 == null ? 0 : data.code160;
	var code170 = data.code170 == null ? 0 : data.code170;
	var productcodes = data.productcodes;
	var girard = data.girard;
	var girardold = data.girardOld;
	// var productoldname = data.productoldname;
	var time = expectTime;
	var productname = data.productname;
	var productimg = data.productimg;
	var datas = {
		girard : girard,
		productId : productcodes,
		originalWave : girardold,
		clothName : productname,
		designImg : productimg,
		expectTime : time,
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
		code170 : code170
	};
	$.ajax({
		url : 'approvalApplication/addapprovalApplication.do',
		dataType : 'json',
		type : 'post',
		data : datas,
		success : function(data) {
			if (data == 1) {
				alert("返单生成成功！");
			} else {
				alert("返单生成失败！");
			}
			firstLoadData("productBack/selProductBack.do?" + mySelectForm, $(
					".laypage_curr").text());
		},
		error : function() {
			alert("返单生成失败！系统错误！！");
		}
	});
}

// 导入销售数据/////////////////////////////////////
function inputSalesSku() {
	$("#importSalesSku").click(function() {
		$.ajaxFileUpload({
			url : 'productBack/inputSalesSkuOfWdt.do',
			secureuri : false,
			fileElementId : "importSalesSkuData",
			dataType : 'json',
			success : function(data, status) {
				if (data == "1") {
					alert("上传成功!");
					firstLoadData("productBack/selProductBack.do", 1);
				} else if (data == "2") {
					alert("上传失败!!");
				} else if (data == "0") {
					alert("上传格式错误,请上传.xls格式");
				}
			},
			error : function(data, status, e) {
				$.messager.alert("提示", "导入失败", 'error');
				return false;
			}
		});
		$("#importSalesSkuData").val("");
	});
}
// 导入库存数据//////////////////////////////
function inputSalesReport() {
	$("#importSalesReport").click(function() {
		$.ajaxFileUpload({
			url : 'productBack/inputSalesReportOfWdt.do',
			secureuri : false,
			fileElementId : "importSalesReportData",
			dataType : 'json',
			success : function(data, status) {
				if (data == "1") {
					alert("上传成功!");
					firstLoadData("productBack/selProductBack.do", 1);
				} else if (data == "2") {
					alert("上传失败!!");
				} else if (data == "0") {
					alert("上传格式错误,请上传.xls格式");
				}
			},
			error : function(data, status, e) {
				$.messager.alert("提示", "导入失败", 'error');
				return false;
			}
		});
		$("#importSalesReportData").val("");
	});
}
// 库存分析
function analysis() {
	$("#analysis").on("click", function() {
		$.ajax({
			url : 'productBack/analysis.do',
			dataType : 'json',
			type : 'post',
			data : {},
			success : function(data) {
				if (data == 0) {
					alert("分析发生错误!!");
				} else if (data == 1) {
					alert("分析成功!!");
					firstLoadData("productBack/selProductBack.do", 1);
				}
			},
			error : function() {
				alert("分析失败系统错误!~!");
			}
		});

	});
}
// /////////////////////////////////双击修改//////////////////////////////
/*
 * function dbclickUppApparel() { $(".mydblclick").on( "dblclick", function() {
 * var id = $(this).parent().find(".id").val(); var result =
 * $(this).text().trim(); var name = $(this).attr("name"); $(this).html( "<input
 * id='" + id + "' type='text' value='" + result + "' name='" + name + "'
 * style='width:100px;'> "); $("#" + id).focus();// 文本框获取光标事件 uppblur(id,
 * name);// 光标离开 }); } // 光标离开 function uppblur(id, name) { $("#" +
 * id).blur(function() { var newtxt = $(this).val();
 * $(this).closest("td").text(newtxt); var data = { id : id }; data[name] =
 * newtxt; $.ajax({ url : 'productBack/uppProductBack.do', dataType : 'json',
 * type : 'post', data : data, success : function(mydata) { if (mydata != 1) {
 * alert("修改失败！"); } loadPageDatas($(".laypage_curr").text()); }, error :
 * function() { alert("修改失败，系统错误！！"); loadPageDatas($(".laypage_curr").text()); }
 * }); }); }
 */
// ////////////////////////////////////////////////////////////////////////////////
// 修改前查询
/*
 * function touppProduct() { $(".toupp").click(function() { var id =
 * $(this).parent().parent().find(".id").val(); $.ajax({ url :
 * 'productBack/toProductBack.do', dataType : 'json', type : 'post', data : { id :
 * id, }, success : function(data) { $("#id").val(id);
 * $("#ucode52").val(data.code52 == 0? "" : data.code52);
 * $("#ucode59").val(data.code59 == 0 ? "" : data.code59);
 * $("#ucode66").val(data.code66 == 0 ? "" : data.code66);
 * $("#ucode73").val(data.code73 == 0 ? "" : data.code73);
 * $("#ucode80").val(data.code80 == 0 ? "" : data.code80);
 * $("#ucode90").val(data.code90 == 0 ? "" : data.code90);
 * $("#ucode100").val(data.code100 == 0 ? "" : data.code100);
 * $("#ucode110").val(data.code110 == 0 ? "" : data.code110);
 * $("#ucode120").val(data.code120 == 0? "" : data.code120);
 * $("#ucode130").val(data.code130 == 0 ? "" : data.code130);
 * $("#ucode160").val(data.code160 == 0 ? "" : data.code160);
 * $("#ucode170").val(data.code170 == 0 ? "" : data.code170); } }); }); } //
 * 修改各码的数量 function uppProduct() { $("#updateSub").click(function() { var id =
 * $("#id").val(); var code52 = $("#ucode52").val() == "" ? 0 :
 * $("#ucode52").val(); var code59 = $("#ucode59").val() == "" ? 0 :
 * $("#ucode59").val(); var code66 = $("#ucode66").val() == "" ? 0 :
 * $("#ucode66").val(); var code73 = $("#ucode73").val() == "" ? 0 :
 * $("#ucode73").val(); var code80 = $("#ucode80").val() == "" ? 0 :
 * $("#ucode80").val(); var code90 = $("#ucode90").val() == "" ? 0 :
 * $("#ucode90").val(); var code100 = $("#ucode100").val() == "" ? 0 :
 * $("#ucode100").val(); var code110 = $("#ucode110").val() == "" ? 0 :
 * $("#ucode110").val(); var code120 = $("#ucode120").val() == "" ? 0 :
 * $("#ucode120").val(); var code130 = $("#ucode130").val() == "" ? 0 :
 * $("#ucode130").val(); var code160 = $("#ucode160").val() == "" ? 0 :
 * $("#ucode160").val(); var code170 = $("#ucode170").val() == "" ? 0 :
 * $("#ucode170").val(); $.ajax({ url : 'productBack/uppProductBack.do',
 * dataType : 'json', type : 'post', data : { id : id, code52 : code52, code59 :
 * code59, code66 : code66, code73 : code73, code80 : code80, code90 : code90,
 * code100 : code100, code110 : code110, code120 : code120, code130 : code130,
 * code160 : code160, code170 : code170 }, success : function(data) { if (data !=
 * 1) { alert("修改失败"); } firstLoadData("productBack/selProductBack.do?" +
 * mySelectForm,$(".laypage_curr").text()); }, error : function() {
 * alert("修改失败！！系统错误"); } }); }); } // 删除 function delProductBack() {
 * $(".delProductBack").click(function() { var id =
 * $(this).parent().parent().find(".id").val(); if (confirm('确定要删除此条数据吗?')) {
 * $.ajax({ url : 'productBack/delProductBack.do', dataType : 'json', type :
 * 'post', data : {id : id}, success : function(data) { if (data != 1) {
 * alert("删除失败！"); } loadPageDatas($(".laypage_curr").text(), 0); },error :
 * function() { alert("删除失败,系统错误！！"); } }); } else { return false; } }); }
 */

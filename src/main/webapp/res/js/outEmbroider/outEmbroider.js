/**
 * 裁片印绣花领料日报表
 */
$(function() {

	// 分页
	loadPageDatas(1);
	// 添加
	addEmbroider();
	// 模糊查询
	embroiderBylike();

	// 修改
	uppEmdroider();
	// 清空添加框
	clear();
});

function clear() {
	$("#add").click(
			function() {
				$("#add_form_input").find('div').find('div').find(":input")
						.each(function() {
							$(this).val("");
						});
			});
}
// 模糊查询
function embroiderBylike() {
	$("#checkbtn").click(function() {
		var girard = $("#checkByGirard").val();
		firstLoadData("/outEmbroider/embroiderBylike.do?girard=" + girard, 1);
	});

}

// 分页
function loadPageDatas(index) {
	// 处理后的数据
	firstLoadData("/outEmbroider/embroiderBylike.do?girard=" + "", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	outEmbroider(mydata);
}
function outEmbroider(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, o) {
						$("tbody")
								.append(
										"<tr>"
												+ "<input type='hidden' class='bid' value='"
												+ o.oid
												+ "'/>"
												+ "<td style='text-align: center;'>"
												+ o.company
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ o.odate
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ o.girard
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ o.fabric
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ "<img width='60px' height='60px' src='"
												+ o.designImg
												+ "'/></td>"
												+ "<td style='text-align: center;'>"
												+ (o.code52 == null || o.code52 == 0 ? '' : o.code52)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code1 == null || o.code1 == 0 ? '' : o.code1)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code2 == null || o.code2 == 0 ? '' : o.code2)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code3 == null || o.code3 == 0 ? '' : o.code3)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code4 == null || o.code4 == 0 ? '' : o.code4)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code5 == null || o.code5 == 0 ? '' : o.code5)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code6 == null || o.code6 == 0 ? '' : o.code6)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code110 == null
														|| o.code110 == 0 ? ''
														: o.code110)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code120 == null
														|| o.code120 == 0 ? ''
														: o.code120)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code130 == null
														|| o.code130 == 0 ? ''
														: o.code130)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code160 == null
														|| o.code160 == 0 ? ''
														: o.code160)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.code170 == null
														|| o.code170 == 0 ? ''
														: o.code170)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ o.total
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (o.remarks == null ? ""
														: o.remarks)
												+ "</td>"
												+ "<td style='text-align: center;'><a class='delEmbroider'  href='javascript:;'>删除</a></td>"
												+ "<td style='text-align: center;'><a data-toggle='modal' data-target='#myModal1' class='updateEmbroider' href='javascript:;'>修改</a></td></tr>");
					});
	// 获取修改的信息
	getupp();
	// 删除
	delEmbroider();

}
// 添加
function addEmbroider() {
	$("#addEmbroider").click(function() {
		var company = $("#company").val();
		var girard = $("#girard").val();
		var fabric = $("#fabric").val();
		var date = $("#odate").val();
		var code52 = $("#code52").val() == "" ? 0 : $("#code52").val();
		var code1 = $("#code1").val() == "" ? 0 : $("#code1").val();
		var code2 = $("#code2").val() == "" ? 0 : $("#code2").val();
		var code3 = $("#code3").val() == "" ? 0 : $("#code3").val();
		var code4 = $("#code4").val() == "" ? 0 : $("#code4").val();
		var code5 = $("#code5").val() == "" ? 0 : $("#code5").val();
		var code6 = $("#code6").val() == "" ? 0 : $("#code6").val();
		var code110 = $("#code110").val() == "" ? 0 : $("#code110").val();
		var code120 = $("#code120").val() == "" ? 0 : $("#code120").val();
		var code130 = $("#code130").val() == "" ? 0 : $("#code130").val();
		var code160 = $("#code160").val() == "" ? 0 : $("#code160").val();
		var code170 = $("#code170").val() == "" ? 0 : $("#code170").val();

		var remark = $("#remark").val();
		$.ajax({
			url : '/outEmbroider/addEmbroider.do',
			datatype : 'json',
			type : 'post',
			data : {
				company : company,
				girard : girard,
				fabric : fabric,
				odate : date,
				code52 : code52,
				code1 : code1,
				code2 : code2,
				code3 : code3,
				code4 : code4,
				code5 : code5,
				code6 : code6,
				code110 : code110,
				code120 : code120,
				code130 : code130,
				code160 : code160,
				code170 : code170,
				remarks : remark
			},
			success : function(data) {
				loadPageDatas(1);
			}
		});
	});

}
// 删除
function delEmbroider() {
	$(".delEmbroider").bind("click", function() {
		var oid = $(this).parent().parent().find("input").val();
		if (confirm('确定要删除此条数据吗?')) {
			$.ajax({
				url : '/outEmbroider/delEmbroider.do',
				dataType : 'json',
				type : 'post',
				data : {
					oid : oid
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

function getupp() {
	$(".updateEmbroider").bind("click", function() {
		var id = $(this).parent().parent().find("input").val();
		$.ajax({
			url : '/outEmbroider/touppEmbroider.do',
			dataType : 'json',
			type : 'post',
			data : {
				oid : id
			},
			success : function(data) {
				$("#oid").val(id);
				$("#ucompany").val(data.company);
				$("#udate").val(data.odate);
				$("#ugirard").val(data.girard);
				$("#ufabric").val(data.fabric);
				$("#ucode52").val(data.code52);
				$("#ucode1").val(data.code1);
				$("#ucode2").val(data.code2);
				$("#ucode3").val(data.code3);
				$("#ucode4").val(data.code4);
				$("#ucode5").val(data.code5);
				$("#ucode6").val(data.code6);
				$("#ucode110").val(data.code110);
				$("#ucode120").val(data.code120);
				$("#ucode130").val(data.code130);
				$("#ucode160").val(data.code160);
				$("#ucode170").val(data.code170);
				$("#uremark").val(data.remarks);
			}
		});
	});
}
// 修改
function uppEmdroider() {
	$("#uppEmbroider").click(function() {
		var id = $("#oid").val();
		var company = $("#ucompany").val();
		var girard = $("#ugirard").val();
		var date = $("#udate").val();
		var fabric = $("#ufabric").val();
		var code52 = $("#ucode52").val() == "" ? 0 : $("#ucode52").val();
		var code1 = $("#ucode1").val() == "" ? 0 : $("#ucode1").val();
		var code2 = $("#ucode2").val() == "" ? 0 : $("#ucode2").val();
		var code3 = $("#ucode3").val() == "" ? 0 : $("#ucode3").val();
		var code4 = $("#ucode4").val() == "" ? 0 : $("#ucode4").val();
		var code5 = $("#ucode5").val() == "" ? 0 : $("#ucode5").val();
		var code6 = $("#ucode6").val() == "" ? 0 : $("#ucode6").val();
		var code110 = $("#ucode110").val() == "" ? 0 : $("#ucode110").val();
		var code120 = $("#ucode120").val() == "" ? 0 : $("#ucode120").val();
		var code130 = $("#ucode130").val() == "" ? 0 : $("#ucode130").val();
		var code160 = $("#ucode160").val() == "" ? 0 : $("#ucode160").val();
		var code170 = $("#ucode170").val() == "" ? 0 : $("#ucode170").val();
		var remark = $("#uremark").val();
		$.ajax({
			url : '/outEmbroider/uppEmbroider.do',
			dataType : 'json',
			type : 'post',
			data : {
				oid : id,
				company : company,
				odate : date,
				girard : girard,
				fabric : fabric,
				code52 : code52,
				code1 : code1,
				code2 : code2,
				code3 : code3,
				code4 : code4,
				code5 : code5,
				code6 : code6,
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
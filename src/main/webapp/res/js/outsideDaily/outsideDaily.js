/**
 * 裁片印绣花领料日报表
 */
$(function() {

	// 分页
	loadPageDatas(1);
	// 添加
	addOutsideDaily();
	// 模糊查询
	OutsideDailyBylike();

	// 修改
	uppOutsideDaily();
	// 清空添加表单
	clearOs();
});
function clearOs() {
	$("#add").click(
			function() {
				$("#add_form_input").find('div').find('div').find(":input")
						.each(function() {
							$(this).val("");
						});
			});
}
// 模糊查询
function OutsideDailyBylike() {
	$("#checkbtn").click(
			function() {
				var girard = $("#checkByGirard").val();
				var company = $("#checkByCompany").val();
				firstLoadData("outsideDialy/outsideDailyBylike.do?girard="
						+ girard + "&company=" + company, 1);
				$("#checkByGirard").val("");
				$("#checkByCompany").val("");
			});
}
// 分页
function loadPageDatas(index) {
	// 处理后的数据
	firstLoadData("outsideDialy/outsideDailyBylike.do", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	outsideDialy(mydata);
}

function outsideDialy(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, od) {
			$("tbody").append("<tr>"
				+ "<input type='hidden' class='bid' value='"
				+ od.odid
				+ "'/>"
				+ "<td style='text-align: center;'>"
				+ od.company
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ od.oddate
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ od.girard
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ od.fabric
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ "<img width='60px' height='60px' src='"
				+ od.designImg
				+ "'/></td>"
				+ "<td style='text-align: center;'>"
				+ (od.code52 == null || od.code52 == 0 ? '' : od.code52)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code1 == null || od.code1 == 0 ? '' : od.code1)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code2 == null || od.code2 == 0 ? '' : od.code2)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code3 == null || od.code3 == 0 ? '' : od.code3)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code4 == null || od.code4 == 0 ? '' : od.code4)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code5 == null || od.code5 == 0 ? '' : od.code5)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code6 == null || od.code6 == 0 ? '' : od.code6)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code110 == null || od.code110 == 0 ? '' : od.code110)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code120 == null || od.code120 == 0 ? '' : od.code120)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code130 == null || od.code130 == 0 ? '' : od.code130)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code160 == null || od.code160 == 0 ? '' : od.code160)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.code170 == null || od.code170 == 0 ? '' : od.code170)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.total == null ? '' : od.total)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (od.remarks == null ? "" : od.remarks)
				+ "</td>"
				+ "<td style='text-align: center;'><a class='deloutsideDaily'  href='javascript:;'>删除</a></td>"
				+ "<td style='text-align: center;'><a data-toggle='modal' data-target='#myModal1' class='updateoutsideDaily' href='javascript:;'>修改</a></td></tr>");
		});
	// 获取修改的信息
	getupp();
	// 删除
	delOutsideDaily();
}
// 添加
function addOutsideDaily() {
	$("#addoutsideDaily").click(function() {
		var company = $("#company").val();
		var date = $("#oddate").val();
		var girard = $("#girard").val();
		var fabric = $("#fabric").val();
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
			url : '/outsideDialy/addOutsideDaily.do',
			datatype : 'json',
			type : 'post',
			data : {
				company : company,
				oddate : date,
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
// 删除
function delOutsideDaily() {
	$(".deloutsideDaily").bind("click", function() {
		var id = $(this).parent().parent().find("input").val();
		if (confirm('确定要删除此条数据吗?')) {
			$.ajax({
				url : '/outsideDialy/delOutsideDaily.do',
				dataType : 'json',
				type : 'post',
				data : {
					odid : id
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
// 修改前查询
function getupp() {
	$(".updateoutsideDaily").bind("click", function() {
		var id = $(this).parent().parent().find("input").val();
		$.ajax({
			url : '/outsideDialy/touppOutsideDaily.do',
			dataType : 'json',
			type : 'post',
			data : {
				odid : id
			},
			success : function(data) {
				$("#odid").val(id);
				$("#ucompany").val(data.company);
				$("#udate").val(data.oddate);
				$("#ugirard").val(data.girard);
				$("#ufabric").val(data.fabric);
				$("#ucode52").val(data.code52 == 0 ? "" : data.code52);
				$("#ucode1").val(data.code1 == 0 ? "" : data.code1);
				$("#ucode2").val(data.code2 == 0 ? "" : data.code2);
				$("#ucode3").val(data.code3 == 0 ? "" : data.code3);
				$("#ucode4").val(data.code4 == 0 ? "" : data.code4);
				$("#ucode5").val(data.code5 == 0 ? "" : data.code5);
				$("#ucode6").val(data.code6 == 0 ? "" : data.code6);
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
function uppOutsideDaily() {
	$("#uppoutsideDaily").click(function() {
		var id = $("#odid").val();
		var company = $("#ucompany").val();
		var date = $("#udate").val();
		var girard = $("#ugirard").val();
		var fabric = $("#ufabric").val();
		var code52= $("#ucode52").val() == "" ? 0 : $("#ucode52").val();
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
			url : '/outsideDialy/uppOutsideDaily.do',
			dataType : 'json',
			type : 'post',
			data : {
				odid : id,
				company : company,
				oddate : date,
				girard : girard,
				fabric : fabric,
				code52:code52,
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

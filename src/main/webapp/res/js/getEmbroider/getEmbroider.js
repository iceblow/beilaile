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
	$("#add").click(function() {
		$("#add_form").find("div").find("div").find("input").each(function() {
			$(this).val("");
		})
	});
});

// 模糊查询
function embroiderBylike() {
	$("#checkbtn").click(function() {
		var girard = $("#checkByGirard").val();
		firstLoadData("getEmbroider/embroiderBylike.do?girard=" + girard, 1);
		$("#checkByGirard").val("");
	});

}

// 分页
function loadPageDatas(index) {
	// 处理后的数据
	firstLoadData("getEmbroider/embroiderBylike.do", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	getEmbroider(mydata);
}
function getEmbroider(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, e) {
			// var str = "<button class='btn btn-default'>已完成
			// </button>";
			// if (e.status == "0") {
			// str = "<button id='submit' class='btn
			// btn-default'>确认完成 </button>";
			// }
			$("tbody").append(
				"<tr>"
					+ "<input type='hidden' class='bid' value='"
					+ e.eid
					+ "'/>"
					+ "<td style='text-align: center;'>"
					+ e.company
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ e.edate
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ e.girard
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.fabric == null ?'0':e.fabric)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code52 == null || e.code52 == 0 ? '' : e.code52)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code1 == null || e.code1 == 0 ? '' : e.code1)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code2 == null || e.code2 == 0 ? '' : e.code2)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code3 == null || e.code3 == 0 ? '' : e.code3)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code4 == null || e.code4 == 0 ? '' : e.code4)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code5 == null || e.code5 == 0 ? '' : e.code5)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code6 == null || e.code6 == 0 ? '' : e.code6)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code110 == null || e.code110 == 0 ? '' : e.code110)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code120 == null || e.code120 == 0 ? '' : e.code120)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code130 == null || e.code130 == 0 ? '' : e.code130)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code160 == null || e.code160 == 0 ? '' : e.code160)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (e.code170 == null || e.code170 == 0 ? '' : e.code170)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ e.total
					+ "</td>"
					+ "<td style='text-align: center;'><a class='delEmbroider'  href='javascript:;'>删除</a></td>"
					+ "<td style='text-align: center;'><a data-toggle='modal' data-target='#myModal1' class='updateEmbroider' href='javascript:;'>修改</a>"
					// + "</td>" + "<td
					// style='text-align:center;
					// width: 60px;'>" + str
					+ "</td></tr>");
		});
	// 获取修改的信息
	getupp();
	// 删除
	delEmbroider();

}

function addEmbroider() {
	$("#addEmbroider").click(function() {
		var company = $("#company").val();
		var date = $("#edate").val();
		var girard = $("#girard").val();
		var fabric = $("#fabric").val();
		var code52= $("#code52").val() == "" ? 0 : $("#code52").val();
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

		$.ajax({
			url : '/getEmbroider/addembroider.do',
			datatype : 'json',
			type : 'post',
			data : {
				company : company,
				edate : date,
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
				code170 : code170
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
		var eid = $(this).parent().parent().find("input").val();
		if (confirm('确定要删除此条数据吗?')) {
			$.ajax({
				url : '/getEmbroider/delembroider.do',
				dataType : 'json',
				type : 'post',
				data : {
					eid : eid
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
		$("#eid").val($(this).parent().parent().find("input").val());
		$("#ucompany").val($(this).parent().parent().find("td:eq(0)").text());
		$("#udate").val($(this).parent().parent().find("td:eq(1)").text());
		$("#ugirard").val($(this).parent().parent().find("td:eq(2)").text());
		$("#ufabric").val($(this).parent().parent().find("td:eq(3)").text());
		$("#ucode52").val($(this).parent().parent().find("td:eq(4)").text());
		$("#ucode1").val($(this).parent().parent().find("td:eq(5)").text());
		$("#ucode2").val($(this).parent().parent().find("td:eq(6)").text());
		$("#ucode3").val($(this).parent().parent().find("td:eq(7)").text());
		$("#ucode4").val($(this).parent().parent().find("td:eq(8)").text());
		$("#ucode5").val($(this).parent().parent().find("td:eq(9)").text());
		$("#ucode6").val($(this).parent().parent().find("td:eq(10)").text());
		$("#ucode110").val($(this).parent().parent().find("td:eq(11)").text());
		$("#ucode120").val($(this).parent().parent().find("td:eq(12)").text());
		$("#ucode130").val($(this).parent().parent().find("td:eq(13)").text());
		$("#ucode160").val($(this).parent().parent().find("td:eq(14)").text());
		$("#ucode170").val($(this).parent().parent().find("td:eq(15)").text());
	});

}
// 修改
function uppEmdroider() {
	$("#uppEmbroider").click(function() {
		var id = $("#eid").val();
		var company = $("#ucompany").val();
		var date = $("#udate").val();
		var girard = $("#ugirard").val();
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
		$.ajax({
			url : '/getEmbroider/uppembroider.do',
			dataType : 'json',
			type : 'post',
			data : {
				eid : id,
				company : company,
				girard : girard,
				fabric : fabric,
				edate : date,
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
				code170 : code170
			},
			success : function(data) {
				loadPageDatas($(".laypage_curr").text());
			}
		});
	});

}

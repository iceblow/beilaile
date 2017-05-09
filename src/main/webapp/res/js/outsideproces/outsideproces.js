/**
 * 外加工各款明细表
 */
$(function() {
	// 重复
	getDistinct();
	// 分页
	loadPageDatas(1);
	// 模糊查询
	OutsideProcesBylike();
	// 修改
	uppProce();

	$("#add").click(function() {
		$("#girard").val("");
		$("#bnumber").val("");
		$("#category").val("");
		$("#workprice").val("");
		$("#cpprice").val("");
		$("#remark").val("");
		$("#hejia").val("");
	});
});

function getProces(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, op) {
						if (op.bnumber == null) {
							op.bnumber = 0;
						}
						if (op.remark == null) {
							op.remark = " ";
						}
						$("tbody")
								.append(
										"<tr>"
												+ "<input type='hidden' class='bid' value='"
												+ op.bid
												+ "'/>"
												+ "<td style='text-align: center;'>"
												+ op.girard
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ op.bnumber
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ op.category
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ op.workprice
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ op.cpprice
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ op.remark
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ op.hejia
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ op.bdate
												+ "</td>"
												+ "<td style='text-align: center;'><a class='delProce'  href='javascript:;'>删除</a></td>"
												+ "<td style='text-align: center;'><a data-toggle='modal' data-target='#myModal1' class='uppProce' href='javascript:;'>修改</a></td></tr>");

					});
	// 获取修改的值
	getupp();
	// 删除
	delProce();
}
// 检查
function getDistinct() {
	$("#addProce").click(function() {
		var girard = $("#girard").val().toUpperCase();// 波次
		var bnumber = $("#bnumber").val();// 件数
		var category = $("#category").val();// 类别
		var workprice = $("#workprice").val();// 加工外发总价
		var cpprice = $("#cpprice").val();// 裁片外发总价
		var remark = $("#remark").val();// 备注
		var hejia = $("#hejia").val();// 核价人
		$.ajax({
			url : '/outsideproces/getDistinct.do',
			dataType : 'json',
			type : 'post',
			data : {
				girard : girard,
				bnumber : bnumber,
				category : category,
				workprice : workprice,
				cpprice : cpprice,
				remark : remark,
				hejia : hejia
			},
			success : function(data) {
				loadPageDatas(1);
			}
		});
	});
}

// 给修改框赋值
function getupp() {
	$(".uppProce").bind(
			"click",
			function() {
				$("#ugirard").val(
						$(this).parent().parent().find("td:eq(0)").text());
				$("#ubnumber").val(
						$(this).parent().parent().find("td:eq(1)").text());
				$("#ucategory").val(
						$(this).parent().parent().find("td:eq(2)").text());
				$("#uworkprice").val(
						$(this).parent().parent().find("td:eq(3)").text());
				$("#ucpprice").val(
						$(this).parent().parent().find("td:eq(4)").text());
				$("#uremark").val(
						$(this).parent().parent().find("td:eq(5)").text());
				$("#uhejia").val(
						$(this).parent().parent().find("td:eq(6)").text());
				$("#bid").val($(this).parent().parent().find("input").val());

				// alert($(this).parent().parent().find("input").val());
			});
}

function uppProce() {
	$("#uppOutsideproce").click(function() {
		var id = $("#bid").val();
		var ugirard = $("#ugirard").val().toUpperCase();
		var ubnumber = $("#ubnumber").val();
		var ucategory = $("#ucategory").val();
		var uworkprice = $("#uworkprice").val();
		var ucpprice = $("#ucpprice").val();
		var uremark = $("#uremark").val();
		var uhejia = $("#uhejia").val();
		// alert(uworkprice);
		$.ajax({
			url : '/outsideproces/uppProce.do',
			dataType : 'json',
			type : 'post',
			data : {
				bid : id,
				girard : ugirard,
				bnumber : ubnumber,
				category : ucategory,
				workprice : uworkprice,
				cpprice : ucpprice,
				remark : uremark,
				hejia : uhejia
			},
			async : false,
			success : function(mydata) {
				loadPageDatas($(".laypage_curr").text());
			}

		});
	});

}

// 分页
function loadPageDatas(index) {
	// 处理后的数据
	firstLoadData("/outsideproces/outsideProcesBylike.do?girard=" + "", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	getProces(mydata);
}
// 模糊查询
function OutsideProcesBylike() {
	$("#checkbtn").click(
			function() {
				var girard = $("#checkByGirard").val();
				firstLoadData("/outsideproces/outsideProcesBylike.do?girard="
						+ girard, 1);
				$("#checkByGirard").val("");
			});
}
// 删除
function delProce() {
	$(".delProce").bind("click", function() {
		var id = $(this).parent().parent().find("input").val();
		$.ajax({
			url : '/outsideproces/delProce.do',
			datatype : 'json',
			type : 'post',
			data : {
				bid : id
			},
			success : function(data) {
				loadPageDatas($(".laypage_curr").text().trim());
				alert("删除成功！！");
			}
		});
	});
}

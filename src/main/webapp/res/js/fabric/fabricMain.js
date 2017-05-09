$(function() {

	// 分页查询的方法
	loadPageDatas(1)

	YZ();

	// 提交按钮点击事件
	addSub();

	// 修改按钮点击事件
	myupdate();

	// 查询方法
	select();

});

// 进入后台进行分页查询
function loadPageDatas(index) {

	// 处理后的数据
	firstLoadData($("#path").val() + "/fabric/getByPage.do", index);

}
// 分页查询以后前台页面打印
function loadData(mydata) {

	// B种打印方式--打印处理后的数据
	testB(mydata);
}

function testB(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, xx) {
						var consumptions = xx.consumption;
						var companys = xx.company;

						var cons = consumptions.split("/");// 分割为一个数组
						var coms = companys.split("/");
						var ids = xx.id.split("/");

						var b_id = "<td>" + xx.b_id + "</td>";// 打印的波次号
						var fabric = "<td>" + xx.fabric + "</td>";// 打印的用料名称
						var date = "<td>" + (xx.date == null ? '' : xx.date)
								+ "</td>";// 打印的用料名称
						var consumption = "";// 打印的用料量
						var mytime = "<td>"
								+ (xx.mytime == null ? '' : xx.mytime)
								+ "</td>";

						var design_img = xx.design_img == null? "<td></td>"
								: "<td><img src=" + xx.design_img + " width='120px' height='90px'></td>"
						// 对用料量进行赋值
						for (var i = 0; i < 20; i++) {
							if (cons[i] == null || cons[i].length == 0) {
								consumption = consumption + "<td></td>"
							} else {
								consumption = consumption
										+ "<td><input type='hidden' class='myid' value='"
										+ ids[i]
										+ "'><a data-toggle='modal' data-target='#myModal1' href='javascript:;' class='myupdate'><span class='myconsumption'>"
										+ cons[i]
										+ "</span>/<span class='mycompany'>"
										+ coms[i] + "</span> </a> </td>";
							}
						}

						$("tbody").append(
								"<tr>" + date + b_id + fabric + consumption
										+ mytime + design_img + "</tr>");
					});

	update();
}

function update() {
	$(".update").click(
			function() {

				var company = $(this).parent().parent().find("td:eq(4)").text()
						.trim();

				$("#id").val(
						$(this).parent().parent().find("td:eq(0)").text()
								.trim());
				$("#b_id").val(
						$(this).parent().parent().find("td:eq(1)").text()
								.trim());
				$("#fabric").val(
						$(this).parent().parent().find("td:eq(2)").text()
								.trim());
				$("#consumption").val(
						$(this).parent().parent().find("td:eq(3)").text()
								.trim());
				$("input[value='" + company + "']").prop("checked", "checked");

			});

	$(".myupdate").click(
			function() {

				company = $(this).find(".mycompany").text().trim();
				$("#b_id").val(
						$(this).parent().parent().find("td:eq(1)").text()
								.trim());
				$("#fabric").val(
						$(this).parent().parent().find("td:eq(2)").text()
								.trim());
				$("#consumption").val(
						$(this).find(".myconsumption").text().trim());

				$("input[value='" + company + "']").prop("checked", "checked");
				$("#id").val($(this).parent().find(".myid").val().trim());
				$("#date").val(
						$(this).parent().parent().find("td:eq(0)").text()
								.trim());
			});

}

var addType = 1;
var updateType = 1;

// 绑定验证事件
function YZ() {
	// -----------------添加
	// 添加按钮点击事件
	$("#add").click(function() {
		addType = 0;
		$("#b_ids").val("");
		$(".fabrics").val("");
		$(".consumptions").val("");
		YZadd();
	});
	$("#b_ids").blur(function() {
		addType = 1;
		YZadd();
	});
	$(".fabrics").blur(function() {
		addType = 1;
		YZadd();
	});
	$(".consumptions").blur(function() {
		addType = 1;
		YZadd();
	});

	// -----------------修改
	$(".myupdate").click(function() {
		updateType = 0;
		YZupdate();
	});
	$("#b_id").blur(function() {
		updateType = 1;
		YZupdate();
	});
	$("#fabric").blur(function() {
		updateType = 1;
		YZupdate();
	});
	$("#consumption").blur(function() {
		updateType = 1;
		YZupdate();
	});

}

// 添加模态框的验证事件
function YZadd() {
	if ($("#b_ids").val().trim().length == 0) {
		$("#addSub").attr("disabled", true);
		return;
	} else if ($(".fabrics").val().trim().length == 0) {
		$("#addSub").attr("disabled", true);
		return;
	} else if ($(".consumptions").val().trim().length == 0) {
		$("#addSub").attr("disabled", true);
		return;
	} else {
		$("#addSub").attr("disabled", false);
		return;
	}
}

// 修改模态框做的验证
function YZupdate() {

	if ($("#b_id").val().trim().length == 0) {
		$("#updateSub").attr("disabled", true);
		if (updateType == 1) {
			layer.tips('请输入波次号', '#b_id');
		}
		return;
	} else if ($("#fabric").val().trim().length == 0) {
		$("#updateSub").attr("disabled", true);
		if (updateType == 1) {
			layer.tips('请输入面料', '#fabric');
		}
		return;
	} else if ($("#consumption").val().trim().length == 0) {
		$("#updateSub").attr("disabled", true);
		if (updateType == 1) {
			layer.tips('请输入用量', '#consumption');
		}
		return;
	} else {
		$("#updateSub").attr("disabled", false);
	}
}

var id = 1

// 添加输入记录
function zjadd() {

	id = id + 1

	$(".mydiv")
			.last()
			.after(
					"<div id="
							+ id
							+ " class='mydiv' style='float: left;'>"
							+ "<div class='col-md-6' style='float: left;'>"
							+ "<label for='fabric'>面料名称</label> "
							+ "<input type='text' class='form-control fabrics' name='fabric'>"
							+ "</div>"
							+ "<div class='col-md-6' style='float: left;'>"
							+ "<label for='consumption'>用量</label>"
							+ "<input type='text' class='form-control consumptions' name='consumption' onkeyup='value=value.replace(/[^\d.]/g,'')'>"
							+ "</div> "
							+ "<div class='col-md-6' style='float: right;'> "
							+ "<input type='radio' class='company' name='company"
							+ id
							+ "' value='kg' checked='checked'>kg "
							+ "<input type='radio' class='company' name='company"
							+ id + "' value='M'>M " + "</div> </div>");

	YZ();
}

// 提交添加点击事件
function addSub() {
	$("#addSub").click(function() {
		var num = $("#div > div").last().attr("id");
		// -------------------------------------------------
		// 此处拼接数据
		var b_ids = "";
		var fabrics = "";
		var consumptions = "";
		var companys = "";
		var dates = "";

		for (var i = 1; i <= num; i++) {

			var b_id = $("#b_ids").val();
			var fabric = $("#" + i + " > div > .fabrics").val();
			var consumption = $("#" + i + "> div > .consumptions").val();
			var company = $("#" + i + " > div > input:radio:checked").val();
			var date = $("#dates").val();

			b_ids = b_ids + b_id + "/";
			fabrics = fabrics + fabric + "/";
			consumptions = consumptions + consumption + "/";
			companys = companys + company + "/";
			dates = dates + date + "!"
		}

		// -------------------------------------------------

		$.ajax({
			url : '/fabric/add.do',
			dataType : 'json',
			type : 'post',
			async : false,
			data : {
				b_ids : b_ids,
				fabrics : fabrics,
				consumptions : consumptions,
				companys : companys,
				dates : dates,
			},
			error : function(mydata) {
				loadPageDatas(1);
			}
		});
	});
}

function myupdate() {
	$("#updateSub").click(function() {
		var page = $(".laypage_curr").text().trim();

		var id = $("#id").val().trim();
		var b_id = $("#b_id").val().trim();
		var fabric = $("#fabric").val().trim();
		var consumption = $("#consumption").val().trim();
		var asd = $("input[name='company']:checked").val();
		var date = $("#date").val();

		$.ajax({
			url : '/fabric/update.do',
			dataType : 'json',
			type : 'post',
			data : {
				id : id,
				b_id : b_id,
				fabric : fabric,
				consumption : consumption,
				company : asd,
				date : date
			},
			error : function() {
				loadPageDatas(page);
			}
		});

	});
}

// 删除事件
function del() {

	var fid = $("#id").val();
	var page = $(".laypage_curr").text();
	// 执行删除方法并返回当前页面
	$.ajax({
		url : '/fabric/delete.do',
		dataType : 'json',
		type : 'post',
		data : {
			id : fid
		},
		error : function(mydata) {
			loadPageDatas(page);
		}
	});
}

// 查询方法
function select() {
	$("#selSub").click(
			function() {
				// 获取波次号输入框的值
				var bid = $("#selBid").val();

				// 根据波次号进行分页查询
				firstLoadData($("#path").val() + "/fabric/getAllByBid.do?bid="
						+ bid, 1);

				// 每次查询完了以后要把输入框清空
				$("#selBid").val("");
			});
}

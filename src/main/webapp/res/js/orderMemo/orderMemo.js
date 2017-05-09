$(function() {

	// 分页查询的方法
	loadPageDatas(1);

	// 添加验证方法
	myadd();
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	firstLoadData($("#path").val() + "/orderMemo/getAllByPage.do", index);

}
// 分页查询以后前台页面打印
function loadData(mydata) {

	// 调用打印方法
	test(mydata);

}
//打印数据
function test(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, xx) {
						var id = "<td class='id'>" + xx.id + "</td>"
						var date = "<td class='date'>" + xx.date + "</td>"
						var consigneeMan = "<td class='consigneeMan'>"
								+ xx.consigneeMan + "</td>"
						var b_id = "<td class='b_id'>" + xx.b_id + "</td>"
						var color = "<td class='color'>" + xx.color + "</td>"
						var g0 = "<td class='g0'>" + xx.g0 + "</td>"
						var g1 = "<td class='g1'>" + xx.g1 + "</td>"
						var g2 = "<td class='g2'>" + xx.g2 + "</td>"
						var g3 = "<td class='g3'>" + xx.g3 + "</td>"
						var g4 = "<td class='g4'>" + xx.g4 + "</td>"
						var g5 = "<td class='g5'>" + xx.g5 + "</td>"
						var g6 = "<td class='g6'>" + xx.g6 + "</td>"
						var g7 = "<td class='g7'>" + xx.g7 + "</td>"
						var g8 = "<td class='g8'>" + xx.g8 + "</td>"
						var g9 = "<td class='g9'>" + xx.g9 + "</td>"
						var g10 = "<td class='g10'>" + xx.g10 + "</td>"
						var g11 = "<td class='g11'>" + xx.g11 + "</td>"
						var g_num = "<td class='g_num'>" + xx.g_num + "</td>"
						var horse = "<td class='horse'>" + xx.horse + "</td>"

						var append = $("tbody")
								.append("<tr>"+ id
												+ date
												+ consigneeMan
												+ b_id
												+ color
												+ g0
												+ g1
												+ g2
												+ g3
												+ g4
												+ g5
												+ g6
												+ g7
												+ g8
												+ g9
												+ g10
												+ g11
												+ g_num
												+ horse
												+ "<td style='text-align: center;'><a href='javascript:;' class='del'>删除</a>|<a data-toggle='modal' data-target='#myModal1' href='javascript:;' class='update'>修改</a></td></tr>");

					});
	myupdate();
	del();
}

// 添加方法验证
function myadd() {
	// 将当前系统时间赋值给日期文本框
	$("#add").click(function() {
		var date = new Date();
		var t = date.toLocaleDateString(); // 获取当前日期
		$("#date").val(t);

		// 清空每个表格
		$("#consigneeMan").val("");
		$("#b_id").val("");
		$("#color").val("");
		$("#g0").val("");
		$("#g1").val("");
		$("#g2").val("");
		$("#g3").val("");
		$("#g4").val("");
		$("#g5").val("");
		$("#g6").val("");
		$("#g7").val("");
		$("#g8").val("");
		$("#g9").val("");
		$("#g10").val("");
		$("#g11").val("");
		$("#g_num").val("");
		$("#horse").val("");

	});
	$("#addSub").click(function() {
		//点击提交的时候获取每个输入框的值
		var date = $("#date").val();
		var consigneeMan = $("#consigneeMan").val();
		var b_id = $("#b_id").val();
		var color = $("#color").val();
		var g0 = $("#g0").val();
		var g1 = $("#g1").val();
		var g2 = $("#g2").val();
		var g3 = $("#g3").val();
		var g4 = $("#g4").val();
		var g5 = $("#g5").val();
		var g6 = $("#g6").val();
		var g7 = $("#g7").val();
		var g8 = $("#g8").val();
		var g9 = $("#g9").val();
		var g10 = $("#g10").val();
		var g11 = $("#g11").val();
		var g_num = $("#g_num").val();
		var horse = $("#horse").val();
		// 进入后台添加数据
		$.ajax({
			url : '/orderMemo/add.do',
			dataType : 'json',
			type : 'post',
			async : false,
			data : {
				date : date,
				consigneeMan : consigneeMan,
				b_id : b_id,
				color : color,
				g0 : g0,
				g1 : g1,
				g2 : g2,
				g3 : g3,
				g4 : g4,
				g5 : g5,
				g6 : g6,
				g7 : g7,
				g8 : g8,
				g9 : g9,
				g10 : g10,
				g11 : g11,
				g_num : g_num,
				horse : horse
			},
			success : function(mydata) {
				if (mydata == 1) {
					alert("添加成功");
					loadPageDatas(1);
				}
			}
		});
	});
}
// 添加合计计算
function getNum() {

	var g0 = $("#g0").val();
	var g1 = $("#g1").val();
	var g2 = $("#g2").val();
	var g3 = $("#g3").val();
	var g4 = $("#g4").val();
	var g5 = $("#g5").val();
	var g6 = $("#g6").val();
	var g7 = $("#g7").val();
	var g8 = $("#g8").val();
	var g9 = $("#g9").val();
	var g10 = $("#g10").val();
	var g11 = $("#g11").val();
	var g_num = (g0 - 0) + (g1 - 0) + (g2 - 0) + (g3 - 0) + (g4 - 0) + (g5 - 0)
			+ (g6 - 0) + (g7 - 0) + (g8 - 0) + (g9 - 0) + (g10 - 0) + (g11 - 0);
	$("#g_num").val(g_num);

}
// 修改合计计算
function getNums() {

	var g0 = $("#g0s").val().trim();
	var g1 = $("#g1s").val().trim();
	var g2 = $("#g2s").val().trim();
	var g3 = $("#g3s").val().trim();
	var g4 = $("#g4s").val().trim();
	var g5 = $("#g5s").val().trim();
	var g6 = $("#g6s").val().trim();
	var g7 = $("#g7s").val().trim();
	var g8 = $("#g8s").val().trim();
	var g9 = $("#g9s").val().trim();
	var g10 = $("#g10s").val().trim();
	var g11 = $("#g11s").val().trim();
	var g_num = (g0 - 0) + (g1 - 0) + (g2 - 0) + (g3 - 0) + (g4 - 0) + (g5 - 0)
			+ (g6 - 0) + (g7 - 0) + (g8 - 0) + (g9 - 0) + (g10 - 0) + (g11 - 0);

	$("#g_nums").val(g_num);

}

function myupdate() {
	$(".update")
			.click(
					function() {
						// 给每个表格赋值
						$("#ids").val(
								$(this).parent().parent().find(".id").text().trim());
						
						if($(this).parent().parent().find(".date")
								.text().trim().length==0){
							var date = new Date();
							var t = date.toLocaleDateString(); // 获取当前日期
							$("#dates").val(t);
							
						}else{
							$("#dates").val($(this).parent().parent().find(".date")
									.text().trim())
						}
						
						$("#consigneeMans").val(
								$(this).parent().parent().find(".consigneeMan")
										.text().trim());
						$("#b_ids").val(
								$(this).parent().parent().find(".b_id").text().trim());
						$("#colors")
								.val(
										$(this).parent().parent()
												.find(".color").text().trim());
						$("#g0s").val(
								$(this).parent().parent().find(".g0").text().trim());
						$("#g1s").val(
								$(this).parent().parent().find(".g1").text().trim());
						$("#g2s").val(
								$(this).parent().parent().find(".g2").text().trim());
						$("#g3s").val(
								$(this).parent().parent().find(".g3").text().trim());
						$("#g4s").val(
								$(this).parent().parent().find(".g4").text().trim());
						$("#g5s").val(
								$(this).parent().parent().find(".g5").text().trim());
						$("#g6s").val(
								$(this).parent().parent().find(".g6").text().trim());
						$("#g7s").val(
								$(this).parent().parent().find(".g7").text().trim());
						$("#g8s").val(
								$(this).parent().parent().find(".g8").text().trim());
						$("#g9s").val(
								$(this).parent().parent().find(".g9").text().trim());
						$("#g10s").val(
								$(this).parent().parent().find(".g10").text().trim());
						$("#g11s").val(
								$(this).parent().parent().find(".g11").text().trim());
						$("#g_nums")
								.val(
										$(this).parent().parent()
												.find(".g_num").text().trim());
						$("#horses")
								.val(
										$(this).parent().parent()
												.find(".horse").text().trim());
					});
	$("#updateSub").click(function() {
		var id = $("#ids").val()
		var date = $("#dates").val();
		var consigneeMan = $("#consigneeMans").val();
		var b_id = $("#b_ids").val();
		var color = $("#colors").val();
		var g0 = $("#g0s").val();
		var g1 = $("#g1s").val();
		var g2 = $("#g2s").val();
		var g3 = $("#g3s").val();
		var g4 = $("#g4s").val();
		var g5 = $("#g5s").val();
		var g6 = $("#g6s").val();
		var g7 = $("#g7s").val();
		var g8 = $("#g8s").val();
		var g9 = $("#g9s").val();
		var g10 = $("#g10s").val();
		var g11 = $("#g11s").val();
		var g_num = $("#g_nums").val();
		var horse = $("#horses").val();

		var page = $(".laypage_curr").text().trim();

		$.ajax({
			url : '/orderMemo/update.do',
			dataType : 'json',
			type : 'post',
			async : false,
			data : {
				id : id,
				date : date,
				consigneeMan : consigneeMan,
				b_id : b_id,
				color : color,
				g0 : g0,
				g1 : g1,
				g2 : g2,
				g3 : g3,
				g4 : g4,
				g5 : g5,
				g6 : g6,
				g7 : g7,
				g8 : g8,
				g9 : g9,
				g10 : g10,
				g11 : g11,
				g_num : g_num,
				horse : horse
			},
			success : function(mydata) {
				if (mydata == 1) {
					loadPageDatas(page);
				}
			}
		});
	});
}


function del(){
	 //假删除
	$(".del").click(function(){
		var id=$(this).parent().parent().find(".id").text().trim();
		//获取当前页数
		var page = $(".laypage_curr").text().trim();
		$.ajax({
			url : '/orderMemo/fakeDel.do',
			dataType : 'json',
			type : 'post',
			async : false,
			data : {
				id : id,
			},
			success:function(mydata) {
				if(mydata==1){
					 //删除成功以后直接刷新当前页
					loadPageDatas(page);
				}
			}
		});
	});
}
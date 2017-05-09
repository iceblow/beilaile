/**
 * 浩迅入库
 */
$(function() {
	// 分页
	loadPageDatas(1);
	// 模糊查询
	SalesNotSaleHaoXunBylike();
});

// 模糊查询
var mySelectForm = "";
function SalesNotSaleHaoXunBylike() {
	$("#checkbtn").on("click", function() {
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData("SalesNotSaleHaoXun/getDataByPage.do?" + mySelectForm, 1);
		$("#mySelect_From>input").val("");
	});
}

// 分页
function loadPageDatas(index) {
	// 处理后的数据inputstorage
	firstLoadData($("#path").val() + "/SalesNotSaleHaoXun/getDataByPage.do",
			index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	Inputstorage(mydata);
}
function Inputstorage(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, a) {
						var product_code = a.product_code == null
								|| a.product_code == "" ? "<td></td>" : "<td>"
								+ a.product_code + "</td>";
						var product_img = a.product_img == null
								|| a.product_img == "" ? "<td></td>"
								: "<td><img src='" + a.product_img
										+ "' width='100px' height='80px'></td>";
						var deliveryDate = a.deliveryDate == null
								|| a.deliveryDate == "" ? "<td></td>" : "<td>"
								+ a.deliveryDate + "</td>";
						var artNo = a.artNo == null || a.artNo == "" ? "<td></td>"
								: "<td>" + a.artNo + "</td>";
						var season = a.season == null || a.season == "" ? "<td></td>"
								: "<td>" + a.season + "</td>";
						var series = a.series == null || a.series == "" ? "<td></td>"
								: "<td>" + a.series + "</td>";
						var wave = a.wave == null || a.wave == "" ? "<td></td>"
								: "<td>" + a.wave + "</td>";
						var num = a.num == null || a.num == "" ? "<td></td>"
								: "<td>" + a.num + "</td>";
						var code52 = a.code52 == null || a.code52 == "" ? "<td></td>"
								: "<td>" + a.code52 + "</td>";
						var code59 = a.code59 == null || a.code59 == "" ? "<td></td>"
								: "<td>" + a.code59 + "</td>";
						var code66 = a.code66 == null || a.code66 == "" ? "<td></td>"
								: "<td>" + a.code66 + "</td>";
						var code73 = a.code73 == null || a.code73 == "" ? "<td></td>"
								: "<td>" + a.code73 + "</td>";
						var code80 = a.code80 == null || a.code80 == "" ? "<td></td>"
								: "<td>" + a.code80 + "</td>";
						var code90 = a.code90 == null || a.code90 == "" ? "<td></td>"
								: "<td>" + a.code90 + "</td>";
						var code100 = a.code100 == null || a.code100 == "" ? "<td></td>"
								: "<td>" + a.code100 + "</td>";
						var code110 = a.code110 == null || a.code110 == "" ? "<td></td>"
								: "<td>" + a.code110 + "</td>";
						var code120 = a.code120 == null || a.code120 == "" ? "<td></td>"
								: "<td>" + a.code120 + "</td>";
						var code130 = a.code130 == null || a.code130 == "" ? "<td></td>"
								: "<td>" + a.code130 + "</td>";
						var code160 = a.code160 == null || a.code160 == "" ? "<td></td>"
								: "<td>" + a.code160 + "</td>";
						var code170 = a.code170 == null || a.code170 == "" ? "<td></td>"
								: "<td>" + a.code170 + "</td>";
						$("tbody").append(
								"<tr>" + product_code + product_img
										+ deliveryDate + artNo + season
										+ series + wave + num + code52 + code59
										+ code66 + code73 + code80 + code90
										+ code100 + code110 + code120 + code130
										+ code160 + code170 + "</tr>");
					});
}
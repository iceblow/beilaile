$(function() {

	// 分页查询的方法
	loadPageDatas(1);

	addProdrct();
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	firstLoadData($("#path").val() + "/salesSlowMovingStock/getAllByPage.do",
			index);

}

// 分页查询以后前台页面打印
function loadData(mydata) {

	// 调用打印方法
	test(mydata);

}
// 打印数据
function test(mydata) {
	$("tbody").empty();
	$.each(mydata,
			function(index, xx) {
				var ALIAE_CODE = xx.aliae_CODE == null ? "<td></td>" : "<td align='center'>"
						+ xx.aliae_CODE + "</td>";
				var PRODUCT_CODE = xx.product_CODE == null ? "<td></td>"
						: "<td align='center'><a href='productInfo.html?"+xx.product_CODE+"' target='_blank'><font color='blue'>" + xx.product_CODE + "</font></a></td>";
				var STOCK_NUM = xx.stock_NUM == null ? "<td></td>" : "<td align='center'>"
						+ xx.stock_NUM + "</td>";
				var SALES_TOTAL = xx.sales_TOTAL == null ? "<td></td>" : "<td align='center'>"
						+ xx.sales_TOTAL + "</td>";
				var PRODUCT_IMG = xx.product_IMG == null
						|| xx.product_IMG == "" ? "<td></td>" : "<td align='center'><img src='"
						+ xx.product_IMG + "' width='120px' height='80px'></td>";
				var REPORT_DATE = xx.report_DATE == null ? "<td></td>" : "<td align='center'>"
						+ xx.report_DATE + "</td>";

				var append = $("tbody").append(
						"<tr>" + ALIAE_CODE + PRODUCT_CODE + STOCK_NUM
								+ SALES_TOTAL + PRODUCT_IMG + REPORT_DATE
								+ "</tr>");
			});
}

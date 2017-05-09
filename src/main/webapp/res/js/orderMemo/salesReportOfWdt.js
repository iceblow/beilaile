$(function() {

	// 分页查询的方法
	loadPageDatas(1);

	addProdrct();
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	firstLoadData($("#path").val() + "/salesReportOfWdt/getAllByPage.do", index);

}

// 分页查询以后前台页面打印
function loadData(mydata) {

	// 调用打印方法
	test(mydata);

}
// 打印数据
function test(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, xx) {

						var ALIAE_CODE = xx.aliae_CODE == null ? "<td></td>"
								: "<td>" + xx.aliae_CODE + "</td>";
						var PORUDCT_CODE = xx.product_CODE == null ? "<td></td>"
								: "<td>" + xx.product_CODE + "</td>";
						var PRODUCT_NAME = xx.product_NAME == null ? "<td></td>"
								: "<td>" + xx.product_NAME + "</td>";
						var STOCK_NUM = xx.stock_NUM == null ? "<td></td>"
								: "<td>" + xx.stock_NUM + "</td>";
						var SALES_7DAYS = xx.sales_7DAYS == null ? "<td></td>"
								: "<td>" + xx.sales_7DAYS + "</td>";
						var SALES_14DAYS = xx.sales_14DAYS == null ? "<td></td>"
								: "<td>" + xx.sales_14DAYS + "</td>";
						var SALES_30DAYS = xx.sales_30DAYS == null ? "<td></td>"
								: "<td>" + xx.sales_30DAYS + "</td>";
						var SALES_TATOAL = xx.sales_TATOAL == null ? "<td></td>"
								: "<td>" + xx.sales_TATOAL + "</td>";
						var SALES_7DAYS_AVERAGE = xx.sales_7DAYS_AVERAGE == null ? "<td></td>"
								: "<td>" + xx.sales_7DAYS_AVERAGE + "</td>";
						var SALES_14DAYS_AVERAGE = xx.sales_14DAYS_AVERAGE == null ? "<td></td>"
								: "<td>" + xx.sales_14DAYS_AVERAGE + "</td>";
						var SALES_30DAYS_AVERAGE = xx.sales_30DAYS_AVERAGE == null ? "<td></td>"
								: "<td>" + xx.sales_30DAYS_AVERAGE + "</td>";
						var SALE_DAYS_WITH_7D = xx.sale_DAYS_WITH_7D == null ? "<td></td>"
								: "<td>" + xx.sale_DAYS_WITH_7D + "</td>";
						var SALE_DAYS_WITH_14D = xx.sale_DAYS_WITH_14D == null ? "<td></td>"
								: "<td>" + xx.sale_DAYS_WITH_14D + "</td>";
						var SALE_DAYS_WITH_30D = xx.sale_DAYS_WITH_30D == null ? "<td></td>"
								: "<td>" + xx.sale_DAYS_WITH_30D + "</td>";
						var PRODUCT_IMG = xx.product_IMG == null
								|| xx.product_IMG == "" ? "<td></td>"
								: "<td><img src='" + xx.product_IMG
										+ "' width='100px' height='80px'></td>";

						var append = $("tbody")
								.append(
										"<tr>"
												+ ALIAE_CODE
												+ PORUDCT_CODE
												+ PRODUCT_NAME
												+ STOCK_NUM
												+ SALES_7DAYS
												+ SALES_14DAYS
												+ SALES_30DAYS
												+ SALES_TATOAL
												+ SALES_7DAYS_AVERAGE
												+ SALES_14DAYS_AVERAGE
												+ SALES_30DAYS_AVERAGE
												+ SALE_DAYS_WITH_7D
												+ SALE_DAYS_WITH_14D
												+ SALE_DAYS_WITH_30D
												+ PRODUCT_IMG
												+ "<td align='center'><a data-toggle='modal' data-target='#myModal' href='javascript:;' class='toback'><button class='btn btn-default' data-dismiss='modal'>返单</button></a></td></tr>");
					});
	getProduct();
}

// 获取
function getProduct() {
	$(".toback").unbind('click').bind("click", function() {
		var codes = $(this).parent().parent().find("td:eq(1)").text();
		if (codes == "") {
			alert("商品编号为空   无法查询");
			return;
		}
		$("input").val("");
		$.ajax({
			url : $("#path").val() + '/salesReportOfWdt/getOneByCodes.do',
			dataType : 'json',
			type : 'post',
			data : {
				codes : codes
			},
			success : function(data) {

				$("#girardOld").val(data.wave);
				$("#productCodes").val(data.productCodes);
				$("#productName").val(data.productName);
				$("#productShortName").val(data.productShortName);
				$("#excleFile").val(data.excleFile);
				$("#productImg").val(data.productImg);
				$("#productOldName").val(data.productOldName);
			}
		});
	});
}

// 添加
function addProdrct() {
	$("#addSub").click(function() {
		var girard = $("#girard").val();
		var code52 = $("#code52").val() == "" ? 0 : $("#code52").val();
		var code59 = $("#code59").val() == "" ? 0 : $("#code59").val();
		var code66 = $("#code66").val() == "" ? 0 : $("#code66").val();
		var code73 = $("#code73").val() == "" ? 0 : $("#code73").val();
		var code80 = $("#code80").val() == "" ? 0 : $("#code80").val();
		var code90 = $("#code90").val() == "" ? 0 : $("#code90").val();
		var time = $("#expectTime").val();
		var girardOld = $("#girardOld").val();
		var codes = $("#productCodes").val();
		var name = $("#productName").val();
		var shortName = $("#productShortName").val();
		var excle = $("#excleFile").val();
		var Img = $("#productImg").val();
		var oldName = $("#productOldName").val();
		$.ajax({
			url : $("#path").val() + '/productBack/addProductBack.do',
			dataType : 'json',
			type : 'post',
			data : {
				girard : girard,
				girardOld : girardOld,
				productcodes : codes,
				productname : name,
				productoldname : oldName,
				expectTime : time,
				productshortname : shortName,
				exclefile : excle,
				productimg : Img,
				code52 : code52,
				code59 : code59,
				code66 : code66,
				code73 : code73,
				code80 : code80,
				code90 : code90
			},
			success : function(data) {
				if (data == 1) {
					alert("申请发送成功！！");
					loadPageDatas($(".laypage_curr").text());
				} else {
					alert("申请发送失败！！");
				}
			}
		});
	});
}
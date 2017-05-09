$(function() {

	// 分页查询的方法
	loadPageDatas(1);

	// 模糊查询
	mySelect();
	
	//去除空格
	dislodgeSpace();
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	firstLoadData($("#path").val() + "/purchaseOrdersDetail/getAllByPage.do",
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
	$.each(mydata, function(index, xx) {
		var wave = xx.wave == null ? "<td></td>" : "<td>" + xx.wave + "</td>";// 波次号
		var order_CODE = xx.order_CODE == null ? "<td></td>" : "<td>"
				+ xx.order_CODE + "</td>";// 订单编码
		var buyer = xx.buyer == null ? "<td></td>" : "<td>" + xx.buyer + "</td>";// 采购人
		var supplier = xx.supplier == null ? "<td></td>" : "<td>" + xx.supplier
				+ "</td>";// 供应商
		var purchase_DATE = xx.purchase_DATE == null ? "<td></td>" : "<td>"
				+ xx.purchase_DATE + "</td>";// 采购时间
		var alias_CODE = xx.alias_CODE == null ? "<td></td>" : "<td>"
				+ xx.alias_CODE + "</td>";// 商家编码
		var product_CODE = xx.product_CODE == null ? "<td></td>" : "<td>"
				+ xx.product_CODE + "</td>";// 产品编码
		var product_NAME = xx.product_NAME == null ? "<td></td>" : "<td>"
				+ xx.product_NAME + "</td>";// 产品名称
		var puchase_AMOUNT = xx.puchase_AMOUNT == null ? "<td></td>" : "<td>"
				+ xx.puchase_AMOUNT + "</td>";// 采购总数

		var append = $("tbody").append(
				"<tr>" + wave + order_CODE + buyer + supplier + purchase_DATE
						+ alias_CODE + product_CODE + product_NAME
						+ puchase_AMOUNT + "</tr>");
	});
}

var mySelectForm;
function mySelect() {
	$("#mySelect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				$(".col-md-2>input").val("");
				firstLoadData($("#path").val()
						+ "/purchaseOrdersDetail/getAllByPage.do?"
						+ mySelectForm, 1);
			});
}
//去除空格
function dislodgeSpace(){
	$(".col-md-2>input").blur(function(){
		var value=$(this).val().trim();
		$(this).val(value);
	});
}
$(function() {
	loadPageDatas(1);
	// 点击查询方法
	mySelect();
	// 修改提交方法
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	// 处理后的数据
	firstLoadData($("#path").val() + "/productTaoBaoInfo/getDataByPage.do",
			index);

}
// 查询完成,打印数据
function loadData(mydata) {

	// B种打印方式--打印处理后的数据
	testB(mydata);
}

function testB(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, x) {

						var product_name = x.product_name == null
								|| x.product_name == "" ? "<td></td>" : "<td>"
								+ x.product_name + "</td>";
						var product_img = x.product_img == null
								|| x.product_img == "" ? "<td></td>" : "<td><img src'"
								+ x.product_img + "' width='100px' height='80px'/></td>";
						var product_code = x.product_code == null
								|| x.product_code == "" ? "<td></td>" : "<td>"
								+ x.product_code + "</td>";
						var goodsId = x.goodsId == null || x.goodsId == "" ? "<td></td>"
								: "<td><a href='https://item.taobao.com/item.htm?id=" + x.goodsId + "' target='_blank'>点击!跳转淘宝链接</a></td>";
						var norms_code = x.norms_code == null
								|| x.norms_code == "" ? "<td></td>" : "<td>"
								+ x.norms_code + "</td>";
						var normsID = x.normsID == null || x.normsID == "" ? "<td></td>"
								: "<td>" + x.normsID + "</td>";
						var taobao_inventory = x.taobao_inventory == null
								|| x.taobao_inventory == "" ? "<td></td>"
								: "<td>" + x.taobao_inventory + "</td>";
						$("tbody").append(
								"<tr>" + product_name + product_img
										+ product_code + goodsId + norms_code
										+ normsID + taobao_inventory + "</tr>");
					});

}

var mySelectForm = "";
function mySelect() {
	$("#mySelectProduct").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData(
						$("#path").val()
								+ "/productTaoBaoInfo/getDataByPage.do?"
								+ mySelectForm, 1);
				$(".col-md-2>input").val("");
			});
}
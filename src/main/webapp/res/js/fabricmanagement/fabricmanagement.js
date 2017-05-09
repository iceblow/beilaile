/**
 * 裁片印绣花领料日报表
 */
$(function() {

	// 分页
	loadPageDatas(1);
	// 模糊查询
	InputstorageBylike();
	// 查询
	selFabricmanagementBywave();
});

// 分页
function loadPageDatas(index) {
	// 处理后的数据
	firstLoadData("/fabricmanagement/allfabricmanagement.do?", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	Inputstorage(mydata);
}
function Inputstorage(mydata) {
	$("tbody").empty();
	$.each(mydata, function(index, f) {
		// 加载数据
		$("tbody").append(
				"<tr>" + "<input type='hidden' class='bid' value='" + f.inputId
						+ "'/>" + "<td style='text-align: center;'>"
						+ (f.inputDate == null ? '' : f.inputDate) + "</td>"
						+ "<td style='text-align: center;'>"
						+ (f.wave == null ? '' : f.wave) + "</td>"
						+ "<td style='text-align: center;'>"
						+ (f.fabricMaterial == null ? '' : f.fabricMaterial)
						+ "</td>" + "<td style='text-align: center;'>"
						+ (f.totalPurchases == null ? '' : f.totalPurchases)
						+ "</td>" + "<td style='text-align: center;'>"
						+ (f.inputAmount == null ? '' : f.inputAmount)
						+ "</td>" + "<td style='text-align: center;'>"
						+ (f.inputGapAmount == null ? '' : f.inputGapAmount)
						+ "</td>" + "<td style='text-align: center;'>"
						+ (f.outputAmount == null ? '' : f.outputAmount)
						+ "</td>" + "<td style='text-align: center;'>"
						+ (f.gapAmount == null ? '' : f.gapAmount)
						+ "</td></tr>");
	});

}

// 模糊查询
function InputstorageBylike() {
	// 点击查询按钮进行查询
	$("#checkbtn").click(
			function() {
				// 获取文本框中的值
				var wave = $("#checkByFlag1").val();
				var fabricmaterial = $("#checkByFlag2").val();
				var inputAmount = $("#checkByFlag3").val().toUpperCase();
				var outputAmount = $("#checkByFlag4").val().toUpperCase();
				// 走分页的查询方法
				firstLoadData("/fabricmanagement/allfabricmanagement.do?wave="
						+ wave + "&fabricMaterial=" + fabricmaterial
						+ "&inputAmount=" + inputAmount + "&outputAmount="
						+ outputAmount, 1);
				// 清空输入框
				$("#checkByFlag1").val("");
				$("#checkByFlag2").val("");
				$("#checkByFlag3").val("");
				$("#checkByFlag4").val("");
			});

}
// 超链接
function selFabricmanagementBywave() {
	var url = location.href;
	var argArr = [];
	if (url) {
		console.info(url)
		var argStr = url.split("?");
		if (argStr.length > 1) {
			var arg = argStr[1].split("&");
			for (var a = 0; a < arg.length; a++) {
				var temp = arg[a].split("=");
				argArr[temp[0]] = temp[1]
			}
		}
	}
	// 查询--赋值
	for ( var a in argArr) {
		firstLoadData("/fabricmanagement/selFabricmanagementBywave.do?wave="
				+ argArr[a], 1);
	}

}

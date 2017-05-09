$(function() {
	// 分页查询的方法
	loadPageDatas(1);
	// 模糊查询
	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	firstLoadData($("#path").val() + "/boardWorksSchedule/getAllByPage.do",
			index); // 指定url
}
// 分页查询以后打印数据
function loadData(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, x) {
						var id = x.id == null || x.id == "" ? "<td></td>"
								: "<td>" + x.id + "</td>";
						var wave = x.wave == null || x.wave == "" ? "<td></td>"
								: "<td>" + x.wave + "</td>";
						var originalWave = x.originalWave == null
								|| x.originalWave == "" ? "<td></td>" : "<td>"
								+ x.originalWave + "</td>";
						var image = x.image == null || x.image == "" ? "<td></td>"
								: "<td><img src=" + x.image
										+ " width='100px' height='80px'></td>";
						var orders = x.orders == null || x.orders == "" ? "<td></td>"
								: "<td>" + x.orders + "</td>";
						var orderType = x.orderType == null
								|| x.orderType == "" ? "<td></td>" : "<td>"
								+ x.orderType + "</td>";
						var fabricStorageTime = x.fabricStorageTime == null
								|| x.fabricStorageTime == "" ? "<td></td>"
								: "<td>" + x.fabricStorageTime + "</td>";
						$("tbody").append(
								"<tr>" + id + wave + originalWave + image
										+ orders + orderType
										+ fabricStorageTime + "</tr>");
					});
}

// 查詢按鈕點擊事件
function select() {
	$("#myselect").click(
			function() {
				var mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val() + "/boardWorksSchedule/getAllByPage.do?"
						+ mySelectForm, 1); // 指定url
				$(".col-md-2>input").val("");
			});
}
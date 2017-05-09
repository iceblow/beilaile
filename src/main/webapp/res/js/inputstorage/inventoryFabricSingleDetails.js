$(function() {
	loadPageDatas(1);
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val()
			+ "/inventoryFabricSingleDetails/inventoryFabricSingleDetails.do", index); // 指定url
}
function loadData(data) {
	$("tbody").empty();
	$.each(data,function(index, x) {				
						var _HTML_TEBLE_ = "";
						_HTML_TEBLE_ = "<tr><td >"
								+ (x.sid == null ? ''
										: x.sid)
								+ "</td><td >"
								+ (x.fabricBarcode == null|| x.fabricBarcode == "" ? "<td></td>"
								:"<td><img src='" + x.fabricBarcode)
								+ "' width='100px' height='80px'></td>"
								+"<td >"
								+ (x.fabricCode == null ? ''
										: x.fabricCode)
								+ "</td><td >"
								+ (x.fabricName == null ? ''
										: x.fabricName)
								+ "</td><td >"
								+ (x.supplierName == null ? ''
										: x.supplierName)
								+ "</td><td >"
								+ (x.fabricWeight == null ? ''
										: x.fabricWeight)
								+ "</td><td >"
								+ (x.fabricUnit == null ? ''
										: x.fabricUnit)
								+ "</td><td >"
								+ (x.fabricColor == null ? ''
										: x.fabricColor)
								+ "</td><td >"
								+ (x.fabricStorageTime == null ? ''
										: x.fabricStorageTime)
								+ "</td><td >"
								+ (x.fabricOutTime == null ? ''
										: x.fabricOutTime)
								+ "</td>"	
								+ "<td>"
								+ (x.fabricAmount == null ? ''
										: x.fabricAmount)
								+ "</td><td >"
								+ (x.createTime == null ? ''
										: x.createTime)
								+ "</td>"
						$("tbody").append(_HTML_TEBLE_);					
				});
};
$(function() {
	//首页加载
	loadPageData(1);
	//点击查询
	loadPageDataByLike();

});
//要查询的数据
var myselForm = "";
// 点击查询
function loadPageDataByLike() {
	$("#checkbtn").click(function(){
		myselForm = $("#myselect_from").serialize();
		firstLoadData("productOnlineProgress/selProductOnlineProgressBypage.do?"+ myselForm, 1);// 处理后的数据
	});
}
// 首页分页查询
function loadPageData(index) {
	firstLoadData("productOnlineProgress/selProductOnlineProgressBypage.do",index);// 处理后的数据
}
// 调用数据
function loadData(data) {
	loadProductOnline(data);
}
function loadProductOnline(data) {
	$("#tbody").empty();
	$.each(data, function(index, a) {
		$("#tbody").append(
				"<tr"+(a.operationTime!=null?" style='background:aquamarine;'":'')+">" 
						+"<input type='hidden' class='id' value='"+ a.id+ "'/><td>"
						+ (a.sid == null ? "" : a.sid)
						+ "</td><td>"
						+ (a.wave == null ? "" : a.wave)
						+ "</td><td>"
						+ (a.productCode == null ? "" : a.productCode)
						+ "</td><td>"
						+ "<img src='"+ a.designImg+ "'width='50px';/>"
						+ "</td><td>"
						+ (a.storageStatus == null ? "" : a.storageStatus)
						+ "</td><td>"
						+ (a.storageTime == null ? "" : a.storageTime)
						+ "</td><td>"
						+ (a.sampleStatus == null ? "" : a.sampleStatus)
						+ "</td><td>"
						+ (a.sampleTime == null ? "" : a.sampleTime)
						+ "</td><td>"
						+ (a.photographyStatus == null ? "": a.photographyStatus) 
						+ "</td><td>"
						+ (a.photographyTime == null ? "" : a.photographyTime)
						+ "</td><td>"
						+ (a.artworkStatus == null ? "" : a.artworkStatus)
						+ "</td><td>"
						+ (a.artworkTime == null ? "" : a.artworkTime)
						+ "</td><td>"
						+ (a.operationStatus == null ? "" : a.operationStatus)
						+ "</td><td>"
						+ (a.operationTime == null ? "" : a.operationTime)
						+ "</td><td>"
						+ (a.orderGrade == null ? "" : a.orderGrade)
						+ "</td></tr>");
	});
}
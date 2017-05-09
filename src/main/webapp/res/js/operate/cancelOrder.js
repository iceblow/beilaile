/**
 * 2017-2-18 14:06:00
 */
$(function() {
	// 查询
	loadPageDatas(1);
	// 模糊查询
	loadPageDataByLike();
	//添加
	addOrder();
});
// 模糊查询
var mySelectForm = "";
function loadPageDataByLike() {
	$("#checkbtn").click(function() {
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData("cancelOrder/CancelOrderByPage.do?" + mySelectForm, 1);
		$("#mySelect_From>input").val("");
	});
};

// 分页
function loadPageDatas(index) {
	firstLoadData("cancelOrder/CancelOrderByPage.do", index);
}

// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	getapprovalApplication(mydata);
}
function getapprovalApplication(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, a) {
		var sampleImg = "";
		if (a.sampleImg != null) {
			sampleImg = "<a href='" + a.sampleImg + "' target='_blank'>工艺单</a>";
		}
		var sizeChart = "";
		if (a.sizeChart != null) {
			sizeChart = "<a href='" + a.sizeChart + "'  target='_blank'>尺码表</a>";
		}
		var status=(a.status=="1"?"<button class='btn btn-info btn-sm ' data-toggle='modal'>恢复订单</button>":
			"<button class='btn btn-danger btn-sm ' data-toggle='modal'>撤销订单</button>")
		$("tbody").append(
			"<tr><input type='hidden' class='id' value='" + a.id + "'/>"
					+ "<td style='text-align: center;'>"
					+ (a.girard == null ? "" : a.girard)
					+ "</td><td style='text-align: center;'>"
					+ (a.originalWave == null ? "" : a.originalWave)
					+ "</td><td style='text-align: center;'>"
					+ (a.designer == null ? "" : a.designer)
					+ "</td><td style='text-align: center;'>"
					+ (a.productId == null ? "" : a.productId)
					+ "</td><td style='text-align: center; width:200px;'>"
					+ (a.clothName == null ? "" : a.clothName)
					+ "</td><td style='text-align: center;'>"
					+ "<img width='50px' height='40px' src='"
					+ a.designImg
					+ "'/></td><td style='text-align: center;'>"
					+ sampleImg
					+ "</td><td style='text-align: center;'>"
					+ sizeChart
					+ "</td><td style='text-align: center;'>"
					+ (a.delOrder == null ? "" : a.delOrder)
//					+ "</td><td style='text-align: center;'>"
//					+ (a.restoreOrder == null ? "" : a.restoreOrder)
					+ "</td><td style='text-align: center;'>"
					+ (a.remark == null ? "" : a.remark) 
//					+ "</td><td style='text-align:center;'>"
//					+ status
					+"</td></tr>");
	});
}
//添加要撤销的订单
function addOrder(){
	$("#addCancelOrder").on("click",function(){
		var girard=$("#girard").val();
		var remark=$("#remark").val();
		$.ajax({
			url:"cancelOrder/addCancelOrder.do",
			type:'post',
			data:{
				girard:girard,
				remark:remark
			},
			success:function(data){
				if(data!=1){
					alert("添加失败");
				}
			firstLoadData("cancelOrder/CancelOrderByPage.do?" + mySelectForm, 1);
			clear();
			},error:function(){
				alert("添加失败，系统错误！");
			}
		});
	});
}
//清空输入框
function clear(){
	$("#girard").val("");
	$("#remark").val("");
}
//
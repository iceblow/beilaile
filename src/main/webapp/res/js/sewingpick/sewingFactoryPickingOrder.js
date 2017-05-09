/**
 * 详单表
 */
var url = location.search; //获取url中"?"符后的字串
var str = location.search.substr(1); 
$(function() {
	// 分页
	if(str.length==0){
	loadPageDatas(1);
	}else{
		firstLoadData("/SewingFactoryPickingOrder/selSewingFactoryPickingOrderBypage.do?orderId="+str, 1);
	}
	
});

//分页
function loadPageDatas(index) {
	firstLoadData("/SewingFactoryPickingOrder/selSewingFactoryPickingOrderBypage.do", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	getProces(mydata);
}
function getProces(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, op) {
		var status=op.sewingStatus=='2'?"已发料":"<button class='btn btn-danger btn-sm delSewing'  data-toggle='modal'  href='javascript:;'>删 除</button></td>";
	$("tbody").append(
				"<tr>"
				+"<input type='hidden' class='id' value='"+op.id+"'>"
				+ "<td style='text-align: center;'>"
				+ (op.wave==null?"":op.wave)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.sewingFactory==null?"":op.sewingFactory)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ "<img src='"+op.designImg+"' width='50px;' height='50px;'/>"
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code52==null||op.code52==0?"":op.code52)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code59==null||op.code59==0?"":op.code59)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code66==null||op.code66==0?"":op.code66)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code73==null||op.code73==0?"":op.code73)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code80==null||op.code80==0?"":op.code80)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code90==null||op.code90==0?"":op.code90)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code100==null||op.code100==0?"":op.code100)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code110==null||op.code110==0?"":op.code110)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code120==null||op.code120==0?"":op.code120)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code130==null||op.code130==0?"":op.code130)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code160==null||op.code160==0?"":op.code160)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.code170==null||op.code170==0?"":op.code170)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.total==null||op.total==0?"":op.total)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.remark==null?"":op.remark)
				+ "</td>"
				+ "<td style='text-align: center; width:70px;'>"
				+status 
				+"</tr>");
			});
	// 修改
	delProce();
}

function delProce(){
	$(".delSewing").on("click",function(){
		var id=$(this).parent().parent().find(".id").val();
		if (confirm('确定要删除此条数据吗?')) {
			$.ajax({
				url:'SewingFactoryPickingOrder/uppStatus.do',
				dataType:'json',
				type:'post',
				data:{
					id:id
				},success:function(data){
					if(data!=1){
						alert("删除失败！");
					}
					firstLoadData("SewingFactoryPickingOrder/selSewingFactoryPickingOrderBypage.do?orderId="+str, $(".laypage_curr").text());
				},error:function(){
					alert("删除失败，系统错误！！");
				}
			});
		}else{
			return false;
		}
	});
}
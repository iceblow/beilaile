/**
 *同步裁床表
 */
$(function() {
	// 分页
	loadPageDatas(1);

});
var url = location.search; //获取url中"?"符后的字串
var str = location.search.substr(1); 
//分页
function loadPageDatas(index) {
	$("#checkbtn").on("click",function(){
		var wave=$("#checkByWave").val();
	firstLoadData("piecesInformation/piecesInformationBypage.do?wave="+wave, index);
	});
	firstLoadData("piecesInformation/piecesInformationBypage.do", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	getProces(mydata);
}
function getProces(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, op) {
	var statu="";
	if(op.status=="0"){
		statu="已 添 加"+(op.printingFactory==null?"":"("+op.printingFactory+")");
	}else if(op.status=="1"){
		statu="<button class='btn btn-info btn-sm  uppStatus'  data-toggle='modal'  href='javascript:;'>添 加</batton>";
	}else if(op.status=="2"){
		statu="已 下 单"+(op.printingFactory==null?"":"("+op.printingFactory+")");
	}else if(op.status=="3"){
		statu="已 发 料"+(op.printingFactory==null?"":"("+op.printingFactory+")");
	}
		$("tbody").append(
				"<tr>"
				+ "<td style='text-align: center;'>"
				+ op.id
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.wave==null?"":op.wave)
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
				+ "<td style='text-align: center; width:70px;'>"
				+statu 
				+"</td></tr>");
			});
	// 修改
	uppProce();
}
//向片印领料详单里添加数据
function uppProce(){
	$(".uppStatus").click(function(){
		var id=$(this).parent().parent().find("td:eq(0)").text();
		var orderId=str;
		if (confirm('确定要添加此条数据吗?')) {
			$.ajax({
				url:'piecesInformation/uppPiecesInformation.do',
				dataType:'json',
				type:'post',
				data:{
					id:id,
					orderId:orderId
				},success:function(data){
					if(data!=1){
					alert("添加失败！");
					}
					firstLoadData("piecesInformation/piecesInformationBypage.do", $(".laypage_curr").text());
				},error:function(){
					alert("添加失败，系统错误！！");
				}
			});
		}else{
			return false;
		}
	});
}
/**
 * 外加工各款明细表
 */
$(function() {
	// 分页
	loadPageDatas(1);
	//添加工厂
	addPrint();
	
	//模糊查询
	sewingOrderBylike();

});
//分页
function loadPageDatas(index) {
	firstLoadData("SewingPickingOrder/selSewingPickingOrder.do", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	getProces(mydata);
}
function getProces(mydata) {
	$("#tbody").empty();
	$.each(mydata,function(index, op) {
	var dad="<button class='btn btn-warning btn-sm printOrder'  data-toggle='modal'  href='javascript:;'>打 单</batton>";
	var pick="<button class='btn btn-info btn-sm  uppStatus'  data-toggle='modal'  href='javascript:;'>领 料</batton>";
	var mark="<button class='btn btn-default btn-sm markOrder'  data-toggle='modal'  href='javascript:;'>发 料</batton>";
	var revoked="<button class='btn btn-danger btn-sm revokedOrder'  data-toggle='modal'  href='javascript:;'>撤销</batton>";
	$("#tbody").append(
				"<tr>"
				+ "<td style='text-align: center;'>"
				+ op.orderId
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.sewingFactory==null?"":op.sewingFactory)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ "<a target='_blank' href=' sewingFactoryPickingOrder.html?"
				+ op.orderId+"'>领料详单</a>"
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.addTime==null?"":op.addTime)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.orderTime==null?"":op.orderTime)
				+ "</td>"
				+ "<td style='text-align: center;'>"
				+ (op.deliveryTime==null?"":op.deliveryTime)
				+ "</td>"
				+ "<td style='text-align: center;' class='mydblClick' name='orderRemark'>"
				+ (op.orderRemark==null?"":op.orderRemark)
				+ "</td>"
				+ "<td style='text-align: center; width:60px;'>"
				+(op.orderStatus=='3'?"已发料":pick)
				+ "</td>"
				+ "<td style='text-align: center; width:60px;'>"
				+ (op.orderStatus=='3'?"已打单":dad)
				+ "</td>" 
				+ "<td style='text-align: center; width:60px;'>"
				+ (op.orderStatus=='3'?"已发料":mark)
				+ "</td>"
				+ "<td style='text-align: center; width:60px;'>"
				+ (op.orderStatus=='3'?revoked:'撤销')
				+ "</td>"
				+ "</tr>");
			});
	// 领料
	uppPrint();
	//打单
	printOrder();
	//发料
	markOrder()
	//撤销
	revokedOrder();
	//双击修改
	updbclick();
}
//添加
function addPrint(){
	$("#addProce").on("click",function(){
		var sewingFactory=$("#sewingFactory").val();
		var orderRemark=$("#orderRemark").val();
		$.ajax({
			url:'SewingPickingOrder/addSewingPickingOrder.do',
			dataType:'json',
			type:'post',
			data:{
				sewingFactory:sewingFactory,
				orderRemark:orderRemark
			},
			success:function(data){
				if(data!=1){
					alert("添加失败");
				}
				firstLoadData("SewingPickingOrder/selSewingPickingOrder.do", 1);
			},error:function(){
				alert("添加失败系统错误！！");
			}
		});
		$("#sewingFactory").val("");
		$("#orderRemark").val("");
	});
}
//领料
function uppPrint(){
	$(".uppStatus").on("click",function(){
		var id=$(this).parent().parent().find("td:eq(0)").text();
		var printingFactory=$(this).parent().parent().find("td:eq(1)").text();
		window.open("sewingInformation.html?"+ id);
	});
}
//打单
function printOrder(){
	$(".printOrder").on("click",function(){
		var id=$(this).parent().parent().find("td:eq(0)").text();
		var factory=$(this).parent().parent().find("td:eq(1)").text();
		var mydate=new Date();
		//date=mydate.getFullYear()+"-"+(mydate.getMonth()+1)+"-"+mydate.getDate();时间
		$.ajax({
			url:'SewingPickingOrder/selSewingFactory.do',
			dataType:'json',
			type:'post',
			data:{
				orderId:id
			},success:function(data){
				//加载前清空
				$("#print").empty();
				$("#factory").empty();
				//$("#date").empty();清空时间
				$("#ids").empty();
				//编号
				var ids=( "0000000" + id ).substr(id.length );  
				$("#ids").append(ids);
				//时间
				//$("#date").append(date);追加时间
				//工厂
					$("#factory").append(factory);
				//循环输出打印
				$.each(data,function(index, op) {
				var code=(op.code52==null?0:op.code52)+(op.code59==null?0:op.code59)+(op.code66==null?0:op.code66)
				+(op.code73==null?0:op.code73)+(op.code80==null?0:op.code80)+(op.code90==null?0:op.code90)
				+(op.code100==null?0:op.code100)+(op.code110==null?0:op.code110)+(op.code120==null?0:op.code120)
				+(op.code130==null?0:op.code130)+(op.code160==null?0:op.code160)+(op.code170==null?0:op.code170);
					$("#print").append("<tr>"
					+ "<td>"
					+ (op.wave==null?"":op.wave)
					+ "</td>"
					+ "<td >"
					+ (op.code52==null||op.code52==0?"":op.code52)
					+ "</td>"
					+ "<td >"
					+ (op.code59==null||op.code59==0?"":op.code59)
					+ "</td>"
					+ "<td >"
					+ (op.code66==null||op.code66==0?"":op.code66)
					+ "</td>"
					+ "<td >"
					+ (op.code73==null||op.code73==0?"":op.code73)
					+ "</td>"
					+ "<td >"
					+ (op.code80==null||op.code80==0?"":op.code80)
					+ "</td>"
					+ "<td >"
					+ (op.code90==null||op.code90==0?"":op.code90)
					+ "</td>"
					+ "<td >"
					+ (op.code100==null||op.code100==0?"":op.code100)
					+ "</td>"
					+ "<td >"
					+ (op.code110==null||op.code110==0?"":op.code110)
					+ "</td>"
					+ "<td >"
					+ (op.code120==null||op.code120==0?"":op.code120)
					+ "</td>"
					+ "<td >"
					+ (op.code130==null||op.code130==0?"":op.code130)
					+ "</td>"
					+ "<td >"
					+ (op.code160==null||op.code160==0?"":op.code160)
					+ "</td>"
					+ "<td >"
					+ (op.code170==null||op.code170==0?"":op.code170)
					+ "</td>"
					+ "<td >"
					+ code
					+ "</td>"
					+ "<td >"
					+ (op.remark==null?"":op.remark)
					+ "</td>"
					+"</tr>");
				});
				$("#prints").jqprint();
				firstLoadData("SewingPickingOrder/selSewingPickingOrder.do",$(".laypage_curr").text());
			},error:function(){
				alert("打单失败！系统错误！！");
			}
		});
	});
}
//发料
function markOrder(){
	$(".markOrder").on("click",function(){
		var id=$(this).parent().parent().find("td:eq(0)").text();
		if (confirm('确定要发料吗?')) {
			$.ajax({
				url:'SewingPickingOrder/uppSewingPickingOrder.do',
				dataType:'json',
				type:'post',
				data:{
					orderId:id,
					orderStatus:3
				},success:function(data){
					if(data!=1){
						alert("发料失败！");
					}
					firstLoadData("SewingPickingOrder/selSewingPickingOrder.do",$(".laypage_curr").text());
				},error:function(){
					alert("发料失败！系统错误！！");
				}
			});
		}else{
			return false;
		}
	});
}
//撤销
function revokedOrder(){
	$(".revokedOrder").on("click",function(){
		var id=$(this).parent().parent().find("td:eq(0)").text();
		if (confirm('确定要撤销吗?')) {
			$.ajax({
				url:'SewingPickingOrder/uppSewingPickingOrder.do',
				dataType:'json',
				type:'post',
				data:{
					orderId:id,
					orderStatus:4
				},success:function(data){
					if(data!=1){
						alert("撤销失败！");
					}
					firstLoadData("SewingPickingOrder/selSewingPickingOrder.do",$(".laypage_curr").text());
				},error:function(){
					alert("撤销失败！系统错误！！");
				}
			});
		}else{
			return false;
		}
	});
}
/////////////////双击修改////////////////
function updbclick() {
	$(".mydblClick").on("dblclick",function() {
		var id = $(this).parent().find("td:eq(0)").text();
		var code = $(this).text().trim();
		var name = $(this).attr("name");
		$(this).html("<input id='" + id + "' type='text' value='" + code+ "' name='" + name + "' style='width:100px;'> ");
		$("#" + id).focus();// 文本框获取光标事件
		uppblur(id, name);
	});
}
// 光标离开事件
function uppblur(id, name) {
	$("#" + id).blur(function() {
		var newtxt = $(this).val();
		$(this).closest("td").text(newtxt);
		var data = {orderId : id};
		data[name] = newtxt;
		$.ajax({
			url : 'SewingPickingOrder/dbuppSewingPickingOrder.do',
			dataType : 'json',
			type : 'post',
			data : data,
			success : function(data) {
				if (data == 1) {
					firstLoadData("SewingPickingOrder/selSewingPickingOrder.do",$(".laypage_curr").text());
				}
			},error : function() {
				alert("修改失败,系统错误!");
			}
		});
	});
}
function sewingOrderBylike(){
	$("#checkbtn").on("click",function(){
		var factory=$("#checkByFactory").val().trim();
		firstLoadData("SewingPickingOrder/selSewingPickingOrder.do?sewingFactory="+factory, 1);
	});
}
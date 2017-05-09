$(function() {
	// 分页
	loadPageDatas(1);
	//模糊查询
	loadPageByCheck();
	//导入Excel
	inputExcel();
	$("#importFile").val("");
});

function loadPageDatas(index) {
	firstLoadData("financeAccountReconciliation/selfinanceAccountReconciliationbyPage.do", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	financeAccountReconciliation(mydata);
}
function financeAccountReconciliation(mydata) {
	$("#tbody").empty();
	$.each(mydata, function(index, f) {
		$("#tbody").append(
				"<tr><input type='hidden' name='id' class='id' value='"+f.id+"' /><td>" 
				+ (f.reconciliationTime==null?"":f.reconciliationTime) + "</td><td>"//对账日期
				+ (f.wave==null?"":f.wave)+ "</td><td>" 
				+ (f.factory==null?"":f.factory) + "</td><td>" 
				+ (f.productCode==null?"":f.productCode) + "</td><td width='180px'>" 
				+ (f.productName==null?"":f.productName) + "</td><td>" 
				+ "<img src='"+f.designImg+ "' width='60px'/></td><td>" 
				+ (f.orderType==null?"":f.orderType)+"</td><td>"//订单类型
				+ (f.reconciliationUtil==null?"":f.reconciliationUtil)+"</td><td>"//单位
				+ (f.cropNumber==null||f.cropNumber==0?"":f.cropNumber)+"</td><td>"//裁剪数
				+ (f.reconciliationUnitPrice==null?"":f.reconciliationUnitPrice)+"</td><td>"//价格
				+ (f.shipmentNum==null?"":f.shipmentNum) + "</td><td>"// 出货数
				+ (f.deliveryTotal==null?"":f.deliveryTotal) + "</td><td>" // 合计
				+ (f.deviationNum==null?"":f.deviationNum) + "</td><td class='mydbclick' name='actualDeliveryNum'>" // 误差
				+ (f.actualDeliveryNum==null||f.actualDeliveryNum==0?"":f.actualDeliveryNum) + "</td><td class='mydbclick' name='factoryFeedback'>"// 实际到货数
				+ (f.factoryFeedback==null?"":f.factoryFeedback) + "</td><td class='mydbclick' name='remarks'>" // 工厂反馈
				+ (f.remarks==null?"":f.remarks)
				+ "</td></tr>");
	});
	//双击修改
	mydbclick();
}
//模糊查询
var selMyForm="";
function loadPageByCheck(){
	$("#checkbtn").on("click",function(){
		selMyForm=$("#sel-form").serialize();
		firstLoadData("financeAccountReconciliation/selfinanceAccountReconciliationbyPage.do?"+selMyForm, 1);
	});
}
//导入
function inputExcel() {
	$("#ImportStockAlert").click(function() {
		$.ajaxFileUpload({
			url :'financeAccountReconciliation/inFinanceAccountReconciliation.do',
			secureuri : false,
			fileElementId : 'importFile',
			dataType : 'json',
			success : function(data,status) {
				if (data == "1") {
					alert("上传成功!");
					firstLoadData("financeAccountReconciliation/selfinanceAccountReconciliationbyPage.do", 1);
				}else if(data=="0"){
					alert("上传失败,请更改Excel表里的时间格式:YYYY/mm/dd");
				}else{
					alert("格式不支持请上传.xls格式");
				}
			}, 
			error : function(data, status, e) {
				$.messager.alert("提示", "导入失败", 'error');
				return false;
			}
		});
		$("#importFile").val("");
	});
}
//修改
function mydbclick(){
	$(".mydbclick").on("dblclick",function(){
		var name=$(this).attr("name");
		var value=$(this).text();
		var id=$(".id").val();
		//alert("id==="+id+" ** "+name+" --- "+value);
		$(this).html("<input type='text' id='"+id+"' name='"+name+"' value='"+value+"' style='width:100px;'/>");
		$("#"+id).focus();
		myblur(id,name);
	});
}
function myblur(id,name){
	$("#"+id).on("blur",function(){
		var newval=$("#"+id).val();
		var data = { id : id };
			data[name] = newval;
		$.ajax({
			url:'financeAccountReconciliation/dbuppFinanceAccountReconciliation.do',
			dataType:'json',
			data:data,
			type:'post',
			success:function(mydata){
				if(mydata!=1){
					alert("修改失败!");
				}
			},error:function(){
				alert("修改失败,系统错误!!!");
			}
		});
		firstLoadData("financeAccountReconciliation/selfinanceAccountReconciliationbyPage.do?"+selMyForm, $(".laypage_curr").text());
	});
}
/**
 *返单样衣管理 
 */
$(function(){
	//分页查询
	loadPageDatas(1);
	select();
})
//调用分页查询方法
function loadPageDatas(index){
	firstLoadData("/returnToSinglePattern/getDataByPage.do",index);
}
//打印数据
function loadData(mydata){
	$("tbody").empty();
	$.each(mydata,function(index,r){
		var id="<input type='hidden' class='id' value='"+r.id+"'/>";// 序号
		var returnTime="<td style='text-align: center;'>"+(r.returnTime==null?'':r.returnTime)+"</td>";// 返单时间
		var wave="<td style='text-align: center;'>"+(r.wave==null?'':r.wave)+"</td>";// 波次号
		var oringinalWave="<td style='text-align: center;'>"+(r.oringinalWave==null?'':r.oringinalWave)+"</td>";// 原波次
		var productCode="<td>"+(r.productCode==null?'':r.productCode)+"</td>";// 商品编号
		var clothName="<td>"+(r.clothName==null?'':r.clothName)+"</td>";// 服装名
		var designImg="<td>"+(r.designImg==null||r.designImg==''?'':"<img src="+r.designImg+" width='100px' height='80px'>")+"</td>";// 设计图
		var sampleImg="<td>"+(r.sampleImg==null||r.sampleImg==''?'':"<a href='"+r.sampleImg+"' target='_blank'>工艺单</a>")+"</td>";// 工艺单
		var sizeImg="<td>"+(r.sizeImg==null||r.sizeImg==''?'':"<a href='"+r.sizeImg+"' target='_blank'>尺码表</a>")+"</td>";// 尺码图
		var needToBeSampleCloth="<td style='text-align: center;'>"+(r.needToBeSampleCloth=='需要样衣'?'需要样衣':'<button class="btn btn-sm btn-primary needToBeSampleCloth">需要样衣</button>')+"</td>";// 需要样衣
		var pieceSampleComplete="<td style='text-align: center;'>"+(r.pieceSampleComplete=='纸样已完成'?'纸样已完成':'<button class="btn btn-sm btn-danger pieceSampleComplete">纸样完成</button>')+"</td>";// 纸样完成
		
		$("tbody").append("<tr>"
				+id// 序号
				+returnTime// 返单时间
				+wave// 波次号
				+oringinalWave// 原波次
				+productCode// 商品编号
				+clothName// 服装名
				+designImg// 设计图
				+sampleImg// 工艺单
				+sizeImg// 尺码图
				+needToBeSampleCloth// 需要样衣
				+pieceSampleComplete// 纸样完成
				+"</tr>");
	});
	//需要样衣方法
	needToBeSampleCloth();
	//纸样完成方法
	pieceSampleComplete();
}
//定义查询条件
var mySelectForm;
/**
 * 查詢按鈕點擊事件
 */
function select() {
	$("#mySelect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData("/returnToSinglePattern/getDataByPage.do?"+ mySelectForm, 1); // 指定url
			});
}
/**
 * 需要样衣点击事件
 * @returns
 */
function needToBeSampleCloth(){
	$(".needToBeSampleCloth").click(function(){
		var id=$(this).parent().parent().find(".id").val();
		var wave=$(this).parent().parent().find("td:eq(1)").text().trim();
		layer.confirm("确认<font color='red'>"+wave+"</font>需要样衣?",function(){
			$.ajax({
				url:'/returnToSinglePattern/needToBeSampleCloth.do',
				type:'post',
				dataType:'json',
				data:{
					id:id,
				},
				success:function(){
					firstLoadData("/returnToSinglePattern/getDataByPage.do?"+ mySelectForm, $(".laypage_curr").text());// 指定url
					layer.msg('已确认');
				}
			});
		},function(){
			layer.msg('取消确认');
		});
	});
}

/**
 * 纸样完成点击事件
 * @returns
 */
function pieceSampleComplete(){
	$(".pieceSampleComplete").click(function(){
		var id=$(this).parent().parent().find(".id").val();
		var wave=$(this).parent().parent().find("td:eq(1)").text().trim();
		layer.confirm("确认<font color='red'>"+wave+"</font>纸样完成?",function(){
			$.ajax({
				url:'/returnToSinglePattern/pieceSampleComplete.do',
				type:'post',
				dataType:'json',
				data:{
					id:id,
				},
				success:function(){
					firstLoadData("/returnToSinglePattern/getDataByPage.do?"+ mySelectForm, $(".laypage_curr").text());// 指定url
					layer.msg('已确认');
				}
			});
		},function(){
			layer.msg('取消确认');
		});
	});
}
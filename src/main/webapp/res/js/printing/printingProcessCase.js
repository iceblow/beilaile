$(function() {
	// 进入页面进行查询
	loadPageDatas(1);

	// 模糊查询
	select();
})

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val() + "/printingProcessCase/getDataByPage.do",
			index); // 指定url
}
// 打印数据
function loadData(data) {
	$("tbody").empty();
	$.each(data, function(index, x) {
		var id = "<input type='hidden' class='id' value='" + x.id + "'>";// 编号

		var wave = "<td>" + (x.wave == null ? '' : x.wave) + "</td>";// 波次
		var productCode = "<td>" + (x.productCode == null ? '' : x.productCode)
				+ "</td>";// 商品编号
		var designer = "<td>" + (x.designer == null ? '' : x.designer)
				+ "</td>";// 设计师
		var referencePrinting = "<td>"
				+ (x.referencePrinting == null ? '' : x.referencePrinting)
				+ "</td>";// 参考印花
		var designImg = "<td>"
			+ (x.designImg == null || x.designImg == "" ? ''
					: "<img src='"
							+ x.designImg
							+ "' width='90px' height='60px'/>");
		var sampleImg = "<td>"
				+ (x.sampleImg == null ? '' : "<a href='" + x.sampleImg
						+ "' target='_blank'>工艺单</a>") + "</td>";// 工艺单
		var patternCraftsOrder = "<td>"
				+ (x.patternCraftsOrder == null ? '' : "<a href='"+ x.patternCraftsOrder + "' target='_blank'>图样工艺单</a>")
				+ "</td>";// 图样工艺单
		var orderDetails = "<td>" + (x.orderDetails == null ? '' : x.orderDetails) + "</td>";// 订单详情
		var orders = "<td>" + (x.orders == null ? '' : x.orders) + "</td>";// 订单数
		var printingFactory = "<td>" + (x.printingFactory == null ? '' : x.printingFactory) + "</td>";// 印花工厂
		var printingFabricArrangeOut = "<td style='text-align: center;'>" + (x.printingFabricArrangeOut == null||x.printingFabricArrangeOut == "" ?"<button class='btn btn-app btn-danger btn-sm btnClick' value='fabricOut'>领料</button>":x.printingFabricArrangeOut) + "</td>";// 匹印领料时间
		var printingFabricArrangeIn = "<td style='text-align: center;'>" + (x.printingFabricArrangeIn == null||x.printingFabricArrangeIn == "" ? "<button class='btn btn-app btn-purple btn-sm btnClick' value='fabricIn'>回料</button>" : x.printingFabricArrangeIn) + "</td>";// 匹印回料时间
		var require = "<td>" + (x.require == null ? '' : x.require) + "</td>";// 片印要求
		
		$("tbody").append("<tr>" + id// 编号
				+ wave// 波次号
				+ productCode// 商品编号
				+ designer// 设计师
				+ referencePrinting// 参考印花
				+ designImg// 设计图
				+ sampleImg// 工艺单
				+ patternCraftsOrder// 图样工艺单
				+ orderDetails// 订单详情
				+ orders// 订单数
				+ printingFactory// 印花工厂
				+ printingFabricArrangeOut// 匹印领料时间
				+ printingFabricArrangeIn// 匹印回料时间
				+ require// 片印要求
				+ "</tr>");
	});
	btnClick();
}
// -----------------------------------------------点击查询-----------------------------------------------
var mySelectForm;
function select() {
	$("#mySelectBtn").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData("/printingProcessCase/getDataByPage.do?"
						+ mySelectForm, 1); // 指定url
			});
}
//------------------------------------------------
function btnClick(){
	$(".btnClick").click(function(){
		var id=$(this).parent().parent().find(".id").val();
		var myFunction=$(this).val().trim();
		var text=$(this).text().trim();
		layer.confirm('确认'+text+"?",{
					btn:['是','否']
				},
				function(){
					$.ajax({
						url:"/printingProcessCase/"+myFunction+".do",
						type:'post',
						dataType:'json',
						data:{
							id:id,
						},
						success:function(data){
							if(data>0){
								firstLoadData("/printingProcessCase/getDataByPage.do?"
										+ mySelectForm, $(".laypage_curr").text()); // 指定url
								layer.msg('已确认',{
									icon:6
								})
							}
						}
					});
				},function(){
					layer.msg('已取消',{
						icon:5
					})
				});
	});
}

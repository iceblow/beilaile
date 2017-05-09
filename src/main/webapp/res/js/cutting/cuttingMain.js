$(function() {
	// 分页查询的方法
	loadPageDatas(1)
	select();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData($("#path").val() + "/cutting/getAllByPage.do", index); // 指定url
}
// 分页查询以后打印数据
function loadData(mydata) {

	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, xx) {
						var design_img = xx.design_img == "" ? "<td></td>"
								: "<td style='text-align: center;'><img src='"
										+ xx.design_img
										+ "' width='100px' height='100px'></td>";
						var completeType = "<td>"
								+ (xx.completeType == "未完成" ? "<a href='javascript:;' class='complete'>点击完成</a>"
										: xx.completeType) + "</td>"
						$("tbody")
								.append(
										"<tr style='"
												+ (xx.completeType == "已完成" ? "background-color:#02F78E;"
														: "")
												+ "'><td style='text-align: center;'>"
												+ xx.id
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.date
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.b_id
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.type
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s52 == null
														|| xx.s52 == 0 ? ''
														: xx.s52)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s59 == null
														|| xx.s59 == 0 ? ''
														: xx.s59)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s66 == null
														|| xx.s66 == 0 ? ''
														: xx.s66)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s73 == null
														|| xx.s73 == 0 ? ''
														: xx.s73)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s80 == null
														|| xx.s80 == 0 ? ''
														: xx.s80)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s90 == null
														|| xx.s90 == 0 ? ''
														: xx.s90)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s100 == null
														|| xx.s100 == 0 ? ''
														: xx.s100)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s110 == null
														|| xx.s110 == 0 ? ''
														: xx.s110)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s120 == null
														|| xx.s120 == 0 ? ''
														: xx.s120)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s130 == null
														|| xx.s130 == 0 ? ''
														: xx.s130)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s160 == null
														|| xx.s160 == 0 ? ''
														: xx.s160)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.s170 == null
														|| xx.s170 == 0 ? ''
														: xx.s170)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.num == 0 ? '' : xx.num)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.oneCursumption
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.oneCursumptionB == null ? ""
														: xx.oneCursumptionB)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.oneCursumptionC == null ? ""
														: xx.oneCursumptionC)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.oneCursumptionD == null ? ""
														: xx.oneCursumptionD)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.oneCursumptionE == null ? ""
														: xx.oneCursumptionE)
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.flowerOutTime
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.flowerInTime
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.wages
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.inTime
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.cuttingMan
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.priceOutingTime
												+ "</td>"
												+ "<td style='text-align: center;'>" 
												+ (xx.packets==null?'':xx.packets)//包数
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ (xx.shelves==null?'':xx.shelves)//货架
												+ "</td>"
												+ "<td style='text-align: center;'>"
												+ xx.remark
												+ "</td>"
												+ design_img
												+ completeType
												+ "<td style='text-align: center;'><a data-toggle='modal' data-target='#myModal1' class='update' href='javascript:;'>修改</a></td>"
												+ "<td style='text-align: center;'><a class='del' href='javascript:;'>删除</a></td></tr>");
					});
	update();
	del();
	complete();
}

function update() {
	$(".update").click(
			function() {
				var id = $(this).parent().parent().find("td:eq(0)").text()
						.trim();
				$.ajax({
					url:'/cutting/getOne.do',
					type:'post',
					dataType:'json',
					data:{
						id:id
					},
					success:function(data){
						$("#id").val(data.id);
						$("#date").val(data.date);
						$("#b_id").val(data.b_id);
						$("#type").val(data.type);
						$("#s52").val(data.s52==0?'':data.s52);
						$("#s59").val(data.s59==0?'':data.s59);
						$("#s66").val(data.s66==0?'':data.s66);
						$("#s73").val(data.s73==0?'':data.s73);
						$("#s80").val(data.s80==0?'':data.s80);
						$("#s90").val(data.s90==0?'':data.s90);
						$("#s100").val(data.s100==0?'':data.s100);
						$("#s110").val(data.s110==0?'':data.s110);
						$("#s120").val(data.s120==0?'':data.s120);
						$("#s130").val(data.s130==0?'':data.s130);
						$("#s160").val(data.s160==0?'':data.s160);
						$("#s170").val(data.s170==0?'':data.s170);
						$("#oneCursumption").val(data.oneCursumption);
						$("#oneCursumptionB").val(data.oneCursumptionB);
						$("#oneCursumptionC").val(data.oneCursumptionC);
						$("#oneCursumptionD").val(data.oneCursumptionD);
						$("#oneCursumptionE").val(data.oneCursumptionE);
						$("#FlowerOutTime").val(data.flowerOutTime);
						$("#FlowerInTime").val(data.flowerInTime);
						$("#wages").val(data.wages);
						$("#InTime").val(data.inTime);
						$("#CuttingMan").val(data.cuttingMan);
						$("#PriceOutingTime").val(data.PriceOutingTime);
						$("#packets").val(data.packets);
						$("#shelves").val(data.shelves);
						$("#remark").val(data.remark);
					}
				});
			});
}

// 删除方法(暂未使用)
function del() {
	$(".del").bind(
			"click",
			function() {
				var id = $(this).parent().parent().find("td:eq(0)").text()
						.trim();
				$.ajax({
					url : $("#path").val() + "/cutting/del.do",
					type : 'get',
					dataType : 'json',
					data : {
						id : id,
					},
					error : function() {
						firstLoadData($("#path").val()
								+ "/cutting/getAllByPage.do", 1); // 指定url
					}
				});
			});
}
var mySelectForm;
// 查詢按鈕點擊事件
function select() {
	$("#myselect").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val() + "/cutting/getAllByBid.do?"
						+ mySelectForm, 1); // 指定url
				// $(".col-md-2>input").val("");
			});
}

function complete() {
	$(".complete").click(
			function() {
				var id = $(this).parent().parent().find("td:eq(0)").text()
						.trim();
				$.ajax({
					url : $("#path").val() + "/cutting/complete.do",
					type : "post",
					dataType : "json",
					data : {
						id : id,
					},
					success : function(data) {
						firstLoadData($("#path").val()
								+ "/cutting/getAllByPage.do?" + mySelectForm,
								$(".laypage_curr").text().trim());
					}
				});
			});
}
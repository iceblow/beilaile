/**
 * 裁片印绣花领料日报表
 */
$(function() {
	// 分页
	loadPageDatas(1);
	// 模糊查询
	InputstorageBylike();
});

// 模糊查询
var mySelectForm = "";
function InputstorageBylike() {
	$("#checkbtn").on("click",function() {
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData("salesNotSaleHangZhou/getDataByPage.do?" + mySelectForm, 1);
		$("#mySelect_From>input").val("");
	});
}

// 分页
function loadPageDatas(index) {
	// 处理后的数据inputstorage
	firstLoadData($("#path").val() + "/salesNotSaleHangZhou/getDataByPage.do", index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	Inputstorage(mydata);
}
function Inputstorage(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, s) {
			$("tbody").append("<tr>"
					+ "<input type='hidden' class='sid' value='"
					+ s.sid
					+ "'/>"
					+ "<input type='hidden' class='productShortName' value='"
					+ s.productShortName
					+ "'/>"
					+ "<td style='text-align: center;'>"
					+ (s.sdate == null ? '' : s.sdate)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.vendorCode == null ? '' : s.vendorCode)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.commodityc_code == null ? '' : s.commodityc_code)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.girard == null ? '' : s.girard)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.factory == null ? '' : s.factory)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.design_img==null?"":"<img width='60px' height='60px' src='"+s.design_img+"'/>")
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code59 == null
							|| s.code59 == 0 ? '' : s.code59)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code66 == null
							|| s.code66 == 0 ? '' : s.code66)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code73 == null
							|| s.code73 == 0 ? '' : s.code73)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code80 == null
							|| s.code80 == 0 ? '' : s.code80)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code90 == null
							|| s.code90 == 0 ? '' : s.code90)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code100 == null
							|| s.code100 == 0 ? '' : s.code100)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code110 == null
							|| s.code110 == 0 ? '' : s.code110)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code120 == null
							|| s.code120 == 0 ? '' : s.code120)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code130 == null
							|| s.code130 == 0 ? '' : s.code130)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code160 == null
							|| s.code160 == 0 ? '' : s.code160)
					+ "</td>"
					+ "<td style='text-align: center;'  class='mybdlclick'>"
					+ (s.code170 == null
							|| s.code170 == 0 ? '' : s.code170)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.total == null ? '' : s.total)
					+ "</td>"
					+ "<td style='text-align: center;'>"
					+ (s.remarks == null ? '' : s.remarks)
					+ "</td></tr>");
			});
}

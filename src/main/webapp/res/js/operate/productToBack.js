$(function() {
	loadPageDatas(1);
	// 点击查询方法
	mySelect();

	addProdrct();

	commitSampleModel();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
	firstLoadData("productToBack/selProductToBack.do", index);// 处理后的数据
}
function loadData(mydata) {
	test(mydata);
}
function test(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, x) {
		var id = x.id == null || x.id == "" ? "<td></td>"
				: "<td align='center'>" + x.id + "</td>";// 编号
		var wave = x.wave == null || x.wave == "" ? "<td></td>"
				: "<td align='center'>" + x.wave + "</td>";// 波次号
		var productCodes = x.productCodes == null
				|| x.productCodes == "" ? "<td></td>"
				: "<td align='center'>" + x.productCodes
						+ "</td>";// 商品编号
		var productName = x.productName == null
				|| x.productName == "" ? "<td></td>"
				: "<td align='center'>" + x.productName
						+ "</td>";// 商品名称
		var productShortName = x.productShortName == null
				|| x.productShortName == "" ? "<td></td>"	
				: "<td align='center'>" + x.productShortName
						+ "</td>";// 商品简称
		var productOldName = x.productOldName == null
				|| x.productOldName == "" ? "<td></td>"
				: "<td align='center'>" + x.productOldName
						+ "</td>";// 商品简称(旧)
		var excleFile = x.excleFile == null
				|| x.excleFile == "" ? "<td></td>"
				: "<td align='center'>" + x.excleFile + "</td>";// excle文件
		var productImg = x.productImg == null
				|| x.productImg == "" ? "<td></td>"
				: "<td align='center'><img src=" + x.productImg
						+ " width='100px' height='80px'></td>";// 商品图片
		// alert(flag);
		var str = "<a data-toggle='modal' data-target='#myModal' href='javascript:;' class='toback'><button class='btn btn-default' data-dismiss='modal'>返单</button></a>";
		$("tbody").append( "<tr>" + id + productCodes + wave + productName
						+ productOldName + productShortName
						+ excleFile + productImg
						+ "<td align='center'>" + str
						+ "</td>"
						+ "<td align='center'><a data-toggle='modal' data-target='#sampleForModel' href='javascript:;'class='btn btn-success sampleModel'>调样衣</a></td>"
						+"</tr>");
	});

	getProduct();
	
	sampleForModel();
}
// 获取
function getProduct() {
	$(".toback").unbind('click').bind("click", function() {
		var ids = $(this).parent().parent().find("td:eq(0)").text();
		$("input").val("");
		$.ajax({
			url : 'productToBack/getById.do',
			dataType : 'json',
			type : 'post',
			data : {
				id : ids
			},
			success : function(data) {
				var record = eval(data);
				$("#girardOld").val(record.wave);
				$("#productCodes").val(record.productCodes);
				$("#productName").val(record.productName);
				$("#productShortName").val(record.productShortName);
				$("#excleFile").val(record.excleFile);
				$("#productImg").val(record.productImg);
				$("#productOldName").val(record.productOldName);
			}
		});
	});
}
// 添加
function addProdrct() {
	$("#addSub").click(function() {
		var girard = $("#girard").val();
		var code52 = $("#code52").val() == "" ? 0 : $("#code52").val();
		var code59 = $("#code59").val() == "" ? 0 : $("#code59").val();
		var code66 = $("#code66").val() == "" ? 0 : $("#code66").val();
		var code73 = $("#code73").val() == "" ? 0 : $("#code73").val();
		var code80 = $("#code80").val() == "" ? 0 : $("#code80").val();
		var code90 = $("#code90").val() == "" ? 0 : $("#code90").val();
		var code100 = $("#code100").val() == "" ? 0 : $("#code100").val();
		var code110 = $("#code110").val() == "" ? 0 : $("#code110").val();
		var code120 = $("#code120").val() == "" ? 0 : $("#code120").val();
		var code130 = $("#code130").val() == "" ? 0 : $("#code130").val();
		var code160 = $("#code160").val() == "" ? 0 : $("#code160").val();
		var code170 = $("#code170").val() == "" ? 0 : $("#code170").val();
		var time = $("#expectTime").val();
		var girardOld = $("#girardOld").val();
		var codes = $("#productCodes").val();
		var name = $("#productName").val();
		var shortName = $("#productShortName").val();
		var excle = $("#excleFile").val();
		var Img = $("#productImg").val();
		var oldName = $("#productOldName").val();
		$.ajax({
			url : 'approvalApplication/addapprovalApplication.do',
			dataType : 'json',
			type : 'post',
			data : {
				girard : girard,
				originalWave : girardOld,
				productId : codes,
				expectTime : time,
				clothName : shortName,
				designImg : Img,
				code52 : code52,
				code59 : code59,
				code66 : code66,
				code73 : code73,
				code80 : code80,
				code90 : code90,
				code100 : code100,
				code110 : code110,
				code120 : code120,
				code130 : code130,
				code160 : code160,
				code170 : code170
			},
			success : function(data) {
				if (data == 1) {
					alert("申请发送成功！！");
					loadPageDatas($(".laypage_curr").text());
				} else {
					alert("申请发送失败！！");
				}
			},error : function() {
				alert("添加失败！！");
			}
		});
	});
}

function sampleForModel(){
	$(".sampleModel").click(function(){
		var wave=$(this).parent().parent().find("td:eq(2)").text().trim();
		var designImg=$(this).parent().parent().find("td:eq(7)>img").attr("src");
		var productCode=$(this).parent().parent().find("td:eq(1)").text().trim();
		$("#wave").val(wave);
		$("#designImg").val(designImg);
		$("#productCode").val(productCode);
		$("#shippingAddress").val("");
	});
}

var mySelectForm = "";
function mySelect() {
	$("#mySelectProduct").click(function() {
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData("productToBack/selProductToBack.do?" + mySelectForm, 1);
		$(".col-md-2>input").val("");
	});
}

function commitSampleModel(){
	$("#commitSampleForMode").click(function(){
		var myform=$("#sample_for_model_form").serialize();
		$.ajax({
			url:"sampleArrange/addForModel.do",
			type:'post',
			dataType:'json',
			data:myform,
			success:function(mydata){
				alert("调样衣成功");
			}
		});
	});
}
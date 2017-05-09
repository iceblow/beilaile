$(function() {
	var url=location.href;
	var hrefArray=url.split("?");
	if(hrefArray.length==1){
		loadPageDatas(1);
	}else {
		$("#mySelect_From>div:eq(0)>input").val(hrefArray[1])
		mySelectForm = $("#mySelect_From").serialize();
		firstLoadData($("#path").val()
				+ "/productInfo/getDataByPage.do?" + mySelectForm, 1);
	}
	// 添加方法
	addData();
	// 点击查询方法
	mySelect();
	// 修改提交方法
	myupdate();
});

// 进入后台进行分页查询
function loadPageDatas(index) {

	// 处理后的数据
	firstLoadData($("#path").val() + "/productInfo/getDataByPage.do", index);

}
// 查询完成,打印数据
function loadData(mydata) {

	// B种打印方式--打印处理后的数据
	testB(mydata);
}

function testB(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, x) {
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
								|| x.idexcleFile == "" ? "<td></td>"
								: "<td align='center'>" + x.excleFile + "</td>";// excle文件
						var productImg = x.productImg == null
								|| x.productImg == "" ? "<td></td>"
								: "<td align='center'><img src=" + x.productImg
										+ " width='100px' height='80px'></td>";// 商品图片
						var processImg = x.processImg == null
								|| x.processImg == "" ? "<td></td>"
								: "<td><a href='" + x.processImg
										+ "'>工艺单</a></td>"
						var sizeImg = x.sizeImg == null || x.sizeImg == "" ? "<td></td>"
								: "<td><a href='" + x.sizeImg + "'>尺码表</a></td>"
						var deleteType = x.deleteType == 1 ? "<td align='center'><a data-toggle='modal' href='javascript:;' class='del'>删除</a></td>"
								: "<td align='center'>不可删除</td>";
						// alert(productImg + Date());
						$("tbody")
								.append(
										"<tr>"
												+ id
												+ productCodes
												+ wave
												+ productName
												+ productOldName
												+ productShortName
												+ excleFile
												+ productImg
												+ processImg
												+ sizeImg
												+ deleteType
												+ "<td  align='center'><a data-toggle='modal' data-target='#myModal1' href='javascript:;' class='update'>修改</a></td></tr>");
					});

	update();
	myDelete();
}

function Clear() {
	$(".col-md-4 >input").val("");
}

function addData() {
	$("#addSub").click(
			function() {
				var formData = new FormData($("#add_form")[0]);
				$.ajax({
					url : '/productInfo/addData.do',
					type : 'POST',
					data : formData,
					async : false,
					cache : false,
					contentType : false,
					processData : false,
					success : function(data) {
						if (data == 1) {
							// alert("添加成功");
							firstLoadData($("#path").val()
									+ "/productInfo/getDataByPage.do", 1);
						} else {
							alert("添加失败");
						}
					}
				});
			});

}
var mySelectForm = "";
function mySelect() {
	$("#mySelectProduct").click(
			function() {
				mySelectForm = $("#mySelect_From").serialize();
				firstLoadData($("#path").val()
						+ "/productInfo/getDataByPage.do?" + mySelectForm, 1);
				$(".col-md-2>input").val("");
			});
}

function update() {
	$(".update").click(function() {
		$(".col-md-4>input").val("");
		var id = $(this).parent().parent().find("td:eq(0)").text().trim();
		$.ajax({
			url : '/productInfo/getOne.do',
			dataType : 'json',
			type : 'post',
			data : {
				id : id,
			},
			success : function(data) {
				$("#id").val(data.id);
				$("#productCodes").val(data.productCodes);
				$("#wave").val(data.wave);
				$("#productName").val(data.productName);
				$("#productOldName").val(data.productOldName);
				$("#productShortName").val(data.productShortName);
				$("#excleFile").val(data.excleFile);
				$("#productImg").val(data.productImg);
			}
		});
	});
}

function myupdate() {
	$("#updateSub").click(
			function() {
				var formData = new FormData($("#update_form")[0]);
				$.ajax({
					url : '/productInfo/updateData.do',
					type : 'POST',
					data : formData,
					async : false,
					cache : false,
					contentType : false,
					processData : false,
					success : function(data) {
						if (data == 1) {
							alert("修改成功");
							firstLoadData($("#path").val()
									+ "/productInfo/getDataByPage.do?"
									+ mySelectForm, $(".laypage_curr").text()
									.trim());
						} else {
							alert("修改失败");
						}
					}
				});
			});
}

function myDelete() {
	$(".del").click(
			function() {
				var id = $(this).parent().parent().find("td:eq(0)").text()
						.trim();
				$.ajax({
					url : '/productInfo/deleteOne.do',
					dataType : 'json',
					type : 'post',
					data : {
						id : id,
					},
					success : function(data) {
						if (data == 1) {
							alert("删除成功");
							firstLoadData($("#path").val()
									+ "/productInfo/getDataByPage.do?"
									+ mySelectForm, $(".laypage_curr").text()
									.trim());
						}
					}
				});
			});
}
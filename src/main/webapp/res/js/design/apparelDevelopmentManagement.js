/**
 * 服装开发管理
 */
$(function() {
	// 查询
	loadPageDatas(1);
	// 模糊查询
	loadPageDataByLike();
	// 修改
	myupdate();
	// 全选
	checkAll();
	// 生成Excel表
	toExcel();
	// 检查波次号
	checkGirard();
	// 生成工艺单
	toSampleImg();
	// 打印工艺单
	printImg();
	//生成报表
	toReport();	
	
});
function checkGirard() {
	// 添加验证
	$("#girard").blur(function() {
		var girard = $("#girard").val();
		$.ajax({
			url : '/apparelDevelopmentManagement/checkGirard.do',
			dataType : 'json',
			type : 'post',
			data : {girard : girard},
			success : function(data) {
				if (data == 0) {
					$("#addApparelDevelopmentManagement").show();
					addApparelDevelopmentManagement();
				} else {
					alert("此波次已存在");
					$("#addApparelDevelopmentManagement").hide();
				}
			}
		});
	});
}
// 清空添加框
function clear() {
	$("#add").click(function() {
	$("#add_form_input").find('div').find('div').find(":input").each(function() {
				$(this).val("");
			});
	});
}
var mySelectForm = ""
// 模糊查询
function loadPageDataByLike() {
	$("#checkbtn").click(function() {
		var girard = $("#checkByGirard").val().trim();
		var merchantId = $("#checkByMerchantId").val().trim();
		var designer = $("#checkByDesigner").val().trim();
		var model = $("#checkByModel").val().trim();
		// var plate = $("#checkByPlate").val().trim();
		var clothName = $("#checkByClothName").val().trim();
		var platewave = $("#checkByPlatewave").val().trim();
		var referPrint = $("#checkByReferprint").val().trim();
		var sampleImg = $("#checkBySampleImg").val().trim();
		var processImg = $("#checkByProcessImg").val().trim();
		var designTime = $("#checkByDesignTime").val();
		mySelectForm = $("#myselect-from").serialize();
		firstLoadData(
				"/apparelDevelopmentManagement/apparelDevelopmentManagementBylike.do?"+mySelectForm, 1);
		$("#checkByGirard").val("");
		$("#checkByMerchantId").val("");
		$("#checkByDesigner").val("");
		$("#checkByModel").val("");
		// $("#checkByPlate").val("");
		$("#checkByClothName").val("");
		$("#checkByPlatewave").val("");
		$("#checkByReferprint").val("");
		$("#checkBySampleImg").val("");
		$("#checkByProcessImg").val("");
		$("#checkByDesignTime").val("");
	});
}
// 分页
function loadPageDatas(index) {
	// 处理后的数据
	firstLoadData("/apparelDevelopmentManagement/apparelDevelopmentManagementBylike.do",index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	getapparelDevelopmentManagement(mydata);
}
function getapparelDevelopmentManagement(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, a) {
		var sampleImg = "";
		if (a.sampleImg != null) {
			sampleImg = "<a href='" + a.sampleImg+ "' target='_blank'>工艺单</a>"
		}
		var childImg = "";
		if (a.childImg != null) {
			childImg = "<a href='" + a.childImg+ "' target='_blank'>尺码表</a>"
		}
		var processImg = "";
		if (a.processImg != null) {
			processImg = "<a href='" + a.processImg+ "' target='_blank'>头样图</a>"
		}
		var processPatternImg = "";
		if (a.processPatternImg != null) {
			processPatternImg = "<a href='" + a.processPatternImg+ "' target='_blank' >图样工艺单</a>"
		}
		update="<a data-toggle='modal' data-target='#myModal1' class='updateApparelDevelopmentManagement' href='javascript:;'>修改</a>";
		del="<a class='delApparelDevelopmentManagement'  href='javascript:;'>删除</a>";
		if(a.completeTime !=null){
			del="已下单";
		}
		// var PRJ = "";
		// if (a.paperpatternPrjFile != null) {
		// PRJ = "<a href='" + a.paperpatternPrjFile
		// + "' target='_blank'>PRJ</a>" }
		// var EMF = "";
		// if (a.paperpatternEmfFile != null) {
		// EMF = "<a href='" + a.paperpatternEmfFile
		// + "' target='_blank'>EMF</a>" }
		$("tbody").append(
			"<tr><input type='hidden' class='id' value='"
			+ a.id
			+ "'/><input type='hidden' class='smallSampleNumA' value='"
			+ a.smallSampleNumA
			+ "'/><input type='hidden' class='smallSampleNumB' value='"
			+ a.smallSampleNumB
			+ "'/><input type='hidden' class='smallSampleNumC' value='"
			+ a.smallSampleNumC
			+ "'/><input type='hidden' class='smallSampleNumD' value='"
			+ a.smallSampleNumD
			+ "'/><input type='hidden' class='smallSampleNumE' value='"
			+ a.smallSampleNumE
			+ "'/><input type='hidden' class='smallSampleNumF' value='"
			+ a.smallSampleNumF
			+ "'/>"
			+ "<td style='text-align: center;'>"
			+ "<input type='checkbox' class='check' name='check' /> "
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ (a.girard == null ? "": a.girard)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='merchantId'>"
			+ (a.merchantId == null ? "": a.merchantId)
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ (a.designer == null ? "": a.designer)
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ (a.model == null ? "": a.model)
			+ "</td>"
			// + "<td style='text-align:center;'>" + (a.plate == null ? "":a.plate) + "</td>"
			+ "<td style='text-align: center;'>"
			+ (a.platewave == null ? "": a.platewave)
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ (a.referPrint == null ? "": a.referPrint)
			+ "</td>"
			// + "<td style='text-align:center;'>"+ (a.clothName == null ? "":a.clothName)+ "</td>"
			// + "<td style='text-align:center;'>"+ EMF + "</td>"
			// + "<td style='text-align:center;'>"+ PRJ+ "</td>"
			+ "<td style='text-align: center;'>"
			+ "<img width='50px' height='40px' src='"
			+ a.designImg
			+ "'/></td>"
			+ "<td style='text-align: center;'>"
			+ processImg
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ sampleImg
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ processPatternImg
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ childImg
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ (a.code52 == null ||a.code52==0? "": " 52/"+a.code52)
			+ (a.code59 == null ||a.code59==0? "": " 59/"+a.code59)
			+ (a.code66 == null ||a.code66==0? "": " 66/"+a.code66)
			+ (a.code73 == null ||a.code73==0? "": " 73/"+a.code73)
			+ (a.code80 == null ||a.code80==0? "": " 80/"+a.code80)
			+ (a.code90 == null ||a.code90==0? "": " 90/"+a.code90)
			+ (a.code100== null ||a.code100==0? "":" 100/"+a.code100)
			+ (a.code110== null ||a.code110==0? "":" 110/"+a.code110)
			+ (a.code120== null ||a.code120==0? "":" 120/"+a.code120)
			+ (a.code130== null ||a.code130==0? "":" 130/"+a.code130)
			+ (a.code160== null ||a.code160==0? "":" 160/"+a.code160)
			+ (a.code170== null ||a.code170==0? "":" 170/"+a.code170)
			+ "</td><td style='text-align: center;'>"
			+ (a.total == null|| a.total == "" ? 0: a.total)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='print'>"
			+ (a.print==null?"":a.print)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='filmPrint'>"
			+ (a.filmPrint==null?"":a.filmPrint)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='embroidery'>"
			+ (a.embroidery==null?"":a.embroidery)
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ (a.designTime == null ? "": a.designTime)
			+ "</td>"
			// /////////////////
			/*
			 * + "<td style='text-align: center;' class='mydblClick' name='codeNum'>" +
			 * (a.codeNum == null ? "" : a.codeNum) + "</td>" + "<td style='text-align: center;' class='mydblClick' name='audit'>" +
			 * (a.audit == null ? "" : a.audit) + "</td>" + "<td style='text-align: center;' class='mydblClick' name='pattern'>" +
			 * (a.pattern == null ? "" :a.pattern) + "</td>" + "<td style='text-align: center;' class='mydblClick' name='carversion'>" +
			 * (a.carversion == null ? "" :a.carversion) + "</td>" + "<td style='text-align: center;' class='mydblClick' name='releasedate'>" +
			 * (a.releasedate == null ? "" :a.releasedate) + "</td>" + "<td style='text-align: center;' class='mydblClick' name='completiondate'>" +
			 * (a.completiondate == null ? "" :a.completiondate) + "</td>" + "<td style='text-align: center;' class='mydblClick' name='sizeconfirmation'>" +
			 * (a.sizeconfirmation == null ? "" :a.sizeconfirmation) + "</td>" + "<td style='text-align: center;' class='mydblClick' name='obsolete'>" +
			 * (a.obsolete == null ? "" :a.obsolete) + "</td>" + "<td style='text-align: center;' class='mydblClick' name='merchandiser'>" +
			 * (a.merchandiser == null ? "" :a.merchandiser) + "</td>" + "<td style='text-align: center;' class='mydblClick' name='supplier'>" +
			 * (a.supplier == null ? "" : a.supplier) + "</td>"
			 */
			// a
			+ "<td style='text-align: center;' class='mydblClickfabric' name='smallSampleNumA'>"
			+ (a.smallsamplea == null ? "": a.smallsamplea)
			+ "</td>"
			//+"<td style='text-align:center;' class='mydblClick' name='addressa'>"+(a.addressa == null?"":a.addressa)+"</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='widtha'>"
			+ (a.widtha == null ? "": a.widtha)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='ingredienta'>"
			+ (a.ingredienta == null ? "": a.ingredienta)
			+ "</td>"
			// b
			+ "<td style='text-align: center;' class='mydblClickfabric' name='smallSampleNumB'>"
			+ (a.smallsampleb == null ? "": a.smallsampleb)
			+ "</td>"
			// + "<td style='text-align:center;' class='mydblClick' name='addressb'>" + (a.addressb == null ? "" :a.addressb) + "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='widthb'>"
			+ (a.widthb == null ? "": a.widthb)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='ingredientb'>"
			+ (a.ingredientb == null ? "": a.ingredientb)
			+ "</td>"
			// c
			+ "<td style='text-align: center;' class='mydblClickfabric' name='smallSampleNumC'>"
			+ (a.smallsamplec == null ? "": a.smallsamplec)
			+ "</td>"
			// + "<td style='text-align:center;' class='mydblClick' name='addressc'>" + (a.addressc == null ? "" : a.addressc)
			+ "<td style='text-align: center;' class='mydblClick' name='widthc'>"
			+ (a.widthc == null ? "": a.widthc)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='ingredientc'>"
			+ (a.ingredientc == null ? "": a.ingredientc)
			+ "</td>"
			// d
			+ "<td style='text-align: center;' class='mydblClickfabric' name='smallSampleNumD'>"
			+ (a.smallsampled == null ? "": a.smallsampled)
			+ "</td>"
			// + "<td  style='text-align:center;' class='mydblClick'name='addressd'>" +(a.addressd == null ? "" : a.addressd)
			+ "<td style='text-align: center;' class='mydblClick' name='widthd'>"
			+ (a.widthd == null ? "": a.widthd)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='ingredientd'>"
			+ (a.ingredientd == null ? "": a.ingredientd)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClickfabric' name='smallSampleNumE'>"
			+ (a.smallsamplee == null ? "": a.smallsamplee)
			+ "</td>"
			// + "<td style='text-align:center;' class='mydblClick'name='addresse'>"+(a.addresse == null ? "" :a.addresse)
			+ "<td style='text-align: center;' class='mydblClick' name='widthe'>"
			+ (a.widthe == null ? "": a.widthe)
			+ "</td>"
			//e
			+ "<td style='text-align: center;' class='mydblClick' name='ingrediente'>"
			+ (a.ingrediente == null ? "": a.ingrediente)
			+ "</td>"
			//新增的F
			+ "<td style='text-align: center;' class='mydblClickfabric' name='smallSampleNumF'>"
			+ (a.smallsamplef == null ? "": a.smallsamplef)
			+ "</td>"
			// + "<td style='text-align:center;' class='mydblClick'name='addressf'>"+(a.addressf == null ? "" :a.addressf)
			+ "<td style='text-align: center;' class='mydblClick' name='widthf'>"
			+ (a.widthf == null ? "": a.widthf)
			+ "</td>"
			//f
			+ "<td style='text-align: center;' class='mydblClick' name='ingredientf'>"
			+ (a.ingredientf == null ? "": a.ingredientf)
			+ "</td>"
			//辅料
			+ "<td style='text-align: center;' class='mydblClick' name='smallsampleaf'>"
			+ (a.smallsampleaf == null ? "": a.smallsampleaf)
			+ "</td>"
// 			+ "<td style='text-align:center;' class='mydblClick'name='addressaf'>" + (a.addressaf == null ? "":a.addressaf) + "</td>"
//			+ "<td style='text-align: center;' class='mydblClick' name='widthaf'>"+ (a.widthaf == null ? "": a.widthaf)
//			+ "</td>"+"<td style='text-align: center;' class='mydblClick' name='ingredientaf'>"+ (a.ingredientaf == null ? "": a.ingredientaf)+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='smallsamplebf'>"
			+ (a.smallsamplebf == null ? "": a.smallsamplebf)
			+ "</td>"
//   		+ "<td style='text-align:center;' class='mydblClick' name='addressbf'>" + (a.addressbf == null ? "": a.addressbf)+ "</td>"
//			+ "<td style='text-align: center;' class='mydblClick' name='widthbf'>"+ (a.widthbf == null ? "": a.widthbf)+ "</td>"
//			+ "<td style='text-align: center;' class='mydblClick' name='ingredientbf'>"+ (a.ingredientbf == null ? "": a.ingredientbf)+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='smallsamplecf'>"
			+ (a.smallsamplecf == null ? "": a.smallsamplecf)
			+ "</td>"
// 			+ "<td style='text-align:center;'class='mydblClick'name='addresscf'>"+ (a.addresscf == null ? "" :a.addresscf)+ "</td>"
//			+ "<td style='text-align: center;' class='mydblClick' name='widthcf'>"+ (a.widthcf == null ? "": a.widthcf)+ "</td>"
//			+ "<td style='text-align: center;' class='mydblClick' name='ingredientcf'>"+ (a.ingredientcf == null ? "": a.ingredientcf)+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='printPosition'>"
			+ (a.printPosition == null ? "": a.printPosition)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='embroideredPosition'>"
			+ (a.embroideredPosition == null ? "": a.embroideredPosition)
			+ "</td>"
			// /////////////////////////////////
			+ "<td style='text-align: center;'>"
			+ (a.remark == null ? "": a.remark)
			+ "</td>"
			+ "<td style='text-align: center;'>" 
			+del
			+"</td><td style='text-align: center;'>" 
			+update 
			+"</td></tr>");
	});
	// 删除
	delApparelDevelopmentManagement();
	// 获取修改的信息
	getupp();
	// 双击修改
	updbclick();
	//双击修改面料
	updbclickfabric();

}
// ///////////////双击修改////////////////
function updbclick() {
	$(".mydblClick").on("dblclick",function() {
		var id = $(this).parent().find(".id").val();
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
		var data = {id : id};
		data[name] = newtxt;
		$.ajax({
			url : '/apparelDevelopmentManagement/dbuppApparelDevelopmentManagerment.do',
			dataType : 'json',
			type : 'post',
			data : data,
			success : function(data) {
				if (data == 1) {
					firstLoadData("/apparelDevelopmentManagement/apparelDevelopmentManagementBylike.do?"
							+ mySelectForm,$(".laypage_curr").text());
				}
			},error : function() {
				alert("修改失败,输入的类型错误!");
			}
		});
	});
}
/////////////////双击修改面料////////////////
function updbclickfabric() {
	$(".mydblClickfabric").on("dblclick",function() {
		var id = $(this).parent().find(".id").val();
		var name=$(this).attr("name");
		var code ="";
		if(name=="smallSampleNumA"){
			code=$(this).parent().find(".smallSampleNumA").val()=="null"?"":$(this).parent().find(".smallSampleNumA").val();
		}else if(name=="smallSampleNumB"){
			 code=$(this).parent().find(".smallSampleNumB").val()=="null"?"":$(this).parent().find(".smallSampleNumB").val();
		}else if(name=="smallSampleNumC"){
			 code=$(this).parent().find(".smallSampleNumC").val()=="null"?"":$(this).parent().find(".smallSampleNumC").val();
		}else if(name=="smallSampleNumD"){
			 code=$(this).parent().find(".smallSampleNumD").val()=="null"?"":$(this).parent().find(".smallSampleNumD").val();
		}else if(name=="smallSampleNumE"){
			 code=$(this).parent().find(".smallSampleNumE").val()=="null"?"":$(this).parent().find(".smallSampleNumE").val();
		}else if(name=="smallSampleNumF"){
			 code=$(this).parent().find(".smallSampleNumF").val()=="null"?"":$(this).parent().find(".smallSampleNumF").val();
		}
		$(this).html("<input id='" + id + "' type='text' value='" + code+ "' name='" + name + "' style='width:100px;'> ");
		$("#" + id).focus();// 文本框获取光标事件
		uppfabricBlur(id, name);
	});
}
// 光标离开事件
function uppfabricBlur(id, name) {
	$("#" + id).blur(function() {
		var newtxt = $(this).val().trim();
		$(this).closest("td").text(newtxt);
		var data = {id : id,type:name};
		data[name] = newtxt;
		$.ajax({
			url : '/apparelDevelopmentManagement/checkClothName.do',
			dataType : 'json',
			type : 'post',
			data : data,
			success : function(data) {
			 if(data==2){
					if(confirm("该编号不存在，是否跳转到面料添加？")){
						window.open("fabricSupplier.html");
					}
				}
			},error : function() {
				alert("修改失败,系统错误!");
			}
		});
		firstLoadData("/apparelDevelopmentManagement/apparelDevelopmentManagementBylike.do?"
				+ mySelectForm,$(".laypage_curr").text());
	});
}
// /////////////////////////////////////////
// 后台获取数据
function getupp() {
	$(".updateApparelDevelopmentManagement").bind("click",function() {
		//加载前清空图片
		$("#udesignImg").val("");
		$("#uprocessImg").val("");
		$("#uchildImg").val("");
		$("#uprocessPatternImg").val("");
		//获取当前页
		var myIndex = $(".laypage_curr").text().trim();
		$("#myIndex").val(myIndex);
		var id = $(this).parent().parent().find(".id").val();//获取ID
		$.ajax({
			url : '/apparelDevelopmentManagement/getApparelDevelopmentManagementById.do',
			datatype : 'json',
			type : 'post',
			data : {id : id},
			success : function(data) {
				var record = eval(data);
				$("#id").val(record.id);
				$("#ugirard").val(record.girard);
				$("#uclothName").val(record.clothName);
				$("#udesigner").val(record.designer);
				$("#umerchantId").val(record.merchantId);
				$("#umodel").val(record.model);
				$("#uplate").val(record.plate);
				$("#uplatewave").val(record.platewave);
				$("#ureferPrint").val(record.referPrint);
				$("#udesignTime").val(record.designTime);
				$("#ucode52").val(record.code52 == 0 ? "": record.code52);
				$("#ucode59").val(record.code59 == 0 ? "": record.code59);
				$("#ucode66").val(record.code66 == 0 ? "": record.code66);
				$("#ucode73").val(record.code73 == 0 ? "": record.code73);
				$("#ucode80").val(record.code80 == 0 ? "": record.code80);
				$("#ucode90").val(record.code90 == 0 ? "": record.code90);
				$("#ucode100").val(record.code100 == 0 ? "": record.code100);
				$("#ucode110").val(record.code110 == 0 ? "": record.code110);
				$("#ucode120").val(record.code120 == 0 ? "": record.code120);
				$("#ucode130").val(record.code130 == 0 ? "": record.code130);
				$("#ucode160").val(record.code160 == 0 ? "": record.code160);
				$("#ucode170").val(record.code170 == 0 ? "": record.code170);
				$("#uremark").val(record.remark);
				$(".code").removeAttr("readonly");//删除只读属性
				if(record.completeTime!=null){//alert("工艺单已存在!");
					$(".code").attr("readonly","true");
				}
				$("#udesignImg").val(record.designImg);
				$("#uprocessImg").val(record.processImg);
				$("#uprocessPatternImg").val(record.processPatternImg);
				$("#uchildImg").val(record.childImg);
			}
		});
	});
}
// 删除 ==========delApparelDevelopmentManagement
function delApparelDevelopmentManagement() {
	$(".delApparelDevelopmentManagement").bind("click",function() {
		var id = $(this).parent().parent().find("input").val();
		if (confirm('确定要删除此条数据吗?')) {
			$.ajax({
				url : 'apparelDevelopmentManagement/delApparelDevelopmentManagerment.do',
				datatype : 'json',
				type : 'post',
				data : {id : id},
				success : function(data) {
					firstLoadData("/apparelDevelopmentManagement/apparelDevelopmentManagementBylike.do?"
							+ mySelectForm,$(".laypage_curr").text());
				}
			});
		} else {
			return false;
		}
	});
}
// 全选========点击id=checkbox 全部选中或取消
function checkAll() {
	$("#checkbox").attr("checked", false);
	$('#checkbox').click(function() {
		if (this.checked) {
			$("input[name='check']").each(function() {
				this.checked = true;
			});
		} else {
			$("input[name='check']").each(function() {
				this.checked = false;
			});
		}
	});
	$("[name='check']").click(function() {
		if ($("[name='check']").is("checked")) {
		} else {
			$('#checkbox').attr("checked", false);
		}
	});
}
// toExcel()====下面的获取的值
function toExcel() {
	$("#Excelbtn").on("click",function() {
		var ids = "";
		$("#tbody").find(":checkbox:checked").each(function() {
			var id = $(this).parent().parent().find("input").val();
			ids += id + ",";
		});
		if (ids == "") {
			alert("请选择要导出的数据");
		} else {
			$.ajax({
				url : '/apparelDevelopmentManagement/excel.do',
				datatype : 'json',
				type : 'post',
				data : {
					ids : ids
				},
				success : function(data) {
					var form = $("<form>");// 定义一个form表单
					form.attr("style", "display:none");
					form.attr("name", "mainform");
					form.attr("target", "");
					form.attr("method", "post");
					form.attr("action","/apparelDevelopmentManagement/excels.do");
					var input1 = $("<input>");
					input1.attr("type", "hidden");
					input1.attr("name", "file");
					input1.attr("value", data);
					$("#excelss").append(form);// 将表单放置在web中
					form.append(input1);
					form.submit();// 表单提交
				}
			});
		}
	});
}
// 添加 addApparelDevelopmentManagement
function addApparelDevelopmentManagement() {
	$("#addApparelDevelopmentManagement").unbind('click').bind('click',function() {
		var formData = new FormData($("#add_form")[0]);
		
		$.ajax({
			url : '/apparelDevelopmentManagement/addApparelDevelopmentManagement.do',
			type : 'POST',
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data) {
				if (data == 1) {
					loadPageDatas(1);
				}
				// 清空添加框
				clear();
			},
			error : function() {
				alert("添加失败!系统错误！");
			}
		});
	});
}
// 修改
function myupdate() {
	$("#myupdate").unbind('click').bind("click",function() {
		var formData = new FormData($("#myupp-form")[0]);
		$.ajax({
			url : '/apparelDevelopmentManagement/uppApparelDevelopmentManagerment.do',
			type : 'POST',
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data) {
				firstLoadData("/apparelDevelopmentManagement/apparelDevelopmentManagementBylike.do?"
								+ mySelectForm,$(".laypage_curr").text());
			},
			error : function(data) {
				alert("修改失败，系统错误！");
			}
		});
	});
}
// 生成工艺单
function toSampleImg() {
	$("#sampleImg").on("click", function() {
		var ids = "";
		$("#tbody").find(":checkbox:checked").each(function() {
			var id = $(this).parent().parent().find("input").val();
			ids += id + ",";
		});
		if (ids == "") {
			alert("请选择要导出的数据");
		} else {
			if (confirm('确定要生成工艺单吗?')) {
				$.ajax({
					url : '/apparelDevelopmentManagement/toSampleImg.do',
					datatype : 'json',
					type : 'post',
					data : {
						ids : ids
					},
					success : function(data) {
						if (data == 3) {
							// alert("工艺单生成成功！！");
							// 发送提示到理单跟踪------------待定
						} else if (data == 2) {
							alert("工艺单生成错误！头样图找不到！");
						} else {
							alert("工艺单生成失败！");
						}
						loadPageDatas($(".laypage_curr").text());
						$('#checkbox').attr("checked", false);
					},
					error : function() {
						alert("生成工艺单出错！！系统错误！！");
						loadPageDatas($(".laypage_curr").text());
					}
				});
			} else {
				return false;
			}
		}
	});
}
// 打印工艺单
function printImg() {
	$("#printImg").click(function() {
		if (confirm('确定要打印工艺单吗?')) {
			$("#tbody").find(":checkbox:checked").each(function() {
				var id = $(this).parent().parent().find("input").val();
				if (id.length > 0) {
					$.ajax({
						url : '/apparelDevelopmentManagement/getApparelDevelopmentManagementById.do',
						datatype : 'json',
						type : 'post',
						data : {id : id},
						success : function(data) {
							if (data.sampleImg.length != 0) {
								if (data.sampleImg != null) {
									var sample = $("<img src='"+ data.sampleImg+ "' width='100%' height=100%>")
											.get(0);
									$(sample).jqprint();
								}
							} else {
								alert("该工艺单不存在！");
							}
							loadPageDatas($(".laypage_curr").text());
						}
					});
				}
			});
		} else {
			return false;
		}
		loadPageDatas($(".laypage_curr").text());
	});
}
//生成Excel报表
function toReport(){
	$("#toRepotr_test").on("click",function(){
		var time=$("#odesignTime").val();
		var endTime=$("#edesignTime").val();
		window.open("/apparelDevelopmentManagement/toExcelTest.do?startTime="+ time+"&endTime="+endTime);
	});
	
}
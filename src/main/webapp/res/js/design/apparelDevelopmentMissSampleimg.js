/**
 * 服装开发管理
 */
$(function() {
	// 查询
	loadPageDatas(1);
	// 模糊查询
	loadPageDataByLike();
	// 清空添加框
	clear();
	addApparelDevelopmentManagement();
	// 修改
	myupdate();
	// 全选
	checkAll();
	// 生成工艺单
	toSampleImg();
	// 打印工艺单printImg();
	
});
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
		mySelectForm = $("#myselect-from").serialize();
		firstLoadData(
				"/apparelDevelopmentMissSampleimg/apparelDevelopmentMissSampleimgBylike.do?"+mySelectForm, 1);
		$("#checkByGirard").val("");
		$("#checkByMerchantId").val("");
		$("#checkByDesigner").val("");
		$("#checkByModel").val("");
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
	firstLoadData("/apparelDevelopmentMissSampleimg/apparelDevelopmentMissSampleimgBylike.do",index);
}
// 分页查询以后前台页面打印
function loadData(mydata) {
	// 打印处理后的数据
	getapparelDevelopmentMissSampleimg(mydata);
}
function getapparelDevelopmentMissSampleimg(mydata) {
	$("tbody").empty();
	$.each(mydata,function(index, a) {
		var str = "";
		if (a.sampleImg != null && a.sampleImg!='') {
			str = "<a href='" + a.sampleImg+ "' target='_blank'>工艺单</a>"
		}
		var str1 = "";
		if (a.childImg != null && a.childImg!='') {
			str1 = "<a href='" + a.childImg+ "' target='_blank'>尺码表</a>"
		}
		var str2 = "";
		if (a.processImg != null && a.processImg!='') {
			str2 = "<a href='" + a.processImg+ "' target='_blank'>头样图</a>"
		}
//		var str3 = "";
//		if (a.processPatternImg != null) {
//			str3 = "<a href='" + a.processPatternImg+ "' target='_blank' >图样工艺单</a>"
//		}
		$("tbody").append(
			"<tr "+(a.completeTime!=null?"style='background:aquamarine;'":'') 
			+"><input type='hidden' class='id' value='"
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
			+ "'/>"
			+ "<td style='text-align: center;'>"
			+ "<input type='checkbox' class='check' name='check' /> "
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ (a.girard == null ? "": a.girard)
			+ "</td>"
			+ "<td style='text-align: center;'  class='mydblClick' name='originalWave'>"
			+ (a.originalWave == null ? "": a.originalWave)
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ (a.merchantId == null ? "": a.merchantId)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='designer'>"
			+ (a.designer == null ? "": a.designer)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='model'>"
			+ (a.model == null ? "": a.model)
			+ "</td>"
			// + "<td style='text-align:center;'>"
			// + (a.plate == null ? "":a.plate)
			// + "</td>"
			+ "<td style='text-align: center;'  class='mydblClick' name='platewave'>"
			+ (a.platewave == null ? "": a.platewave)
			+ "</td>"
			+ "<td style='text-align: center;'  class='mydblClick' name='referPrint'>"
			+ (a.referPrint == null ? "": a.referPrint)
			+ "</td>"
			// + "<td style='text-align:center;'>"
			// + (a.clothName == null ? "":  a.clothName)
			// + "</td>"
			+ "<td style='text-align: center;'>"
			+ "<img width='50px' height='40px' src='"
			+ a.designImg
			+ "'/></td>"
			+ "<td style='text-align: center;'>"
			+ str2
			+ "</td>"
			+ "<td style='text-align: center;'>"
			+ str
			+ "</td>"
			//+ "<td style='text-align: center;'>"
			//+ str3
			//+ "</td>"
			+ "<td style='text-align: center;'>"
			+ str1
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
			// a
			+ "<td style='text-align: center;' class='mydblClickfabric' name='smallSampleNumA'>"
			+ (a.smallsamplea == null ? "": a.smallsamplea)
			+ "</td>"
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
			+ "<td style='text-align: center;' class='mydblClick' name='widthd'>"
			+ (a.widthd == null ? "": a.widthd)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='ingredientd'>"
			+ (a.ingredientd == null ? "": a.ingredientd)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClickfabric' name='smallSampleNumE'>"
			+ (a.smallsamplee == null ? "": a.smallsamplee)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='widthe'>"
			+ (a.widthe == null ? "": a.widthe)
			+ "</td>"
			//e
			+ "<td style='text-align: center;' class='mydblClick' name='ingrediente'>"
			+ (a.ingrediente == null ? "": a.ingrediente)
			+ "</td>"
			//辅料
			+ "<td style='text-align: center;' class='mydblClick' name='smallsampleaf'>"
			+ (a.smallsampleaf == null ? "": a.smallsampleaf)
			+ "</td>"
			+ "<td style='text-align: center;' clas" +
					"s='mydblClick' name='smallsamplebf'>"
			+ (a.smallsamplebf == null ? "": a.smallsamplebf)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='smallsamplecf'>"
			+ (a.smallsamplecf == null ? "": a.smallsamplecf)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='printPosition'>"
			+ (a.printPosition == null ? "": a.printPosition)
			+ "</td>"
			+ "<td style='text-align: center;' class='mydblClick' name='embroideredPosition'>"
			+ (a.embroideredPosition == null ? "": a.embroideredPosition)
			+ "</td>"
			// /////////////////////////////////
			+ "<td style='text-align: center;'class='mydblClick' name='remark'>"
			+ (a.remark == null ? "": a.remark)
			+ "</td>"
			+ "<td style='text-align: center;'><a data-toggle='modal' data-target='#myModal1' class='updateApparelDevelopmentMissSampleimg' href='javascript:;'>修改</a>"
			+"</td></tr>");
	});
	// 获取修改的信息
	getupp();
	// 双击修改
	updbclick();
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
			url : '/apparelDevelopmentMissSampleimg/dbuppApparelDevelopmentMissSampleimg.do',
			dataType : 'json',
			type : 'post',
			data : data,
			success : function(data) {
				if (data == 1) {
					firstLoadData("/apparelDevelopmentMissSampleimg/apparelDevelopmentMissSampleimgBylike.do?"
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
		var name = $(this).attr("name");
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
		}
		$(this).html("<input id='" + id + "' type='text' value='" + code+ "' name='" + name + "' style='width:100px;'> ");
		$("#" + id).focus();// 文本框获取光标事件
		uppfabricBlur(id, name);
	});
}
// 光标离开事件
function uppfabricBlur(id, name) {
	$("#" + id).blur(function() {
		var newtxt = $(this).val();
	//	if(newtxt!=null&&newtxt!=""){
		$(this).closest("td").text(newtxt);
		var data = {id : id,type:name};
		data[name] = newtxt;
		$.ajax({
			url : '/apparelDevelopmentMissSampleimg/checkClothName.do',
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
	//	}
			firstLoadData("/apparelDevelopmentMissSampleimg/apparelDevelopmentMissSampleimgBylike.do?"
					+ mySelectForm,$(".laypage_curr").text());
		
	});
}
// /////////////////////////////////////////
// 后台获取数据
function getupp() {
	$(".updateApparelDevelopmentMissSampleimg").bind("click",function() {
		$("#udesignImg").val("");
		$("#uprocessImg").val("");
		$("#uchildImg").val("");
		$("#uprocessPatternImg").val("");
		var myIndex = $(".laypage_curr").text().trim();
		$("#myIndex").val(myIndex);
		var id = $(this).parent().parent().find(".id").val();
		var index = $(".laypage_curr").text();
		$.ajax({
			url : '/apparelDevelopmentMissSampleimg/getApparelDevelopmentMissSampleimgById.do',
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
				$("#udesignImg").val(record.designImg);
				$("#uprocessImg").val(record.processImg);
				$("#uprocessPatternImg").val(record.processPatternImg);
				$("#uchildImg").val(record.childImg);
				$("#index").val(index);
			}
		});
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

// 添加 addApparelDevelopmentManagement
function addApparelDevelopmentManagement() {
	$("#addApparelDevelopmentMissSampleimg").unbind('click').bind('click',function() {
		var formData = new FormData($("#add_form")[0]);
		$.ajax({
			url : 'apparelDevelopmentMissSampleimg/addApparelDevelopmentMissSampleimg.do',
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
			url : 'apparelDevelopmentMissSampleimg/uppApparelDevelopmentMissSampleimg.do',
			type : 'POST',
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data) {
				firstLoadData("/apparelDevelopmentMissSampleimg/apparelDevelopmentMissSampleimgBylike.do?"
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
					url : '/apparelDevelopmentMissSampleimg/toSampleImg.do',
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
//// 打印工艺单
//function printImg() {
//	$("#printImg").click(function() {
//		if (confirm('确定要打印工艺单吗?')) {
//			$("#tbody").find(":checkbox:checked").each(function() {
//				var id = $(this).parent().parent().find("input").val();
//				if (id.length > 0) {
//					$.ajax({
//						url : '/apparelDevelopmentMissSampleimg/getApparelDevelopmentMissSampleimgById.do',
//						datatype : 'json',
//						type : 'post',
//						data : {id : id},
//						success : function(data) {
//							if (data.sampleImg.length != 0) {
//								if (data.sampleImg != null) {
//									var sample = $("<img src='"+ data.sampleImg+ "' width='100%' height=100%>")
//											.get(0);
//									$(sample).jqprint();
//								}
//							} else {
//								alert("该工艺单不存在！");
//							}
//							loadPageDatas($(".laypage_curr").text());
//						}
//					});
//				}
//			});
//		} else {
//			return false;
//		}
//		loadPageDatas($(".laypage_curr").text());
//	});
//}
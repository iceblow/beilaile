$(function() {
	getAllByPage(1);
	myupdate();
	myselect();
});

// var type="0";

function getAllByPage(index) {
	firstLoadData("/auxiliaryFabric/getAllByPage.do", index);
}
function loadData(mydata) {
	$("tbody").empty();
	$
			.each(
					mydata,
					function(index, a) {
						var color = a.popper_color == null ? ''
								: a.popper_color;
						var mark_washORdrop = a.mark_washORdrop == null ? ''
								: a.mark_washORdrop;
						var mark_wash_element = a.mark_wash_element == null ? ''
								: a.mark_wash_element;
						var accessoryAName = a.accessoryAName == null ? ''
								: a.accessoryAName;
						var accessoryANum = a.accessoryANum == null ? ''
								: a.accessoryANum;
						var accessoryBName = a.accessoryBName == null ? ''
								: a.accessoryBName;
						var accessoryBNum = a.accessoryBNum == null ? ''
								: a.accessoryBNum;
						var accessoryCName = a.accessoryCName == null ? ''
								: a.accessoryCName;
						var accessoryCNum = a.accessoryCNum == null ? ''
								: a.accessoryCNum;
						var sample_img = a.sample_img == null ? '' : "<a href="
								+ a.sample_img + " target='_blank'>工艺单</a>";
						var child_img = a.child_img == null ? '' : "<a href="
								+ a.child_img + " target='_blank'>尺码图</a>";
						var paperpattern_emf_file = a.paperpattern_emf_file == null ? ''
								: "<a href=" + a.paperpattern_emf_file
										+ " target='_blank'>纸样emf图</a>";
						var paperpattern_prj_file = a.paperpattern_prj_file == null ? ''
								: "<a href=" + a.paperpattern_prj_file
										+ " target='_blank'>纸样prj图</a>";
						var remark = a.remark == null ? '' : a.remark;
						$("tbody")
								.append(
										"<tr><input type='hidden' class='id' value="
												+ a.id
												+ " /><td>"
												+ a.cloth_name
												+ "</td><td>"
												+ a.design_time
												+ "</td><td>"
												+ a.girard
												+ "</td><td>"
												+ a.model
												+ "</td><td>52/"
												+ a.code52+" 59/"
												+ a.code59+" 66/"
												+ a.code66+" 73/"
												+ a.code73+" 80/"
												+ a.code80+" 90/"
												+ a.code90
												+ "</td><td>"
												+ a.total
												+ "</td><td><img src="
												+ a.design_img
												+ " width='120px' height='120px'/></td><td>"
												+ sample_img
												+ "</td><td>"
												+ child_img
												+ "</td><td>"
												+ paperpattern_emf_file
												+ "</td><td>"
												+ paperpattern_prj_file
												+ "</td><td class='mydblClick' name='popper_color'>"
												+ color
												+ "</td><td class='mydblClick' name='popper_num'>"
												+ a.popper_num
												+ "</td><td class='mydblClick' name='mark_washORdrop'>"
												+ mark_washORdrop
												+ "</td><td class='mydblClick' name='mark_wash_element'>"
												+ mark_wash_element
												+ "</td><td class='mydblClick' name='accessoryAName'>"
												+ accessoryAName
												+ "</td><td class='mydblClick' name='accessoryANum'>"
												+ accessoryANum
												+ "</td><td class='mydblClick' name='accessoryBName'>"
												+ accessoryBName
												+ "</td><td class='mydblClick' name='accessoryBNum'>"
												+ accessoryBNum
												+ "</td><td class='mydblClick' name='accessoryCName'>"
												+ accessoryCName
												+ "</td><td class='mydblClick' name='accessoryCNum'>"
												+ accessoryCNum
												+ "</td><td class='mydblClick' name='remark'>"
												+ remark
												+ "</td><td style='text-align: center;'><a data-toggle='modal' data-target='#myModal1' class='updateAuxiliaryFabric' href='javascript:;'>修改</a></td></tr>");
					});
	updateGetData();
	mydblclick();
}

function updateGetData() {
	$(".updateAuxiliaryFabric").click(function() {

		var id = $(this).parent().parent().find(".id").val();
		$.ajax({
			url : '/auxiliaryFabric/getOne.do',
			type : 'POST',
			dataType : 'json',
			data : {
				id : id,
			},
			success : function(data) {
				$("#id").val(data.id);
				$("#popper_color").val(data.popper_color);
				$("#popper_num").val(data.popper_num);
				$("#mark_washORdrop").val(data.mark_washORdrop);
				$("#code52").val(data.code52);
				$("#code59").val(data.code59);
				$("#code66").val(data.code66);
				$("#code73").val(data.code73);
				$("#code80").val(data.code80);
				$("#code90").val(data.code90);
				$("#total").val(data.total);
				$("#mark_wash_element").val(data.mark_wash_element);
				$("#accessoryAName").val(data.accessoryAName);
				$("#accessoryANum").val(data.accessoryANum);
				$("#accessoryBName").val(data.accessoryBName);
				$("#accessoryBNum").val(data.accessoryBNum);
				$("#accessoryCName").val(data.accessoryCName);
				$("#accessoryCNum").val(data.accessoryCNum);
				$("#remark").val(data.remark);
			}
		});

	});
}

function myupdate() {
	$("#uppAuxiliaryFabric").click(
			function() {
				var myform = $("#myform").serialize()
				$.ajax({
					url : '/auxiliaryFabric/update.do',
					type : 'POST',
					dataType : 'json',
					data : myform,
					success : function(data) {
						if (data == 1) {
							alert("修改成功");
							firstLoadData("/auxiliaryFabric/getAllByPage.do?"
									+ mySelectForm, $(".laypage_curr").text());
						} else {
							alert("修改失败");
						}
					}
				});
			})
}

var mySelectForm = "";

function myselect() {
	$("#myselect").click(function() {
		mySelectForm = $("#mySelect_From").serialize();
		$(".col-md-2 >input").val("");
		firstLoadData("/auxiliaryFabric/getAllByPage.do?" + mySelectForm, 1);
	});
}
// /---------------------------------------双击修改事件------------------------------------------
function mydblclick() {
	$(".mydblClick").on(
			"dblclick",
			function() {
				var myid = $(this).parent().find(".id").val();
				var thisText = $(this).text().trim();
				var thisName = $(this).attr("name");
				if ($(this).attr("class") == "mydblClick") {
					$(this).html(
							"<form id='dbUpdateForm'><input type='hidden' name='id' value="
									+ myid + " /><input type='text' id='my"
									+ thisName + "' name='" + thisName
									+ "' value='" + thisText + "'></form>");
					$(this).attr("class", "sn");
				}
				myblur("my" + thisName);
			});
}

function myblur(id) {
	$("#" + id).blur(
			function() {
				var myform = $("#dbUpdateForm").serialize();
				$.ajax({
					url : '/auxiliaryFabric/myDBupdate.do',
					type : 'POST',
					dataType : 'json',
					data : myform,
					success : function(data) {
						if (data == 1) {
							firstLoadData("/auxiliaryFabric/getAllByPage.do?"
									+ mySelectForm, $(".laypage_curr").text());
						} else {
							alert("修改失败");
						}
					}
				});
			});
}
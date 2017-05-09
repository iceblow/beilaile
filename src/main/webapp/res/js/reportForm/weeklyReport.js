/**
 * 生产报表
 */
$(function() {
	getAll();
});
function getAll() {
	$.ajax({
		url : $("#path").val() + '/weeklyReport/myGetWeekly.do',
		type : 'post',
		dataType : 'json',
		async : false,
		success : function(data) {
			select(data.date, data.storage);
		},
		error : function() {
			alert("查询失败");
		}
	});
}
function select(date, storage) {
	$('#container').highcharts({
		title : {
			text : '成品入库7日均值日报表'
		},
		subtitle : {
			text : ''
		},
		xAxis : {
			categories : date
		},
		yAxis : {
			title : {
				text : '生产量'
			}
		},
		plotOptions : {
			line : {
				dataLabels : {
					enabled : true
				},
				enableMouseTracking : true
			}
		},
		series : storage,
	});
}
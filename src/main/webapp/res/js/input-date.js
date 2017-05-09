$(".input-date").datetimepicker({
	format : "yyyy-mm-dd",
	autoclose : true,
	todayBtn : true,
	todayHighlight : true,
	showMeridian : true,
	pickerPosition : "bottom-left",
	language : 'zh-CN', // 中文，需要引用zh-CN.js包
	startView : 2, // 月视图
	minView : 2
// 日期时间选择器所能够提供的最精确的时间选择视图
});
$(".input-date").prop("readOnly", "true");
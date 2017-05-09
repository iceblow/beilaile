function getDiscrepantDays(dateStart, dateEnd) {
	var reg1 = new RegExp("[\.+-/年月]", "g");
	var reg = new RegExp("[\日]", "g");
	if(IsDate(dateStart)) {
		dateStart = dateStart.replace(reg1, "/");
		dateStart = dateStart.replace(reg, "");
		var dateStart1 = null;
		if(IsDate(dateEnd)) {
			dateEnd = dateEnd.replace(reg1, "/");
			dateEnd = dateEnd.replace(reg, "");
			dateStart1 = new Date(dateEnd);
		} else {
			var date = new Date();
			var nowDate = date.getFullYear() + "/" + (date.getMonth() + 1) +
				"/" + date.getDate();
			dateStart1 = new Date(nowDate);
		}
		var dateStart2 = new Date(dateStart);
		var myval = Math.floor((dateStart2.getTime() - dateStart1.getTime()) / (1000 * 3600 * 24));
		// 返回值
		return "<span style='color: red;'>" + myval + "</span>"
	}
	// 返回值
	return dateStart;
}
function IsDate(str) {
	if(str != null && str.length > 0) {
		var reg = /^(\d{4})(-|\/)(\d{2})\2(\d{2})$/;
		var r = str.match(reg);
		if(r == null) {
			return false;
		} else {
			return true;
		}

	}
}
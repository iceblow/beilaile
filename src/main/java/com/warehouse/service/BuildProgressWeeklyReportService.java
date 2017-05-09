package com.warehouse.service;

import java.util.Map;

public interface BuildProgressWeeklyReportService {
	// 个数
	Map<String, Object> getCount();

	// 总数
	Map<String, Object> getSum();

}

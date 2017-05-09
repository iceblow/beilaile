package com.warehouse.service;

import java.util.Map;

public interface BuildProgressReportService {
	// 个数
	Map<String, Object> getCount();

	// 总数
	Map<String, Object> getSum();

}

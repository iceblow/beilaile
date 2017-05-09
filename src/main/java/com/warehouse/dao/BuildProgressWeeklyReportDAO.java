package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.BuildProgressReport;

public interface BuildProgressWeeklyReportDAO {

	// 得到日期
	List<String> getDate();

	// 得到类型
	List<String> getNameType();

	// 得到对象
	List<BuildProgressReport> getAll(String string);

}

package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.BuildProgressFactoryDailyReport;

public interface BuildProgressFactoryFailyReportDAO {

	List<String> getDate();

	List<String> getNameType();

	List<BuildProgressFactoryDailyReport> getAll(String string);

}

package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.MyStorage;

public interface StorageReportService {
	
	//获得日期
	List<String> getDate();
	//获得工厂
	List<String> getFactory();

	int getSumTotal(String factory, String date);
	//得到所有的数据
	List<MyStorage> getAll(String date);

}

package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.MyStorage;

public interface StorageReportDAO {
	// 查询前三十条日期
	List<String> getDate();

	// 查询工厂
	List<String> getFactory();

	// 查询
	Integer getSumTotal(String factory, String date);

	// 查询所有的数据
	List<MyStorage> getAll(String date);

}

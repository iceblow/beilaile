package com.warehouse.dao;

import java.util.List;

public interface InputStorageRatioDAO {

	// 得到日期
	List<String> getDate();

	// 得到类型
	List<String> getNameType();
	
	//得到入库比例的集合
	List<Double> getRatioIn(String typeName);
	//得到未入库比例的集合
	List<Double> getRatioNot(String typeName);

}

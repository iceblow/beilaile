package com.warehouse.dao;

import org.apache.ibatis.annotations.Param;

//import com.warehouse.entity.SalesSkuOfWdt;

public interface SalesSkuOfWdtMapper {
	/**
	 * 导入信息
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(@Param(value = "insert") String insert);
	// int insertSelective(SalesSkuOfWdt record);

	/**
	 * 清空所有信息
	 * 
	 * @return
	 */
	int delSelective();
}
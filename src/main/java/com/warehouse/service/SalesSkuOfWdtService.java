package com.warehouse.service;

import org.apache.ibatis.annotations.Param;

//import com.warehouse.entity.SalesSkuOfWdt;

public interface SalesSkuOfWdtService {

	// Excel导入
	// int insertSelective(SalesSkuOfWdt record);
	int insertSelective(@Param(value = "insert") String insert);

	// 清空
	int delSelective();
}

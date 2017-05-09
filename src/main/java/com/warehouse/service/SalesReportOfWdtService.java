package com.warehouse.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.SalesReportOfWdt;
import com.warehouse.util.PageUtil;

public interface SalesReportOfWdtService {

	Map<String, Object> getAllByPage(PageUtil pageUtil, SalesReportOfWdt salesReportOfWdt);

	int delSelective();

	int insertSelective(SalesReportOfWdt salesReportOfWdt);

	int insertSelectives(@Param(value = "form") String form);

}

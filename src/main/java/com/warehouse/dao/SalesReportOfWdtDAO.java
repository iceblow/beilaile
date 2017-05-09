package com.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.SalesReportOfWdt;

public interface SalesReportOfWdtDAO {

	/**
	 * 得到数据量
	 * 
	 * @param purchaseOrdersDetail
	 * @return
	 */
	public int getCountByPage(SalesReportOfWdt salesReportOfWdt);

	/**
	 * 得到分页数据
	 * 
	 * @param purchaseOrdersDetail
	 * @return
	 */
	public List<SalesReportOfWdt> getDataByPage(SalesReportOfWdt salesReportOfWdt);

	/**
	 * 添加
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(SalesReportOfWdt record);

	int insertSelectives(@Param(value = "form") String form);

	/**
	 * 清空所有信息
	 * 
	 * @return
	 */
	int delSelective();

}

package com.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.MyStorage;

public interface WeeklyReportDAO {
	/**
	 * 
	 * @param form 表名
	 * @param cdate 多少天
	 * @return
	 */
	List<String> getDate(@Param(value="form")String form, @Param(value="cdate")int cdate);
	/**
	 * 
	 * @param form 表名
	 * @return
	 */
	List<String> getFactory(@Param(value="form")String form);
	/**
	 * 
	 * @param date最小的日期
	 * @param form表名
	 * @return
	 */
	List<MyStorage> getAll(@Param(value="form")String form,@Param(value="date")String date);
	
}

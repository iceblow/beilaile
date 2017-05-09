package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.PrintMarkOrder;

public interface PrintMarkOrderMapper {
	/**
	 * 分页
	 * 
	 * @param record
	 * @return
	 */
	int selectByCount(PrintMarkOrder record);

	List<PrintMarkOrder> selectByPage(PrintMarkOrder record);

	/**
	 * 修改
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(PrintMarkOrder record);

	/**
	 * 添加
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(PrintMarkOrder record);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	PrintMarkOrder selPrintByID(Integer id);
}
package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.PrintingProcessCase;

public interface PrintingProcessCaseMapper {

	/**
	 * 根据编号单个查询
	 * @param id
	 * @return
	 */
    PrintingProcessCase selectByPrimaryKey(Integer id);

    /**
     * 得到数据量
     * @param printingProcessCase
     * @return
     */
    int getCount(PrintingProcessCase printingProcessCase);
    
    /**
     * 分页查询数据
     * @param printingProcessCase
     * @return
     */
    List<PrintingProcessCase> getDataByPage(PrintingProcessCase printingProcessCase);
    
    /**
     * 根据传入的条件修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PrintingProcessCase record);

    /**
     * 修改所有信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(PrintingProcessCase record);

    /**
     * 匹印领料
     * @param id
     * @return
     */
	int fabricOut(int id);

	/**
	 * 匹印回料
	 * @param id
	 * @return
	 */
	int fabricIn(int id);
    
}
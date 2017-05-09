package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.ApparelDevelopmentReturn;

public interface ApparelDevelopmentReturnMapper {

	// 删除
	int deleteByPrimaryKey(ApparelDevelopmentReturn record);

	// 添加
	int insertSelective(ApparelDevelopmentReturn record);

	// 根据id查询
	ApparelDevelopmentReturn selectByPrimaryKey(Integer id);

	// 修改
	int updateByPrimaryKey(ApparelDevelopmentReturn record);

	// 分页查询
	int selApparelDevelopmentReturnCount(ApparelDevelopmentReturn record);

	List<ApparelDevelopmentReturn> developmentReturns(ApparelDevelopmentReturn record);

	// 分页查询
	int selApparelDevelopmentReturnCounting(ApparelDevelopmentReturn record);

	List<ApparelDevelopmentReturn> developmentReturnsing(ApparelDevelopmentReturn record);

	// 分页查询
	int selApparelDevelopmentReturnCountover(ApparelDevelopmentReturn record);

	List<ApparelDevelopmentReturn> developmentReturnsover(ApparelDevelopmentReturn record);

	// 旺店通
	List<ApparelDevelopmentReturn> queryEtrack(int id);

	// 根据时间生成excel
	int toExcelNum(ApparelDevelopmentReturn record);

	List<ApparelDevelopmentReturn> toExcel(ApparelDevelopmentReturn record);

}
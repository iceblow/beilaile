package com.warehouse.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FinanceAccountReconciliation;

public interface FinanceAccountReconciliationService {
	// 新增
	int insertSelective(FinanceAccountReconciliation record);

	// 根据ID查询
	FinanceAccountReconciliation selectByPrimaryKey(Integer id);

	// 修改
	int updateByPrimaryKeySelective(FinanceAccountReconciliation record);

	// 分页查询
	int getCountByPrimaryKey(FinanceAccountReconciliation record);

	List<FinanceAccountReconciliation> selectByPrimaryKeyPage(FinanceAccountReconciliation record);

	// 导入
	int insertSelectiveByExcle(@Param(value = "sql") String sql);

}

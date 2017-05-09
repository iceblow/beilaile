package com.warehouse.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.ApprovalApplication;

public interface ApprovalApplicationService {
	// 删除
	int deleteByPrimaryKey(ApprovalApplication record);

	// 添加
	int insertSelective(ApprovalApplication record);

	// 导入
	int insertSelectives(@Param(value = "insertData") String insertData);

	// 修改
	ApprovalApplication selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ApprovalApplication record);

	// 分页查询
	int selApprovalApplicationCount(ApprovalApplication record);

	List<ApprovalApplication> ApprovalApplicationReturns(ApprovalApplication record);

	// 计算订单总值
	int calculations(String girard);

}

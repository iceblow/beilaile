package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.ApparelDevelopmentManagement;

public interface ApparelDevelopmentManagementMapper {

	// 删除服装开发信息
	int deleteByPrimaryKey(ApparelDevelopmentManagement record);

	// 添加服装开发信息
	int insertSelective(ApparelDevelopmentManagement record);

	// 根据id查询
	ApparelDevelopmentManagement getApparelDevelopmentManagementById(Integer id);

	// 修改服装开发信息
	int updateByPrimaryKeySelective(ApparelDevelopmentManagement record);

	// 分页
	// 获取分页数量
	int getCountByLike(ApparelDevelopmentManagement record);

	List<ApparelDevelopmentManagement> getApparelDevelopmentManagementByLike(ApparelDevelopmentManagement page);

	// 生成Excel表
	List<ApparelDevelopmentManagement> queryEtrack(Integer id);

	// 生成报表
	List<ApparelDevelopmentManagement> toExcel();
	//根据时间段生成excel表
	List<ApparelDevelopmentManagement> toExcelByTime(Map map);
	// 波次唯一
	int checkGirard(String girard);

}
package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ApparelDevelopmentManagement;

public interface ApparelDevelopmentManagementService {

	// 添加服装开发信息
	int addApparelDevelopmentManagement(ApparelDevelopmentManagement record);

	// 根据id查询
	ApparelDevelopmentManagement getApparelDevelopmentManagementById(Integer id);

	// 修改服装开发信息
	int updateApparelDevelopmentManagement(ApparelDevelopmentManagement record);

	// 删除服装开发信息
	int delApparelDevelopmentManagement(ApparelDevelopmentManagement record);

	// 分页查询
	int getCountByLike(ApparelDevelopmentManagement record);

	List<ApparelDevelopmentManagement> getApparelDevelopmentManagementByLike(ApparelDevelopmentManagement page);

	// 生成Excel
	List<ApparelDevelopmentManagement> queryEtrack(Integer id);

	// 生成报表
	List<ApparelDevelopmentManagement> toExcel();

	// 按时间段生成报表
	List<ApparelDevelopmentManagement> toExcelByTime(String startTime, String endTime);

	// 检查波次是否唯一
	int checkGirard(String girard);

}

package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.EmployeesTest;

public interface EmployeesTestMapper {
	// 新增
	int addEmployeesTest(EmployeesTest employeesTest);

	// 修改
	int modifyEmployeesTest(EmployeesTest employeesTest);

	// 删除（修改状态）
	int delEmployeesTest(@Param("id") Integer id);

	// 带条件查询总条数
	int getEmployeesTestByPageCount(Map<String, Object> anyval);

	// 带条件分页查询
	List<EmployeesTest> findConditionEmployeesTestByPage(Map<String, Object> anyval);

	// 修改获取数据根据id
	EmployeesTest getEmployeesTestById(@Param("id") Integer id);

}

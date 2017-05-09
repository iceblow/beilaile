package com.warehouse.service;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.EmployeesTest;

public interface EmployeesTestService {

	// 新增员工
	int addEmployeesTest(EmployeesTest employeesTest);

	// 修改员工信息
	int modifyEmployeesTest(EmployeesTest fabricStorage);

	// 逻辑删除 员工信息
	int delEmployeesTest(Integer id);

	// 带条件分页查询查询
	List<EmployeesTest> findConditionEmployeesTestByPage(Map<String, Object> anyVal);

	// 修改获取数据根据id
	EmployeesTest getEmployeesTestById(Integer id);

	// 带条件查询总条数
	int getEmployeesTestByPageCount(Map<String, Object> anyval);

}

package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.EmployeesTestMapper;
import com.warehouse.dao.FabricStorageMapper;
import com.warehouse.entity.EmployeesTest;
import com.warehouse.entity.FabricStorage;

@Service
public class EmployeesTestServiceImpl implements EmployeesTestService {

	@Resource
	public EmployeesTestMapper employeesTestMapper;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);// 时间格式化

	
	@Override
	public int addEmployeesTest(EmployeesTest employeesTest) {
		String addTime = formatter.format(new Date());// 操作时间
		employeesTest.setAddTime(addTime);
		employeesTest.setState("1");// 状态
		int reslut = employeesTestMapper.addEmployeesTest(employeesTest);
		return reslut;
	}

	@Override
	public int delEmployeesTest(Integer id) {
		int reslut = employeesTestMapper.delEmployeesTest(id);
		return reslut;
	}

	@Override
	public int modifyEmployeesTest(EmployeesTest employeesTest) {
		
		int reslut = employeesTestMapper.modifyEmployeesTest(employeesTest);
		return reslut;
	}

	@Override
	public List<EmployeesTest> findConditionEmployeesTestByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<EmployeesTest> list = employeesTestMapper.findConditionEmployeesTestByPage(anyVal);
		return list;
	}

	@Override
	public EmployeesTest getEmployeesTestById(Integer id) {
		EmployeesTest employeesTest = employeesTestMapper.getEmployeesTestById(id);
		return employeesTest;
	}

	@Override
	public int getEmployeesTestByPageCount(Map<String, Object> anyval) {
		int reslut = employeesTestMapper.getEmployeesTestByPageCount(anyval);
		return reslut;
	}

	
	
}

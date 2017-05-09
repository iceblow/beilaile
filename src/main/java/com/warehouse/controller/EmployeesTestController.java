package com.warehouse.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.EmployeesTest;
import com.warehouse.service.EmployeesTestService;
import com.warehouse.util.Page;

@Controller
public class EmployeesTestController {
	private Logger logger = LoggerFactory.getLogger(BuildProgressController.class);

	@Resource
	public EmployeesTestService employeesTestService;

	/**
	 * 添加 员工
	 * 
	 * @param employeesTest
	 * @return
	 */
	@RequestMapping(value = "addEmployeesTest.do", method = RequestMethod.POST)
	public String addEmployeesTest(EmployeesTest employeesTest) {

		employeesTestService.addEmployeesTest(employeesTest);
		return "redirect:" + "/employeesTest.html";// 返回添加成功页面
	}
	
	/**
	 * 修改 对象
	 * 
	 * @param employeesTest
	 * @return
	 */
	@RequestMapping(value = "modifyEmployeesTest.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyEmployeesTest(EmployeesTest employeesTest) {

		int reslut = employeesTestService.modifyEmployeesTest(employeesTest);
		logger.info("成功的修改了id：" + employeesTest.getId() + "波茨号：" + employeesTest.getName());
		return reslut;
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delEmployeesTest.do", method = RequestMethod.POST)
	@ResponseBody
	public int delEmployeesTest(Integer id) {
		int reslut = employeesTestService.delEmployeesTest(id);
		logger.info("成功的修改了id：" + id);
		return reslut;
	}

	/**
	 * 带添加查询总条数
	 * 
	 * @param anyval
	 * @return
	 */
	@RequestMapping(value = "getEmployeesTestByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<EmployeesTest> getEmployeesTestByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = employeesTestService.getEmployeesTestByPageCount(anyval);
		Page<EmployeesTest> page = new Page<EmployeesTest>(result, 1);
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findConditionEmployeesTestByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<EmployeesTest> findConditionEmployeesTestByPage(@RequestParam Map<String, Object> anyVal) {

		List<EmployeesTest> list = employeesTestService.findConditionEmployeesTestByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getEmployeesTestById.do", method = RequestMethod.POST)
	@ResponseBody
	public EmployeesTest getFabricSourcingById(Integer id) {
		EmployeesTest employeesTest = employeesTestService.getEmployeesTestById(id);
		return employeesTest;
	}
	
}

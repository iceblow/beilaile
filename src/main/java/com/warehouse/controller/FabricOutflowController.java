package com.warehouse.controller;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.FabricOutflow;
import com.warehouse.service.FabricOutflowService;
import com.warehouse.util.Page;

@Controller
public class FabricOutflowController {
	private Logger logger = LoggerFactory.getLogger(BuildProgressController.class);

	@Resource
	public FabricOutflowService fabricOutflowService;

	/**
	 * 添加一个对象
	 * 
	 * @param fabricOutflow
	 * @return
	 */
	@RequestMapping(value = "addFabricOutflow.do", method = RequestMethod.POST)
	public String addFabricOutflow(FabricOutflow fabricOutflow, HttpServletRequest request) {

		double fabricCount = 0.0;
		if (fabricOutflow.getParameter1() != null)
			fabricCount += fabricOutflow.getParameter1();
		if (fabricOutflow.getParameter2() != null)
			fabricCount += fabricOutflow.getParameter2();
		if (fabricOutflow.getParameter3() != null)
			fabricCount += fabricOutflow.getParameter3();
		if (fabricOutflow.getParameter4() != null)
			fabricCount += fabricOutflow.getParameter4();
		if (fabricOutflow.getParameter5() != null)
			fabricCount += fabricOutflow.getParameter5();
		if (fabricOutflow.getParameter6() != null)
			fabricCount += fabricOutflow.getParameter6();
		if (fabricOutflow.getParameter7() != null)
			fabricCount += fabricOutflow.getParameter7();
		if (fabricOutflow.getParameter8() != null)
			fabricCount += fabricOutflow.getParameter8();
		if (fabricOutflow.getParameter9() != null)
			fabricCount += fabricOutflow.getParameter9();
		if (fabricOutflow.getParameter10() != null)
			fabricCount += fabricOutflow.getParameter10();
		if (fabricOutflow.getParameter11() != null)
			fabricCount += fabricOutflow.getParameter11();
		if (fabricOutflow.getParameter12() != null)
			fabricCount += fabricOutflow.getParameter12();
		if (fabricOutflow.getParameter13() != null)
			fabricCount += fabricOutflow.getParameter13();
		if (fabricOutflow.getParameter14() != null)
			fabricCount += fabricOutflow.getParameter14();
		if (fabricOutflow.getParameter15() != null)
			fabricCount += fabricOutflow.getParameter15();
		if (fabricOutflow.getParameter16() != null)
			fabricCount += fabricOutflow.getParameter16();
		if (fabricOutflow.getParameter17() != null)
			fabricCount += fabricOutflow.getParameter17();
		if (fabricOutflow.getParameter18() != null)
			fabricCount += fabricOutflow.getParameter18();
		if (fabricOutflow.getParameter19() != null)
			fabricCount += fabricOutflow.getParameter19();
		if (fabricOutflow.getParameter20() != null)
			fabricCount += fabricOutflow.getParameter20();
		fabricOutflow.setFabricCount(fabricCount);
		Double d = fabricOutflow.getFabricPrices().doubleValue();
		Double t = d * fabricCount;
		BigDecimal totalPrice = new BigDecimal(t);
		fabricOutflow.setTotalPrice(totalPrice);
		fabricOutflowService.addFabricOutflow(fabricOutflow, request);

		return "redirect:" + "/fabricOutflow.html";// 返回添加成功页面
	}

	/**
	 * 修改一个对象
	 * 
	 * @param fabricOutflow
	 * @return
	 */
	@RequestMapping(value = "modifyFabricOutflow.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyFabricOutflow(FabricOutflow fabricOutflow, HttpServletRequest request) {

		double fabricCount = 0.0;
		if (fabricOutflow.getParameter1() != null)
			fabricCount += fabricOutflow.getParameter1();
		if (fabricOutflow.getParameter2() != null)
			fabricCount += fabricOutflow.getParameter2();
		if (fabricOutflow.getParameter3() != null)
			fabricCount += fabricOutflow.getParameter3();
		if (fabricOutflow.getParameter4() != null)
			fabricCount += fabricOutflow.getParameter4();
		if (fabricOutflow.getParameter5() != null)
			fabricCount += fabricOutflow.getParameter5();
		if (fabricOutflow.getParameter6() != null)
			fabricCount += fabricOutflow.getParameter6();
		if (fabricOutflow.getParameter7() != null)
			fabricCount += fabricOutflow.getParameter7();
		if (fabricOutflow.getParameter8() != null)
			fabricCount += fabricOutflow.getParameter8();
		if (fabricOutflow.getParameter9() != null)
			fabricCount += fabricOutflow.getParameter9();
		if (fabricOutflow.getParameter10() != null)
			fabricCount += fabricOutflow.getParameter10();
		if (fabricOutflow.getParameter11() != null)
			fabricCount += fabricOutflow.getParameter11();
		if (fabricOutflow.getParameter12() != null)
			fabricCount += fabricOutflow.getParameter12();
		if (fabricOutflow.getParameter13() != null)
			fabricCount += fabricOutflow.getParameter13();
		if (fabricOutflow.getParameter14() != null)
			fabricCount += fabricOutflow.getParameter14();
		if (fabricOutflow.getParameter15() != null)
			fabricCount += fabricOutflow.getParameter15();
		if (fabricOutflow.getParameter16() != null)
			fabricCount += fabricOutflow.getParameter16();
		if (fabricOutflow.getParameter17() != null)
			fabricCount += fabricOutflow.getParameter17();
		if (fabricOutflow.getParameter18() != null)
			fabricCount += fabricOutflow.getParameter18();
		if (fabricOutflow.getParameter19() != null)
			fabricCount += fabricOutflow.getParameter19();
		if (fabricOutflow.getParameter20() != null)
			fabricCount += fabricOutflow.getParameter20();
		fabricOutflow.setFabricCount(fabricCount);
		Double d = fabricOutflow.getFabricPrices().doubleValue();
		Double t = d * fabricCount;
		BigDecimal totalPrice = new BigDecimal(t);
		fabricOutflow.setTotalPrice(totalPrice);
		int result = fabricOutflowService.modifyFabricOutflow(fabricOutflow, request);
		logger.info("成功修改了id：" + fabricOutflow.getId() + "波茨号为：" + fabricOutflow.getWave());
		return result;
	}

	/**
	 * 删除一个数据
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delFabricOutflow.do", method = RequestMethod.POST)
	@ResponseBody
	public int delFabricOutflow(Integer id, HttpServletRequest request) {
		int result = fabricOutflowService.delFabricOutflow(id, request);
		logger.info("成功删除了id：" + id);
		return result;
	}

	/**
	 * 带条件查询总条数
	 * 
	 * @param anyval
	 * @return
	 */
	@RequestMapping(value = "getFabricOutflowByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<FabricOutflow> getFabricOutflowByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = fabricOutflowService.getFabricOutflowByPageCount(anyval);
		Page<FabricOutflow> page = new Page<FabricOutflow>(result, 1);
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findConditionFabricOutflowByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<FabricOutflow> findConditionFabricOutflowByPage(@RequestParam Map<String, Object> anyVal) {

		List<FabricOutflow> list = fabricOutflowService.findConditionFabricOutflowByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getFabricOutflowById.do", method = RequestMethod.POST)
	@ResponseBody
	public FabricOutflow getFabricOutflowById(Integer id) {
		FabricOutflow fabricOutflow = fabricOutflowService.getFabricOutflowById(id);
		return fabricOutflow;
	}

}

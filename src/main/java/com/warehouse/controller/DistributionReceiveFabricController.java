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
import com.warehouse.entity.DistributionReceiveFabric;
import com.warehouse.service.DistributionReceiveFabricService;
import com.warehouse.util.Page;

@Controller
public class DistributionReceiveFabricController {
	private Logger logger = LoggerFactory.getLogger(BuildProgressController.class);

	@Resource
	public DistributionReceiveFabricService distributionReceiveFabricService;

	/**
	 * 添加对象
	 * 
	 * @param DistributionReceiveFabric
	 * @return
	 */
	@RequestMapping(value = "addDistributionReceiveFabric.do", method = RequestMethod.POST)
	public String addDistributionReceiveFabric(DistributionReceiveFabric distributionReceiveFabric) {

		distributionReceiveFabricService.addDistributionReceiveFabric(distributionReceiveFabric);
		return "redirect:" + "/distributionReceiveFabric.html";// 返回添加成功页面
	}

	/**
	 * 修改对象
	 * @param DistributionReceiveFabric
	 * @return
	 */

	@RequestMapping(value = "modifyDistributionReceiveFabric.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyDistributionReceiveFabric(DistributionReceiveFabric distributionReceiveFabric) {

		int reslut = distributionReceiveFabricService.modifyDistributionReceiveFabric(distributionReceiveFabric);
		logger.info("成功修改了id:" + distributionReceiveFabric.getId() + "波茨号：" + distributionReceiveFabric.getWave());
		return reslut;
	}

	/**
	 * 删除对象
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delDistributionReceiveFabric.do", method = RequestMethod.POST)
	@ResponseBody
	public int delDistributionReceiveFabric(Integer id) {
		int reslut = distributionReceiveFabricService.delDistributionReceiveFabricById(id);
		return reslut;
	}

	@RequestMapping(value = "getDistributionReceiveFabricByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<DistributionReceiveFabric> getDistributionReceiveFabricByPageCount(@RequestParam Map<String, Object> anyval) {
		int result = distributionReceiveFabricService.getDistributionReceiveFabricByPageCount(anyval);
		Page<DistributionReceiveFabric> page = new Page<DistributionReceiveFabric>(result, 1);
		return page;
	}

	/**
	 * 带条件分页查询
	 * 
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findConditionDistributionReceiveFabricByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<DistributionReceiveFabric> findConditionDistributionReceiveFabricByPage(
			@RequestParam Map<String, Object> anyVal) {

		List<DistributionReceiveFabric> list = distributionReceiveFabricService.findConditionDistributionReceiveFabricByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getDistributionReceiveFabricById.do", method = RequestMethod.POST)
	@ResponseBody
	public DistributionReceiveFabric getFabricSourcingById(Integer id) {
		DistributionReceiveFabric distributionReceiveFabric = distributionReceiveFabricService.getDistributionReceiveFabricById(id);
		return distributionReceiveFabric;
	}

	@RequestMapping(value = "updateDistributionReceiveFabricByCompleteStatus.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateDistributionReceiveFabricByCompleteStatus(DistributionReceiveFabric distributionReceiveFabric) {
		int rslut = distributionReceiveFabricService.updateDistributionReceiveFabricByCompleteStatus(distributionReceiveFabric);
		return rslut;
	}

}

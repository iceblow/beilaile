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

import com.warehouse.entity.DistributionFabric;
import com.warehouse.service.DistributionFabricService;
import com.warehouse.util.Page;

@Controller
public class DistributionFabricController {
	private Logger logger = LoggerFactory.getLogger(BuildProgressController.class);

	@Resource
	public DistributionFabricService distributionFabricService;

	/**
	 * 查询根据条件
	 *
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "findDistributionFabricPageByVal.do", method = RequestMethod.POST)
	@ResponseBody
	public List<DistributionFabric> findDistributionFabricPageByVal(@RequestParam Map<String, Object> anyVal)
			throws FileNotFoundException {

		List<DistributionFabric> list = distributionFabricService.findDistributionFabricPageByVal(anyVal);
		return list;

	}

	/**
	 * 查询根据条件
	 *
	 * @param anyVal
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "getDistributionFabricById.do", method = RequestMethod.POST)
	@ResponseBody
	public DistributionFabric getDistributionFabricById(Integer id) {

		DistributionFabric distributionFabric = distributionFabricService.getDistributionFabricById(id);
		return distributionFabric;

	}

	/**
	 * 添加
	 *
	 * @param buildProgress
	 *            对象
	 * @return
	 */
	@RequestMapping(value = "addDistributionFabric.do", method = RequestMethod.POST)
	public String addDistributionFabric(DistributionFabric distributionFabric) {

		distributionFabricService.addDistributionFabric(distributionFabric);// 修改操作
		// 返回数据页面（刷新当前页面）
		return "redirect:" + "/distributionFabric.html";// 返回添加成功页面

	}

	/**
	 * 修改一条件数据
	 *
	 * @param buildProgress
	 *            对象
	 * @return
	 */
	@RequestMapping(value = "modifyDistributionFabric.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyDistributionFabric(DistributionFabric distributionFabric) {

		int reslut = distributionFabricService.modifyDistributionFabric(distributionFabric);// 修改操作

		logger.info("成功修改了ID：" + distributionFabric.getId() + "波茨号为：" + distributionFabric.getWave());
		// 返回数据页面（刷新当前页面）
		return reslut;// 返回结果集

	}

	/**
	 * 查询帶條件总条数
	 *
	 * @return
	 */
	@RequestMapping(value = "getDistributionFabricTotalPageByVal.do")
	@ResponseBody
	public Page<DistributionFabric> getDistributionFabricTotalPageByVal(@RequestParam Map<String, Object> anyVal) {
		int result = distributionFabricService.getDistributionFabricTotalPageByVal(anyVal);// 这个查询总数据
		Page<DistributionFabric> page = new Page<DistributionFabric>(result, 1);
		return page;
	}

	/**
	 * 删除
	 *
	 * @return
	 */
	@RequestMapping(value = "delByDistributionFabric.do", method = RequestMethod.POST)
	@ResponseBody
	public int delByDistributionFabric(int id) {
		int result = distributionFabricService.delByDistributionFabric(id);
		logger.info("删除了id:" + id + "的数据 ");
		return result;
	}

	/**
	 * 删除
	 *
	 * @return
	 */
	@RequestMapping(value = "modifyDistributionFabricIssuedStatus.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyDistributionFabricIssuedStatus(DistributionFabric distributionFabric) {
		int result = distributionFabricService.modifyDistributionFabricIssuedStatus(distributionFabric);
		logger.info("修改了id:" + distributionFabric.getId() + "的状态");
		return result;
	}

}

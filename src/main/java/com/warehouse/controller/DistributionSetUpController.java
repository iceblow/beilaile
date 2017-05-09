package com.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.warehouse.entity.DistributionSetUp;
import com.warehouse.service.DistributionSetUpService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("distributionSetUp")
public class DistributionSetUpController {

	@Resource
	private DistributionSetUpService distributionSetUpService;

	private Logger log = LoggerFactory.getLogger(InputStorageController.class);

	/**
	 * 修改
	 * 
	 * @return
	 */
	@RequestMapping("updatedistributionSetUp")
	@ResponseBody
	public int updateDistributionMakSample(DistributionSetUp distributionSetUp) {
		int result = this.distributionSetUpService.updateDistributionSetUp(distributionSetUp);
		log.debug("修改设置经销单");
		return result;

	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping("distributionSetUpByLike")
	@ResponseBody
	public Map<String, Object> distributionSetUpByLike(DistributionSetUp distributionSetUp, PageUtil page) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.distributionSetUpService.getCountDistributionSetUp(distributionSetUp));// 总共有多少条数据
		// map对象中存的数据
		List<DistributionSetUp> distributionSetUps = this.distributionSetUpService.distributionSetUpByLike(
				new DistributionSetUp(page.getReqult()[0], page.getReqult()[1], distributionSetUp.getClothName(),
						distributionSetUp.getOringinalWave(), distributionSetUp.getWave()));
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", distributionSetUps);
		log.info("查看设置经销单");
		return map;
	}

	// 双击修改
	@RequestMapping("updateByText")
	@ResponseBody
	public int updateByText(DistributionSetUp distributionSetUp) {
		System.err.println(distributionSetUp.getRemark());
		return this.distributionSetUpService.updateByText(distributionSetUp);
	}
}

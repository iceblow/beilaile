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
import com.warehouse.entity.DistributionMakSample;
import com.warehouse.service.DistributionMakSampleService;
import com.warehouse.util.PageUtil;
  
@Controller
@RequestMapping("distributionMakSample")
public class DistributionMakSampleController {
	
	@Resource
	private DistributionMakSampleService distributionMakSampleService;

	private Logger log = LoggerFactory.getLogger(InputStorageController.class);
	/**
	 * 修改
	 * @param distributionMakSample
	 * @return
	 */
	@RequestMapping("updatedistributionMakSample")
	@ResponseBody
	public int updateDistributionMakSample(DistributionMakSample distributionMakSample ){
		int result = this.distributionMakSampleService.updateDistributionMakSample(distributionMakSample);
		log.debug("修改经销单打样");
		return result;
		
	}
	
	//添加打样工厂
	@RequestMapping("addProofingFactory")
	@ResponseBody
	public int addProofingFactory(DistributionMakSample distributionMakSample ){
		return distributionMakSampleService.addProofingFactory(distributionMakSample);
	}
	
	/**
	 * 分页查询
	 * @param distributionMakSample
	 * @return
	 */
	@RequestMapping("distributionMakSampleByLike")
	@ResponseBody
	public Map<String, Object> distributionMakSampleByLike(DistributionMakSample distributionMakSample , PageUtil page){
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.distributionMakSampleService.getCountDistributionMakSample(distributionMakSample));// 总共有多少条数据
		// map对象中存的数据
		List<DistributionMakSample> list = this.distributionMakSampleService.distributionMakSampleByLike(new DistributionMakSample(page.getReqult()[0],page.getReqult()[1],distributionMakSample));
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList",list);
		log.info("查看经销单打样");
		return map;
	}
	//双击修改
	@RequestMapping("updateByText")
	@ResponseBody
	public int updateByText(DistributionMakSample distributionMakSample ){
		return this.distributionMakSampleService.updateByText(distributionMakSample);
	}			
}

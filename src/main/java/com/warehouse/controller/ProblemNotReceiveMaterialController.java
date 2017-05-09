package com.warehouse.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ProblemNotReceiveMaterial;

import com.warehouse.service.ProblemNotReceiveMaterialService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("problemNotReceiveMaterial")

public class ProblemNotReceiveMaterialController {
	@Resource
	private ProblemNotReceiveMaterialService  problemNotReceiveMaterialService ;
	private Logger log = LoggerFactory.getLogger(InputStorageController.class);
	/*
	 * 假删除
	 */
	@RequestMapping("deleteByProblemNotReceiveMaterialId")
	@ResponseBody
	public int deleteByProblemNotReceiveMaterialId(ProblemNotReceiveMaterial problemNotReceiveMaterial){
		int result = this.problemNotReceiveMaterialService.deleteByProblemNotReceiveMaterialId(problemNotReceiveMaterial);
		log.debug("删除裁片跟踪");
		return result;
		
	}
	/*
	 * 分页查询
	 */
	@RequestMapping("problemNotReceiveMaterialbylike")
	@ResponseBody
	public Map<String, Object> ProblemNotReceiveMaterialbylike(ProblemNotReceiveMaterial problemNotReceiveMaterial,PageUtil page){
		// 传送至前台的map对象
				Map<String, Object> map = new HashMap<String, Object>();
				page.setPageSize(15);// 每页显示的数据量
				page.setTotolCount(this.problemNotReceiveMaterialService.getCountByProblemNotReceiveMaterialLike(problemNotReceiveMaterial));// 总共有多少条数据
				// map对象中存的数据
				List<ProblemNotReceiveMaterial> grant = this.problemNotReceiveMaterialService
						.ProblemNotReceiveMaterialbylike((new ProblemNotReceiveMaterial(page.getReqult()[0]
						,page.getReqult()[1]
						,problemNotReceiveMaterial.getWave()
						,problemNotReceiveMaterial.getClouthName()
						,problemNotReceiveMaterial.getProductCode()
						,problemNotReceiveMaterial.getFactory()
						,problemNotReceiveMaterial.getOrderType()
						)));
				map.put("pageUtil", page); // 在map中写入数据对象
				map.put("dataList",grant);
				log.info("查看裁片跟踪信息");
				return map;
		
	}
	
	//双击修改
	@RequestMapping("updateByText")
	@ResponseBody
	public int updateByText(ProblemNotReceiveMaterial problemNotReceiveMaterial){
		return problemNotReceiveMaterialService.updateByText(problemNotReceiveMaterial);
	}
	
	//问题解决
	@RequestMapping("updateAndTime")
	@ResponseBody
	public int updateAndTime(ProblemNotReceiveMaterial problemNotReceiveMaterial){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		problemNotReceiveMaterial.setProblemSolvingTime(df.format(new Date()));
		problemNotReceiveMaterial.setProblemState("已解决");
		System.out.println(problemNotReceiveMaterial.getProblemState());
		return problemNotReceiveMaterialService.updateByText(problemNotReceiveMaterial);
	}
}

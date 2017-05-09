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

import com.warehouse.entity.ProblemNotGrant;

import com.warehouse.service.ProblemNotGrantService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("problemNotGrant")

public class ProblemNotGrantController {
	@Resource
	private ProblemNotGrantService problemNotGrantService ;
	private Logger log = LoggerFactory.getLogger(InputStorageController.class);
	/*
	 * 假删除
	 */
	@RequestMapping("deleteByProblemNotGrantId")
	@ResponseBody
	public int deleteByProblemNotGrantId(ProblemNotGrant problemNotGrant){
		int result = this.problemNotGrantService.deleteByProblemNotGrantId(problemNotGrant);
		log.debug("删除面料跟踪信息");
		return result;

	}

	/*
	 * 分页查询
	 */
	@RequestMapping("problemNotGrantbylike")
	@ResponseBody
	public Map<String, Object> ProblemNotGrantbylike(ProblemNotGrant problemNotGrant, PageUtil page) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.problemNotGrantService.getCountByProblemNotGrantLike(problemNotGrant));// 总共有多少条数据
		// map对象中存的数据
		List<ProblemNotGrant> grant = this.problemNotGrantService
				.ProblemNotGrantbylike((new ProblemNotGrant(page.getReqult()[0], page.getReqult()[1],
						problemNotGrant.getWave(), problemNotGrant.getClouthName(), problemNotGrant.getProductCode(),problemNotGrant.getFactory(),
						problemNotGrant.getOrderType(), problemNotGrant.getPiecesApproved())));
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", grant);
		log.info("查看面料跟踪信息");
		return map;

	}
	//双击修改
		@RequestMapping("updateByText")
		@ResponseBody
		public int updateByText(ProblemNotGrant problemNotGrant){
			System.out.println("11111111111111111111111111111111111111111111111111111111111");
			return problemNotGrantService.updateByText(problemNotGrant);
		}
		
		//问题解决
		@RequestMapping("updateAndTime")
		@ResponseBody
		public int updateAndTime(ProblemNotGrant problemNotGrant){
			System.out.println("2222222222222222222222222222222222222222222222222222222222222");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			problemNotGrant.setProblemSolvingTime(df.format(new Date()));
			problemNotGrant.setProblemState("已解决");
			System.out.println(problemNotGrant.getProblemState());
			return problemNotGrantService.updateByText(problemNotGrant);
		}
}

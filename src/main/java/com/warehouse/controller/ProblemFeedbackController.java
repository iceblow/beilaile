package com.warehouse.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ProblemFeedback;
import com.warehouse.service.ProblemFeedbackService;
import com.warehouse.util.Page;

/**
 * Created by Beilaile on 2016/11/30.
 */
@Controller
public class ProblemFeedbackController {
	@Resource
	private ProblemFeedbackService problemFeedbackService;

	@RequestMapping(value = "addProblemFeedback.do", method = RequestMethod.POST)
	@ResponseBody
	public int addProblemFeedback(ProblemFeedback problemFeedback) {
		int reslut = problemFeedbackService.addProblemFeedback(problemFeedback);
		return reslut;
	}

	@RequestMapping(value = "ModifyProblemFeedback.do", method = RequestMethod.POST)
	@ResponseBody
	public int ModifyProblemFeedback(ProblemFeedback problemFeedback) {
		int reslut = problemFeedbackService.ModifyProblemFeedback(problemFeedback);
		return reslut;
	}

	@RequestMapping(value = "delProblemFeedbackById.do", method = RequestMethod.POST)
	@ResponseBody
	public int delProblemFeedbackById(Integer id) {
		int reslut = problemFeedbackService.delProblemFeedbackById(id);
		return reslut;
	}

	@RequestMapping(value = "getProblemFeedbackByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<ProblemFeedback> getProblemFeedbackByPageCount(@RequestParam Map<String, Object> anyVal) {
		int reslut = problemFeedbackService.getProblemFeedbackByPageCount(anyVal);
		Page<ProblemFeedback> page = new Page<ProblemFeedback>(reslut, 1);
		return page;
	}

	@RequestMapping(value = "findConditionProblemFeedbackByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<ProblemFeedback> findConditionProblemFeedbackByPage(@RequestParam Map<String, Object> anyVal) {
		List<ProblemFeedback> list = problemFeedbackService.findConditionProblemFeedbackByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getProblemFeedbackById.do", method = RequestMethod.POST)
	@ResponseBody
	public ProblemFeedback getProblemFeedbackById(Integer id) {
		ProblemFeedback problemFeedback = problemFeedbackService.getProblemFeedbackById(id);
		return problemFeedback;
	}

	@RequestMapping(value = "getProblemFeedbackByReports.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getProblemFeedbackByReports() {
		return problemFeedbackService.getProblemFeedbackByReports();

	}
}

package com.warehouse.service;

import com.warehouse.entity.ProblemFeedback;

import java.util.List;
import java.util.Map;

/**
 * Created by Beilaile on 2016/11/30.
 */
public interface ProblemFeedbackService {
	int addProblemFeedback(ProblemFeedback problemFeedback);

	int ModifyProblemFeedback(ProblemFeedback problemFeedback);

	int delProblemFeedbackById(Integer id);

	// 带条件查询总条数
	int getProblemFeedbackByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<ProblemFeedback> findConditionProblemFeedbackByPage(Map<String, Object> anyVal);

	// 带id查询
	ProblemFeedback getProblemFeedbackById(Integer id);

	// 报表
	Map<String, Object> getProblemFeedbackByReports();
}

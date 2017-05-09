package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.ProblemFeedback;

public interface ProblemFeedbackMapper {
	int addProblemFeedback(ProblemFeedback problemFeedback);

	int ModifyProblemFeedback(ProblemFeedback problemFeedback);

	int delProblemFeedbackById(ProblemFeedback problemFeedback);

	// 带条件查询总条数
	int getProblemFeedbackByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<ProblemFeedback> findConditionProblemFeedbackByPage(Map<String, Object> anyVal);

	ProblemFeedback getProblemFeedbackById(@Param("id") Integer id);

	// 报表名字
	List<ProblemFeedback> getProblemFeedbackByLink();

	// 报表日期
	List<ProblemFeedback> getProblemFeedbackByCreatedate();

	// 报表
	List<ProblemFeedback> getProblemFeedbackByReports();
}
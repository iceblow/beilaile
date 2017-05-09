package com.warehouse.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ProblemFeedbackMapper;
import com.warehouse.entity.ProblemFeedback;
import com.warehouse.util.DateUtils;

/**
 * Created by Beilaile on 2016/11/30.
 */
@Service
public class ProblemFeedbackServiceImpl implements ProblemFeedbackService {
	@Resource
	private ProblemFeedbackMapper problemFeedbackMapper;

	@Override
	public int addProblemFeedback(ProblemFeedback problemFeedback) {
		problemFeedback.setCreatedTime(DateUtils.formateDaTime(new Date()));
		problemFeedback.setStatus("1");
		int reslut = problemFeedbackMapper.addProblemFeedback(problemFeedback);
		return reslut;
	}

	@Override
	public int ModifyProblemFeedback(ProblemFeedback problemFeedback) {
		problemFeedback.setModifyTime(DateUtils.formateDaTime(new Date()));
		int reslut = problemFeedbackMapper.ModifyProblemFeedback(problemFeedback);
		return reslut;
	}

	@Override
	public int delProblemFeedbackById(Integer id) {
		ProblemFeedback problemFeedback = new ProblemFeedback();
		problemFeedback.setId(id);
		problemFeedback.setStatus("0");
		int reslut = problemFeedbackMapper.delProblemFeedbackById(problemFeedback);
		return reslut;
	}

	@Override
	public int getProblemFeedbackByPageCount(Map<String, Object> anyVal) {
		int reslut = problemFeedbackMapper.getProblemFeedbackByPageCount(anyVal);
		return reslut;
	}

	@Override
	public List<ProblemFeedback> findConditionProblemFeedbackByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<ProblemFeedback> list = problemFeedbackMapper.findConditionProblemFeedbackByPage(anyVal);
		return list;
	}

	@Override
	public ProblemFeedback getProblemFeedbackById(Integer id) {
		ProblemFeedback problemFeedback = problemFeedbackMapper.getProblemFeedbackById(id);
		return problemFeedback;
	}

	/**
	 * 查询报表
	 */

	@Override
	public Map<String, Object> getProblemFeedbackByReports() {
		List<ProblemFeedback> allList = problemFeedbackMapper.getProblemFeedbackByReports();// 查询所有数据（个数，日期，环节）
		List<ProblemFeedback> listCreatedate = problemFeedbackMapper.getProblemFeedbackByCreatedate();// 查询换节
		List<ProblemFeedback> listLink = problemFeedbackMapper.getProblemFeedbackByLink();// 查询日期
		Map map = new HashMap(); // map要返回值个页面
		List<ProblemFeedback> listArray = new ArrayList();// list实体
		String[] date = new String[listCreatedate.size()];// 日期数组
		String[] Name = new String[listLink.size()]; // 名字数组
		for (int i = 0; i < listLink.size(); i++) {// 循环添加环节到名字数组
			Name[i] = listLink.get(i).getLink();
		}
		for (int i = 0; i < listCreatedate.size(); i++) {// 循环添加
			date[i] = listCreatedate.get(i).getCreatedate();
		}
		for (int i = 0; i < Name.length; i++) {// 循环环节（生产，采购）
			int[] totals = new int[date.length]; // 个数数组
			for (int j = 0; j < date.length; j++) {// 循环日期(2016-11-11)
				for (int k = allList.size() - 1; k >= 0; k--) {// 循环所有数据的总条数
					int t = 0;
					if (allList.get(k).getLink().equals(Name[i]) && allList.get(k).getCreatedate().equals(date[j])) {// 判断
						t = allList.get(k).getCountNumber();/// 个数=结果
					}
					totals[j] = t;// 个数=t
					if (allList.get(k).getLink().equals(Name[i]) && allList.get(k).getCreatedate().equals(date[j])) {
						// 如果找到符合条件的就跳出当前循环,减少循环的次数
						break;
					}
				}
			}
			ProblemFeedback problemFeedback = new ProblemFeedback();// 实体声明
			problemFeedback.setName(Name[i]);
			problemFeedback.setData(totals);
			// 将对象写入数据集合中
			listArray.add(problemFeedback);
		}
		map.put("date", date);
		map.put("storage", listArray);
		return map;
	}
}

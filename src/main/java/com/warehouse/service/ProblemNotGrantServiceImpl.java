package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ProblemNotGrantMapper;
import com.warehouse.entity.ProblemNotGrant;

@Service
public class ProblemNotGrantServiceImpl implements ProblemNotGrantService {

	@Resource
	private ProblemNotGrantMapper problemNotGrantMapper;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
	
	
	/**
	 * 假删除
	 */	
	@Override
	public int deleteByProblemNotGrantId(ProblemNotGrant problemNotGrant) {
		problemNotGrant.setDelTime(sdf.format(new Date()));
		int result = this.problemNotGrantMapper.deleteByProblemNotGrantId(problemNotGrant);
		return result;
	}

	/**
	 * 分页查询
	 */
	@Override
	public int getCountByProblemNotGrantLike(ProblemNotGrant problemNotGrant) {
		int count = this.problemNotGrantMapper.getCountByProblemNotGrantLike(problemNotGrant);
		return count;
	}
	@Override
	public List<ProblemNotGrant> ProblemNotGrantbylike(ProblemNotGrant problemNotGrant) {
		List<ProblemNotGrant> grants = this.problemNotGrantMapper.ProblemNotGrantbylike(problemNotGrant);
		return grants;
	}
	/**
	 * 双击修改
	 */
	@Override
	public int updateByText(ProblemNotGrant problemNotGrant) {		
		return this.problemNotGrantMapper.updateByText(problemNotGrant);
	}
}

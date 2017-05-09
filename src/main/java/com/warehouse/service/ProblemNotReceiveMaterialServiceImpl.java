package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ProblemNotReceiveMaterialMapper;
import com.warehouse.entity.ProblemNotReceiveMaterial;

@Service
public class ProblemNotReceiveMaterialServiceImpl implements ProblemNotReceiveMaterialService {
	@Resource
	private ProblemNotReceiveMaterialMapper problemNotReceiveMaterialMapper;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
	
	
	/**
	 * 假删除 
	 */
	@Override
	public int deleteByProblemNotReceiveMaterialId(ProblemNotReceiveMaterial problemNotReceiveMaterial) {
		problemNotReceiveMaterial.setDelTime(sdf.format(new Date()));
		int result = this.problemNotReceiveMaterialMapper.deleteByProblemNotReceiveMaterialId(problemNotReceiveMaterial);
		return result;
	}
	/**
	 * 模糊查询
	 */
	@Override
	public int getCountByProblemNotReceiveMaterialLike(ProblemNotReceiveMaterial problemNotReceiveMaterial) {
		int count = this.problemNotReceiveMaterialMapper.getCountByProblemNotReceiveMaterialLike(problemNotReceiveMaterial);
		return count;
	}
	@Override
	public List<ProblemNotReceiveMaterial> ProblemNotReceiveMaterialbylike(
			ProblemNotReceiveMaterial problemNotReceiveMaterial) {
		List<ProblemNotReceiveMaterial> list = this.problemNotReceiveMaterialMapper.ProblemNotReceiveMaterialbylike(problemNotReceiveMaterial);
		return list;
	}
	/**
	 * 双击修改
	 */
	@Override
	public int updateByText(ProblemNotReceiveMaterial problemNotReceiveMaterial) {
		
		return this.problemNotReceiveMaterialMapper.updateByText(problemNotReceiveMaterial);
	}

}

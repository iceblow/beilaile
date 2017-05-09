package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ReturnToSinglePatternMapper;
import com.warehouse.entity.ReturnToSinglePattern;

@Service
public class ReturnToSinglePatternServiceServlce implements ReturnToSinglePatternService {

	@Resource
	private ReturnToSinglePatternMapper returnToSinglePatternMapper;

	//查询数据量
	@Override
	public int getCount(ReturnToSinglePattern returnToSinglePattern) {
		return this.returnToSinglePatternMapper.getCount(returnToSinglePattern);
	}

	//查询分页数据
	@Override
	public List<ReturnToSinglePattern> getDataByPage(ReturnToSinglePattern returnToSinglePattern) {
		return this.returnToSinglePatternMapper.getDataByPage(returnToSinglePattern);
	}

	//需要样衣
	@Override
	public int needToBeSampleCloth(int id) {
		return this.returnToSinglePatternMapper.needToBeSampleCloth(id);
	}

	//纸样完成
	@Override
	public int pieceSampleComplete(int id) {
		return this.returnToSinglePatternMapper.pieceSampleComplete(id);
	}

}

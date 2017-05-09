package com.warehouse.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.TaisanCuttingOutflowMapper;
import com.warehouse.entity.TaisanCuttingOutflow;
import com.warehouse.util.PageUtil;

@Service
public class TaisanCuttingOutflowServiceImpl implements TaisanCuttingOutflowService {

	@Resource
	private TaisanCuttingOutflowMapper taisanCuttingOutflowMapper;

	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, TaisanCuttingOutflow taisanCuttingOutflow) {
		pageUtil.setPageSize(10);
		pageUtil.setTotolCount(this.taisanCuttingOutflowMapper.getCount(taisanCuttingOutflow));
		Map<String, Object> map = new HashMap<>();
		map.put("pageUtil", pageUtil);
		map.put("dataList", this.taisanCuttingOutflowMapper.getDataByPage(
				new TaisanCuttingOutflow(pageUtil.getReqult()[0], pageUtil.getReqult()[1], taisanCuttingOutflow)));
		return map;
	}

	@Override
	public int cuttingPieceReady(String wave) {
		return this.taisanCuttingOutflowMapper.cuttingPieceReady(wave);
	}

	@Override
	public int cuttingPieceOut(String wave) {
		return this.taisanCuttingOutflowMapper.cuttingPieceOut(wave);
	}
	
	//修改字段RowOfSingleAgain
	@Override
	public int updateRowOfSingleAgainByWave(String wave) {
		return this.taisanCuttingOutflowMapper.updateRowOfSingleAgainByWave(wave);
	}

}

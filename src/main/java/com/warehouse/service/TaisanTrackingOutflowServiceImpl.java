package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.TaisanTrackingOutflowMapper;
import com.warehouse.entity.TaisanTrackingOutflow;
import com.warehouse.util.PageUtil;

@Service
public class TaisanTrackingOutflowServiceImpl implements TaisanTrackingOutflowService {

	@Resource
	private TaisanTrackingOutflowMapper taisanTrackingOutflowMapper;

	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, TaisanTrackingOutflow taisanTrackingOutflow) {
		pageUtil.setPageSize(10);
		pageUtil.setTotolCount(this.taisanTrackingOutflowMapper.getCount(taisanTrackingOutflow));
		Map<String, Object> map = new HashMap<>();
		map.put("dataList", this.taisanTrackingOutflowMapper.getDataByPage(
				new TaisanTrackingOutflow(pageUtil.getReqult()[0], pageUtil.getReqult()[1], taisanTrackingOutflow)));
		map.put("pageUtil", pageUtil);
		return map;
	}

	@Override
	public int arrangeFabricAndAssistMaterial(String wave) {
		return this.taisanTrackingOutflowMapper.arrangeFabricAndAssistMaterial(wave);
	}

	@Override
	public int informFactory(String wave) {
		return this.taisanTrackingOutflowMapper.informFactory(wave);
	}

	@Override
	public TaisanTrackingOutflow getOneByWave(String wave) {
		return this.taisanTrackingOutflowMapper.getOneByWave(wave);
	}

	@Override
	public int updateFactory(TaisanTrackingOutflow taisanTrackingOutflow) {
		return this.taisanTrackingOutflowMapper.updateFactory(taisanTrackingOutflow);
	}

	@Override
	public int updateRowOfSingleAgain(String wave) {
		return this.taisanTrackingOutflowMapper.updateRowOfSingleAgain(wave);
	}

}

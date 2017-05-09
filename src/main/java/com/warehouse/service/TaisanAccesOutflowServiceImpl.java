package com.warehouse.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.TaisanAccesOutflowMapper;
import com.warehouse.entity.TaisanAccesOutflow;
import com.warehouse.util.PageUtil;

@Service
public class TaisanAccesOutflowServiceImpl implements TaisanAccesOutflowService {

	@Resource
	private TaisanAccesOutflowMapper taisanAccesOutflowMapper;

	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, TaisanAccesOutflow taisanAccesOutflow) {
		pageUtil.setPageSize(10);
		pageUtil.setTotolCount(this.taisanAccesOutflowMapper.getCount(taisanAccesOutflow));
		Map<String, Object> map = new HashMap<>();
		map.put("pageUtil", pageUtil);
		map.put("dataList", this.taisanAccesOutflowMapper.getDataByPage(
				new TaisanAccesOutflow(pageUtil.getReqult()[0], pageUtil.getReqult()[1], taisanAccesOutflow)));
		return map;
	}

	@Override
	public int assistMaterialReady(String wave) {
		// TODO Auto-generated method stub
		return this.taisanAccesOutflowMapper.assistMaterialReady(wave);
	}

	@Override
	public int assistOut(String wave) {
		// TODO Auto-generated method stub
		return this.taisanAccesOutflowMapper.assistOut(wave);
	}

	@Override//重新安排订单
	public int rowOfSingleAgain(String wave) {
		
		return this.taisanAccesOutflowMapper.rowOfSingleAgain(wave);
	}

}

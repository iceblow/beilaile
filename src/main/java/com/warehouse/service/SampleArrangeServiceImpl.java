package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.SampleArrangeMapper;
import com.warehouse.entity.SampleArrange;
import com.warehouse.util.PageUtil;

@Service
public class SampleArrangeServiceImpl implements SampleArrangeService {

	@Resource
	private SampleArrangeMapper sampleArrangeMapper;
	
	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, SampleArrange sampleArrange) {
		pageUtil.setPageSize(13);
		pageUtil.setTotolCount(this.sampleArrangeMapper.getCount(sampleArrange));
		List<SampleArrange> dataList=this.sampleArrangeMapper.getDataByPage(new SampleArrange(pageUtil.getReqult()[0], pageUtil.getReqult()[1], sampleArrange));
		Map<String, Object> map=new HashMap<>();
		map.put("dataList", dataList);
		map.put("pageUtil", pageUtil);
		return map;
	}

	@Override
	public int dbUpdate(SampleArrange sampleArrange) {
		return this.sampleArrangeMapper.dbUpdate(sampleArrange);
	}

	@Override
	public int out(String wave) {
		return this.sampleArrangeMapper.out(wave);
	}

	@Override
	public int addForModel(SampleArrange sampleArrange) {
		return this.sampleArrangeMapper.addForModel(sampleArrange);
	}

}

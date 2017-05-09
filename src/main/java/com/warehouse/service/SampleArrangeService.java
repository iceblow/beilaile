package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.SampleArrange;
import com.warehouse.util.PageUtil;

public interface SampleArrangeService {

	Map<String, Object> getDataByPage(PageUtil pageUtil, SampleArrange sampleArrange);

	int dbUpdate(SampleArrange sampleArrange);

	int out(String wave);
	/**
	 * 添加模特样衣安排数据
	 * @param sampleArrange
	 * @return
	 */
	int addForModel(SampleArrange sampleArrange);

}

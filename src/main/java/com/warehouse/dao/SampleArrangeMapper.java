package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.SampleArrange;

public interface SampleArrangeMapper {
	
    int getCount(SampleArrange sampleArrange);
    
    List<SampleArrange> getDataByPage(SampleArrange sampleArrange);

	int dbUpdate(SampleArrange sampleArrange);
	/**
	 * 模特需要样衣安排
	 * @param sampleArrange
	 * @return
	 */
	int addForModel(SampleArrange sampleArrange);

	int out(String wave);
}
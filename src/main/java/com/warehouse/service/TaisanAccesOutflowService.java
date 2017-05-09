package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.TaisanAccesOutflow;
import com.warehouse.util.PageUtil;

public interface TaisanAccesOutflowService {

	Map<String, Object> getDataByPage(PageUtil pageUtil, TaisanAccesOutflow taisanAccesOutflow);

	int assistMaterialReady(String wave);

	int assistOut(String wave);
	
	int rowOfSingleAgain(String wave);//重新安排订单

}

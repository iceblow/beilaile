package com.warehouse.service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.CuttingFabricCompletedMapper;
import com.warehouse.dao.PrintingCuttingCompletedMapper;
import com.warehouse.entity.CuttingFabricCompleted;
import com.warehouse.entity.PrintingCuttingCompleted;
import com.warehouse.util.PageUtil;

@Service
public class CuttingFabricCompletedServiceImpl implements CuttingFabricCompletedService {

	@Resource
	private CuttingFabricCompletedMapper cuttingFabricCompletedMapper;

	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, CuttingFabricCompleted cuttingFabricCompleted) {
		pageUtil.setPageSize(15);// 每页显示条数
		pageUtil.setTotolCount(cuttingFabricCompletedMapper.getCountByPage(cuttingFabricCompleted));// 总的数据量
		List<CuttingFabricCompleted> dataList = this.cuttingFabricCompletedMapper.getDataByPage(new CuttingFabricCompleted(pageUtil.getReqult()[0], pageUtil.getReqult()[1], cuttingFabricCompleted));// 显示的数据

		Map<String, Object> mydata=new HashMap<>();
		mydata.put("data", dataList);
		mydata.put("styleSum",pageUtil.getTotolCount());
		mydata.put("orderSum",this.cuttingFabricCompletedMapper.getOrderSum(cuttingFabricCompleted));
		
		Map<String, Object> map = new HashMap<>();
		map.put("dataList", mydata);
		map.put("pageUtil", pageUtil);
		return map;
	}

	@Override
	public int updateDateByWave(CuttingFabricCompleted cuttingFabricCompleted) {
		return this.cuttingFabricCompletedMapper.updateDateByWave(cuttingFabricCompleted);
	}

	@Override
	public int remarkUpdate(String wave) {
		return this.cuttingFabricCompletedMapper.remarkUpdate(wave);
	}

	@Override
	public int planCut(CuttingFabricCompleted cuttingFabricCompleted) {
		return this.cuttingFabricCompletedMapper.planCut(cuttingFabricCompleted);
	}

}

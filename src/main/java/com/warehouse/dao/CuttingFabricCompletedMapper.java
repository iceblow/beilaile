package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.CuttingFabricCompleted;

public interface CuttingFabricCompletedMapper {
	
	int getCountByPage(CuttingFabricCompleted cuttingFabricCompleted);

	List<CuttingFabricCompleted> getDataByPage(CuttingFabricCompleted cuttingFabricCompleted);
	
	int updateDateByWave(CuttingFabricCompleted cuttingFabricCompleted);

	int remarkUpdate(String wave);

	Integer getOrderSum(CuttingFabricCompleted cuttingFabricCompleted);
	
	int planCut(CuttingFabricCompleted cuttingFabricCompleted);
}
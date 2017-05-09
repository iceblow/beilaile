package com.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricOutflowReady;

public interface FabricOutflowReadyMapper {

	int getCountByPage(FabricOutflowReady record);

	List<FabricOutflowReady> getDataByPage(FabricOutflowReady record);

	int completeReady(int id);

	int dbUpdateData(FabricOutflowReady ready);

	List<FabricOutflowReady> toExcle(@Param("idList") String idList);

	int completeSuccess(int id);

}
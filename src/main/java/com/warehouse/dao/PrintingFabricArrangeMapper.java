package com.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.PrintingFabricArrange;

public interface PrintingFabricArrangeMapper {

	int getCountByPage(PrintingFabricArrange record);

	List<PrintingFabricArrange> getDataByPage(PrintingFabricArrange printingFabricArrange);

	int completeReady(int id);

	int dbUpdateData(PrintingFabricArrange ready);

	List<PrintingFabricArrange> toExcle(@Param("idList") String idList);

	int completeSuccess(int id);

}
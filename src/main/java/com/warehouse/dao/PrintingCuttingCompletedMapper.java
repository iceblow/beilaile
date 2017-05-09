package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.PrintingCuttingCompleted;

public interface PrintingCuttingCompletedMapper {
	
	int getCountByPage(PrintingCuttingCompleted printingCuttingCompleted);
	
	List<PrintingCuttingCompleted> getDataByPage(PrintingCuttingCompleted printingCuttingCompleted);
	
	int updateDataByWave(PrintingCuttingCompleted printingCuttingCompleted);
	
}
package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.PrintingAndEmbroideredOrder;

public interface PrintingAndEmbroideredOrderMapper {

	int getCount(PrintingAndEmbroideredOrder printingAndEmbroideredOrder);

	List<PrintingAndEmbroideredOrder> getDataByPage(PrintingAndEmbroideredOrder printingAndEmbroideredOrder);

	PrintingAndEmbroideredOrder selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(PrintingAndEmbroideredOrder record);

	int updateByPrimaryKey(PrintingAndEmbroideredOrder record);
	
	void updateDataByWave(String wave);
}
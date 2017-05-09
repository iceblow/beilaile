package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.FabricTotalPrice;

public interface FabricTotalPriceMapper {
	
	//查询总条数
   int selectFabric(FabricTotalPrice fabricTotalPrice);
   
   //返回分页的结果
   List<FabricTotalPrice>getFabricPage(FabricTotalPrice fabricTotalPrice);
	
}
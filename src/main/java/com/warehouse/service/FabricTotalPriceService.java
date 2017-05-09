package com.warehouse.service;

import java.util.List;
import com.warehouse.entity.FabricTotalPrice;

public interface FabricTotalPriceService {

	//分页查询返回总条数
	int selectFabric(FabricTotalPrice fabricTotalPrice);
	
	//返回分页查询的结果
	List<FabricTotalPrice> getFabricPage(FabricTotalPrice fabricTotalPrice);
}

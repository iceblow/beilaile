package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricTotalPriceMapper;
import com.warehouse.entity.FabricTotalPrice;

@Service
public class FabricTotalPriceServiceImpl implements FabricTotalPriceService{

	@Resource
	private FabricTotalPriceMapper fabricTotalPriceMapper;

	//返回分页查询的总条数
	@Override
	public int selectFabric(FabricTotalPrice fabricTotalPrice) {
		
		return fabricTotalPriceMapper.selectFabric(fabricTotalPrice);
	}
	
	//返回分页查询的结果
	@Override
	public List<FabricTotalPrice> getFabricPage(FabricTotalPrice fabricTotalPrice) {
		
		return fabricTotalPriceMapper.getFabricPage(fabricTotalPrice);
	}
}

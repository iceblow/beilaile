package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.AuxiliaryFabric;

public interface AuxiliaryFabricService {
	//查询数据量的方法
	int getCount(AuxiliaryFabric auxiliaryFabric);
	//分页查询方法
	List<AuxiliaryFabric> getAllByPage(AuxiliaryFabric auxiliaryFabric);
	//查询单个信息方法
	AuxiliaryFabric getOne(Integer id);
	//普通修改方法
	void update(AuxiliaryFabric auxiliaryFabric);
	//双击修改方法
	void myDBupdate(AuxiliaryFabric auxiliaryFabric);

}

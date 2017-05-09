package com.warehouse.dao;

import com.warehouse.entity.Manufacturer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ManufacturerMapper {
	// 添加对象
	int addManufacturer(Manufacturer manufacturer);

	// 修改对象
	int updateManufacturer(Manufacturer manufacturer);

	// 修改对象
	int deleteManufacturer(Manufacturer manufacturer);

	// 根据条件查询总条数
	int getManufacturerByPageCount(Map<String, Object> anyValue);

	// 根据条件查询分页数据
	List<Manufacturer> findConditionManufacturerByPage(Map<String, Object> anyValue);

	// 根据名字查找
	int getManufacturerByFactoryName(@Param("factoryName") String factoryName);

	// 根据id查找
	Manufacturer findManufacturerById(@Param("id") Integer id);

	// 查询所有工厂
	List<Manufacturer> findManufacturerByAllFactory();
}
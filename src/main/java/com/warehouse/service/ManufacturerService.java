package com.warehouse.service;

import com.warehouse.entity.Manufacturer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Beilaile on 2017/2/24.
 */
public interface ManufacturerService {
	// 添加对象
	int addManufacturer(Manufacturer manufacturer, HttpServletRequest request);

	// 修改对象
	int updateManufacturer(Manufacturer manufacturer, HttpServletRequest request);

	// 修改对象
	int deleteManufacturer(Manufacturer manufacturer, HttpServletRequest request);

	// 根据条件查询总条数
	int getManufacturerByPageCount(Map<String, Object> anyValue);

	// 根据条件查询分页数据
	List<Manufacturer> findConditionManufacturerByPage(Map<String, Object> anyValue);

	// 根据id查找
	Manufacturer findManufacturerById(@Param("id") Integer id);
	
	// 根据id查找
	List<Manufacturer> selectAllFactory();
	

	// 根据名字查找个数
	int getManufacturerByFactoryName(@Param("factoryName") String factoryName);

	// 查询所有工厂
	List<Manufacturer> findManufacturerByAllFactory();

}

package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.BuildProgress;

public interface BuildProgressMapper {
	// 添加對象
	int insertSelective(BuildProgress buildProgress);

	// 修改对象
	int modifyByBuildProgress(BuildProgress buildProgress);

	// 刪除對象
	int delByPrimaryKey(@Param("wave") String wave, @Param("delTime") String delTime);

	// 查詢數據帶條件
	List<BuildProgress> findByAnyValPage(Map<String, Object> anyval);

	// 带条件查询总条数
	int getAnyVaTotalPageCount(Map<String, Object> anyval);

	// 带条件查询总条数
	Integer getAnyValSumOrderNumber(Map<String, Object> anyval);

	// 查询产品
	List<BuildProgress> findProduct();

	// 查询产品
	BuildProgress getModifyBuildProgressByWave(@Param("wave") String wave);
}
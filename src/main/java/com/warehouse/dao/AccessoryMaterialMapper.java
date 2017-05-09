package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.AccessoryMaterial;

public interface AccessoryMaterialMapper {
	// 添加对象
	int addAccessoryMaterial(AccessoryMaterial accessoryMaterial);

	// 修改对象
	int modifyAccessoryMaterial(AccessoryMaterial accessoryMaterial);

	// 删除对象
	int delAccessoryMaterialById(AccessoryMaterial accessoryMaterial);

	// 带条件查询总条数
	int getAccessoryMaterialByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<AccessoryMaterial> findConditionAccessoryMaterialByPage(Map<String, Object> anyVal);

	// 修改获取数据根据id
	AccessoryMaterial getAccessoryMaterialById(@Param("id") Integer id);

	// 修改对象
	int savaAccessoryMaterialArgsUpdate(AccessoryMaterial accessoryMaterial);

	//更新发放状态
	int updateIssuedStatus(AccessoryMaterial accessoryMaterial);

//	//根据波次号更新 发放状态为被驳回
//	void updateIStoReject(String wave);
}
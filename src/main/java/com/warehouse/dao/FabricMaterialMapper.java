package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricMaterial;

public interface FabricMaterialMapper {
	// 添加对象
	int addFabricMaterial(FabricMaterial fabricMaterial);

	// 修改对象
	int modifyFabricMaterial(FabricMaterial fabricMaterial);

	// 删除对象
	int delFabricMaterialById(FabricMaterial fabricMaterial);

	// 带条件查询总条数
	int getFabricMaterialByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<FabricMaterial> findConditionFabricMaterialByPage(Map<String, Object> anyVal);

	// 带条件查询总条数
	int selectFabricMaterialByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<FabricMaterial> selectConditionFabricMaterialByPage(Map<String, Object> anyVal);

	// 修改获取数据根据id
	FabricMaterial getFabricMaterialById(@Param("id") Integer id);

	// 修改对象
	int updateFabricMaterialByStatus(FabricMaterial fabricMaterial);

	// 修改对象
	int updateFabricMaterialByPurchase(FabricMaterial fabricMaterial);

	// 修改对象
	int updateFabricMaterialByOverrule(FabricMaterial fabricMaterial);

	// 生成成功表格
	List<FabricMaterial> findFabricMaterialByExcel();
}
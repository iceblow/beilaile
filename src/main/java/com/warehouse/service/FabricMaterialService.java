package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FabricMaterial;

/**
 * 
 * @author Beilaile 2016年12月12日18:12:27
 *
 */
public interface FabricMaterialService {
	// 添加对象
	int addFabricMaterial(FabricMaterial fabricMaterial, HttpServletRequest request);

	// 修改对象
	int modifyFabricMaterial(FabricMaterial fabricMaterial, HttpServletRequest request);

	// 删除对象
	int delFabricMaterialById(FabricMaterial fabricMaterial, HttpServletRequest request);

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

	int updateFabricMaterialByStatus(FabricMaterial fabricMaterial, HttpServletRequest request);

	int updateFabricMaterialByPurchase(FabricMaterial fabricMaterial, HttpServletRequest request);

	int updateFabricMaterialByOverrule(FabricMaterial fabricMaterial, HttpServletRequest request);

	// 生成成功表格
	List<FabricMaterial> findFabricMaterialByExcel();

}

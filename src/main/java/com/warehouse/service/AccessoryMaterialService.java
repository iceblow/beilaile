package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.AccessoryMaterial;

/**
 * Created by Beilaile on 2016/12/8.
 */
public interface AccessoryMaterialService {
	// 添加对象
	int addAccessoryMaterial(AccessoryMaterial accessoryMaterial, HttpServletRequest request);

	// 修改对象
	int modifyAccessoryMaterial(AccessoryMaterial accessoryMaterial, HttpServletRequest request);

	// 删除对象
	int delAccessoryMaterialById(AccessoryMaterial accessoryMaterial, HttpServletRequest request);

	// 带条件查询总条数
	int getAccessoryMaterialByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<AccessoryMaterial> findConditionAccessoryMaterialByPage(Map<String, Object> anyVal);

	// 修改获取数据根据id
	AccessoryMaterial getAccessoryMaterialById(@Param("id") Integer id);

	// 双击保存
	AccessoryMaterial savaAccessoryMaterialArgsUpdate(AccessoryMaterial am, HttpServletRequest request);

//	弃用功能
// 确认辅料准备就绪
//	int confirmReady(Integer am, HttpServletRequest request);
//
//	// 确认辅料已发放
//	int alreadyIssue(Integer amId, HttpServletRequest request);
//
//	// 辅料状态重置
//	int resetState(Integer amId, HttpServletRequest request);

	int manageAmComplete(Integer amId, HttpServletRequest request);
}

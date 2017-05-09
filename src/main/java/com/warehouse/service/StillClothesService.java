package com.warehouse.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.StillClothes;

public interface StillClothesService {
	// 添加对象
	int addStillClothes(StillClothes stillClothes);

	// 修改对象
	int modifyStillClothes(StillClothes stillClothes);

	// 删除对象
	int delStillClothesById(StillClothes stillClothes);

	// 带条件查询总条数
	int getStillClothesByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<StillClothes> findConditionStillClothesByPage(Map<String, Object> anyVal);

	// 修改获取数据根据id
	StillClothes getStillClothesById(@Param("id") Integer id);
}

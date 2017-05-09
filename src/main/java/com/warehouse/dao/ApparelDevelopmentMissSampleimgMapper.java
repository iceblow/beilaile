package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.ApparelDevelopmentMissSampleimg;

public interface ApparelDevelopmentMissSampleimgMapper {

	// 删除服装开发信息
	int deleteByPrimaryKey(ApparelDevelopmentMissSampleimg record);

	// 添加服装开发信息
	int insertSelective(ApparelDevelopmentMissSampleimg record);

	// 根据id查询
	ApparelDevelopmentMissSampleimg getApparelDevelopmentMissSampleimgById(Integer id);

	// 修改服装开发信息
	int updateByPrimaryKeySelective(ApparelDevelopmentMissSampleimg record);

	// 分页
	int getCountByLike(ApparelDevelopmentMissSampleimg record);

	List<ApparelDevelopmentMissSampleimg> getApparelDevelopmentMissSampleimgByLike(
			ApparelDevelopmentMissSampleimg page);

	// 生成工艺单
	ApparelDevelopmentMissSampleimg queryEtrack(Integer id);

}
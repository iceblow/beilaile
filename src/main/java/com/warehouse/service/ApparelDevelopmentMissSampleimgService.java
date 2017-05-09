package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ApparelDevelopmentMissSampleimg;

public interface ApparelDevelopmentMissSampleimgService {

	// 添加服装开发信息
	int addApparelDevelopmentMissSampleimg(ApparelDevelopmentMissSampleimg record);

	// 根据id查询
	ApparelDevelopmentMissSampleimg getApparelDevelopmentMissSampleimgById(Integer id);

	// 修改服装开发信息
	int updateApparelDevelopmentMissSampleimg(ApparelDevelopmentMissSampleimg record);

	// 删除服装开发信息
	int delApparelDevelopmentMissSampleimg(ApparelDevelopmentMissSampleimg record);

	// 分页查询
	int getCountByLike(ApparelDevelopmentMissSampleimg record);

	List<ApparelDevelopmentMissSampleimg> getApparelDevelopmentMissSampleimgByLike(
			ApparelDevelopmentMissSampleimg page);

	// 生成工艺单
	ApparelDevelopmentMissSampleimg queryEtrack(Integer id);

}

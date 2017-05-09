package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.GetEmbroider;

public interface GetEmbroiderService {

	// 添加
	int insertEmbroider(GetEmbroider embroider);

	// 删除
	int deleteEmbroider(GetEmbroider embroider);

	// 修改前查询
	List<GetEmbroider> selEmbroider(Integer orderId);

	// 修改
	int updateEmbroider(GetEmbroider embroider);

	// 模糊查询
	int getCountByLike(GetEmbroider embroider);// 数量

	List<GetEmbroider> getEmbroiderByLike(GetEmbroider embroider);

}

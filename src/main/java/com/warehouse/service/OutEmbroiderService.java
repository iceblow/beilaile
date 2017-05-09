package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.OutEmbroider;

public interface OutEmbroiderService {

	// 添加
	void insertOutEmbroider(OutEmbroider embroider);

	// 删除
	void deleteOutEmbroider(OutEmbroider embroider);

	OutEmbroider selectByPrimaryKey(Integer id);

	// 修改
	void updateOutEmbroider(OutEmbroider embroider);

	// 模糊查询
	int getCountByOutLike(String girard);

	List<OutEmbroider> outEmbroiderByLike(OutEmbroider outEmbroider);

}

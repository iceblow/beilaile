package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.GetEmbroider;

public interface GetEmbroiderMapper {

	// 添加
	int addEmbroider(GetEmbroider embroider);

	// 删除
	int delEmbroider(GetEmbroider embroider);

	// 根据订单号查询数据
	List<GetEmbroider> selEmbroider(Integer orderId);

	// 修改
	int uppEmbroider(GetEmbroider embroider);

	// 模糊查询

	int getCountByLike(GetEmbroider embroider);// 数量

	List<GetEmbroider> getEmbroiderByLike(GetEmbroider embroider);

}

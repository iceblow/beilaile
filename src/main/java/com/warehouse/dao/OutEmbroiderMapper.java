package com.warehouse.dao;

import java.util.List;
import com.warehouse.entity.OutEmbroider;

public interface OutEmbroiderMapper {

	// 添加
	int insertSelective(OutEmbroider record);

	// 根据id查询
	OutEmbroider selectByPrimaryKey(Integer oid);

	// 修改
	int updateByPrimaryKeySelective(OutEmbroider record);

	// 删除
	void delOutEmbroider(OutEmbroider embroider);

	// 模糊查询
	int getCountByOutLike(String girard);

	List<OutEmbroider> outEmbroiderByLike(OutEmbroider embroider);
}
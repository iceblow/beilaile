package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.OutsideDaily;

public interface OutsideDailyMapper {

	// 删除
	int delOutsideDaily(OutsideDaily daily);

	// 添加
	int insertSelective(OutsideDaily record);

	// 修改前查询
	OutsideDaily selectByPrimaryKey(OutsideDaily outsideDaily);

	// 修改
	int updateByPrimaryKeySelective(OutsideDaily record);

	// 模糊查询
	int getCountByOutsideLike(OutsideDaily daily);

	List<OutsideDaily> OutsideDailyByLike(OutsideDaily outsideDaily);

	// 根据订单号查询
	List<OutsideDaily> selDaily(Integer orderId);
}
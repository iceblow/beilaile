package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.OutsideDaily;

public interface OutsideDailyService {

	// 添加
	void insertOutsideDaily(OutsideDaily outsideDaily);

	// 删除
	void deleteOutsideDaily(OutsideDaily daily);

	// 查询
	OutsideDaily selectByPrimaryKey(OutsideDaily outsideDaily);

	// 修改
	void updateOutsideDaily(OutsideDaily outsideDaily);

	// 模糊查询
	int getCountByOutsideLike(OutsideDaily outsideDaily);

	List<OutsideDaily> OutsideDailyByLike(OutsideDaily outsideDaily);

	// 根据订单号查询
	List<OutsideDaily> selDaily(Integer orderId);

}

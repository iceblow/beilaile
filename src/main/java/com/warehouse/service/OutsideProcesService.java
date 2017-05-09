package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.Outsideproces;
import com.warehouse.util.Pagess;

public interface OutsideProcesService {

	// 添加
	void addProces(Outsideproces outsideproces);

	// 修改
	void uppProces(Outsideproces outsideproces);

	// 删除
	void delProces(Integer bid);

	// 模糊查询
	int getCountByOutsideLike(String girard);

	List<Outsideproces> OutsideProcesByLike(Pagess page);

	/**
	 * 
	 * @param outsideproces
	 * @return
	 */
	// 根据波次查询数据
	List<Outsideproces> getDistinct(Outsideproces outsideproces);

	// 修改件数
	void uppNum(Integer bid, Integer bnumber);

}

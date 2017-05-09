package com.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.Outsideproces;
import com.warehouse.util.Pagess;

public interface OutsideProcesMapper {
	// 添加数据
	void addproces(Outsideproces outsideproces);

	// 修改数据
	void uppProce(Outsideproces outsideproces);

	// 删除数据
	void delProce(Integer bid);

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
	void uppNum(@Param("bid") Integer bid, @Param("bnumber") Integer bnumber);

}

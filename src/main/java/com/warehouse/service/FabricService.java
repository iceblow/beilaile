package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.FabricDemo;
import com.warehouse.util.Pagess;

public interface FabricService {

	/**
	 * 添加用料日报表数据
	 * 
	 * @param fabricDemo
	 */
	void add(FabricDemo fabricDemo);

	/**
	 * 修改用料日报表信息
	 * 
	 * @param fabricDemo
	 */
	void update(FabricDemo fabricDemo);

	/**
	 * 在后台取得不重复的b_id和fabric
	 * 
	 * @return
	 */
	List<FabricDemo> getBidAndFabric(Pagess page);
	/**
	 * 查询不重复的b_id和fabric的数据量
	 * @return
	 */
	int getAllCountByBidAndFabric();
	
	/**
	 * 根据b_id和fabric查询出所有的用量和单位
	 * @param b_id
	 * @param fabric
	 * @return
	 */
	List<FabricDemo> getConsumptionByBidAndFabric(String b_id, String fabric);
	/**
	 * (假)删除用料日报表数据
	 * @param id
	 * @param delTime
	 */
	void delete(FabricDemo fabric);
	/**
	 * 根据bid查询数据量
	 * @param bid
	 * @return
	 */
	int getCountByBid(String bid);

	List<FabricDemo> getAllByBid(Pagess pagess);
	/**
	 * 根据波次号修改日期
	 * @param fa
	 */
	void updateDateByBid(FabricDemo fa);
	
	/**
	 * 根据id查询单条数据
	 * @param id
	 * @return
	 */
	FabricDemo getOne(int id);
}

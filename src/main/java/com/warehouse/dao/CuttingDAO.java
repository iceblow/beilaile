package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.Cutting;
import com.warehouse.util.Pagess;

public interface CuttingDAO {

	// 添加裁床日报表
	void add(Cutting cut);

	// 修改裁床日报表信息
	void update(Cutting cut);
	
	//查询所有数据量
	int getCutCounts();
	
	//所有数据的分页查询
	List<Cutting> getAllByPage(Pagess page);
	
	//根据编号删除信息
	void delCut(int id);
	
	//根據bid查詢數據量
	int getCutCountByBid(Cutting cutting);
	
	//根據bid分頁查詢
	List<Cutting> getAllByBid(Cutting cutting);
	
	//根据id查询单条数据
	Cutting getOne(int id);
	
	//完成方法
	int complete(int id);

}

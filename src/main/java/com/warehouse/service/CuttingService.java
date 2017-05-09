package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.Cutting;
import com.warehouse.util.Pagess;

public interface CuttingService {

	// 添加裁剪日报表方法
	void add(Cutting cut);

	// 修改裁剪日报表数据的方法
	void update(Cutting cut);
	
	//查询总的数据量
	int getCutCounts();

	//所有数据的分页查询
	List<Cutting> getAllByPage(Pagess page);

	//根据编号删除数据
	void delCut(int id);
	
	//根據編號查詢出數據量
	int getCutCountByBid(Cutting cutting);
	
	//根據編號分頁查詢
	List<Cutting> getAllByBid(Cutting cutting);
	
	//根据id查询单条数据
	Cutting getOne(int id);
	
	//完成方法
	int complete(int id);

}

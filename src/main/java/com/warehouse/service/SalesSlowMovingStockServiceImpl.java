package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.SalesSlowMovingStockDAO;
import com.warehouse.entity.SalesSlowMovingStock;
import com.warehouse.util.PageUtil;

@Service
public class SalesSlowMovingStockServiceImpl implements SalesSlowMovingStockService {

	@Resource
	private SalesSlowMovingStockDAO salesSlowMovingStockDAO;

	@Override
	public Map<String, Object> getAllByPage(PageUtil page, SalesSlowMovingStock salesSlowMovingStock) {
		page.setPageSize(15);//写入每页显示数量
		page.setTotolCount(this.salesSlowMovingStockDAO.getCountByPage(salesSlowMovingStock));//写入数据量

		List<SalesSlowMovingStock> dataList = this.salesSlowMovingStockDAO.getDataByPage(
				new SalesSlowMovingStock(page.getReqult()[0], page.getReqult()[1], salesSlowMovingStock));//得到显示数据
		Map<String, Object> map =new HashMap<>();
		map.put("pageUtil", page);
		map.put("dataList", dataList);
		
		return map;
	}

}

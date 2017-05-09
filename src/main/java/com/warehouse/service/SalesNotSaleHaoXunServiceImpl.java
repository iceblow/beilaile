package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.SalesNotSaleHaoXunDAO;
import com.warehouse.entity.SalesNotSaleHaoXun;
import com.warehouse.util.PageUtil;

@Service
public class SalesNotSaleHaoXunServiceImpl implements SalesNotSaleHaoXunService {

	@Resource
	private SalesNotSaleHaoXunDAO notSaleHaoXunDAO;

	@Override
	public Map<String, Object> getDataByPage(PageUtil page, SalesNotSaleHaoXun SalesNotSaleHaoXun) {
		page.setPageSize(15);// 每页显示数据量
		page.setTotolCount(this.notSaleHaoXunDAO.getCountByPage(SalesNotSaleHaoXun));// 写入总的数据量

		List<SalesNotSaleHaoXun> dataList = this.notSaleHaoXunDAO
				.getDataByPage(new SalesNotSaleHaoXun(page.getReqult()[0], page.getReqult()[1], SalesNotSaleHaoXun));// 得到显示的数据
		Map<String, Object> map = new HashMap<>();// 前台接收的数据
		map.put("pageUtil", page);// 加载分页信息
		map.put("dataList", dataList);// 加载显示数据
		return map;
	}

	@Override
	public void addData(SalesNotSaleHaoXun haoXun) {
		this.notSaleHaoXunDAO.addData(haoXun);
	}

}

package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.InputStorageHaoXunDao;
import com.warehouse.entity.InputStorageHaoXun;
import com.warehouse.util.PageUtil;

@Service
public class InputStorageHaoXunServiceImpl implements InputStorageHaoXunService {

	@Resource
	private InputStorageHaoXunDao inputStorageHaoXunDao;

	@Override
	public Map<String, Object> getDataByPage(PageUtil page, InputStorageHaoXun inputStorageHaoXun) {
		page.setPageSize(15);// 每页显示数据量
		page.setTotolCount(this.inputStorageHaoXunDao.getCountByPage(inputStorageHaoXun));// 写入总的数据量

		List<InputStorageHaoXun> dataList = this.inputStorageHaoXunDao
				.getDataByPage(new InputStorageHaoXun(page.getReqult()[0], page.getReqult()[1], inputStorageHaoXun));// 得到显示的数据
		Map<String, Object> map = new HashMap<>();// 前台接收的数据
		map.put("pageUtil", page);// 加载分页信息
		map.put("dataList", dataList);// 加载显示数据
		return map;
	}

	@Override
	public void addData(InputStorageHaoXun haoXun) {
		this.inputStorageHaoXunDao.addData(haoXun);
	}

}

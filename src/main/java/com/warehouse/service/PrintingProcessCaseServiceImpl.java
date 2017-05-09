package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.PrintingProcessCaseMapper;
import com.warehouse.entity.PrintingProcessCase;
import com.warehouse.util.PageUtil;

@Service
public class PrintingProcessCaseServiceImpl implements PrintingProcessCaseService {

	@Resource
	private PrintingProcessCaseMapper printingProcessCaseMapper;

	/**
	 * 分页查询
	 */
	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, PrintingProcessCase printingProcessCase) {
		pageUtil.setPageSize(10);// 写入每页长度
		pageUtil.setTotolCount(this.printingProcessCaseMapper.getCount(printingProcessCase));// 写入总的数据量
		List<PrintingProcessCase> dataList = this.printingProcessCaseMapper.getDataByPage(
				new PrintingProcessCase(pageUtil.getReqult()[0], pageUtil.getReqult()[1], printingProcessCase));// 得到显示的数据
		Map<String, Object> map = new HashMap<>();
		map.put("pageUtil", pageUtil);
		map.put("dataList", dataList);
		return map;
	}

	/**
	 * 匹印领料
	 */
	@Override
	public int fabricOut(int id) {
		return this.printingProcessCaseMapper.fabricOut(id);
	}

	/**
	 * 匹印回料
	 */
	@Override
	public int fabricIn(int id) {
		return this.printingProcessCaseMapper.fabricIn(id);
	}

}

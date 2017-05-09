package com.warehouse.service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.PrintingCuttingCompletedMapper;
import com.warehouse.entity.PrintingCuttingCompleted;
import com.warehouse.util.PageUtil;

@Service
public class PrintingCuttingCompletedServiceImpl implements PrintingCuttingCompletedService {

	@Resource
	private PrintingCuttingCompletedMapper printingCuttingCompletedMapper;

	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, PrintingCuttingCompleted printingCuttingCompleted) {
		pageUtil.setPageSize(15);// 每页显示条数
		pageUtil.setTotolCount(printingCuttingCompletedMapper.getCountByPage(printingCuttingCompleted));// 总的数据量
		List<PrintingCuttingCompleted> dataList = this.printingCuttingCompletedMapper
				.getDataByPage(new PrintingCuttingCompleted(pageUtil.getReqult()[0], pageUtil.getReqult()[1],
						printingCuttingCompleted));// 显示的数据
		Map<String, Object> map = new HashMap<>();
		map.put("dataList", dataList);
		map.put("pageUtil", pageUtil);
		return map;
	}

	@Override
	public int updateDataByWave(PrintingCuttingCompleted printingCuttingCompleted) {
		return this.printingCuttingCompletedMapper.updateDataByWave(printingCuttingCompleted);
	}

}

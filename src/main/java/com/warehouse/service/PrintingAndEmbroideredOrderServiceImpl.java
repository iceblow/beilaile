package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.PrintingAndEmbroideredOrderMapper;
import com.warehouse.entity.PrintingAndEmbroideredOrder;
import com.warehouse.util.PageUtil;

@Service
public class PrintingAndEmbroideredOrderServiceImpl implements PrintingAndEmbroideredOrderService {

	@Resource
	private PrintingAndEmbroideredOrderMapper printingAndEmbroideredOrderMapper;

	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil,
			PrintingAndEmbroideredOrder printingAndEmbroideredOrder) {
		pageUtil.setPageSize(8);
		
		pageUtil.setTotolCount(this.printingAndEmbroideredOrderMapper.getCount(printingAndEmbroideredOrder));
		
		List<PrintingAndEmbroideredOrder> dataList=this.printingAndEmbroideredOrderMapper.getDataByPage(new PrintingAndEmbroideredOrder(
				pageUtil.getReqult()[0], pageUtil.getReqult()[1], printingAndEmbroideredOrder));
		
		Map<String, Object> map = new HashMap<>();
		map.put("pageUtil", pageUtil);
		map.put("dataList", dataList);
		
		return map;
	}

	@Override
	public int completeOrder(PrintingAndEmbroideredOrder printingAndEmbroideredOrder) {
		return this.printingAndEmbroideredOrderMapper.updateByPrimaryKey(printingAndEmbroideredOrder);
	}

	/**
	 * 根据波次修改信息
	 */
	@Override
	public void updateDataByWave(String wave) {
		this.printingAndEmbroideredOrderMapper.updateDataByWave(wave);
	}

}

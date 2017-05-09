package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.PrintingQuoteMapper;
import com.warehouse.entity.PrintingQuote;
import com.warehouse.util.PageUtil;

@Service
public class PrintingQuoteServiceImpl implements PrintingQuoteService {

	@Resource
	private PrintingQuoteMapper printingQuoteMapper;

	/**
	 * 分页查询实现类
	 */
	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, PrintingQuote printingQuote) {
		pageUtil.setPageSize(10);
		pageUtil.setTotolCount(this.printingQuoteMapper.getCount(printingQuote));
		List<PrintingQuote> dataList = this.printingQuoteMapper
				.getDataByPage(new PrintingQuote(pageUtil.getReqult()[0], pageUtil.getReqult()[1], printingQuote));
		Map<String, Object> map = new HashMap<>();
		map.put("pageUtil", pageUtil);
		map.put("dataList", dataList);
		return map;
	}

	/**
	 * 双击修改实现类
	 */
	@Override
	public int mydblClick(PrintingQuote printingQuote) {
		return this.printingQuoteMapper.updateByPrimaryKeySelective(printingQuote);
	}

	/**
	 * 确认报价实现类
	 */
	@Override
	public int confirmPiece(int id) {
		return this.printingQuoteMapper.confirmPiece(id);
	}

	@Override
	public void delDataByWave(String wave) {
		this.printingQuoteMapper.delDataByWave(wave);
	}

}

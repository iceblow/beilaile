package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.PieceProcessCaseMapper;
import com.warehouse.entity.PieceProcessCase;
import com.warehouse.util.PageUtil;

@Service
public class PieceProcessCaseServiceImpl implements PieceProcessCaseService {

	@Resource
	private PieceProcessCaseMapper pieceProcessCaseMapper;

	/**
	 * 分页查询
	 */
	@Override
	public Map<String, Object> getDataByPage(PageUtil pageUtil, PieceProcessCase pieceProcessCase) {
		//写入每页显示数据
		pageUtil.setPageSize(10);
		//写入数据量
		pageUtil.setTotolCount(this.pieceProcessCaseMapper.getCount(pieceProcessCase));
		//得到显示数据
		List<PieceProcessCase> dataList = this.pieceProcessCaseMapper.getDataByPage(
				new PieceProcessCase(pageUtil.getReqult()[0], pageUtil.getReqult()[1], pieceProcessCase));
		
		Map<String, Object> map=new HashMap<>();
		
		map.put("pageUtil", pageUtil);
		map.put("dataList", dataList);
		return map;
	}

	/**
	 * 片印领料时间
	 */
	@Override
	public int pieceOfPrintingOut(PieceProcessCase pieceProcessCase) {
		return this.pieceProcessCaseMapper.pieceOfPrintingOut(pieceProcessCase);
	}

	/**
	 * 片印回料
	 */
	@Override
	public int pieceOfPrintingIn(PieceProcessCase pieceProcessCase) {
		return this.pieceProcessCaseMapper.pieceOfPrintingIn(pieceProcessCase);
	}

}

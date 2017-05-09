package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.ApparelDevelopmentReturnMapper;
import com.warehouse.entity.ApparelDevelopmentReturn;

@Service
public class ApparelDevelopmentReturnServiceImpl implements ApparelDevelopmenReturnService {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置时间格式
	@Resource
	private ApparelDevelopmentReturnMapper apparelDevelopmentReturnMapper;

	@Override
	public int addApparelDevelopmenReturn(ApparelDevelopmentReturn record) {
		record.setDelb(0);
		record.setUrgentState(0);
		record.setAddTime(sdf.format(new Date()));
		int result = apparelDevelopmentReturnMapper.insertSelective(record);
		return result;
	}

	@Override
	public int delApparelDevelopmenReturn(ApparelDevelopmentReturn record) {
		record.setDelTime(sdf.format(new Date()));
		int result = apparelDevelopmentReturnMapper.deleteByPrimaryKey(record);
		return result;
	}

	@Override
	public ApparelDevelopmentReturn selApparelDevelopmenReturnById(Integer id) {
		ApparelDevelopmentReturn developmentReturn = apparelDevelopmentReturnMapper.selectByPrimaryKey(id);
		return developmentReturn;
	}

	@Override
	public int uppApparelDevelopmenReturn(ApparelDevelopmentReturn record) {
		record.setUpdateTime(sdf.format(new Date()));
		int result = apparelDevelopmentReturnMapper.updateByPrimaryKey(record);
		return result;
	}

	/**
	 * 查询
	 * 
	 */
	@Override
	public int selApparelDevelopmentReturnCount(ApparelDevelopmentReturn record) {
		int result = apparelDevelopmentReturnMapper.selApparelDevelopmentReturnCount(record);
		return result;
	}

	@Override
	public List<ApparelDevelopmentReturn> developmentReturns(ApparelDevelopmentReturn record) {
		List<ApparelDevelopmentReturn> developmentReturns = apparelDevelopmentReturnMapper.developmentReturns(record);
		return developmentReturns;
	}

	/**
	 * 旺店通
	 */
	@Override
	public List<ApparelDevelopmentReturn> queryEtrack(int id) {
		List<ApparelDevelopmentReturn> list = apparelDevelopmentReturnMapper.queryEtrack(id);
		return list;
	}

	/**
	 * 采购查询
	 * 
	 */
	@Override
	public int selApparelDevelopmentReturnCounting(ApparelDevelopmentReturn record) {
		int result = apparelDevelopmentReturnMapper.selApparelDevelopmentReturnCounting(record);
		return result;
	}

	@Override
	public List<ApparelDevelopmentReturn> developmentReturnsing(ApparelDevelopmentReturn record) {
		List<ApparelDevelopmentReturn> developmentReturns = apparelDevelopmentReturnMapper
				.developmentReturnsing(record);
		return developmentReturns;
	}

	/**
	 * 已完成查询
	 * 
	 */
	@Override
	public int selApparelDevelopmentReturnCountover(ApparelDevelopmentReturn record) {
		int result = apparelDevelopmentReturnMapper.selApparelDevelopmentReturnCountover(record);
		return result;
	}

	@Override
	public List<ApparelDevelopmentReturn> developmentReturnsover(ApparelDevelopmentReturn record) {
		List<ApparelDevelopmentReturn> developmentReturns = apparelDevelopmentReturnMapper
				.developmentReturnsover(record);
		return developmentReturns;
	}

	/**
	 * 根据时间生成Excel
	 */
	@Override
	public int toExcelNum(ApparelDevelopmentReturn record) {
		int num = this.apparelDevelopmentReturnMapper.toExcelNum(record);
		return num;
	}

	@Override
	public List<ApparelDevelopmentReturn> toExcel(ApparelDevelopmentReturn record) {
		List<ApparelDevelopmentReturn> developmentReturns = apparelDevelopmentReturnMapper.toExcel(record);
		return developmentReturns;
	}

}

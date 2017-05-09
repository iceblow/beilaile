package com.warehouse.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.FinanceAccountReconciliationMapper;
import com.warehouse.entity.FinanceAccountReconciliation;
import com.warehouse.util.DateUtils;

@Service
public class FinanceAccountReconciliationImpl implements FinanceAccountReconciliationService {

	@Resource
	private FinanceAccountReconciliationMapper financeAccountReconciliationmapper;

	/**
	 * 添加
	 */
	@Override
	public int insertSelective(FinanceAccountReconciliation record) {
		return financeAccountReconciliationmapper.insertSelective(record);
	}

	/**
	 * 导入
	 */
	@Override
	public int insertSelectiveByExcle(String sql) {
		return financeAccountReconciliationmapper.insertSelectiveByExcle(sql);
	}

	/**
	 * 根据ID查询
	 */
	@Override
	public FinanceAccountReconciliation selectByPrimaryKey(Integer id) {
		return financeAccountReconciliationmapper.selectByPrimaryKey(id);
	}

	/**
	 * 修改
	 */
	@Override
	public int updateByPrimaryKeySelective(FinanceAccountReconciliation record) {
		record.setUpdateTime(DateUtils.formateDaTime(new Date()));
		return financeAccountReconciliationmapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 分页查询
	 */
	@Override
	public int getCountByPrimaryKey(FinanceAccountReconciliation record) {
		return financeAccountReconciliationmapper.getCountByPrimaryKey(record);
	}

	@Override
	public List<FinanceAccountReconciliation> selectByPrimaryKeyPage(FinanceAccountReconciliation record) {
		return financeAccountReconciliationmapper.selectByPrimaryKeyPage(record);
	}

}

package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ApprovalApplicationMapper;
import com.warehouse.entity.ApprovalApplication;

@Service
public class ApprovalApplicationServiceImpl implements ApprovalApplicationService {

	@Resource
	private ApprovalApplicationMapper approvalApplicationMapper;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置时间格式

	/**
	 * 删除
	 */
	@Override
	public int deleteByPrimaryKey(ApprovalApplication record) {
		record.setDelb(0);
		record.setDelTime(sdf.format(new Date()));
		int result = approvalApplicationMapper.deleteByPrimaryKey(record);
		return result;
	}

	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ApprovalApplication record) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");// 设置时间格式
		record.setReturnTime(sd.format(new Date()));// 预计返单时间
		record.setDelb(1);
		record.setAddTime(sdf.format(new Date()));
		int result = approvalApplicationMapper.insertSelective(record);
		return result;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public ApprovalApplication selectByPrimaryKey(Integer id) {
		ApprovalApplication application = approvalApplicationMapper.selectByPrimaryKey(id);
		return application;
	}

	/**
	 * 修改
	 */
	@Override
	public int updateByPrimaryKeySelective(ApprovalApplication record) {
		record.setUpdateTime(sdf.format(new Date()));
		int result = approvalApplicationMapper.updateByPrimaryKeySelective(record);
		return result;
	}

	/**
	 * 分页查询
	 */
	@Override
	public int selApprovalApplicationCount(ApprovalApplication record) {
		int count = approvalApplicationMapper.selApprovalApplicationCount(record);
		return count;
	}

	@Override
	public List<ApprovalApplication> ApprovalApplicationReturns(ApprovalApplication record) {
		List<ApprovalApplication> applications = approvalApplicationMapper.ApprovalApplicationReturns(record);
		return applications;
	}

	// 计算订单总值
	@Override
	public int calculations(String girard) {
		Integer flag = this.approvalApplicationMapper.calculations(girard);
		return flag;
	}

	@Override
	public int insertSelectives(String insertData) {
		int flag = this.approvalApplicationMapper.insertSelectives(insertData);
		return flag;
	}

}

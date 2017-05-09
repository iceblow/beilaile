package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ApparelDevelopmentMissSampleimgMapper;
import com.warehouse.entity.ApparelDevelopmentMissSampleimg;

@Service
public class ApparelDevelopmentMissSampleimgImpl implements ApparelDevelopmentMissSampleimgService {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置时间格式
	@Resource
	private ApparelDevelopmentMissSampleimgMapper apparelDevelopmentMissSampleimgMapper;

	/**
	 * 添加
	 */
	@Override
	public int addApparelDevelopmentMissSampleimg(ApparelDevelopmentMissSampleimg record) {
		record.setDelb(0);
		record.setAddTime(sdf.format(new Date()));// 设置添加时间
		int result = apparelDevelopmentMissSampleimgMapper.insertSelective(record);
		return result;
	}

	/**
	 * 修改
	 */
	@Override
	public int updateApparelDevelopmentMissSampleimg(ApparelDevelopmentMissSampleimg record) {
		record.setUpdateTime(sdf.format(new Date()));// 设置修改时间
		int result = apparelDevelopmentMissSampleimgMapper.updateByPrimaryKeySelective(record);
		return result;
	}

	/**
	 * 分页查个数
	 */
	@Override
	public int getCountByLike(ApparelDevelopmentMissSampleimg record) {
		int count = apparelDevelopmentMissSampleimgMapper.getCountByLike(record);
		return count;
	}

	/**
	 * 分页数据
	 */
	@Override
	public List<ApparelDevelopmentMissSampleimg> getApparelDevelopmentMissSampleimgByLike(
			ApparelDevelopmentMissSampleimg page) {
		List<ApparelDevelopmentMissSampleimg> apparelDevelopmentManagements = apparelDevelopmentMissSampleimgMapper
				.getApparelDevelopmentMissSampleimgByLike(page);
		return apparelDevelopmentManagements;
	}

	/**
	 * 删除
	 */
	@Override
	public int delApparelDevelopmentMissSampleimg(ApparelDevelopmentMissSampleimg record) {
		record.setDelTime(sdf.format(new Date()));// 设置删除时间
		int result = apparelDevelopmentMissSampleimgMapper.deleteByPrimaryKey(record);
		return result;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public ApparelDevelopmentMissSampleimg getApparelDevelopmentMissSampleimgById(Integer id) {
		ApparelDevelopmentMissSampleimg record = this.apparelDevelopmentMissSampleimgMapper
				.getApparelDevelopmentMissSampleimgById(id);
		return record;
	}

	/**
	 * 生成工艺单
	 */
	@Override
	public ApparelDevelopmentMissSampleimg queryEtrack(Integer id) {
		ApparelDevelopmentMissSampleimg appares = this.apparelDevelopmentMissSampleimgMapper.queryEtrack(id);
		return appares;
	}

}

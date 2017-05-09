package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ApparelDevelopmentManagementMapper;
import com.warehouse.entity.ApparelDevelopmentManagement;

@Service
public class ApparelDevelopmentManagementServiceImpl implements ApparelDevelopmentManagementService {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置时间格式
	@Resource
	private ApparelDevelopmentManagementMapper apparelDevelopmentManagementMapper;

	/**
	 * 添加
	 */
	@Override
	public int addApparelDevelopmentManagement(ApparelDevelopmentManagement record) {
		record.setDelb(0);
		record.setAddTime(sdf.format(new Date()));// 设置添加时间
		int result = apparelDevelopmentManagementMapper.insertSelective(record);
		return result;
	}

	/**
	 * 修改
	 */
	@Override
	public int updateApparelDevelopmentManagement(ApparelDevelopmentManagement record) {
		record.setUpdateTime(sdf.format(new Date()));// 设置修改时间
		int result = apparelDevelopmentManagementMapper.updateByPrimaryKeySelective(record);
		return result;
	}

	/**
	 * 分页查个数
	 */
	@Override
	public int getCountByLike(ApparelDevelopmentManagement record) {
		int count = apparelDevelopmentManagementMapper.getCountByLike(record);
		return count;
	}

	/**
	 * 分页数据
	 */
	@Override
	public List<ApparelDevelopmentManagement> getApparelDevelopmentManagementByLike(ApparelDevelopmentManagement page) {
		List<ApparelDevelopmentManagement> apparelDevelopmentManagements = apparelDevelopmentManagementMapper
				.getApparelDevelopmentManagementByLike(page);
		return apparelDevelopmentManagements;
	}

	/**
	 * 删除
	 */
	@Override
	public int delApparelDevelopmentManagement(ApparelDevelopmentManagement record) {
		record.setDelTime(sdf.format(new Date()));// 设置删除时间
		int result = apparelDevelopmentManagementMapper.deleteByPrimaryKey(record);
		return result;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public ApparelDevelopmentManagement getApparelDevelopmentManagementById(Integer id) {
		ApparelDevelopmentManagement record = this.apparelDevelopmentManagementMapper
				.getApparelDevelopmentManagementById(id);
		return record;
	}

	/**
	 * 生成Excel表
	 */
	@Override
	public List<ApparelDevelopmentManagement> queryEtrack(Integer id) {
		List<ApparelDevelopmentManagement> apparelDevelopmentManagements = this.apparelDevelopmentManagementMapper
				.queryEtrack(id);
		return apparelDevelopmentManagements;
	}

	@Override
	public List<ApparelDevelopmentManagement> toExcel() {
		List<ApparelDevelopmentManagement> apparelDevelopmentManagements = this.apparelDevelopmentManagementMapper
				.toExcel();
		return apparelDevelopmentManagements;
	}
	/**
	 * 按时间段查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ApparelDevelopmentManagement> toExcelByTime(String startTime,String endTime){
		Map map = new HashMap<String,String>();
		map.put("startTime",startTime);
		map.put("endTime",endTime);
		return this.apparelDevelopmentManagementMapper.toExcelByTime(map);
	}
	@Override
	public int checkGirard(String girard) {
		int count = this.apparelDevelopmentManagementMapper.checkGirard(girard);
		return count;
	}

}

package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ReturnRepairDoucumentsMapper;
import com.warehouse.entity.ReturnRepairDoucuments;

@Service
public class ReturnRepairDoucumentsServiceImpl implements ReturnRepairDoucumentsService {
	
    @Resource
	public ReturnRepairDoucumentsMapper returnrepairdoucumentsMapper;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
	
    /**
	 * 删除
	 */
	@Override
	public int deleteByPrimaryKey(ReturnRepairDoucuments record) {
		record.setDeleteTime(sdf.format(new Date()));
		int result = this.returnrepairdoucumentsMapper.deleteByPrimaryKey(record);
		return result;
	}
	/**
	 * 添加
	 */
	@Override
	public int insert(ReturnRepairDoucuments record) {
		record.setBuildTime(sdf.format(new Date()));
		int result = this.returnrepairdoucumentsMapper.insert(record);
		return result;
	}
	
	
	
	/**
	 * 修改前查询
	 */
	@Override
	public ReturnRepairDoucuments selectByPrimaryKey(Integer sid) {
		ReturnRepairDoucuments repairDoucuments = this.returnrepairdoucumentsMapper.selectByPrimaryKey(sid);
		return repairDoucuments;
	}
	
	/**
	 * 模糊查询
	 */
	@Override
	public int getCountByOutsideLike(ReturnRepairDoucuments record) {	
		int	count = this.returnrepairdoucumentsMapper.getCountByOutsideLike(record);
		return count;
	}

	@Override
	public List<ReturnRepairDoucuments> ReturnRepairDoucumentsbylike(ReturnRepairDoucuments record) {
		List<ReturnRepairDoucuments> returnrepairdoucuments = this.returnrepairdoucumentsMapper.ReturnRepairDoucumentsbylike(record);
		return returnrepairdoucuments;
	}

	/**
	 * 修改
	 */
	@Override
	public int updateByPrimaryKeySelective(ReturnRepairDoucuments record) {
		record.setChangeTime(sdf.format(new Date()));
		int result = this.returnrepairdoucumentsMapper.updateByPrimaryKeySelective(record);
		return result;
	}
	@Override
	public int girardcount(String girard) {
		int rseult=this.returnrepairdoucumentsMapper.girardcount(girard);
		return rseult;
	}
	
}

package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ReturnRepairMapper;
import com.warehouse.entity.ReturnRepair;


@Service
public class ReturnRepairServiceImpl implements ReturnRepairService {
	
    @Resource
	public ReturnRepairMapper returnrepairdoucumentsMapper;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
	
    /**
	 * 删除
	 */
	@Override
	public int deleteByPrimaryKey(ReturnRepair record) {
		record.setDeleteTime(sdf.format(new Date()));
		int result = this.returnrepairdoucumentsMapper.deleteByPrimaryKey(record);
		return result;
	}
	/**
	 * 添加
	 */
	@Override
	public int insert(ReturnRepair record) {
		record.setBuildTime(sdf.format(new Date()));
		int result = this.returnrepairdoucumentsMapper.insert(record);
		return result;
	}
	
	
	
	/**
	 * 修改前查询
	 */
	@Override
	public ReturnRepair selectByPrimaryKey(Integer sid) {
		ReturnRepair repairDoucuments = this.returnrepairdoucumentsMapper.selectByPrimaryKey(sid);
		return repairDoucuments;
	}
	
	/**
	 * 模糊查询
	 */
	@Override
	public int getCountByOutsideLike(ReturnRepair record) {	
		int	count = this.returnrepairdoucumentsMapper.getCountByOutsideLike(record);
		return count;
	}

	@Override
	public List<ReturnRepair> ReturnRepairDoucumentsbylike(ReturnRepair record) {
		List<ReturnRepair> returnrepairdoucuments = this.returnrepairdoucumentsMapper.ReturnRepairDoucumentsbylike(record);
		return returnrepairdoucuments;
	}

	/**
	 * 修改
	 */
	@Override
	public int updateByPrimaryKeySelective(ReturnRepair record) {
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

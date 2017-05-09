package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.OutEmbroiderMapper;
import com.warehouse.entity.OutEmbroider;

@Service
public class OutEmbroiderServiceImpl implements OutEmbroiderService {

	@Resource
	public OutEmbroiderMapper emberoidermapper;

	/**
	 * 添加
	 */
	@Override
	public void insertOutEmbroider(OutEmbroider embroider) {
		embroider.setDelb(0);
		embroider.setStatus("0");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
		embroider.setAddTime(sdf.format(new Date()));
		this.emberoidermapper.insertSelective(embroider);
	}

	/**
	 * 假删除
	 */
	@Override
	public void deleteOutEmbroider(OutEmbroider embroider) {
		// 获取删除的时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
		embroider.setDelTime(df.format(new Date()));
		this.emberoidermapper.delOutEmbroider(embroider);
	}

	/**
	 * 修改
	 */
	@Override
	public void updateOutEmbroider(OutEmbroider embroider) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
		embroider.setUpdateTime(sdf.format(new Date()));
		this.emberoidermapper.updateByPrimaryKeySelective(embroider);
	}

	/**
	 * 模糊查询
	 */
	@Override
	public int getCountByOutLike(String girard) {
		int count = this.emberoidermapper.getCountByOutLike(girard);
		return count;
	}

	@Override
	public List<OutEmbroider> outEmbroiderByLike(OutEmbroider outEmbroider) {
		List<OutEmbroider> embroiderList = this.emberoidermapper.outEmbroiderByLike(outEmbroider);
		return embroiderList;
	}

	@Override
	public OutEmbroider selectByPrimaryKey(Integer id) {
		OutEmbroider outEmbroider = this.emberoidermapper.selectByPrimaryKey(id);
		return outEmbroider;
	}

}

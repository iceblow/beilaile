package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.GetEmbroiderMapper;
import com.warehouse.entity.GetEmbroider;

@Service
public class GetEmbroiderServiceImpl implements GetEmbroiderService {

	@Resource
	private GetEmbroiderMapper emberoidermapper;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

	/**
	 * 添加
	 */
	@Override
	public int insertEmbroider(GetEmbroider embroider) {
		embroider.setDelb(0);
		embroider.setStatus("0");
		embroider.setAddTime(sdf.format(new Date()));
		int falg = this.emberoidermapper.addEmbroider(embroider);
		return falg;

	}

	/**
	 * 假删除
	 */
	@Override
	public int deleteEmbroider(GetEmbroider embroider) {
		embroider.setDelTime(sdf.format(new Date()));
		int result = this.emberoidermapper.delEmbroider(embroider);
		return result;
	}

	/**
	 * 修改
	 */
	@Override
	public int updateEmbroider(GetEmbroider embroider) {
		embroider.setUpdateTime(sdf.format(new Date()));
		int result = this.emberoidermapper.uppEmbroider(embroider);
		return result;
	}

	/**
	 * 模糊查询
	 */
	@Override
	public int getCountByLike(GetEmbroider embroider) {
		int count = this.emberoidermapper.getCountByLike(embroider);
		return count;
	}

	@Override
	public List<GetEmbroider> getEmbroiderByLike(GetEmbroider embroider) {
		List<GetEmbroider> embroiderList = this.emberoidermapper.getEmbroiderByLike(embroider);
		return embroiderList;
	}

	@Override
	public List<GetEmbroider> selEmbroider(Integer orderId) {
		List<GetEmbroider> embroiders = this.emberoidermapper.selEmbroider(orderId);
		return embroiders;
	}

}

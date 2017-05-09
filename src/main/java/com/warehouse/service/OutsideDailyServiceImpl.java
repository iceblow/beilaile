package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.OutsideDailyMapper;
import com.warehouse.entity.OutsideDaily;

@Service
public class OutsideDailyServiceImpl implements OutsideDailyService {

	@Resource
	public OutsideDailyMapper dailymapper;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

	/**
	 * 添加
	 */
	@Override
	public void insertOutsideDaily(OutsideDaily daily) {
		// 默认删除标识(0---存在)
		daily.setDelb(0);
		daily.setAddTime(df.format(new Date()));
		this.dailymapper.insertSelective(daily);

	}

	/**
	 * 假删除
	 */
	@Override
	public void deleteOutsideDaily(OutsideDaily daily) {
		// 获取删除的时间
		// 获取当前系统时间
		daily.setDelTime(df.format(new Date()));
		daily.setOdid(daily.getOdid());

		this.dailymapper.delOutsideDaily(daily);
	}

	/**
	 * 修改
	 */
	@Override
	public void updateOutsideDaily(OutsideDaily daily) {
		daily.setUpdateTime(df.format(new Date()));
		this.dailymapper.updateByPrimaryKeySelective(daily);
	}

	/**
	 * 模糊查询
	 */
	@Override
	public int getCountByOutsideLike(OutsideDaily outsideDaily) {
		int count = this.dailymapper.getCountByOutsideLike(outsideDaily);
		return count;
	}

	@Override
	public List<OutsideDaily> OutsideDailyByLike(OutsideDaily outsideDaily) {
		List<OutsideDaily> embroiderList = this.dailymapper.OutsideDailyByLike(outsideDaily);
		return embroiderList;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public OutsideDaily selectByPrimaryKey(OutsideDaily outsideDaily) {
		OutsideDaily Daily = this.dailymapper.selectByPrimaryKey(outsideDaily);
		return Daily;
	}

	/**
	 * 根据订单号查询
	 */
	@Override
	public List<OutsideDaily> selDaily(Integer orderId) {
		List<OutsideDaily> dailies = this.dailymapper.selDaily(orderId);
		return dailies;
	}

}

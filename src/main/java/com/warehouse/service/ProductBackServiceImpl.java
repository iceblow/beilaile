package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.ProductBackMapper;
import com.warehouse.entity.ProductBack;

@Service
public class ProductBackServiceImpl implements ProductBackService {

	@Resource
	private ProductBackMapper productBackmapper;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置时间格式

	/**
	 * 删除
	 */
	@Override
	public int delProduct(ProductBack record) {
		record.setDelb(1);
		record.setDelTime(sdf.format(new Date()));
		int result = productBackmapper.deleteByPrimaryKey(record);
		return result;
	}

	/**
	 * 添加
	 */
	@Override
	public int addProduct(ProductBack record) {
		record.setDelb(0);
		record.setAddTime(sdf.format(new Date()));
		int result = productBackmapper.insertSelective(record);
		return result;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public ProductBack getOne(Integer id) {
		ProductBack productBack = productBackmapper.getOne(id);
		return productBack;
	}

	/**
	 * 修改
	 */
	@Override
	public int uppProduct(ProductBack record) {
		record.setUpdateTime(sdf.format(new Date()));
		int result = productBackmapper.updateByPrimaryKeySelective(record);
		return result;
	}

	/**
	 * 分页查询
	 */
	@Override
	public int getCountByPage(ProductBack record) {
		int count = productBackmapper.getCountByPage(record);
		return count;
	}

	@Override
	public List<ProductBack> getDataByPage(ProductBack record) {
		List<ProductBack> productBacks = productBackmapper.getDataByPage(record);
		return productBacks;
	}

	@Override
	public Integer analysis() {
		Integer flag = this.productBackmapper.analysis();
		return flag;
	}

}

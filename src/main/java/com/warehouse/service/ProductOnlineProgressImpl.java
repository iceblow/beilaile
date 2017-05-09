package com.warehouse.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.ProductOnlineProgressMapper;
import com.warehouse.entity.ProductOnlineProgress;

@Service
public class ProductOnlineProgressImpl implements ProductOnlineProgressService {

	@Resource
	private ProductOnlineProgressMapper ProductOnlineProgressmapper;

	@Override
	public int insertSelective(ProductOnlineProgress record) {
		int flag = this.ProductOnlineProgressmapper.insertSelective(record);
		return flag;
	}

	@Override
	public int updateByPrimaryKeySelective(ProductOnlineProgress record) {
		int flag = this.ProductOnlineProgressmapper.updateByPrimaryKeySelective(record);
		return flag;
	}

	@Override
	public int selectCountByPrimaryKey(ProductOnlineProgress record) {
		int count = this.ProductOnlineProgressmapper.selectCountByPrimaryKey(record);
		return count;
	}

	@Override
	public List<ProductOnlineProgress> selectByPrimaryKey(ProductOnlineProgress record) {
		List<ProductOnlineProgress> ProductList = this.ProductOnlineProgressmapper.selectByPrimaryKey(record);
		return ProductList;
	}

}

package com.warehouse.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.ClothesTotalPriceMapper;
import com.warehouse.entity.ClothesTotalPrice;

@Service
public class ClothesTotalPriceServiceImpl implements ClothesTotalPriceService {

	@Resource
	private ClothesTotalPriceMapper clothesTotalPriceMapper;

	// 查询总条数
	@Override
	public Integer selectClothes1(ClothesTotalPrice clothesTotalPrice) {
		return clothesTotalPriceMapper.selectClothes1(clothesTotalPrice);
	}

	// 分页查询返回结果
	@Override
	public List<ClothesTotalPrice> getClothesPage(ClothesTotalPrice clothesTotalPrice) {

		return clothesTotalPriceMapper.getClothesPage(clothesTotalPrice);
	}

}

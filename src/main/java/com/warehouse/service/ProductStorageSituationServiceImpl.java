package com.warehouse.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.ProductStorageSituationMapper;
import com.warehouse.entity.ProductStorageSituation;

@Service
public class ProductStorageSituationServiceImpl implements ProductStorageSituationService{
	
	@Resource
	private ProductStorageSituationMapper productStorageSituationMapper;
	@Override
	public int selectAllcount(ProductStorageSituation productStorageSituation) {
		
		return productStorageSituationMapper.selectAllcount(productStorageSituation);
	}

	@Override
	public List<ProductStorageSituation> getProductStorageSituationPage(ProductStorageSituation productStorageSituation) {
		
		return productStorageSituationMapper.getProductStorageSituationPage(productStorageSituation);
	}

	@Override
	public int deleteProductStorageSituationById(ProductStorageSituation productStorageSituation) {
		
		return productStorageSituationMapper.deleteProductStorageSituationById(productStorageSituation);
	}

	@Override
	public int updateProductStorageSituationById(ProductStorageSituation productStorageSituation) {
		
		return productStorageSituationMapper.updateProductStorageSituationById(productStorageSituation);
	}

	@Override
	public int updateDataStateById(ProductStorageSituation productStorageSituation) {
		return productStorageSituationMapper.updateDataStateById(productStorageSituation);
	}

	@Override
	public ProductStorageSituation findDataStateById(Integer id) {
		
		return productStorageSituationMapper.findDataStateById(id);
	}

}

package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.ProductSampleSituationMapper;
import com.warehouse.entity.ProductSampleSituation;

@Service
public class ProductSampleSituationServiceImpl implements ProductSampleSituationService {
	@Resource
	private ProductSampleSituationMapper productSampleSituationMapper;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
	//模糊查询
	@Override
	public int getProductSampleSituationCount(ProductSampleSituation productSampleSituation) {		
		return this.productSampleSituationMapper.getProductSampleSituationCount(productSampleSituation) ;
	}

	@Override
	public List<ProductSampleSituation> selectProductSampleSituationByLike(
			ProductSampleSituation productSampleSituation) {
		return this.productSampleSituationMapper.selectProductSampleSituationByLike(productSampleSituation);
	}
	//假删除
	@Override
	public int deleteProductSampleSituation(ProductSampleSituation productSampleSituation) {
		productSampleSituation.setDataStatus("1");
		productSampleSituation.setDeleteTime(sdf.format(new Date()));
		return this.productSampleSituationMapper.deleteProductSampleSituation(productSampleSituation);
	}
	// 修改前查询
	@Override
	public ProductSampleSituation selectOnedata(ProductSampleSituation productSampleSituation) {
		return this.productSampleSituationMapper.selectOnedata(productSampleSituation);
	}
	//修改
	@Override
	public int updateProductSampleSituation(ProductSampleSituation productSampleSituation) {
		productSampleSituation.setModifyTime(sdf.format(new Date()));
		return this.productSampleSituationMapper.updateProductSampleSituation(productSampleSituation);
	}
	//接收数据
	@Override
	public int insertProductSampleSituation(ProductSampleSituation productSampleSituation) {
		productSampleSituation.setCreateTime(sdf.format(new Date()));
		return this.productSampleSituationMapper.insertProductSampleSituation(productSampleSituation);
	}

}

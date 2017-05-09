package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.ProductSampleSituation;

public interface ProductSampleSituationService {
	 //模糊查询
    int getProductSampleSituationCount(ProductSampleSituation productSampleSituation);
    
    List<ProductSampleSituation> selectProductSampleSituationByLike(ProductSampleSituation productSampleSituation);
    
    //假删除
    int deleteProductSampleSituation(ProductSampleSituation productSampleSituation);

    //修改前查询
    ProductSampleSituation selectOnedata(ProductSampleSituation productSampleSituation);
    
    //修改
    int updateProductSampleSituation(ProductSampleSituation productSampleSituation);
    
    //接收数据
    int insertProductSampleSituation(ProductSampleSituation productSampleSituation);

}

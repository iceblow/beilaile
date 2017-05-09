package com.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ProductOnlineProgress;
import com.warehouse.entity.ProductPhotographySituation;
import com.warehouse.entity.ProductSampleSituation;
import com.warehouse.service.ProductOnlineProgressService;
import com.warehouse.service.ProductPhotographySituationService;
import com.warehouse.service.ProductSampleSituationService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("productSampleSituation")
public class ProductSampleSituationController {
	@Resource
	private ProductSampleSituationService productSampleSituationService;
	@Resource
	private ProductPhotographySituationService productPhotographySituationService;
	
	//分页查询数据
	@RequestMapping("selectProductSampleSituationByLike")
    @ResponseBody()
	public Map<String, Object> selectProductSampleSituationByLike(ProductSampleSituation productSampleSituation, PageUtil page) {
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.productSampleSituationService.getProductSampleSituationCount(productSampleSituation));// 总共有多少条数据
		// map对象中存的数据
		List<ProductSampleSituation> product = this.productSampleSituationService
				.selectProductSampleSituationByLike((new ProductSampleSituation(page.getReqult()[0], page.getReqult()[1],
						productSampleSituation.getSid(), productSampleSituation.getWave(), productSampleSituation.getProductCode(), productSampleSituation.getProductName())));
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList", product);
		return map;
	}
	
	//假删除
	@RequestMapping("deleteProductSampleSituation")
    @ResponseBody()
	public int deleteProductSampleSituation(ProductSampleSituation productSampleSituation) {
		return this.productSampleSituationService.deleteProductSampleSituation(productSampleSituation);
	}
	
	//修改前查询
	@RequestMapping("selectOnedata")
    @ResponseBody()
	public ProductSampleSituation selectOnedata(ProductSampleSituation productSampleSituation) {
		return this.productSampleSituationService.selectOnedata(productSampleSituation);
	}
	
	//修改
	@RequestMapping("updateProductSampleSituation")
    @ResponseBody()
	public int updateProductSampleSituation(ProductSampleSituation productSampleSituation) {
		int result = this.productSampleSituationService.updateProductSampleSituation(productSampleSituation);
		ProductSampleSituation prod = this.productSampleSituationService.selectOnedata(productSampleSituation);
		ProductPhotographySituation productPhotographySituation = new ProductPhotographySituation();
	if (result==1&&productSampleSituation.getSampleTime()!=null) {
		//传值给拍照
		productPhotographySituation.setWave(prod.getWave());
		productPhotographySituation.setProductCode(prod.getProductCode());
		productPhotographySituation.setDesignImg(prod.getDesignImg());
		productPhotographySituation.setOrderGrade(prod.getOrderGrade());
		productPhotographySituation.setProductName(prod.getProductName());
		productPhotographySituation.setSid(prod.getSid());
		productPhotographySituationService.addproductPhotographySituationInfo(productPhotographySituation);
		}	
		return result;
	}
	
	//接收数据
	@RequestMapping("insertProductSampleSituation")
    @ResponseBody()
	public int insertProductSampleSituation(ProductSampleSituation productSampleSituation) {
		int result = this.productSampleSituationService.insertProductSampleSituation(productSampleSituation);		
		return result;
		
	}
	
}

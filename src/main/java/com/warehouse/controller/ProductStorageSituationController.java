package com.warehouse.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ProductInfo;
import com.warehouse.entity.ProductOnlineProgress;
import com.warehouse.entity.ProductSampleSituation;
import com.warehouse.entity.ProductStorageSituation;
import com.warehouse.service.ProductOnlineProgressService;
import com.warehouse.service.ProductSampleSituationService;
import com.warehouse.service.ProductStorageSituationService;
import com.warehouse.util.PageUtil;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("productStorageSituation")

public class ProductStorageSituationController {
	@Resource
	private ProductStorageSituationService productStorageSituationService;
	
	@Resource
	private ProductSampleSituationService productSampleSituationService;

	@Resource
	private ProductOnlineProgressService productOnlineProgressService;
	
	// 分页查询
	@RequestMapping("getProductStorageSituationPage.do")
	@ResponseBody
	public Map<String, Object> selectPageFabric(PageUtil page, ProductStorageSituation productStorageSituation)
			throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(10);// 每页显示数据量
		page.setTotolCount(productStorageSituationService.selectAllcount(productStorageSituation));// 总数据条数
		List<ProductStorageSituation> myList = this.productStorageSituationService.getProductStorageSituationPage(
				new ProductStorageSituation(page.getReqult()[0], page.getReqult()[1], productStorageSituation));// 得到分页查询的数据
		map.put("pageUtil", page);// 前台接收的分页信息
		map.put("dataList", myList);// 显示数据详细信息
		return map;
	}

	/**
	 * 数据假删除
	 * */ 
	@RequestMapping("deleteProductStorageSituationById.do")
	@ResponseBody
	public int deleteProductStorageSituationById(ProductStorageSituation productStorageSituation) {

		return productStorageSituationService.deleteProductStorageSituationById(productStorageSituation);
	}

	/**
	 * 修改备注和订单等级
	 * */ 
	@RequestMapping("updateProductStorageSituationById.do")
	@ResponseBody
	public int updateProductStorageSituationById(ProductStorageSituation productStorageSituation) {

		return productStorageSituationService.updateProductStorageSituationById(productStorageSituation);
	}
	
	/**
	 * 页面确认入仓,传值给productSampleSituationService接口
	 * */
	@RequestMapping("updateDataStateById.do")
	@ResponseBody
	public int updateDataStateById(ProductStorageSituation productStorageSituation) {
		int result = productStorageSituationService.updateDataStateById(productStorageSituation);
		if (result == 1) {
			//页面确认入仓,传值给productSampleSituationService接口
			ProductStorageSituation abcd=productStorageSituationService.findDataStateById(productStorageSituation.getId());
			ProductSampleSituation productSampleSituation = new ProductSampleSituation();
			productSampleSituation.setProductCode(abcd.getProductCode());
			productSampleSituation.setWave(abcd.getWave());
			productSampleSituation.setDesignImg(abcd.getDesignImg());
			productSampleSituation.setOrderGrade(abcd.getOrderGrade());
			productSampleSituation.setProductName(abcd.getProductName());
			productSampleSituation.setSid(abcd.getSid());
			int result1 =productSampleSituationService.insertProductSampleSituation(productSampleSituation);
			
			//页面确认入仓传值productOnlineProgressService
			ProductOnlineProgress productOnlineProgress=new ProductOnlineProgress();
			productOnlineProgress.setProductCode(abcd.getProductCode());
			productOnlineProgress.setWave(abcd.getWave());
			productOnlineProgress.setProductName(abcd.getProductName());
			productOnlineProgress.setDesignImg(abcd.getDesignImg());
			productOnlineProgress.setOrderGrade(abcd.getOrderGrade());
			productOnlineProgress.setStorageStatus(abcd.getDataStatus());
			productOnlineProgress.setStorageTime(abcd.getStorageTime());
			productOnlineProgress.setSid(abcd.getSid());
			productOnlineProgressService.insertSelective(productOnlineProgress);
			return result1;
		}else{
			return 0;
		}								
		
	}

}

package com.warehouse.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ProductArtworkSituation;
import com.warehouse.entity.ProductOnlineProgress;
import com.warehouse.entity.ProductPhotographySituation;
import com.warehouse.service.ProductArtworkSituationService;
import com.warehouse.service.ProductOnlineProgressService;
import com.warehouse.service.ProductPhotographySituationService;
import com.warehouse.util.DateUtils;
import com.warehouse.util.Page;

@Controller
public class ProductPhotographySituationController {
	@Resource
	ProductPhotographySituationService productPhotographySituationService;
	@Resource
	ProductArtworkSituationService productArtworkSituationService;
	@Resource
	ProductOnlineProgressService productOnlineProgressService;
	
	private Logger logger = LoggerFactory.getLogger(ProductPhotographySituationController.class);
	/**
	 * 带条件查询总条数 ByPageCount Bpcnt 查询摄影情况总数
	 */
	@RequestMapping(value = "getPhotographyInfoBpcnt.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<ProductPhotographySituation> getPhotographyInfoBpcnt(@RequestParam Map<String, Object> param) {
		
		int result = productPhotographySituationService.getPhotographyInfoBpcnt(param);
		Object value=param.get("pageNow");
		String pageNow=value.toString();
		if(pageNow==""){
		
		Page<ProductPhotographySituation> page = new Page<>(result,1);
		logger.info("带条件查询总条数 ByPageCount Bpcnt 查询摄影情况总数");
		return page;
		}
		
		Page<ProductPhotographySituation> page = new Page<>(result,Integer.parseInt(pageNow));
		logger.info("带条件查询总条数 ByPageCount Bpcnt 查询摄影情况总数");
		return page;
		
		
		
	}

	/**
	 * 带条件分页查询
	 */
	@RequestMapping(value = "findPhotographyInfoCndbp.do", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductPhotographySituation> findPhotographyInfoCndbp(@RequestParam Map<String, Object> param) {
		
		   
		
		List<ProductPhotographySituation> list = productPhotographySituationService.findPhotographyInfoCndbp(param);
		logger.info("带条件分页查询摄影情况记录");
		return list;
	}

	/**
	 * 修改拍摄状态
	 */
	@RequestMapping(value = "confirmShipmentPhotography.do", method = RequestMethod.POST)
	@ResponseBody
	public int confirmShipmentPhotography(Integer id) {
		
		int result = productPhotographySituationService.confirmShipmentPhotography(id);
		if(result==1){
		
			ProductPhotographySituation productPhotographySituation = productPhotographySituationService.queryById(id);
			ProductArtworkSituation  productArtworkSituation= new ProductArtworkSituation();
			if(productPhotographySituation.getSid()!=null){
			productArtworkSituation.setSid(productPhotographySituation.getSid());}
			if(productPhotographySituation.getWave()!=null){
			productArtworkSituation.setWave(productPhotographySituation.getWave());}
			if(productPhotographySituation.getProductCode()!=null){
			productArtworkSituation.setProductCode(productPhotographySituation.getProductCode());}
			if(productPhotographySituation.getProductName()!=null){
			productArtworkSituation.setProductName(productPhotographySituation.getProductName());}
			if(productPhotographySituation.getDesignImg()!=null){
			productArtworkSituation.setDesignImg(productPhotographySituation.getDesignImg());}
			if(productPhotographySituation.getOrderGrade()!=null){
			productArtworkSituation.setOrderGrade(productPhotographySituation.getOrderGrade());}
			productArtworkSituation.setCreateTime(DateUtils.formateDaTime(new Date()));
			productArtworkSituationService.addproductArtworkSituationInfo(productArtworkSituation);
			
			ProductOnlineProgress productOnlineProgress=new ProductOnlineProgress();
			productOnlineProgress.setPhotographyTime(DateUtils.formateDaTime(new Date()));
			productOnlineProgress.setPhotographyStatus("已拍摄");
			productOnlineProgress.setWave(productPhotographySituation.getWave());
			productOnlineProgressService.updateByPrimaryKeySelective(productOnlineProgress);
		}
		logger.info("修改拍摄状态并且传递记录给美工页面");
		return result;
	}
	/**
	 * 双击修改
	 */
	@RequestMapping(value = "modifyPhotographyInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyPhotographyInfo(@RequestParam Map<String, Object> param) {
	
		int result = productPhotographySituationService.modifyPhotographyInfo(param);
		logger.info("拍摄状态双击修改");
		return result;
	}
}


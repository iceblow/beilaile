package com.warehouse.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.ProductArtworkSituation;
import com.warehouse.entity.ProductOnlineProgress;
import com.warehouse.entity.ProductOperationSituation;
import com.warehouse.entity.ProductPhotographySituation;
import com.warehouse.service.ProductArtworkSituationService;
import com.warehouse.service.ProductOnlineProgressService;
import com.warehouse.service.ProductOperationSituationService;
import com.warehouse.util.DateUtils;
import com.warehouse.util.Page;

@Controller
public class ProductArtworkSituationController {
	@Resource
	ProductArtworkSituationService productArtworkSituationService;
	@Resource
	ProductOnlineProgressService productOnlineProgressService;
	@Resource
	ProductOperationSituationService productOperationSituationService;
	private Logger logger = LoggerFactory.getLogger(ProductArtworkSituationController.class);
	/**
	 * 带条件查询总条数 ByPageCount Bpcnt 查询美工情况总数
	 */
	@RequestMapping(value = "getArtworkInfoBpcnt.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<ProductArtworkSituation> getArtworkInfoBpcnt(@RequestParam Map<String, Object> param) {
		
		int result = productArtworkSituationService.getArtworkInfoBpcnt(param);
		Object value=param.get("pageNow");
		String pageNow=value.toString();
		if(pageNow==""){
		
		Page<ProductArtworkSituation> page = new Page<>(result,1);
		logger.info(" 带条件查询总条数 ByPageCount Bpcnt 查询美工情况总数");
		return page;
		}
		
		Page<ProductArtworkSituation> page = new Page<>(result,Integer.parseInt(pageNow));
		logger.info(" 带条件查询总条数 ByPageCount Bpcnt 查询美工情况总数");
		return page;
		
		
		
	}

	/**
	 * 带条件分页查询
	 */
	@RequestMapping(value = "findArtworkInfoCndbp.do", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductArtworkSituation> findArtworkInfoCndbp(@RequestParam Map<String, Object> param) {
		
		   
		
		List<ProductArtworkSituation> list = productArtworkSituationService.findArtworkInfoCndbp(param);
		logger.info(" 带条件分页查询美工记录");
		return list;
	}

	/**
	 * 修改修图状态
	 */
	@RequestMapping(value = "confirmShipmentArtwork.do", method = RequestMethod.POST)
	@ResponseBody
	public int confirmShipmentArtwork(Integer id) {
	
		int result = productArtworkSituationService.confirmShipmentArtwork(id);
	
		
		
		if(result==1){
			
			ProductArtworkSituation productArtworkSituation = productArtworkSituationService.queryById(id);
			ProductOperationSituation  productOperationSituation= new ProductOperationSituation();
			if(productArtworkSituation.getSid()!=null){
				productOperationSituation.setSid(productArtworkSituation.getSid());}
			if(productArtworkSituation.getWave()!=null){
				productOperationSituation.setWave(productArtworkSituation.getWave());}
			if(productArtworkSituation.getProductCode()!=null){
				productOperationSituation.setProductCode(productArtworkSituation.getProductCode());}
			if(productArtworkSituation.getProductName()!=null){
				productOperationSituation.setProductName(productArtworkSituation.getProductName());}
			if(productArtworkSituation.getDesignImg()!=null){
				productOperationSituation.setDesignImg(productArtworkSituation.getDesignImg());}
			if(productArtworkSituation.getOrderGrade()!=null){
				productOperationSituation.setOrderGrade(productArtworkSituation.getOrderGrade());}
			productOperationSituation.setCreateTime(DateUtils.formateDaTime(new Date()));
			productOperationSituationService.addProductOperationSituationInfo(productOperationSituation);
			
			ProductOnlineProgress productOnlineProgress=new ProductOnlineProgress();
			productOnlineProgress.setArtworkTime(DateUtils.formateDaTime(new Date()));
			productOnlineProgress.setArtworkStatus("已修图");
			productOnlineProgress.setWave(productArtworkSituation.getWave());
			productOnlineProgressService.updateByPrimaryKeySelective(productOnlineProgress);
		}
		logger.info("修改修图状态并且传递给上架页面");
		return result;
	}
	/**
	 * 双击修改
	 */
	@RequestMapping(value = "modifyArtworkInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyArtworkInfo(@RequestParam Map<String, Object> param) {
	
		int result = productArtworkSituationService.modifyArtworkInfo(param);
		
		logger.info("双击修改修图信息");
		return result;
	}

	
    /**
     * 生成新名字
     * @param Filename 文件名
     * @return 新的图片名称
     */
    private String fileReName(String Filename) {
        Random rd = new Random();// 随机数生成
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String suffix = Filename.substring(Filename.lastIndexOf("."));// 获取后缀名
        return sdf.format(new Date()) + rd.nextInt(10000) + suffix;// 新图片名
    }

}

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

import com.warehouse.entity.ProductOnlineProgress;
import com.warehouse.entity.ProductOperationSituation;
import com.warehouse.service.ProductOnlineProgressService;
import com.warehouse.service.ProductOperationSituationService;
import com.warehouse.util.DateUtils;
import com.warehouse.util.Page;
@Controller
public class ProductOperationSituationController {
	
	@Resource
	ProductOperationSituationService productOperationSituationService;
	@Resource
	ProductOnlineProgressService productOnlineProgressService;
	private Logger logger = LoggerFactory.getLogger(ProductOperationSituationController.class);
	/**
	 * 带条件查询总条数 ByPageCount Bpcnt 查询运营情况总数
	 */
	@RequestMapping(value = "getOperationInfoBpcnt.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<ProductOperationSituation> getOperationInfoBpcnt(@RequestParam Map<String, Object> param) {
		
		int result = productOperationSituationService.getOperationInfoBpcnt(param);
		Object value=param.get("pageNow");
		String pageNow=value.toString();
		if(pageNow==""){
		
		Page<ProductOperationSituation> page = new Page<>(result,1);
		logger.debug(" 带条件查询总条数 ByPageCount Bpcnt 查询运营情况总数");
		return page;
		}
		
		Page<ProductOperationSituation> page = new Page<>(result,Integer.parseInt(pageNow));
		logger.info(" 带条件查询总条数 ByPageCount Bpcnt 查询运营情况总数");
		return page;
		
		
		
	}

	/**
	 * 带条件分页查询
	 */
	@RequestMapping(value = "findOperationInfoCndbp.do", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductOperationSituation> findOperationInfoCndbp(@RequestParam Map<String, Object> param) {
		
		   
		
		List<ProductOperationSituation> list = productOperationSituationService.findOperationInfoCndbp(param);
		logger.info(" 带条件分页查询运营记录");
		return list;
	}

	/**
	 * 修改运营状态
	 */
	@RequestMapping(value = "confirmShipmentOperation.do", method = RequestMethod.POST)
	@ResponseBody
	public int confirmShipmentOperation(Integer id) {
	
		int result = productOperationSituationService.confirmShipmentOperation(id);
		ProductOperationSituation productOperationSituation = productOperationSituationService.queryById(id);
		if(result==1){
		ProductOnlineProgress productOnlineProgress=new ProductOnlineProgress();
		productOnlineProgress.setOperationTime(DateUtils.formateDaTime(new Date()));
		productOnlineProgress.setOperationStatus("已上架");
		productOnlineProgress.setWave(productOperationSituation.getWave());
		productOnlineProgressService.updateByPrimaryKeySelective(productOnlineProgress);
		}
		logger.info(" 修改运营状态并且传递给上新进度页面");
		return result;
	}
	/**
	 * 双击修改
	 */
	@RequestMapping(value = "modifyOperationInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyOperationInfo(@RequestParam Map<String, Object> param) {
	
		int result = productOperationSituationService.modifyOperationInfo(param);
		
		logger.info(" 双击修改上架信息");
		return result;
	}

	
    private String fileReName(String Filename) {
        Random rd = new Random();// 随机数生成
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String suffix = Filename.substring(Filename.lastIndexOf("."));// 获取后缀名
        return sdf.format(new Date()) + rd.nextInt(10000) + suffix;// 新图片名
    }


}

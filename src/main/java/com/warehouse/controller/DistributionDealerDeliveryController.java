package com.warehouse.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

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

import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;

import com.warehouse.entity.DistributionDealerDelivery;

import com.warehouse.service.DistributionDealerDeliveryService;
import com.warehouse.util.Page;

@Controller

public class DistributionDealerDeliveryController {

	private Logger logger = LoggerFactory.getLogger(AccesInfoController.class);
	@Resource
	private DistributionDealerDeliveryService distributionDealerDeliveryService;



	/**
	 * 带条件查询总条数 ByPageCount Bpcnt 查询经销单信息总数
	 */
	@RequestMapping(value = "getDistributionInfoBpcnt.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<DistributionDealerDelivery> getDistributionInfoBpcnt(@RequestParam Map<String, Object> param) {
		
		int result = distributionDealerDeliveryService.getDistributionInfoBpcnt(param);
		Object value=param.get("pageNow");
		String pageNow=value.toString();
		if(pageNow==""){
		Page<DistributionDealerDelivery> page = new Page<>(result,1);

		logger.debug("根据分页条件查询  库存辅料总数");
		return page;
		}
		
		
		Page<DistributionDealerDelivery> page = new Page<>(result,Integer.parseInt(pageNow));
		
		logger.debug("根据分页条件查询  库存辅料总数");
		return page;
	}

	/**
	 * 带条件分页查询 ConditiontByPage Cndbp 查询辅料信息列表
	 */
	@RequestMapping(value = "findDistributionInfoCndbp.do", method = RequestMethod.POST)
	@ResponseBody
	public List<DistributionDealerDelivery> findDistributionInfoCndbp(@RequestParam Map<String, Object> param) {
		
		
		
		List<DistributionDealerDelivery> list = distributionDealerDeliveryService.findDistributionInfoCndbp(param);
		for (DistributionDealerDelivery d : list) {
			if(d.getReportYards59()==0){
				d.setReportYards59(null);
			}
			if(d.getReportYards66()==0){
				d.setReportYards66(null);
			}
			if(d.getReportYards73()==0){
				d.setReportYards73(null);
			}
			if(d.getReportYards80()==0){
				d.setReportYards80(null);
			}
			if(d.getReportYards90()==0){
				d.setReportYards90(null);
			}
			if(d.getReportYards110()==0){
				d.setReportYards110(null);
			}
			if(d.getReportYards120()==0){
				d.setReportYards120(null);
			}
			if(d.getReportYards130()==0){
				d.setReportYards130(null);
			}
			if(d.getReportYards160()==0){
				d.setReportYards160(null);
			}
			if(d.getReportYards170()==0){
				d.setReportYards170(null);
			}
			if(d.getRealYards59()==0){
				d.setRealYards59(null);
			}
			if(d.getRealYards66()==0){
				d.setRealYards66(null);
			}
			if(d.getRealYards73()==0){
				d.setRealYards73(null);
			}
			if(d.getRealYards80()==0){
				d.setRealYards80(null);
			}
			if(d.getRealYards90()==0){
				d.setRealYards90(null);
			}
			if(d.getRealYards110()==0){
				d.setRealYards110(null);
			}
			if(d.getRealYards120()==0){
				d.setRealYards120(null);
			}
			if(d.getRealYards130()==0){
				d.setRealYards130(null);
			}if(d.getRealYards160()==0){
				d.setRealYards160(null);
			}
			if(d.getRealYards170()==0){
				d.setRealYards170(null);
			}
			if(d.getActualTotalDeal()==0){
				d.setActualTotalDeal(null);
			}
			if(d.getReportsTotalDeal()==0){
				d.setReportsTotalDeal(null);
			}
			
		}
	
		logger.debug("根据分页条件查询 辅料理单");
		return list;
	}

	/**
	 * 根据 aInfoid 获取 辅料信息
	 * 
	 * @param request
	 *            获取Ip
	 * @return 辅料信息
	 */
	@RequestMapping(value = "getDistributionInfoBid.do", method = RequestMethod.POST)
	@ResponseBody
	public DistributionDealerDelivery getDistributionInfoBid(Integer id) {
	
		DistributionDealerDelivery result = distributionDealerDeliveryService.getDistributionInfoBid(id);
		
		return result;
	}
	
	@RequestMapping(value = "confirmShipment.do", method = RequestMethod.POST)
	@ResponseBody
	public int confirmShipment(Integer id) {
		System.out.println(id);
		int result = distributionDealerDeliveryService.confirmShipment(id);

		return result;
	}

	
	/**
	 * 双击修改
	 */
	@RequestMapping(value = "modifyDistributionInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyDistributionInfo(@RequestParam Map<String, Object> param,HttpServletRequest request) {
		
		System.out.println("進入contryooler");
		//双击修改
		int result = distributionDealerDeliveryService.modifyDistributionInfo(param, request);
		//根据id获取记录
		DistributionDealerDelivery distributionDealerDelivery=distributionDealerDeliveryService.selectById(param);
		//计算总数
		distributionDealerDelivery.setActualTotalDeal(distributionDealerDelivery.getRealYards59()+distributionDealerDelivery.getRealYards66()+distributionDealerDelivery.getRealYards73()+distributionDealerDelivery.getRealYards80()
		+distributionDealerDelivery.getRealYards90()+distributionDealerDelivery.getRealYards110()+distributionDealerDelivery.getRealYards120()+distributionDealerDelivery.getRealYards130()+distributionDealerDelivery.getRealYards160()+distributionDealerDelivery.getRealYards170());
		//最后的总数据
		int actual=distributionDealerDelivery.getActualTotalDeal();
		//计算实际出库
		distributionDealerDelivery.setReportsTotalDeal(distributionDealerDelivery.getReportYards59()+distributionDealerDelivery.getReportYards66()+distributionDealerDelivery.getReportYards73()+distributionDealerDelivery.getReportYards80()+distributionDealerDelivery.getReportYards90()
	    +distributionDealerDelivery.getReportYards110()+distributionDealerDelivery.getReportYards120()+distributionDealerDelivery.getReportYards130()+distributionDealerDelivery.getReportYards160()+distributionDealerDelivery.getReportYards170());
		//最后数据
		int report=distributionDealerDelivery.getReportsTotalDeal();
		//修改总數據
		distributionDealerDeliveryService.updateReportAndReal(distributionDealerDelivery.getId(),actual,report);
		logger.debug("双击修改");
		return result;
	}

	/**
	 * 添加辅料
	 * 
	 * @param file
	 *            文件名
	 * @param accessoryInfo
	 *            辅料信息对象
	 * @param request
	 *            请求信息
	 * @return 添加结果
	 * @throws IOException
	 */
	

	/**
	 * 生成新名字
	 * 
	 * @param Filename
	 *            文件名
	 * @return 新的图片名称
	 */
	private String fileReName(String Filename) {
		Random rd = new Random();// 随机数生成
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String suffix = Filename.substring(Filename.lastIndexOf("."));// 获取后缀名
		return sdf.format(new Date()) + rd.nextInt(10000) + suffix;// 新图片名
	}

}

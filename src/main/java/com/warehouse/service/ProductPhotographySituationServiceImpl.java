package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ProductPhotographySituationMapper;
import com.warehouse.entity.ProductPhotographySituation;
import com.warehouse.util.DateUtils;

@Service
public class ProductPhotographySituationServiceImpl implements ProductPhotographySituationService {
	
	@Resource
	ProductPhotographySituationMapper productPhotographySituationMapper;
//获取拍摄情况总数
	@Override
	public int getPhotographyInfoBpcnt(Map<String, Object> param) {
	
		return productPhotographySituationMapper.getPhotographyInfoBpcnt(param);
	}
//获取拍摄情况记录
	@Override
	public List<ProductPhotographySituation> findPhotographyInfoCndbp(Map<String, Object> param) {
		int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
		return productPhotographySituationMapper.findPhotographyInfoCndbp(param);
	}
//修改拍摄状态
	@Override
	public int confirmShipmentPhotography(Integer id) {
	
		return productPhotographySituationMapper.confirmShipmentPhotography(id);
	}
//双击修改拍摄数据记录
	@Override
	public int modifyPhotographyInfo(Map<String, Object> param) {
		
		return productPhotographySituationMapper.modifyPhotographyInfo(param);
	}
//增添数据
	@Override
	public int addproductPhotographySituationInfo(ProductPhotographySituation productPhotographySituation) {
		productPhotographySituation.setCreateTime(DateUtils.formateDaTime(new Date()));
		productPhotographySituation.setDelStatus("1");
		return productPhotographySituationMapper.addproductPhotographySituationInfo(productPhotographySituation);
	}
//按ID查询一条拍摄数据
	@Override
	public ProductPhotographySituation queryById(Integer id) {
		
		return productPhotographySituationMapper.queryById(id);
	}

	
	
}

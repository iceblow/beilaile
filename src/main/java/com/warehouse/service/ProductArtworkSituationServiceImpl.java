package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ProductArtworkSituationMapper;
import com.warehouse.entity.ProductArtworkSituation;
@Service
public class ProductArtworkSituationServiceImpl implements ProductArtworkSituationService {
	@Resource
	ProductArtworkSituationMapper productArtworkSituationMapper;
	//获取美工情况总数
	@Override
	public int getArtworkInfoBpcnt(Map<String, Object> param) {

		return productArtworkSituationMapper.getArtworkInfoBpcnt(param);
	}
//获取美工情况记录
	@Override
	public List<ProductArtworkSituation> findArtworkInfoCndbp(Map<String, Object> param) {
		int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
		return productArtworkSituationMapper.findArtworkInfoCndbp(param);
	}
//修改修图状态
	@Override
	public int confirmShipmentArtwork(Integer id) {
	
		return productArtworkSituationMapper.confirmShipmentArtwork(id);
	}
//双击修改修图数据
	@Override
	public int modifyArtworkInfo(Map<String, Object> param) {
		
		return productArtworkSituationMapper.modifyArtworkInfo(param);
	}
//增添一条美工数据
	@Override
	public int addproductArtworkSituationInfo(ProductArtworkSituation productArtworkSituation) {
		
		return productArtworkSituationMapper.addproductArtworkSituationInfo(productArtworkSituation);
	}
//根据ID查询
	@Override
	public ProductArtworkSituation queryById(Integer id) {

		return productArtworkSituationMapper.queryById(id);
	}

}

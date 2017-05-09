package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ProductOperationSituationMapper;
import com.warehouse.entity.ProductOperationSituation;
@Service
public class ProductOperationSituationServiceImpl implements ProductOperationSituationService {
	@Resource
	ProductOperationSituationMapper productOperationSituationMapper;
	@Override
//获取上架状态总数
	public int getOperationInfoBpcnt(Map<String, Object> param) {

		return productOperationSituationMapper.getOperationInfoBpcnt(param);
	}
//获取上架状态记录
	@Override
	public List<ProductOperationSituation> findOperationInfoCndbp(Map<String, Object> param) {
		int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
		return productOperationSituationMapper.findOperationInfoCndbp(param);
	}
//修改上架状态
	@Override
	public int confirmShipmentOperation(Integer id) {
	
		return productOperationSituationMapper.confirmShipmentOperation(id);
	}
//双击修改上架记录
	@Override
	public int modifyOperationInfo(Map<String, Object> param) {
		
		return productOperationSituationMapper.modifyOperationInfo(param);
	}
//增添一条上架记录
	@Override
	public int addProductOperationSituationInfo(ProductOperationSituation productOperationSituation) {
		
		return productOperationSituationMapper.addProductOperationSituationInfo(productOperationSituation);
	}
//根据ID查询
	@Override
	public ProductOperationSituation queryById(Integer id) {
		
		return productOperationSituationMapper.queryById(id);
	}
}

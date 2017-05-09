package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ProductTaoBaoInfoDAO;
import com.warehouse.entity.ProductTaoBaoInfo;
import com.warehouse.util.PageUtil;

@Service
public class ProductTaoBaoInfoServiceImpl implements ProductTaoBaoInfoService {

	@Resource
	private ProductTaoBaoInfoDAO taoBaoInfoDAO;

	@Override
	public Map<String, Object> getDataByPage(PageUtil page, ProductTaoBaoInfo taoBaoInfo) {
		page.setPageSize(15);
		page.setTotolCount(this.taoBaoInfoDAO.getCountByPage(taoBaoInfo));
		List<ProductTaoBaoInfo> dataList = this.taoBaoInfoDAO
				.getDataByPage(new ProductTaoBaoInfo(page.getReqult()[0], page.getReqult()[1], taoBaoInfo));
		Map<String, Object> map=new HashMap<>();
		map.put("pageUtil", page);
		map.put("dataList", dataList);
		return map;
	}

}

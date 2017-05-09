package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.PurchaseOrdersDetailDAO;
import com.warehouse.entity.PurchaseOrdersDetail;
import com.warehouse.util.PageUtil;

@Service
public class PurchaseOrdersDetailServiceImpl implements PurchaseOrdersDetailService {

	@Resource
	private PurchaseOrdersDetailDAO purchaseOrdersDetailDAO;

	@Override
	public Map<String, Object> getAllByPage(PageUtil page, PurchaseOrdersDetail purchaseOrdersDetail) {

		Map<String, Object> map = new HashMap<>();

		page.setPageSize(18);
		page.setTotolCount(this.purchaseOrdersDetailDAO.getCountByPage(purchaseOrdersDetail));

		List<PurchaseOrdersDetail> dataList = this.purchaseOrdersDetailDAO.getDataByPage(
				new PurchaseOrdersDetail(page.getReqult()[0], page.getReqult()[1], purchaseOrdersDetail));

		map.put("pageUtil", page);
		map.put("dataList", dataList);

		return map;
	}

}

package com.warehouse.service;

import java.util.Map;

import com.warehouse.entity.PurchaseOrdersDetail;
import com.warehouse.util.PageUtil;

public interface PurchaseOrdersDetailService {

	Map<String, Object> getAllByPage(PageUtil page, PurchaseOrdersDetail purchaseOrdersDetail);

}

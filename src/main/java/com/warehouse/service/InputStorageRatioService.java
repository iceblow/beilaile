package com.warehouse.service;

import java.util.Map;

public interface InputStorageRatioService {
	/**
	 * 入库比例
	 * @return
	 */
	Map<String,Object> getRatioIn();
	/**
	 * 未入库
	 * @return
	 */
	Map<String,Object> getRatioNot();

}

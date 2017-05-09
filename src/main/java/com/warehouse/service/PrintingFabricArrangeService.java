package com.warehouse.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.warehouse.entity.PrintingFabricArrange;
import com.warehouse.util.PageUtil;

public interface PrintingFabricArrangeService {

	/**
	 * 面料配齐分页查询(模糊查询)
	 * @param pageUtil 分页信息
	 * @param ready 查询条件
	 * @return
	 */
	Map<String, Object> getDataByPage(PageUtil pageUtil,PrintingFabricArrange ready);
	
	/**
	 * 完成按钮点击事件
	 * @param id
	 * @return
	 */
	int completeReady(int id);

	/**
	 * 双击修改
	 * @param ready
	 * @return
	 */
	int dbUpdateData(PrintingFabricArrange ready);
	
	/**
	 * 导出excle数据
	 * @param ids(id的集合)
	 */
	void toExcle(HttpServletRequest request,HttpServletResponse response,String ids);

	/**
	 * 面料发放确认
	 * @param id
	 * @return
	 */
	int completeSuccess(int id);

}

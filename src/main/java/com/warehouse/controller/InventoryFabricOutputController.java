package com.warehouse.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.InventoryFabricDetails;
import com.warehouse.entity.InventoryFabricOutput;
import com.warehouse.entity.InventoryFabricSingleDetails;
import com.warehouse.service.InventoryFabricDetailsService;
import com.warehouse.service.InventoryFabricOutputService;
import com.warehouse.service.InventoryFabricSingleDetailsService;
import com.warehouse.util.DateUtils;
import com.warehouse.util.Page;

@Controller
public class InventoryFabricOutputController {
	@Resource
	public InventoryFabricOutputService inventoryFabricOutputService;
	@Resource
	public InventoryFabricDetailsService inventoryFabricDetailsService;
	@Resource
	public InventoryFabricSingleDetailsService inventoryFabricSingleDetailsService;

	@RequestMapping(value = "findInventoryFabricOutputById.do", method = RequestMethod.POST)
	@ResponseBody
	public InventoryFabricOutput findInventoryFabricOutputById(Integer id) {
		return inventoryFabricOutputService.findInventoryFabricOutputById(id);
	}

	@RequestMapping(value = "findInventoryFabricOutputByFabricCode.do", method = RequestMethod.POST)
	@ResponseBody
	public List<InventoryFabricOutput> findInventoryFabricOutputByFabricCode(String fabricCode) {
		return inventoryFabricOutputService.findInventoryFabricOutputByFabricCode(fabricCode);
	}

	@RequestMapping(value = "addInventoryFabricOutput.do", method = RequestMethod.POST)
	@ResponseBody
	public int addInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput, HttpServletRequest request) {
		// 修改出库状态
		int result = inventoryFabricOutputService.addInventoryFabricOutput(inventoryFabricOutput, request);

		return result;
	}

	@RequestMapping(value = "updateInventoryFabricOutputDataStatusById.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateInventoryFabricOutputDataStatusById(Integer id, HttpServletRequest request) {
		// 修改出库状态
		int result = inventoryFabricOutputService.updateInventoryFabricOutputDataStatusById(id, request);
		// 1为已出库
		if (result == 1) {
			// 查询面料入库的这个对象id，查找对象
			InventoryFabricOutput inventoryFabricOutput = inventoryFabricOutputService
					.findInventoryFabricOutputById(id);
			// 查询编号,这个查对象在汇总是否存在
			InventoryFabricDetails resultDetails = inventoryFabricDetailsService
					.findInventoryFabricDetailsByFabricCode(inventoryFabricOutput.getFabricCode());
			// 如果汇总里原来有这个数据 就进行数据累加
			if (resultDetails != null) {
				// 修改汇总
				resultDetails
						.setFabricAmount(resultDetails.getFabricAmount() - inventoryFabricOutput.getFabricAmount());// 添加数量
				resultDetails
						.setFabricWeight(resultDetails.getFabricWeight() - inventoryFabricOutput.getFabricWeight());// 添加重量
				resultDetails.setFabricInventoryTime(DateUtils.formateDaTime(new Date()));// 盘点时间
				// 汇总表的修改操作
				int updateDetails = inventoryFabricDetailsService.modifyInventoryFabricDetails(resultDetails, request);// 修改这两个数据
				// 成功修改仓库数据
				if (updateDetails == 1) {
					// 把入库信息添加到面料详情表去
					// new 面料详情对象
					InventoryFabricSingleDetails singleDetails = new InventoryFabricSingleDetails();
					singleDetails.setFabricAmount(inventoryFabricOutput.getFabricAmount()); // 数量
					singleDetails.setFabricBarcode(inventoryFabricOutput.getFabricBarcode()); // 面料条形码
					singleDetails.setFabricCode(inventoryFabricOutput.getFabricCode()); // 面料编码
					singleDetails.setFabricUnit(inventoryFabricOutput.getFabricUnit()); // 面料单位
					singleDetails.setFabricOutTime(inventoryFabricOutput.getFabricOutTime());// 入库时间
					singleDetails.setFabricWeight(inventoryFabricOutput.getFabricWeight()); // 面料重量
					singleDetails.setCreateTime(DateUtils.formateDaTime(new Date()));// 创建库时间
					singleDetails.setSid(inventoryFabricOutput.getSid());
					// 返回值1，为成功
					int addSingleDetails = inventoryFabricSingleDetailsService
							.addInventoryFabricSingleDetails(singleDetails, request);// 添加到面料详情信息里
					return addSingleDetails;
				}

			}
			// 如果仓库没有面料就不能出库
			return 18;

		}
		return result;

	}

	@RequestMapping(value = "modifyInventoryFabricOutput.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput, HttpServletRequest request) {
		return inventoryFabricOutputService.modifyInventoryFabricOutput(inventoryFabricOutput, request);
	}

	@RequestMapping(value = "delInventoryFabricOutput.do", method = RequestMethod.POST)
	@ResponseBody
	public int delInventoryFabricOutput(InventoryFabricOutput inventoryFabricOutput, HttpServletRequest request) {
		return inventoryFabricOutputService.delInventoryFabricOutput(inventoryFabricOutput, request);
	}

	@RequestMapping(value = "getInventoryFabricOutputByPageCount.do")
	@ResponseBody
	public Page<InventoryFabricOutput> getInventoryFabricOutputByPageCount(@RequestParam Map<String, Object> anyVal) {
		int result = inventoryFabricOutputService.getInventoryFabricOutputByPageCount(anyVal);
		Page<InventoryFabricOutput> page = new Page<InventoryFabricOutput>(result, 1);
		return page;
	}

	@RequestMapping(value = "findConditionInventoryFabricOutputByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<InventoryFabricOutput> findConditionInventoryFabricOutputByPage(
			@RequestParam Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		return inventoryFabricOutputService.findConditionInventoryFabricOutputByPage(anyVal);
	}
}

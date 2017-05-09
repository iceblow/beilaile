package com.warehouse.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.InventoryFabricDetails;
import com.warehouse.entity.InventoryFabricSingleDetails;
import com.warehouse.entity.InventoryFabricStorage;
import com.warehouse.service.InventoryFabricDetailsService;
import com.warehouse.service.InventoryFabricSingleDetailsService;
import com.warehouse.service.InventoryFabricStorageService;
import com.warehouse.util.DateUtils;
import com.warehouse.util.Page;

@Controller
public class InventoryFabricStorageController {
	@Resource
	public InventoryFabricStorageService InventoryFabricStorageService;

	@Resource
	public InventoryFabricDetailsService inventoryFabricDetailsService;
	@Resource
	public InventoryFabricSingleDetailsService inventoryFabricSingleDetailsService;

	@RequestMapping(value = "findInventoryFabricStorageById.do", method = RequestMethod.POST)
	@ResponseBody
	public InventoryFabricStorage findInventoryFabricStorageById(Integer id) {
		return InventoryFabricStorageService.findInventoryFabricStorageById(id);
	}

	@RequestMapping(value = "findInventoryFabricStorageByFabricCode.do", method = RequestMethod.POST)
	@ResponseBody
	public List<InventoryFabricStorage> findInventoryFabricStorageByFabricCode(String fabricCode) {
		return InventoryFabricStorageService.findInventoryFabricStorageByFabricCode(fabricCode);
	}

	@RequestMapping(value = "addInventoryFabricStorage.do", method = RequestMethod.POST)
	@ResponseBody
	public int addInventoryFabricStorage(InventoryFabricStorage inventoryFabricStorage, HttpServletRequest request) {
		// 入库
		int result = InventoryFabricStorageService.addInventoryFabricStorage(inventoryFabricStorage, request);
		return result;
	}

	/**
	 * 根据id入库
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "updateInventoryFabricStorageDataStatusById.do", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public int updateInventoryFabricStorageDataStatusById(Integer id, HttpServletRequest request) {
		// 修改入库状态
		int result = InventoryFabricStorageService.updateInventoryFabricStorageDataStatusById(id, request);
		// 1为已入库
		if (result == 1) {
			// 查询面料入库的这个对象id，查找对象
			InventoryFabricStorage inventoryFabricStorage = InventoryFabricStorageService
					.findInventoryFabricStorageById(id);
			// 查询编号,这个查对象在汇总是否存在
			InventoryFabricDetails resultDetails = inventoryFabricDetailsService
					.findInventoryFabricDetailsByFabricCode(inventoryFabricStorage.getFabricCode());
			// 如果汇总里原来有这个数据 就进行数据累加
			if (resultDetails != null) {
				// 修改汇总
				resultDetails
						.setFabricAmount(resultDetails.getFabricAmount() + inventoryFabricStorage.getFabricAmount());// 添加数量
				resultDetails
						.setFabricWeight(resultDetails.getFabricWeight() + inventoryFabricStorage.getFabricWeight());// 添加重量
				resultDetails.setFabricInventoryTime(DateUtils.formateDaTime(new Date()));// 盘点时间
				// 汇总表的修改操作
				int updateDetails = inventoryFabricDetailsService.modifyInventoryFabricDetails(resultDetails, request);// 修改这两个数据
				// 成功修改仓库数据
				if (updateDetails == 1) {
					// 把入库信息添加到面料详情表去
					// new 面料详情对象
					InventoryFabricSingleDetails singleDetails = new InventoryFabricSingleDetails();
					singleDetails.setFabricAmount(inventoryFabricStorage.getFabricAmount()); // 数量
					singleDetails.setFabricBarcode(inventoryFabricStorage.getFabricBarcode()); // 面料条形码
					singleDetails.setFabricCode(inventoryFabricStorage.getFabricCode()); // 面料编码
					singleDetails.setFabricUnit(inventoryFabricStorage.getFabricUnit()); // 面料单位
					singleDetails.setFabricStorageTime(inventoryFabricStorage.getFabricStorageTime());// 入库时间
					singleDetails.setFabricWeight(inventoryFabricStorage.getFabricWeight()); // 面料重量
					singleDetails.setCreateTime(DateUtils.formateDaTime(new Date()));// 入库时间
					// 返回值1，为成功
					int addSingleDetails = inventoryFabricSingleDetailsService
							.addInventoryFabricSingleDetails(singleDetails, request);// 添加到面料详情信息里
					return addSingleDetails;
				}

			} else {// 如果仓库没有这个数据
				// 在仓库汇总里调用添加
				// new 仓库面料对象
				InventoryFabricDetails addDetails = new InventoryFabricDetails();
				addDetails.setFabricAmount(inventoryFabricStorage.getFabricAmount());// 数量
				addDetails.setFabricCode(inventoryFabricStorage.getFabricCode());// 编号
				addDetails.setFabricWeight(inventoryFabricStorage.getFabricWeight());// 重量
				addDetails.setFabricUnit(inventoryFabricStorage.getFabricUnit());// 单位
				addDetails.setFabricInventoryTime(DateUtils.formateDaTime(new Date()));// 盘点时间间
				addDetails.setSid(inventoryFabricStorage.getSid());
				// 调用仓库面料汇总的添加方法法
				Integer addFabricDetails = inventoryFabricDetailsService.addInventoryFabricDetails(addDetails, request);
				if (addFabricDetails == 1) {
					// 把入库信息添加到面料详情表去
					// new 面料详情对象
					InventoryFabricSingleDetails singleDetails = new InventoryFabricSingleDetails();
					singleDetails.setSid(inventoryFabricStorage.getSid());
					singleDetails.setFabricAmount(inventoryFabricStorage.getFabricAmount()); // 数量
					singleDetails.setFabricBarcode(inventoryFabricStorage.getFabricBarcode()); // 面料条形码
					singleDetails.setFabricCode(inventoryFabricStorage.getFabricCode()); // 面料编码
					singleDetails.setFabricUnit(inventoryFabricStorage.getFabricUnit()); // 面料单位
					singleDetails.setFabricStorageTime(inventoryFabricStorage.getFabricStorageTime());// 入库时间
					singleDetails.setFabricWeight(inventoryFabricStorage.getFabricWeight()); // 面料重量
					singleDetails.setCreateTime(DateUtils.formateDaTime(new Date()));// 入库时间
					// 返回值1，为成功
					int addSingleDetails = inventoryFabricSingleDetailsService
							.addInventoryFabricSingleDetails(singleDetails, request);// 添加到面料详情信息里
					return addSingleDetails;
				}

			}
		}
		return result;

	}

	@RequestMapping(value = "modifyInventoryFabricStorage.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyInventoryFabricStorage(InventoryFabricStorage inventoryFabricStorage, HttpServletRequest request) {
		return InventoryFabricStorageService.modifyInventoryFabricStorage(inventoryFabricStorage, request);
	}

	@RequestMapping(value = "delInventoryFabricStorage.do", method = RequestMethod.POST)
	@ResponseBody
	public int delInventoryFabricStorage(InventoryFabricStorage inventoryFabricStorage, HttpServletRequest request) {
		return InventoryFabricStorageService.delInventoryFabricStorage(inventoryFabricStorage, request);
	}

	@RequestMapping(value = "getInventoryFabricStorageByPageCount.do")
	@ResponseBody
	public Page<InventoryFabricStorage> getInventoryFabricStorageByPageCount(@RequestParam Map<String, Object> anyVal) {
		int result = InventoryFabricStorageService.getInventoryFabricStorageByPageCount(anyVal);
		Page<InventoryFabricStorage> page = new Page<InventoryFabricStorage>(result, 1);
		return page;
	}

	@RequestMapping(value = "findConditionInventoryFabricStorageByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<InventoryFabricStorage> findConditionInventoryFabricStorageByPage(
			@RequestParam Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		return InventoryFabricStorageService.findConditionInventoryFabricStorageByPage(anyVal);
	}

}

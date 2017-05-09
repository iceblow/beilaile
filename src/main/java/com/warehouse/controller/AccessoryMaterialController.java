package com.warehouse.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.AccessoryMaterial;
import com.warehouse.service.AccessoryMaterialService;
import com.warehouse.util.Page;

/**
 * ccessoryMaterial 辅料  功能弃用   历史数据存在请勿删除
 * Created by Beilaile on 2016/12/8.
 */
@Controller
public class AccessoryMaterialController {
	@Resource
	public AccessoryMaterialService accessoryMaterialService;

	private Logger logger = LoggerFactory.getLogger(AccessoryMaterialController.class);

	/**
	 * 添加辅料 使用sql function 代替
	 *
	 * @param accessoryMaterial
	 * @param request
     * @return
     */
	@RequestMapping(value = "addAccessoryMaterial.do", method = RequestMethod.POST)
	@ResponseBody
	public int addAccessoryMaterial(AccessoryMaterial accessoryMaterial, HttpServletRequest request) {
		int result = accessoryMaterialService.addAccessoryMaterial(accessoryMaterial, request);
		logger.debug("添加辅料");
		return result;
	}

	/**
	 * 根据id查询
	 *
	 * @param id 辅料id
	 * @return 辅料对象
	 */
	@RequestMapping(value = "getAccessoryMaterialById.do", method = RequestMethod.POST)
	@ResponseBody
	public AccessoryMaterial getAccessoryMaterialById(Integer id) {
		AccessoryMaterial accessoryMaterial = accessoryMaterialService.getAccessoryMaterialById(id);
		logger.info("根据id 查询辅料");
		return accessoryMaterial;
	}

	/**
	 * 修改对象
	 * 
	 * @param accessoryMaterial 辅料对象
	 * @return 修改的对象信息
	 */
	@RequestMapping(value = "modifyAccessoryMaterial.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyAccessoryMaterial(AccessoryMaterial accessoryMaterial, HttpServletRequest request) {
		int result = accessoryMaterialService.modifyAccessoryMaterial(accessoryMaterial, request);
		logger.debug("修改辅料对象");
		return result;
	}

	/**
	 * 根据id删除
	 * @param accessoryMaterial 辅料对象
	 * @param request 修改的结果数
     * @return
     */
	@RequestMapping(value = "delAccessoryMaterialById.do", method = RequestMethod.POST)
	@ResponseBody
	public int delAccessoryMaterialById(AccessoryMaterial accessoryMaterial, HttpServletRequest request) {
		int result = accessoryMaterialService.delAccessoryMaterialById(accessoryMaterial, request);
		logger.debug("根据Id 删除 辅料信息");
		return result;
	}

	/**
	 * 查询总条数
	 * @param anyVal  筛查条件
	 * @return 辅料总数两
	 */
	@RequestMapping(value = "getAccessoryMaterialByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<AccessoryMaterial> getAccessoryMaterialByPageCount(Map<String, Object> anyVal) {
		int result = accessoryMaterialService.getAccessoryMaterialByPageCount(anyVal);
		Page<AccessoryMaterial> page = new Page<>(result, 1);
		// page.setRecordList(list);
		logger.info("查询辅料总条数");
		return page;
	}

	/**
	 * 模糊查询带分页
	 * @param anyVal 当前页信息 筛查条件
	 * @return 查询的信息列表
	 */
	@RequestMapping(value = "findConditionAccessoryMaterialByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<AccessoryMaterial> findConditionAccessoryMaterialByPage(@RequestParam Map<String, Object> anyVal) {
		List<AccessoryMaterial> list = accessoryMaterialService.findConditionAccessoryMaterialByPage(anyVal);
		logger.info("模糊查询辅料 带分页");
		return list;
	}

	/**
	 * 保存双击修改的参数
	 * @param am 辅料对象
	 * @return 修改对象的信息
     */
	@RequestMapping("savaAccessoryMaterialArgsUpdate")
	@ResponseBody
	private AccessoryMaterial savaAccessoryMaterialArgsUpdate(AccessoryMaterial am, HttpServletRequest request) {
		AccessoryMaterial result = this.accessoryMaterialService.savaAccessoryMaterialArgsUpdate(am, request);
		logger.debug("双击修改辅料参数");
		return result;
	}

	/**
	 * 修改 理单完成
	 * @param amId 修改对象的id
	 * @param request  请求地址信息
	 * @return
	 */
	@RequestMapping(value = "manageAmComplete.do", method = RequestMethod.POST)
	@ResponseBody
	private int manageAmComplete(Integer amId, HttpServletRequest request) {
		int result = this.accessoryMaterialService.manageAmComplete(amId, request);
		logger.debug("修改状态 为理单完成");
		return result;
	}

//	弃用功能
//	@RequestMapping(value = "confirmReady.do", method = RequestMethod.POST)
//	@ResponseBody
//	private int confirmReady(Integer amId, HttpServletRequest request) {
//		int result = this.accessoryMaterialService.confirmReady(amId, request);
//		logger.debug("修改 发放状态 为准备就绪");
//		return result;
//	}
//
//	@RequestMapping(value = "alreadyIssue.do", method = RequestMethod.POST)
//	@ResponseBody
//	private int alreadyIssue(Integer amId, HttpServletRequest request) {
//		int result = this.accessoryMaterialService.alreadyIssue(amId, request);
//		logger.debug("修改 发放状态 为已经发放");
//		return result;
//	}
//
//	@RequestMapping(value = "resetState.do", method = RequestMethod.POST)
//	@ResponseBody
//	private int resetState(Integer amId, HttpServletRequest request) {
//		int result = this.accessoryMaterialService.resetState(amId, request);
//		logger.debug("修改 发放状态 为默认");
//		return result;
//	}



}

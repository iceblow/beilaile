package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricMaterialMapper;
import com.warehouse.entity.FabricMaterial;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

/**
 * 
 * @author Beilaile 2016年12月12日18:12:27
 *
 */
@Service
public class FabricMaterialServiceImpl implements FabricMaterialService {
	private Logger logger = LoggerFactory.getLogger(FabricMaterialServiceImpl.class);
	@Resource
	public FabricMaterialMapper fabricMaterialMapper;

	@Override
	public int addFabricMaterial(FabricMaterial fabricMaterial, HttpServletRequest request) {
		String operatorIp = ClientIpUtil.getIpAddress(request);
		fabricMaterial.setOperatorIp(operatorIp);
		fabricMaterial.setCreatedTime(DateUtils.formateDaTime(new Date()));
		fabricMaterial.setMarkStatus("1");
		int result = fabricMaterialMapper.addFabricMaterial(fabricMaterial);
		logger.debug(" 成功添加编号:" + fabricMaterial.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return result;
	}

	@Override
	public int modifyFabricMaterial(FabricMaterial fabricMaterial, HttpServletRequest request) {
		String operatorIp = ClientIpUtil.getIpAddress(request);
		fabricMaterial.setOperatorIp(operatorIp);
		fabricMaterial.setModifyTime(DateUtils.formateDaTime(new Date()));
		int result = fabricMaterialMapper.modifyFabricMaterial(fabricMaterial);
		logger.debug(" 成功修改编号:" + fabricMaterial.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return result;
	}

	@Override
	public int delFabricMaterialById(FabricMaterial fabricMaterial, HttpServletRequest request) {
		String operatorIp = ClientIpUtil.getIpAddress(request);
		fabricMaterial.setOperatorIp(operatorIp);
		fabricMaterial.setDeleteTime(DateUtils.formateDaTime(new Date()));
		fabricMaterial.setMarkStatus("0");
		int result = fabricMaterialMapper.delFabricMaterialById(fabricMaterial);
		logger.debug(" 成功添删除料编号:" + fabricMaterial.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return result;
	}

	@Override
	public int getFabricMaterialByPageCount(Map<String, Object> anyVal) {
		int result = fabricMaterialMapper.getFabricMaterialByPageCount(anyVal);
		return result;
	}

	@Override
	public List<FabricMaterial> findConditionFabricMaterialByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<FabricMaterial> list = fabricMaterialMapper.findConditionFabricMaterialByPage(anyVal);
		return list;
	}

	@Override
	public FabricMaterial getFabricMaterialById(Integer id) {
		FabricMaterial fabricMaterial = fabricMaterialMapper.getFabricMaterialById(id);
		return fabricMaterial;
	}

	@Override
	public int updateFabricMaterialByStatus(FabricMaterial fabricMaterial, HttpServletRequest request) {
		String operatorIp = ClientIpUtil.getIpAddress(request);
		fabricMaterial.setOperatorIp(operatorIp);
		fabricMaterial.setIssuedStatus("1");
		fabricMaterial.setModifyTime(DateUtils.formateDaTime(new Date()));

		int result = fabricMaterialMapper.updateFabricMaterialByStatus(fabricMaterial);
		logger.debug("成功操作波次:" + fabricMaterial.getWave() + "数据状态为:" + fabricMaterial.getIssuedStatus() + "操作者ip为:"
				+ ClientIpUtil.getIpAddress(request));

		return result;
	}

	@Override
	public int updateFabricMaterialByPurchase(FabricMaterial fabricMaterial, HttpServletRequest request) {
		String operatorIp = ClientIpUtil.getIpAddress(request);
		fabricMaterial.setOperatorIp(operatorIp);
		fabricMaterial.setIssuedStatus("2");
		fabricMaterial.setModifyTime(DateUtils.formateDaTime(new Date()));
		int result = fabricMaterialMapper.updateFabricMaterialByPurchase(fabricMaterial);
		logger.debug("成功操作波次:" + fabricMaterial.getWave() + "数据状态为:" + fabricMaterial.getIssuedStatus() + "操作者ip为:"
				+ ClientIpUtil.getIpAddress(request));
		return result;
	}

	@Override
	public int selectFabricMaterialByPageCount(Map<String, Object> anyVal) {
		int result = fabricMaterialMapper.selectFabricMaterialByPageCount(anyVal);
		return result;
	}

	@Override
	public List<FabricMaterial> selectConditionFabricMaterialByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<FabricMaterial> list = fabricMaterialMapper.selectConditionFabricMaterialByPage(anyVal);
		return list;
	}

	/**
	 * 驳回 状态为三
	 */
	@Override
	public int updateFabricMaterialByOverrule(FabricMaterial fabricMaterial, HttpServletRequest request) {
		String operatorIp = ClientIpUtil.getIpAddress(request);
		fabricMaterial.setOperatorIp(operatorIp);
		fabricMaterial.setIssuedStatus("3");
		fabricMaterial.setModifyTime(DateUtils.formateDaTime(new Date()));
		int result = fabricMaterialMapper.updateFabricMaterialByOverrule(fabricMaterial);
		logger.debug("成功操作波次:" + fabricMaterial.getWave() + "数据状态为:" + fabricMaterial.getIssuedStatus() + "操作者ip为:"
				+ ClientIpUtil.getIpAddress(request));

		return result;
	}

	/**
	 * 生成excel
	 * 
	 */
	@Override
	public List<FabricMaterial> findFabricMaterialByExcel() {
		List<FabricMaterial> list = fabricMaterialMapper.findFabricMaterialByExcel();
		return list;
	}

}

package com.warehouse.service;

import com.warehouse.constant.StateConstant;
import com.warehouse.dao.AccessoryPurchaseMapper;
import com.warehouse.entity.AccessoryPurchase;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by chiayich on 2016/12/30.
 */
@Service
public class AccessoryPurchaseServiceImpl implements AccessoryPurchaseService {

	@Resource
	public AccessoryPurchaseMapper accessoryPurchaseMapper;

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);// 时间格式化
	SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);// 日期格式化




	@Override
	public int getAccessoryPurchaseByPageCount(Map<String, Object> anyVal) {
		int reslut = accessoryPurchaseMapper.getAccessoryPurchaseByPageCount(anyVal);
		return reslut;
	}

	@Override
	public List<AccessoryPurchase> findConditionAccessoryPurchaseByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<AccessoryPurchase> list = accessoryPurchaseMapper.findConditionAccessoryPurchaseByPage(anyVal);
		return list;
	}

	@Override
	public AccessoryPurchase getAccessoryPurchaseById(@Param("id") Integer id) {
		AccessoryPurchase accessoryPurchase = accessoryPurchaseMapper.getAccessoryPurchaseById(id);
		return accessoryPurchase;
	}

	@Override
	public AccessoryPurchase alreadyIssuePurchase(Integer amId, HttpServletRequest request) {
		AccessoryPurchase accessoryPurchase = updateISCommon(amId, request);
		accessoryPurchase.setIssuedStatus(StateConstant._CONFIRM_ISSUE_PURCHASE);
		accessoryPurchaseMapper.updatePurchaseIssuedStatus(accessoryPurchase);
		return accessoryPurchase;
	}

	@Override
	public AccessoryPurchase rejectPurchase(Integer amId, HttpServletRequest request) {
		AccessoryPurchase accessoryPurchase = updateISCommon(amId, request);
		accessoryPurchase.setIssuedStatus(StateConstant._REJECT_PURCHASE);
		accessoryPurchaseMapper.updatePurchaseIssuedStatus(accessoryPurchase);
		return accessoryPurchase;
	}

	//修改状态的通用部分
	private AccessoryPurchase updateISCommon(int amId,HttpServletRequest request) {
		String operatorIp = ClientIpUtil.getIpAddress(request);
		AccessoryPurchase accessoryMaterial = accessoryPurchaseMapper.getAccessoryPurchaseById(amId);
		accessoryMaterial.setOperatorIp(operatorIp);
		accessoryMaterial.setModifyTime(DateUtils.formateDaTime(new Date()).toString());
		return accessoryMaterial;
	}
}

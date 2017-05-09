package com.warehouse.service;

import com.warehouse.constant.StateConstant;
import com.warehouse.dao.AccessoryRationMapper;
import com.warehouse.entity.AccessoryRation;
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
public class AccessoryRationServiceImpl implements AccessoryRationService {

	@Resource
	private AccessoryRationMapper accessoryRationMapper;

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);// 时间格式化
	SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);// 日期格式化




	@Override
	public int getAccessoryRationByPageCount(Map<String, Object> anyVal) {
		int reslut = accessoryRationMapper.getAccessoryRationByPageCount(anyVal);
		return reslut;
	}

	@Override
	public List<AccessoryRation> findConditionAccessoryRationByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<AccessoryRation> list = accessoryRationMapper.findConditionAccessoryRationByPage(anyVal);
		return list;
	}

	@Override
	public AccessoryRation getAccessoryRationById(@Param("id") Integer id) {
		AccessoryRation accessoryRation = accessoryRationMapper.getAccessoryRationById(id);
		return accessoryRation;
	}

	@Override
	public AccessoryRation rationPurchasing(Integer amId, HttpServletRequest request) {
		AccessoryRation accessoryRation = updateISCommon(amId, request);
		accessoryRation.setIssuedStatus(StateConstant._RATION_PURCHASE_ING);
		accessoryRationMapper.updateRationIssuedStatus(accessoryRation);
		return accessoryRation;
	}

	@Override
	public AccessoryRation rejectRation(Integer amId, HttpServletRequest request) {
		AccessoryRation accessoryRation = updateISCommon(amId, request);
		accessoryRation.setIssuedStatus(StateConstant._REJECT_PURCHASE);
		accessoryRationMapper.updateRationIssuedStatus(accessoryRation);
		return accessoryRation;
	}

	@Override
	public AccessoryRation rationPrepareComplete(Integer amId, HttpServletRequest request) {
		AccessoryRation accessoryRation = updateISCommon(amId, request);
		accessoryRation.setIssuedStatus(StateConstant._RATION_ALREADY_PREPARED);
		accessoryRationMapper.updateRationIssuedStatus(accessoryRation);
		return accessoryRation;
	}

	@Override
	public AccessoryRation rationAlreadyIssue(Integer amId, HttpServletRequest request) {
		AccessoryRation accessoryRation = updateISCommon(amId, request);
		accessoryRation.setIssuedStatus(StateConstant._RATION_ALREADY_ISSUE);
		accessoryRationMapper.updateRationIssuedStatus(accessoryRation);
		return accessoryRation;
	}

	//修改状态的通用部分
	private AccessoryRation updateISCommon(int amId,HttpServletRequest request) {
		String operatorIp = ClientIpUtil.getIpAddress(request);
		AccessoryRation accessoryMaterial = accessoryRationMapper.getAccessoryRationById(amId);
		accessoryMaterial.setOperatorIp(operatorIp);
		accessoryMaterial.setModifyTime(DateUtils.formateDaTime(new Date()).toString());
		return accessoryMaterial;
	}
}

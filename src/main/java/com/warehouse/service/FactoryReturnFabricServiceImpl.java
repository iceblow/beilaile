package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FactoryReturnFabricMapper;
import com.warehouse.entity.FactoryReturnFabric;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class FactoryReturnFabricServiceImpl implements FactoryReturnFabricService {
	private Logger logger = LoggerFactory.getLogger(FabricSourcingServiceImpl.class);

	@Resource
	public FactoryReturnFabricMapper factoryReturnFabricMapper;

	@Override
	public int addFactoryReturnFabric(FactoryReturnFabric factoryReturnFabric, HttpServletRequest request) {
		double fp1 = factoryReturnFabric.getParameter1() == null ? 0 : factoryReturnFabric.getParameter1();// 数据1
		double fp2 = factoryReturnFabric.getParameter2() == null ? 0 : factoryReturnFabric.getParameter2();// 数据1
		double fp3 = factoryReturnFabric.getParameter3() == null ? 0 : factoryReturnFabric.getParameter3();// 数据1
		double fp4 = factoryReturnFabric.getParameter4() == null ? 0 : factoryReturnFabric.getParameter4();// 数据1
		double fp5 = factoryReturnFabric.getParameter5() == null ? 0 : factoryReturnFabric.getParameter5();// 数据1
		double fp6 = factoryReturnFabric.getParameter6() == null ? 0 : factoryReturnFabric.getParameter6();// 数据1
		double fp7 = factoryReturnFabric.getParameter7() == null ? 0 : factoryReturnFabric.getParameter7();// 数据1
		double fp8 = factoryReturnFabric.getParameter8() == null ? 0 : factoryReturnFabric.getParameter8();// 数据1
		double fp9 = factoryReturnFabric.getParameter9() == null ? 0 : factoryReturnFabric.getParameter9();// 数据1
		double fp10 = factoryReturnFabric.getParameter10() == null ? 0 : factoryReturnFabric.getParameter10();// 数据1
		double fp11 = factoryReturnFabric.getParameter11() == null ? 0 : factoryReturnFabric.getParameter11();// 数据1
		double fp12 = factoryReturnFabric.getParameter12() == null ? 0 : factoryReturnFabric.getParameter12();// 数据1
		double fp13 = factoryReturnFabric.getParameter13() == null ? 0 : factoryReturnFabric.getParameter13();// 数据1
		double fp14 = factoryReturnFabric.getParameter14() == null ? 0 : factoryReturnFabric.getParameter14();// 数据1
		double fp15 = factoryReturnFabric.getParameter15() == null ? 0 : factoryReturnFabric.getParameter15();// 数据1
		double fp16 = factoryReturnFabric.getParameter16() == null ? 0 : factoryReturnFabric.getParameter16();// 数据1
		double fp17 = factoryReturnFabric.getParameter17() == null ? 0 : factoryReturnFabric.getParameter17();// 数据1
		double fp18 = factoryReturnFabric.getParameter18() == null ? 0 : factoryReturnFabric.getParameter18();// 数据1
		double fp19 = factoryReturnFabric.getParameter19() == null ? 0 : factoryReturnFabric.getParameter19();// 数据1
		double fp20 = factoryReturnFabric.getParameter20() == null ? 0 : factoryReturnFabric.getParameter20();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18, fp19, fp20 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		factoryReturnFabric.setTotalCount(totalCount);
		factoryReturnFabric.setAddTime(DateUtils.formateDaTime(new Date()));
		factoryReturnFabric.setState("1");// 状态
		int reslut = factoryReturnFabricMapper.addFactoryReturnFabric(factoryReturnFabric);
		logger.debug(" 成功添加编号:" + factoryReturnFabric.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return reslut;
	}

	@Override
	public int modifyFactoryReturnFabric(FactoryReturnFabric factoryReturnFabric, HttpServletRequest request) {
		double fp1 = factoryReturnFabric.getParameter1() == null ? 0 : factoryReturnFabric.getParameter1();// 数据1
		double fp2 = factoryReturnFabric.getParameter2() == null ? 0 : factoryReturnFabric.getParameter2();// 数据1
		double fp3 = factoryReturnFabric.getParameter3() == null ? 0 : factoryReturnFabric.getParameter3();// 数据1
		double fp4 = factoryReturnFabric.getParameter4() == null ? 0 : factoryReturnFabric.getParameter4();// 数据1
		double fp5 = factoryReturnFabric.getParameter5() == null ? 0 : factoryReturnFabric.getParameter5();// 数据1
		double fp6 = factoryReturnFabric.getParameter6() == null ? 0 : factoryReturnFabric.getParameter6();// 数据1
		double fp7 = factoryReturnFabric.getParameter7() == null ? 0 : factoryReturnFabric.getParameter7();// 数据1
		double fp8 = factoryReturnFabric.getParameter8() == null ? 0 : factoryReturnFabric.getParameter8();// 数据1
		double fp9 = factoryReturnFabric.getParameter9() == null ? 0 : factoryReturnFabric.getParameter9();// 数据1
		double fp10 = factoryReturnFabric.getParameter10() == null ? 0 : factoryReturnFabric.getParameter10();// 数据1
		double fp11 = factoryReturnFabric.getParameter11() == null ? 0 : factoryReturnFabric.getParameter11();// 数据1
		double fp12 = factoryReturnFabric.getParameter12() == null ? 0 : factoryReturnFabric.getParameter12();// 数据1
		double fp13 = factoryReturnFabric.getParameter13() == null ? 0 : factoryReturnFabric.getParameter13();// 数据1
		double fp14 = factoryReturnFabric.getParameter14() == null ? 0 : factoryReturnFabric.getParameter14();// 数据1
		double fp15 = factoryReturnFabric.getParameter15() == null ? 0 : factoryReturnFabric.getParameter15();// 数据1
		double fp16 = factoryReturnFabric.getParameter16() == null ? 0 : factoryReturnFabric.getParameter16();// 数据1
		double fp17 = factoryReturnFabric.getParameter17() == null ? 0 : factoryReturnFabric.getParameter17();// 数据1
		double fp18 = factoryReturnFabric.getParameter18() == null ? 0 : factoryReturnFabric.getParameter18();// 数据1
		double fp19 = factoryReturnFabric.getParameter19() == null ? 0 : factoryReturnFabric.getParameter19();// 数据1
		double fp20 = factoryReturnFabric.getParameter20() == null ? 0 : factoryReturnFabric.getParameter20();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18, fp19, fp20 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		factoryReturnFabric.setTotalCount(totalCount);
		factoryReturnFabric.setUpdateTime(DateUtils.formateDaTime(new Date()));
		int reslut = factoryReturnFabricMapper.modifyFactoryReturnFabric(factoryReturnFabric);
		logger.debug(" 成功添加编号:" + factoryReturnFabric.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return reslut;
	}

	@Override
	public int delFactoryReturnFabricById(Integer id, HttpServletRequest request) {
		int reslut = factoryReturnFabricMapper.delFactoryReturnFabricById(id, DateUtils.formateDaTime(new Date()));
		logger.debug(" 成功添加编号:" + id + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return reslut;
	}

	@Override
	public int getFactoryReturnFabricByPageCount(Map<String, Object> anyval) {
		int reslut = factoryReturnFabricMapper.getFactoryReturnFabricByPageCount(anyval);
		return reslut;
	}

	@Override
	public List<FactoryReturnFabric> findConditionFactoryReturnFabricByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<FactoryReturnFabric> list = factoryReturnFabricMapper.findConditionFactoryReturnFabricByPage(anyVal);
		return list;
	}

	@Override
	public FactoryReturnFabric getFactoryReturnFabricById(Integer id) {
		FactoryReturnFabric factoryReturnFabric = factoryReturnFabricMapper.getFactoryReturnFabricById(id);
		return factoryReturnFabric;
	}

	@Override
	public int updateFactoryReturnFabricByCompleteStatus(FactoryReturnFabric factoryReturnFabric,
			HttpServletRequest request) {
		factoryReturnFabric.setUpdateTime(DateUtils.formateDaTime(new Date()));// 状态
		factoryReturnFabric.setFulfilStatus("1");// 状态
		int reslut = factoryReturnFabricMapper.updateFactoryReturnFabricByCompleteStatus(factoryReturnFabric);
		logger.debug(" 成功添加编号:" + factoryReturnFabric.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return reslut;
	}

}

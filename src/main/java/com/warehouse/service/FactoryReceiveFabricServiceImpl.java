package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FactoryReceiveFabricMapper;
import com.warehouse.entity.FactoryReceiveFabric;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class FactoryReceiveFabricServiceImpl implements FactoryReceiveFabricService {
	private Logger logger = LoggerFactory.getLogger(FabricSourcingServiceImpl.class);

	@Resource
	public FactoryReceiveFabricMapper factoryReceiveFabricMapper;

	@Override
	public int addFactoryReceiveFabric(FactoryReceiveFabric factoryReceiveFabric, HttpServletRequest request) {
		double fp1 = factoryReceiveFabric.getParameter1() == null ? 0 : factoryReceiveFabric.getParameter1();// 数据1
		double fp2 = factoryReceiveFabric.getParameter2() == null ? 0 : factoryReceiveFabric.getParameter2();// 数据1
		double fp3 = factoryReceiveFabric.getParameter3() == null ? 0 : factoryReceiveFabric.getParameter3();// 数据1
		double fp4 = factoryReceiveFabric.getParameter4() == null ? 0 : factoryReceiveFabric.getParameter4();// 数据1
		double fp5 = factoryReceiveFabric.getParameter5() == null ? 0 : factoryReceiveFabric.getParameter5();// 数据1
		double fp6 = factoryReceiveFabric.getParameter6() == null ? 0 : factoryReceiveFabric.getParameter6();// 数据1
		double fp7 = factoryReceiveFabric.getParameter7() == null ? 0 : factoryReceiveFabric.getParameter7();// 数据1
		double fp8 = factoryReceiveFabric.getParameter8() == null ? 0 : factoryReceiveFabric.getParameter8();// 数据1
		double fp9 = factoryReceiveFabric.getParameter9() == null ? 0 : factoryReceiveFabric.getParameter9();// 数据1
		double fp10 = factoryReceiveFabric.getParameter10() == null ? 0 : factoryReceiveFabric.getParameter10();// 数据1
		double fp11 = factoryReceiveFabric.getParameter11() == null ? 0 : factoryReceiveFabric.getParameter11();// 数据1
		double fp12 = factoryReceiveFabric.getParameter12() == null ? 0 : factoryReceiveFabric.getParameter12();// 数据1
		double fp13 = factoryReceiveFabric.getParameter13() == null ? 0 : factoryReceiveFabric.getParameter13();// 数据1
		double fp14 = factoryReceiveFabric.getParameter14() == null ? 0 : factoryReceiveFabric.getParameter14();// 数据1
		double fp15 = factoryReceiveFabric.getParameter15() == null ? 0 : factoryReceiveFabric.getParameter15();// 数据1
		double fp16 = factoryReceiveFabric.getParameter16() == null ? 0 : factoryReceiveFabric.getParameter16();// 数据1
		double fp17 = factoryReceiveFabric.getParameter17() == null ? 0 : factoryReceiveFabric.getParameter17();// 数据1
		double fp18 = factoryReceiveFabric.getParameter18() == null ? 0 : factoryReceiveFabric.getParameter18();// 数据1
		double fp19 = factoryReceiveFabric.getParameter19() == null ? 0 : factoryReceiveFabric.getParameter19();// 数据1
		double fp20 = factoryReceiveFabric.getParameter20() == null ? 0 : factoryReceiveFabric.getParameter20();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18, fp19, fp20 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		factoryReceiveFabric.setTotalCount(totalCount);

		factoryReceiveFabric.setAddTime(DateUtils.formateDaTime(new Date()));
		factoryReceiveFabric.setState("1");// 状态
		int reslut = factoryReceiveFabricMapper.addFactoryReceiveFabric(factoryReceiveFabric);
		logger.debug(" 成功添加编号:" + factoryReceiveFabric.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return reslut;
	}

	@Override
	public int modifyFactoryReceiveFabric(FactoryReceiveFabric factoryReceiveFabric, HttpServletRequest request) {
		double fp1 = factoryReceiveFabric.getParameter1() == null ? 0 : factoryReceiveFabric.getParameter1();// 数据1
		double fp2 = factoryReceiveFabric.getParameter2() == null ? 0 : factoryReceiveFabric.getParameter2();// 数据1
		double fp3 = factoryReceiveFabric.getParameter3() == null ? 0 : factoryReceiveFabric.getParameter3();// 数据1
		double fp4 = factoryReceiveFabric.getParameter4() == null ? 0 : factoryReceiveFabric.getParameter4();// 数据1
		double fp5 = factoryReceiveFabric.getParameter5() == null ? 0 : factoryReceiveFabric.getParameter5();// 数据1
		double fp6 = factoryReceiveFabric.getParameter6() == null ? 0 : factoryReceiveFabric.getParameter6();// 数据1
		double fp7 = factoryReceiveFabric.getParameter7() == null ? 0 : factoryReceiveFabric.getParameter7();// 数据1
		double fp8 = factoryReceiveFabric.getParameter8() == null ? 0 : factoryReceiveFabric.getParameter8();// 数据1
		double fp9 = factoryReceiveFabric.getParameter9() == null ? 0 : factoryReceiveFabric.getParameter9();// 数据1
		double fp10 = factoryReceiveFabric.getParameter10() == null ? 0 : factoryReceiveFabric.getParameter10();// 数据1
		double fp11 = factoryReceiveFabric.getParameter11() == null ? 0 : factoryReceiveFabric.getParameter11();// 数据1
		double fp12 = factoryReceiveFabric.getParameter12() == null ? 0 : factoryReceiveFabric.getParameter12();// 数据1
		double fp13 = factoryReceiveFabric.getParameter13() == null ? 0 : factoryReceiveFabric.getParameter13();// 数据1
		double fp14 = factoryReceiveFabric.getParameter14() == null ? 0 : factoryReceiveFabric.getParameter14();// 数据1
		double fp15 = factoryReceiveFabric.getParameter15() == null ? 0 : factoryReceiveFabric.getParameter15();// 数据1
		double fp16 = factoryReceiveFabric.getParameter16() == null ? 0 : factoryReceiveFabric.getParameter16();// 数据1
		double fp17 = factoryReceiveFabric.getParameter17() == null ? 0 : factoryReceiveFabric.getParameter17();// 数据1
		double fp18 = factoryReceiveFabric.getParameter18() == null ? 0 : factoryReceiveFabric.getParameter18();// 数据1
		double fp19 = factoryReceiveFabric.getParameter19() == null ? 0 : factoryReceiveFabric.getParameter19();// 数据1
		double fp20 = factoryReceiveFabric.getParameter20() == null ? 0 : factoryReceiveFabric.getParameter20();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18, fp19, fp20 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		factoryReceiveFabric.setTotalCount(totalCount);
		factoryReceiveFabric.setUpdateTime(DateUtils.formateDaTime(new Date()));
		int reslut = factoryReceiveFabricMapper.modifyFactoryReceiveFabric(factoryReceiveFabric);
		logger.debug(" 成功添加编号:" + factoryReceiveFabric.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return reslut;
	}

	@Override
	public int delFactoryReceiveFabricById(Integer id, HttpServletRequest request) {
		int reslut = factoryReceiveFabricMapper.delFactoryReceiveFabricById(id, DateUtils.formateDaTime(new Date()));

		return reslut;
	}

	@Override
	public int getFactoryReceiveFabricByPageCount(Map<String, Object> anyVal) {
		int reslut = factoryReceiveFabricMapper.getFactoryReceiveFabricByPageCount(anyVal);

		return reslut;
	}

	@Override
	public List<FactoryReceiveFabric> findConditionFactoryReceiveFabricByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<FactoryReceiveFabric> list = factoryReceiveFabricMapper.findConditionFactoryReceiveFabricByPage(anyVal);
		return list;
	}

	@Override
	public FactoryReceiveFabric getFactoryReceiveFabricById(Integer id) {
		FactoryReceiveFabric factoryReceiveFabric = factoryReceiveFabricMapper.getFactoryReceiveFabricById(id);
		return factoryReceiveFabric;
	}

	@Override
	public int updateFactoryReceiveFabricByCompleteStatus(FactoryReceiveFabric factoryReceiveFabric, HttpServletRequest request) {
		factoryReceiveFabric.setUpdateTime(DateUtils.formateDaTime(new Date()));
		factoryReceiveFabric.setFulfilStatus("1");// 状态
		int reslut = factoryReceiveFabricMapper.updateFactoryReceiveFabricByCompleteStatus(factoryReceiveFabric);
		logger.debug(" 成功添加编号:" + factoryReceiveFabric.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return reslut;
	}

}

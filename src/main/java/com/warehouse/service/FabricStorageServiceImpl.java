package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricStorageMapper;
import com.warehouse.entity.FabricStorage;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class FabricStorageServiceImpl implements FabricStorageService {
	private Logger logger = LoggerFactory.getLogger(FabricStorageServiceImpl.class);
	@Resource
	public FabricStorageMapper fabricStorageMapper;

	@Override
	public int addFabricStorage(FabricStorage fabricStorage, HttpServletRequest request) {
		double fp1 = fabricStorage.getParameter1() == null ? 0 : fabricStorage.getParameter1();// 数据1
		double fp2 = fabricStorage.getParameter2() == null ? 0 : fabricStorage.getParameter2();// 数据1
		double fp3 = fabricStorage.getParameter3() == null ? 0 : fabricStorage.getParameter3();// 数据1
		double fp4 = fabricStorage.getParameter4() == null ? 0 : fabricStorage.getParameter4();// 数据1
		double fp5 = fabricStorage.getParameter5() == null ? 0 : fabricStorage.getParameter5();// 数据1
		double fp6 = fabricStorage.getParameter6() == null ? 0 : fabricStorage.getParameter6();// 数据1
		double fp7 = fabricStorage.getParameter7() == null ? 0 : fabricStorage.getParameter7();// 数据1
		double fp8 = fabricStorage.getParameter8() == null ? 0 : fabricStorage.getParameter8();// 数据1
		double fp9 = fabricStorage.getParameter9() == null ? 0 : fabricStorage.getParameter9();// 数据1
		double fp10 = fabricStorage.getParameter10() == null ? 0 : fabricStorage.getParameter10();// 数据1
		double fp11 = fabricStorage.getParameter11() == null ? 0 : fabricStorage.getParameter11();// 数据1
		double fp12 = fabricStorage.getParameter12() == null ? 0 : fabricStorage.getParameter12();// 数据1
		double fp13 = fabricStorage.getParameter13() == null ? 0 : fabricStorage.getParameter13();// 数据1
		double fp14 = fabricStorage.getParameter14() == null ? 0 : fabricStorage.getParameter14();// 数据1
		double fp15 = fabricStorage.getParameter15() == null ? 0 : fabricStorage.getParameter15();// 数据1
		double fp16 = fabricStorage.getParameter16() == null ? 0 : fabricStorage.getParameter16();// 数据1
		double fp17 = fabricStorage.getParameter17() == null ? 0 : fabricStorage.getParameter17();// 数据1
		double fp18 = fabricStorage.getParameter18() == null ? 0 : fabricStorage.getParameter18();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		fabricStorage.setTotalCount(totalCount);
		fabricStorage.setAddTime(DateUtils.formateDaTime(new Date()));
		fabricStorage.setState("1");// 状态
		int reslut = fabricStorageMapper.addFabricStorage(fabricStorage);
		logger.debug(" 成功添加编号:" + fabricStorage.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return reslut;
	}

	@Override
	public int modifyFabricStorage(FabricStorage fabricStorage, HttpServletRequest request) {
		double fp1 = fabricStorage.getParameter1() == null ? 0 : fabricStorage.getParameter1();// 数据1
		double fp2 = fabricStorage.getParameter2() == null ? 0 : fabricStorage.getParameter2();// 数据1
		double fp3 = fabricStorage.getParameter3() == null ? 0 : fabricStorage.getParameter3();// 数据1
		double fp4 = fabricStorage.getParameter4() == null ? 0 : fabricStorage.getParameter4();// 数据1
		double fp5 = fabricStorage.getParameter5() == null ? 0 : fabricStorage.getParameter5();// 数据1
		double fp6 = fabricStorage.getParameter6() == null ? 0 : fabricStorage.getParameter6();// 数据1
		double fp7 = fabricStorage.getParameter7() == null ? 0 : fabricStorage.getParameter7();// 数据1
		double fp8 = fabricStorage.getParameter8() == null ? 0 : fabricStorage.getParameter8();// 数据1
		double fp9 = fabricStorage.getParameter9() == null ? 0 : fabricStorage.getParameter9();// 数据1
		double fp10 = fabricStorage.getParameter10() == null ? 0 : fabricStorage.getParameter10();// 数据1
		double fp11 = fabricStorage.getParameter11() == null ? 0 : fabricStorage.getParameter11();// 数据1
		double fp12 = fabricStorage.getParameter12() == null ? 0 : fabricStorage.getParameter12();// 数据1
		double fp13 = fabricStorage.getParameter13() == null ? 0 : fabricStorage.getParameter13();// 数据1
		double fp14 = fabricStorage.getParameter14() == null ? 0 : fabricStorage.getParameter14();// 数据1
		double fp15 = fabricStorage.getParameter15() == null ? 0 : fabricStorage.getParameter15();// 数据1
		double fp16 = fabricStorage.getParameter16() == null ? 0 : fabricStorage.getParameter16();// 数据1
		double fp17 = fabricStorage.getParameter17() == null ? 0 : fabricStorage.getParameter17();// 数据1
		double fp18 = fabricStorage.getParameter18() == null ? 0 : fabricStorage.getParameter18();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		fabricStorage.setTotalCount(totalCount);
		fabricStorage.setUpdateTime(DateUtils.formateDaTime(new Date()));
		int reslut = fabricStorageMapper.modifyFabricStorage(fabricStorage);
		logger.debug(" 成功添加编号:" + fabricStorage.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return reslut;
	}

	@Override
	public int delFabricStorage(Integer id, HttpServletRequest request) {
		int reslut = fabricStorageMapper.delFabricStorage(id, DateUtils.formateDaTime(new Date()));
		logger.debug(" 成功添加编号:" + id + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return reslut;
	}

	@Override
	public int getFabricStorageByPageCount(Map<String, Object> anyval) {
		int reslut = fabricStorageMapper.getFabricStorageByPageCount(anyval);
		return reslut;
	}

	@Override
	public List<FabricStorage> findConditionFabricStorageByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<FabricStorage> list = fabricStorageMapper.findConditionFabricStorageByPage(anyVal);
		return list;
	}

	@Override
	public FabricStorage getFabricStorageById(Integer id) {
		FabricStorage fabricStorage = fabricStorageMapper.getFabricStorageById(id);
		return fabricStorage;
	}

	@Override
	public int updateFabricStorageByTotal(FabricStorage fs, HttpServletRequest request) {
		int reslut = fabricStorageMapper.modifyFabricStorage(fs);
		if (reslut > 0) {
			FabricStorage fabricStorage = fabricStorageMapper.getFabricStorageById(fs.getId());
			double fp1 = fabricStorage.getParameter1() == null ? 0 : fabricStorage.getParameter1();// 数据1
			double fp2 = fabricStorage.getParameter2() == null ? 0 : fabricStorage.getParameter2();// 数据1
			double fp3 = fabricStorage.getParameter3() == null ? 0 : fabricStorage.getParameter3();// 数据1
			double fp4 = fabricStorage.getParameter4() == null ? 0 : fabricStorage.getParameter4();// 数据1
			double fp5 = fabricStorage.getParameter5() == null ? 0 : fabricStorage.getParameter5();// 数据1
			double fp6 = fabricStorage.getParameter6() == null ? 0 : fabricStorage.getParameter6();// 数据1
			double fp7 = fabricStorage.getParameter7() == null ? 0 : fabricStorage.getParameter7();// 数据1
			double fp8 = fabricStorage.getParameter8() == null ? 0 : fabricStorage.getParameter8();// 数据1
			double fp9 = fabricStorage.getParameter9() == null ? 0 : fabricStorage.getParameter9();// 数据1
			double fp10 = fabricStorage.getParameter10() == null ? 0 : fabricStorage.getParameter10();// 数据1
			double fp11 = fabricStorage.getParameter11() == null ? 0 : fabricStorage.getParameter11();// 数据1
			double fp12 = fabricStorage.getParameter12() == null ? 0 : fabricStorage.getParameter12();// 数据1
			double fp13 = fabricStorage.getParameter13() == null ? 0 : fabricStorage.getParameter13();// 数据1
			double fp14 = fabricStorage.getParameter14() == null ? 0 : fabricStorage.getParameter14();// 数据1
			double fp15 = fabricStorage.getParameter15() == null ? 0 : fabricStorage.getParameter15();// 数据1
			double fp16 = fabricStorage.getParameter16() == null ? 0 : fabricStorage.getParameter16();// 数据1
			double fp17 = fabricStorage.getParameter17() == null ? 0 : fabricStorage.getParameter17();// 数据1
			double fp18 = fabricStorage.getParameter18() == null ? 0 : fabricStorage.getParameter18();// 数据1
			int totalCount = 0;// 个数 如果什么都没就是0
			// Map criticalMap = new HashMap<>(); // 好
			double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16,
					fp17, fp18 };// 数组
			for (double i : arr) {
				if (i != 0) {
					totalCount = totalCount + 1;// 循环得到个数
				}
			}
			fabricStorage.setTotalCount(totalCount);
			fabricStorage.setUpdateTime(DateUtils.formateDaTime(new Date()));
			int reslut1 = fabricStorageMapper.modifyFabricStorage(fabricStorage);
			logger.debug(" 成功添加编号:" + fabricStorage.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
			return reslut1;
		} else {
			return 5;
		}
	}

	@Override
	public int updateFabricStorageByCompleteStatus(FabricStorage fabricStorage, HttpServletRequest request) {
		fabricStorage.setFabricStorageState("1");
		fabricStorage.setConfirmStorageTime(DateUtils.formateDaTime(new Date()));
		int reslut = fabricStorageMapper.updateFabricStorageByCompleteStatus(fabricStorage);
		logger.debug(" 成功添加编号:" + fabricStorage.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
		return reslut;
	}

}

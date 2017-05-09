package com.warehouse.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricOutflowMapper;
import com.warehouse.entity.FabricOutflow;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

@Service
public class FabricOutflowServiceImpl implements FabricOutflowService {
	private Logger logger = LoggerFactory.getLogger(FabricOutflowServiceImpl.class);

	@Resource
	public FabricOutflowMapper fabricOutflowMapper;

	@Override
	public int addFabricOutflow(FabricOutflow fabricOutflow, HttpServletRequest request) {
		double fp1 = fabricOutflow.getParameter1() == null ? 0 : fabricOutflow.getParameter1();// 数据1
		double fp2 = fabricOutflow.getParameter2() == null ? 0 : fabricOutflow.getParameter2();// 数据2
		double fp3 = fabricOutflow.getParameter3() == null ? 0 : fabricOutflow.getParameter3();// 数据3
		double fp4 = fabricOutflow.getParameter4() == null ? 0 : fabricOutflow.getParameter4();// 数据4
		double fp5 = fabricOutflow.getParameter5() == null ? 0 : fabricOutflow.getParameter5();// 数据5
		double fp6 = fabricOutflow.getParameter6() == null ? 0 : fabricOutflow.getParameter6();// 数据6
		double fp7 = fabricOutflow.getParameter7() == null ? 0 : fabricOutflow.getParameter7();// 数据7
		double fp8 = fabricOutflow.getParameter8() == null ? 0 : fabricOutflow.getParameter8();// 数据8
		double fp9 = fabricOutflow.getParameter9() == null ? 0 : fabricOutflow.getParameter9();// 数据9
		double fp10 = fabricOutflow.getParameter10() == null ? 0 : fabricOutflow.getParameter10();// 数据10
		double fp11 = fabricOutflow.getParameter11() == null ? 0 : fabricOutflow.getParameter11();// 数据11
		double fp12 = fabricOutflow.getParameter12() == null ? 0 : fabricOutflow.getParameter12();// 数据12
		double fp13 = fabricOutflow.getParameter13() == null ? 0 : fabricOutflow.getParameter13();// 数据13
		double fp14 = fabricOutflow.getParameter14() == null ? 0 : fabricOutflow.getParameter14();// 数据14
		double fp15 = fabricOutflow.getParameter15() == null ? 0 : fabricOutflow.getParameter15();// 数据15
		double fp16 = fabricOutflow.getParameter16() == null ? 0 : fabricOutflow.getParameter16();// 数据16
		double fp17 = fabricOutflow.getParameter17() == null ? 0 : fabricOutflow.getParameter17();// 数据17
		double fp18 = fabricOutflow.getParameter18() == null ? 0 : fabricOutflow.getParameter18();// 数据18
		double fp19 = fabricOutflow.getParameter19() == null ? 0 : fabricOutflow.getParameter19();// 数据19
		double fp20 = fabricOutflow.getParameter20() == null ? 0 : fabricOutflow.getParameter20();// 数据20
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18, fp19, fp20 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		BigDecimal b1 = new BigDecimal(Double.toString(fp1));
		BigDecimal b2 = new BigDecimal(Double.toString(fp2));
		BigDecimal b3 = new BigDecimal(Double.toString(fp3));
		BigDecimal b4 = new BigDecimal(Double.toString(fp4));
		BigDecimal b5 = new BigDecimal(Double.toString(fp5));
		BigDecimal b6 = new BigDecimal(Double.toString(fp6));
		BigDecimal b7 = new BigDecimal(Double.toString(fp7));
		BigDecimal b8 = new BigDecimal(Double.toString(fp8));
		BigDecimal b9 = new BigDecimal(Double.toString(fp9));
		BigDecimal b10 = new BigDecimal(Double.toString(fp10));
		BigDecimal b11 = new BigDecimal(Double.toString(fp11));
		BigDecimal b12 = new BigDecimal(Double.toString(fp12));
		BigDecimal b13 = new BigDecimal(Double.toString(fp13));
		BigDecimal b14 = new BigDecimal(Double.toString(fp14));
		BigDecimal b15 = new BigDecimal(Double.toString(fp15));
		BigDecimal b16 = new BigDecimal(Double.toString(fp16));
		BigDecimal b17 = new BigDecimal(Double.toString(fp17));
		BigDecimal b18 = new BigDecimal(Double.toString(fp18));
		BigDecimal b19 = new BigDecimal(Double.toString(fp19));
		BigDecimal b20 = new BigDecimal(Double.toString(fp20));
		// 总个数
		BigDecimal num = b1.add(b2).add(b3).add(b4).add(b5).add(b6).add(b7).add(b8).add(b9).add(b10).add(b11).add(b12)
				.add(b13).add(b14).add(b15).add(b16).add(b17).add(b18).add(b19).add(b20);
		// 乘单价
		BigDecimal totalPrice = num.multiply(fabricOutflow.getFabricPrices());

		fabricOutflow.setTotalPrice(totalPrice);
		fabricOutflow.setTotalCount(totalCount);
		fabricOutflow.setAddTime(DateUtils.formateDaTime(new Date()));
		fabricOutflow.setState("1");// 状态
		int result = fabricOutflowMapper.addFabricOutflow(fabricOutflow);
		logger.debug("成功操作波次:" + fabricOutflow.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return result;
	}

	@Override
	public int modifyFabricOutflow(FabricOutflow fabricOutflow, HttpServletRequest request) {
		double fp1 = fabricOutflow.getParameter1() == null ? 0 : fabricOutflow.getParameter1();// 数据1
		double fp2 = fabricOutflow.getParameter2() == null ? 0 : fabricOutflow.getParameter2();// 数据1
		double fp3 = fabricOutflow.getParameter3() == null ? 0 : fabricOutflow.getParameter3();// 数据1
		double fp4 = fabricOutflow.getParameter4() == null ? 0 : fabricOutflow.getParameter4();// 数据1
		double fp5 = fabricOutflow.getParameter5() == null ? 0 : fabricOutflow.getParameter5();// 数据1
		double fp6 = fabricOutflow.getParameter6() == null ? 0 : fabricOutflow.getParameter6();// 数据1
		double fp7 = fabricOutflow.getParameter7() == null ? 0 : fabricOutflow.getParameter7();// 数据1
		double fp8 = fabricOutflow.getParameter8() == null ? 0 : fabricOutflow.getParameter8();// 数据1
		double fp9 = fabricOutflow.getParameter9() == null ? 0 : fabricOutflow.getParameter9();// 数据1
		double fp10 = fabricOutflow.getParameter10() == null ? 0 : fabricOutflow.getParameter10();// 数据1
		double fp11 = fabricOutflow.getParameter11() == null ? 0 : fabricOutflow.getParameter11();// 数据1
		double fp12 = fabricOutflow.getParameter12() == null ? 0 : fabricOutflow.getParameter12();// 数据1
		double fp13 = fabricOutflow.getParameter13() == null ? 0 : fabricOutflow.getParameter13();// 数据1
		double fp14 = fabricOutflow.getParameter14() == null ? 0 : fabricOutflow.getParameter14();// 数据1
		double fp15 = fabricOutflow.getParameter15() == null ? 0 : fabricOutflow.getParameter15();// 数据1
		double fp16 = fabricOutflow.getParameter16() == null ? 0 : fabricOutflow.getParameter16();// 数据1
		double fp17 = fabricOutflow.getParameter17() == null ? 0 : fabricOutflow.getParameter17();// 数据1
		double fp18 = fabricOutflow.getParameter18() == null ? 0 : fabricOutflow.getParameter18();// 数据1
		double fp19 = fabricOutflow.getParameter19() == null ? 0 : fabricOutflow.getParameter19();// 数据1
		double fp20 = fabricOutflow.getParameter20() == null ? 0 : fabricOutflow.getParameter20();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18, fp19, fp20 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		fabricOutflow.setTotalCount(totalCount);
		fabricOutflow.setUpdateTime(DateUtils.formateDaTime(new Date()));
		int result = fabricOutflowMapper.modifyFabricOutflow(fabricOutflow);
		logger.debug("成功修改操作波次:" + fabricOutflow.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return result;
	}

	@Override
	public int delFabricOutflow(Integer id, HttpServletRequest request) {
		int result = fabricOutflowMapper.delFabricOutflow(id, DateUtils.formateDaTime(new Date()));
		logger.debug("成功删除操作波次:" + id + "操作者ip为:" + ClientIpUtil.getIpAddress(request));

		return result;
	}

	@Override
	public int getFabricOutflowByPageCount(Map<String, Object> anyval) {
		int result = fabricOutflowMapper.getFabricOutflowByPageCount(anyval);
		return result;
	}

	@Override
	public List<FabricOutflow> findConditionFabricOutflowByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<FabricOutflow> list = fabricOutflowMapper.findConditionFabricOutflowByPage(anyVal);

		return list;
	}

	@Override
	public FabricOutflow getFabricOutflowById(Integer id) {
		FabricOutflow fabricOutflow = fabricOutflowMapper.getFabricOutflowById(id);
		return fabricOutflow;
	}

	@Override
	public int updateFabricOutflowByCompleteStatus(FabricOutflow fo, HttpServletRequest request) {
		int result = fabricOutflowMapper.modifyFabricOutflow(fo);
		if (result > 0) {
			FabricOutflow fabricOutflow = fabricOutflowMapper.getFabricOutflowById(fo.getId());
			double fp1 = fabricOutflow.getParameter1() == null ? 0 : fabricOutflow.getParameter1();// 数据1
			double fp2 = fabricOutflow.getParameter2() == null ? 0 : fabricOutflow.getParameter2();// 数据1
			double fp3 = fabricOutflow.getParameter3() == null ? 0 : fabricOutflow.getParameter3();// 数据1
			double fp4 = fabricOutflow.getParameter4() == null ? 0 : fabricOutflow.getParameter4();// 数据1
			double fp5 = fabricOutflow.getParameter5() == null ? 0 : fabricOutflow.getParameter5();// 数据1
			double fp6 = fabricOutflow.getParameter6() == null ? 0 : fabricOutflow.getParameter6();// 数据1
			double fp7 = fabricOutflow.getParameter7() == null ? 0 : fabricOutflow.getParameter7();// 数据1
			double fp8 = fabricOutflow.getParameter8() == null ? 0 : fabricOutflow.getParameter8();// 数据1
			double fp9 = fabricOutflow.getParameter9() == null ? 0 : fabricOutflow.getParameter9();// 数据1
			double fp10 = fabricOutflow.getParameter10() == null ? 0 : fabricOutflow.getParameter10();// 数据1
			double fp11 = fabricOutflow.getParameter11() == null ? 0 : fabricOutflow.getParameter11();// 数据1
			double fp12 = fabricOutflow.getParameter12() == null ? 0 : fabricOutflow.getParameter12();// 数据1
			double fp13 = fabricOutflow.getParameter13() == null ? 0 : fabricOutflow.getParameter13();// 数据1
			double fp14 = fabricOutflow.getParameter14() == null ? 0 : fabricOutflow.getParameter14();// 数据1
			double fp15 = fabricOutflow.getParameter15() == null ? 0 : fabricOutflow.getParameter15();// 数据1
			double fp16 = fabricOutflow.getParameter16() == null ? 0 : fabricOutflow.getParameter16();// 数据1
			double fp17 = fabricOutflow.getParameter17() == null ? 0 : fabricOutflow.getParameter17();// 数据1
			double fp18 = fabricOutflow.getParameter18() == null ? 0 : fabricOutflow.getParameter18();// 数据1
			double fp19 = fabricOutflow.getParameter19() == null ? 0 : fabricOutflow.getParameter19();// 数据1
			double fp20 = fabricOutflow.getParameter20() == null ? 0 : fabricOutflow.getParameter20();// 数据1
			int totalCount = 0;// 个数 如果什么都没就是0
			// Map criticalMap = new HashMap<>(); // 好
			double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16,
					fp17, fp18, fp19, fp20 };// 数组
			for (double i : arr) {
				if (i != 0) {
					totalCount = totalCount + 1;// 循环得到个数
				}
			}
			fabricOutflow.setTotalCount(totalCount);
			int result1 = fabricOutflowMapper.updateFabricOutflowByCompleteStatus(fabricOutflow);
			logger.debug("成功修改操作波次:" + fabricOutflow.getWave() + "操作者ip为:" + ClientIpUtil.getIpAddress(request));
			return result1;
		}
		return result;
	}

}

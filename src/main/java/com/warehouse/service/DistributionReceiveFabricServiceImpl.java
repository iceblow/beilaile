package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.DistributionReceiveFabricMapper;
import com.warehouse.entity.DistributionReceiveFabric;
import com.warehouse.util.DateUtils;

@Service
public class DistributionReceiveFabricServiceImpl implements DistributionReceiveFabricService {
	@Resource
	public DistributionReceiveFabricMapper distributionReceiveFabricMapper;

	@Override
	public int addDistributionReceiveFabric(DistributionReceiveFabric distributionReceiveFabric) {
		double fp1 = distributionReceiveFabric.getParameter1() == null ? 0 : distributionReceiveFabric.getParameter1();// 数据1
		double fp2 = distributionReceiveFabric.getParameter2() == null ? 0 : distributionReceiveFabric.getParameter2();// 数据1
		double fp3 = distributionReceiveFabric.getParameter3() == null ? 0 : distributionReceiveFabric.getParameter3();// 数据1
		double fp4 = distributionReceiveFabric.getParameter4() == null ? 0 : distributionReceiveFabric.getParameter4();// 数据1
		double fp5 = distributionReceiveFabric.getParameter5() == null ? 0 : distributionReceiveFabric.getParameter5();// 数据1
		double fp6 = distributionReceiveFabric.getParameter6() == null ? 0 : distributionReceiveFabric.getParameter6();// 数据1
		double fp7 = distributionReceiveFabric.getParameter7() == null ? 0 : distributionReceiveFabric.getParameter7();// 数据1
		double fp8 = distributionReceiveFabric.getParameter8() == null ? 0 : distributionReceiveFabric.getParameter8();// 数据1
		double fp9 = distributionReceiveFabric.getParameter9() == null ? 0 : distributionReceiveFabric.getParameter9();// 数据1
		double fp10 = distributionReceiveFabric.getParameter10() == null ? 0 : distributionReceiveFabric.getParameter10();// 数据1
		double fp11 = distributionReceiveFabric.getParameter11() == null ? 0 : distributionReceiveFabric.getParameter11();// 数据1
		double fp12 = distributionReceiveFabric.getParameter12() == null ? 0 : distributionReceiveFabric.getParameter12();// 数据1
		double fp13 = distributionReceiveFabric.getParameter13() == null ? 0 : distributionReceiveFabric.getParameter13();// 数据1
		double fp14 = distributionReceiveFabric.getParameter14() == null ? 0 : distributionReceiveFabric.getParameter14();// 数据1
		double fp15 = distributionReceiveFabric.getParameter15() == null ? 0 : distributionReceiveFabric.getParameter15();// 数据1
		double fp16 = distributionReceiveFabric.getParameter16() == null ? 0 : distributionReceiveFabric.getParameter16();// 数据1
		double fp17 = distributionReceiveFabric.getParameter17() == null ? 0 : distributionReceiveFabric.getParameter17();// 数据1
		double fp18 = distributionReceiveFabric.getParameter18() == null ? 0 : distributionReceiveFabric.getParameter18();// 数据1
		double fp19 = distributionReceiveFabric.getParameter19() == null ? 0 : distributionReceiveFabric.getParameter19();// 数据1
		double fp20 = distributionReceiveFabric.getParameter20() == null ? 0 : distributionReceiveFabric.getParameter20();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18, fp19, fp20 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		distributionReceiveFabric.setTotalCount(totalCount);
		//如果issuedate为空，设为今天
		if(distributionReceiveFabric.getIssueDate()==null ||"".equals(distributionReceiveFabric.getIssueDate())){
			distributionReceiveFabric.setIssueDate(DateUtils.formateDaTime(new Date()));
		}
		distributionReceiveFabric.setAddTime(DateUtils.formateDaTime(new Date()));
		distributionReceiveFabric.setState("1");// 状态
		int reslut = distributionReceiveFabricMapper.addDistributionReceiveFabric(distributionReceiveFabric);

		return reslut;
	}

	@Override
	public int modifyDistributionReceiveFabric(DistributionReceiveFabric distributionReceiveFabric) {
		double fp1 = distributionReceiveFabric.getParameter1() == null ? 0 : distributionReceiveFabric.getParameter1();// 数据1
		double fp2 = distributionReceiveFabric.getParameter2() == null ? 0 : distributionReceiveFabric.getParameter2();// 数据1
		double fp3 = distributionReceiveFabric.getParameter3() == null ? 0 : distributionReceiveFabric.getParameter3();// 数据1
		double fp4 = distributionReceiveFabric.getParameter4() == null ? 0 : distributionReceiveFabric.getParameter4();// 数据1
		double fp5 = distributionReceiveFabric.getParameter5() == null ? 0 : distributionReceiveFabric.getParameter5();// 数据1
		double fp6 = distributionReceiveFabric.getParameter6() == null ? 0 : distributionReceiveFabric.getParameter6();// 数据1
		double fp7 = distributionReceiveFabric.getParameter7() == null ? 0 : distributionReceiveFabric.getParameter7();// 数据1
		double fp8 = distributionReceiveFabric.getParameter8() == null ? 0 : distributionReceiveFabric.getParameter8();// 数据1
		double fp9 = distributionReceiveFabric.getParameter9() == null ? 0 : distributionReceiveFabric.getParameter9();// 数据1
		double fp10 = distributionReceiveFabric.getParameter10() == null ? 0 : distributionReceiveFabric.getParameter10();// 数据1
		double fp11 = distributionReceiveFabric.getParameter11() == null ? 0 : distributionReceiveFabric.getParameter11();// 数据1
		double fp12 = distributionReceiveFabric.getParameter12() == null ? 0 : distributionReceiveFabric.getParameter12();// 数据1
		double fp13 = distributionReceiveFabric.getParameter13() == null ? 0 : distributionReceiveFabric.getParameter13();// 数据1
		double fp14 = distributionReceiveFabric.getParameter14() == null ? 0 : distributionReceiveFabric.getParameter14();// 数据1
		double fp15 = distributionReceiveFabric.getParameter15() == null ? 0 : distributionReceiveFabric.getParameter15();// 数据1
		double fp16 = distributionReceiveFabric.getParameter16() == null ? 0 : distributionReceiveFabric.getParameter16();// 数据1
		double fp17 = distributionReceiveFabric.getParameter17() == null ? 0 : distributionReceiveFabric.getParameter17();// 数据1
		double fp18 = distributionReceiveFabric.getParameter18() == null ? 0 : distributionReceiveFabric.getParameter18();// 数据1
		double fp19 = distributionReceiveFabric.getParameter19() == null ? 0 : distributionReceiveFabric.getParameter19();// 数据1
		double fp20 = distributionReceiveFabric.getParameter20() == null ? 0 : distributionReceiveFabric.getParameter20();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18, fp19, fp20 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		distributionReceiveFabric.setTotalCount(totalCount);
		distributionReceiveFabric.setUpdateTime(DateUtils.formateDaTime(new Date()));
		int reslut = distributionReceiveFabricMapper.modifyDistributionReceiveFabric(distributionReceiveFabric);

		return reslut;
	}

	@Override
	public int delDistributionReceiveFabricById(Integer id) {
		int reslut = distributionReceiveFabricMapper.delDistributionReceiveFabricById(id, DateUtils.formateDaTime(new Date()));

		return reslut;
	}

	@Override
	public int getDistributionReceiveFabricByPageCount(Map<String, Object> anyVal) {
		int reslut = distributionReceiveFabricMapper.getDistributionReceiveFabricByPageCount(anyVal);

		return reslut;
	}

	@Override
	public List<DistributionReceiveFabric> findConditionDistributionReceiveFabricByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<DistributionReceiveFabric> list = distributionReceiveFabricMapper.findConditionDistributionReceiveFabricByPage(anyVal);
		return list;
	}

	@Override
	public DistributionReceiveFabric getDistributionReceiveFabricById(Integer id) {
		DistributionReceiveFabric distributionReceiveFabric = distributionReceiveFabricMapper.getDistributionReceiveFabricById(id);
		return distributionReceiveFabric;
	}

	@Override
	public int updateDistributionReceiveFabricByCompleteStatus(DistributionReceiveFabric distributionReceiveFabric) {
		distributionReceiveFabric.setUpdateTime(DateUtils.formateDaTime(new Date()));
		distributionReceiveFabric.setFulfilStatus("1");// 状态
		int reslut = distributionReceiveFabricMapper.updateDistributionReceiveFabricByCompleteStatus(distributionReceiveFabric);
		return reslut;
	}

}

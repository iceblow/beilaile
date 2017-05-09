package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricReturnBackMapper;
import com.warehouse.entity.FabricReturnBack;

@Service
public class FabricReturnBackServiceImpl implements FabricReturnBackService {
	@Resource
	public FabricReturnBackMapper fabricReturnBackMapper;

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);// 时间格式化

	@Override
	public int addFabricReturnBack(FabricReturnBack fabricReturnBack) {
		double fp1 = fabricReturnBack.getParameter1() == null ? 0 : fabricReturnBack.getParameter1();// 数据1
		double fp2 = fabricReturnBack.getParameter2() == null ? 0 : fabricReturnBack.getParameter2();// 数据1
		double fp3 = fabricReturnBack.getParameter3() == null ? 0 : fabricReturnBack.getParameter3();// 数据1
		double fp4 = fabricReturnBack.getParameter4() == null ? 0 : fabricReturnBack.getParameter4();// 数据1
		double fp5 = fabricReturnBack.getParameter5() == null ? 0 : fabricReturnBack.getParameter5();// 数据1
		double fp6 = fabricReturnBack.getParameter6() == null ? 0 : fabricReturnBack.getParameter6();// 数据1
		double fp7 = fabricReturnBack.getParameter7() == null ? 0 : fabricReturnBack.getParameter7();// 数据1
		double fp8 = fabricReturnBack.getParameter8() == null ? 0 : fabricReturnBack.getParameter8();// 数据1
		double fp9 = fabricReturnBack.getParameter9() == null ? 0 : fabricReturnBack.getParameter9();// 数据1
		double fp10 = fabricReturnBack.getParameter10() == null ? 0 : fabricReturnBack.getParameter10();// 数据1
		double fp11 = fabricReturnBack.getParameter11() == null ? 0 : fabricReturnBack.getParameter11();// 数据1
		double fp12 = fabricReturnBack.getParameter12() == null ? 0 : fabricReturnBack.getParameter12();// 数据1
		double fp13 = fabricReturnBack.getParameter13() == null ? 0 : fabricReturnBack.getParameter13();// 数据1
		double fp14 = fabricReturnBack.getParameter14() == null ? 0 : fabricReturnBack.getParameter14();// 数据1
		double fp15 = fabricReturnBack.getParameter15() == null ? 0 : fabricReturnBack.getParameter15();// 数据1
		double fp16 = fabricReturnBack.getParameter16() == null ? 0 : fabricReturnBack.getParameter16();// 数据1
		double fp17 = fabricReturnBack.getParameter17() == null ? 0 : fabricReturnBack.getParameter17();// 数据1
		double fp18 = fabricReturnBack.getParameter18() == null ? 0 : fabricReturnBack.getParameter18();// 数据1
		double fp19 = fabricReturnBack.getParameter19() == null ? 0 : fabricReturnBack.getParameter19();// 数据1
		double fp20 = fabricReturnBack.getParameter20() == null ? 0 : fabricReturnBack.getParameter20();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18, fp19, fp20 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		fabricReturnBack.setTotalAmount(totalCount);
		String addTime = formatter.format(new Date());// 操作时间
		fabricReturnBack.setAddTime(addTime);
		fabricReturnBack.setDataState("1");// 状态
		int result = fabricReturnBackMapper.addFabricOutflow(fabricReturnBack);
		return result;
	}

	@Override
	public int modifyFabricOutflow(FabricReturnBack fabricReturnBack) {
		double fp1 = fabricReturnBack.getParameter1() == null ? 0 : fabricReturnBack.getParameter1();// 数据1
		double fp2 = fabricReturnBack.getParameter2() == null ? 0 : fabricReturnBack.getParameter2();// 数据1
		double fp3 = fabricReturnBack.getParameter3() == null ? 0 : fabricReturnBack.getParameter3();// 数据1
		double fp4 = fabricReturnBack.getParameter4() == null ? 0 : fabricReturnBack.getParameter4();// 数据1
		double fp5 = fabricReturnBack.getParameter5() == null ? 0 : fabricReturnBack.getParameter5();// 数据1
		double fp6 = fabricReturnBack.getParameter6() == null ? 0 : fabricReturnBack.getParameter6();// 数据1
		double fp7 = fabricReturnBack.getParameter7() == null ? 0 : fabricReturnBack.getParameter7();// 数据1
		double fp8 = fabricReturnBack.getParameter8() == null ? 0 : fabricReturnBack.getParameter8();// 数据1
		double fp9 = fabricReturnBack.getParameter9() == null ? 0 : fabricReturnBack.getParameter9();// 数据1
		double fp10 = fabricReturnBack.getParameter10() == null ? 0 : fabricReturnBack.getParameter10();// 数据1
		double fp11 = fabricReturnBack.getParameter11() == null ? 0 : fabricReturnBack.getParameter11();// 数据1
		double fp12 = fabricReturnBack.getParameter12() == null ? 0 : fabricReturnBack.getParameter12();// 数据1
		double fp13 = fabricReturnBack.getParameter13() == null ? 0 : fabricReturnBack.getParameter13();// 数据1
		double fp14 = fabricReturnBack.getParameter14() == null ? 0 : fabricReturnBack.getParameter14();// 数据1
		double fp15 = fabricReturnBack.getParameter15() == null ? 0 : fabricReturnBack.getParameter15();// 数据1
		double fp16 = fabricReturnBack.getParameter16() == null ? 0 : fabricReturnBack.getParameter16();// 数据1
		double fp17 = fabricReturnBack.getParameter17() == null ? 0 : fabricReturnBack.getParameter17();// 数据1
		double fp18 = fabricReturnBack.getParameter18() == null ? 0 : fabricReturnBack.getParameter18();// 数据1
		double fp19 = fabricReturnBack.getParameter19() == null ? 0 : fabricReturnBack.getParameter19();// 数据1
		double fp20 = fabricReturnBack.getParameter20() == null ? 0 : fabricReturnBack.getParameter20();// 数据1
		int totalCount = 0;// 个数 如果什么都没就是0
		// Map criticalMap = new HashMap<>(); // 好
		double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16, fp17,
				fp18, fp19, fp20 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalCount = totalCount + 1;// 循环得到个数
			}
		}
		fabricReturnBack.setTotalAmount(totalCount);
		String updateTime = formatter.format(new Date());// 操作时间
		fabricReturnBack.setUpdateTime(updateTime);
		int result = fabricReturnBackMapper.modifyFabricOutflow(fabricReturnBack);
		return result;
	}

	//删除数据
	@Override
	public int delFabricOutflow(Integer id) {
		String deleteTime = formatter.format(new Date());
		int result = fabricReturnBackMapper.delFabricOutflow(id, deleteTime);
		return result;
	}

	@Override
	public int getFabricOutflowByPageCount(Map<String, Object> anyval) {
		int result = fabricReturnBackMapper.getFabricOutflowByPageCount(anyval);
		return result;
	}

	@Override
	public List<FabricReturnBack> findConditionFabricOutflowByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<FabricReturnBack> list = fabricReturnBackMapper.findConditionFabricOutflowByPage(anyVal);
		return list;
	}

	@Override
	public FabricReturnBack getFabricOutflowById(Integer id) {
		FabricReturnBack fabricReturnBack = fabricReturnBackMapper.getFabricOutflowById(id);
		return fabricReturnBack;
	}

	@Override
	public int updateFabricOutflowByCompleteStatus(FabricReturnBack fo, HttpRequest httpRequest) {
		int result = fabricReturnBackMapper.modifyFabricOutflow(fo);
		if (result > 0) {
			FabricReturnBack fabricReturnBack = fabricReturnBackMapper.getFabricOutflowById(fo.getId());
			double fp1 = fabricReturnBack.getParameter1() == null ? 0 : fabricReturnBack.getParameter1();// 数据1
			double fp2 = fabricReturnBack.getParameter2() == null ? 0 : fabricReturnBack.getParameter2();// 数据1
			double fp3 = fabricReturnBack.getParameter3() == null ? 0 : fabricReturnBack.getParameter3();// 数据1
			double fp4 = fabricReturnBack.getParameter4() == null ? 0 : fabricReturnBack.getParameter4();// 数据1
			double fp5 = fabricReturnBack.getParameter5() == null ? 0 : fabricReturnBack.getParameter5();// 数据1
			double fp6 = fabricReturnBack.getParameter6() == null ? 0 : fabricReturnBack.getParameter6();// 数据1
			double fp7 = fabricReturnBack.getParameter7() == null ? 0 : fabricReturnBack.getParameter7();// 数据1
			double fp8 = fabricReturnBack.getParameter8() == null ? 0 : fabricReturnBack.getParameter8();// 数据1
			double fp9 = fabricReturnBack.getParameter9() == null ? 0 : fabricReturnBack.getParameter9();// 数据1
			double fp10 = fabricReturnBack.getParameter10() == null ? 0 : fabricReturnBack.getParameter10();// 数据1
			double fp11 = fabricReturnBack.getParameter11() == null ? 0 : fabricReturnBack.getParameter11();// 数据1
			double fp12 = fabricReturnBack.getParameter12() == null ? 0 : fabricReturnBack.getParameter12();// 数据1
			double fp13 = fabricReturnBack.getParameter13() == null ? 0 : fabricReturnBack.getParameter13();// 数据1
			double fp14 = fabricReturnBack.getParameter14() == null ? 0 : fabricReturnBack.getParameter14();// 数据1
			double fp15 = fabricReturnBack.getParameter15() == null ? 0 : fabricReturnBack.getParameter15();// 数据1
			double fp16 = fabricReturnBack.getParameter16() == null ? 0 : fabricReturnBack.getParameter16();// 数据1
			double fp17 = fabricReturnBack.getParameter17() == null ? 0 : fabricReturnBack.getParameter17();// 数据1
			double fp18 = fabricReturnBack.getParameter18() == null ? 0 : fabricReturnBack.getParameter18();// 数据1
			double fp19 = fabricReturnBack.getParameter19() == null ? 0 : fabricReturnBack.getParameter19();// 数据1
			double fp20 = fabricReturnBack.getParameter20() == null ? 0 : fabricReturnBack.getParameter20();// 数据1
			int totalCount = 0;// 个数 如果什么都没就是0
			// Map criticalMap = new HashMap<>(); // 好
			double arr[] = { fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12, fp13, fp14, fp15, fp16,
					fp17, fp18, fp19, fp20 };// 数组
			for (double i : arr) {
				if (i != 0) {
					totalCount = totalCount + 1;// 循环得到个数
				}
			}
			fabricReturnBack.setTotalAmount(totalCount);
			int result1 = fabricReturnBackMapper.updateFabricOutflowByCompleteStatus(fabricReturnBack);
			return result1;
		}
		return result;
	}

	@Override
	public int updateColourById(FabricReturnBack fabricReturnBack) {
		
		return  fabricReturnBackMapper.updateColourById(fabricReturnBack);
	}

}

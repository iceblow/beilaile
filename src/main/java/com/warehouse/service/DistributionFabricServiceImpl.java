package com.warehouse.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.DistributionFabricMapper;
import com.warehouse.entity.DistributionFabric;
import com.warehouse.util.DateUtils;

@Service
public class DistributionFabricServiceImpl implements DistributionFabricService {
	@Resource
	public DistributionFabricMapper distributionFabricMapper;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 查询分页
	 */
	@Override
	public List<DistributionFabric> findDistributionFabricPageByVal(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<DistributionFabric> list = distributionFabricMapper.findDistributionFabricPageByVal(anyVal);
		return list;
	}

	/**
	 * 查询总条数
	 */
	@Override
	public int getDistributionFabricTotalPageByVal(Map<String, Object> anyval) {
		int result = distributionFabricMapper.getDistributionFabricTotalPageByVal(anyval);
		return result;
	}

	/**
	 * 修改
	 */
	@Override
	public int modifyDistributionFabric(DistributionFabric distributionFabric) {
		double fb1 = distributionFabric.getFabric1() == null ? 0 : distributionFabric.getFabric1();// 数据1
		double fb2 = distributionFabric.getFabric2() == null ? 0 : distributionFabric.getFabric2();// 数据1
		double fb3 = distributionFabric.getFabric3() == null ? 0 : distributionFabric.getFabric3();// 数据1
		double fb4 = distributionFabric.getFabric4() == null ? 0 : distributionFabric.getFabric4();// 数据1
		double fb5 = distributionFabric.getFabric5() == null ? 0 : distributionFabric.getFabric5();// 数据1
		double fb6 = distributionFabric.getFabric6() == null ? 0 : distributionFabric.getFabric6();// 数据1
		double fb7 = distributionFabric.getFabric7() == null ? 0 : distributionFabric.getFabric7();// 数据1
		// Map criticalMap = new HashMap<>(); // 好
		double total = (fb1 + fb2 + fb3 + fb4 + fb5 + fb6 + fb7);// 合计
		int totalNumber = 0;// 个数 如果什么都没就是0
		double arr[] = { fb1, fb2, fb3, fb4, fb5, fb6, fb7 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalNumber = totalNumber + 1;// 循环得到个数
			}
		}
		// 单价
		BigDecimal price = new BigDecimal(
				distributionFabric.getUnitprice().equals(null) || distributionFabric.getUnitprice().equals("") ? 0
						: distributionFabric.getUnitprice());
		BigDecimal amount = BigDecimal.valueOf(total).multiply(price);// 方法1 好
		// BigDecimal amount = new BigDecimal(total*price.doubleValue());//方法2
		String updateTime = formatter.format(new Date());// 添加时间
		distributionFabric.setTotal(total);// 合计
		distributionFabric.setTotalNumber(totalNumber);// 个数
		distributionFabric.setAmount(amount);// 金额
		distributionFabric.setUpdateTime(updateTime);// 修改操作时间
		int result = distributionFabricMapper.modifyDistributionFabric(distributionFabric);
		return result;
	}

	/**
	 * 添加
	 */
	@Override
	public int addDistributionFabric(DistributionFabric distributionFabric) {
		double fb1 = distributionFabric.getFabric1() == null ? 0 : distributionFabric.getFabric1();// 数据1
		double fb2 = distributionFabric.getFabric2() == null ? 0 : distributionFabric.getFabric2();// 数据1
		double fb3 = distributionFabric.getFabric3() == null ? 0 : distributionFabric.getFabric3();// 数据1
		double fb4 = distributionFabric.getFabric4() == null ? 0 : distributionFabric.getFabric4();// 数据1
		double fb5 = distributionFabric.getFabric5() == null ? 0 : distributionFabric.getFabric5();// 数据1
		double fb6 = distributionFabric.getFabric6() == null ? 0 : distributionFabric.getFabric6();// 数据1
		double fb7 = distributionFabric.getFabric7() == null ? 0 : distributionFabric.getFabric7();// 数据1
		// Map criticalMap = new HashMap<>(); // 好
		double total = (fb1 + fb2 + fb3 + fb4 + fb5 + fb6 + fb7);// 合计
		int totalNumber = 0;// 个数 如果什么都没就是0
		double arr[] = { fb1, fb2, fb3, fb4, fb5, fb6, fb7 };// 数组
		for (double i : arr) {
			if (i != 0) {
				totalNumber = totalNumber + 1;// 循环得到个数
			}
		}
		// 单价
		BigDecimal price = new BigDecimal(
				distributionFabric.getUnitprice().equals(null) || distributionFabric.getUnitprice().equals("") ? 0
						: distributionFabric.getUnitprice());
		BigDecimal amount = BigDecimal.valueOf(total).multiply(price);// 方法1 好
		// BigDecimal amount = new BigDecimal(total*price.doubleValue());//方法2
		String addTime = formatter.format(new Date());// 添加时间
		distributionFabric.setTotal(total);// 合计
		distributionFabric.setTotalNumber(totalNumber);// 个数
		distributionFabric.setAmount(amount);// 金额
		distributionFabric.setAddTime(addTime);// 修改操作时间
		distributionFabric.setState("1");
		int result = distributionFabricMapper.addDistributionFabric(distributionFabric);
		return result;
	}

	/**
	 * 删除
	 */
	@Override
	public int delByDistributionFabric(int id) {
		String delTime = formatter.format(new Date());
		int result = distributionFabricMapper.delByDistributionFabric(id, delTime);
		return result;
	}

	@Override
	public DistributionFabric getDistributionFabricById(Integer id) {
		DistributionFabric distributionFabric = distributionFabricMapper.getDistributionFabricById(id);
		return distributionFabric;
	}

	@Override
	public int modifyDistributionFabricIssuedStatus(DistributionFabric distributionFabric) {
		distributionFabric.setIssuedStatus("2");
		distributionFabric.setUpdateTime(DateUtils.formateDaTime(new Date()));
		int result = distributionFabricMapper.modifyDistributionFabricIssuedStatus(distributionFabric);
		return result;
	}

}

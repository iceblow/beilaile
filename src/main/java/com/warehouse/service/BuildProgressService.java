package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.warehouse.entity.BuildProgress;

/**
 * Created by MQ on 2016/10/10.
 */
public interface BuildProgressService {
	// 条件对象
	int insert(BuildProgress record,HttpServletRequest request);

	// 修改对象
	int modifyByBuildProgress(BuildProgress buildProgress,HttpServletRequest request);

	// 根据id删除一条数据 保存删除时间
	int delByPrimaryKey(String wave,HttpServletRequest request);

	// 带条件查询分页
	List<BuildProgress> findByAnyValPage(Map<String, Object> anyval);

	// 带条件查询总条数
	int getAnyVaTotalPageCount(Map<String, Object> anyval);

	// 总订单数
	Integer getAnyValSumOrderNumber(Map<String, Object> anyval);

	// 根据波茨号查询
	BuildProgress getModifyBuildProgressByWave(String Wave);

}

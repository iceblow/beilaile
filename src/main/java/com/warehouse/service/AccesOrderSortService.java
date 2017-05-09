package com.warehouse.service;

import com.warehouse.entity.AccesOrderSort;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/1/20.
 *
 */

public interface AccesOrderSortService {

    int getAccesOrderSortBpcnt(Map<String, Object> param);

    List<AccesOrderSort> findAccesOrderSortCndbp(Map<String, Object> param);

    AccesOrderSort getAccesOrderSortBid(Integer id, HttpServletRequest request);

    //更新理单参数
    AccesOrderSort savaOrderSortUpdate(AccesOrderSort am, HttpServletRequest request);

    AccesOrderSort savaOrderSortFill(AccesOrderSort am, HttpServletRequest request);

    //获取 辅料未配齐 数据
    int orderRationWaitBpcnt(Map<String, Object> param);

    List<AccesOrderSort> orderRationWait(Map<String, Object> param);

    //获取 辅料已配齐 数据
    int orderRationReadyBpcnt(Map<String, Object> param);

    List<AccesOrderSort> orderRationReady(Map<String, Object> param);

    //获取 辅料未配齐 数据
    int orderRationSpecBpcnt(Map<String, Object> param);

    List<AccesOrderSort> orderRationSpec(Map<String, Object> param);

    //查询 跟单环节数据
    int orderFollowBpcnt(Map<String, Object> param);

    List<AccesOrderSort> orderFollowList(Map<String, Object> param);

    //保存辅料状态
    AccesOrderSort savaOrderSortStatus(AccesOrderSort am, HttpServletRequest request);

    AccesOrderSort layerSort(AccesOrderSort am, HttpServletRequest request);
}

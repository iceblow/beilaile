package com.warehouse.service;

import com.warehouse.entity.AccesOrderFollow;
import com.warehouse.entity.AccesOrderSort;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/1/20.
 *
 */

public interface AccesOrderFollowService {

    int getAccesOrderFollowBpcnt(Map<String, Object> param);

    List<AccesOrderFollow> findAccesOrderFollowCndbp(Map<String, Object> param);

    AccesOrderFollow getAccesOrderFollowBid(Integer id, HttpServletRequest request);

    //更新理单参数
    AccesOrderFollow savaOrderSortUpdate(AccesOrderFollow am, HttpServletRequest request);

    AccesOrderFollow savaRemarkFollow(AccesOrderFollow am, HttpServletRequest request);

    //获取 辅料未配齐 数据
    int orderRationWaitBpcnt(Map<String, Object> param);

    List<AccesOrderFollow> orderRationWait(Map<String, Object> param);

    //获取 辅料已配齐 数据
    int orderRationReadyBpcnt(Map<String, Object> param);

    List<AccesOrderFollow> orderRationReady(Map<String, Object> param);

    //获取 辅料未配齐 数据
    int orderRationSpecBpcnt(Map<String, Object> param);

    List<AccesOrderFollow> orderRationSpec(Map<String, Object> param);

    //查询 跟单环节数据
    int orderFollowBpcnt(Map<String, Object> param);

    List<AccesOrderFollow> orderFollowList(Map<String, Object> param);

    //保存辅料状态
    AccesOrderFollow savaOrderSortStatus(AccesOrderFollow am, HttpServletRequest request);
}

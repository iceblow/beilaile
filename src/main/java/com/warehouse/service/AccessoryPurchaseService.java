package com.warehouse.service;

import com.warehouse.entity.AccessoryPurchase;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/1/10.
 */
public interface AccessoryPurchaseService {


    // 带条件查询总条数
    int getAccessoryPurchaseByPageCount(Map<String, Object> anyVal);

    // 带条件分页查询
    List<AccessoryPurchase> findConditionAccessoryPurchaseByPage(Map<String, Object> anyVal);

    // 修改获取数据根据id
    AccessoryPurchase getAccessoryPurchaseById(@Param("id") Integer id);

    // 修改状态已经发放
    AccessoryPurchase alreadyIssuePurchase(Integer amId, HttpServletRequest request);

    //驳回
    AccessoryPurchase rejectPurchase(Integer amId, HttpServletRequest request);
}

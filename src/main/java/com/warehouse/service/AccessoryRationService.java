package com.warehouse.service;

import com.warehouse.entity.AccessoryRation;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/1/10.
 */
public interface AccessoryRationService {


    // 带条件查询总条数
    int getAccessoryRationByPageCount(Map<String, Object> anyVal);

    // 带条件分页查询
    List<AccessoryRation> findConditionAccessoryRationByPage(Map<String, Object> anyVal);

    // 修改获取数据根据id
    AccessoryRation getAccessoryRationById(@Param("id") Integer id);

    AccessoryRation rationPurchasing(Integer amId, HttpServletRequest request);

    AccessoryRation rejectRation(Integer amId, HttpServletRequest request);


    AccessoryRation rationPrepareComplete(Integer amId, HttpServletRequest request);

    AccessoryRation rationAlreadyIssue(Integer amId, HttpServletRequest request);
}

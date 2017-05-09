package com.warehouse.service;

import com.warehouse.entity.AccesOrderRation;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/1/21.
 */
public interface AccesOrderRationService {

    //==================== 辅料库存准备 ========================
    int getAccesOrderRationBpcnt(Map<String, Object> param);

    List<AccesOrderRation> findAccesOrderRationCndbp(Map<String, Object> param);

    AccesOrderRation getAccesOrderRationBid(Integer id, HttpServletRequest request);

    AccesOrderRation orderRationPurchasing(Integer amId, HttpServletRequest request);

    AccesOrderRation orderRationPrepareComplete(Integer amId, HttpServletRequest request);

    AccesOrderRation orderRationAlreadyIssue(Integer amId, HttpServletRequest request);

    AccesOrderRation orderRationReject(Integer amId, HttpServletRequest request);

    AccesOrderRation rationDone(Integer amId, HttpServletRequest request);


}

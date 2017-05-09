package com.warehouse.service;

import com.warehouse.entity.AccessoryInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/1/23.
 */
public interface AccesInfoService {


    int getAccesInfoBpcnt(Map<String, Object> param);

    List<AccessoryInfo> findAccesInfoCndbp(Map<String, Object> param);

    AccessoryInfo getAccesInfoBid(Integer id, HttpServletRequest request);

    int addAccesInfo(AccessoryInfo accessoryInfo);

    int modifyAccesInfo(AccessoryInfo accessoryInfo);
}


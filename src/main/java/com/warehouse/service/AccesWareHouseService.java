package com.warehouse.service;

import com.warehouse.entity.AccesWareHouse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/1/21.
 */
public interface AccesWareHouseService {

    int getAccesWareHouseBpcnt(Map<String, Object> param);

    List<AccesWareHouse> findAccesWareHouseCndbp(Map<String, Object> param);

    AccesWareHouse getAccesWareHouseBid(Integer id, HttpServletRequest request);
}

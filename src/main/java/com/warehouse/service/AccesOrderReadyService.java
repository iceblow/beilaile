package com.warehouse.service;

import com.warehouse.entity.AccesOrderReady;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/1/20.
 *
 */

public interface AccesOrderReadyService {

    int getAccesOrderReadyBpcnt(Map<String, Object> param);

    List<AccesOrderReady> findAccesOrderReadyCndbp(Map<String, Object> param);

    AccesOrderReady getAccesOrderReadyBid(Integer id, HttpServletRequest request);


    AccesOrderReady transferShelf(AccesOrderReady accesOrderReady, HttpServletRequest request);
}

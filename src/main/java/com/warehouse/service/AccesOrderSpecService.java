package com.warehouse.service;

import com.warehouse.entity.AccesOrderSpec;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/2/9.
 */
public interface AccesOrderSpecService {

    int orderSpecBpcnt(Map<String, Object> param);

    List<AccesOrderSpec> orderSpecList(Map<String, Object> param);

    AccesOrderSpec getAccesOrderSpecBid(Integer id, HttpServletRequest request);


    AccesOrderSpec savaOrderSpecStatus(AccesOrderSpec am, HttpServletRequest request);


}

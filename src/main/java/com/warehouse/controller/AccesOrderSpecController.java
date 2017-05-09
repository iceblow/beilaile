package com.warehouse.controller;


import com.warehouse.entity.AccesOrderSpec;
import com.warehouse.service.AccesOrderSpecService;
import com.warehouse.util.DateUtils;
import com.warehouse.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/1/20.
 *
 */
@Controller
public class AccesOrderSpecController {

    private Logger logger = LoggerFactory.getLogger(AccesOrderSpecController.class);

    @Resource
    private AccesOrderSpecService accesOrderSpecService;


    /**
     * 带条件查询   跟单环节 总条数
     *ByPageCount  Bpcnt  查询总数
     */
    @RequestMapping(value = "orderSpecBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccesOrderSpec> orderSpecBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesOrderSpecService.orderSpecBpcnt(param);
        Page<AccesOrderSpec> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询 辅料理单总数");
        return page;
    }

    /**
     * 带条件分页 跟单环节 查询 列表
     *ConditiontByPage Cndbp  带条件分页查询 制定工厂信息
     */
    @RequestMapping(value = "orderSpecList.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccesOrderSpec> orderSpecList(@RequestParam Map<String, Object> param) {

        List<AccesOrderSpec> list = accesOrderSpecService.orderSpecList(param);
        logger.debug("根据分页条件查询 辅料理单");
        return list;
    }




}
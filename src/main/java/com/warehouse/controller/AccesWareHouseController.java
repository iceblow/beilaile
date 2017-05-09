package com.warehouse.controller;


import com.warehouse.entity.AccesWareHouse;
import com.warehouse.service.AccesWareHouseService;
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
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/1/20.
 *
 */
@Controller
public class AccesWareHouseController {

    private Logger logger = LoggerFactory.getLogger(AccesWareHouseController.class);

    @Resource
    private AccesWareHouseService accesWareHouseService;

    /**
     * 带条件查询总条数
     *ByPageCount  Bpcnt
     */
    @RequestMapping(value = "getAccesWareHouseBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccesWareHouse> getAccesWareHouseBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesWareHouseService.getAccesWareHouseBpcnt(param);
        Page<AccesWareHouse> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询  库存辅料总数");
        return page;
    }

    /**
     * 带条件分页查询
     *ConditiontByPage Cndbp
     */
    @RequestMapping(value = "findAccesWareHouseCndbp.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccesWareHouse> findAccesWareHouseCndbp(@RequestParam Map<String, Object> param) {

        List<AccesWareHouse> list = accesWareHouseService.findAccesWareHouseCndbp(param);
        logger.debug("根据分页条件查询 辅料库存");
        return list;
    }

    /**
     * 根据 id  获取 辅料库存信息
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "getAccesWareHouseBid", method = RequestMethod.POST)
    @ResponseBody
    public AccesWareHouse getAccesWareHouseBid(Integer id, HttpServletRequest request) {
        AccesWareHouse result = accesWareHouseService.getAccesWareHouseBid(id, request);
        return result;
    }
}
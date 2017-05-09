package com.warehouse.controller;


import com.warehouse.entity.AccesOrderReady;
import com.warehouse.entity.AccesOrderSpec;
import com.warehouse.service.AccesOrderReadyService;
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
public class AccesOrderReadyController {

    private Logger logger = LoggerFactory.getLogger(AccesOrderReadyController.class);

    @Resource
    private AccesOrderReadyService accesOrderReadyService;


    /**
     * 带条件查询  已配齐 总条数
     *ByPageCount  Bpcnt   1
     */
    @RequestMapping(value = "getAccesOrderReadyBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccesOrderReady> getAccesOrderReadyBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesOrderReadyService.getAccesOrderReadyBpcnt(param);
        Page<AccesOrderReady> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询 辅料已配齐总数");
        return page;
    }

    /**
     * 带条件分页 已配齐 查询 列表
     *ConditiontByPage Cndbp  2
     */
    @RequestMapping(value = "findAccesOrderReadyCndbp.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccesOrderReady> findAccesOrderReadyCndbp(@RequestParam Map<String, Object> param) {
        List<AccesOrderReady> list = accesOrderReadyService.findAccesOrderReadyCndbp(param);
        logger.debug("根据分页条件查询 已配齐信息");
        return list;
    }

    @RequestMapping(value = "transferShelf.do", method = RequestMethod.POST)
    @ResponseBody
    public AccesOrderReady transferShelf(Integer amId, HttpServletRequest request) {
        AccesOrderReady accesOrderReady = this.accesOrderReadyService.getAccesOrderReadyBid(amId, request);
        if (accesOrderReady.getAccesStatus().equals("移至工厂货架")) {
            accesOrderReady.setReadyException("已转移到指定工厂货架");
        }else {
            if (accesOrderReady.getFollowStatus().equals("完成配发")){
                if (accesOrderReady.getSpecFctry()!=null){
                    accesOrderReady.setAccesStatus("移至工厂货架");
                    accesOrderReady.setReadyException("无异常");
                }else {
                    accesOrderReady.setReadyException("请等待指定工厂");
                }
            }else {
                accesOrderReady.setReadyException("请等待 配发完成");
            }
        }

        accesOrderReady = accesOrderReadyService.transferShelf(accesOrderReady, request);
        logger.debug("修改 发放状态 为 移至工厂货架");
        return accesOrderReady;
    }

}
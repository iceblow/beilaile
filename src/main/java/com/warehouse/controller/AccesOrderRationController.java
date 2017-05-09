package com.warehouse.controller;


import com.warehouse.entity.AccesOrderRation;
import com.warehouse.entity.AccesRationIssue;
import com.warehouse.service.AccesOrderRationService;
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
public class AccesOrderRationController {

    private Logger logger = LoggerFactory.getLogger(AccesOrderRationController.class);

    @Resource
    private AccesOrderRationService accesOrderRationService;

    /**
     * 带条件查询总条数
     *ByPageCount  Bpcnt
     */
    @RequestMapping(value = "getAccesOrderRationBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccesOrderRation> getAccesOrderRationBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesOrderRationService.getAccesOrderRationBpcnt(param);
        Page<AccesOrderRation> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询 新料单单总数");
        return page;
    }

    /**
     * 带条件分页查询
     *ConditiontByPage Cndbp  根据条件分页查询
     */
    @RequestMapping(value = "findAccesOrderRationCndbp.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccesOrderRation> findAccesOrderRationCndbp(@RequestParam Map<String, Object> param) {

        List<AccesOrderRation> list = accesOrderRationService.findAccesOrderRationCndbp(param);
        logger.debug("根据分页条件查询 新料单");
        return list;
    }

    /**
     * 根据 id  获取 辅料库存准备信息
     * @param id 辅料库存准备的id
     * @param request
     * @return
     */
    @RequestMapping(value = "getAccesOrderRationBid", method = RequestMethod.POST)
    @ResponseBody
    public AccesOrderRation getAccesOrderRationBid(Integer id, HttpServletRequest request) {
        AccesOrderRation result = accesOrderRationService.getAccesOrderRationBid(id, request);
        return result;
    }

    /**
     * 辅料采购中状态修改
     * @param amId  修改对象的id
     * @param request 状态修改者的ip
     * @return
     */
    @RequestMapping(value = "orderRationPurchasing.do", method = RequestMethod.POST)
    @ResponseBody
    private AccesOrderRation orderRationPurchasing(Integer amId, HttpServletRequest request) {
        AccesOrderRation result = this.accesOrderRationService.orderRationPurchasing(amId, request);
        logger.debug("修改 发放状态 为采购中");
        return result;
    }

    /**
     * 辅料配发状态修改 为 可配发
     * @param amId 对象id
     * @param request  操作者ip
     * @return
     */
    @RequestMapping(value = "orderRationPrepareComplete.do", method = RequestMethod.POST)
    @ResponseBody
    private AccesOrderRation orderRationPrepareComplete(Integer amId, HttpServletRequest request) {
        AccesOrderRation result = this.accesOrderRationService.orderRationPrepareComplete(amId, request);
        logger.debug("修改 发放状态 为 可配发");
        return result;
    }

    /**
     * 功能弃用用
     * @param amId
     * @param request
     * @return
     */
    @RequestMapping(value = "orderRationAlreadyIssue.do", method = RequestMethod.POST)
    @ResponseBody
    private AccesOrderRation orderRationAlreadyIssue(Integer amId, HttpServletRequest request) {
        AccesOrderRation result = this.accesOrderRationService.orderRationAlreadyIssue(amId, request);
        logger.debug("修改 已经领走 为 已发放");
        return result;
    }

    /**
     * 功能弃用
     * @param amId
     * @param request
     * @return
     */
    @RequestMapping(value = "orderRationReject.do", method = RequestMethod.POST)
    @ResponseBody
    private AccesOrderRation orderRationReject(Integer amId, HttpServletRequest request) {
        AccesOrderRation result = this.accesOrderRationService.orderRationReject(amId, request);
        logger.debug("修改 发放状态 为 驳回");
        return result;
    }

    /**
     * 功能配发完成
     * @param amId 配发完成的对象 id
     * @param request 操作人员的 ip
     * @return
     */
    @RequestMapping(value = "rationDone.do", method = RequestMethod.POST)
    @ResponseBody
    private AccesOrderRation rationDone(Integer amId, HttpServletRequest request) {
        AccesOrderRation result = this.accesOrderRationService.rationDone(amId, request);
        logger.debug("修改 发放状态 为 处理完成");
        return result;
    }

}
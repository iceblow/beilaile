package com.warehouse.controller;


import com.warehouse.constant.StateConstant;
import com.warehouse.entity.AccesOrderFollow;
import com.warehouse.service.AccesOrderFollowService;
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
 */
@Controller
public class AccesOrderFollowController {

    private Logger logger = LoggerFactory.getLogger(AccesOrderFollowController.class);

    @Resource
    private AccesOrderFollowService accesOrderFollowService;


    /**
     * 带条件查询   跟单环节 总条数
     * ByPageCount  Bpcnt   1
     */
    @RequestMapping(value = "orderFollowBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccesOrderFollow> orderFollowBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesOrderFollowService.orderFollowBpcnt(param);
        Page<AccesOrderFollow> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询 辅料理单总数");
        return page;
    }

    /**
     * 带条件分页 跟单环节 查询 列表
     * ConditiontByPage Cndbp  2
     */
    @RequestMapping(value = "orderFollowList.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccesOrderFollow> orderFollowList(@RequestParam Map<String, Object> param) {
        List<AccesOrderFollow> list = accesOrderFollowService.orderFollowList(param);
        logger.debug("根据分页条件查询 辅料理单");
        return list;
    }

    /**
     * 双击修改跟单备注
     * @param am
     * @return
     */
    @RequestMapping("savaRemarkFollow")
    @ResponseBody
    private AccesOrderFollow savaRemarkFollow(AccesOrderFollow am, HttpServletRequest request) {
        AccesOrderFollow result = accesOrderFollowService.savaRemarkFollow(am, request);
        logger.debug("双击修改跟单备注");
        return result;
    }

    /**
     * 跟单状态  确认配发
     *
     * @param am asdf
     * @return 3asdf
     */
    @RequestMapping("askIssueAcces")
    @ResponseBody
    private AccesOrderFollow askIssueAcces(AccesOrderFollow am, HttpServletRequest request) {
        am.setAccesStatus("确认配发");
        am.setFollowStatus("确认配发");
        am.setFollowTime(DateUtils.formateDaTime(new Date()));
        AccesOrderFollow result = accesOrderFollowService.savaOrderSortStatus(am, request);
        logger.debug("确认配发");
        return result;
    }

    /*
    按裁剪数配发  4
     */
    @RequestMapping("issueByCropNum")
    @ResponseBody
    private AccesOrderFollow issueByCropNum(AccesOrderFollow am, HttpServletRequest request) {
        AccesOrderFollow aof = accesOrderFollowService.getAccesOrderFollowBid(am.getId(), request);
        Integer sumParam = Integer.parseInt(aof.getSumSort());//获取辅料总数
        Integer readyParam = Integer.parseInt(aof.getReadySumSort());//获取辅料可配发数
        if (aof.getIssueMethod() == null) {//如果发放方式不空
            if (sumParam.equals(readyParam)&&aof.getAccesStatus().equals("可配发")) {//总数等于可配法数
                if (null!=(aof.getCropNum())){
                    aof.setIssueNum(aof.getCropNum());
                    aof.setIssueMethod("裁剪数配发");
                    aof = commonFollowStatusModify(aof);
                    aof = calNumbyOC(aof);
                    aof = accesOrderFollowService.savaOrderSortStatus(aof, request);
                    aof.setFollowException("无异常");
                }else{
                    aof.setFollowException("裁剪数为空");
                }

            }else {
                aof.setFollowException("请等待可配发");
            }
        }else {
            aof.setFollowException("已要求配发");
        }

        logger.debug("确认配发");
        return aof;
    }

    /*
    按订单数配发配发  5
     */
    @RequestMapping("issueByOrderNum")
    @ResponseBody
    private AccesOrderFollow issueByOrderNum(AccesOrderFollow am, HttpServletRequest request) {
        AccesOrderFollow aof = accesOrderFollowService.getAccesOrderFollowBid(am.getId(), request);
        //前置条件 ： 确认 辅料数量和 可配发数量相同
        Integer sumParam = Integer.parseInt(aof.getSumSort());
        Integer readyParam = Integer.parseInt(aof.getReadySumSort());
        if (aof.getIssueMethod() == null) {//如果发放方式为空
            if (sumParam.equals(readyParam)&&aof.getAccesStatus().equals("可配发")) {
                aof.setIssueNum(aof.getOrderNum());
                aof.setIssueMethod("订单数配发");
                aof = commonFollowStatusModify(aof);
                aof = calNumbyOC(aof);
                aof = accesOrderFollowService.savaOrderSortStatus(aof, request);
                aof.setFollowException("无异常");
            }else {
                aof.setFollowException("请等待可配发");
            }
        }else {
            aof.setFollowException("已要求配发");
        }
        logger.debug("订单数配发");
        return aof;
    }

    /*
    追加补料单 6
     */
    @RequestMapping("issueForAddtion")
    @ResponseBody
    public AccesOrderFollow issueForAddtion(AccesOrderFollow am, HttpServletRequest request) {
        AccesOrderFollow aof = accesOrderFollowService.getAccesOrderFollowBid(am.getId(), request);

        //前置条件： 订单数配发 且订裁差大于零 的才可以 追加补料单
        if (aof.getIsReplenishStatus().equals("追加补料单")) {
            aof.setFollowException("已追加");
        }else {
            System.out.println(aof.getIssueMethod());
            if (null!=aof.getIssueMethod()){
                if (aof.getIssueMethod().equals("订单数配发")) {
                    if (null!=(aof.getCropNum())) {
                        if (aof.getNumDiff() > 0) {
                            aof.setAccesStatus("追加补料单");
                            aof.setIsReplenishStatus("追加补料单");
                            aof.setReplenishTime(DateUtils.formateDaTime(new Date()));
                            aof.setNumDiff(aof.getCropNum() - aof.getOrderNum());
                            aof = calNumbyDiff(aof);
                            aof = accesOrderFollowService.savaOrderSortStatus(aof, request);
                            aof.setFollowException("无异常");
                        } else {
                            aof.setFollowException("配发数大于裁剪数不予配发");
                        }
                    }else {
                        aof.setFollowException("裁剪数为空");
                    }

                }else {
                    aof.setFollowException("裁剪数配发不可追加");
                }
            }else {
                aof.setFollowException("请先按订单数配发");
            }
        }

        logger.debug("追加补料单");
        return aof;
    }

    //跟单状态修改通用部分 7
    private AccesOrderFollow commonFollowStatusModify(AccesOrderFollow accesOrderFollow) {
        accesOrderFollow.setAccesStatus("确认配发");
        accesOrderFollow.setFollowStatus("确认配发");
        accesOrderFollow.setIsReplenishStatus("首次配发");
        accesOrderFollow.setFollowTime(DateUtils.formateDaTime(new Date()));
        return accesOrderFollow;
    }

    /**
     * 通过  订裁差 计算辅料 数量
     *
     * @param accesOrderFollow
     * @return
     */
    private AccesOrderFollow calNumbyDiff(AccesOrderFollow accesOrderFollow) {

        Integer NumParam = 0;
        switch (accesOrderFollow.getIsReplenishStatus()) {
            case StateConstant._ISSUE_METHOD_BY_DIFF_:
                NumParam = accesOrderFollow.getNumDiff();
                break;
            default:
                break;
        }

        Double diffNumParam;
        if(!"".equals(accesOrderFollow.getAccesOne())&&null!=accesOrderFollow.getAccesOne()) {
            diffNumParam = calByFormula(NumParam, accesOrderFollow.getAccesOneSingleUse(), accesOrderFollow.getAccesOneScrapRate());
            accesOrderFollow.setAccesOneAddtion(diffNumParam);
        }
        if(!"".equals(accesOrderFollow.getAccesTwo())&&null!=accesOrderFollow.getAccesTwo()) {
            diffNumParam = calByFormula(NumParam, accesOrderFollow.getAccesTwoSingleUse(), accesOrderFollow.getAccesTwoScrapRate());
            accesOrderFollow.setAccesTwoAddtion(diffNumParam);
        }
        if(!"".equals(accesOrderFollow.getAccesThree())&&null!=accesOrderFollow.getAccesThree()) {
            diffNumParam = calByFormula(NumParam, accesOrderFollow.getAccesThreeSingleUse(), accesOrderFollow.getAccesThreeScrapRate());
            accesOrderFollow.setAccesThreeAddtion(diffNumParam);
        }
        if(!"".equals(accesOrderFollow.getAccesFour())&&null!=accesOrderFollow.getAccesFour()) {
            diffNumParam = calByFormula(NumParam, accesOrderFollow.getAccesFourSingleUse(), accesOrderFollow.getAccesFourScrapRate());
            accesOrderFollow.setAccesFiveAddtion(diffNumParam);
        }
        if(!"".equals(accesOrderFollow.getAccesFive())&&null!=accesOrderFollow.getAccesFive()) {
            diffNumParam = calByFormula(NumParam, accesOrderFollow.getAccesFiveSingleUse(), accesOrderFollow.getAccesFiveScrapRate());
            accesOrderFollow.setAccesFiveAddtion(diffNumParam);
        }
        if(!"".equals(accesOrderFollow.getAccesSix())&&null!=accesOrderFollow.getAccesSix()) {
            diffNumParam = calByFormula(NumParam, accesOrderFollow.getAccesSixSingleUse(), accesOrderFollow.getAccesSixScrapRate());
            accesOrderFollow.setAccesSixAddtion(diffNumParam);
        }
        return accesOrderFollow;
    }

    /**
     * 通过 订单数 或者 裁剪数  计算辅料 数量
     *
     * @param accesOrderFollow
     * @return
     */
    private AccesOrderFollow calNumbyOC(AccesOrderFollow accesOrderFollow) {

        Integer NumParam = 0;
        switch (accesOrderFollow.getIssueMethod()) {
            case StateConstant._ISSUE_METHOD_BY_ORDER_:
                NumParam = accesOrderFollow.getOrderNum();
                break;
            case StateConstant._ISSUE_METHOD_BY_CROP_:
                NumParam = accesOrderFollow.getCropNum();
                break;
            default:
                break;
        }
        Double accesNumParam;
        if(!"".equals(accesOrderFollow.getAccesOne())&&null!=accesOrderFollow.getAccesOne()) {
            accesNumParam = calByFormula(NumParam, accesOrderFollow.getAccesOneSingleUse(), accesOrderFollow.getAccesOneScrapRate());
            accesOrderFollow.setAccesOneQuantity(accesNumParam);
        }
        if(!"".equals(accesOrderFollow.getAccesTwo())&&null!=accesOrderFollow.getAccesTwo()) {
        accesNumParam = calByFormula(NumParam, accesOrderFollow.getAccesTwoSingleUse(), accesOrderFollow.getAccesTwoScrapRate());
        accesOrderFollow.setAccesTwoQuantity(accesNumParam);
        }
        if(!"".equals(accesOrderFollow.getAccesThree())&&null!=accesOrderFollow.getAccesThree()) {
        accesNumParam = calByFormula(NumParam, accesOrderFollow.getAccesThreeSingleUse(), accesOrderFollow.getAccesThreeScrapRate());
        accesOrderFollow.setAccesThreeQuantity(accesNumParam);
        }
        if(!"".equals(accesOrderFollow.getAccesFour())&&null!=accesOrderFollow.getAccesFour()) {
        accesNumParam = calByFormula(NumParam, accesOrderFollow.getAccesFourSingleUse(), accesOrderFollow.getAccesFourScrapRate());
        accesOrderFollow.setAccesFiveQuantity(accesNumParam);
        }
        if(!"".equals(accesOrderFollow.getAccesFive())&&null!=accesOrderFollow.getAccesFive()) {
        accesNumParam = calByFormula(NumParam, accesOrderFollow.getAccesFiveSingleUse(), accesOrderFollow.getAccesFiveScrapRate());
        accesOrderFollow.setAccesFiveQuantity(accesNumParam);
        }
        if(!"".equals(accesOrderFollow.getAccesSix())&&null!=accesOrderFollow.getAccesSix()) {
            accesNumParam = calByFormula(NumParam, accesOrderFollow.getAccesSixSingleUse(), accesOrderFollow.getAccesSixScrapRate());
            accesOrderFollow.setAccesSixQuantity(accesNumParam);
        }
        return accesOrderFollow;
    }

    //计算公式：数量 = 订单数 * 单耗 * 损耗率
    private Double calByFormula(Integer num, Double singleUse, Double scrapRate) {
        Double rsInt = num * singleUse * scrapRate;
        rsInt = Math.ceil(rsInt);
        return rsInt;
    }
}
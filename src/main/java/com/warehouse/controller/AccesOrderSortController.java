package com.warehouse.controller;


import com.warehouse.constant.WastageConstant;
import com.warehouse.entity.AccesOrderSort;
import com.warehouse.service.AccesOrderSortService;
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
public class AccesOrderSortController {

    private Logger logger = LoggerFactory.getLogger(AccesOrderSortController.class);

    @Resource
    private AccesOrderSortService accesOrderSortService;

    /** 1
     * 带条件查询总条数
     *ByPageCount  Bpcnt
     */
    @RequestMapping(value = "getAccesOrderSortBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccesOrderSort> getAccesOrderSortBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesOrderSortService.getAccesOrderSortBpcnt(param);
        Page<AccesOrderSort> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询 辅料理单总数");
        return page;
    }

    /** 2
     * 带条件分页查询
     *ConditiontByPage Cndbp
     */
    @RequestMapping(value = "findAccesOrderSortCndbp.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccesOrderSort> findAccesOrderSortCndbp(@RequestParam Map<String, Object> param) {

        List<AccesOrderSort> list = accesOrderSortService.findAccesOrderSortCndbp(param);
        logger.debug("根据分页条件查询 辅料理单");
        return list;
    }

    /** 3
     * 根据 id  获取 辅料理单信息
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "getAccesOrderSortBid", method = RequestMethod.POST)
    @ResponseBody
    public AccesOrderSort getAccesOrderSortBid(Integer id, HttpServletRequest request) {
        AccesOrderSort result = accesOrderSortService.getAccesOrderSortBid(id, request);
        return result;
    }


    /** 4
     * 保存双击修改的数字参数
     * @param am
     * @return
     */
    @RequestMapping("savaOrderSortUpdate")
    @ResponseBody
    private AccesOrderSort savaOrderSortUpdate(AccesOrderSort am, HttpServletRequest request) {
        AccesOrderSort result = accesOrderSortService.savaOrderSortUpdate(am, request);
        logger.debug("双击修改辅料参数");
        return result;
    }


    /**
     * 保弹出层2
     * @param am
     * @return
     */
    @RequestMapping("layerSort")
    @ResponseBody
    private AccesOrderSort layerSort(AccesOrderSort am, HttpServletRequest request) {
        AccesOrderSort result = accesOrderSortService.layerSort(am, request);
        logger.debug("弹出层2");
        return result;
    }
    /** 5
     * 保存双击修改的文字参数
     * @param am
     * @return
     */
    @RequestMapping("savaOrderSortFill")
    @ResponseBody
    private AccesOrderSort savaOrderSortFill(AccesOrderSort am, HttpServletRequest request) {
        AccesOrderSort result = accesOrderSortService.savaOrderSortFill(am, request);
        logger.debug("双击修改辅料文字参数");
        return result;
    }


    /** 6
     * 理单状态 理单完成
     * @param am
     * @return
     */
    @RequestMapping("oderSortComplete")
    @ResponseBody
    private AccesOrderSort oderSortComplete(AccesOrderSort am, HttpServletRequest request) {
        am.setAccesStatus("理单完成");
        AccesOrderSort param = accesOrderSortService.getAccesOrderSortBid(am.getId(), request);
        Integer sumSort = 0;

        //计算辅料数量
        if (param.getAccesOne()!= null&&!param.getAccesOne().equals("")) {
            sumSort++;
        }
        if (param.getAccesTwo()!= null&&!param.getAccesTwo().equals("")) {
            sumSort++;
        }
        if (param.getAccesThree()!= null&&!param.getAccesThree().equals("")) {
            sumSort++;
        }
        if (param.getAccesFour()!= null&&!param.getAccesFour().equals("")) {
            sumSort++;
        }
        if (param.getAccesFive()!= null&&!param.getAccesFive().equals("")) {
            sumSort++;
        }
        if (param.getAccesSix()!= null&&!param.getAccesSix().equals("")) {
            sumSort++;
        }
        if (param.getAccesOneQuantity()==null||param.getAccesTwoQuantity()==null||param.getAccesThreeQuantity()==null){
            am.setAccesOneScrapRate(WastageConstant._ONE_SCRAP_RATE);
            am.setAccesTwoScrapRate(WastageConstant._TWO_SCRAP_RATE);
            am.setAccesThreeScrapRate(WastageConstant._THREE_SCRAP_RATE);
            am.setAccesOneSingleUse(1.0);
            am.setAccesTwoSingleUse(1.0);
            am.setAccesThreeSingleUse(0.0);
        }
        am.setSumSort(sumSort.toString());
        am.setReadySumSort("0");
        am.setSortStatus("理单完成");
        am.setSortTime(DateUtils.formateDaTime(new Date()));
        am.setFollowStatus("跟单未处理");
        AccesOrderSort result = accesOrderSortService.savaOrderSortFill(am, request);
        logger.debug("理单完成");
        return result;
    }



    /**
     * 带条件查询   未配齐总条数
     *ByPageCount  Bpcnt
     */
    @RequestMapping(value = "orderRationWaitBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccesOrderSort> orderRationWaitBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesOrderSortService.orderRationWaitBpcnt(param);
        Page<AccesOrderSort> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询 辅料理单总数");
        return page;
    }

    /**
     * 带条件分页 未配齐查询
     *ConditiontByPage Cndbp
     */
    @RequestMapping(value = "orderRationWait.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccesOrderSort> orderRationWait(@RequestParam Map<String, Object> param) {

        List<AccesOrderSort> list = accesOrderSortService.orderRationWait(param);
        logger.debug("根据分页条件查询 辅料理单");
        return list;
    }

    /**
     * 带条件查询   壹配齐总条数
     *ByPageCount  Bpcnt
     */
    @RequestMapping(value = "orderRationReadyBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccesOrderSort> orderRationReadyBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesOrderSortService.orderRationReadyBpcnt(param);
        Page<AccesOrderSort> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询 辅料理单总数");
        return page;
    }

    /**
     * 带条件分页 已经配齐查询
     *ConditiontByPage Cndbp
     */
    @RequestMapping(value = "orderRationReady.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccesOrderSort> orderRationReady(@RequestParam Map<String, Object> param) {

        List<AccesOrderSort> list = accesOrderSortService.orderRationReady(param);
        logger.debug("根据分页条件查询 辅料理单");
        return list;
    }

    /**
     * 带条件查询   指定工厂总条数
     *ByPageCount  Bpcnt
     */
    @RequestMapping(value = "orderRationSpecBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccesOrderSort> orderRationSpecBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesOrderSortService.orderRationSpecBpcnt(param);
        Page<AccesOrderSort> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询 辅料理单总数");
        return page;
    }

    /**
     * 带条件分页 指定工厂查询
     *ConditiontByPage Cndbp
     */
    @RequestMapping(value = "orderRationSpec.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccesOrderSort> orderRationSpec(@RequestParam Map<String, Object> param) {

        List<AccesOrderSort> list = accesOrderSortService.orderRationSpec(param);
        logger.debug("根据分页条件查询 辅料理单");
        return list;
    }



}
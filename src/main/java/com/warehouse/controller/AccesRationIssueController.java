package com.warehouse.controller;


import com.warehouse.entity.AccesOrderRation;
import com.warehouse.entity.AccesRationIssue;
import com.warehouse.service.AccesOrderRationService;
import com.warehouse.service.AccesRationIssueService;
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
import java.util.Objects;

/**
 * Created by chiayich on 2017/1/20.
 *辅料配发
 */
@Controller
public class AccesRationIssueController {

    private Logger logger = LoggerFactory.getLogger(AccesRationIssueController.class);

    @Resource
    private AccesRationIssueService accesRationIssueService;

    /**
     * 带条件查询总条数
     *ByPageCount  Bpcnt 查询符合条件的信息总数
     */
    @RequestMapping(value = "getAccesOrderIssueBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccesRationIssue> getAccesOrderIssueBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesRationIssueService.getAccesOrderIssueBpcnt(param);
        Page<AccesRationIssue> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询 新料单单总数");
        return page;
    }

    /**
     * 带条件分页查询
     *ConditiontByPage Cndbp 查询符合条件的信息列表
     */
    @RequestMapping(value = "findAccesOrderIssueCndbp.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccesRationIssue> findAccesOrderIssueCndbp(@RequestParam Map<String, Object> param) {

        List<AccesRationIssue> list = accesRationIssueService.findAccesOrderIssueCndbp(param);
        logger.debug("根据分页条件查询 新料单");
        return list;
    }

    /**
     * 修改状态为 完成配发  功能弃用
     * @param amId
     * @param request
     * @return
     */
    @RequestMapping(value = "issueDone.do", method = RequestMethod.POST)
    @ResponseBody
    public AccesRationIssue issueDone(Integer amId, HttpServletRequest request) {
        AccesRationIssue result = this.accesRationIssueService.issueDone(amId, request);
        logger.debug("修改 发放状态 为 完成配发");
        return result;
    }


    /**
     * 双击修改配发备注
     * @param am 修改的对象
     * @return 保村的信息
     */
    @RequestMapping("savaRemarkIssue")
    @ResponseBody
    private AccesRationIssue savaRemarkIssue(AccesRationIssue am, HttpServletRequest request) {
        AccesRationIssue result = accesRationIssueService.savaRemarkIssue(am, request);
        logger.debug("双击修改辅料配发备注");
        return result;
    }

    /**
     *打印配发单  功能弃用
     * @param  idList 要打印的对象id数组字符串
     * @param request 获取ip
     * @return 打印信息内容
     */
    @RequestMapping("printIssueSheet")
    @ResponseBody
    private List<AccesRationIssue> printIssueSheet(String idList, HttpServletRequest request) {
        List<AccesRationIssue> result = accesRationIssueService.printIssueSheet(idList, request);
        logger.debug("打印配料单");
        return result;
    }

    /**
     *热敏纸打印配发的辅料信息 条码
     * @param idList 要打印的对象id数组字符串
     * @param request 操作元Ip
     * @return 要打印的信息列表
     */
    @RequestMapping("printHTPaper")
    @ResponseBody
    private List<AccesRationIssue> printHTPaper(String idList, HttpServletRequest request) {
        List<AccesRationIssue> result = accesRationIssueService.printHTPaper(idList, request);
        logger.debug("打印配料单");
        return result;
    }
}
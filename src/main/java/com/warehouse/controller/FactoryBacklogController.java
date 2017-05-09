package com.warehouse.controller;

import com.warehouse.entity.FactoryBacklog;
import com.warehouse.service.FactoryBacklogService;
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
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/1/17.
 */
@Controller
public class FactoryBacklogController {
    
    private Logger logger = LoggerFactory.getLogger(FactoryBacklogController.class);

    @Resource
    public FactoryBacklogService factoryBacklogService;


    /**
     * 带条件查询 工厂代办事务 总条数
     *
     * @param anyval
     * @return
     */
    @RequestMapping(value = "getFactoryBacklogByPageCount.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<FactoryBacklog> getFactoryBacklogByPageCount(@RequestParam Map<String, Object> anyval) {
        int result = factoryBacklogService.getFactoryBacklogByPageCount(anyval);
        Page<FactoryBacklog> page = new Page<FactoryBacklog>(result, 1);
        logger.debug("根据分页条件查询 工厂代办事务 总条数");
        return page;
    }

    /**
     * 带条件分页查询
     *
     * @param anyVal
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping(value = "findConditionFactoryBacklogByPage.do", method = RequestMethod.POST)
    @ResponseBody
    public List<FactoryBacklog> findConditionFactoryBacklogByPage(@RequestParam Map<String, Object> anyVal) {

        List<FactoryBacklog> list = factoryBacklogService.findConditionFactoryBacklogByPage(anyVal);
        logger.debug("根据分页条件查询 工厂代办事务");
        return list;
    }

    @RequestMapping(value = "getFactoryBacklogById.do", method = RequestMethod.POST)
    @ResponseBody
    public FactoryBacklog getFactoryBacklogById(Integer id) {
        FactoryBacklog FactoryBacklog = factoryBacklogService.getFactoryBacklogById(id);
        logger.debug("根据id查询 工厂代办事务");
        return FactoryBacklog;
    }

    @RequestMapping(value = "confirmBacklogCompleted.do", method = RequestMethod.POST)
    @ResponseBody
    private FactoryBacklog confirmBacklogCompleted(Integer amId, HttpServletRequest request) {
        FactoryBacklog result = this.factoryBacklogService.confirmBacklogCompleted(amId, request);
        logger.debug("修改 工厂代办事务 完成状态 为 已领取（已完成）");
        return result;
    }


}

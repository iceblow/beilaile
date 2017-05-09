package com.warehouse.service;

import com.warehouse.constant.WastageConstant;
import com.warehouse.dao.AccesOrderReadyMapper;
import com.warehouse.entity.AccesOrderReady;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/1/20.
 *
 */
@Service
public class AccesOrderReadyServiceImpl implements AccesOrderReadyService {



    @Resource
    private AccesOrderReadyMapper accesOrderReadyMapper;

    /**
     * 根据筛查条件 查询配齐货架的信息总数
     * @param param 筛查条件
     * @return  配齐货架信息总数
     */
    @Override
    public int getAccesOrderReadyBpcnt(Map<String, Object> param) {
        int countNum = accesOrderReadyMapper.getAccesOrderReadyBpcnt(param);
        return countNum;
    }

    /**
     * 根据筛查条件 查询配齐货架信息的列表
     * @param param 筛查条件 当前页 页面显示数量
     * @return  配齐货架信息列表
     */
    @Override
    public List<AccesOrderReady> findAccesOrderReadyCndbp(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderReady> list = accesOrderReadyMapper.findAccesOrderReadyCndbp(param);
        return list;
    }

    /**
     * 根据ID 查询 配齐货架的信息
     * @param id 配齐辅料的id
     * @param request 操作人的ip
     * @return 配齐辅料波次的信息
     */
    @Override
    public AccesOrderReady getAccesOrderReadyBid(Integer id, HttpServletRequest request) {
        AccesOrderReady accesOrderSort = accesOrderReadyMapper.selectByPrimaryKey(id);
        return accesOrderSort;
    }


    /**
     * 转移至指定工厂货架
     * @param accesOrderReady  指定工厂的配齐货架信息对象
     * @param request  IP
     * @return  指定工厂修改的信息状态
     */
    @Override
    public AccesOrderReady transferShelf(AccesOrderReady accesOrderReady, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        accesOrderReady.setOperatorIp(operatorIp);
        accesOrderReadyMapper.updateByPrimaryKeySelective(accesOrderReady);
        return accesOrderReady;
    }
}

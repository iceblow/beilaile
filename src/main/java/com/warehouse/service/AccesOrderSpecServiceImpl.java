package com.warehouse.service;

import com.warehouse.dao.AccesOrderSpecMapper;
import com.warehouse.entity.AccesOrderSpec;
import com.warehouse.util.ClientIpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/1/20.
 *
 */
@Service
public class AccesOrderSpecServiceImpl implements AccesOrderSpecService {



    @Resource
    private AccesOrderSpecMapper accesOrderSpecMapper;


    /**
     * 跟据条件 查询指定工厂的信息总数
     * @param param  筛查条件
     * @return  返回查询的信息总数
     */
    @Override
    public int orderSpecBpcnt(Map<String, Object> param) {
        int countNum = accesOrderSpecMapper.getAccesOrderSpecBpcnt(param);
        return countNum;
    }

    /**
     * 根据条件查询 指定工厂的信息列表
     * @param param 筛查条件  当前页 页面显示数量
     * @return  指定工厂的信息列表
     */
    @Override
    public List<AccesOrderSpec> orderSpecList(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderSpec> list = accesOrderSpecMapper.findAccesOrderSpecCndbp(param);
        return list;
    }

    /**
     * 根据ID 查询指定工厂的信息
     * @param id  指定信息ID
     * @param request  操作人的iP
     * @return  查询的指定工厂的信息对象
     */
    @Override
    public AccesOrderSpec getAccesOrderSpecBid(Integer id, HttpServletRequest request) {
        AccesOrderSpec accesOrderSort = accesOrderSpecMapper.selectByPrimaryKey(id);
        return accesOrderSort;
    }


    /**
     * 保存 更新 指定工厂状态
     * @param am 更新状态的对象
     * @param request 操作人IP
     * @return 跟新的信息内容
     */
    @Override
    public AccesOrderSpec savaOrderSpecStatus(AccesOrderSpec am, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        am.setOperatorIp(operatorIp);
        accesOrderSpecMapper.updateByPrimaryKeySelective(am);
        return am;
    }
}

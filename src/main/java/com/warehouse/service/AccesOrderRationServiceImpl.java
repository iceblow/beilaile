package com.warehouse.service;

import com.warehouse.constant.StateConstant;
import com.warehouse.dao.AccesOrderRationMapper;
import com.warehouse.dao.AccesRationIssueMapper;
import com.warehouse.entity.AccesOrderRation;
import com.warehouse.entity.AccesRationIssue;
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
public class AccesOrderRationServiceImpl implements AccesOrderRationService {

    @Resource
    private AccesOrderRationMapper accesOrderRationMapper;


    /**
     * 根据筛查条件 查询库存配发的辅料总数
     * @param param 筛查条件
     * @return  符合条件的辅料信息总数
     */
    @Override
    public int getAccesOrderRationBpcnt(Map<String, Object> param) {
        int countNum = accesOrderRationMapper.getAccesOrderRationBpcnt(param);
        return countNum;
    }

    /**
     * 根据筛查条件 查询库存配发的辅料信息列表
     * @param param  筛查条件  页面显示数量 当前页
     * @return  辅料信息列表
     */
    @Override
    public List<AccesOrderRation> findAccesOrderRationCndbp(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderRation> list = accesOrderRationMapper.findAccesOrderRationCndbp(param);
        return list;
    }

    /**
     * 根据id 获取要辅料信息
     * @param id  辅料id
     * @param request 查询人 ip
     * @return  查询的辅料信息
     */
    @Override
    public AccesOrderRation getAccesOrderRationBid(Integer id, HttpServletRequest request) {
        AccesOrderRation accesOrderRation = accesOrderRationMapper.selectByPrimaryKey(id);
        return accesOrderRation;
    }

    /**
     * 辅料采购中  功能弃用
     * @param amId
     * @param request
     * @return
     */
    @Override
    public AccesOrderRation orderRationPurchasing(Integer amId, HttpServletRequest request) {
        AccesOrderRation accessoryRation = updateISCommon(amId, request);
        accessoryRation.setRationStatus(StateConstant._RATION_PURCHASE_ING);
        accesOrderRationMapper.updateByPrimaryKeySelective(accessoryRation);
        return accessoryRation;
    }

    /**
     * 辅料准备完成就绪
     * @param amId
     * @param request
     * @return
     */
    @Override
    public AccesOrderRation orderRationPrepareComplete(Integer amId, HttpServletRequest request) {
        AccesOrderRation accessoryRation = updateISCommon(amId, request);
        accessoryRation.setRationStatus(StateConstant._RATION_ALREADY_PREPARED);
        accesOrderRationMapper.updateByPrimaryKeySelective(accessoryRation);
        return accessoryRation;
    }

    /**
     * 已发放的辅料  功能弃用
     * @param amId
     * @param request
     * @return
     */
    @Override
    public AccesOrderRation orderRationAlreadyIssue(Integer amId, HttpServletRequest request) {
        AccesOrderRation accessoryRation = updateISCommon(amId, request);
        accessoryRation.setRationStatus(StateConstant._RATION_ALREADY_ISSUE);
        accesOrderRationMapper.updateByPrimaryKeySelective(accessoryRation);
        return accessoryRation;
    }


    /**
     * 辅料配发完成   功能弃用
     * @param amId  配发完成的id
     * @param request 操作人员的 ip
     * @return  修改的内容
     */
    @Override
    public AccesOrderRation rationDone(Integer amId, HttpServletRequest request) {
        AccesOrderRation accessoryRation = updateISCommon(amId, request);
        Integer numDiff = accessoryRation.getNumDiff();
        if (numDiff!=null&&numDiff<=0){
            accessoryRation.setRationStatus(StateConstant._RATION_DONE);
            accesOrderRationMapper.updateByPrimaryKeySelective(accessoryRation);
            return accessoryRation;
        }else {
            return new AccesOrderRation();
        }
    }

    /**
     * 拒绝配发 对象   改方法由于功能需求改变已弃用
     * @param amId  对象id
     * @param request 操作人ip
     * @return 跟新的配发对象
     */
    @Override
    public AccesOrderRation orderRationReject(Integer amId, HttpServletRequest request) {
        AccesOrderRation accessoryRation = updateISCommon(amId, request);
        accessoryRation.setRationStatus(StateConstant._REJECT_PURCHASE);
        accesOrderRationMapper.updateByPrimaryKeySelective(accessoryRation);
        return accessoryRation;
    }

    /**
     * 更新操作人iP通用方法
     * @param amId 跟新对象ID
     * @param request 操作人员ip
     * @return 修改的内容
     */
    private AccesOrderRation updateISCommon(int amId,HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        AccesOrderRation ar = accesOrderRationMapper.selectByPrimaryKey(amId);
        ar.setOperatorIp(operatorIp);
        ar.setModifyTime((new Date()).toString());
        return ar;
    }

}

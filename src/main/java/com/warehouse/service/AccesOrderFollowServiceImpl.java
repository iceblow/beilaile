package com.warehouse.service;

import com.warehouse.constant.WastageConstant;
import com.warehouse.dao.AccesOrderFollowMapper;
import com.warehouse.entity.AccesOrderFollow;
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
public class AccesOrderFollowServiceImpl implements AccesOrderFollowService {



    @Resource
    private AccesOrderFollowMapper accesOrderFollowMapper;

    /**
     * 根据 查询条件查询 跟单总数
     * @param param 筛查条件
     * @return 符合条件的总数
     */
    @Override
    public int getAccesOrderFollowBpcnt(Map<String, Object> param) {
        int countNum = accesOrderFollowMapper.getAccesOrderFollowBpcnt(param);
        return countNum;
    }

    /**
     * 根据条件和页面显示数 当前页 和筛查条件 查询跟单信息一览
     * @param param 筛查条件 当前页 总数
     * @return  查询出的跟单信息
     */
    @Override
    public List<AccesOrderFollow> findAccesOrderFollowCndbp(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderFollow> list = accesOrderFollowMapper.findAccesOrderFollowCndbp(param);
        return list;
    }

    /**
     * 跟据id 查询跟单信息
     * @param id 跟单的ID
     * @param request 操作人ip
     * @return  查询的 跟单
     */
    @Override
    public AccesOrderFollow getAccesOrderFollowBid(Integer id, HttpServletRequest request) {
        AccesOrderFollow accesOrderFollow = accesOrderFollowMapper.selectByPrimaryKey(id);
        return accesOrderFollow;
    }


    /**
     * 跟单备注保存
     * @param am  跟单对象
     * @param request 操作人 iP
     * @return 修改的内容
     */
    @Override
    public AccesOrderFollow savaRemarkFollow(AccesOrderFollow am, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        am.setOperatorIp(operatorIp);
        am.setModifyTime(DateUtils.formateDaTime(new Date()));
        accesOrderFollowMapper.updateByPrimaryKeySelective(am);
        return am;
    }


    /**
     * 保存 跟单更新信息
     * @param am  要保存的对象信息
     * @param request  操作人IP
     * @return  更新成功的信息
     */
    @Override
    public AccesOrderFollow savaOrderSortUpdate(AccesOrderFollow am, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        am.setOperatorIp(operatorIp);
        am.setModifyTime(DateUtils.formateDaTime(new Date()));

        /**
         * 根据订单数 更新理单数字参数
         * @param 订单数 orderNum
         * 损耗率（ AccessoriesScrapRate1/2/3）
         * 单耗 (SingleUse Accessories1/2/3SingleUse)
         * formula  数量 = 订单数 * 损耗率 * 单耗
         */
        Integer primaryKey = am.getId();
        AccesOrderFollow aceMatOri = accesOrderFollowMapper.selectByPrimaryKey(primaryKey);
        Integer orderNumOri = aceMatOri.getOrderNum();//原数据中的裁剪数

        //若损耗率常量未添加 则更新常量数据
        if (aceMatOri.getAccesOneScrapRate()==null) {
            refreshConsWastage(aceMatOri);
        }
        if (orderNumOri != null) {

            //修改辅料4 损耗率
            if (am.getAccesFourScrapRate()!= null){
                if (aceMatOri.getAccesFourSingleUse()!= null) {
                    Double param = calAccesOrderFollowNum(orderNumOri,am.getAccesFourScrapRate(),
                            aceMatOri.getAccesFourSingleUse());
                    am.setAccesFourQuantity(param);
                }
            }
            //修改辅料5 损耗率
            if (am.getAccesFiveScrapRate()!= null){
                if (aceMatOri.getAccesFiveSingleUse()!= null) {
                    Double param = calAccesOrderFollowNum(orderNumOri,
                            am.getAccesFiveScrapRate(),
                            aceMatOri.getAccesFiveSingleUse());
                    am.setAccesFiveQuantity(param);
                }
            }
            //修改辅料6 损耗率
            if (am.getAccesSixScrapRate()!= null){
                if (aceMatOri.getAccesSixSingleUse()!= null) {
                    Double param = calAccesOrderFollowNum(orderNumOri,am.getAccesSixScrapRate(),
                            aceMatOri.getAccesSixSingleUse());
                    am.setAccesSixQuantity(param);
                }
            }

            // 修改辅料4 单耗
            if (am.getAccesFourSingleUse()!= null) {
                if (aceMatOri.getAccesFourScrapRate()!= null) {
                    am.setAccesFourQuantity(calAccesOrderFollowNum(orderNumOri,aceMatOri.getAccesFourScrapRate(),
                            am.getAccesFourSingleUse()));
                }
            }

            // 修改辅料5 单耗
            if (am.getAccesFiveSingleUse()!= null) {
                if (aceMatOri.getAccesFiveScrapRate()!= null) {
                    am.setAccesFiveQuantity(calAccesOrderFollowNum(orderNumOri,aceMatOri.getAccesFiveScrapRate(),
                            am.getAccesFiveSingleUse()));
                }
            }

            // 修改辅料6 单耗
            if (am.getAccesSixSingleUse() != null) {
                if (aceMatOri.getAccesSixScrapRate()!= null) {
                    am.setAccesSixQuantity(calAccesOrderFollowNum(orderNumOri,aceMatOri.getAccesSixScrapRate(),
                            am.getAccesSixSingleUse()));
                }
            }

            //吊牌 损耗率
            if (aceMatOri.getAccesOneSingleUse() == null) {
                am.setAccesOneSingleUse(1.0);
                am.setAccesOneQuantity(calAccesOrderFollowNum(orderNumOri,WastageConstant._ONE_SCRAP_RATE,am.getAccesOneSingleUse()));
            }

            //包装袋 损耗率
            if (aceMatOri.getAccesTwoSingleUse() == null) {
                am.setAccesTwoSingleUse(1.0);
                am.setAccesTwoQuantity(calAccesOrderFollowNum(orderNumOri,WastageConstant._TWO_SCRAP_RATE,am.getAccesTwoSingleUse()));
            }

            // 修改 五爪扣 单耗自填  损耗率固定
            if (am.getAccesThreeSingleUse() != null) {
                am.setAccesThreeQuantity(calAccesOrderFollowNum(orderNumOri,WastageConstant._THREE_SCRAP_RATE,am.getAccesThreeSingleUse()));
            }
        }
        am.setAccesOneScrapRate(WastageConstant._ONE_SCRAP_RATE);
        am.setAccesTwoScrapRate(WastageConstant._TWO_SCRAP_RATE);
        am.setAccesThreeScrapRate(WastageConstant._THREE_SCRAP_RATE);
        //保存am  包含 修改值 及相应的数量
        accesOrderFollowMapper.updateByPrimaryKeySelective(am);
        return am;
    }

    /**
     * 插入损耗率 固定值
     * @param accesOrderSort  要初始化 损耗率的对象
     * @return 修改的内容数
     */
    private int refreshConsWastage(AccesOrderFollow accesOrderSort) {
        accesOrderSort.setAccesOneScrapRate(WastageConstant._ONE_SCRAP_RATE);
        accesOrderSort.setAccesTwoScrapRate(WastageConstant._TWO_SCRAP_RATE);
        accesOrderSort.setAccesThreeScrapRate(WastageConstant._THREE_SCRAP_RATE);
        int re = accesOrderFollowMapper.updateByPrimaryKeySelective(accesOrderSort);
        return re;
    }

    /**
     *  辅料用量 计算公式
     * @param num 订单数
     * @param scrapRate 损耗率
     * @param singleUse 单耗
     * @return 总数
     */
    private Double calAccesOrderFollowNum(Integer num, Double scrapRate,Double singleUse){
        Double result = num * scrapRate * singleUse ;
        result = Math.ceil(result);
        return result;
    }

    /**
     * 根据筛查条件查询等待配发总数
     * @param param 筛查条件
     * @return 符合条件的总数
     */
    @Override
    public int orderRationWaitBpcnt(Map<String, Object> param) {
        int countNum = accesOrderFollowMapper.orderRationWaitBpcnt(param);
        return countNum;
    }

    /**
     * 跟据条件查询 等待配发的跟单信息
     * @param param
     * @return
     */
    @Override
    public List<AccesOrderFollow> orderRationWait(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderFollow> list = accesOrderFollowMapper.orderRationWait(param);
        return list;
    }

    /**
     *
     * @param param
     * @return
     */
    @Override
    public int orderRationReadyBpcnt(Map<String, Object> param) {
        int countNum = accesOrderFollowMapper.orderRationReadyBpcnt(param);
        return countNum;
    }

    /**
     *
     * @param param
     * @return
     */
    @Override
    public List<AccesOrderFollow> orderRationReady(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderFollow> list = accesOrderFollowMapper.orderRationReady(param);
        return list;
    }

    /**
     * 根据条件查询指定工厂的订单信息总数
     * @param param  筛查信息
     * @return
     */
    @Override
    public int orderRationSpecBpcnt(Map<String, Object> param) {
        int countNum = accesOrderFollowMapper.orderRationSpecBpcnt(param);
        return countNum;
    }

    /**
     * 根据条件查询指定工厂的订单信息
     * @param param 当前页 页面显示数量 条件
     * @return 符合条件的信息列表
     */
    @Override
    public List<AccesOrderFollow> orderRationSpec(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderFollow> list = accesOrderFollowMapper.orderRationSpec(param);
        return list;
    }

    /**
     * 根据条件查询 跟单信息总数
     * @param param 筛查条件
     * @return 符合条件的跟单信息总数
     */
    @Override
    public int orderFollowBpcnt(Map<String, Object> param) {
        int countNum = accesOrderFollowMapper.orderFollowBpcnt(param);
        return countNum;
    }

    /**
     * 根据条件 查询 跟单信息
     * @param param 筛查条件
     * @return 符合筛查条件的 跟单信息列表
     */
    @Override
    public List<AccesOrderFollow> orderFollowList(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderFollow> list = accesOrderFollowMapper.orderFollowList(param);
        return list;
    }

    /**
     * 保存理单状态
     * @param am 要修改的对象
     * @param request 操作人IP
     * @return 修改成功的对象
     */
    @Override
    public AccesOrderFollow savaOrderSortStatus(AccesOrderFollow am, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        am.setOperatorIp(operatorIp);
        accesOrderFollowMapper.updateByPrimaryKeySelective(am);
        return am;
    }

}

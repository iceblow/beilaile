package com.warehouse.service;

import com.warehouse.constant.WastageConstant;
import com.warehouse.dao.AccesOrderSortMapper;
import com.warehouse.entity.AccesOrderSort;
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
public class AccesOrderSortServiceImpl implements AccesOrderSortService {



    @Resource
    private AccesOrderSortMapper accesOrderSortMapper;

    @Override
    public int getAccesOrderSortBpcnt(Map<String, Object> param) {
        int countNum = accesOrderSortMapper.getAccesOrderSortBpcnt(param);
        return countNum;
    }

    @Override
    public List<AccesOrderSort> findAccesOrderSortCndbp(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderSort> list = accesOrderSortMapper.findAccesOrderSortCndbp(param);
        return list;
    }

    @Override
    public AccesOrderSort getAccesOrderSortBid(Integer id, HttpServletRequest request) {
        AccesOrderSort accesOrderSort = accesOrderSortMapper.selectByPrimaryKey(id);
        return accesOrderSort;
    }



    @Override
    public AccesOrderSort savaOrderSortFill(AccesOrderSort am, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        am.setModifyTime(DateUtils.formateDaTime(new Date()));
        am.setOperatorIp(operatorIp);

//
//        if (am.getAccesOneQuantity()==null||am.getAccesTwoQuantity()==null||am.getAccesThreeQuantity()==null){
//            am.setAccesOneScrapRate(WastageConstant._ONE_SCRAP_RATE);
//            am.setAccesTwoScrapRate(WastageConstant._TWO_SCRAP_RATE);
//            am.setAccesThreeScrapRate(WastageConstant._THREE_SCRAP_RATE);
//            am.setAccesOneSingleUse(1.0);
//            am.setAccesTwoSingleUse(1.0);
//            am.setAccesThreeSingleUse(0.0);
//        }

        accesOrderSortMapper.updateByPrimaryKeySelective(am);
        return am;
    }



    @Override
    public AccesOrderSort savaOrderSortUpdate(AccesOrderSort am, HttpServletRequest request) {
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
        AccesOrderSort aceMatOri = accesOrderSortMapper.selectByPrimaryKey(primaryKey);
        Integer orderNumOri = aceMatOri.getOrderNum();//原数据中的裁剪数

        //若损耗率常量未添加 则更新常量数据
        if (aceMatOri.getAccesOneScrapRate()==null) {
            refreshConsWastage(aceMatOri);
        }
        if (orderNumOri != null) {

            //修改辅料4 损耗率
            if (am.getAccesFourScrapRate()!= null){
                if (aceMatOri.getAccesFourSingleUse()!= null) {
                    Double param = calAccesOrderSortNum(orderNumOri,am.getAccesFourScrapRate(),
                            aceMatOri.getAccesFourSingleUse());
                    am.setAccesFourQuantity(param);
                }
            }
            //修改辅料5 损耗率
            if (am.getAccesFiveScrapRate()!= null){
                if (aceMatOri.getAccesFiveSingleUse()!= null) {
                    Double param = calAccesOrderSortNum(orderNumOri,
                            am.getAccesFiveScrapRate(),
                            aceMatOri.getAccesFiveSingleUse());
                    am.setAccesFiveQuantity(param);
                }
            }
            //修改辅料6 损耗率
            if (am.getAccesSixScrapRate()!= null){
                if (aceMatOri.getAccesSixSingleUse()!= null) {
                    Double param = calAccesOrderSortNum(orderNumOri,am.getAccesSixScrapRate(),
                            aceMatOri.getAccesSixSingleUse());
                    am.setAccesSixQuantity(param);
                }
            }

            // 修改辅料4 单耗
            if (am.getAccesFourSingleUse()!= null) {
                if (aceMatOri.getAccesFourScrapRate()!= null) {
                    am.setAccesFourQuantity(calAccesOrderSortNum(orderNumOri,aceMatOri.getAccesFourScrapRate(),
                            am.getAccesFourSingleUse()));
                }
            }

            // 修改辅料5 单耗
            if (am.getAccesFiveSingleUse()!= null) {
                if (aceMatOri.getAccesFiveScrapRate()!= null) {
                    am.setAccesFiveQuantity(calAccesOrderSortNum(orderNumOri,aceMatOri.getAccesFiveScrapRate(),
                            am.getAccesFiveSingleUse()));
                }
            }

            // 修改辅料6 单耗
            if (am.getAccesSixSingleUse() != null) {
                if (aceMatOri.getAccesSixScrapRate()!= null) {
                    am.setAccesSixQuantity(calAccesOrderSortNum(orderNumOri,aceMatOri.getAccesSixScrapRate(),
                            am.getAccesSixSingleUse()));
                }
            }

            //吊牌 损耗率
            if (aceMatOri.getAccesOneSingleUse() == null) {
                am.setAccesOneSingleUse(1.0);
                am.setAccesOneQuantity(calAccesOrderSortNum(orderNumOri,WastageConstant._ONE_SCRAP_RATE,am.getAccesOneSingleUse()));
//            } else {
//                am.setAccesOneQuantity(calAccesOrderSortNum(orderNumOri,WastageConstant._ONE_SCRAP_RATE,am.getAccesOneSingleUse()));
            }

            //包装袋 损耗率
            if (aceMatOri.getAccesTwoSingleUse() == null) {
                am.setAccesTwoSingleUse(1.0);
                am.setAccesTwoQuantity(calAccesOrderSortNum(orderNumOri,WastageConstant._TWO_SCRAP_RATE,am.getAccesTwoSingleUse()));
            }

            // 修改 五爪扣 单耗自填  损耗率固定
            if (am.getAccesThreeSingleUse() != null) {
                am.setAccesThreeQuantity(calAccesOrderSortNum(orderNumOri,WastageConstant._THREE_SCRAP_RATE,am.getAccesThreeSingleUse()));
            }
        }
        am.setAccesOneScrapRate(WastageConstant._ONE_SCRAP_RATE);
        am.setAccesTwoScrapRate(WastageConstant._TWO_SCRAP_RATE);
        am.setAccesThreeScrapRate(WastageConstant._THREE_SCRAP_RATE);
        //保存am  包含 修改值 及相应的数量
        accesOrderSortMapper.updateByPrimaryKeySelective(am);
        return am;
    }

    //插入损耗率 固定值
    private int refreshConsWastage(AccesOrderSort accesOrderSort) {
        accesOrderSort.setAccesOneScrapRate(WastageConstant._ONE_SCRAP_RATE);

        accesOrderSort.setAccesThreeScrapRate(WastageConstant._THREE_SCRAP_RATE);
        accesOrderSort.setAccesTwoScrapRate(WastageConstant._TWO_SCRAP_RATE);
        int re = accesOrderSortMapper.updateByPrimaryKeySelective(accesOrderSort);
        return re;
    }

    private Double calAccesOrderSortNum(Integer num, Double scrapRate,Double singleUse){
        Double result = num * scrapRate * singleUse ;//计算公式
        result = Math.ceil(result);
        return result;
    }

    @Override
    public int orderRationWaitBpcnt(Map<String, Object> param) {
        int countNum = accesOrderSortMapper.orderRationWaitBpcnt(param);
        return countNum;
    }

    @Override
    public List<AccesOrderSort> orderRationWait(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderSort> list = accesOrderSortMapper.orderRationWait(param);
        return list;
    }

    @Override
    public int orderRationReadyBpcnt(Map<String, Object> param) {
        int countNum = accesOrderSortMapper.orderRationReadyBpcnt(param);
        return countNum;
    }

    @Override
    public List<AccesOrderSort> orderRationReady(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderSort> list = accesOrderSortMapper.orderRationReady(param);
        return list;
    }

    @Override
    public int orderRationSpecBpcnt(Map<String, Object> param) {
        int countNum = accesOrderSortMapper.orderRationSpecBpcnt(param);
        return countNum;
    }

    @Override
    public List<AccesOrderSort> orderRationSpec(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderSort> list = accesOrderSortMapper.orderRationSpec(param);
        return list;
    }

    @Override
    public int orderFollowBpcnt(Map<String, Object> param) {
        int countNum = accesOrderSortMapper.orderFollowBpcnt(param);
        return countNum;
    }

    @Override
    public List<AccesOrderSort> orderFollowList(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesOrderSort> list = accesOrderSortMapper.orderFollowList(param);
        return list;
    }

    @Override
    public AccesOrderSort savaOrderSortStatus(AccesOrderSort am, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        am.setOperatorIp(operatorIp);
        accesOrderSortMapper.updateByPrimaryKeySelective(am);
        return am;
    }

    @Override
    public AccesOrderSort layerSort(AccesOrderSort am, HttpServletRequest request) {

        if (null!=am.getAccesOneScrapRate()&&null!=am.getAccesOneSingleUse()) {
            am.setAccesOneQuantity(calAccesOrderSortNum(am.getOrderNum(),am.getAccesOneScrapRate(),
                    am.getAccesOneSingleUse()));
        }
        if (null!=am.getAccesTwoScrapRate()&&null!=am.getAccesTwoSingleUse()) {

            am.setAccesTwoQuantity(calAccesOrderSortNum(am.getOrderNum(),am.getAccesTwoScrapRate(),
                    am.getAccesTwoSingleUse()));
        }
        if (null!=am.getAccesThreeScrapRate()&&null!=am.getAccesThreeSingleUse()) {

            am.setAccesThreeQuantity(calAccesOrderSortNum(am.getOrderNum(),am.getAccesThreeScrapRate(),
                    am.getAccesThreeSingleUse()));
        }
        if (null!=am.getAccesFourScrapRate()&&null!=am.getAccesFourSingleUse()) {

            am.setAccesFourQuantity(calAccesOrderSortNum(am.getOrderNum(),am.getAccesFourScrapRate(),
                    am.getAccesFourSingleUse()));
        }
        if (null!=am.getAccesFiveScrapRate()&&null!=am.getAccesFiveSingleUse()) {

            am.setAccesFiveQuantity(calAccesOrderSortNum(am.getOrderNum(),am.getAccesFiveScrapRate(),
                    am.getAccesFiveSingleUse()));
        }
        if (null!=am.getAccesSixScrapRate()&&null!=am.getAccesSixSingleUse()) {
            am.setAccesSixQuantity(calAccesOrderSortNum(am.getOrderNum(),am.getAccesSixScrapRate(),
                    am.getAccesSixSingleUse()));
        }

        accesOrderSortMapper.updateByPrimaryKeySelective(am);
        return am;
    }
}

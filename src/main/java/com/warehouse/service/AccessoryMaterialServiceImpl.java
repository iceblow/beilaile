package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.warehouse.constant.WastageConstant;
import com.warehouse.dao.AccessoryMaterialMapper;
import com.warehouse.entity.AccessoryMaterial;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;

/**
 * Created by Beilaile on 2016/12/8.
 */
@Service
public class AccessoryMaterialServiceImpl implements AccessoryMaterialService {

    @Resource
    public AccessoryMaterialMapper accessoryMaterialMapper;


    @Override
    public int addAccessoryMaterial(AccessoryMaterial accessoryMaterial, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        accessoryMaterial.setOperatorIp(operatorIp);
        accessoryMaterial.setCreatedTime(DateUtils.formateDaTime(new Date()));
        accessoryMaterial.setMarkStatus("1");

        accessoryMaterial.setCropNumber(100);
        accessoryMaterial.setPopperScrapRate(WastageConstant._POPPER_SCRAP_RATE);
        accessoryMaterial.setTagLoss(WastageConstant._TAG_LOSS);
        accessoryMaterial.setLoss(WastageConstant._WRAPPINGS_LOSS);
        int result = accessoryMaterialMapper.addAccessoryMaterial(accessoryMaterial);
        return result;
    }

    @Override
    public int modifyAccessoryMaterial(AccessoryMaterial accessoryMaterial, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        accessoryMaterial.setOperatorIp(operatorIp);
        accessoryMaterial.setModifyTime(DateUtils.formateDaTime(new Date()));
        int result = accessoryMaterialMapper.modifyAccessoryMaterial(accessoryMaterial);
        return result;
    }

    @Override
    public int delAccessoryMaterialById(AccessoryMaterial accessoryMaterial, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        accessoryMaterial.setOperatorIp(operatorIp);
        accessoryMaterial.setDeleteTime(DateUtils.formateDaTime(new Date()));
        accessoryMaterial.setMarkStatus("0");
        int result = accessoryMaterialMapper.delAccessoryMaterialById(accessoryMaterial);
        return result;
    }

    @Override
    public int getAccessoryMaterialByPageCount(Map<String, Object> anyVal) {
        int result = accessoryMaterialMapper.getAccessoryMaterialByPageCount(anyVal);
        return result;
    }

    @Override
    public List<AccessoryMaterial> findConditionAccessoryMaterialByPage(Map<String, Object> anyVal) {
        int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
        int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        anyVal.put("pageNow", pageNow);
        anyVal.put("pageSize", pageSize);
        List<AccessoryMaterial> list = accessoryMaterialMapper.findConditionAccessoryMaterialByPage(anyVal);
        return list;
    }

    @Override
    public AccessoryMaterial getAccessoryMaterialById(Integer id) {
        AccessoryMaterial accessoryMaterial = accessoryMaterialMapper.getAccessoryMaterialById(id);

        return accessoryMaterial;
    }

    @Override
    public AccessoryMaterial savaAccessoryMaterialArgsUpdate(AccessoryMaterial am, HttpServletRequest request) {
        String operatorIp = ClientIpUtil.getIpAddress(request);
        am.setOperatorIp(operatorIp);
        am.setModifyTime(DateUtils.formateDaTime(new Date()));

        /**
         * 裁减数不为空 判断传入要修改的是哪个值 如果相应的参数已经存在 则计算对应的数量
         * @param 裁剪数cropNumber
         * 损耗率（ AccessoriesScrapRateA/B/C）
         * 单耗 (popperSingleUse AccessoriesA/B/CSingleUse)
         * formula  数量 = 裁剪数 * 损耗率 * 单号
         */
        AccessoryMaterial aceMatOri =accessoryMaterialMapper.getAccessoryMaterialById(am.getId());
        Integer cropNumberOri = aceMatOri.getCropNumber();//原数据中的裁剪数

        //若损耗率常量未添加 则更新常量数据
        if (aceMatOri.getPopperScrapRate()==null) {
            insetConsWastage(aceMatOri);
        }
        if (cropNumberOri!= null) {

            //修改辅料A 损耗率
            if (am.getAccessoriesScrapRateA()!= null){
                if (aceMatOri.getAccessoriesASingleUse()!= null) {
                    Double param = calAccessoriesNum(cropNumberOri,am.getAccessoriesScrapRateA(),
                            aceMatOri.getAccessoriesASingleUse());
                    am.setAccessoriesAQuantity(param);
                }

            }

            // 修改辅料B 损耗率
            if (am.getAccessoriesScrapRateB()!= null){
                if (aceMatOri.getAccessoriesBSingleUse()!=null) {
                    am.setAccessoriesBQuantity(calAccessoriesNum(cropNumberOri,am.getAccessoriesScrapRateB(),
                            aceMatOri.getAccessoriesBSingleUse()));
                }

            }

            // 修改辅料C 损耗率
            if (am.getAccessoriesScrapRateC()!= null){
                if (aceMatOri.getAccessoriesCSingleUse()!= null) {
                    am.setAccessoriesCQuantity(calAccessoriesNum(cropNumberOri,am.getAccessoriesScrapRateC(),
                            aceMatOri.getAccessoriesCSingleUse()));
                }
            }

            // 修改辅料A 单耗
            if (am.getAccessoriesASingleUse()!= null) {
                if (aceMatOri.getAccessoriesScrapRateA()!= null) {
                    am.setAccessoriesAQuantity(calAccessoriesNum(cropNumberOri,aceMatOri.getAccessoriesScrapRateA(),
                            am.getAccessoriesASingleUse()));
                }
            }

            // 修改辅料B 单耗
            if (am.getAccessoriesBSingleUse()!= null) {
                if (aceMatOri.getAccessoriesScrapRateB()!= null) {
                    am.setAccessoriesBQuantity(calAccessoriesNum(cropNumberOri,aceMatOri.getAccessoriesScrapRateB(),
                            am.getAccessoriesBSingleUse()));
                }
            }

            // 修改辅料C 单耗
            if (am.getAccessoriesCSingleUse()!= null) {
                if (aceMatOri.getAccessoriesScrapRateC()!= null) {
                    am.setAccessoriesCQuantity(calAccessoriesNum(cropNumberOri,aceMatOri.getAccessoriesScrapRateC(),
                            am.getAccessoriesCSingleUse()));
                }
            }

            //修改 五爪扣 单耗自填  损耗率固定
            if (am.getPopperSingleUse()!= null) {
                am.setPopperQuantity(calPPtNum(cropNumberOri,WastageConstant._POPPER_SCRAP_RATE,
                        Double.valueOf(am.getPopperSingleUse())));

            }
            //吊牌 损耗率
            if (am.getTotalCode() == null) {
                am.setTotalCode(calPPtNum(cropNumberOri,WastageConstant._TAG_LOSS,1.0));
            }

            //包装袋 损耗率
            if (aceMatOri.getPackingBagQuantity() == null) {
                am.setPackingBagQuantity(calPPtNum(cropNumberOri,WastageConstant._WRAPPINGS_LOSS,1.0));
            }
            am.setLoss(WastageConstant._WRAPPINGS_LOSS);
            am.setTagLoss(WastageConstant._TAG_LOSS);
            am.setPopperScrapRate(WastageConstant._POPPER_SCRAP_RATE);
        }

        //保存am  包含 修改值 及相应的数量
        accessoryMaterialMapper.savaAccessoryMaterialArgsUpdate(am);
        return am;
    }
//  弃用功能
//    @Override
//    public int confirmReady(Integer amId, HttpServletRequest request) {
//        AccessoryMaterial accessoryMaterial = updateIssuedStatusCommon(amId, request);
//        accessoryMaterial.setIssuedStatus("准备就绪");
//        int re = accessoryMaterialMapper.updateIssuedStatus(accessoryMaterial);
//        return re;
//    }
//
//    @Override
//    public int alreadyIssue(Integer amId, HttpServletRequest request) {
//        AccessoryMaterial accessoryMaterial = updateIssuedStatusCommon(amId, request);
//        accessoryMaterial.setIssuedStatus("确认发放");
//        int re = accessoryMaterialMapper.updateIssuedStatus(accessoryMaterial);
//        return re;
//    }
//
//    @Override
//    public int resetState(Integer amId, HttpServletRequest request) {
//        AccessoryMaterial accessoryMaterial = updateIssuedStatusCommon(amId, request);
//        accessoryMaterial.setIssuedStatus("");
//        int re = accessoryMaterialMapper.updateIssuedStatus(accessoryMaterial);
//        return re;
//    }

    @Override
    public int manageAmComplete(Integer amId, HttpServletRequest request) {
        AccessoryMaterial accessoryMaterial = updateIssuedStatusCommon(amId, request);
        accessoryMaterial.setIssuedStatus("理单完成");
        int re = accessoryMaterialMapper.updateIssuedStatus(accessoryMaterial);
        return re;
    }

    //修改状态的通用部分
    private AccessoryMaterial updateIssuedStatusCommon(int amId,HttpServletRequest request) {
        //AccessoryMaterial am = accessoryMaterialMapper.getAccessoryMaterialById(amId);
        String operatorIp = ClientIpUtil.getIpAddress(request);
        AccessoryMaterial accessoryMaterial = accessoryMaterialMapper.getAccessoryMaterialById(amId);
        accessoryMaterial.setOperatorIp(operatorIp);
        accessoryMaterial.setModifyTime(DateUtils.formateDaTime(new Date()));
        return accessoryMaterial;
    }

    //插入损耗率 固定值
    private int insetConsWastage(AccessoryMaterial accessoryMaterial) {
        accessoryMaterial.setPopperScrapRate(WastageConstant._POPPER_SCRAP_RATE);
        accessoryMaterial.setTagLoss(WastageConstant._TAG_LOSS);
        accessoryMaterial.setLoss(WastageConstant._WRAPPINGS_LOSS);
        int re = accessoryMaterialMapper.savaAccessoryMaterialArgsUpdate(accessoryMaterial);
        return re;
    }

    /**
     * 计算辅料 A B C 用量  返回 小数  向上取整
     * @param cropNum 裁剪数
     * @param scrapRate 损耗率
     * @param singleUse 单耗
     * @return
     */
    private Double calAccessoriesNum(Integer cropNum, Double scrapRate,Double singleUse){
        Double result = cropNum * (scrapRate) * singleUse ;
        result = Math.ceil(result);
        return result;
    }

    /**
     * 计算五爪扣 吊牌 包装袋数量  返回整数 向上取整
     * @param cropNum  裁剪数
     * @param pptScrapRate 损耗率
     * @param singleUse  单耗
     * @return
     */
    private int calPPtNum(Integer cropNum, Double pptScrapRate,Double singleUse){
        Double result = cropNum * (pptScrapRate) * singleUse ;
        result = Math.ceil(result);
        int re = result.intValue();
        return re;
    }
}

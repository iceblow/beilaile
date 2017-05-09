package com.warehouse.constant;

/**
 * 方法状态常量
 *
 * Created by admin on 2016/12/31.
 */
public class StateConstant {

    public final static String _REJECT_PURCHASE = "驳回" ;

    public final static String _CONFIRM_PURCHASE = "确认采购" ;

    public final static String _AREADY_PREPARED = "准备就绪";

    public final static String _CONFIRM_ISSUE_PURCHASE = "确认发放";

    public final static String _RATION_PREPARE_COMPLETE = "配置完成";

    //======================== 辅料理单 状态常量 =============================
    public final static String _AM_ORDER_COMPLETE = "理单完成";
    public final static String _AM_ORDER_WAITING = "未理单";
    public final static String _AM_ORDER_REJECTED = "被退回";
    public final static String _AM_ORDER_ISSUED = "已发放";
    public final static String _AM_ORDER_PACKAGED = "配包完成";


    //======================== 库存准备 状态常量 ===============================
    public final static String _RATION_ALREADY_PREPARED = "可配发";//原始为 准备发放

    public static final String _RATION_REISSUE = "追加可配发";




    public final static String _RATION_PURCHASE_ING = "采购中";

    public final static String _RATION_PACKAGE_READY = "已配包";

    public final static String _RATION_ALREADY_ISSUE = "已发放";

    public static final String _RATION_DONE = "处理完成";

    //======================== 工厂代办 状态常量============================================

    public final static String _FACTORY_BACKLOG_WAITING = "等待处理";

    public final static String _FACTOYR_BACKLOG_COMPLETED = "已领取";

    public final static String _FACTORY_BACKLOG_TIME_OUT = "超时未领取";

    //+++++++++++++++++++++++++++++++ 辅料配发 方式 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static final String _ISSUE_METHOD_BY_ORDER_ = "订单数配发";
    public static final String _ISSUE_METHOD_BY_CROP_ = "裁剪数配发";
    public static final String _ISSUE_METHOD_BY_DIFF_ = "追加补料单";


    //===========================  excel 列名 =======================================================
    public static final String _XLS_ID_ = "编号";

    public static final String _XLS_WAVE = "波段";

    public static final String _XLS_ISSUE_NAME = "辅料名称";

    public static final String _XLS_ISSUE_SERINUM = "编号";

    public static final String _XLS_ACTUAL_QUALITY = "数量";

    public static final String _XLS_ISSUE_CODE = "辅料条码";

    public static final String _XLS_ISSUE_ETALON = "规格";

    public static final String _XLS_ISSUE_QUALITY = "配料数量";

    public static final String _XLS_ISSUE_DETAIL = "配料详情";

    public static final String _XLS_ISSUE_METHOD = "配发方式";

    public static final String _XLS_SYNCH_TIME = "要求配发时间";


}















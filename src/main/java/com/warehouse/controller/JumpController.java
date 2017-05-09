package com.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.warehouse.constant.StaticPages.*;

/**
 * Created by Administrator on 2016/8/19.
 */
@Controller
public class JumpController {
	@RequestMapping(value = "index")
	public String index() {
		return _HTML_INDEX_;
	}

	@RequestMapping(value = "alertIndex")
	public String alertIndex() {

		return _HTML_ALERT_INDEX;
	}

	@RequestMapping(value = "jqgrid")
	public String jqgrid() {
		return _HTML_JQGRID_;
	}

	@RequestMapping(value = "salesReport")
	public String salesReport() {
		return _HTML_SALESrEPORT_;
	}

	@RequestMapping(value = "stock_alert")
	public String stock_alert() {
		return _HTML_STOCK_ALERT_;
	}

	@RequestMapping(value = "factoryImg.html")
	public String factoryImg() {
		return _HTML_FACTORY_IMG_;
	}

	@RequestMapping(value = "goodsImg.html")
	public String goodsImg() {
		return _HTML_GOODS_IMG_;
	}

	@RequestMapping(value = "goods_images.html")
	public String goods_images() {
		return _HTML_GOODS_IMAGES_;
	}

	@RequestMapping(value = "login.html")
	public String login() {
		return _HTML_LOGIN_;
	}

	@RequestMapping(value = "profile.html")
	public String profile() {
		return _HTML_PROFILE_;
	}

	@RequestMapping(value = "user/dropzone")
	public String dropzone() {
		return _HTML_DROPZONE_;
	}

	/**
	 * 设计师首页
	 *
	 * @return
	 */
	@RequestMapping(value = "designers")
	public String designers() {
		return _HTML_DESIGNERS_;
	}

	/**
	 * 设计师导入
	 *
	 * @return
	 */
	@RequestMapping(value = "designersImport")
	public String designersImport() {
		return _HTML_DESIGNERS_IMPORT_;
	}

	@RequestMapping(value = "designersAllGoods")
	public String designersAllGoods() {
		return _HTML_DESIGNERS_All_Goods_;
	}

	@RequestMapping(value = "getDesignRank")
	public String getDesignRank() {
		return _HTML_DESIGN_RANK_;
	}

	/**
	 * 设计师排行榜
	 *
	 * @return
	 */
	@RequestMapping(value = "designSalesRank")
	public String designSalesRank() {
		return _HTML_DESIGN_SALES_RANK_;
	}

	/**
	 * 淘宝客数据导入
	 *
	 * @return
	 */
	@RequestMapping(value = "taobaoke")
	public String taobaoke() {
		return _HTML_TAO_BAO_KE_;
	}

	/**
	 * 裁片外发生产进度表
	 */
	@RequestMapping(value = "buildProgress")
	public String buildProgress() {
		return _HTML_BUILD_PROGRESS_;
	}

	/**
	 * 裁片外发生产进度报表
	 */
	@RequestMapping(value = "buildProgressReport")
	public String buildProgressReport() {
		return _HTML_BUILD_PROGRESS_REPORT_;
	}

	/**
	 * 裁片外发七日均值生产进度报表
	 */
	@RequestMapping(value = "buildProgressWeeklyReport")
	public String buildProgressWeeklyReport() {
		return _HTML_BUILD_PROGRESS_WEEKLY_REPORT_;
	}

	/**
	 * 淘宝客数据导入
	 *
	 * @return
	 */
	@RequestMapping(value = "stock")
	public String stock() {
		return _HTML_STOCK_STOCK_;
	}

	/**
	 * 淘宝客数据导入
	 *
	 * @return
	 */
	@RequestMapping(value = "Test")
	public String Testjsp() {
		return "/designers/Test.jsp";
	}

	/**
	 * 淘宝客数据导入
	 *
	 * @return
	 */
	@RequestMapping(value = "cuttingMain")
	public String cutting() {
		return _HTML_CUTTING_MAIN_;
	}

	/**
	 * 工厂经销单仓库面料出库数据
	 *
	 * @return
	 */
	@RequestMapping(value = "distributionFabric")
	public String distributionFabric() {
		return _HTML_DISTRIBUTION_FABRIC_;
	}

	/**
	 * 淘宝客数据导入
	 *
	 * @return
	 */
	@RequestMapping(value = "fabric")
	public String fabric() {
		return _HTML_FABRIC_MAIN_;
	}

	/**
	 * 订单
	 *
	 * @return
	 */
	@RequestMapping(value = "orderMemo")
	public String orderMemo() {
		return _HTML_ORDERMEMO_MAIN_;
	}

	/**
	 * 外加工
	 *
	 * @return
	 */
	@RequestMapping(value = "outsideproces")
	public String outsideproces() {
		return _HTML_outsideproces_MAIN_;
	}

	/**
	 * 出库数据
	 *
	 * @return
	 */
	@RequestMapping(value = "fabricOutflow")
	public String fabricOutflow() {
		return _HTML_FABRIC_OUTFLOW_;
	}

	/**
	 * 入库数据
	 *
	 * @return
	 */
	@RequestMapping(value = "fabricStorage")
	public String fabricStorage() {
		return _HTML_FABRIC_STORAGE_;
	}

	/**
	 * 理单跟踪记录表
	 *
	 * @return
	 */
	@RequestMapping(value = "tracking")
	public String tracking() {
		return _HTML_TRACKING_FABRIC_;
	}

	/**
	 * 匹印厂领料日报表
	 *
	 * @return
	 */
	@RequestMapping(value = "factoryReceiveFabric")
	public String factoryReceiveFabric() {
		return _HTML_FACTORY_RECEIVE_FABRIC_;
	}

	/**
	 * 匹印厂回料日报表
	 *
	 * @return
	 */
	@RequestMapping(value = "factoryReturnFabric")
	public String factoryReturnFabric() {
		return _HTML_FACTORY_RETYRN_FABRIC_;
	}

	/**
	 * 裁片印绣花领料日报表
	 */
	@RequestMapping(value = "getEmbroider")
	public String getEmbroider() {
		return _HTML_GETEMBROIDER_MAIN_;
	}

	/**
	 * 裁片印绣花回料日报表
	 */
	@RequestMapping(value = "outEmbroider")
	public String outEmbroider() {
		return _HTML_OUTEMBROIDER_MAIN_;
	}

	/**
	 * 外加工各款价格日报表
	 *
	 * @return
	 */
	@RequestMapping(value = "outsideDaily")
	public String outsideDaily() {
		return _HTML_OUTSIDEDAILY_MAIN_;
	}

	/**
	 * QC追踪
	 *
	 * @return
	 */
	@RequestMapping(value = "QCTrack")
	public String QCTrack() {
		return _HTML_QCTRACK_MAIN_;
	}

	/**
	 * 采购入库表
	 *
	 * @return
	 */
	@RequestMapping(value = "inputstorage")
	public String inputstorage() {
		return _HTML_INPUTSTORAGE_MAIN_;
	}

	/**
	 * 面料进度
	 *
	 * @return
	 */
	@RequestMapping(value = "fabricmanagement")
	public String fabricmanagement() {
		return _HTML_FABRICMANEGEMENT_MAIN_;
	}

	/**
	 * 面料采购
	 *
	 * @return
	 */
	@RequestMapping(value = "fabricSourcing")
	public String fabricSourcing() {
		return _HTML_FABRIC_SOURCING_;
	}

	/**
	 * 生产报表
	 *
	 * @return
	 */
	@RequestMapping(value = "storageReport")
	public String storageReport() {
		return _HTML_FABRIC_LOOK_;
	}

	/**
	 * 成品入库七日均值日报表
	 *
	 * @return
	 */
	@RequestMapping(value = "weeklyReport")
	public String weeklyReport() {
		return _HTML_FABRIC_WEEKLY_AVERAGE_REPORT;
	}

	/**
	 * 登陆
	 *
	 * @return
	 */
	@RequestMapping(value = "userinfo")
	public String userinfo() {
		return _HTML_INDEX_;
	}

	/**
	 * 服装开发管理
	 *
	 * @return
	 */
	@RequestMapping(value = "apparelDevelopmentManagement")
	public String apparelDevelopmentManagement() {
		return _HTML_DESIGN_APPAREL_DEVELOPMENT_MANAGEMENT;
	}

	/**
	 * 补工艺单管理
	 *
	 * @return
	 */
	@RequestMapping(value = "apparelDevelopmentMissSampleimg")
	public String apparelDevelopmentMissSampleimg() {
		return _HTML_DESIGN_APPAREL_DEVELOPMENT_MISS_SAMPLEIMG;
	}

	/**
	 * 登陆
	 *
	 * @return
	 */
	@RequestMapping(value = "product")
	public String product() {
		return _HTML_PRODUCT_;
	}

	/**
	 * 入库日报总表
	 *
	 * @return
	 */
	@RequestMapping(value = "putInStorageReport")
	public String putInStorageReport() {
		return _HTML_PUT_IN_STORAGE_REPORT_;
	}

	/**
	 * 入库日报总表
	 *
	 * @return
	 */
	@RequestMapping(value = "problemFeedback.html")
	public String problemFeedback() {
		return _HTML_PROBLEM_FEEDBACK_;
	}

	/**
	 * 设计师数据汇总
	 *
	 * @return
	 */
	@RequestMapping(value = "apparelDevelopmentManagementCollect")
	public String apparelDevelopmentManagementCollect() {
		return _HTML_DESIGN_APPAREL_DEVELOPMENT_MANAGEMENT_COLLECT;
	}

	/**
	 * 设计师数据汇总
	 *
	 * @return
	 */
	@RequestMapping(value = "boardRoom")
	public String boardRoom() {
		return _HTML_BOARD_ROOM_;
	}

	@RequestMapping(value = "stillClothes")
	public String stillClothes() {
		return _HTML_STILL_CLOTHES_;
	}

	/**
	 * 辅料采购申请
	 *
	 * @return
	 */
	@RequestMapping(value = "auxiliaryFabric")
	public String auxiliaryFabric() {
		return _HTML_DESIGN_AUXILIARY_FABRIC_;
	}

	/**
	 * 运营返单
	 * 
	 * @return
	 */
	@RequestMapping(value = "apparelDevelopmentReturn")
	public String apparelDevelopmentReturn() {
		return _HTML_OPERATE_APPAREL_DEVELOPMENT_RETURN;
	}

	/**
	 * 辅料理单
	 *
	 * @return
	 */
	@RequestMapping(value = "accessoryMaterial")
	public String accessoryMaterial() {
		return _HTML_ACCESSORY_MATERIAL_;
	}

	/**
	 * 面料理单
	 *
	 * @return
	 */
	@RequestMapping(value = "fabricMaterial")
	public String fabricMaterial() {
		return _HTML_FABRIC_MATERIAL_;
	}

	/**
	 * 工厂进度
	 *
	 * @return
	 */
	@RequestMapping(value = "buildProgressFactoryDailyReport")
	public String buildProgressFactoryDailyReport() {
		return _HTML_BUILD_PROGRESS_FACTORY_DAILY_REPORT_;
	}

	/**
	 * 商品详细信息
	 *
	 * @return
	 */
	@RequestMapping(value = "productInfo")
	public String productInfo() {
		return _HTML_PRODUCT_INFO_;
	}

	/**
	 * 领料通知
	 *
	 * @return
	 */
	@RequestMapping(value = "receiveMaterialNotice")
	public String receiveMaterialNotice() {
		return _HTML_RECEIVE_MATERIAL_NOTICE_;
	}

	/**
	 * 板房生产计划
	 *
	 * @return
	 */
	@RequestMapping(value = "boardWorksSchedule")
	public String boardWorksSchedule() {
		return _HTML_BOARD_WORKS_SCHEDULE_;
	}

	/**
	 * 印绣花任务分配
	 *
	 * @return
	 */
	@RequestMapping(value = "TaskDistribution")
	public String TaskDistribution() {
		return _HTML_TASK_DISTRIBUTION_;
	}

	/***
	 * 商品返单
	 * 
	 * @return
	 */
	@RequestMapping(value = "productToBack")
	public String productToBack() {
		return _HTML_OPERATE_PRODUCT_TOBACK_;
	}

	/**
	 * 确认采购面料
	 *
	 * @return
	 */
	@RequestMapping(value = "confirmPurchaseFabric")
	public String confirmPurchaseFabric() {
		return _HTML_CONFIRM_PURCHASE_FABRIC_;
	}

	/***
	 * 库存分析
	 * 
	 * @return
	 */
	@RequestMapping(value = "productBack")
	public String productBack() {
		return _HTML_OPERATE_PRODUCT_BACK_;
	}

	/***
	 * 申请审批
	 * 
	 * @return
	 */
	@RequestMapping(value = "approvalApplication")
	public String approvalApplication() {
		return _HTML_OPERATE_APPROVAL_APPLICATION_;
	}

	/***
	 * 撤销订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "cancelOrder")
	public String cancelOrder() {
		return _HTML_OPERATE_CANCEL_ORDER_;
	}

	/***
	 * 员工信息 chiayich
	 * 
	 * @return
	 */
	@RequestMapping(value = "employeesTest")
	public String employeesTest() {
		return _HTML_EMPLOYEES_TEST_;
	}

	/***
	 * chiayich 弃用
	 * 
	 * @return
	 */
	// @RequestMapping(value = "accessoryPrepared")
	// public String accessoryPrepared() {
	// return _HTML_ACCESSORY_PREPARED_;
	// }

	/**
	 * 面料采购
	 * 
	 * @return
	 */
	@RequestMapping(value = "accessoryPurchase")
	public String accessoryPurchase() {
		return _HTML_ACCESSORY_PURCHASE_;
	}

	/**
	 * 面料配置
	 * 
	 * @return
	 */
	@RequestMapping(value = "accessoryRation")
	public String accessoryRation() {
		return _HTML_ACCESSORY_RATION_;
	}

	/***
	 * 订单详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "purchaseOrdersDetail")
	public String purchaseOrdersDetail() {
		return _HTML_ORDERMEMO_PURCHASEORDERSDETAIL_;
	}

	/***
	 * 销售记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "salesReportOfWdt")
	public String salesReportOfWdt() {
		return _HTML_ORDERMEMO_SALESREPORTOFWDT_;
	}

	/***
	 * 滞销记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "salesSlowMovingStock")
	public String salesSlowMovingStock() {
		return _HTML_OPERATE_SALESSLOWMOVINGSTOCK_;
	}

	/**
	 * 工厂待办
	 */
	@RequestMapping(value = "factoryBacklog")
	public String factoryBacklog() {
		return _HTML_FACTORY_BACKLOG_;
	}

	/**
	 * 辅料跟单
	 */
	@RequestMapping(value = "documentaryAccessory")
	public String documentaryAccessory() {
		return _HTML_DOCUMENTARY_ACCESSORY_;
	}

	/**
	 * 辅料理单
	 */
	@RequestMapping(value = "orderSortingAccessory")
	public String orderSortingAccessory() {
		return _HTML_ORDER_SORTING_ACCESSORY_;
	}

	/**
	 * 辅料出库
	 */
	@RequestMapping(value = "stockRemoveAccessory")
	public String stockRemoveAccessory() {
		return _HTML_STROCK_REMOVE_ACCESSORY_;
	}

	/**
	 *
	 * 辅料入库
	 */
	@RequestMapping(value = "storageAccessory")
	public String storageAccessory() {
		return _HTML_STORAGE_ACCESSORY_;
	}

	/**
	 * 辅料库存
	 */
	@RequestMapping(value = "inventoryAccessory")
	public String inventoryAccessory() {
		return _HTML_INVENTORY_ACCESSORY_;
	}

	/**
	 * 采购进度
	 */
	@RequestMapping(value = "procurementScheduleAccessory")
	public String procurementScheduleAccessory() {
		return _HTML_PROCUREMENT_SCHEDULE_ACCESSORY_;
	}

	/**
	 * 库存准备
	 */
	@RequestMapping(value = "orderRationAccessory")
	public String orderRationAccessory() {
		return _HTML_ORDER_RATION_ACCESSORY_;
	}

	/**
	 * 辅料配发
	 */
	@RequestMapping(value = "orderIssueAccessory")
	public String orderIssueAccessory() {
		return _HTML_ORDER_ISSUE_ACCESSORY_;
	}

	/**
	 * 辅料信息
	 */
	@RequestMapping(value = "accessoryInfo")
	public String accessoryInfo() {
		return _HTML_ACCESSORY_INFO_;
	}

	/**
	 * 辅料未配齐信息
	 */
	@RequestMapping(value = "orderRationWait")
	public String orderRationWait() {
		return _HTML_ORDER_RATION_WAIT_;
	}

	/**
	 * 辅料配发就绪信息
	 */
	@RequestMapping(value = "orderRationReady")
	public String orderRationReady() {
		return _HTML_ORDER_RATION_READY_;
	}

	/**
	 * 辅料已指定工厂信息
	 */
	@RequestMapping(value = "orderRationSpec")
	public String orderRationSpec() {
		return _HTML_ORDER_RATION_SPEC_;
	}

	/**
	 * 辅料理单弹出页面信息
	 */
	@RequestMapping(value = "sortLayer")
	public String sortLayer() {
		return _HTML_SORT_LAYER_;
	}

	/**
	 * 面料档案
	 * 
	 * @return
	 */
	@RequestMapping(value = "fabricFiles")
	public String fabricFiles() {
		return _HTML_FABRIC_FILES_;
	}

	/**
	 * 浩讯入库
	 * 
	 * @return
	 */
	@RequestMapping(value = "inputStorageHaoXun")
	public String inputStorageHaoXun() {
		return _HTML_INPUTSTORAGE_HAOXUN_;
	}

	/**
	 * 平台货品
	 * 
	 * @return
	 */
	@RequestMapping(value = "productTaoBaoInfo")
	public String productTaoBaoInfo() {
		return _HTML_PRODUCTT_TAOBAO_INFO_;
	}

	/**
	 * 未售杭州
	 * 
	 * @return
	 */
	@RequestMapping(value = "salesNotSaleHangZhou")
	public String salesNotSaleHangZhou() {
		return SALES_NOT_SALE_HANGZHOU;
	}

	/**
	 * 未售浩讯
	 * 
	 * @return
	 */
	@RequestMapping(value = "salesNotSaleHaoXun")
	public String salesNotSaleHaoXun() {
		return SALES_NOT_SALE_HAOXUN;
	}

	/**
	 * 面料到齐
	 * 
	 * @return
	 */
	@RequestMapping(value = "cuttingFabricCompleted")
	public String cuttingFabricCompleted() {
		return _HTML_CUTTING_FABRIC_COMPLETED_;
	}

	/**
	 * 裁剪完成
	 * 
	 * @return
	 */
	@RequestMapping(value = "printingCuttingCompleted")
	public String printingCuttingCompleted() {
		return _HTML_PRINTING_CUTTING_COMPLETED_;
	}

	/**
	 * 面料配备
	 * 
	 * @return
	 */
	@RequestMapping(value = "fabricOutflowReady")
	public String fabricOutflowReady() {
		return _HTML_FABRIC_OUTFLOW_READY_;
	}

	/**
	 * 待分发裁床表
	 */
	@RequestMapping(value = "piecesInformation")
	public String piecesInformation() {
		return _HTML_PIECESPRINT_PIECESINFORMATION;
	}

	/**
	 * 片印领料单
	 */
	@RequestMapping(value = "printMarkOrder")
	public String printMarkOrder() {
		return _HTML_PIECESPRINT_PRINTMARK_ORDER;
	}

	/**
	 * 发料详单
	 */
	@RequestMapping(value = "distributeDetailedOrder")
	public String distributeDetailedOrder() {
		return _HTML_PIECESPRINT_DISTRIBUTEDETAILED_ORDER;
	}

	/**
	 * 待分发车缝
	 */
	@RequestMapping(value = "sewingInformation")
	public String sewingInformation() {
		return _HTML_SEWINGPICK_SEWING_INFORMATION;
	}

	/**
	 * 车缝领料单
	 */
	@RequestMapping(value = "sewingPickingOrder")
	public String sewingPickingOrder() {
		return _HTML_SEWINGPICK_SEWING_PICKING_ORDER;
	}

	/**
	 * 车缝发料详单
	 */
	@RequestMapping(value = "sewingFactoryPickingOrder")
	public String sewingFactoryPickingOrder() {
		return _HTML_SEWINGPICK_SEWING_FACOTRY_PICKING_ORDER;
	}

	/**
	 * 生产问题反馈
	 * 
	 * @return
	 */
	@RequestMapping(value = "productionProblem")
	public String ProductionProblem() {
		return _HTML_PRODUCTION_PROBLEM_;
	}

	/**
	 * 车缝安排表
	 * 
	 * @return
	 */
	@RequestMapping(value = "taisanTrackingOutflow")
	public String taisanTrackingOutflow() {
		return _HTML_TAISAN_TRACKING_OUTFLOW;
	}

	/**
	 * 辅料安排表
	 * 
	 * @return
	 */
	@RequestMapping(value = "taisanAccesOutflow")
	public String taisanAccesOutflow() {
		return _HTML_TAISAN_ACCES_OUTFLOW;
	}

	/**
	 * 车缝裁片安排表
	 * 
	 * @return
	 */
	@RequestMapping(value = "taisanCuttingOutflow")
	public String taisanCuttingOutflow() {
		return _HTML_TAISAN_CUTTING_OUTFLOW;
	}

	/**
	 * 工厂档案
	 *
	 * @return
	 */
	@RequestMapping(value = "manufacturer")
	public String Manufacturer() {
		return _HTML_MANUFACTURER_;
	}

	/**
	 * 样衣安排
	 *
	 * @return
	 */
	@RequestMapping(value = "sampleArrange")
	public String sampleArrange() {
		return _HTML_SAMPLE_ARRANGE;
	}

	/**
	 * 印绣花理单
	 *
	 * @return
	 */
	@RequestMapping(value = "printingFinish")
	public String printingFinish() {
		return _HTML_PRINTING_FINISH;
	}

	/**
	 * 印绣花报价
	 *
	 * @return
	 */
	@RequestMapping(value = "printingQuote")
	public String printingQuote() {
		return _HTML_PRINTING_QUOTE;
	}

	/**
	 * 匹印面料配备
	 *
	 * @return
	 */
	@RequestMapping(value = "printingFabricArrange")
	public String printingFabricArrange() {
		return _HTML_PRINTING_FABRIC_ARRANGE;
	}

	/**
	 * 匹印加工情况
	 *
	 * @return
	 */
	@RequestMapping(value = "printingProcessCase")
	public String printingProcessCase() {
		return _HTML_PRINTING_PROCESS_CASE;
	}

	/**
	 * 片印加工情况
	 *
	 * @return
	 */
	@RequestMapping(value = "pieceProcessCase")
	public String pieceProcessCase() {
		return _HTML_PIECE_PROCESS_CASE;
	}

	/**
	 * 样衣安排
	 *
	 * @return
	 */
	@RequestMapping(value = "fabricSupplier")
	public String fabricSupplier() {
		return _HTML_FABRIC_SUPPLIER;
	}

	/**
	 * 样衣安排
	 *
	 * @return
	 */
	@RequestMapping(value = "colorCard")
	public String colorCard() {
		return _HTML_COLOR_CARD;
	}

	/**
	 * 
	 * 车缝问题反馈
	 * 
	 * @return
	 */
	@RequestMapping(value = "notStorageRecord")
	public String notStorageRecord() {
		return _HTML_NOT_STROAGE;
	}

	/**
	 * 
	 * 本周出货计划
	 * 
	 * @return
	 */
	@RequestMapping(value = "weekReport")
	public String weekReport() {
		return _HTML_WEEK_REPORT;
	}

	/**
	 * 
	 * 本周出货计划总表
	 * 
	 * @return
	 */
	@RequestMapping(value = "allWeekReport")
	public String allWeekReport() {
		return _HTML_ALL_WEEK_REPORT;
	}

	/**
	 * 
	 * 本周出货计划总表 只读
	 * 
	 * @return
	 */
	@RequestMapping(value = "onlyReadWeekReport")
	public String onlyReadWeekReport() {
		return _HTML_ONLY_READ_WEEK_REPORT;
	}

	/**
	 * 
	 * 下周出货计划
	 * 
	 * @return
	 */
	@RequestMapping(value = "nextWeekReport")
	public String nextWeekReport() {
		return _HTML_ONLY_NEXT_WEEK_REPORT;
	}

	/**
	 * 
	 * 退料表
	 * 
	 * @return
	 */
	@RequestMapping(value = "fabricReturnBack")
	public String fabricReturnBack() {
		return _HTML_FABRIC_RETURN_BACK;
	}

	/**
	 * 
	 * 买手订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "apparelDevelopmentDesignBuyerOrder")
	public String apparelDevelopmentDesignBuyerOrder() {
		return _HTML_APPAREL_DEVELOPMENT_Design_BuyerOrder;
	}

	/**
	 * 
	 * 返单纸样表
	 * 
	 * @return
	 */
	@RequestMapping(value = "returnToSinglePattern")
	public String returnToSinglePattern() {
		return _HTML_RETURN_TO_SINGLE_PATTERN;
	}

	/**
	 * 
	 * 面料合价表
	 * 
	 * @return
	 */
	@RequestMapping(value = "fabricTotalPrice")
	public String fabricTotalPrice() {
		return _HTML_FABRIC_TOTAL_PRICE;
	}

	/**
	 * 
	 * 返修开单
	 * 
	 * @return
	 */
	@RequestMapping(value = "returnrepairdoucuments")
	public String returnrepairdoucuments() {
		return _HTML_RETUR_NREPAIR_DOUCUMENTS;
	}

	/**
	 * 
	 * 成衣和价表
	 * 
	 * @return
	 */
	@RequestMapping(value = "clothesTotalPrice")
	public String clothesTotalPrice() {
		return _HTML_CLOTHES_TOTAL_PRICE;
	}

	/**
	 * 
	 * 入库比例
	 * 
	 * @return
	 */
	@RequestMapping(value = "inputstorageratio")
	public String inputstorageratio() {
		return _INPUT_STORAGE_RATIO;
	}

	/**
	 * 
	 * 返修入库
	 * 
	 * @return
	 */
	@RequestMapping(value = "returnrepair")
	public String returnrepair() {
		return _HTML_RETUR_NREPAIR_;
	}

	/**
	 * 
	 * 已裁剪未领料
	 * 
	 * @return
	 */
	@RequestMapping(value = "problemNotReceiveMaterial")
	public String problemNotReceiveMaterial() {
		return PROBLEM_NOT_RECEIVE_MATERIAL_;
	}

	/**
	 * 
	 * 面料已入库但未发放
	 * 
	 * @return
	 */
	@RequestMapping(value = "problemNotGrant")
	public String problemNotGrant() {
		return PROBLEM_NOT_GRANT_;
	}

	/**
	 * 
	 * 未入库跟踪
	 * 
	 * @return
	 */
	@RequestMapping(value = "notStorageTracking")
	public String notStorageTracking() {
		return _HTML_NOT_STORAGE_TRACKING;
	}

	/**
	 * 
	 * 下单跟踪
	 * 
	 * @return
	 */
	@RequestMapping(value = "orderTracking")
	public String orderTracking() {
		return _HTML_ORDER_TRACKING;
	}

	/**
	 * 已经完成订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "distributionCompletedOrder")
	public String distributionCompletedOrder() {
		return _HTML_DISTRIBUTION_COMPLETED_ORDER;
	}

	/**
	 * 经销单设置
	 * 
	 * @return
	 */
	@RequestMapping(value = "distributionSetUp")
	public String distributionSetUp() {
		return _DISTRIBUTION_SET_UP;
	}

	/**
	 * 经销单打样
	 * 
	 * @return
	 */
	@RequestMapping(value = "distributionMakSample")
	public String distributionMakSample() {
		return _HTML_DISTRIBUTION_MAK_SAMPLE;
	}

	/**
	 * 经销单报价
	 * 
	 * @return
	 */
	@RequestMapping(value = "distributionQuote")
	public String distributionQuote() {
		return _HTML_DISTRIBUTION_QUOTE;
	}

	/**
	 * 经销单下单
	 * 
	 * @return
	 */
	@RequestMapping(value = "distributionConfirmOrder")
	public String distributionConfirmOrder() {
		return _HTML_DISTRIBUTION_CONFIRM_ORDER;
	}

	/**
	 * 经销单出库
	 * 
	 * @return
	 */
	@RequestMapping(value = "distributionDealerDelivery")
	public String distributionDealerDelivery() {
		return _HTML_DISTRIBUTION_DEALER_DELIVERY;
	}

	/**
	 * 经销单裁剪
	 * 
	 * @return
	 */
	@RequestMapping(value = "distributionClippingNumber")
	public String distributionClippingNumber() {
		return _HTML_DISTRIBUTION_CLIPPING_NUMBER;
	}

	/**
	 * 仓库面料
	 * 
	 * @return
	 */
	@RequestMapping(value = "inventoryFabricDetails")
	public String inventoryFabricDetails() {
		return _HTML_INVENTORY_FABRIC_DETAILS;
	}

	/**
	 * 仓库出库面料
	 * 
	 * @return
	 */
	@RequestMapping(value = "inventoryFabricOutput")
	public String inventoryFabricOutput() {
		return _HTML_INVENTORY_FABRIC_OUTPUT;
	}
	/**
	 * 面料编码入库流程信息表
	 * 
	 * @return
	 */
	@RequestMapping(value = "fabricCodeProcessInformation")
	public String fabricCodeProcessInformation() {
		return 	_HTML_INVENTORY_FABRIC_CODE_PROCESS;
	}


	/**
	 * 经销单生产环节
	 */
	@RequestMapping(value = "distributionProduction")
	public String distributionProduction() {
		return _DISTRIBUTION_PRODUCTION;
	}

	/**
	 * 经销单原料采购
	 */
	@RequestMapping(value = "distributionBuyMaterial")
	public String distributionBuyMaterial() {
		return _Distribution_Buy_Material;
	}

	/**
	 * 经销单后道
	 */
	@RequestMapping(value = "distributionFinishProductPerfect")
	public String distributionFinishProductPerfect() {
		return _DISTRIBUTION_FINISH_PRODUCT_PERFECT;
	}

	/**
	 * 经销单汇总
	 */
	@RequestMapping(value = "distributionSummary")
	public String distributionSummary() {
		return _HTML_DISTRIBUTION_SUMMARY;
	}

	/**
	 * 仓库入库面料
	 * 
	 * @return
	 */
	@RequestMapping(value = "inventoryFabricStorage")
	public String inventoryFabricStorage() {
		return _HTML_INVENTORY_FABRIC_STORAGE;
	}

	/**
	 * 面料出入库信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "inventoryFabricSingleDetails")
	public String inventoryFabricSingleDetails() {
		return _HTML_INVENTORY_FABRIC_SINGLE_DETAILS;
	}

	/**
	 * 经销领面料
	 * 
	 * @return
	 */
	@RequestMapping(value = "distributionReceiveFabric")
	public String distributionReceiveFabric() {
		return _HTML_DISTRIBUTION_RECEIVE_FABRIC;
	}

	/**
	 * 样衣情况
	 * 
	 * @return
	 */
	@RequestMapping(value = "productSampleSituation")
	public String productSampleSituation() {
		return _HTML_PRODUCT_SAMPLE_SITUATION;
	}

	/**
	 * 产品上新进度
	 * 
	 * @return
	 */
	@RequestMapping(value = "productOnlineProgress")
	public String productOnlineProgress() {
		return _HTML_PRODUCT_ONLINE_PROGRESS;
	}

	/**
	 * 入库情况
	 * 
	 * @return
	 */
	@RequestMapping(value = "productStorageSituation")
	public String productStorageSituation() {
		return _HTML_PRODUCT_STORAGE_SITUATION;
	}

	/**
	 * 摄影情况信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "productPhotographySituation")
	public String productPhotographySituation() {
		return _HTML_PRODUCT_PHOTOGRAPHY_SITUATION;
	}

	/**
	 * 美工情况信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "productArtworkSituation")
	public String productArtworkSituation() {
		return _HTML_PRODUCT_ARTWORK_SITUATION;
	}

	/**
	 * 运营情况信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "productOperationSituation")
	public String productOperationSituation() {
		return _HTML_PRODUCT_OPERATION_SITUATION;
	}

	/**
	 * 财务对账单
	 * 
	 * @return
	 */
	@RequestMapping(value = "financeAccountReconciliation")
	public String financeAccountReconciliation() {
		return _HTML_FINANCE_ACCOUNT_RECONCILIATION;
	}

	/**
	 * 2017年4月24日09:10:57 新员工页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "userInfo")
	public String userInfo() {
		return _HTML_USER_INFO;
	}
}

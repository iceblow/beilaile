<#macro top>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>
    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf">
                    </i>
                    后台管理系统
                </small>
            </a>
            <!-- /.brand -->
        </div>
        <!-- /.navbar-header -->
        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="/warehouse/res/avatars/user.jpg" alt="Jason's Photo"
                        />
                        <span class="user-info">
                            <small>
                                欢迎光临,
                            </small>
                        ${loginUser.trueName}
                        </span>
                        <i class="icon-caret-down">
                        </i>
                    </a>
                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="icon-cog">
                                </i>
                                设置
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="icon-user">
                                </i>
                                个人资料
                            </a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">
                                <i class="icon-off">
                                </i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- /.ace-nav -->
        </div>
        <!-- /.navbar-header -->
    </div>
    <!-- /.container -->
</div>
</#macro>
<#macro css>
<link rel="stylesheet" href="/warehouse/res/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/warehouse/res/css/bootstrap-datetimepicker.css"/>
<link rel="stylesheet" href="/warehouse/res/css/font-awesome.min.css"/>
<link rel="stylesheet" href="/warehouse/res/css/ace.min.css"/>
<link rel="stylesheet" href="/warehouse/res/css/normalize.css"/>
<link rel="stylesheet" href="/warehouse/res/css/page.css"/>
<link rel="stylesheet" href="/warehouse/res/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/warehouse/res/css/bootstrap-datetimepicker.css"/>
<link rel="stylesheet" href="/warehouse/res/css/font-awesome.min.css"/>
<link rel="stylesheet" href="/warehouse/res/css/ace.min.css"/>
<link rel="stylesheet" href="/warehouse/res/css/normalize.css"/>
</#macro>
<#macro js>
<!-- basic scripts -->
<script type="text/javascript">
    window.jQuery
    || document.write("<script src='/warehouse/res/js/jquery-2.0.3.min.js'>"
            + "<" + "/script>");
</script>
<script type="text/javascript">
    window.jQuery
    || document.write("<script src='/warehouse/res/js/jquery-1.10.2.min.js'>"
            + "<" + "/script>");
</script>
<script type="text/javascript">
    if ("ontouchend" in document)
        document.write("<script src='/warehouse/res/js/jquery.mobile.custom.min.js'>"
                + "<" + "/script>");
</script>
<script type="text/javascript">
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#' + id).addClass('visible');
    }
</script>
<script type="text/javascript" src="/warehouse/res/js/jquery.js"></script>
<script type="text/javascript" src="/warehouse/res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/warehouse/res/js/ace.min.js"></script>
<script type="text/javascript" src="/warehouse/res/js/ace-extra.min.js"></script>
<script type="text/javascript" src="/warehouse/res/js/ace-elements.min.js"></script>
<script type="text/javascript" src="/warehouse/res/js/jquery.page.js"></script>
<script type="text/javascript" src="/warehouse/res/js/ajaxform.js"></script>
<script type="text/javascript" src="/warehouse/res/js/highcharts.js"></script>
<script type="text/javascript" src="/warehouse/res/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="/warehouse/res/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="/warehouse/res/js/jquery-upload.js"></script>
<script type="text/javascript" src="/warehouse/res/js/jquery-regular.js"></script>

<script type="text/javascript"
        src="/warehouse/res/js/printImg/jquery.jqprint-0.3.js"></script>
</#macro>
<#macro left>
<a class="menu-toggler" id="menu-toggler" href="#">
    <span class="menu-text">
    </span>
</a>
<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>
    <ul class="nav nav-list">
        <li class="active">
            <a href="index.html">
                <i class="icon-dashboard">
                </i>
                <span class="menu-text">
                    控制台
                </span>
            </a>
        </li>
    <#--设计师-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                    设计师
                </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="apparelDevelopmentManagement.html">
                        <i class="icon-double-angle-right">
                        </i>
                        服装开发管理
                    </a>
                </li>
                <li>
                    <a target='_blank' href="distributionSetUp.html">
                        <i class="icon-double-angle-right">
                        </i>
                        全经销设置
                    </a>
                </li>
                <li>
                    <a target='_blank' href="apparelDevelopmentMissSampleimg.html">
                        <i class="icon-double-angle-right">
                        </i>
                        补工艺单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="apparelDevelopmentDesignBuyerOrder.html">
                        <i class="icon-double-angle-right">
                        </i>
                        买手订单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="apparelDevelopmentManagementCollect.html">
                        <i class="icon-double-angle-right">
                        </i>
                        服装数据综合
                    </a>
                </li>
                <li>
                    <a target='_blank' href="orderTracking.html">
                        <i class="icon-double-angle-right">
                        </i>
                         订单跟踪          
                    </a>
                </li>
            </ul>
        </li>
    <#--设计师-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                  板房管理
                </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="boardWorksSchedule.html">
                        <i class="icon-double-angle-right">
                        </i>
                        板房生产计划
                    </a>
                </li>
                <li>
                    <a target='_blank' href="boardRoom.html">
                        <i class="icon-double-angle-right">
                        </i>
                        板房
                    </a>
                </li>
                <li>
                    <a target='_blank' href="stillClothes.html">
                        <i class="icon-double-angle-right">
                        </i>
                        样衣
                    </a>
                </li>
                <li>
                    <a target='_blank' href="returnToSinglePattern.html">
                        <i class="icon-double-angle-right">
                        </i>
                        返单纸样
                    </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                    理单管理
                </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">

                <li>
                    <a target='_blank' href="accessoryMaterial.html">
                        <i class="icon-double-angle-right">
                        </i>
                        辅料理单
                    </a>
                </li>

                <li>
                    <a target='_blank' href="accessoryRation.html">
                        <i class="icon-double-angle-right">
                        </i>
                        新料单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="fabricMaterial.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料理单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="confirmPurchaseFabric.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料采购
                    </a>
                </li>
			 
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                  印绣花管理
                </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
            <li>
                    <a target='_blank' href="printingFinish.html">
                        <i class="icon-double-angle-right">
                        </i>
                        印绣花理单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="printingQuote.html">
                        <i class="icon-double-angle-right">
                        </i>
                        印绣花报价
                    </a>
                </li>
                <li>
                    <a target='_blank' href="printingProcessCase.html">
                        <i class="icon-double-angle-right">
                        </i>
                        匹印加工情况
                    </a>
                </li>
                <li>
                    <a target='_blank' href="pieceProcessCase.html">
                        <i class="icon-double-angle-right">
                        </i>
                        片印加工情况
                    </a>
                </li>
                <#-- <li>
                    <a target='_blank' href="TaskDistribution.html">
                        <i class="icon-double-angle-right">
                        </i>
                        印绣花任务分发
                    </a>
                </li>
                <li>
                    <a target='_blank' href="printingCuttingCompleted.html">
                        <i class="icon-double-angle-right">
                        </i>
                        裁剪完成
                    </a>
                </li> -->
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                        跟单管理
                    </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="buildProgress.html">
                        <i class="icon-double-angle-right">
                        </i>
                        跟单裁片外发进度表
                    </a>
                </li>
                <li>
                    <a target='_blank' href="buildProgressReport.html">
                        <i class="icon-double-angle-right">
                        </i>
                        跟单裁片外发进度报表
                    </a>
                </li>
                
                 <li>
                    <a target='_blank' href="notStorageTracking.html">
                        <i class="icon-double-angle-right">
                        </i>
       	 未入库跟踪             
                    </a>
                </li>
                 
                
                
                <li>
                    <a target='_blank' href="buildProgressWeeklyReport.html">
                        <i class="icon-double-angle-right">
                        </i>
                        跟单裁片外发七日均值进度报表
                    </a>
                </li>
                <li>
                    <a target='_blank' href="problemFeedback.html">
                        <i class="icon-double-angle-right">
                        </i>
                        跟单外发问题反馈表
                    </a>
                </li>
                
               
                <li>
                    <a target='_blank' href="problemNotGrant.html">
                        <i class="icon-double-angle-right">
                        </i>
                        裁片跟踪                   
                    </a>
                </li> 
                
                <li>
                    <a target='_blank' href="tracking.html">
                        <i class="icon-double-angle-right">
                        </i>
                        理单跟踪表
                    </a>
                </li>
                <#-- <li>
                    <a target='_blank' href="productionProblem.html">
                        <i class="icon-double-angle-right">
                        </i>
                        生产问题反馈
                    </a>
                </li>-->
                <li>
                    <a target='_blank' href="buildProgressFactoryDailyReport.html">
                        <i class="icon-double-angle-right">
                        </i>
                        工厂进度报表
                    </a>
                </li>
                <li>
                    <a target='_blank' href="allWeekReport.html">
                        <i class="icon-double-angle-right">
                        </i>
       	本周出货计划
                    </a>
                </li>
                
                <li>
                <a target='_blank' href="notStorageRecord.html">
                    <i class="icon-double-angle-right">
                    </i>
                    车缝问题反馈
                </a>
            </li>
                
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                        裁床管理
                    </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="cuttingMain.html">
                        <i class="icon-double-angle-right">
                        </i>
                        裁床日报表
                    </a>
                </li>
                <li>
                    <a target='_blank' href="fabric.html">
                        <i class="icon-double-angle-right">
                        </i>
                        裁床用料日报表
                    </a>
                </li>
                <li>
                    <a target='_blank' href="cuttingFabricCompleted.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料到齐
                    </a>
                </li>
                <li>
                    <a target='_blank' href="taisanCuttingOutflow.html">
                        <i class="icon-double-angle-right">
                        </i>
                        车缝裁片安排
                    </a>
                </li>
                <li>
                    <a target='_blank' href="getEmbroider.html">
                        <i class="icon-double-angle-right">
                        </i>
                        片印领料
                    </a>
                </li>
                <li>
                    <a target='_blank' href="outEmbroider.html">
                        <i class="icon-double-angle-right">
                        </i>
                        片印回料
                    </a>
                </li>
                <li>
                    <a target='_blank' href="outsideDaily.html">
                        <i class="icon-double-angle-right">
                        </i>
                        车缝领料
                    </a>
                </li>
                 <li>
                    <a target='_blank' href="sewingPickingOrder.html">
                        <i class="icon-double-angle-right">
                        </i>
                     车缝领料单
                    </a>
                </li>
               <li>
                    <a target='_blank' href="printMarkOrder.html">
                        <i class="icon-double-angle-right">
                        </i>
                     片印领料单
                    </a>
                </li>
                
            
            
            </ul>
        </li>
    <#--采购单-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                            面料管理
                        </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
                <#--2017年4月17日13:42:43  --<li>
                    <a target='_blank' href="distributionFabric.html">
                        <i class="icon-double-angle-right">
                        </i>
                        经销单出库
                    </a>
                </li>-->
                <li>
                    <a target='_blank' href="orderMemo.html">
                        <i class="icon-double-angle-right">
                        </i>
                        订单备忘表
                    </a>
                </li>
                <li>
                    <a target='_blank' href="fabricOutflow.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料出库
                    </a>
                </li>
                 <li>
                    <a target='_blank' href="fabricReturnBack.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料退料表
                    </a>
                </li>
                <li>
                    <a target='_blank' href="fabricStorage.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料入库
                    </a>
                </li>
               <#-- 6、取消面料管理里  面料进度链接。 2017年4月17日13:41:52 <li>
                    <a target='_blank' href="fabricmanagement.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料进度
                    </a>
                </li>-->
                <li>
                    <a target='_blank' href="fabricSourcing.html">
                        <i class="icon-double-angle-right">
                        </i>
                        采购记录
                    </a>
                </li>
                <li>
                    <a target='_blank' href="fabricCodeProcessInformation.html">
                        <i class="icon-double-angle-right">
                        </i>
           面料编码入库
                    </a>
                </li>
                <li>
                    <a target='_blank' href="factoryReceiveFabric.html">
                        <i class="icon-double-angle-right">
                        </i>
                        匹印领料
                    </a>
                </li>
                <li>
                    <a target='_blank' href="factoryReturnFabric.html">
                        <i class="icon-double-angle-right">
                        </i>
                        匹印回料
                    </a>
                </li>
                <li>
                    <a target='_blank' href="fabricOutflowReady.html">
                        <i class="icon-double-angle-right">
                        </i>
                        裁床面料安排
                    </a>
                </li>
                <li>
                    <a target='_blank' href="printingFabricArrange.html">
                        <i class="icon-double-angle-right">
                        </i>
                        匹印面料安排
                    </a>
                </li>
                 <li>
                    <a target='_blank' href="problemNotReceiveMaterial.html">
                        <i class="icon-double-angle-right">
                        </i>
                         面料跟踪
                    </a>
                </li>
               
            </ul>
        </li><#--经销单管理 开始-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                            经销单管理
                        </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="distributionMakSample.html">
                        <i class="icon-double-angle-right">
                        </i>
                       经销单打样
                    </a>
                </li>
                <li>
                    <a target='_blank' href="distributionQuote.html">
                        <i class="icon-double-angle-right">
                        </i>
                        经销单报价
                    </a>
                </li>
                <li>
                    <a target='_blank' href="distributionConfirmOrder.html">
                        <i class="icon-double-angle-right">
                        </i>
                        经销单下单
                    </a>
                </li>
              	<li>
                    <a target='_blank' href="distributionBuyMaterial.html">
                        <i class="icon-double-angle-right">
                        </i>
                       经销单原料采购
                    </a>
                </li>
                <li>
                    <a target='_blank' href="distributionProduction.html">
                        <i class="icon-double-angle-right">
                        </i>
                       经销单生产环节
                    </a>
                </li>
				<li>
                    <a target='_blank' href="distributionFinishProductPerfect.html">
                        <i class="icon-double-angle-right">
                        </i>
                       经销单后道
                    </a>
                </li>
                <li>
                    <a target='_blank' href="distributionDealerDelivery.html">
                        <i class="icon-double-angle-right">
                        </i>
                       经销单出货信息
                    </a>
                </li>
                <li>
                    <a target='_blank' href="distributionCompletedOrder.html">
                        <i class="icon-double-angle-right">
                        </i>
                        已经完成订单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="distributionReceiveFabric.html">
                        <i class="icon-double-angle-right">
                        </i>
                        经销领面料
                    </a>
                </li>
                 <li>
                    <a target='_blank' href="distributionSummary.html">
                        <i class="icon-double-angle-right">
                        </i>
                        经销单汇总
                    </a>
                </li>
            </ul>
        </li>
    <#--经销单 结束-->
    <#--辅料管理 开始-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                            辅料管理
                        </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
				 <li>
                    <a target='_blank' href="taisanAccesOutflow.html">
                        <i class="icon-double-angle-right">
                        </i>
                        辅料安排
                    </a>
                </li>
                <li>
                    <a target='_blank' href="orderSortingAccessory.html">
                        <i class="icon-double-angle-right">
                        </i>
                        辅料理单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="orderRationAccessory.html">
                        <i class="icon-double-angle-right">
                        </i>
                        库存准备
                    </a>
                </li>
                <li>
                    <a target='_blank' href="documentaryAccessory.html">
                        <i class="icon-double-angle-right">
                        </i>
                        辅料跟单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="orderIssueAccessory.html">
                        <i class="icon-double-angle-right">
                        </i>
                        辅料配发
                    </a>
                </li>
                <li>
                    <a target='_blank' href="orderRationReady.html">
                        <i class="icon-double-angle-right">
                        </i>
                        配齐货架
                    </a>
                </li>
                <li>
                    <a target='_blank' href="orderRationSpec.html">
                        <i class="icon-double-angle-right">
                        </i>
                        指定工厂货架
                    </a>
                </li>
                <li>
                    <a target='_blank' href="accessoryInfo.html">
                        <i class="icon-double-angle-right">
                        </i>
                        辅料信息
                    </a>
                </li>
            </ul>
        </li>
    <#--辅料管理 结束-->
    <#--仓库管理-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                                仓库管理
                            </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            
            <ul class="submenu">
            
            
                <li>
                    <a target='_blank' href="inputstorageratio.html">
                        <i class="icon-double-angle-right">
                        </i>
                        入库比例
                    </a>
                </li>
                
                            
                <li>
                    <a target='_blank' href="inputstorage.html">
                        <i class="icon-double-angle-right">
                        </i>
                        成品入库
                    </a>
                </li>
                
                
                
                
                
                <li>
                    <a target='_blank' href="inputStorageHaoXun.html">
                        <i class="icon-double-angle-right">
                        </i>
                        浩迅入库
                    </a>
                </li>
                
                
                
                
                <li>
                    <a target='_blank' href="salesNotSaleHaoXun.html">
                        <i class="icon-double-angle-right">
                        </i>
                        未售浩讯
                    </a>
                </li>
                <li>
                    <a target='_blank' href="salesNotSaleHangZhou.html">
                        <i class="icon-double-angle-right">
                        </i>
                        未售杭州
                    </a>
                </li>
                <li>
                    <a target='_blank' href="productTaoBaoInfo.html">
                        <i class="icon-double-angle-right">
                        </i>
                        平台库存
                    </a>
                </li>
                <li>
                    <a target='_blank' href="productInfo.html">
                        <i class="icon-double-angle-right">
                        </i>
                        商品详情
                    </a>
                </li>
                <li>
                    <a target='_blank' href="sampleArrange.html">
                        <i class="icon-double-angle-right">
                        </i>
                        样衣安排
                    </a>
                </li>
                <li>
                    <a target='_blank' href="putInStorageReport.html">
                        <i class="icon-double-angle-right">
                        </i>
                        入库日报
                    </a>
                </li>
                <li>
                    <a target='_blank' href="storageReport.html">
                        <i class="icon-double-angle-right">
                        </i>
                        成品日报
                    </a>
                </li>
                <li>
                    <a target='_blank' href="weeklyReport.html">
                        <i class="icon-double-angle-right">
                        </i>
                        成品7日均值
                    </a>
                </li>
                <li>
                    <a target='_blank' href="returnrepairdoucuments.html">
                        <i class="icon-double-angle-right">
                        </i>
                        返修开单
                    </a>
                </li>
                  <li>
                    <a target='_blank' href="returnrepair.html">
                        <i class="icon-double-angle-right">
                        </i>
                        返修入库
                    </a>
                </li>
                 
            </ul>
        </li>
          <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                                仓库面料管理
                            </span>
                <b class="arrow icon-angle-down"> </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="inventoryFabricStorage.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料入库登记
                    </a>
                </li>
                 <li>
                    <a target='_blank' href="inventoryFabricOutput.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料出库登记
                    </a>
                </li>
                 <li>
                    <a target='_blank' href="inventoryFabricDetails.html">
                        <i class="icon-double-angle-right">
                        </i>
                        仓库面料汇总
                    </a>
                </li>
                <li>
                    <a target='_blank' href="inventoryFabricSingleDetails.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料详情信息
                    </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                                技控管理
                            </span>
                <b class="arrow icon-angle-down"> </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="outsideproces.html">
                        <i class="icon-double-angle-right">
                        </i>
                        加工核价
                    </a>
                </li>
                 <li>
                    <a target='_blank' href="fabricTotalPrice.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料核价表
                    </a>
                </li>
                 <li>
                    <a target='_blank' href="clothesTotalPrice.html">
                        <i class="icon-double-angle-right">
                        </i>
                        成衣面料核价表
                    </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                                通知
                            </span>
                <b class="arrow icon-angle-down"> </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="receiveMaterialNotice.html">
                        <i class="icon-double-angle-right">
                        </i>
                        领料通知
                    </a>
                </li>
                <li>
                    <a target='_blank' href="factoryBacklog.html">
                        <i class="icon-double-angle-right">
                        </i>
                        工厂代办
                    </a>
                </li>
            </ul>
        </li>
    <#--运营管理-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                    运营管理
                </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="productToBack.html">
                        <i class="icon-double-angle-right">
                        </i>
                        商品返单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="productBack.html">
                        <i class="icon-double-angle-right">
                        </i>
                        库存分析
                    </a>
                </li>
                <li>
                    <a target='_blank' href="approvalApplication.html">
                        <i class="icon-double-angle-right">
                        </i>
                        申请审批
                    </a>
                </li>
                <li>
                    <a target='_blank' href="apparelDevelopmentReturn.html">
                        <i class="icon-double-angle-right">
                        </i>
                        运营返单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="cancelOrder.html">
                        <i class="icon-double-angle-right">
                        </i>
                        撤销订单
                    </a>
                </li>
                <li>
                    <a target='_blank' href="purchaseOrdersDetail.html">
                        <i class="icon-double-angle-right">
                        </i>
                        订单详情
                    </a>
                </li>
                <li>
                    <a target='_blank' href="salesReportOfWdt.html">
                        <i class="icon-double-angle-right">
                        </i>
                        销售详情
                    </a>
                </li>
                <li>
                    <a target='_blank' href="salesSlowMovingStock.html">
                        <i class="icon-double-angle-right">
                        </i>
                        滞销商品
                    </a>
                </li>
            </ul>
        </li> <#--运营管理-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit">
                </i>
                <span class="menu-text">
                    产品上新进度
                </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            
            
            <ul class="submenu">
             <li>
                    <a target='_blank' href="productStorageSituation.html">
                        <i class="icon-double-angle-right">
                        </i>
                       入库情况
                    </a>
                </li>  
             	<li>
                    <a target='_blank' href="productSampleSituation.html">
                        <i class="icon-double-angle-right">
                        </i>
                        样衣情况
                    </a>
                </li>  
                 <li>
                    <a target='_blank' href="productPhotographySituation.html">
                        <i class="icon-double-angle-right">
                        </i>
                       拍摄情况
                    </a>
                </li>  
                 <li>
                    <a target='_blank' href="productArtworkSituation.html">
                        <i class="icon-double-angle-right">
                        </i>
                     美工情况
                    </a>
                </li>  
                 <li>
                    <a target='_blank' href="productOperationSituation.html">
                        <i class="icon-double-angle-right">
                        </i>
                     运营情况
                    </a>
                </li>  
                 <li>
                    <a target='_blank' href="productOnlineProgress.html">
                        <i class="icon-double-angle-right">
                        </i>
                      产品上新进度汇总
                    </a>
                </li>  
               
            </ul>
           
             	
           
           
           
            
        </li>
    <#--公司作品-->
        <li>
            <a href="product.html">
                <i class="icon-picture">
                </i>
                <span class="menu-text">
                                公司作品
                            </span>
            </a>
        </li>

    <#--个人信息-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-tag">
                </i>
                <span class="menu-text">
                                个人信息
                            </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="profile.html">
                        <i class="icon-double-angle-right">
                        </i>
                        用户信息
                    </a>
                </li>
                <li>
                    <a target='_blank' href="login.html">
                        <i class="icon-double-angle-right">
                        </i>
                        登录 &amp; 注册
                    </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-tag">
                </i>
                <span class="menu-text">
                                资料档案
                            </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
             <li>
                    <a target='_blank' href="fabricSupplier.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料供应商
                    </a>
                </li>
                 <li>
                    <a target='_blank' href="colorCard.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料色卡
                    </a>
                </li>
                 <li>
                    <a target='_blank' href="fabricFiles.html">
                        <i class="icon-double-angle-right">
                        </i>
                        面料档案
                    </a>
                </li>
               
                <li>
                    <a target='_blank' href="manufacturer.html">
                        <i class="icon-double-angle-right">
                        </i>
                        工厂档案
                    </a>
                </li>


            </ul>
        </li>
    <#--员工信息信息-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-tag">
                </i>
                <span class="menu-text">
                                员工信息
                            </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">

          <li>
                    <a target='_blank' href="userInfo.html">
                        <i class="icon-double-angle-right">
                        </i>
                        员工页面
                    </a>
                </li>
            </ul>
        </li>
        
          <#--财务对账-->
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-tag">
                </i>
                <span class="menu-text">
                                财务对账
                            </span>
                <b class="arrow icon-angle-down">
                </b>
            </a>
            <ul class="submenu">
                <li>
                    <a target='_blank' href="financeAccountReconciliation.html">
                        <i class="icon-double-angle-right">
                        </i>
                        财务对账
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <!-- /.nav-list -->
    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
           data-icon2="icon-double-angle-right">
        </i>
    </div>
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>
</#macro>
<#--HTML清空缓存-->
<#macro cache>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</#macro>
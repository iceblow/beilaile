$(function() {
    loadPageDatas(1);
    select();
    addName();
});

// 进入后台进行分页查询
function loadPageDatas(index) {
    firstLoadData($("#path").val() + "/cuttingFabricCompleted/getDataByPage.do", index); // 指定url
}

function loadData(data) {
    $("tbody").empty();
    $("#orderSum").text(data.orderSum == null ? 0 : data.orderSum);
    $("#styleSum").text(data.styleSum);
    $.each(data.data,
    function(index, x) {

        var wave = x.wave == null || x.wave == "" ? "<td align='center'></td>": "<td align='center'>" + x.wave + "</td>"; // 波次号
        var productCode = x.productCode == null || x.productCode == "" ? "<td align='center'></td>": "<td align='center'>" + x.productCode + "</td>"; // 波次号
        var kindsOfFabric = x.kindsOfFabric == null || x.kindsOfFabric == "" ? "<td align='center'></td>": "<td align='center'>" + x.kindsOfFabric + "</td>"; // 面料种类数
        var image = x.image == null || x.image == "" ? "<td align='center'></td>": "<td align='center'><img src='" + x.image + "' width='100px' height='80px'/></td>"; // 图片
        var sampleImg = x.sampleImg == null || x.sampleImg == "" ? "<td></td>": "<td align='center><a href='" + x.sampleImg + "' target='_blank'></a></td>"; // 工艺单
        var orders = x.orders == null || x.orders == "" ? "<td align='center'></td>": "<td align='center'>" + x.orders + "</td>"; // 订单数
        var piecesApproved = x.piecesApproved == null || x.piecesApproved == "" ? "<td align='center'></td>": "<td align='center'>" + x.piecesApproved + "</td>"; // 印绣花类型
        var orderType = x.orderType == null || x.orderType == "" ? "<td align='center'></td>": "<td align='center'>" + x.orderType + "</td>"; // 订单种类
        var largeCargoTime = x.largeCargoTime == null || x.largeCargoTime == "" ? "<td align='center'></td>": "<td align='center'>" + x.largeCargoTime + "</td>"; // 匹印领料日期
        var largeCargoCompletionTime = x.largeCargoCompletionTime == null || x.largeCargoCompletionTime == "" ? "<td align='center'></td>": "<td align='center'>" + x.largeCargoCompletionTime + "</td>"; // 匹印完成送回日期
        var factory = x.factory == null || x.factory == "" ? "<td align='center' class='mydblClick' name='factory'></td>": "<td align='center' class='mydblClick' name='factory'>" + x.factory + "</td>"; // 车缝工厂
        var folwerFactory = x.folwerFactory == null || x.folwerFactory == "" ? "<td align='center' class='mydblClick' name='folwerFactory'></td>": "<td align='center' class='mydblClick' name='folwerFactory'>" + x.folwerFactory + "</td>"; // 印花工厂
        var fabricFeedback = x.fabricFeedback == null || x.fabricFeedback == "" ? "<td align='center' class='mydblClick' name='fabricFeedback'></td>": "<td align='center' class='mydblClick' name='fabricFeedback'>" + x.fabricFeedback + "</td>"; // 备注
        var existPaperPattern = x.existPaperPattern == null || x.existPaperPattern == "" ? "<td align='center' class='mydblClick' name='fabricFeedback'></td>": "<td align='center' class='mydblClick' name='fabricFeedback'>有纸样</td>"; // 是否有纸样
        var fabricIsReadyStatus = "<td align='center'>" + (x.fabricIsReadyStatus == '已配备' || x.fabricIsReadyStatus == '面料就绪' ? '已配备': '') + "</td>";
        var planToGetFabricTime = x.planToGetFabricTime == null || x.planToGetFabricTime == "" ? "<td align='center'></td>": "<td align='center'>" + x.planToGetFabricTime + "</td>"; // 安排日期
        var remark = x.remark != null && x.remark != '' ? "<td align='center'>面料已安排</td>": "<td align='center'><a href='javascript:;' class='remark btn btn-danger btn-sm delApparelDevelopmentReturn' data-dismiss='model'>安排面料</a></td>"; // 备注
        var fabricIssueStatues = "<td>" + (x.fabricIssueStatues == "已发放" ? "已发放": "") + "</td>"; // 面料发放状态
        var cuttingMan = x.cuttingMan == null || x.cuttingMan == "" ? "<td  name='factory'></td>": "<td align='center'  name='cuttingMan'>" + x.cuttingMan + "</td>"; // 车缝工厂
        var fabricIsCuttingStatus = "<td>" + (x.fabricIsCuttingStatus == "已安排裁剪" ? "已安排裁剪": "<a href='javascript:void(0);' data-toggle='modal' data-target='#myModal2'   class='btn btn-purple planCut'>安排裁剪</a>") + "</td>"; // 裁剪状态
        $("tbody").append("<tr>" + wave + productCode + kindsOfFabric + image + sampleImg + orders + piecesApproved + orderType + largeCargoTime + largeCargoCompletionTime + factory + folwerFactory + fabricFeedback +existPaperPattern+ fabricIsReadyStatus + planToGetFabricTime + remark + fabricIssueStatues + cuttingMan + fabricIsCuttingStatus + "</tr>");

    });
    // 双击修改
    mydblclick();
    // 安排按钮点击事件
    remarkClick();
    // 安排裁床
    getId();

}

function getId() {
    $(".planCut").on("click",
    function() {
        var wave = $(this).parent().parent().find("td:eq(0)").text();
        $("#wave").val(wave);
    });
}

//提交模态框数据
function addName() {
    $("#addProce").on("click",
    function() {
        var wave = $("#wave").val();
        var person = $("#cuttingMan").val().trim();
        if (person != "" && person != null) {
            $.ajax({
                url: '/cuttingFabricCompleted/planCut.do',
                data: {
                    wave: wave,
                    cuttingMan: person
                },
                //数据库对应前面字段
                dataType: 'json',
                type: 'post',
                success: function(data) {
                    if (data == 1) {
                        firstLoadData($("#path").val() + "/cuttingFabricCompleted/getDataByPage.do?" + mySelectForm, $(".laypage_curr").text());
                        layer.msg('安排成功', {
                            icon: 6,
                            time: 2000,
                        }); // 20s后自动关闭
                    } else {
                        layer.msg('安排失败', {
                            icon: 5,
                            time: 2000,
                        }); // 20s后自动关闭
                    }
                }
            });
        } else {
            alert("请填写裁剪人姓名");
            return false;
        }

    });
}

function remarkClick() {
    $(".remark").click(function() {
        var wave = $(this).parent().parent().find("td:eq(0)").text().trim();
        layer.confirm('您确认安排' + wave + '的面料', {
            area: '350px',
            btn: ['安排', '取消']
        },
        function() {
            $.ajax({
                url: $("#path").val() + '/cuttingFabricCompleted/remarkClick.do',
                type: 'post',
                dataType: 'json',
                data: {
                    wave: wave,
                },
                success: function(data) {
                    layer.msg('已安排', {
                        icon: 6,
                        time: 1000
                    },
                    function() {
                        firstLoadData($("#path").val() + "/cuttingFabricCompleted/getDataByPage.do?" + mySelectForm, $(".laypage_curr").text().trim()); // 指定url
                    });
                },
                error: function() {
                    layer.msg('安排失败', {
                        icon: 6
                    });
                }
            });
        },
        function() {
            layer.msg('取消安排', {
                icon: 6,
                time: 2000,
                // 20s后自动关闭
            });
        });
    });
}

var mySelectForm;
// 查詢按鈕點擊事件
function select() {
    $("#myselect").click(function() {
        mySelectForm = $("#mySelect_From").serialize();
        firstLoadData($("#path").val() + "/cuttingFabricCompleted/getDataByPage.do?" + mySelectForm, 1); // 指定url
        // -注释时间:2017年1月6日16:54:06
        // -注释原因:查询之后保留查询内容
        // $(".col-md-2>input").val("");
    });
}

// ----------------------------------------------------双击修改----------------------------------------------------
function getTime(date) {
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();

    return year + "-" + month + "-" + strDate
}

function mydblclick() {
    $(".mydblClick").on("dblclick",
    function() {
        var myid = $(this).parent().find("td:eq(0)").text().trim();
        var thisText = $(this).text().trim();
        var thisName = $(this).attr("name");
        var thisVal = $(this).attr("value");
        // 如果双击修改的是时间类型的单元格对里面的内容重新计算 得到真正的日期
        if (thisVal == "time" && thisText != "") {
            var myval = thisText;
            var date = new Date();
            var yyyy = date.getFullYear();
            var mm = ((date.getMonth() + 1) / 10 < 1 ? "0" + (date.getMonth() + 1) : (date.getMonth() + 1));
            var dd = (date.getDate() / 10 < 1 ? "0" + date.getDate() : date.getDate());
            var nowDate = yyyy + "-" + mm + "-" + dd;
            var dateStart1 = new Date(nowDate);
            var asd = new Date(myval * (1000 * 3600 * 24) + dateStart1.getTime());
            var yyyy1 = asd.getFullYear();
            var mm1 = ((asd.getMonth() + 1) / 10 < 1 ? "0" + (asd.getMonth() + 1) : (asd.getMonth() + 1));
            var dd1 = (asd.getDate() / 10 < 1 ? "0" + asd.getDate() : asd.getDate());
            thisText = yyyy1 + "-" + mm1 + "-" + dd1;
        }

        if (thisVal != "time") {
            $(this).html("<form id='dbUpdateForm'><input type='hidden' name='wave' value=" + myid + " /><input type='text' id='my" + thisName + "' name='" + thisName + "' value='" + thisText + "'></form>");
            $(this).attr("class", "sn");

            myblur("my" + thisName);
        } else {
            $(this).html("<form id='dbUpdateForm'><input type='hidden' name='id' value=" + myid + " /><input class='form-control input-date' type='text' id='my" + thisName + "' name='" + thisName + "' value='" + thisText + "'></form>");
            $(this).attr("class", "sn");
            // 绑定时间控件
            var input_date = $(".input-date").datetimepicker({
                format: "yyyy-mm-dd",
                autoclose: true,
                todayBtn: true,
                todayHighlight: true,
                showMeridian: true,
                pickerPosition: "bottom-left",
                language: 'zh-CN',
                // 中文，需要引用zh-CN.js包
                startView: 2,
                // 月视图
                minView: 2
                // 日期时间选择器所能够提供的最精确的时间选择视图
            });
            var input_date_readOnly = $(".input-date").prop("readOnly", "true");

            timeBlur("my" + thisName);
        }
        document.getElementById("my" + thisName).focus();
    });
}

function myblur(id) {
    $("#" + id).blur(function() {
        var myform = $("#dbUpdateForm").serialize();
        $.ajax({
            url: $("#path").val() + '/cuttingFabricCompleted/updateDateByWave.do',
            type: 'POST',
            dataType: 'json',
            data: myform,
            async: false,
            success: function(data) {
                if (data == 1) {
                    firstLoadData($("#path").val() + "/cuttingFabricCompleted/getDataByPage.do?" + mySelectForm, $(".laypage_curr").text());
                } else {
                    alert("修改失败");
                }
            }
        });
    });
}
function timeBlur(id) {
    $("#" + id).blur(function() {
        setTimeout('commitTime()', 200);
    });
}

function commitTime() {
    var myform = $("#dbUpdateForm").serialize();
    $.ajax({
        url: $("#path").val() + '/cuttingFabricCompleted/updateDateByWave.do',
        type: 'POST',
        dataType: 'json',
        data: myform,
        async: false,
        success: function(data) {
            if (data == 1) {
                firstLoadData($("#path").val() + "/cuttingFabricCompleted/getDataByPage.do?" + mySelectForm, $(".laypage_curr").text());
            } else {
                alert("未修改");
            }
        }
    });
}
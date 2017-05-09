/**
 * Created by admin on 2017/2/3.
 */
$(function () {
    $(".col-md-2").find(":input").each(
        function () {
            $(this).val("");
        });
    var anyVal = $("#form-anyVal").serialize();
    getInventoryBpcnt(anyVal);

    $("#ajaxAddInventory").on("click", function () {
        ajaxAddInventory();
    });
    //查询
    $("#queryAccesInventory").on("click", function () {
        var anyVal = $("#form-anyVal").serialize();
        getInventoryBpcnt(anyVal);
    });
});

//查询总条数
function getInventoryBpcnt(anyVal) {
    $.post('getAccesWareHouseBpcnt.do', anyVal,
        function (data) {
            $("#pageSize").val(10); //默認查 10條數據这里啊 默认值是10
            $("#pageNow").val(data.pageNow);
            var anyVal2 = $("#form-anyVal").serialize();
            //获取form参数进行查询
            //調用方法传参
            findInventory(anyVal2);
            // 进入后台进行分页查询
            $(".tcdPageCode").createPage({ //哦哦
                pageCount: data.totalPageCount, //总页数
                current: data.pageNow, //当前页
                backFn: function (p) {
                    $("#pageSize").val(10);
                    $("#pageNow").val(p); //給當前頁賦值
                    var anyVal1 = $("#form-anyVal").serialize(); //获取form表单
                    //調用方法
                    findInventory(anyVal1);
                }
            });
        });
}

//查询
function findInventory(anyVal) {
    $.post("findAccesWareHouseCndbp.do", anyVal, //from表单内容
        function (data) {
            $(".table_app").empty(); //清空原有的数据
            for (var i = 0; i < data.length; i++) {
                var _HTML_TEBLE_ = "";
                _HTML_TEBLE_ = "<tr>" +"<input type='hidden' class='id' value='"
                    + data[i].id
                    + "'/>"
                    + "<td>"
                    + data[i].id
                    + "</td><td >"
                    //名称
                    + (data[i].accesNameWh == null ? '' : data[i].accesNameWh)
                    + "</td><td >"
                    //序列号
                    + (data[i].accesSerialNumWh == null ? '' : data[i].accesSerialNumWh)
                    + "</td><td >"
                    //条码
                    + (data[i].accesBarcodeWh == null ? '' : data[i].accesBarcodeWh)
                    + "</td><td >"
                    //原记录方式
                    + (data[i].accesHistoryCodeWh == null ? '' : data[i].accesHistoryCodeWh)
                    + "</td><td >"
                    //计量单位
                    + (data[i].accesUnitWh == null ? '' : data[i].accesUnitWh)
                    + "</td><td>"
                    //规格
                    + (data[i].accesEtalonWh == null ? '' : data[i].accesEtalonWh)
                    + "</td><td>"
                    //存储方式
                    + (data[i].accesStoreMethodWh == null ? '' : data[i].accesStoreMethodWh)
                    + "</td><td>"
                    //存储单位
                    + (data[i].accesStoreUnitWh == null ? '' : data[i].accesStoreUnitWh)
                    + "</td><td>"
                    //历史使用波次
                    + (data[i].accesHitoryWaveWh == null ? '' : data[i].accesHitoryWaveWh)
                    + "</td><td>"
                    //库存总数量
                    + (data[i].accesInvntryNumWh == null ? '' : data[i].accesInvntryNumWh)
                    + "</td><td>"
                    //库存可自由支配数量
                    + (data[i].accesFreeNumWh == null ? '' : data[i].accesFreeNumWh)
                    + "</td><td>"
                    //库存锁定数量
                    + (data[i].accesLockedNumWh == null ? '' : data[i].accesLockedNumWh)
                    + "</td><td>"
                    //记录更新时间
                    + (data[i].recordRefreshTime == null ? '' : data[i].recordRefreshTime)
                    + "</td><td>"
                    //修改时间
                    + (data[i].modifyTime == null ? '' : data[i].modifyTime)
                    + "</td><td>"
                    //操作人
                    + (data[i].operator == null ? '' : data[i].operator)
                    + "</td><td>"
                    + "<button type='button'  data-toggle='modal' data-target='#modifyAccessoryInfo'onclick='openModifyInventory(\""
                    + data[i].id
                    + "\")' class='btn btn-primary btn-sm icon-confirm'>修改</button>"
                    + "</td></tr>";
                $(".table_app").append(_HTML_TEBLE_);
            }
        });
}
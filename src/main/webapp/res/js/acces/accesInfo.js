/**
 * Created by admin on 2017/1/23.
 */
//页面加载就执行
$(function () {
    $(".col-md-2").find(":input").each(
        function () {
            $(this).val("");
        });
    var anyVal = $("#form-anyVal").serialize();
    
    getAccesInfoBpcnt(anyVal);

    $("#ajaxAddAccesInfo").on("click", function () {
        ajaxAddAccesInfo();
    });
    //查询
    $("#queryAccesInfo").on("click", function () {
        var anyVal = $("#form-anyVal").serialize();
        alert("dd");
        getAccesInfoBpcnt(anyVal);
    });
});


//提交
$("#submit-btn").on("click", function () {
    console.log("+==========================2==============");
    var formData = new FormData($("#form-input")[0]);
    var if_input_Id = $("#obj_hidden_id").val();
    if (if_input_Id != "" && if_input_Id != null) {
        //修改
        modifyAccessoryMaterial(formData);
    } else {
        //添加
        addAccessoryMaterial(formData);
    }
});
//查询总条数
function getAccesInfoBpcnt(anyVal) {
    $.post('getAccesInfoBpcnt.do', anyVal,
        function (data) {
            $("#pageSize").val(10); //默認查 10條數據这里啊 默认值是10
            $("#pageNow").val(data.pageNow);
            var anyVal2 = $("#form-anyVal").serialize();
          
            //获取form参数进行查询
            //調用方法传参
            findAccesInfo(anyVal2);
            
            // 进入后台进行分页查询
            $(".tcdPageCode").createPage({ //哦哦
                pageCount: data.totalPageCount, //总页数
                current: data.pageNow, //当前页
                backFn: function (p) {
                    $("#pageSize").val(10);
                    $("#pageNow").val(p); //給當前頁賦值
                    var anyVal1 = $("#form-anyVal").serialize(); //获取form表单
                   
                    //調用方法
                    findAccesInfo(anyVal1);
                    
                }
            });
        });
}
//查询
function findAccesInfo(anyVal) {
    $.post("findAccesInfoCndbp.do", anyVal, //from表单内容
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
                    + (data[i].accesNameAi == null ? '' : data[i].accesNameAi)
                    + "</td><td >"
                        //序列号
                    + (data[i].accesSerialNumAi == null ? '' : data[i].accesSerialNumAi)
                    + "</td><td >"
                        //条码
                    + (data[i].accesBarcodeAi == null ? '' : data[i].accesBarcodeAi)
                    + "</td><td >"
                        //缩略表示
                    + (data[i].accesAcronymAi == null ? '' : data[i].accesAcronymAi)
                    + "</td><td >"
                        //原记录方式
                    + (data[i].accesHistoryCodeAi == null ? '' : data[i].accesHistoryCodeAi)
                    + "</td><td >"
                        //图片
                    + "<img  width='50px' height='40px'src='"
                    + (data[i].accesImgAi == null ? '' : data[i].accesImgAi)
                    + "'/>"
                    +"</td><td >"
                        //颜色
                    + (data[i].accesColorAi == null ? '' : data[i].accesColorAi)
                    + "</td><td >"
                        //长度
                    + (data[i].accesLengthAi == null ? '' : data[i].accesLengthAi)
                    + "</td><td >"
                        //宽度
                    + (data[i].accesWidthAi == null ? '' : data[i].accesWidthAi)
                    + "</td><td>"
                        //重量
                    + (data[i].accesWeightAi == null ? '' : data[i].accesWeightAi)
                    + "</td><td>"
                        //计量单位
                    + (data[i].accesUnitAi == null ? '' : data[i].accesUnitAi)
                    + "</td><td>"
                        //规格
                    + (data[i].accesEtalonAi == null ? '' : data[i].accesEtalonAi)
                    + "</td><td>"
                        //存储方式
                    + (data[i].accesStoreMethodAi == null ? '' : data[i].accesStoreMethodAi)
                    + "</td><td>"
                        //存储单位
                    + (data[i].accesStoreUnitAi == null ? '' : data[i].accesStoreUnitAi)
                    + "</td><td>"
                        //供应商名称
                    + (data[i].accesSupplierNameAi == null ? '' : data[i].accesSupplierNameAi)
                    + "</td><td>"
                        //供应商联系方式
                    + (data[i].accesSupplierContactAi == null ? '' : data[i].accesSupplierContactAi)
                    + "</td><td>"
                        //供应商地址
                    + (data[i].accesSupplierAddressAi == null ? '' : data[i].accesSupplierAddressAi)
                    + "</td><td>"
                        //供应方式
                    + (data[i].accesSupplyModeAi == null ? '' : data[i].accesSupplyModeAi)
                    + "</td><td>"
                        //历史使用波次
                    + (data[i].accesHitoryWaveAi == null ? '' : data[i].accesHitoryWaveAi)
                    + "</td><td>"
                        //参考价格
                    + (data[i].accesReferencePriceAi == null ? '' : data[i].accesReferencePriceAi)
                    + "</td><td>"
                        //修改时间
                    + (data[i].modifyTime == null ? '' : data[i].modifyTime)
                    + "</td><td>"
                        //操作人
                    + (data[i].operator == null ? '' : data[i].operator)
                    + "</td><td>"
                    + "<button type='button'  data-toggle='modal' data-target='#modifyAccessoryInfo'onclick='openModifyAccesInfo(\""
                    + data[i].id
                    + "\")' class='btn btn-primary btn-sm icon-confirm'>修改</button>"
                    + "</td></tr>";
                $(".table_app").append(_HTML_TEBLE_);
            }
        });
}


// 添加 ajaxAddAccesInfo

function ajaxAddAccesInfo() {
        var formData = new FormData($("#add_acces_info_form")[0]);
        $.ajax({
            url : '/ajaxAddAccesInfo.do',
            type : 'POST',
            data : formData,
            async : true,
            cache : false,
            contentType : false,
            processData : false,
            success : function(data) {
                if (data == 1) {
                    console.log(1);
                }
            },
            error : function() {
                alert("添加失败!");
            }
    });
}

function openModifyAccesInfo(id) {
	
	console.log(id);
    argArr = {id: id};
    
    $.ajax({
        url : '/getAccesInfoBid.do',
        dataType : 'json',
        type : 'post',
        data : argArr,
        success : function(data) {
            console.log("getAccesInfoBid==============="+data);
            $("#accesInfoId").val(data.id);
            $("#accesNameAim").val(data.accesNameAi);
            $("#accesSerialNumAim").val(data.accesSerialNumAi);
            $("#accesBarcodeAim").val(data.accesBarcodeAi);
//            $("#accesStoreMethodAim").val(data.accesStoreMethodAi);
            $("#accesStoreUnitAim").val(data.accesStoreUnitAi);
            $("#accesEtalonAim").val(data.accesEtalonAi);
            $("#accesHitoryWaveAim").val(data.accesHitoryWaveAi);
            $("#accesSupplierNameAim").val(data.accesSupplierNameAi);
            $("#accesSupplierContactAim").val(data.accesSupplierContactAi);
            $("#accesSupplierAddressAim").val(data.accesSupplierAddressAi);
            $("#accesSupplyModeAim").val(data.accesSupplyModeAi);
            $("#standbyFirAim").val(data.standbyFirAi);
        },
        error : function() {
            alert("服务异常!");
        }
    });
}

function ajaxUpdateAccesInfo() {
    var formData = new FormData($("#modify_acces_info_form")[0]);
 
    console.log("modifyAccesInfo");
    console.log(formData);
    $.ajax({
        url : 'modifyAccesInfo.do',
        type : 'POST',
        data : formData,
        async : false,
        cache : false,
        contentType : false,
        processData : false,
        success : function(data) {
            var pageNow = $("#pageNow").val();
            $("#pageSize").val(10);
            $("#pageNow").val(pageNow);//給當前頁賦值
            var anyVal = $("#form-anyVal").serialize();//获取form表单
            //調用方法
            findAccesInfo(anyVal);
        },
        error : function(data) {
            $("#pageSize").val(10);
            $("#pageNow").val(1);//給當前頁賦值
            var anyVal = $("#form-anyVal").serialize();//获取form表单
            //調用方法
            findAccesInfo(anyVal);
        }
    });
}


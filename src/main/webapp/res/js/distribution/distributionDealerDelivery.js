



/**
 * Created by admin on 2017/4/28.
 */
//页面加载就执行

$(function () {

    $(".col-md-2").find(":input").each(
        function () {
            $(this).val("");
        });
    var anyVal = $("#form-anyVal").serialize();
    getDistributionInfoBpcnt(anyVal);

   
    //查询
    $("#queryDistributionInfo").on("click", function () {
        var anyVal = $("#form-anyVal").serialize();
        getDistributionInfoBpcnt(anyVal);
    });
});


//提交
$("#submit-btn").on("click", function () {
    console.log("+==========================2==============");
    var formData = new FormData($("#form-input")[0]);
    var if_input_Id = $("#obj_hidden_id").val();
    if (if_input_Id != "" && if_input_Id != null) {
        //修改
        modifyDeliveryMaterial(formData);
    } else {
        //添加
        addDeliveryMaterial(formData);
    }
});
//查询总条数
function getDistributionInfoBpcnt(anyVal) {

    $.post('getDistributionInfoBpcnt.do', anyVal,
        function (data) {
    
            $("#pageSize").val(10); //默認查 10條數據这里啊 默认值是10
            $("#pageNow").val(data.pageNow);
          
            var anyVal2 = $("#form-anyVal").serialize();
            //获取form参数进行查询
            //調用方法传参
            findDistributionInfo(anyVal2);
        
            // 进入后台进行分页查询
            $(".tcdPageCode").createPage({ //哦哦
                pageCount: data.totalPageCount, //总页数
                current: data.pageNow, //当前页
                backFn: function (p) {
                    $("#pageSize").val(10);
                    $("#pageNow").val(p); //給當前頁賦值
                    var anyVal1 = $("#form-anyVal").serialize(); //获取form表单
                    //調用方法
                    findDistributionInfo(anyVal1);
                }
            });
        });
}
//查询
function findDistributionInfo(anyVal) {
    $.post("findDistributionInfoCndbp.do", anyVal, //from表单内容
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
                        //序列号
                    + (data[i].sid == null ? '' : data[i].sid)
                    + "</td><td >"
                        //商品编号
                    + (data[i].productCode == null ? '' : data[i].productCode)
                    + "</td><td >"
                        //原波次
                    + (data[i].oringinalWave == null ? '' : data[i].oringinalWave)
                    + "</td><td>"
                        //波次号
                    + (data[i].wave == null ? '' : data[i].wave)
                    + "</td><td >"
                        //设计图
                    + "<img  width='100px' height='80px'src='"
                    + (data[i].designImg == null ? '' : data[i].designImg)
                    + "'/>"
                    + "</td><td >"
                        //工艺单
                    +"<a href='" + data[i].sampleImg+ "' target='_blank'>工艺单</a>"
                    + "</td><td >"
                        //尺码表
                    +"<a href='" + data[i].sizeChart+ "' target='_blank'>尺码表</a>"
                    +"</td><td>"
                        //订单明细
                    + (data[i].orderDetails == null ? '' : data[i].orderDetails)
                    + "</td><td>"
                        //订单数
                    + (data[i].orders == null ? '' : data[i].orders)
                    + "</td><td>"
                        //订单类型
                    + (data[i].ordersType == null ? '' : data[i].ordersType)
                    + "</td><td>"
                        //订单等级
                    + (data[i].orderGrade == null ? '' : data[i].orderGrade)
                    + "</td><td>"
                        //经销工厂
                    + (data[i].distributorFactory== null ? '' : data[i].distributorFactory)
                    + "</td><td>"
                        //经销价格
                    + (data[i].distributorPrice == null ? '' : data[i].distributorPrice)
                    + "</td><td class='myDblClick' name='reportYards59'>"
                        //工厂59码
                    + (data[i].reportYards59 == null ? '' : data[i].reportYards59)
                    + "</td><td class='myDblClick' name='reportYards66'>"
                        //工厂66码
                    + (data[i].reportYards66 == null ? '' : data[i].reportYards66)
                    + "</td><td class='myDblClick' name='reportYards73'>"
                        //工厂73码
                    + (data[i].reportYards73== null ? '' : data[i].reportYards73)
                    + "</td><td class='myDblClick' name='reportYards80'>"
                        //工厂80码
                    + (data[i].reportYards80 == null ? '' : data[i].reportYards80)
                    + "</td><td class='myDblClick' name='reportYards90'>"
                        //工厂90码
                    + (data[i].reportYards90 == null ? '' : data[i].reportYards90)
                    + "</td><td class='myDblClick' name='reportYards110'>"
                        //工厂110码
                    + (data[i].reportYards110 == null ? '' : data[i].reportYards110)
                    + "</td><td class='myDblClick' name='reportYards120'>"
                        //工厂120码
                    + (data[i].reportYards120 == null ? '' : data[i].reportYards120)
                    + "</td><td class='myDblClick' name='reportYards130'>"
                        //工厂130码
                    + (data[i].reportYards130 == null ? '' : data[i].reportYards130)
                    + "</td><td class='myDblClick' name='reportYards160'>"
                        //工厂160码
                    + (data[i].reportYards160 == null ? '' : data[i].reportYards160)
                    + "</td><td class='myDblClick' name='reportYards170'>"
                        //工厂170码
                    + (data[i].reportYards170 == null ? '' : data[i].reportYards170)
                    + "</td><td>"
                    	//总出货数
                    + (data[i].reportsTotalDeal == null ? '' : data[i].reportsTotalDeal)
                    + "</td><td >"
                        //设计图
                    + "<img  width='100px' height='80px'src='"
                    + (data[i].designImg == null ? '' : data[i].designImg)
                    + "'/>"
                    + "</td><td class='myDblClick' name='realYards59'>"
                        //实际59码
                    + (data[i].realYards59 == null ? '' : data[i].realYards59)
                    + "</td><td class='myDblClick' name='realYards66'>"
                        //实际66码
                    + (data[i].realYards66 == null ? '' : data[i].realYards66)
                    + "</td><td class='myDblClick' name='realYards73'>"
                        //实际73码
                    + (data[i].realYards73 == null ? '' : data[i].realYards73)
                    + "</td><td class='myDblClick' name='realYards80'>"
                    	//实际80码
                    + (data[i].realYards80 == null ? '' : data[i].realYards80)
                    + "</td><td class='myDblClick' name='realYards90'>"
                        //实际90码
                    + (data[i].realYards90 == null ? '' : data[i].realYards90)
                    + "</td><td class='myDblClick' name='realYards110'>"
                        //实际110码
                    + (data[i].realYards110 == null ? '' : data[i].realYards110)
                    + "</td><td class='myDblClick' name='realYards120'>"
                        //实际120码
                    + (data[i].realYards120 == null ? '' : data[i].realYards120)
                    + "</td><td class='myDblClick' name='realYards130'>"
                  		//实际130码
                    + (data[i].realYards130 == null ? '' : data[i].realYards130)
                    + "</td><td class='myDblClick' name='realYards160'>"
                        //实际160码
                    + (data[i].realYards160 == null ? '' : data[i].realYards160)
                    + "</td><td class='myDblClick' name='realYards170'>"
                        //实际170码
                    + (data[i].realYards170 == null ? '' : data[i].realYards170)
                    + "</td><td>"
                        //实际入库数
                    + (data[i].actualTotalDeal  == null ? '' : data[i].actualTotalDeal )
                    + "</td><td class='myDblClick' name='trackingPeople'>"
                        //跟踪人
                    + (data[i].trackingPeople  == null ? '' : data[i].trackingPeople )
                    + "</td><td>"
                        //下单日期
                    + (data[i].orderDate  == null ? '' : data[i].orderDate )
                    + "</td><td>"  	
                    	//计划入库日期
                    + (data[i].planStorageDate == null ? '' :  data[i].planStorageDate)
                    + "</td><td>"  	
                    	//订单剩余天数
                    + (data[i].planStorageDate == null ? '' :  showtimeplan(data[i].planStorageDate) )
                    + "</td><td>"  	
                    	//环节开始时间
                    + (data[i].linkStartTime == null ? '' : data[i].linkStartTime)
                    + "</td><td>"  	
                    	//本环节耗费天数
                    + (data[i].linkStartTime == null ? '' : showtimelink(data[i].linkStartTime))
                    + "</td><td class='myDblClick' name='remarks'>"  	
                    	//备注
                    + (data[i].remarks == null ? '' : data[i].remarks)
                    + "</td><td>"  	
                    	//出库订单号
                    + (data[i].deliveryOrderNumber == null ? '' : data[i].deliveryOrderNumber)
                    + "</td><td class='myDeliveryTime'>"
                        //确认出货时间
                    + (data[i].confirmDeliveryTime == null ? '' : data[i].confirmDeliveryTime)
                    + "</td><td  class='deliveryStatus" + data[i].deliveryStatus+"'><button type='button'  data-toggle='modal' onclick='confirmShipment(\""
		                    + data[i].id
		                    + "\")' class='btn btn-primary btn-sm icon-confirm'>确认出货</button></td></tr>";
                $(".table_app").append(_HTML_TEBLE_);
                var deliveryStatus = data[i].deliveryStatus;
                
				if (deliveryStatus =='已出货') {
					$(".deliveryStatus" + data[i].deliveryStatus)
							.parent().attr("bgcolor", "#FF7D00");
					$(".deliveryStatus" + data[i].deliveryStatus).find(
					'button').remove();
					$(".deliveryStatus" + data[i].deliveryStatus)
					.append(
							"<button disabled='disabled'  type='button'  data-toggle='modal'  class='btn btn-primary btn-sm icon-confirm'>已出货</button>");
				}
            }
            updbclick();
        });
}



function confirmShipment(id) {
	if(window.confirm('你确定要出货吗？')){
    
      
     }else{
    
        return;
    }
    console.log(id);
    argArr = {id: id};
    $.ajax({
        url : '/confirmShipment.do',
        dataType : 'json',
        type : 'post',
        data : argArr,
        success : function(data) {
            console.log("confirmShipment==============="+data);
            var anyVal = $("#form-anyVal").serialize();
            getDistributionInfoBpcnt(anyVal);
           
        },
        error : function() {
            alert("服务异常!");
        }
    });
}

function updbclick() {

	$(".myDblClick").on("dblclick",function() {
		
		if($(this).parent().find(".myDeliveryTime").text().trim()!=='')
		{
		return ;
		}
		if($(this).parent().find(".myDataStatus").text().trim()=='已拍摄')
		{
		return;
		}
		var id = $(this).parent().find(".id").val();
		var code = $(this).text().trim();
		var name = $(this).attr("name");
		//alert("code========"+code);
		$(this).html("<input id='" + id + "' type='text' value='"+code+"' name='" + name + "' style='width:100px;'> ");
		$("#" + id).focus();// 文本框获取光标事件

		uppblur(id, name);
	});
}
// 光标离开事件
function uppblur(id, name) {
	
	$("#" + id).blur(function() {
		var newtxt = $(this).val();
		if(isNaN(newtxt))
		{
			if(!(name=='remarks'||name=='trackingPeople')){
			alert("只允许添加数字！！！");
			var anyVal = $("#form-anyVal").serialize();
	        getDistributionInfoBpcnt(anyVal);
	            return;}
		}
		if(!(name=='remarks'||name=='trackingPeople') && newtxt=='')
		{ 
			newtxt=0;
		}
		
		$(this).closest("td").text(newtxt);
		var data = {id : id};
		data[name] = newtxt;
	  
		$.ajax({
			url : '/modifyDistributionInfo.do',
			dataType : 'json',
			type : 'post',
			data : data,
			success : function(data) {
				if (data == 1) {
					
					 var anyVal = $("#form-anyVal").serialize();
			            getDistributionInfoBpcnt(anyVal);
					
				}
			},error : function() {
				alert("修改失败,输入的类型错误!");
			}
		});
	});
}


function showtimeplan(time){
	
	var datenow=new Date();
	var dateplan=new Date(time);
	var dif = datenow.getTime() - dateplan.getTime();
	var day = Math.floor(dif / (1000 * 60 * 60 * 24));
	day+=1;
	return day;
}
function showtimelink(time){
	
	var datenow=new Date();
	var datelink=new Date(time);
	var dif = datenow.getTime() - datelink.getTime();
	var day = Math.floor(dif / (1000 * 60 * 60 * 24));
	day+=1;
	return day;
}





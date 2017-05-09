//页面加载就执行
$(function () {
	//页面载入，加载订单数据和分页数据
	loadData();
    
	//点击查询按钮
    $('#anyVal-btn').click(function(){
    	//加载订单数据和分页数据
    	loadData();
    });
    //点击提交按钮(可能是修改或添加)
    $("#submit-btn").click(addOrUpdate);
    
    //点击添加按钮
    $('#add_button').click(clickAddBtn);
    //图片预览
    $("#up").uploadPreview({
		Img : "ImgPr",
		Width : 120,
		Height : 120
	}); 
    
});

//点击添加按钮
function clickAddBtn(){
	//把提交按钮状态改为添加
	$('#obj_hidden_id').val("");
	//清空表单数据
	$('#form-input')[0].reset();
	//清空图片预览的图片
	$("#ImgPr").attr('src',"");  
	//把波次号和商品编号设为可编辑状态
	//$("#goodsId").attr("disabled",false);
	//$("#wave").attr("disabled",false);
	$('#goodsId').removeAttr("readonly");//去除input元素的readonly属性
	$('#wave').removeAttr("readonly");//去除input元素的readonly属性 
}
//点击提交按钮(可能是提交修改，也可能是提交添加)
function addOrUpdate(){
	//获取表单数据
	var formData = new FormData($("#form-input")[0]);
	//获取隐藏值，判断是添加还是修改
	var info = $('#obj_hidden_id').val();
	//等于info=""是添加,否则是修改
	var url = (info == "" ? 'ApparelDevelopmentDesignBuyerOrder/add.do':'ApparelDevelopmentDesignBuyerOrder/update.do' );
   	//获取wave
	var wave = $('#wave').val();
	//提交表单，发送添加请求
	$.ajax({
		url:url,
		type:'post',
		async : false,		//不用写
		cache : false,		//不用写
		contentType : false,//必须写(如果是提交FormDate类型数据，也就是要提交文件)
		processData : false,//必须写
		data:formData,
		dataType:'json',
		success:function(data){
			if(data == 1){
				//添加成功,重新刷新页面加载数据
				loadData();
			}
		}
	});

}
//点击修改按钮
function update(id){
	//把题头改成修改
	$('#modalTitle').html('修改');
	//显示模态框
	$('#myModal').modal('show');
	$('#obj_hidden_id').val(id);
	//根据id查询并赋值
	$.ajax({
		url:'ApparelDevelopmentDesignBuyerOrder/selectById.do',
		type:'post',
		async: false,
		data:{'id':id},
		dataType:'json',
		success:function(data){
			//把波次号和商品编号设置为不可编辑
			//$("#goodsId").attr("disabled",true);
			//$('#wave').attr("disabled",true);
			//$('#goodsId').attr("readonly","readonly")//将input元素设置为readonly 　　 
			//$('#wave').attr("readonly","readonly")//将input元素设置为readonly 　　 
			//修改时的赋值
			$('#obj_hidden_id').val(id);//把提交按钮状态改为修改，并把id赋值到表单中，一会提交时需要根据id修改数据
			$('#wave').val(data.wave);
			$('#goodsId').val(data.goodsId);
			$('#link').val(data.link);
			$('#requireDescription').val(data.requireDescription);
			$('#code52').val(data.code52);
			$('#code59').val(data.code59);
			$('#code66').val(data.code66);
			$('#code73').val(data.code73);
			$('#code80').val(data.code80);
			$('#code90').val(data.code90);
			$('#code100').val(data.code100);
			$('#code110').val(data.code110);
			$('#code120').val(data.code120);
			$('#code130').val(data.code130);
			$('#code160').val(data.code160);
			$('#code170').val(data.code170);
			//图片预览
		    $("#ImgPr").attr('src',data.designImg);  
		}
	});
}

//点击删除的方法 
function deleteOrder(id){
	if(confirm("确认删除??")){//提示是否确认
		$.ajax({
			url:'ApparelDevelopmentDesignBuyerOrder/delete.do',
			type:'post',
			data:{'id':id,'orderStatus':0},//0位删除状态
			dataType:'json',
			success:function(data){
				if(data == 1){
					loadData();//重新加载数据
					alert("删除成功!");
				}
			}
		});
	}
}

//查询总条数,并显示数据
function loadData() {
	//发送请求
	$.ajax({
		url:'ApparelDevelopmentDesignBuyerOrder/getPageCount.do',//发送这个请求，得到分页的page信息
		type:'post',
		data:$('#form-anyVal').serialize(),
		dataType:'json',
		success:function(data){
            //显示主体数据
            showData();
            //显示分页
            showPage(data);
		}
	});
}
	
//显示数据的方法
function showData(){
	//发送请求得到订单信息，并显示
	$.ajax({
		url:'ApparelDevelopmentDesignBuyerOrder/select.do',
		type:'post',
		data:$("#form-anyVal").serialize(),
		dataType:'json',
		success:function(data){
			//清空原来数据
			$('#t_body').empty();
			for(var i=0;i<data.length;i++){
				var s_order = '';
				s_order+='<tr>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].wave == null ? '':data[i].wave)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].goodsId == null ? '':data[i].goodsId)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;"><img src="'+(data[i].designImg == null ? '':data[i].designImg)+'" height="150" width="150"/></th>';
				s_order+=' 	<th style="width:100px;vertical-align:middle;"><a href="'+(data[i].link == null ? '#':data[i].link)+'" target="_blank">'+(data[i].link == null ? '':data[i].link)+'</a></th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].requireDescription == null ? '':data[i].requireDescription)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code52 == null ? '':data[i].code52)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code59 == null ? '' : data[i].code59)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code66 == null ? '': data[i].code66)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code73 == null ? '' : data[i].code73)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code80 == null ? '' : data[i].code80)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code90 == null ? '' : data[i].code90)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code100 == null ? '' : data[i].code100)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code110 == null ? '' : data[i].code110)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code120 == null ? '' : data[i].code120)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code130 == null ? '' : data[i].code130)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code160 == null ? '' : data[i].code160)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].code170 == null ? '' : data[i].code170)+'</th>';
				s_order+=' 	<th style="vertical-align:middle;">'+(data[i].totalPiece == null ? '' : data[i].totalPiece)+'</th>';
				//订单状态
				if(data[i].buyStatus == 'n'){
					s_order+=' 	<th style="vertical-align:middle;"><span style="color:black">未采购<span></th>';
					s_order+=' 	<th style="vertical-align:middle;">'+(data[i].addTime == null ? '':data[i].addTime)+'</th>';
					s_order+=' 	<th style="vertical-align:middle;">'+(data[i].buyTime == null ? '' : data[i].buyTime)+'</th>';
					s_order+=' 	<th style="vertical-align:middle;">'+(data[i].cancelTime == null ? '' : data[i].cancelTime)+'</th>';
					s_order+=' 	<th style="vertical-align:middle;"> <button class="btn btn-primary " onclick="update(\' '+data[i].id+' \')">修改订单</button><br>';
					s_order+='		 <button class="btn btn-success" onclick="buy(\' '+data[i].id+' \')">确定采购</button><br>';
					s_order+='       <button class="btn btn-danger" onclick="deleteOrder(\' '+data[i].id+' \')">删除订单</button></th>';
				}
				else if(data[i].buyStatus == 'y'){
					s_order+=' 	<th style="vertical-align:middle;"><span style="color:green">已采购<span></th>';
					s_order+=' 	<th style="vertical-align:middle;">'+(data[i].addTime == null ? '':data[i].addTime)+'</th>';
					s_order+=' 	<th style="vertical-align:middle;">'+(data[i].buyTime == null ? '' : data[i].buyTime)+'</th>';
					s_order+=' 	<th style="vertical-align:middle;">'+(data[i].cancelTime == null ? '' : data[i].cancelTime)+'</th>';
					s_order+=' 	<th style="vertical-align:middle;"> <button class="btn btn-primary "  disabled="disabled" onclick="update(\' '+data[i].id+' \')">修改订单</button><br>';
					s_order+='		 <button class="btn btn-info" disabled="disabled" >已采购　</button><br>';
					s_order+='       <button class="btn btn-danger" disabled="disabled"  onclick="deleteOrder(\' '+data[i].id+' \')">删除订单</button></th>';
				}
				else if(data[i].buyStatus == 'c'){
					s_order+=' 	<th style="vertical-align:middle;"><span style="color:red">已取消<span></th>';
					s_order+=' 	<th style="vertical-align:middle;">'+(data[i].addTime == null ? '':data[i].addTime)+'</th>';
					s_order+=' 	<th style="vertical-align:middle;">'+(data[i].buyTime == null ? '' : data[i].buyTime)+'</th>';
					s_order+=' 	<th style="vertical-align:middle;">'+(data[i].cancelTime == null ? '' : data[i].cancelTime.substring(0,11))+'</th>';
					s_order+=' 	<th style="vertical-align:middle;"> <button class="btn btn-primary "  disabled="disabled" onclick="update(\' '+data[i].id+' \')">修改订单</button><br>';
					s_order+='		 <button class="btn btn-info" disabled="disabled" >已取消　</button><br>';
					s_order+='       <button class="btn btn-danger" disabled="disabled"  onclick="deleteOrder(\' '+data[i].id+' \')">删除订单</button></th>';
				}
				
			//	s_order+='       <button class="btn btn-default" onclick="cancelOrder(\' '+data[i].id+' \')">取消订单</button><br>';
				
				s_order+='</tr>';
				
				
				//转为jquery对象
				$order = $(s_order);
				//添加到tbody里
				$('#t_body').append($order);
			}
		}
	});
}
//采购
function buy(id){
	var buyStatus='y';
	if(confirm("确定采购？")){
		$.ajax({
			url:'ApparelDevelopmentDesignBuyerOrder/updateontform.do',
			type:'post',
			data:{'id':id,'buyStatus':buyStatus},
			dataType:'json',
			success:function(data){
				if(data == 1){
					//添加成功,重新刷新页面加载数据
					loadData();
				}
			}
		});
	}
}
//取消订单
function cancelOrder(id){
	var buyStatus='c';
	if(confirm("确定取消订单？")){
		$.ajax({
			url:'ApparelDevelopmentDesignBuyerOrder/updateontform.do',
			type:'post',
			data:{'id':id,'buyStatus':buyStatus},
			dataType:'json',
			success:function(data){
				if(data == 1){
					//添加成功,重新刷新页面加载数据
					loadData();
				}
			}
		});
	}
}
//显示分页的方法
function showPage(data){
	//创建分页
	 $(".tcdPageCode").createPage({ 
           pageCount: data.totalPageCount, //总页数
           current: data.pageNow,   //当前页
           backFn: function (p) {	//如果点击了分页信息
               $("#pageNow").val(p); //给当前页赋值
               //重新加载
               loadData();
           }
    });
}

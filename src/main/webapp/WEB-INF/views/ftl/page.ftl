
<#macro pagination  action type size page status>
		<form action="${action!}" id="formId" method="post">
			<input name="type" value="${type!}" hidden="true" />
			<input name="pageNo"  hidden="true" id="pageId"/>
			<input name="staus"  hidden="true" value="${status}"/>
			<input name="status"  value="${status}" hidden=true" />
		</form>
		<div class="page">
				<#if page.totalRecord==0>
					没有相关数据
				<#else>
				<ul>
						<li class="turn"><a onclick="previewPage()">上一页</a></li>
							<#if (page.pageNo>5) && ((page.pageNo+5)<=page.totalPage) >
								<#list (page.pageNo-5)..(page.pageNo+5) as n> 
									<#if n== page.pageNo>
										<li class="num1">${n}</li>
									<#else>
										<li class="num"><a onclick="jump(${n})">${n}</a></li>
									</#if>
	        					</#list> 
	        				<#elseif (page.pageNo<=5) && (10<=page.totalPage)>
	        					<#list 1..10 as n> 
									<#if n== page.pageNo>
										<li class="num1">${n}</li>
									<#else>
										<li class="num"><a onclick="jump(${n})">${n}</a></li>
									</#if>
	        					</#list> 
	        				<#elseif (page.pageNo<=5) && ((page.pageNo+10)>page.totalPage)>
	        					<#list 1..(page.totalPage) as n> 
									<#if n== page.pageNo>
										<li class="num1">${n}</li>
									<#else>
										<li class="num"><a onclick="jump(${n})">${n}</a></li>
									</#if>
	        					</#list> 
	        				<#elseif (page.pageNo>5) && ((page.pageNo+3)>page.totalPage)>
	        					<#list (page.pageNo-5)..page.totalPage as n> 
									<#if n== page.pageNo>
										<li class="num1">${n}</li>
									<#else>
										<li class="num"><a onclick="jump(${n})">${n}</a></li>
									</#if>
	        					</#list> 
							</#if>
						<li class="turn"><a onclick="nextPage()">下一页</a></li>
				</ul>
				</#if>
		</div>

		<script>
			function nextPage(){
				if(${page.pageNo}==${page.totalPage}){
					return ;
				}
				$("#pageId").val("${page.pageNo+1}");
				$("#formId").submit();
			}
			function previewPage(){
				if(${page.pageNo}==1){
					return ;
				}	
				$("#pageId").val("${page.pageNo-1}");
				$("#formId").submit();
			}
			function jump(page){
				$("#pageId").val(page);
				$("#formId").submit();
			}
		</script>
</#macro>





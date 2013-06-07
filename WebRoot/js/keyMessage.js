

$(function(){
	//定义DWRUtil，否则报错
	if (typeof window["DWRUtil"] == "undefined") {  
		window.DWRUtil = dwr.util;  
	}  
        
	//修改时初始化页面
	if($("#keyMessageId").val()!=""){
		/*初始化程序版本*/
		if($("#procedureMessage").val()!=""){
			var array=new Array();
			array[0]=$("#procedureMessage").val();
			array[1]="1";
			procedureVersionService.findByProcedureMessageIdDwr(array,
				function(data){
					//alert(data)
					DWRUtil.removeAllOptions("procedureVersion"); 
					DWRUtil.addOptions("procedureVersion", [""]); 
					DWRUtil.addOptions("procedureVersion", data); 
					//确定版本选中项
					DWRUtil.setValue("procedureVersion",$("#versionId").val());
				}
			);
		}
		/*初始化单位*/
		if($("#provinceId").val()!=""){
			$("#province option").each(function(){
				if($(this).val()==$("#provinceId").val()){
					$(this).attr("selected",true);
				}
			});
			//初始化市级单位
			var array=new Array();
			array[0]=$("#provinceId").val();
			array[1]="2";//单位等级
			array[2]="1";
			departmentService.findByParentID(array,
				function(data){
					DWRUtil.removeAllOptions("city"); 
					DWRUtil.addOptions("city", [""]); 
					DWRUtil.addOptions("city", data); 
					//确定市级选中项
					DWRUtil.setValue("city",$("#cityId").val());
				}
			);
		}
		if($("#cityId").val()!=""){
			var array=new Array();
			array[0]=$("#cityId").val();
			array[1]="3";//单位等级
			array[2]="1";
			departmentService.findByParentID(array,
				function(data){
					DWRUtil.removeAllOptions("district"); 
					DWRUtil.addOptions("district", [""]); 
					DWRUtil.addOptions("district", data); 
					//确定区级选中项
					DWRUtil.setValue("district",$("#districtId").val());
				}
			);
		}
	}
	
	
	$("#procedureMessage").change(function(){
		if($(this).val()!=""){
			var array=new Array();
			array[0]=$(this).val();
			array[1]="1";
			procedureVersionService.findByProcedureMessageIdDwr(array,
				function(data){
					//alert(data)
					DWRUtil.removeAllOptions("procedureVersion"); 
					DWRUtil.addOptions("procedureVersion", [""]); 
					DWRUtil.addOptions("procedureVersion", data); 
				}
			);
		}else{
			$("#procedureVersion option").remove();
		}
	});
	
	$("#province").change(function(){
		if($(this).val()!=""){
			var array=new Array();
			array[0]=$(this).val();
			array[1]="2";
			array[2]="1";
			departmentService.findByParentID(array,
				function(data){
					//alert(data)
					DWRUtil.removeAllOptions("city"); 
					DWRUtil.addOptions("city", [""]); 
					DWRUtil.addOptions("city", data); 
				}
			);
		}else{
			$("#city option").remove();;
			//$("#city option").add("#district option").remove();
		}
			$("#district option").remove();
	});
	$("#city").change(function(){
		if($(this).val()!=""){
			var array=new Array();
			array[0]=$(this).val();
			array[1]="3";
			array[2]="1";
			departmentService.findByParentID(array,
				function(data){
					//alert(data)
					DWRUtil.removeAllOptions("district"); 
					DWRUtil.addOptions("district", [""]); 
					DWRUtil.addOptions("district", data); 
				}
			);
			
		}else{
			$("#district option").remove();
		}
	});
	
	//控制快递编号文本框
	$("#isExpress").click(function(){
		if($("#isExpress").attr("checked")){
			$("#expressCode").attr("disabled",false);
		}else{
			$("#expressCode").attr("disabled",true);
			$("#expressCode").val("");
		}
	});
	
	//锁用途描述
	$("#purpose").change(function(){
		$("#purposeRemark").text($("#purpose :checked").text());
	});
	
	//锁数量必须为数字校验
	$("# keyNum").blur(function(){
		if (!($(this).val().match(/^\d+$/))&&$(this).val()!="") {
			alert("加密锁数量只能为正整数！");
			$(this).val("");
			return;
		}
	});
	
	//表单提交校验
	$("#add").submit(function(){
		if($("#procedureMessage").val().replace(/[ ]/g,"")==""){
			alert("请选择程序！！");
			$("#procedureMessage").focus();
			return false;
		}
		if($("#procedureVersion").val().replace(/[ ]/g,"")==""){
			alert("请选择程序版本！！");
			$("#procedureVersion").focus();
			return false;
		}
		if($("#province").val().replace(/[ ]/g,"")==""){
			alert("请选择单位！！");
			$("#province").focus();
			return false;
		}
		if($("#keyNum").val().replace(/[ ]/g,"")==""){
			alert("请填写锁数量！！");
			$("#keyNum").focus();
			return false;
		}
		if($("#expressType").val().replace(/[ ]/g,"")==""){
			alert("请选择送锁方式！！");
			$("#expressType").focus();
			return false;
		}
		if($("#expressDate").val().replace(/[ ]/g,"")==""){
			alert("请选填写送锁日期！！");
			$("#expressDate").focus();
			return false;
		}
		if($("#purpose").val().replace(/[ ]/g,"")==""){
			alert("请选选择用途描述！！");
			$("#purpose").focus();
			return false;
		}
		if($("#remark").val().length>1000){
			alert("备注不能超过1000字！！");
			$("#remark").focus();
			return false;
		}
	});

});
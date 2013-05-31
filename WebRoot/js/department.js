$(function(){
	//定义DWRUtil，否则报错
	if (typeof window["DWRUtil"] == "undefined") {  
		window.DWRUtil = dwr.util;  
	}  
	
	//修改时，初始化科目下拉框
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
	
	$("#district").change(function(){
		if($(this).val()!=""){
			//保存按钮只读
			$("#addSubmit").add("#departmentName").attr("disabled",true);
		}else{
			//取消保存按钮只读
			$("#addSubmit").add("#departmentName").attr("disabled",false);
		}
	});
	
});
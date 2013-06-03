$(function(){
	//定义DWRUtil，否则报错
	if (typeof window["DWRUtil"] == "undefined") {  
		window.DWRUtil = dwr.util;  
	}  
	
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
	
	$("#province").add("#city").add("#district").change(function(){
		if($("#district").val()!=""&&$("#district").val()!=null){
			//保存按钮只读
			$("#addSubmit").add("#departmentName").attr("disabled",true);
		}else{
			//取消保存按钮只读
			$("#addSubmit").add("#departmentName").attr("disabled",false);
		}
	});
	
});
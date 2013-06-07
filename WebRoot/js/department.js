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
	
	//单位父节点变化时，下方修改文本框中出现最后一级单位，以便修改
	$(".province").change(function(){
		if($("#district").val()!=null&&$("#district").val()!=""){
			$("#departmentName1").val($("#district :selected").text());
		}else if($("#city").val()!=null&&$("#city").val()!=""){
			$("#departmentName1").val($("#city :selected").text());
		}else if($("#province").val()!=null&&$("#province").val()!=""){
			$("#departmentName1").val($("#province :selected").text());
		}
	});
	
	//表单提交验证
	$("#department_add").submit(function(){
//		if($("#province").val()==""){
//			alert("单位父节点不能为空！！");
//			return false;
//		}
		if($("#departmentName").val().replace(/[ ]/g,"")==""){
			alert("单位名称不能为空！！");
			$("#departmentName").focus();
			return false;
		}
		$("#departmentName1").remove();
	});
	
	//修改，表单提交
	$("#updateSubmit").click(function(){
		if($("#province").val()==""){
			alert("单位父节点不能为空！！");
			return false;
		}
		if($("#departmentName1").val().replace(/[ ]/g,"")==""){
			alert("单位名称不能为空！！");
			$("#departmentName1").focus();
			return false;
		}
		$("#departmentName").remove();
		$("#department_add").attr("action","department_updateDepartment").submit();
	});
	
});
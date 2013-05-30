function paginate(currentPage) {
			window.location.href="procedureVersion_init.action?currentPage="+currentPage;
		}

$(function(){
	$("#add").submit(function(){
		
		if($("#procedureMessage").val().replace(/[ ]/g,"")==""){
			alert("请选择程序名称！！");
			return false;
		}
		if($("#VersionName").val().replace(/[ ]/g,"")==""){
			alert("请填写程序版本！！");
			return false;
		}
	});
});
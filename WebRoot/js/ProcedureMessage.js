function paginate(currentPage) {
			window.location.href="procedureMessage_init.action?currentPage="+currentPage;
		}

$(function(){
	$("#add").submit(function(){
		if($("#procedureName").val().replace(/[ ]/g,"")==""){
			alert("请填写程序名称！！");
			return false;
		}
		if($("#remark").val().replace(/[ ]/g,"")==""){
			alert("请填写程序描述！！");
			return false;
		}
	});
});
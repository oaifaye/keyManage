function paginate(currentPage) {
			window.location.href="kindOfKey_init.action?currentPage="+currentPage;
		}
$(function(){
	$("#add").submit(function(){
		if($("#kindName").val().replace(/[ ]/g,"")==""){
			alert("请填写种类名称！！");
			return false;
		}
		if($("#remark").val().replace(/[ ]/g,"")==""){
			alert("请填写备注！！");
			return false;
		}
	});
});
function paginate(currentPage) {
			window.location.href="expressType_init.action?currentPage="+currentPage;
		}

$(function(){
	$("#add").submit(function(){
		if($("#expressTypeName").val().replace(/[ ]/g,"")==""){
			alert("请填写送锁方式！！");
			return false;
		}
	});
});
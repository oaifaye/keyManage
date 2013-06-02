function paginate(currentPage) {
			window.location.href="purpose_init.action?currentPage="+currentPage;
		}

$(function(){
	$("#add").submit(function(){
		if($("#purposeName").val().replace(/[ ]/g,"")==""){
			alert("请填写用锁目的！！");
			return false;
		}
		if($("#remark").val().replace(/[ ]/g,"")==""){
			alert("请填写目的描述！！");
			return false;
		}
	});
});
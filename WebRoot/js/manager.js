
function paginate(currentPage) {
			window.location.href="manager_init.action?currentPage="+currentPage;
		}

$(function(){
	$("#add").submit(function(){
		if($("#role").val()==""){
			alert("请选择用户角色！！");
			return false;
		}
		if($("#name").val().replace(/[ ]/g,"")==""){
			alert("请填写用户名称！！");
			return false;
		}
		if($("#userName").val().replace(/[ ]/g,"")==""){
			alert("请填写用户名！！");
			return false;
		}
	});
});
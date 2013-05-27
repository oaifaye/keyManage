function paginate(currentPage) {
			window.location.href="contain_init.action?currentPage="+currentPage;
		}
$(function(){
	//如果是修改，锁种类、锁数量与入库时间为disabled
	if($("#containId").val()!=""){
		$("#kindOfKey").add("#keyNum").add("#containDate").attr("disabled",true);
	}
	
	//锁数量必须为数字校验
	$("#keyNum").blur(function(){
		if (!($(this).val().match(/^\d+$/))&&$(this).val()!="") {
			alert("加密锁数量只能为正整数！");
			$(this).val("");
			return;
		}
	});
	
	//表单提交校验
	$("#add").submit(function(){
		if($("#kindOfKey").val()==""){
			alert("请选择加密锁种类！！");
			$("#kindOfKey").focus();
			return false;
		}
		if($("#lotNumber").val().replace(/[ ]/g,"")==""){
			alert("请填写加密锁批号！！");
			$("#lotNumber").focus();
			return false;
		}
		if($("#keyNum").val().replace(/[ ]/g,"")==""){
			alert("请填写加密锁数量！！");
			$("#keyNum").focus();
			return false;
		}
		if($("#containDate").val().replace(/[ ]/g,"")==""){
			alert("请填写加密锁入库时间！！");
			$("#containDate").focus();
			return false;
		}
	});
});
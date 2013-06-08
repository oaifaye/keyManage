
$(function(){
	$("#execEditPass").submit(function(){
		if($("#password").val().replace(/[ ]/g,"")==""){
			alert("请输入密码！！");
			$("#password").focus();
			return false;
		}
		
		if($("#passwordRepeat").val().replace(/[ ]/g,"")==""){
			alert("请再次输入密码！！");
			$("#passwordRepeat").focus();
			return false;
		}
		
		if($("#password").val()!=$("#passwordRepeat").val()){
			alert("两次输入密码不相同，请重新填写！！");
			$("#password").add("#passwordRepeat").val("");
			return false;
		}
		
		if($("#password").add("#passwordRepeat").val().length<6){
			alert("为了您账户的安全，密码长度不应小于6！！");
			$("#password").add("#passwordRepeat").val("");
			return false;
		}
	});
});
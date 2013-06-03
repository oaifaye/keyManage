$(function(){
	
	//定义DWRUtil，否则报错
	if (typeof window["DWRUtil"] == "undefined") {  
		window.DWRUtil = dwr.util;  
	}  
	//申请取页面切换
	$(".askKey").click(function(){
		// 设置div greybackground的高与body一样
		var winHeight = $(document).height();
		$("#greybackground").css({
			"height" : winHeight
		});
		$("#askKeySubmit").css("display", "block");
		//给密码锁名称赋值
		$("#keyName").text($(this).parent().parent().find("#countObjectName").text());
		//给剩余锁数量赋值
		$("#num").text($(this).parent().parent().find("#countObjectNum").text());
		//给kindOfKeyId的hidden赋值
		$("#kindOfKeyId").val($(this).parent().find("#id").val());
	});
	
	//关闭
	$("#close").click(function(){
		$("#greybackground").css({
			"height" : 0
		});
		$("#askKeySubmit").css("display", "none");
		$("#askNum").add("#askDate").add("#askRemark").val("");
	});
	
	//确定申请数量为数字
	$("#askNum").blur(function(){
		if($(this).val() != ""){
			if (!($(this).val().match(/^\d+$/))) {
				alert("申请数量只能为数字！");
				$(this).val("");
				return;
			} else {
				if ($(this).val() == 0) {
					alert("申请数量不能为0！");
					$(this).val("");
					return;
				}
			}
		}
		//异步判断锁剩余数量是否够数
		containService.findNumByKindOfKeyID($("#kindOfKeyId").val(),
			function(data){
				if(data<parseInt($("#askNum").val())){
					alert("申请数量不能超过"+data+"!!");
					$("#askNum").val("");
					return;
				}
			}
		);
	});
	
	//表单提交验证
	$("#addKeyAsk").submit(function(){
		if($("#askNum").val()==""){
			alert("请输入申请数量！！");
			$("#askNum").focus();
			return false;
		}
		if($("#askDate").val()==""){
			alert("请输入需求时间！！");
			$("#askDate").focus();
			return false;
		}
		if($("#askRemark").val()==""){
			alert("请输入需求备注！！");
			$("#askRemark").focus();
			return false;
		}
		if(confirm("提交后将无法修改，是否确定申请?")){
			return true;
		}else{
			return false;
		}
	});
	
});
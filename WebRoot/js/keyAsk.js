$(function(){
	
	//申请取页面切换
	$("#askKey").click(function(){
		// 设置div greybackground的高与body一样
		var winHeight = $(document).height();
		$("#greybackground").css({
			"height" : winHeight
		});
		$("#askKeySubmit").css("display", "block");
		//给密码锁名称赋值
		//给kindOfKeyId的hidden赋值
		$("#kindOfKeyId").val($(this).parent().find("#id").val());
	});
	
});
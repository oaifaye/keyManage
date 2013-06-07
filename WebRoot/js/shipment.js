function paginate(currentPage) {
			window.location.href="contain_initShipment.action?currentPage="+currentPage;
		}
$(function(){
	
	//锁数量必须为数字校验
	$(".shipmentNum").blur(function(){
		if (!($(this).val().match(/^\d+$/))&&$(this).val()!="") {
			alert("加密锁数量只能为正整数！");
			$(this).val("");
			return;
		}
	});
	
	//表单提交验证
	$("#add").submit(function(){
		var num=0;
		$(".shipmentNum").each(function(){
			var tempNum=$(this).val().replace(/[ ]/g,"");
			if(tempNum!=""&&tempNum!='0'){
				num=parseInt(tempNum)+num;
			}
		});
		if(num<=0||num>parseInt($("#lastNum").text())){
			alert("给予锁的数量不能大于"+$("#lastNum").text()+"\n且不能为零!!!");
			return false;
		}
		$("#totalNum").val(num);
	});
	
	//返回
	$("#rollBack").click(function(){
		window.location.href="contain_initShipment.action";
	});
});
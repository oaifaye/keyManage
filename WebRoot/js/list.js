$(function(){
		$('tbody tr:odd').addClass("trLight");
		
		$(".select-all").click(function(){
			if($(this).attr("checked")){
				$(".checkBox input[type=checkbox]").each(function(){
					$(this).attr("checked", true);  
					});
				}else{
					$(".checkBox input[type=checkbox]").each(function(){
					$(this).attr("checked", false);  
					});
				}
			});
		
		});
function del(newsType){
	flag = false;
	var ids = document.getElementsByName("ids");
	for(var i = 0; i < ids.length; i++){
		if(ids[i].checked == true){
		flag = true;
		break;
		} 
	}
	if(flag == false){
		alert("至少选择一条记录！！");
	}
	else{
		if(confirm("新闻删除后将永久删除\n确定删除新闻？")) {
			document.submitForm.action=newsType+".action";
			document.submitForm.submit();
		}	
	}
}


$(function(){
//	document.documentElement.onclick = function(){  
//        //alert('name: '+self.parent.frames[1].name+', id: '+self.parent.frames[1].id);  
//        //self.frames[1].name = 'main';  
//        $("#rightPage").attr("name","data-jqv");
//        alert($("#rightPage").attr("name"))
//    }  
//	
	
	//setMenuHeight
	$('.menu').height($(window).height()-51-27-26-5);
	$('.sidebar').height($(window).height()-51-27-26-5);
	$('.page').height($(window).height()-51-27-26-5);
	$('.page iframe').width($(window).width()-15-168);
	$("#test").click(function(){
		alert('name: '+self.frames[1].name+', id: '+self.frames[1].id);
		//alert($("#rightPage").attr("name")+"xxxxxxxx"+$("#test1").attr("target"));  
	})
	
	//menu on and off
	$('.btn').click(function(){
		$('.menu').toggle();
		
		if($(".menu").is(":hidden")){
			$('.page iframe').width($(window).width()-15+5);
			}else{
			$('.page iframe').width($(window).width()-15-168);
				}
		});
		
	//
	$('.subMenu a[href="#"]').click(function(){
		$(this).next('ul').toggle();
		return false;
		});
});
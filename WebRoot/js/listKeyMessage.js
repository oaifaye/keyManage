$(function(){
	$("#selectSubmit").submit(function(){
		var start=$("#startDate").val().split("-");
		var startDateForm= new Date(start[0], start[1], start[2]);
		var startDate=startDateForm.getTime();
		var end=$("#endDate").val().split("-");
		var endDateForm= new Date(end[0], end[1], end[2]);
		var endDate=endDateForm.getTime();
		if(startDate>endDate){
			alert("结束时间应不小于开始时间！！");
			return false;
		}
	});
	
});
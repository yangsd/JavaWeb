seajs.use(['jquery','bootstrap','request'],function($,Bootstrap,Request){
	
	$("#signin").click(function(){
		Request.ajaxPost("greeting",{"billno":"123456"},"0",function(data){	
			 if(data){
				 alert();
			 }
			});
	});
});
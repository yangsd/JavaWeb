seajs.use(['jquery','bootstrap','request'],function($,Bootstrap,Request){
	
	/*
	$("#signin").click(function(){
		Request.ajaxPost("greeting",{"id":"123456"},"0",function(data){	
			 if(data){
				 alert("success");
			 }
			});
	});
	*/
	function setValidateCode() {
		$('img#codefont').attr('src', 'html/randomnum?num=' + new Date().getTime());
	}
	
	$('img#codefont').bind('click', setValidateCode);
});
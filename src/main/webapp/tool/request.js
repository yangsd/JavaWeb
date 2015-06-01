
define(function  (require, exports, module) {
	var $ =require("jquery");
	
	/**
	 * 
	 * 	
	 * @param urlStr 
	 * @param reqData
	 * @param conType  
	 * @param succFunction 
	 * 
	 */
	function ajaxPost(urlStr, reqData,reqType,succFunction) {
		var conType = "application/x-www-form-urlencoded";
		
		if(reqType == '1'){
			conType = 'application/json';
		}
		$.ajax({
			type : 'POST',			
			contentType:conType,
			dataType:"json",
			url : urlStr,
			data :reqData,
			beforeSend : function(){
				
				//Loading.createLoading();
			},
			success : function(data) {
				if(!data){
					succFunction(data);
				}else if (data.message != undefined) {
					
					alert(data.message);
				}else{
					
					succFunction(data);
				}
			},	
			error : function(XMLHttpResquest,textStatus,errorThrown) {	
				if (textStatus === "timeout") {
					alert("请求超时");
				} else {
					alert("请求失败");
				}
			},
			complete : function(){
				
				//Loading.removeLoading();
			}
		});

	};
	
	exports.ajaxPost = ajaxPost;
});
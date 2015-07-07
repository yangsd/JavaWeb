

$(document).ready(function(){
	$("#save").click(function(){
		submit();
	});
});



function submit(){
	$('#ff').form('submit', { 
		url:"saveUser",
	    onSubmit: function(){  
	        //进行表单验证  
	        //如果返回false阻止提交  
	    	return true;
	    },  
	    success:function(data){  
	        window.location.href="userDetail?id="+data;

	    }
	}); 
};

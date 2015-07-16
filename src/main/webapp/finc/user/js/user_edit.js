

$(document).ready(function(){
	$("#save").click(function(){
		submit();
	});
});



function submit(){
	$('#ff').form('submit', { 
		url:"updateUser",
	    onSubmit: function(){  
	        //进行表单验证  
	        //如果返回false阻止提交  
	    	return true;
	    },  
	    success:function(data){  
	    	$.messager.alert('Tips','update user success,return to user list page !','info',function(){ window.location.href="userDetail?pk_user="+data; });
    		
//	    	bootbox.alert({ 
//	    	    size: 'small',
//	    	    message: "update user success,return to user list page !", 
//	    	    callback: function(){ window.location.href="userDetail?pk_user="+data; }
//	    	});
	        

	    }
	}); 
};


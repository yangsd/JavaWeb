

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
	    	if(data){
		    	bootbox.alert({ 
		    	    size: 'small',
		    	    message: "add user success !", 
		    	    callback: function(){ window.location.href="userDetail?id="+data; }
		    	});
	    	}
	    }
	}); 
};


function prompt(){   
	$.messager.prompt('提示:','请输入消息.',function(r){   
		if(r){   
			alert("你输入的文本是:"+r);   
		}   
	});   
}  


$(document).ready(function(){
	$("#save").click(function(){
		submit();
	});
});



function submit(){
	$('#ff').form('submit', { 
		url:"updateUser",
	    onSubmit: function(){  
	        //���б���֤  
	        //�������false��ֹ�ύ  
	    	return true;
	    },  
	    success:function(data){  
	    	bootbox.alert({ 
	    	    size: 'small',
	    	    message: "update user success,return to user list page !", 
	    	    callback: function(){ window.location.href="userDetail?pk_user="+data; }
	    	});
	        

	    }
	}); 
};


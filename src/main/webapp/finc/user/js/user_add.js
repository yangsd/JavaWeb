

$(document).ready(function(){
	$("#save").click(function(){
		submit();
	});
});



function submit(){
	$('#ff').form('submit', { 
		url:"saveUser",
	    onSubmit: function(){  
	        //���б���֤  
	        //�������false��ֹ�ύ  
	    	return true;
	    },  
	    success:function(data){  
	        window.location.href="userDetail?id="+data;

	    }
	}); 
};

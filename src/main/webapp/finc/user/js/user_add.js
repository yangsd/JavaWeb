

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
	$.messager.prompt('��ʾ:','��������Ϣ.',function(r){   
		if(r){   
			alert("��������ı���:"+r);   
		}   
	});   
}  
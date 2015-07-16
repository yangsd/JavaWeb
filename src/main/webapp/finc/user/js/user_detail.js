
function edit(id){	
	window.location.href="/JavaWeb/finc/userEdit?pk_user="+id;		
};

function deleteUser(id){
	
	$.ajax({  
        url:'/JavaWeb/finc/deleteUser',  
        type:'POST',  
        data:{pk_user:id},  
        dataType:'json',  
        success:function (data) {  
        	if(data.detail){
       	 		alert(data.detail);
        	}else{
        		$.messager.alert('Tips','delete user success,return to user list page !','info',function(){ window.location.href="/JavaWeb/finc/userList"; });
        		/*
        		bootbox.alert({ 
		    	    size: 'small',
		    	    message: "delete user success,return to user list page !", 
		    	    callback: function(){ window.location.href="/JavaWeb/finc/userList"; }
		    	});
        		*/
        	}
        },
	     error : function(request, error, status) {
				var msg = "error-request:"+request+"error-error:"+error+"error-status:"+status;
				alert(msg);
			},
    });  
};

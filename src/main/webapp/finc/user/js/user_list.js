/**
 * 
 * @author sdyang
 * @date  2015-07-03
 */

$(function(){
	var curr_time = new Date();     
	$("#beginTime").datebox("setValue",dateformat_begin(curr_time));  
	$("#endTime").datebox("setValue",dateformat_end(curr_time)); 
	
	var queryParams = $('#usertable').datagrid('options').queryParams;  

    getQueryParams(queryParams);  
    $('#usertable').datagrid('options').queryParams = queryParams;
    
	$('#usertable').datagrid({	
	    url:'userPage', 
	    rownumbers:true,
	    singleSelect:true,
	    pagination:'true',
        method:'post',
        toolbar:'#tb',
        footer:'#ft',
	    columns:[[     
	        {field:'loginid',title:'Login ID',width:80,
	        	formatter: function(value,row,index){
		            return '<a href="userDetail?id='+row.pk_user+'">'+value+'</a>';	
		        }  	},     
	        {field:'name',title:'User name',width:100},     
	        {field:'access',title:'Access',width:80,align:'center'},
	        {field:'creatime',title:'Creatime',width:150}
	    ]]     
	});  
});


//获取查询参数
 function getQueryParams(queryParams) {  
     var beginTime = $("#beginTime").datebox("getValue");  
     var endTime = $("#endTime").datebox("getValue");  
     var access = $("#access").combobox('getValue');
      
     queryParams.beginTime = beginTime;  
     queryParams.endTime = endTime; 
     queryParams.access = access;
     
     return queryParams;  
 }  

 //增加查询参数，重新加载数据 
 function reloadgrid() {  

     //查询参数直接添加在queryParams中      

     var queryParams = $('#usertable').datagrid('options').queryParams;  
     getQueryParams(queryParams);  
      
     $("#usertable").datagrid('load',queryParams); 
     
     //使用ajax请求查询数据
     /*
     $.ajax({  
         url:'/JavaWeb/finc/userPage1',  
         type:'POST',  
         data:queryParams,  
         dataType:'json',  
         success:function (data) {  
        	//重新加载数据 
        	 $("#usertable").datagrid('loadData',data);  
         },
	     error : function(request, error, status) {
				var msg = "error-request:"+request+"error-error:"+error+"error-status:"+status;
				alert(msg);
			},
     });  
     */
 }
 
 function dateformat_begin(date){  
	    var y = date.getFullYear();  
	    var m = date.getMonth()+1;  
	    var d = 1;  
	    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  
	}
 function dateformat_end(date){  
	    var y = date.getFullYear();  
	    var m = date.getMonth()+1;  
	    var d = date.getDate();  
	    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  
	}  
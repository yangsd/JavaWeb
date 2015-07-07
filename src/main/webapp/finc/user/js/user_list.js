/**
 * 
 * @author sdyang
 * @date  2015-07-03
 */

$(function(){
	$('#usertable').datagrid({		
	    url:'userPage', 
	    rownumbers:true,
	    singleSelect:true,
	    pagination:'true',
        method:'get',
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
     var StartTime = $("#startTime").datebox("getValue");  
     var EndTime = $("#endTime").datebox("getValue");  
      
     queryParams.StartTime = StartTime;  
     queryParams.EndTime = EndTime;  
     return queryParams;  
 }  

 //增加查询参数，重新加载数据 
 function reloadgrid() {  

     //查询参数直接添加在queryParams中      

     var queryParams = $('#usertable').datagrid('options').queryParams;  
     getQueryParams(queryParams);  
     
     var data = {"total":2,"rows":[{"loginid":"D","name":"sdyang","access":"admin","creatime":20.0},{"loginid":"A","name":"abc","access":"user","creatime":20.0}]};
     
     //使用ajax请求查询数据
     
     $("#usertable").datagrid('loadData',data);//重新加载数据  

 }
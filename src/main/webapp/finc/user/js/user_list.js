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
	        {field:'itemid',title:'Item ID',width:80},     
	        {field:'productid',title:'Product',width:100,
	        	formatter: function(value,row,index){
	            return '<a href="userEdit">view</a>';	
	        }  	},     
	        {field:'listprice',title:'List Price',width:80,align:'right'},
	        {field:'unitcost',title:'Unit Cost',width:80,align:'right'},
	        {field:'attr1',title:'Attribute',width:240,align:'right'},
	        {field:'status',title:'Status',width:60,align:'center'}
	    ]]     
	});  
});


//��ȡ��ѯ����
 function getQueryParams(queryParams) {  
     var StartTime = $("#startTime").datebox("getValue");  
     var EndTime = $("#endTime").datebox("getValue");  
      
     queryParams.StartTime = StartTime;  
     queryParams.EndTime = EndTime;  
     return queryParams;  
 }  

 //���Ӳ�ѯ���������¼������� 
 function reloadgrid() {  

     //��ѯ����ֱ�������queryParams��      

     var queryParams = $('#usertable').datagrid('options').queryParams;  
     getQueryParams(queryParams);  
     
     var data = {"total":2,"rows":[{"productname":"D","unitcost":10.0,"status":"B","listprice":20.0,"attr1":"C","itemid":"D"},{"productname":"D","unitcost":5.0,"status":"T","listprice":20.0,"attr1":"E","itemid":"F"}]};
     
     //ʹ��ajax�����ѯ����
     
     $("#usertable").datagrid('loadData',data);//���¼�������  

 }
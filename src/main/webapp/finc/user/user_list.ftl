<!DOCTYPE html> 
<html lang="zh-CN">
<head>
    <#include "./common/common.ftl"/>
    <link href="user/css/user_list.css" rel="stylesheet">
    <script src="user/js/user_list.js"></script>
	<title>user_list</title>
</head>
<body>

	<#include "./common/navbar-user.ftl"/>
		
	<h1>User List</h1>
	
	<div style="margin:20px 0;"></div>
    <table class="easyui-datagrid" title="DataGrid Complex Toolbar" style="width:700px;height:250px"
            data-options="rownumbers:true,singleSelect:true,url:'userPage',pagination:'true',
            method:'get',toolbar:'#tb',footer:'#ft'">
        <thead>
            <tr>
                <th data-options="field:'itemid',width:80">Item ID</th>
                <th data-options="field:'productid',width:100">Product</th>
                <th data-options="field:'listprice',width:80,align:'right'">List Price</th>
                <th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
                <th data-options="field:'attr1',width:240">Attribute</th>
                <th data-options="field:'status',width:60,align:'center'">Status</th>
            </tr>
        </thead>
    </table>
    <div id="tb" style="padding:2px 5px;">
        Date From: <input class="easyui-datebox" style="width:110px">
        To: <input class="easyui-datebox" style="width:110px">
        Language: 
        <select class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="java">Java</option>
            <option value="c">C</option>
            <option value="basic">Basic</option>
            <option value="perl">Perl</option>
            <option value="python">Python</option>
        </select>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
    </div>
	
	<#include "./common/footer.ftl"/>
</body>
</html>
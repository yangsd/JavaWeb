<!DOCTYPE html> 
<html lang="zh-CN">
<head>
    <#include "./common/common.ftl"/>
    <!--
    <link href="user/css/user_list.css" rel="stylesheet">
    -->
    <script src="user/js/user_list.js"></script>
	<title>user_list</title>
</head>
<body>

	<#assign active='user'/>
	<#include "./common/navbar-user.ftl"/>
	
	<!--	
	<div style="margin:20px 0;"></div>
	-->
    <table id="usertable" class="easyui-datagrid" title="User List" style="width:700px;height:250px"></table>
    
    <!-- ²éÑ¯Ìõ¼ş  -->
    <div id="tb" style="padding:2px 5px;">
        Date From: <input id="beginTime" class="easyui-datebox" style="width:110px">
        To: <input id="endTime" class="easyui-datebox" style="width:110px">
        Language: 
        <select id="access" class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="2">user</option>
            <option value="1">admin</option>]
        </select>
        <a href="javascript:reloadgrid()" id="search" class="easyui-linkbutton" iconCls="icon-search">Search</a>
    </div>
	
	<!--  -->
	<#include "./common/footer.ftl"/>
</body>
</html>
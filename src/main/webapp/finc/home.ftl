<!DOCTYPE html> 
<html lang="zh-CN">
<head>
    <#include "./common/common.ftl"/>
	<script src="js/home.js"></script>	
	<title>home</title>
</head>
<body>
    <#assign active='home'/>
	<#include "./common/navbar-user.ftl"/>	
	
	<div class="input-append date form_datetime">
     	<input size="16" type="text" value="" readonly>
    	<span class="add-on"><i class="icon-th"></i></span>
	</div> 
		
	<#include "./common/footer.ftl"/>
</body>
</html>

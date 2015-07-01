<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
 	<link href="../themes/bootstrap/css/bootstrap.min.css" rel="stylesheet">	 
	 
	  
	<script src="../plugins/jquery-2.1.4.js"></script>
	
	<script src="../plugins/bootstrap.js"></script>	
	
	<script src="js/home.js"></script>	
	<title>home</title>
</head>
<body>

   
	<div>	
    <ul class="nav nav-pills">
		<li role="presentation" class="active"><a href="#">Home</a></li>
		<li role="presentation"><a href="#">Profile</a></li>
		<li role="presentation"><a href="#">Messages</a></li>
	    <li role="presentation" class="dropdown">
		    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
		      Dropdown <span class="caret"></span>
		    </a>
		    <ul class="dropdown-menu">
			    <li><a href="#">Action</a></li>
	            <li><a href="#">Another action</a></li>
	            <li><a href="#">Something else here</a></li>
	            <li><a href="#">Separated link</a></li>
	            <li><a href="#">One more separated link</a></li>
		    </ul>
	    </li>
	    
	    	<li role="presentation"><a href="/JavaWeb/html/admin"> Go AdminPage </a></li>
	    
	    <li role="presentation"><a href="/JavaWeb/html/login">logout</a></li>
	</ul>
</div>
	
	
</body>
</html>

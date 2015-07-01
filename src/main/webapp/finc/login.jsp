<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <link href="../themes/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
    <link href="css/login.css" rel="stylesheet"> 
    <script src="../plugins/jquery-2.1.4.js"></script>
    <script src="js/login.js"></script>
    <title>Login</title>	
  </head>
  
  <body>
   <div class="container">
    <div>${message}</div>
    <!--  
  	<form class="form" action="../j_spring_security_check" method="post">
  	--> 
  	<form class="form" action="../login_check" method="post"> 	
  	
	  <div class="form-login">
	    <label for="username">Username</label>
	    <input type="text" class="form-control" id="username" name='username' placeholder="Enter Username">
	  </div>
	  
	  <div class="form-login">
	    <label for="password">Password</label>
	    <input type="password" class="form-control" id="password" name='password' placeholder="Enter Password">
	  </div>	  
	  
	  <div class="form-login">		 
	  	<label for="code">Code</label> 
		<input type="text" class="form-control" id="verificationCode" name='verificationCode' placeholder="verificationCode" /> 
		<a href="#"> 
			<img src="" id="codefont" width="68" height="27" alt="" /> 
		</a> 		
	  </div>
	
	  <div class="remember">
	    <label>
	      <input type="checkbox"> Remember me
	    </label>
	  </div>
	  
	  <button id="signin" type="submit" class="btn btn-default">Sign in</button>
	  
	</form>
	</div>
  </body>
</html>

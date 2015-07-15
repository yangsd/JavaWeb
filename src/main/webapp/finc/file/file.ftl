<!DOCTYPE html> 
<html lang="zh-CN">
<head>
    <#include "./common/common.ftl"/>
	<script src="js/file.js"></script>	
	<title>file</title>
</head>
<body>
    <#assign active='file'/>
	<#include "./common/navbar-user.ftl"/>	
	
	<li id="a"><a href="/JavaWeb/finc/userListDownload">download</a></li>
	
    <div class="easyui-panel" title="Upload File" style="width:400px;padding:30px 70px 50px 70px">  
    
    	 <form id="uploadForm" method="post" enctype="multipart/form-data">     
        	File:
          	   <input id="file" class="easyui-filebox" name="file" data-options="prompt:'Choose a file...'" style="width:100%">
       	 	
        
        	
        		<input id="upload" type="button" class="btn btn-default" value="Upload"/>
        	
        </form>
    </div>  
	
	<form method="POST" enctype="multipart/form-data"
		action="/JavaWeb/finc/userUpload">
		File to upload: <input type="file" name="file"><br /> Name: <input
			type="text" name="name"><br /> <br /> <input type="submit"
			value="Upload"> Press here to upload the file!
	</form>
		
	<#include "./common/footer.ftl"/>
</body>
</html>

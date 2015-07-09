<!DOCTYPE html> 
<html lang="zh-CN">
<head>
    <#include "./common/common.ftl"/>
    <script src="user/js/user_detail.js"></script>
	<title>user_detail</title>
</head>
<body>
	<#assign active='user'/>
	<#include "./common/navbar-user.ftl"/>
	
	
	<button id="edit"  class="btn btn-default" onclick="edit(${pk_user})">Edit</button>
	<button id="delete"  class="btn btn-default" onclick="deleteUser(${pk_user})">Delete</button>
	
	<hr width="80%" size=5 />
	
	<div class="easyui-panel" title="User Detail" style="width:800px">
        
      
            <table cellpadding="10">
                <tr>
                    <td> <span class="label label-default">Login Id :</span></td>
                    <td><input type="text" value="${loginid}" readonly="true"></input></td>
                                                  
                    <td> <span class="label label-default">  Name    :</span></td>
                    <td><input type="text" value="${name}" readonly="true"></input></td>
               </tr>
               <tr>              	
                	<td> <span class="label label-default">  Access  :</span></td>
                	<td><input type="text" value="${access}" readonly="true"></input></td>   
                	
                	<td> <span class="label label-default">Creatime :</span></td>
                    <td><input type="text" value="${creatime}" readonly="true"></input></td>
                                     
                </tr>
                              
            </table>
       
        </div>
    </div>
	<#include "./common/footer.ftl"/>
</body>
</html>
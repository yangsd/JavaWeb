<!DOCTYPE html> 
<html lang="zh-CN">
<head>
    <#include "./common/common.ftl"/>
    <script src="user/js/user_edit.js"></script>
	<title>user_edit</title>
</head>
<body>
	<#assign active='user'/>
	<#include "./common/navbar-user.ftl"/>
		
	<div class="easyui-panel" title="User Edit" style="width:800px">
        
        <form id="ff"  method="post">
            <table cellpadding="10">
            <input  type="text" name="pk_user" value="${pk_user}" style="display:none;"></input>
                <tr>
                    <td>Login Id:</td>
                    <td><input  type="text" name="loginid" value="${loginid}"></input></td>
                                  
                    <td>Name:</td>
                    <td><input  type="text" name="name" value="${name}"></input></td>
                 </tr>
                <tr>
                	 <td>Access:</td>
                    <td>
                        <select name="access" value="${access}">
	                        <option value="2" <#if (((access)!'') == '2')>selected="selected"</#if> >common</option>
	                        <option value="1" <#if (((access)!'') == '1')>selected="selected"</#if> >admin</option>                     
                        </select>
                    </td>
                    
                  
               
                </tr>
                <tr>
                 
                	<td></td><td></td><td></td>
                	<td><input id="save" type="button" class="btn btn-default" value="save" onclick="save()"/></td>
                </tr>
                
                 <!--
                 <tr>
                	
                	<td><input class="easyui-textbox" type="text" name="loginid" data-options="required:true"></input></td>
                
                    <td>Message:</td>
                    <td><input class="easyui-textbox" name="remark" data-options="multiline:true" style="height:60px"></input></td>
                    
                 </tr>
                 -->
            </table>
        </form>
        </div>
    </div>
	<#include "./common/footer.ftl"/>
</body>
</html>
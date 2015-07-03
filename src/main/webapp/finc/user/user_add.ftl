<!DOCTYPE html> 
<html lang="zh-CN">
<head>
    <#include "./common/common.ftl"/>
	<title>user_add</title>
</head>
<body>
	<#assign active='user_add'/>
	<#include "./common/navbar-user.ftl"/>
		
	<div class="easyui-panel" title="User Add" style="width:800px">
        <!--
        <div style="padding:10px 60px 20px 60px">
        -->
        <form id="ff" method="post">
            <table cellpadding="10">
                <tr>
                    <td>Name:</td>
                    <td><input class="easyui-textbox" disable="disable" type="text" name="name" data-options="required:true"></input></td>
                
                    <td>Email:</td>
                    <td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td><input class="easyui-textbox" type="text" name="subject" data-options="required:true"></input></td>
                
                    <td>Message:</td>
                    <td><input class="easyui-textbox" name="message" data-options="multiline:true" style="height:60px"></input></td>
                </tr>
                <tr>
                    <td>Language:</td>
                    <td>
                        <select class="easyui-combobox" name="language">
                        <option value="ar">Arabic</option>
                        <option value="bg">Bulgarian</option>
                        <option value="ro">Romanian</option>
                        <option value="ru">Russian</option>
                        <option value="sk">Slovak</option>
                        <option value="sl">Slovenian</option>
                        <option value="es">Spanish</option>
                        </select>
                    </td>
                    <td></td>
                    <td><button type="button" class="btn btn-default">save</button></td>
                 </tr>
            </table>
        </form>
        </div>
    </div>
	<#include "./common/footer.ftl"/>
</body>
</html>
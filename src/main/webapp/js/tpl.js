seajs.use(['jquery','compile'],function($,Compile){
		
	var data = {
			title: '��������',
			isAdmin: true,
			list: ['ƻ��', '����', '����', '�㽶', '����']};
	
	var html = Compile.compile("test.tpl",data);

	$(function(){
		$("#content").append(html);
	});
//	document.getElementById('content').innerHTML = html;
	
//	$(function(){
//		
//		$("#content").append(html);
//	
//	});
	
	
});

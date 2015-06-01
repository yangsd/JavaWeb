seajs.use(['jquery','compile'],function($,Compile){
		
	var data = {
			title: '基本例子',
			isAdmin: true,
			list: ['苹果', '香梨', '橘子', '香蕉', '葡萄']};
	
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

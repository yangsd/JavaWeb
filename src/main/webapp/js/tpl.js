seajs.use(['jquery','compile'],function($,Compile){
	
	//var compile = new Compile();
	var data = {
			title: '��������',
			isAdmin: true,
			list: ['����', '����', '��Ӱ', '��Ӱ', '��ҥ', '����', '����']};
	
	var html = Compile.compile("JavaWeb/tool/tpl/test.tpl",data);
	$("#content").append(html);
	
	
});

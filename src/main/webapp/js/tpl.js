seajs.use(['jquery','compile'],function($,Compile){
	
	//var compile = new Compile();
	var data = {
			title: '基本例子',
			isAdmin: true,
			list: ['文艺', '博客', '摄影', '电影', '民谣', '旅行', '吉他']};
	
	var html = Compile.compile("JavaWeb/tool/tpl/test.tpl",data);
	$("#content").append(html);
	
	
});

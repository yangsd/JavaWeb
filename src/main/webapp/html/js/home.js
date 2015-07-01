seajs.use(['jquery','compile'],function($,Compile){
	
		var data = {isAdmin:true};
		
		var html = Compile.compile("nav.tpl",data);

		$(function(){
			$("#nav").append(html);
		});

});
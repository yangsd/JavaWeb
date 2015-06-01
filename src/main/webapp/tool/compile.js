define(function(require, exports, module) {

	function compile(tplFile,data){
		var template = require("template");
		
		tplSource = "";
		if(tplFile == "test.tpl"){
			tplSource=require("../tool/tpl/test.tpl");
		}
		alert(tplSource);
    	var render = template.compile(tplSource);
    	var html = render(data);
    	return html;
    };
    
    exports.compile = compile;
});
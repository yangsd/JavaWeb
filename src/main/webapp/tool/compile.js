define(function(require, exports, module) {
	
	
	
	function compile(tplPath,data){
		var $ = require('jquery');
		var template = require("template");
    	tplSource=require(tplPath);
    	alert(tplPath + ":"+tplSource);

    	var render = template.compile(tplSource);
    	var html = render(data);
    	return html;
    };
    
    exports.compile = compile;
});
/**
 * jsģ����빤��
 * author:sdyang
 * date  :2015-06-01
 */
define(function(require, exports, module) {

	function compile(tplFile,data){
		var template = require("template");
		
		tplSource = "";
		if(tplFile == "test.tpl"){
			tplSource=require("../tpl/test.tpl");
		}else if(tplFile == "nav.tpl"){
			tplSource=require("../tpl/nav.tpl");
		}
    	var render = template.compile(tplSource);
    	var html = render(data);
    	return html;
    };
    
    exports.compile = compile;
});
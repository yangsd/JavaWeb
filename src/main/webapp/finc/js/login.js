/**
 * 
 */

//初始化验证码
$(function(){
	setValidateCode();
});

//单击更换验证码
function changeImg(){
	setValidateCode();
};

function setValidateCode() {
	$('img#codefont').attr('src', 'randomnum?num=' + new Date().getTime());
}
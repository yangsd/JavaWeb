/**
 * 
 */
$(function(){
	setValidateCode();
});

function setValidateCode() {
	$('img#codefont').attr('src', 'randomnum?num=' + new Date().getTime());
}

$('img#codefont').bind('click', setValidateCode);

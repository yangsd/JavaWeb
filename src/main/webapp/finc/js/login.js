/**
 * 
 */

//��ʼ����֤��
$(function(){
	setValidateCode();
});

//����������֤��
function changeImg(){
	setValidateCode();
};

function setValidateCode() {
	$('img#codefont').attr('src', 'randomnum?num=' + new Date().getTime());
}
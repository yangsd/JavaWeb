$(function(){	
	$("#upload").click(function(){
		uploadExcel();
	});
});

function uploadExcel(){   
	 //�õ��ϴ��ļ���ȫ·��
		 var fileName= $('#file').filebox('getValue');		 
		 //���л���У��
		 if(fileName==""){
			 alert("please choose file to upload !");
		 }else{
			 //���ļ���ʽ����У��
			 var d1=/\.[^\.]+$/.exec(fileName); 
			 if(d1==".xls"){
				 $('#uploadForm').form('submit', {
						url : "/JavaWeb/finc/userUpload",
						onSubmit : function() {
							return true;
						},
						success : function(result) {
							alert(result);
						}
					});
					
		    }else{
		    	alert("please choose xls file!");
		    	$('#file').filebox('setValue',''); 
		    }
		 }  
	  }
	

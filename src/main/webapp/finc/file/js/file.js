$(function(){	
	$("#upload").click(function(){
		uploadExcel();
	});
});

function uploadExcel(){   
	 //得到上传文件的全路径
		 var fileName= $('#file').filebox('getValue');		 
		 //进行基本校验
		 if(fileName==""){
			 alert("please choose file to upload !");
		 }else{
			 //对文件格式进行校验
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
	

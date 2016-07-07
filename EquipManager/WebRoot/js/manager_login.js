function login(){
	
	/*var password=document.getElementById("password");
	if(passowrd.value.length<1){
		alert("密码为空");
		return;
	}
	*/
	var form;
	var select=document.getElementById("type");
	var type=select.value;
	if(type==0){
		form=document.getElementById("store");
	}
	if(type==1){
		form=document.getElementById("running");
	}
	if(type==2){
		form=document.getElementById("finance");
	}

	alert("登录成功");
	form.submit();
}
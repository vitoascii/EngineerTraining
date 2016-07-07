function isEmpty(s){
	return s.length<1;
}

function isReadyToLogin(){
	var form=document.getElementById("customer");
	var id=form.elements["id"];
	var pword=form.elements["password"];
	if(isEmpty(id.value)||isEmpty(pword.value)){
		alert("填写完整账号密码!");
	}else{
	form.submit();
	}
}
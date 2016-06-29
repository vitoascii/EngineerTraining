function isEmpty(s){
	return s.length<1;
}

function isReadyToLogin(){
	var form=document.getElementById("customer");
	var name=form.elements["name"];
	var pword=form.elements["password"];
	if(isEmpty(name.value)||isEmpty(pword.value)){
		alert("账号或密码未填写");
		return;
	}
	form.submit();
}
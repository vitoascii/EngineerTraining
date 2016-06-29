

function isPhoneCorrect(number){
	var pattern1=/^\d{3}-\d{8}|\d{4}-\d{7}$/;
	var pattern2=/^(13)(\d{9})$/;
	return (pattern1.test(number))||(pattern2.test(number));
}
function isHomePhoneCorrect(number){
	var pattern=/^\d{3}-\d{8}|\d{4}-\d{7}$/;
	return pattern.test(number);
}
function isPostNumCorrect(number){
	var pattern=/^\d{6}$/;
	return pattern.test(number);
}
function isEmailCorrect(email){
	var pattern=/^([A-Za-z0-9]+)@([a-z0-9]{1,5})\.([a-z]{1,5})$/
	return pattern.test(email);
}
function isStrigTooShort(s){
	return s.length<2;

}
function isIdCardCorrect(number){
	var pattern=/^\d{15}|\d{18}|\d{17}[xX]$/;
	return pattern.test(number);
}

function login(){
	
	var form=document.getElementById("customer");
	var name=form.elements["name"];
	var type=form.elements["type"];
	var phone=form.elements["phone"];
	var address=form.elements["address"];
	var postnum=form.elements["postnum"];
	var email=form.elements["email"];
	var idcard=form.elements["idcard"];
	var pword=form.elements["password"];

	

	if(!isPhoneCorrect(phone.value)){
		alert("联系电话输入错误");
		return;
	}
	
	alert("注册成功！");
	form.submit();
	return;

	if(isStrigTooShort(pword.value)){
		alert("密码过短");
		return;	
	}


	if(isStrigTooShort(name.value)){
		alert("姓名过短");
		return;	
	}

	if(!isPostNumCorrect(postnum.value)){
		alert("邮编输入错误");
		return;		
	}
	if(!isEmailCorrect(email.value)){
		alert("email输入错误");
		return;		
	}
	if(isStrigTooShort(address.value)){
		alert("地址长度过短");
		return;
	}
	
	if(!isIdCardCorrect(idcard.value)){
		alert("身份证号输入错误");
		return;
	}


	if(type.value==0){
		var homephone=form.elements["homephone"];
		if(!isHomePhoneCorrect(homephone.value)){
			alert("座机输入错误");
			return;
		}
		
	}
	if(type.value==1){
		var company=form.elements["company"];
		if(isStrigTooShort(company.value)){
			alert("单位名字过短");
			return;
		}

	}
	if(type.value==2){
		var linkman=form.elements["linkman"];
		if(isStrigTooShort(linkman.value)){
			alert("联系人姓名过短");
			return;
		}
	}
 } 
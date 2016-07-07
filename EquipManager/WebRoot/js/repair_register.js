







function register(){
	alert("it not ok");
	var form=document.getElementById("repair");
	var phe=form.elements["phenomenon"];
	String phe2=phe.value;
	if(phe2.size()<1){
		alert("请填写故障现象")
	}else{
		alert("it ok")
		//form.submit();
	}
	
}
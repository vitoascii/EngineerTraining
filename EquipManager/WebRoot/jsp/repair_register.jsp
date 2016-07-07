<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.*"%>
<%@page import="pd.Customer"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="customer" scope="request" type="pd.Customer" />

<html>
<head>
	<meta charset="utf-8">
	<title>报修登记</title>
<script type="text/javascript">
	function register(){
	var form=document.getElementById("repair");
	var phe=form.elements["phenomenon"];
	var phe2=phe.value;
	if(phe2.length<1){
		alert("请填写故障现象");
	}else{
		form.submit();
	} 
	}
</script>
</head>
<body>
	<div align="center">
		<h2>报修登记</h2>
	</div>
	<hr />
	<div align="center">
	<h4>标 * 选项必填！</h4>
	<form id="repair" action="RepairRegisterServlet" method="post">
	<table>
	<tr>
	<td>用户编号</td>
	<td><%= customer.getId() %></td>
	<input type="hidden" name="id" value=<%= customer.getId() %>>
	<input type="hidden" name="password" value=<%= customer.getPassword() %>>
	</tr>
		<tr>
		<td colspan="1">产品类型：</td>
		<td colspan="3">
		<select name="type">
  		<option value="0">台式机</option>
  		<option value="1">笔记本</option>
  		<option value="2">投影仪</option>
  		<option value="3">打印机</option>
  		<option value="4">其他</option>
  		</select></td>
		<td colspan="1">*</td>
		</tr>
		<tr>
		<td colspan="1">机器品牌：</td>
		<td colspan="3"><input type="text" name="brand"></td>
		</tr>
		<tr>
		<td colspan="1">机器型号：</td>
		<td colspan="3"><input type="text" name="version"></td>
		</tr>
		<tr>
		<td colspan="1">系列号：</td>
		<td colspan="3"><input type="text" name="serial"></td>
		</tr>
		<tr>
		<td colspan="1">故障现象：</td>
		<td colspan="3"><input type="text" name="phenomenon"></td>
		<td colspan="1">*</td>
		</tr>
		<tr>
		<td colspan="1">故障类型：</td>
		<td colspan="3">
			<select name="bug">
			<option value="0">固定性故障</option>
			<option value="1">间隙性故障</option>
			</select>
		</td>
		<td colspan="1">*</td>
		</tr>
		<tr>
		<td colspan="1">机器外观检查：</td>
		<td colspan="3"><input type="text" name="appearance"></td>
		</tr>
		<tr>
		<td colspan="1">重要资料：</td>
		<td colspan="3"><input type="text" name="important_msg"></td>
		</tr>
		<tr>
		<td colspan="1">开机口令：</td>
		<td colspan="3"><input type="text" name="command"></td>
		</tr>
		<tr>
		<td colspan="1">HDD：</td>
		<td colspan="3"><input type="text" name="hdd"></td>
		</tr>
		<tr>
		<td colspan="1">内存：</td>
		<td colspan="3"><input type="text" name="memory"></td>
		</tr>
		<tr>
		<td colspan="1">外置PC卡：</td>
		<td colspan="3"><input type="text" name="pccard"></td>
		</tr>
		<tr>
		<td colspan="1">AC适配器：</td>
		<td colspan="3"><input type="text" name="adapter"></td>
		</tr>
		<tr>
		<td colspan="1">电池：</td>
		<td colspan="3"><input type="text" name="battery"></td>
		</tr>
		<tr>
		<td colspan="1">外接光驱：</td>
		<td colspan="3"><input type="text" name="cd"></td>
		</tr>
		<tr>
		<td colspan="1">外接软驱：</td>
		<td colspan="3"><input type="text" name="floppy"></td>
		</tr>	
		<tr>
		<td colspan="1">其他</td>
		<td colspan="3"><input type="text" name="other"></td>
		</tr>
		<tr>
		<td colspan="5" align="center">
		<button onclick="register()">提交</button>
		</td>
		</tr>
		</table>
		</form>
		</div>
		<div align="center">
		<form action="login_customer.jsp" method="post">
		<input type="hidden" name="id" value=<%= customer.getId() %>>
		<input type="hidden" name="password" value=<%= customer.getPassword() %>>
		<input type="submit" value="取消">
		</form>
		</div>
		
</body>
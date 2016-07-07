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
	<title><%=customer.getName()+"的主页"%>></title>
	<meta charset="utf-8">
</head>
<body>

	<div align="center">
	<table>
		<tr>
		<td width="20" align="center">
			<form method="get" action="/EquipManager/servlet/CustomerInfoUpdatePreServlet">
			<input type="hidden"  name="id" value=<%=customer.getId()%>>
			<input type="submit" value="修改信息">
			</form>
		</td>
		<td width="20" align="center">
			<form method="get" action="/EquipManager/servlet/RepairRegisterPreServlet">
			<input type="hidden" name="id" value=<%=customer.getId()%>>
			<input type="submit" value="报修">
			</form>
		</td>
		</tr>
		</table>
	</div>
	<hr />
	<div align="center">
	<h2><%=customer.getName()+" 个人信息"%></h2>
	<table>
	<tr>
	<td colspan="1">姓名：</td>
	<td colspan="4"><%=customer.getName()%></td>
	</tr>
	<tr>
	<td colspan="1">账号</td>
	<td colspan="4"><%=customer.getId()%></td>
	</tr>
	<tr>
	<td colspan="1">联系电话：</td>
	<td colspan="4"><%=customer.getPhone()%></td>
	</tr>
	<tr>
	<td colspan="1">密码：</td>
	<td colspan="4">
	<button onclick="showPassword()">点击查看</button>
	<input type="hidden" id="psd" value=<%=customer.getPassword()%>></td>
	</tr>
	<tr>
	<td colspan="1">账号类型：</td>
	<td colspan="4"><%=customer.getTypeName()%></td>
	</tr>
	<tr>
	<td colspan="1">联系地址：</td>
	<td colspan="4"><%=customer.getAddress()%></td>
	</tr>
	<tr>
	<td colspan="1"><%=customer.getExtraInfoName()%></td>
	<td colspan="4"><%=customer.getExtraInfoValue()%></td>
	</tr>
	<tr>
	<td colspan="1">身份证号：</td>
	<td colspan="4"><%=customer.getIdcard()%></td>
	</tr>
	<tr>
	<td colspan="1">邮编：</td>
	<td colspan="4"><%=customer.getPostNum()%></td>
	</tr>
	<tr>
	<td colspan="1">email:</td>
	<td colspan="4"><%=customer.getEmail()%></td>
	</tr>
	</table>
	</div>
	<script type="text/javascript">
	var pswd=document.getElementById("psd");
	function showPassword(){
		alert(pswd.value);
	}
	</script>
</body>
</html>
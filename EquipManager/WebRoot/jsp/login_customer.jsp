<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
	<title>用户登陆</title>
	<meta charset="utf-8">
</head>
<body>
<script type="text/javascript" src="../js/login_customer.js"></script>

<div align="center">
<h2>用户登陆</h2>
<hr />
</div>

<div align="center">
<form id="customer" method="post" action="/EquipManager/servlet/CustomerLoginServlet" >
<table>
	<tr>
	<td>编号：</td>
	<td colspan="3"><input name="id" type="text"></td>
	</tr>
	<tr>
	<td>密码：</td>
	<td colspan="3"><input name="password" type="password"></td>
	</tr>
	<tr>
	<td colspan="4" align="center">
	<button onclick="isReadyToLogin()">登录</button>
	</td>
	</tr>
</table>
</form>
<br />
<form method="post" action="/EquipManager/servlet/CustomerLogupPreServlet" >
<input type="submit" value="注册">
</form>

</div>
</body>
</html>
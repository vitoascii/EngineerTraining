

<html>
<head>
	<title>xxx 的主页</title>
</head>
<body>
<script type="text/javascript">
	function showPassword(){
		alert("password");
	}
</script>
	<div align="center">
		<tr>
		<td width="20" align="center">
			<form method="get" action="customer_info_update.jsp">
			<input type="hint" value=1>
			<input type="submit" name="修改信息">
		</td>
		<td width="20" align="center">
			<form method="get" action="repair_register.jsp">
			<input type="hint" value=1>
			<input type="submit" name="报修">
		</td>
	</div>
	<hr />
	<div align="center">
	<h2> xxx 个人信息</h2>
	<table>
	<tr>
	<td colspan="1">姓名：</td>
	<td colspan="4">测试姓名</td>
	</tr>
	<tr>
	<td colspan="1">账号</td>
	<td colspan="4">12345</td>
	</tr>
	<tr>
	<td colspan="1">联系电话：</td>
	<td colspan="4">13345678901</td>
	</tr>
	<tr>
	<td colspan="1">密码：</td>
	<td colspan="4"><button onclick="showPassword()">点击查看</button></button></td>
	</tr>
	<tr>
	<td colspan="1">账号类型：</td>
	<td colspan="4">家庭用户</td>
	</tr>
	<tr>
	<td colspan="1">联系地址：</td>
	<td colspan="4">测试地址</td>
	</tr>
	<tr>
	<td colspan="1">座机：</td>
	<td colspan="4">0322-2424242</td>
	</tr>
	<tr>
	<td colspan="1">身份证号：</td>
	<td colspan="4">123456123456123456</td>
	</tr>
	<tr>
	<td colspan="1">邮编：</td>
	<td colspan="4">123456</td>
	</tr>
	<tr>
	<td colspan="1">email:</td>
	<td colspan="4">123456@123.com</td>
	</tr>
	</table>
	</div>
</body>
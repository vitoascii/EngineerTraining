<%@page import="com.sun.org.apache.bcel.internal.generic.*"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<title>仓库管理</title>
	    <link rel="stylesheet" >
	<meta charset="utf-8">
</head>
<body>
<div align="ceneter">
<h2>仓库管理</h2>
<hr />
</div>
<% int[][] num=(int[][])request.getAttribute("num"); %>
<div align="center">
<h3>当前库存</h3>
<table rules="all" border="1">
<tr>
<td>类型|型号|数量</td>
<td>0号</td>
<td>1号</td>
<td>2号</td>
<td>3号</td>
<td>4号</td>
</tr>
<tr>
<td>HDD</td>
<td><%=num[0][0] %></td>
<td><%=num[0][1] %></td>
<td><%=num[0][2] %></td>
<td><%=num[0][3] %></td>
<td><%=num[0][4] %></td>
</tr>
<tr>
<td>内存</td>
<td><%=num[1][0] %></td>
<td><%=num[1][1] %></td>
<td><%=num[1][2] %></td>
<td><%=num[1][3] %></td>
<td><%=num[1][4] %></td>
</tr>
<tr>
<td>外置PC卡</td>
<td><%=num[2][0] %></td>
<td><%=num[2][1] %></td>
<td><%=num[2][2] %></td>
<td><%=num[2][3] %></td>
<td><%=num[2][4] %></td>
</tr>
<tr>
<td>AC适配器</td>
<td><%=num[3][0] %></td>
<td><%=num[3][1] %></td>
<td><%=num[3][1] %></td>
<td><%=num[3][1] %></td>
<td><%=num[3][1] %></td>
</tr>
<tr>
<td>电池</td>
<td><%=num[4][0] %></td>
<td><%=num[4][1] %></td>
<td><%=num[4][2] %></td>
<td><%=num[4][3] %></td>
<td><%=num[4][4] %></td>
</tr>
<tr>
<td>外界光驱</td>
<td><%=num[5][0] %></td>
<td><%=num[5][1] %></td>
<td><%=num[5][2] %></td>
<td><%=num[5][3] %></td>
<td><%=num[5][4] %></td>
</tr>
<tr>
<td>外界软驱</td>
<td><%=num[6][0] %></td>
<td><%=num[6][1] %></td>
<td><%=num[6][2] %></td>
<td><%=num[6][3] %></td>
<td><%=num[6][4] %></td>
</tr>
</table>
</div>
<hr />
<div align="center">
	<h3>入库</h3>
	<form action="/EquipManager/servlet/StorageServlet" method="post" id="store">
	<table>
	<tr>
	<td>
	<select name="element">
	<option value="0">HDD</option>
	<option value="1">内存</option>
	<option value="2">外置PC卡</option>
	<option value="3">AC适配器</option>
	<option value="4">电池</option>
	<option value="5">外界光驱</option>
	<option value="6">外界软驱</option>
	</select>
	</td>
	<td>
	<h4>型号：</h4>
	</td>
	<td>
	<input size="5" type="number" name="type">
	</td>
	<td>
	<h4>数量：</h4>
	</td>
	<td>
	<input size="5" type="number" name="number">
	</td>
	</tr>
	<tr>
	<td>
	<input type="submit" value="入库">
	</td>
	</tr>
	</table>
	</form>
</div>
</body>
</html>
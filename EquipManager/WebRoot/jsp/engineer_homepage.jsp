<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.*"%>
<%@page import="pd.Engineer"%>
<%@page import="pd.CustomerRepairRecord"%>
<%@page import="value.RepairValue"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="engineer" scope="request" type="pd.Engineer" />
<jsp:useBean id="task" scope="request" type="pd.CustomerRepairRecord" />
<html>
<head>
	<title><%= engineer.getId()+"号工程师主页" %></title>
	<meta charset="utf-8">
</head>
<body>

	<div align="center">
	<h2><%= engineer.getId()+"号工程师" %></h2>
	</div>
	<hr />
	<%	if(engineer.getCond()==0){%>
	<div>
	<h4>正在进行的维修工作:xx号维修单 x号顾客 xxx xx机器</h4>
	</div>
	<%	}else{%>
	<div align="center">
	<h4><%="正在进行的维修工作:"+task.getId()+"号维修单 "+task.getCustomerId()+"号顾客" %></h4>
	<table rules="all" border="1">
		<tr>
		<td>接修日期</td>
		<td><%= task.getDate() %></td>
		<td>维修编号</td>
		<td><%= task.getId() %></td>
		</tr>
		<tr>
		<td>产品类型</td>
		<td><%= RepairValue.Types[task.getType()] %></td>
		<td>机器品牌</td>
		<td><%= task.getBrand() %></td>
		</tr>
		<tr>
		<td>机器型号</td>
		<td><%= task.getVersion() %></td>
		<td>系列号</td>
		<td><%= task.getSerial() %></td>
		</tr>
		<tr>
		<td colspan="2" align="center">机器故障现象</td>
		<td colspan="2" align="center">故障类型</td>
		</tr>
		<tr>
		<td colspan="2" align="center"><%= task.getPhenomenon() %></td>
		<td colspan="2" align="center"><%= RepairValue.BugTypes[task.getType()] %></td>
		</tr>
		<tr>
		<td colspan="4">随机附件</td>
		</tr>
		<tr>
		<td colspan="4"><%= task.getExtraInfo() %></td>
		</tr>
		</table>
	</div>
	<br />
	<div align="center">
	<h3>需要零件：</h3>
	<form id="element" method="post" action="/EquipManager/servlet/RepairServlet">
	<table>
	<input type="hidden" name="id" value=<%= engineer.getId() %>>
	<input type="hidden" name="password" value=<%= engineer.getPassword() %>>
	<tr>
	<td>零件类型</td>
	<td align="center">型号</td>
	<td align="center">数量</td>
	</tr>
	<tr>
	<td>HDD</td>
	<td><input type="text " name="type0"></td>
	<td><input type="text " name="num0"></td>
	</tr>
	<tr>
	<td>内存</td>
	<td><input type="text " name="type1"></td>
	<td><input type="text " name="num1"></td>
	</tr>
	<tr>
	<td>外置PC卡</td>
	<td><input type="text " name="type2"></td>
	<td><input type="text " name="num2"></td>
	</tr>
	<tr>
	<td>AC适配器</td>
	<td><input type="text " name="type3"></td>
	<td><input type="text " name="num3"></td>
	</tr>
	<td>电池</td>
	<td><input type="text " name="type4"></td>
	<td><input type="text " name="num4"></td>
	</tr>
	<tr>
	<td>外界光驱</td>
	<td><input type="text " name="type5"></td>
	<td><input type="text " name="num5"></td>
	</tr>
	<tr>
	<td>外界软驱</td>
	<td><input type="text " name="type6"></td>
	<td><input type="text " name="num6"></td>
	</tr>
	<tr>
	<td colspan="4" align="center">
	<input type="submit" value="维修">
	</td>
	</tr>
	</table>
	<% } %>
</form>
</body>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.*"%>
<%@page import="pd.Customer"%>
<%@page import="pd.CustomerRepairRecord"%>
<%@page import="value.RepairValue"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="customer" scope="request" type="pd.Customer" />
<jsp:useBean id="record" scope="request" type="pd.CustomerRepairRecord" />
<html>
<head>
<meta charset="utf-8">
	<title>用户确认单</title>
</head>

<body>
<script type="text/javascript">
	function print(){
		alert("successful print!")
		var form=document.getElementById("info");
		form.submit();
	}
</script>
	<div align="center">
	<form id ="info" action="/EquipManager/servlet/CustomerLoginServlet" method="get">
	<input type="hidden" name="id" value=<%= customer.getId() %>>
	<input type="hidden" name="password" value=<%= customer.getPassword() %>>
		<table rules="all" border="1">
		<tr>
		<td colspan="4" align="center">***沈阳市计算机服务有限公司区及凭证***</td>
		</tr>
		<tr>
		<td>接修日期</td>
		<td><%= record.getDate() %></td>
		<td>维修编号</td>
		<td><%= record.getId() %></td>
		</tr>
		<tr>
		<td>产品类型</td>
		<td><%= RepairValue.Types[record.getType()] %></td>
		<td>机器品牌</td>
		<td><%= record.getBrand() %></td>
		</tr>
		<tr>
		<td>机器型号</td>
		<td><%= record.getVersion() %></td>
		<td>系列号</td>
		<td><%= record.getSerial() %></td>
		</tr>
		<td colspan="4" align="center">机器故障现象</td>
		</tr>
		<tr>
		<td colspan="4" align="center"><%= record.getPhenomenon() %></td>
		</tr>
		<tr>
		<td colspan="4" align="center">随机附件</td>
		</tr>
		<tr>
		<td colspan="4"><%= record.getExtraInfo() %></td>
		</tr>
		<tr>
		<td colspan="4" align="left">接机签字：________ 机主签字：_______ 打印时间：________</td>
		</tr>
		</table>
	<button onclick="print()">打印</button>
	</form>
	</div>
</body>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.*"%>
<%@page import="pd.Bill"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="info" scope="request" type="java.util.ArrayList" />

<html>
<head>
	<title>财务管理</title>
	<meta charset="utf-8">
</head>
<body>

<div align="center">
	<h2>结算清单</h2>
</div>
<hr />
<%! Bill b=null; %>
<%  for(int i=0;i<info.size();i++){ %>
<%  b=info.get(i); %>
<div align="center">
<table rules="all" border="1">
<tr>
		<td colspan="4" align="center">***沈阳市计算机服务有限公司区及凭证***</td>
		</tr>
		<tr>
		<td>维修编号</td>
		<td><%= b.id%></td>
		<td>用户编号</td>
		<td><%= b.customerId %></td>
		</tr>
		<tr>
		<td>材料费</td>
		<td><%= b.element %></td>
		<td>修理费</td>
		<td><%= b.manual %></td>
		</tr>
		<tr>
		<td>合计</td>
		<td><%= b.element+b.manual %></td>
		<td>日期</td>
		<td><%= b.date %></td>
		<tr>
		<td colspan="4" align="left">接机签字：________ 机主签字：_______ 打印时间：________</td>
		</tr>
		</table>
		<% } %>



</div>



</body>
</html>
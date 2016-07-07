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
<script type="text/javascript" src="../js/update_customer.js"></script> 
<title>用户信息</title>
</head>
<body>

<div align="center">
  <h1>修改信息</h>
  <hr />
</div>

<div align="center">
  <form id="customer" method="post" action="/EquipManager/servlet/CustomerInfoUpdateServlet" >
  <table>
  <tr>
    <input type="hidden" name="id" value=<%= customer.getId() %>>
    <input type="hidden" name="type" value=<%= customer.getType() %>>
  	<input type="hidden" name="password" value=<%= customer.getPassword() %>>
  </tr>

  <tr>
  <td align="right">姓名：</td>
  <td colspan="3"><input type="text" name="name"></td>
  </tr>

  <tr>
  <td align="right">设置密码：</td>
  <td colspan="3"><input type="text" name="password2"></td>
  </tr>

  <tr>
  <td align="left">客户性质：</td>
  <td><%= customer.getTypeName() %></td>
  </tr>

  <tr>
  <td align="right">联系电话：</td>
  <td colspan="3"><input type="text" name="phone"></td>
  </tr>

  <tr>
  <td align="right">联系地址：</td>
  <td colspan="3"><input type="text" name="address"></td>
  </tr>

  <tr>
  <td align="right">邮编：</td>
  <td colspan="3"><input type="text" name="postnum"></td>
  </tr>

  <tr>
  <td align="right">email：</td>
  <td colspan="3"><input type="text" name="email"></td>
  </tr>

  <tr>
  <td align="right">身份证号：</td>
  <td colspan="3"><input type="text" name="idcard"></td>
  </tr>

  <tr>
  <td align="right"><%= customer.getExtraInfoName() %></td>
  <td colspan="3"><input type="text" name="extrainfo"></td>
  </tr>
  
  <tr>
  <td colspan="4" align="center">
  <button onclick="submit()">确定</button>
  </td>  
  </tr>
  </table>
  </form>
</div>
<div align="center">
  <form action="/EquipManager/servlet/CustomerLoginServlet">
  	<input type="submit" value="取消">
  	<input type="hidden" name="id" value=<%= customer.getId() %>>
  	<input type="hidden" name="password" value=<%= customer.getPassword() %>>
  </form>
</div> 

</body>
</html>
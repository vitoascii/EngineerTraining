<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.*"%>
<%@page import="value.CustomerType.Type"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<jsp:useBean id="alt" scope="request" type="java.util.ArrayList" />
<jsp:useBean id="failed" scope="request" type="java.lang.String"/>


<html>
<head>
<script type="text/javascript" src="../js/logup_customer.js"></script> 
<title>用户注册</title>
<meta charset="utf-8">
</head>
<body>

<div align="center">
  <h1>用户注册</h>
  <input type="hidden" id="isfailed" value=<%= failed %>>
  <hr />
</div>

<div align="center">
  <form id="customer" method="post" action="/EquipManager/servlet/CustomerLogupServlet" >
  <table>

  <tr>
  <td align="right">姓名：</td>
  <td colspan="3"><input type="text" name="name"></td>
  </tr>

  <tr>
  <td align="right">设置密码：</td>
  <td colspan="3"><input type="password" name="password"></td>
  </tr>

  <tr>
  <td align="left">客户性质：</td>
  <td colspan="1">
  <select name="type">  
   <%! Type p1 = null; %>
	  <%	for(int i=0;i<alt.size();i++){%>
	  <% 	  p1 = (Type)alt.get(i); %>	
	  <option value=<%= p1.id %>><%= p1.typeName%></option>
	  <%	} %>
  </select>
  </td>
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


  <%! Type p2 = null; %>
  <%	for(int i=0;i<alt.size();i++){%>
  <% 	  p2 = (Type)alt.get(i); %>	
  <tr>
  <td align="right"><%=p2.typeInfoName %></td>
  <td colspan="3"><input type="text" name=<%="extraInfo"+(i+1) %>></td>
  <td align="left" colspan="2"><%="("+p2.typeName+"需填)"%></td>
  </tr>
  <% } %>
  <tr>
  <td align="right" colspan="4">
  	<input type="button" value="注册" onclick="logup()">
  	</td>
  </tr>

  </table>
  </form>
</div>
<script type="text/javascript" >
	var fail=document.getElementById("isfailed");
	if(fail.value=="0"){
		alert("身份证已被注册");
	}
</script> 

</body>
</html>
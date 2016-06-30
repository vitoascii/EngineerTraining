

<html>
<head>
<script type="text/javascript" src="../js/logup_customer.js"></script> 
<script type="text/javascript">
	function onSubmitClick(){
		login();
	}
</script>

<title>用户注册</title>
</head>
<body>

<div align="center">
  <h1>用户注册</h>
  <hr />
</div>

<div align="center">
  <form id="customer" method="post" action="../../test.html" >
  <table>

  <tr>
  <td align="right">姓名：</td>
  <td colspan="3"><input type="text" name="name"></td>
  </tr>

  <tr>
  <td align="right">设置密码：</td>
  <td colspan="3"><input type="text" name="password"></td>
  </tr>

  <tr>
  <td align="left">客户性质：</td>
  <td colspan="1">
  <select name="type">
  <option value="0">家庭用户</option>
  <option value="1">单位用户</option>
  <option value="2">代理商</option>
  <option value="3">签约用户</option>
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

  <tr>
  <td align="right">座机：</td>
  <td colspan="3"><input type="text" name="homephone"></td>
  <td align="left" colspan="2">(家庭用户需填)</td>
  </tr>

  <tr>
  <td align="right" colspan="4">
  	<input type="button" value="确定" onclick="onSubmitClick()">
  	</td>
  <td align="right" colspan="4">
    <input type="button" value="取消" onclick="onSubmitClick()">
    </td>

  </tr>

  </table>
  </form>
</div>

</body>
</html>
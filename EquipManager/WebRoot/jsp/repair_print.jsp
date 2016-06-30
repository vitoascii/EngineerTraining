

<html>
<head>
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
	<form id ="info" action="customer_homepage.jsp" method="get">
		<table>
		<tr>
		<td colspan="4" align="center">***沈阳市计算机服务有限公司区及凭证***</td>
		</tr>
		<tr>
		<td>接修日期</td>
		<td>2004-7-17</td>
		<td>维修编号</td>
		<td>001</td>
		</tr>
		<tr>
		<td>产品类型</td>
		<td>台式机</td>
		<td>机器品牌</td>
		<td>dell</td>
		</tr>
		<tr>
		<td>机器型号</td>
		<td>001-001</td>
		<td>系列号</td>
		<td>1234567</td>
		</tr>
		<tr>
		<td>单位名称</td>
		<td>xx公司</td>
		<td>联系人</td>
		<td>xx</td>
		</tr>
		<tr>
		<td colspan="4" align="center">机器故障现象</td>
		</tr>
		<tr>
		<td colspan="4" align="center">xx故障</td>
		</tr>
		<tr>
		<td colspan="2">缺少零件</td>
		<td colspan="2">随机附件</td>
		</tr>
		<tr>
		<td>xx零件</td>
		<td>xx附件</td>
		</tr>
		<tr>
		<td colspan="4" align="left">接机签字：        机主签字：       打印时间：</td>
		</tr>
		</table>
	<button onclick="print()">打印</button>
	</form>
	</div>
</body>
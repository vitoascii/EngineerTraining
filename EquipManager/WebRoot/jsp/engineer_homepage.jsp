

<html>
<head>
	<title>xx号工程师</title>
</head>
<body>
<script type="text/javascript">
	function submit(){
		alert("零件提取成功，修理完成");
		var form=document.getElementById("element");
		form.submit();
	}
</script>
	<div align="center">
	<h2>xx号工程师</h2>
	<hr />
	<h4>正在进行的维修工作:xx号维修单 x号顾客 xxx xx机器</h4>
	</div>
	<div align="center">
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
	</div>
	<div align="center">
	<h3>需要零件：</h3>
	<form id="element" method="post" action="login_engineer.html">
	<table>
	<tr>
	<td>零件类型</td>
	<td>型号</td>
	<td>数量</td>
	</tr>
	<tr>
	<td>HDD</td>
	<td><input type="numeber" name="hdd_type"></td>
	<td><input type="number" name="hdd_amount"></td>
	</tr>
	<tr>
	<td>内存</td>
	<td><input type="numeber" name="memory_type"></td>
	<td><input type="number" name="memory_amount"></td>
	</tr>
	<tr>
	<td>外置PC卡</td>
	<td><input type="numeber" name="pccard_type"></td>
	<td><input type="number" name="pccard_amount"></td>
	</tr>
	<tr>
	<td>AC适配器</td>
	<td><input type="numeber" name="ac_type"></td>
	<td><input type="number" name="ac_amount"></td>
	</tr>
	<td>电池</td>
	<td><input type="numeber" name="battery_type"></td>
	<td><input type="number" name="battery_amount"></td>
	</tr>
	<tr>
	<td>外界光驱/td>
	<td><input type="numeber" name="cd_type"></td>
	<td><input type="number" name="cd_amount"></td>
	</tr>
	<tr>
	<td>外界软驱</td>
	<td><input type="numeber" name="fl_type"></td>
	<td><input type="number" name="fl_amount"></td>
	</tr>
	<button onclick="submit()">提交</button>



	</table>

</form>



</body>
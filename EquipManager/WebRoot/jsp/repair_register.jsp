
<html>
<head>
	<title>报修登记</title>
</head>
<body>
<script type="text/javascript">
	function submit(){
		alert("提交成功")；
		var form=document.getElementById("repair_info");
		form.submit();
	}
</script>
	<div align="center">
		<h2>报修登记</h2>
	</div>
	<hr />
	<div align="cnter">
	<h4>标 * 选项必填！</h4>
	<form id="repair_info" action="repair_print.jsp" method="post">
	<table>
		<tr>
		<td colspan="1">报修时间：</td>
		<td colspan="3"><input type="text" name="date"></td>
		</tr>
		<tr>
		<td colspan="1">预估价格：</td>
		<td colspan="3"><input type="number" name="price"></td>
		</tr>
		<tr>
		<td colspan="1">预计完成时间：</td>
		<td colspan="3"><input type="text" name="end_date"></td>
		</tr>
		<tr>
		<td colspan="1">产品类型：</td>
		<td colspan="3">
		<select name="mch_type">
  		<option value="0">台式机</option>
  		<option value="1">笔记本</option>
  		<option value="2">投影仪</option>
  		<option value="3">打印机</option>
  		<option value="4">其他</option>
  		</select></td>
		<td colspan="1">*</td>
		</tr>
		<tr>
		<td colspan="1">机器品牌：</td>
		<td colspan="3"><input type="text" name="mch_brand"></td>
		</tr>
		<tr>
		<td colspan="1">机器型号：</td>
		<td colspan="3"><input type="text" name="mch_version"></td>
		</tr>
		<tr>
		<td colspan="1">缺少零件：</td>
		<td colspan="3"><input type="text" name="mch_element"></td>
		</tr>
		<tr>
		<td colspan="1">故障现象：</td>
		<td colspan="3"><input type="text" name="phenomenon"></td>
		<td colspan="1">*</td>
		</tr>
		<tr>
		<td colspan="1">故障类型：</td>
		<td colspan="3">
			<select name="bug_type">
			<option value="0">固定性故障</option>
			<option value="1">间隙性故障</option>
			</select>
		</td>
		<td colspan="1">*</td>
		</tr>
		<tr>
		<td colspan="1">机器外观检查：</td>
		<td colspan="3"><input type="text" name="mch_appearance"></td>
		</tr>
		<tr>
		<td colspan="1">重要资料：</td>
		<td colspan="3"><input type="text" name="important_msg"></td>
		</tr>
		<tr>
		<td colspan="1">开机口令：</td>
		<td colspan="3"><input type="text" name="open_commmand"></td>
		</tr>
		<tr>
		<td colspan="1">其他：</td>
		<td colspan="3"><input type="text" name="other"></td>
		</tr>
		<tr>
		<td colspan="2">
		<button onclick="submit()">提交</button>
		</td>
		<td colspan="2">
		<form action="customer_homepage.jsp" method="get">
		<input type="hint" name="id" value="1">
		<input type="submit" value="取消">
		</form>
		</td>
		</tr>
		</table>
		</form>
		</div>
</body>
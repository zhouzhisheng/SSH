<%@page import="com.baidu.struts.entity.BasDict"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function cancel() {
		location.href = "../basdict.do?flag=findAllBasDicts";
	}
</script>
</head>
<body>
	<form action="../basdict.do?flag=Add" method="post">
		<table class="tableEdit">
			<thead>
				<tr>
					<td colspan="4">新建数据字典条目</td>
				</tr>
			</thead>
			<tr>
				<th>类别：</th>
				<td><select name="dictType">
						<option value="客户等级">客户等级</option>
						<option value="服务类型">服务类型</option>
				</select></td>
				<th>条目：</th>
				<td><input type="text" name="dictItem" /></td>
			</tr>
			<tr>
				<th>值：</th>
				<td><input type="text" name="dictValue" /></td>
				<th>是否编辑：</th>
				<td><input type="checkbox" name="dictIsEditable" /></td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="4"><input type="submit" value="确定" />&nbsp;&nbsp;
						<input type="button" value="返回" onclick="cancel()"/></td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
<link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="desDiv">
		<span>客户构成分析</span><br /> 根据客户的相关信息显示
	</div>
	<form action="../cstcustomer.do?flag=findAllCustomer" method="post">
		<table class="tableEdit">
			<tr>
				<th>报表方式：</th>
				<td><select id="type" name="type">
						<option value="level" selected="selected">按客户等级</option>
						<option value="satisfy">按满意度</option>
						<option value="credit">按信用度</option>
				</select></td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="查询" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
	<table class="dataTable">
		<tr>
			<th>序号</th>
			<th>等级</th>
			<th>客户数量</th>
		</tr>
		<c:forEach items="${list}" var="customer" varStatus="li">
			<tr>
				<td>${li.count}</td>
				<td>${customer[0]}</td>
				<td>${customer[1]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

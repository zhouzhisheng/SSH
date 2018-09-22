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
		<span>客户贡献分析</span><br /> 查看客户的销售总金额（从高到低排序）
	</div>
	<form action="../order.do?flag=findAllOrders" method="post">
	<table class="tableEdit">
		<tr>
			<th>客户名称：</th>
			<td><input type="text" name="cusName"/></td>
			<th>年份：</th>
			<td><select name="Year">
					<option value="2016">2016</option>
					<option value="2015">2015</option>
					<option value="2014">2014</option>
					<option value="2013">2013</option>
					<option value="2012">2012</option>
			</select>（说明：最近5年）</td>
		</tr>
		<tfoot>
			<tr>
				<td colspan="8"><input type="submit" value="查询" /></td>
			</tr>
		</tfoot>
	</table>
	</form>
	<table class="dataTable">
		<tr>
			<th>序号</th>
			<th>客户姓名</th>
			<th>订单金额(元)</th>
		</tr>
		<c:forEach items="${listOrders}" var="order" varStatus="li">
			<tr>
				<td>${li.count}</td>
				<td>${order[0] }</td>
				<td>${order[1]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

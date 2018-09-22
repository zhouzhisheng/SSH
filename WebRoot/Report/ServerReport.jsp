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
		<span>客户服务分析</span><br /> 根据客户服务类型显示数据（从高到低排序）
	</div>
	<form action="../cstservice.do?flag=findAllcstService" method="post">
		<table class="tableEdit">
			<tr>
				<th>年份：</th>
				<td><select name="year">
				        <option value="2017" selected="selected">2017</option>
						<option value="2016">2016</option>
						<option value="2015">2015</option>
						<option value="2014">2014</option>
						<option value="2013">2013</option>
				</select>（说明：最近5年）</td>
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
			<th>条目</th>
			<th>服务数量</th>
		</tr>
		<c:forEach items="${listCstServices}" var="service" varStatus="li">
			<tr>
				<td>${li.count}</td>
				<td>${service.svrType}</td>
				<td>${service.svrSatisfy}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

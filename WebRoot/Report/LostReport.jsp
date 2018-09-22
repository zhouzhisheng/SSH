<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<span>客户流失分析</span><br /> 查询显示流失客户相关信息
	</div>
	<form action="../cstLost.do?flag=findAllcstLost" method="post">
		<table class="tableEdit">
			<tr>
				<th>客户名称：</th>
				<td><input type="text" name="lstCustName"/></td>
				<th>客户经理：</th>
				<td><input type="text" name="lstCustManagerName"/></td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="4"><input type="submit" value="查询" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
	<table class="dataTable">
		<tr>
			<th>序号</th>
			<th>年份</th>
			<th>客户</th>
			<th>客户经理</th>
			<th>流失原因</th>
		</tr>
		<c:forEach items="${listCstLosts }" var="lost" varStatus="li">
			<tr>
				<td>${li.count }</td>
				<td><fmt:formatDate value="${lost.lstLostDate }" pattern="yyyy" />
				</td>
				<td>${lost.lstCustName }</td>
				<td>${ lost.lstCustManagerName}</td>
				<td>${lost.lstReason }</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>

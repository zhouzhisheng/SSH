<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<form action="../deal.do?flag=update" method="post">
		<table class="tableEdit" style="width:500px;">
			<thead>
				<tr>
					<td colspan="4">服务信息（状态：已分配）</td>
				</tr>
			</thead>
			<tr>
				<th>客户名称：</th>
				<td>${cstService.svrCustName }</td>
				<th>服务类型：</th>
				<td>${ cstService.svrType}</td>
			</tr>
			<tr>
				<th>服务概要：</th>
				<td colspan="3">${cstService.svrTitle }</td>
			</tr>
			<tr>
				<th>详细信息：</th>
				<td colspan="3">${cstService.svrRequest }</td>
			</tr>
			<tr>
				<th>创建人：</th>
				<td>${ cstService.svrCreateBy}</td>
				<th>创建时间：</th>
				<td><fmt:formatDate value="${cstService.svrCreateDate }"
						pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<th>分配人：</th>
				<td>${cstService.svrDueTo }</td>
				<th>分配时间：</th>
				<td><fmt:formatDate value="${ cstService.svrDueDate}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</table>
		<table class="tableEdit" style="width:500px;">
			<thead>
				<tr>
					<td colspan="4">服务处理</td>
				</tr>
			</thead>
			<tr>
				<th>服务处理：</th>
				<td colspan="3"><textarea name="result"></textarea></td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="4"><input type="submit" value="确定" />&nbsp;&nbsp;
						<input type="button" value="返回" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>

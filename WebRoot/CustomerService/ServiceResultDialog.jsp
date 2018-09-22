<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="../feedback.do?flag=update" method="post">
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
				<td>${cstService.svrType }</td>
			</tr>

			<tr>
				<th>服务概要：</th>
				<td colspan="3">${cstService.svrTitle }</td>
			</tr>
			<tr>
				<th>详细信息：</th>
				<td colspan="3">${ cstService.svrRequest}</td>
			</tr>
			<tr>
				<th>创建人：</th>
				<td>${cstService.svrCreateBy }</td>
				<th>创建时候：</th>
				<td><fmt:formatDate value="${ cstService.svrCreateDate}"
						pattern="yyyy年MM月dd日" /></td>
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
				<td colspan="3">${cstService.svrDeal}</td>
			</tr>
			<tr>
				<th>处理人：</th>
				<td>${cstService.svrDealBy }</td>
				<th>处理时间：</th>
				<td><fmt:formatDate value="${ cstService.svrDealDate}"
						pattern="yyyy年MM月dd日" /></td>
			</tr>
		</table>
		<table class="tableEdit" style="width:500px;">
			<thead>
				<tr>
					<td colspan="4">服务反馈</td>
				</tr>
			</thead>
			<tr>
				<th>满意度：</th>
				<td><select name="svrSatisfy">
						<option value="1">☆</option>
						<option value="2">☆☆</option>
						<option value="3">☆☆☆</option>
						<option value="4">☆☆☆☆</option>
						<option value="5">☆☆☆☆☆</option>
				</select></td>
			</tr>
			<tr>
				<th>处理结果：</th>
				<td><textarea name="svrResult"></textarea></td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="4"><input type="submit" value="确定" />&nbsp;&nbsp;
						<input type="button" value="关闭" onclick="window.close()" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>

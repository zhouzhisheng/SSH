<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
<link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function Jump() {
		var page = document.getElementById("page").value;
		if (page != 0) {
			location.href = "../assign.do?flag=findAll&curPage=" + page;
		}
	}
</script>
</head>
<body>
	<div id="desDiv">
		<span>服务反馈</span><br /> 对于客户提出的咨询、建议、投诉等服务进行处理完毕后，记录客户对服务的结果的满意度等
	</div>
	<form action="../feedback.do?flag=find" method="post">
		<table class="tableEdit">
			<tr>
				<th>客户名称：</th>
				<td><input type="text" name="cusName" /></td>
				<th>概要：</th>
				<td><input type="text" name="title" /></td>
				<th>服务类型：</th>
				<td><select name="serviceType">
						<option value="" selected="selected">全部</option>
						<option value="咨询">咨询</option>
						<option value="投诉">投诉</option>
						<option value="建议">建议</option>
				</select></td>
			</tr>
			<tr>
				<th>创建日期：</th>
				<td colspan="3"><input type="text" name="day1" />&nbsp;-&nbsp;<input
					type="text" name="day2" /></td>
				<th>状态：</th>
				<td><select name="status">
						<option value="全部">全部</option>
						<option value="新创建">新创建</option>
						<option value="已分配">已分配</option>
						<option value="已处理" selected="selected">已处理</option>
						<option value="已反馈">已反馈</option>
						<option value="已归档">已归档</option>
				</select></td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="8"><input type="submit" value="查询" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
	<div id="dataDiv">
		<div id="headDiv"></div>
		<table class="dataTable">
			<tr>
				<th>客户名称</th>
				<th>概要</th>
				<th>服务类型</th>
				<th>创建时间</th>
				<th>分配人</th>
				<th>分配时间</th>
				<th>处理</th>
			</tr>
			<c:forEach items="${cstServices }" var="service">
				<tr>
					<td>${service.svrCustName }</td>
					<td>${ service.svrTitle}</td>
					<td>${service.svrType }</td>
					<td><fmt:formatDate value="${service.svrCreateDate }"
							pattern="yyyy年MM月dd日" /></td>
					<td>${service.svrDueTo }</td>
					<td><fmt:formatDate value="${ service.svrDueDate}"
							pattern="yyyy年MM月dd日" /></td>
					<td><a
						href="../feedback.do?flag=findByID&id=${service.svrId }"><img
							src="../images/bt_feedback.gif" style="border:0px" /></a></td>
				</tr>
			</c:forEach>
		</table>
		<div id="pageDiv">
			<div id="leftPage">共有${count}条记录，当前第${curPage}/${maxPage}页</div>
			<div id="rightPage">
				<a
					href="../feedback.do?flag=find&path=CustomerService/ServiceResult.jsp&curPage=1"><input
					type="image" src="../images/first.gif" />&nbsp;&nbsp; </a> <a
					href="../feedback.do?flag=find&path=CustomerService/ServiceResult.jsp&curPage=${curPage-1 }"><input
					type="image" src="../images/back.gif" />&nbsp;&nbsp; </a> <a
					href="../feedback.do?flag=find&path=CustomerService/ServiceResult.jsp&curPage=${curPage+1 }"><input
					type="image" src="../images/next.gif" />&nbsp;&nbsp; </a> <a
					href="../feedback.do?flag=find&path=CustomerService/ServiceResult.jsp&curPage=${maxPage}"><input
					type="image" src="../images/last.gif" />&nbsp;&nbsp; </a> 
					转到第<input type="text" size="1" id="page" />&nbsp;&nbsp;
					<input type="image" src="../images/go.gif"  onclick="Jump()"/>
			</div>
		</div>
	</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
<link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function Delete(id) {
		if (confirm("确认删除该信息吗？")) {
			location.href = "../basdict.do?flag=Deletebasdict&id=" + id;
		}
	}
</script>
</head>
<body>
	<div id="desDiv">
		<span>数据字典管理</span><br /> 管理系统所需的数据字典内容
	</div>
	<form action="../basdict.do?flag=findAllBasDicts" method="post">
	<table class="tableEdit">
		<tr>
			<th>类别：</th>
			<td><input type="text"  name="dictType"/></td>
			<th>条目：</th>
			<td><input type="text" name="dictItem"/></td>
			<th>值：</th>
			<td><input type="text" name="dictValue"/></td>
		</tr>
		<tfoot>
			<tr>
				<td colspan="8"><input type="submit" value="查询" /></td>
			</tr>
		</tfoot>
	</table>
	</form>
	<div id="dataDiv">
		<div id="headDiv">
			<img src="../images/22.gif" />&nbsp;&nbsp;<a
				href="DataAdd.jsp?1=1">新建</a>

		</div>
		<table class="dataTable">
			<tr>
				<th>类别</th>
				<th>条目</th>
				<th>值</th>
				<th>是否可编辑</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${listbasdict }" var="basDiet">
				<tr>
					<td>${basDiet.dictType }</td>
					<td>${ basDiet.dictItem}</td>
					<td>${basDiet.dictValue }</td>
					<td><c:if test="${basDiet.dictIsEditable==1 }">是</c:if> <c:if
							test="${basDiet.dictIsEditable==0 }">否</c:if></td>
					<td><c:if test="${basDiet.dictIsEditable==1 }">
							<a href="../basdict.do?flag=toEdit&id=${basDiet.dictId }"><img
								src="../images/33.gif" title="编辑" style="border:0px" /></a>
							<a href="javascript:Delete('${basDiet.dictId }')"><img src="../images/bt_del.gif"
								title="删除" style="border:0px" /></a>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>

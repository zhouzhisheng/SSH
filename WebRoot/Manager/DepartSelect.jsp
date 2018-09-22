<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
<link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function doSize() {
			var page = document.getElementById("page").value;
			//alert(page);
			if(page!=0){
			location.href = "../storage.do?flag=findAllStorage&curPage=" + page;
			}		
	}
</script>
</head>
<body>
	<div id="desDiv">
		<span>库存查询</span><br /> 查询产品库存信息
	</div>
	<form action="../storage.do?flag=findAllStorage" method="post">
		<table class="tableEdit">
			<tr>
				<th>产品名称：</th>
				<td><input type="text" name="proName" /></td>
				<th>仓库：</th>
				<td><input type="text" name="stkWarehouse" /></td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="4"><input type="submit" value="查询" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
	<br />
	<table class="dataTable">
		<tr>
			<th>产品名称</th>
			<th>仓库</th>
			<th>货位</th>
			<th>件数</th>
			<th>备注</th>
		</tr>
		<c:forEach items="${liststStorages}" var="storage">
			<tr>
				<td>${storage.product.prodName }</td>
				<td>${storage.stkWarehouse }</td>
				<td>${storage.stkWare }</td>
				<td>${storage.stkCount }</td>
				<td>${storage.stkMemo }</td>
			</tr>
		</c:forEach>
	</table>
	<div id="pageDiv">
		<div id="leftPage">共有${count}条记录，当前第${curPage}/${maxPage }页</div>
		<div id="rightPage">
			<a
				href="../storage.do?flag=findAllStorage&path=Manager/DepartSelect.jsp&curPage=1">
				<input type="image" src="../images/first.gif" />&nbsp;&nbsp;
			</a> <a
				href="../storage.do?flag=findAllStorage&path=Manager/DepartSelect.jsp&curPage=${curPage-1 }">
				<input type="image" src="../images/back.gif" />&nbsp;&nbsp;
			</a>. <a
				href="../storage.do?flag=findAllStorage&path=Manager/DepartSelect.jsp&curPage=${curPage+1 }">
				<input type="image" src="../images/next.gif" />&nbsp;&nbsp;
			</a>. <a
				href="../storage.do?flag=findAllStorage&path=Manager/DepartSelect.jsp&curPage=${maxPage }">
				<input type="image" src="../images/last.gif" />&nbsp;&nbsp;
			</a>转到第<input type="text" size="1" name="page" id="page"/>&nbsp;&nbsp;<input type="image"
				src="../images/go.gif" onclick="doSize()" name="page" id="page"/>
		</div>
	</div>
</body>
</html>

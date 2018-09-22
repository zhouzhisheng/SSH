<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
<link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function Jump(){
	    var page=document.getElementById("page").value;
		//alert(page);
		if(page!=0){
		location.href = "../product.do?flag=findAllProduct&curPage=" + page;
		}	
	}	
</script>
</head>
<body>
	<div id="desDiv">
		<span>产品查询</span><br /> 查询产品信息
	</div>
	<form action="../product.do?flag=findAllProduct" method="post">
		<table class="tableEdit">
			<tr>
				<th>产品名称：</th>
				<td><input type="text" name="prodName" /></td>
				<th>型号：</th>
				<td><input type="text" name="prodType" /></td>
				<th>批次：</th>
				<td><input type="text" name="prodBatch" /></td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="8"><input type="submit" value="查询" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
	<br />
	<table class="dataTable">
		<tr>
			<th>产品名称</th>
			<th>型号</th>
			<th>等级/批次</th>
			<th>单位</th>
			<th>单价(元)</th>
			<th>备注</th>
		</tr>
		<c:forEach items="${listpProducts }" var="product">
			<tr>
				<td>${product.prodName}</td>
				<td>${product.prodType}</td>
				<td>${product.prodBatch }</td>
				<td>${product.prodUnit}</td>
				<td>${product.prodPrice}</td>
				<td>${product.prodMemo}</td>
			</tr>
		</c:forEach>
	</table>
	<div id="pageDiv">
		<div id="leftPage">共有${count}条记录，当前第${curPage}/${maxPage }页</div>
		<div id="rightPage">
			<a href="../product.do?flag=findAllProduct&path=Manager/ProductSelect.jsp&curPage=1">
				<input type="image" src="../images/first.gif" />&nbsp;&nbsp;</a> <a href="../product.do?flag=findAllProduct&path=Manager/ProductSelect.jsp&curPage=${curPage-1 }">
				<input type="image" src="../images/back.gif" />&nbsp;&nbsp;</a> <a href="../product.do?flag=findAllProduct&path=Manager/ProductSelect.jsp&curPage=${curPage+1 }">
				<input type="image" src="../images/next.gif" />&nbsp;&nbsp;</a> <a href="../product.do?flag=findAllProduct&path=Manager/ProductSelect.jsp&curPage=${maxPage }">
				<input type="image" src="../images/last.gif" />&nbsp;&nbsp;</a> 
			转到第<input type="text" size="1" id="page"/>&nbsp;&nbsp;
			<input type="image" src="../images/go.gif" onclick="Jump()"/>
		</div>
	</div>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title></title>
    <link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
    <link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    function dosize(){
    var page=document.getElementById("page").value;
    location.href="../saleChance.do?type=query&curpage="+page;
    }
    function date(id){
    	if(confirm("真的确认删除该信息吗？")){
    	location.href="../saleChance.do?type=dateSale&id="+id;
    	}
    }
    </script> 
</head>
<body>
<div id="desDiv">
    <span>销售机会管理</span><br />
    创建和维护销售机会
</div>
<form action="../saleChance.do?type=query" method="post">
<input  type="hidden" id="curpage" name="curpage" value="${curpage }"/>
    <table class="tableEdit">
        <tr>
            <th>客户名称：</th>
            <td><input type="text" name="chcCustName"/></td>
            <th>联系人：</th>
            <td><input type="text" name="chcLinkman"/></td>
            <th>概要：</th>
            <td><input type="text" name="chcDesc"/></td>
        </tr>
        <tfoot>
            <tr>
                <td colspan="8"><input type="submit" value="查询" /></td>
            </tr>
        </tfoot>
    </table>
    </form>
    <br />
<div id="dataDiv">
    <div id="headDiv">
        <img src="../images/22.gif" />&nbsp;&nbsp;<a href="AddSale.jsp">新建</a>
    </div>
    <table class="dataTable">
        <tr>
            <th>客户名称</th>
            <th>概要</th>
            <th>联系人</th>
            <th>联系电话</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${salist }" var="salist">
        <tr>
            <td>${salist.chcCustName }</td>
            <td>${salist.chcTitle }</td>
            <td>${salist.chcLinkman }</td>
            <td>${salist.chcTel }</td> 
            <td><fmt:formatDate value="${salist.chcCreateDate }" pattern="yyyy-MM-dd" /></td>
            <td>
            <a href="../saleChance.do?type=Usale&chcId=${salist.chcId}"><img title="分配" src="../images/bt_linkman.gif" style="border:0px;width:16px;height:16px" /></a>&nbsp;&nbsp;
            <a href="../saleChance.do?type=QuerSale&chcId=${salist.chcId}"><img title="修改" src="../images/edt.gif" style="border:0px"/></a>&nbsp;&nbsp;<img title="删除" src="../images/del.gif" onclick="date('${salist.chcId}');" /></td>
        </tr>
  </c:forEach>
    </table>
    <div id="pageDiv">
        <div id="leftPage">共有${maxpage }条记录，当前第${curpage }/${ maxpage}页</div>
        <div id="rightPage">
            <input type="image" src="../images/first.gif" onclick="location.href='../saleChance.do?type=query&curpage=1'" />&nbsp;&nbsp;
            <input type="image" src="../images/back.gif"  onclick="location.href='../saleChance.do?type=query&curpage=${curpage-1}'" />&nbsp;&nbsp;
            <input type="image" src="../images/next.gif"  onclick="location.href='../saleChance.do?type=query&curpage=${curpage+1}'"/>&nbsp;&nbsp;
            <input type="image" src="../images/last.gif"  onclick="location.href='../saleChance.do?type=query&curpage=${maxpage}'"/>&nbsp;&nbsp;
            转到第<input type="text" size="1" name="page" id="page" />&nbsp;&nbsp;<input type="image" name="page" id="page" src="../images/go.gif" onclick="dosize()"/>
        </div>
    </div>
</div>
</body>
</html>

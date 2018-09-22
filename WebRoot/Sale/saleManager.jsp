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
        function showOk() {
            window.showModalDialog("SaleOk.htm?data=" + Math.random(), "参数", "dialogWidth:550px;dialogHeight:400px;help:no");
        }
        function showNo() {
            window.showModalDialog("SaleNo.htm?data=" + Math.random(), "参数", "dialogWidth:550px;dialogHeight:400px;help:no");
        }
	function dosize(){
    var page=document.getElementById("page").value;
    location.href="../saleChance.do?type=query&curpage="+page;
    }
 </script>
</head>
<body>
<div id="desDiv">
    <span>客户开发计划</span><br />
    制定客户开发计划和记录开发进度
</div>
<form action="../salPlan.do?type=query" method="post">
    <table class="tableEdit">
        <tr>
            <th>客户名称：</th>
            <td><input type="text" name="chcCustName" /></td>
            <th>联系人：</th>
            <td><input type="text" name="chcLinkman" /></td>
        </tr>
        <tr>
            <th>概要：</th>
            <td><input type="text"  name="chcTitle"/></td>
            <th>开发状态：</th>
            <td>
                <select>
                    <option selected="selected" value="0">全部</option>
                    <option value="1">开发中</option>
                    <option value="2">开发成功</option>
                    <option value="3">开发失败</option>
                </select>
            </td>
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
    </div>
    <table class="dataTable">
        <tr>
            <th>客户名称</th>
            <th>概要</th>
            <th>联系人</th>
            <th>联系电话</th>
            <th>创建时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${slist }" var="v">
        <tr>
            <td>${v.chcCustName }</td>
            <td>${v.chcTitle }</td>
            <td>${v.chcLinkman }</td>
            <td>${v.chcTel }</td>
            <td><fmt:formatDate value="${v.chcCreateDate }" pattern="yyyy-MM-dd" /> </td>
                  <c:if test="${v.chcStatus==2 }">
            <td>开发中</td>
           </c:if>
           <c:if test="${v.chcStatus==3 }">
            <td>开发成功</td>
           </c:if>
           <c:if test="${v.chcStatus==4}">
            <td>开发失败</td>
           </c:if>
            <td>                
            <c:if test="${v.chcStatus==2 }">
             
                <a href="../salPlan.do?type=ues&chcId=${v.chcId }"><img title="制定计划" src="../images/bt_plan.gif" style="border:0px" /></a>
                <a href="../salPlan.do?type=ZX&chcId=${v.chcId }&go=exec"><img title="执行计划" src="../images/bt_feedback.gif" style="border:0px" /></a>
                <a href="../saleChance.do?type=CG&chcId=${v.chcId }"><img title="开发成功" src="../images/bt_yes.gif" style="border:0px" /></a>
                <a href="../saleChance.do?type=ZZ&chcId=${v.chcId }"><img title="开发终止" src="../images/11.gif" style="border:0px" /></a>
            </c:if>
            <c:if test="${v.chcStatus==3 }">
                <a href="../salPlan.do?type=Ac&chcId=${v.chcId }"><img title="查看" src="../images/bt_orders.gif" /></a>
           </c:if>
           <c:if test="${v.chcStatus==4}">
                开发失败
           </c:if>             
            </td>
        </tr>
      </c:forEach>
    </table>
    <div id="pageDiv">
         <div id="leftPage">共有${maxpage }条记录，当前第${curpage }/${ maxpage}页</div>
        <div id="rightPage">
            <input type="image" src="../images/first.gif" onclick="location.href='../salPlan.do?type=query&curpage=1'" />&nbsp;&nbsp;
            <input type="image" src="../images/back.gif"  onclick="location.href='../salPlan.do?type=query&curpage=${curpage-1}'" />&nbsp;&nbsp;
            <input type="image" src="../images/next.gif"  onclick="location.href='../salPlan.do?type=query&curpage=${curpage+1}'"/>&nbsp;&nbsp;
            <input type="image" src="../images/last.gif"  onclick="location.href='../salPlan.do?type=query&curpage=${maxpage}'"/>&nbsp;&nbsp;
            转到第<input type="text" size="1" name="page" id="page" />&nbsp;&nbsp;
            <input type="image" name="page" id="page" src="../images/go.gif" onclick="dosize()"/>
        </div>
    </div>
</div>
</body>
</html>

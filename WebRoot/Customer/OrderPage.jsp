<%@page import="com.baidu.dao.CstCustomerDao"%>
<%@page import="com.baidu.dao.IMPL.CstCustomerDaoIMPL"%>
<%@page import="com.baidu.biz.IMPL.CstCustomerBizIMPL"%>
<%@page import="com.baidu.biz.CstCustomerBiz"%>
<%@page import="com.baidu.struts.entity.CstCustomer"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 4.1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
    <link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
    <%
    String stuN=(String)request.getSession().getAttribute("custNo");
    session.setAttribute("stuNo", stuN);
    %>
    <script type="text/javascript">
    function show(){
   var page= document.getElementById("page").value;
   location.href="../cstCustomer.do?type=Or&curpage="+page;
    }
    </script>
</head>
<body>
    <div id="desDiv">
        <span>客户历史订单</span><br />
        记录客户的历史订单
    </div>
    <table class="tableEdit">
        <tr>
            <th>
                客户编号：
            </th>
            <td>
              ${cstCustomer.custNo }
            </td>
            <th>
                客户名称：
            </th>
            <td>
                ${cstCustomer.custName}
            </td>
        </tr>
    </table>
    <div id="dataDiv">
        <div id="headDiv">
            <img src="../images/22.gif" />&nbsp;&nbsp;<a href="OrderAdd.jsp">新建</a>
        </div>
        <table class="dataTable">
            <tr>
                <th>
                    订单编号
                </th>
                <th>
                    日期
                </th>
                <th>
                    送货地址
                </th>
                <th>
                    状态
                </th>
                <th>
                    操作
                </th>
            </tr>
            <c:forEach items="${orlist }" var="A">
            <tr>
                <td>
                  ${A.odrId }
                </td>
                <td>
              <fmt:formatDate value="${A.odrDate }" pattern="yyyy-MM-dd" />
                </td>
                <td>
                   ${A.odrAddr }
                </td>
                <td><c:if test="${A.odrStatus==5 }">
                   已回款
               </c:if><c:if test="${A.odrStatus==6 }">
                 未回款 
               </c:if></td>
                <td>
                    <a href="../cstCustomer.do?type=rO&odrId=${A.odrId }"><img title="详细信息" src="../images/bt_detail.gif" /></a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <div id="pageDiv">
            <div id="leftPage">
                共有${maxPage }条记录，当前第${curpage }/${maxPage }页
            </div>
            <div id="rightPage">
                <input type="image" src="../images/first.gif"onclick="location.href='../cstCustomer.do?type=Or&curpage=1'" />&nbsp;&nbsp;
                <input type="image" src="../images/back.gif" onclick="location.href='../cstCustomer.do?type=Or&curpage=${curpage-1}'" />&nbsp;&nbsp;
                <input type="image" src="../images/next.gif" onclick="location.href='../cstCustomer.do?type=Or&curpage=${curpage+1}'"/>&nbsp;&nbsp;
                <input type="image" src="../images/last.gif" onclick="location.href='../cstCustomer.do?type=Or&curpage=${maxPage}'" />&nbsp;&nbsp; 
                转到第<input type="text"size="1" id="page" />&nbsp;&nbsp;
                <input type="image" src="../images/go.gif" onclick="show()" />
            </div>
        </div>
    </div>
</body>
</html>

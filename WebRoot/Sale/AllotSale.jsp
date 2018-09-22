<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 4.0.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="../CSS/style2.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    function date(){
     location.href="../saleChance.do?type=query";
     }
    </script>
    <%
    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    String usrName=(String)request.getSession().getAttribute("usrName");
    
    pageContext.setAttribute("datetime", datetime);
    pageContext.setAttribute("usrName", usrName);
    session.setAttribute("usrName", usrName);
   session.setAttribute("datetime", datetime);
     %>
</head>
<body>
<form action="../saleChance.do?type=SaleFp" method="post">
    <table class="tableEdit">
        <thead>
            <tr>
                <td colspan="4">销售机会添加</td>
            </tr>
        </thead>
        <tr>
            <th>客户名称：</th>
            <td>
                ${sal.chcCustName } 
            </td>
            <th>机会来源</th>
            
            <td>${sal.chcSource }</td>
        </tr>
        <tr>
            <th>成功几率：</th>
            <td>
                ${sal.chcRate }
            </td>
            <th></th>
            <td></td>
        </tr>
        <tr>
            <th>联系人：</th>
            <td>${sal.chcLinkman }</td>
            
            <th>联系电话：</th>
            <td>${sal.chcTel }</td>
        </tr>
        <tr>
            <th>概要：</th>
            <td colspan="3">${sal.chcTitle }</td>
        </tr>
        <tr style="height:100px">
            <th>机会描述：</th>
            <td colspan="3" style="vertical-align:top">${sal.chcDesc }</td>
        </tr>
        <tr>
            <th>创建人：</th>
            <td>${usrName }</td>
            <th>创建时间：</th>
            <td>${sal.chcCreateDate }</td>
        </tr>
        <tr>
            <th>指派人：</th>
            <td>
                <select name="useId">
                <c:forEach items="${syslist }" var="v">
                    <option value="${v.usrId }">${v.usrName }</option>
                </c:forEach>
                </select>
            </td>
            <th>指派时间：</th>
            <td>${datetime }</td>
        </tr>
        <tfoot>
            <tr>
                <td colspan="4">
                    <input type="submit" value="确定" />&nbsp;&nbsp;
                    <input type="button" value="返回" onclick="date()"/>
                </td>
            </tr>
        </tfoot>
        </form>
    </table>
</body>
</html>

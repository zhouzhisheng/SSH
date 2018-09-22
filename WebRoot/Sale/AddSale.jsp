<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ page language="java" import="java.text.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 4.0.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="../CSS/style2.css" rel="stylesheet" type="text/css" />
    <%
    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    pageContext.setAttribute("datetime", datetime);
    String usrName=(String)request.getSession().getAttribute("usrName");
    int usrId=(Integer)request.getSession().getAttribute("usrId");
    session.setAttribute("usrId", usrId);
    session.setAttribute("usrName", usrName);
    session.setAttribute("datetime", datetime);
     %>
<script type="text/javascript">
     function OnCile(){
     location.href="../saleChance.do?type=AddSale";
     }
     function date(){
     location.href="../saleChance.do?type=query";
     }
  </script>
</head>

<body>
<form action="../saleChance.do?type=AddSale" method="post">
    <table class="tableEdit">
        <thead>
            <tr>
                <td colspan="4">销售机会添加</td>
            </tr>
        </thead>
        <tr>
            <th>客户名称：</th>
            <td>
                <input type="text" name="chcCustName" />
            </td>
            <th>机会来源</th>
            <td><input type="text" name="chcSource"/></td>
        </tr>
        <tr>
            <th>成功几率：</th>
            <td>
                <input type="text" name="chcRate"/>
            </td>
            <th></th>
            <td></td>
        </tr>
        <tr>
            <th>联系人：</th>
            <td><input type="text" name="chcLinkman"/></td>
            <th>联系电话：</th>
            <td><input type="text"  name="chcTel"/></td>
        </tr>
        <tr>
            <th>概要：</th>
            <td colspan="3"><input type="text" style="width:500px" name="chcTitle" /></td>
        </tr>
        <tr>
            <th>机会描述：</th>
            <td colspan="3"><textarea style="width:500px" name="chcDesc"></textarea></td>
        </tr>
        <tr>
            <th>创建人</th>
            <td><input type="text" readonly="readonly" value="${usrName }" name="usrName"/></td>
            <th>创建时间</th>
            <td><input type="text" readonly="readonly" value="${datetime }" name="datetime" /></td> 
        </tr>
        <tfoot>
            <tr>
                <td colspan="4">
                    <input type="submit" value="确定并返回" />&nbsp;&nbsp;
                    <input type="button" value="确定并继续" onclick="OnCile()" />&nbsp;&nbsp;
                    <input type="button" value="返回" onclick="date()"/>
                </td>
                
            </tr>
        </tfoot>
        </form>
    </table>
</body>
</html>

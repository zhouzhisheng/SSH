<%@page import="com.baidu.struts.entity.SalChance"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title></title>
    <link href="../CSS/style2.css" rel="stylesheet" type="text/css" />
 <%
    String usrName=(String)request.getSession().getAttribute("usrName");
     session.setAttribute("usrName", usrName);
  %>
  <script type="text/javascript">
    function date(){
     location.href="../saleChance.do?type=query";
     }
  </script>
</head>
<body>
<form action="../saleChance.do?type=UpdaSale" method="post">
    <table class="tableEdit">
        <thead>
            <tr>
                <td colspan="4">销售机会编辑</td>
            </tr>
        </thead>
        <tr>
            <th>客户名称：</th>
            <td>
                <input type="text" name="chcCustName" value="${salChance.chcCustName }"/>
            </td>
            <th>机会来源</th>
            <td><input type="text" name="chcSource" value="${salChance.chcSource }" /></td>
        </tr>
        <tr>
            <th>成功几率：</th>
            <td>
                <input type="text" name="chcRate" value="${salChance.chcRate }" />
            </td>
            <th></th>
            <td></td>
        </tr>
        <tr>
            <th>联系人：</th>
            <td><input type="text" name="chcLinkman" value="${salChance.chcLinkman }" /></td>
           <th>联系电话：</th>
           <td><input type="text"  name="chcTel" value="${salChance.chcTel }"/></td>
        </tr>
        <tr>
            <th>概要：</th>
            <td colspan="3"><input type="text" style="width:500px" name="chcTitle" value="${salChance.chcTitle }" /></td>
        </tr>
        <tr>
            <th>机会描述：</th>
            <td colspan="3"><textarea style="width:500px" name="chcDesc" value="${salChance.chcDesc }"></textarea></td>
        </tr>
        <tr>
            <th>创建人</th>
            <td><input type="text" readonly="readonly" value="${usrName }" name="usrName" /></td>
            <th>创建时间</th>
             <td><input type="text"name="chcCreateDate" value="<fmt:formatDate value="${salChance.chcCreateDate}" pattern="yyyy-MM-dd" /> " />
             </td>
        </tr>
        <tfoot>
            <tr>
                <td colspan="4">
                    <input type="submit" value="确定" />&nbsp;&nbsp;
                    <input type="button" value="返回" onclick="date()" />
                </td>
            </tr>
        </tfoot>
        </form>
    </table>
</body>
</html>

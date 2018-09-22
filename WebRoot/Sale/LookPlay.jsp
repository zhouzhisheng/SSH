<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="../CSS/style2.css" rel="stylesheet" type="text/css" />
    <link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <table class="tableEdit">
        <thead>
            <tr>
                <td colspan="4">客户信息</td>
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
            <th>开发状态</th>
            <td>开发成功/开发失败</td>
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
            <td>${sal.chcCreateBy }</td>
            <th>创建时间：</th>
            <td><fmt:formatDate value="${sal.chcCreateDate }" pattern="yyyy-MM-dd"/></td>
        </tr>
        <tr>
            <th>指派人：</th>
            <td>${sal.chcDueTo }</td>
            <th>指派时间：</th>
            <td><fmt:formatDate value="${sal.chcDueDate }" pattern="yyyy-MM-dd"/></td>
        </tr>
    </table>
    <p>
    </p>
    <table class="dataTable">
        <tr>
            <th>日期</th>
            <th>计划</th>
            <th>执行效果</th>
        </tr>
        <c:forEach items="${salist }" var="v">
        <tr>
            <td><fmt:formatDate value="${v.plaDate }" pattern="yyyy-MM-dd"/></td>
            <td>${v.plaTodo }</td>
            <td>${v.plaResult }</td>
        </tr>
       </c:forEach>
    </table>
</body>
</html>

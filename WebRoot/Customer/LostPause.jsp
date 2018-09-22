<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 4.1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="../CSS/style2.css" rel="stylesheet" type="text/css" />
     <script type="text/javascript">
    function  show() {
		location.href="../cstlost.do?type=query";
	}
</script>
</head>
<body>
<form action="../cstlost.do?type=Ag" method="post">
    <table class="tableEdit">
        <thead>
            <tr>
                <td colspan="4">暂缓流失</td>
            </tr>
        </thead>
        <tr>
            <th>客户编号：</th>
            <td>
                ${cs.cstCustomer.custNo }
            </td>
            <th>客户姓名：</th>
            <td>${cs.lstCustName }</td>
        </tr>
        <tr>
            <th>客户经理：</th>
            <td>${cs.lstCustManagerName }</td>
            <th>最后下单时间：</th>
            <td><fmt:formatDate value="${cs.lstLastOrderDate }"/></td>
        </tr>
        <tr>
            <th>暂缓措施：</th>
            <td colspan="3">
                ${cs.lstDelay }<br/>
            </td>
        </tr>
        <tr>
            <th>追加暂缓措施：</th>
            <td colspan="3"><textarea name="cw"></textarea></td>
        </tr>
        <tfoot>
            <tr>
                <td colspan="4">
                    <input type="submit" value="确定" />&nbsp;&nbsp;
                    <input type="button" value="返回" onclick="show()" />
                </td>
            </tr>
        </tfoot>
    </table>
  </form>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title></title>
    <link href="../CSS/style2.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    function on(custNo){
         
    location.href="../cstCustomer.do?type=In&custNo="+custNo;
    }
    </script>
</head>
<body>
<form action="../cstCustomer.do?type=Update" method="post">
<table class="tableEdit">
        <thead>
            <tr>
                <td colspan="4">编辑联系人</td>
            </tr>
        </thead>
        <tr>
            <th>姓名：</th>
            <td>
                <input type="text"  name="lkmCustName" value="${cs.lkmName }"/></td>
            <th>性别：</th>
            <td>
                <input type="radio" checked="checked" name="lkmSex" value="${cs.lkmSex }" />男&nbsp;&nbsp;
                <input type="radio"   name="lkmSex" value="${cs.lkmSex }"/>女
            </td>
        </tr>
        <tr>
            <th>职位：</th>
            <td><input type="text"  name="lkmPostion" value="${cs.lkmPostion }"/></td>
            <th>固定电话：</th>
            <td><input type="text"  name="lkmTel" value="${cs.lkmTel }"/></td>
        </tr>
         <tr>
            <th>手机号码：</th>
            <td><input type="text"  name="lkmMobile" value="${cs.lkmMobile }"/></td>
            <th></th>
            <td></td>
        </tr>
        <tr>
            <th>备注：</th>
            <td colspan="3"><textarea  name="lkmMemo"  ${cs.lkmMemo }></textarea></td>
        </tr>
        <tfoot>
            <tr>
                <td colspan="4">
                    <input type="submit" value="确定" />&nbsp;&nbsp;
                    <input type="button" value="关闭"  onclick="on('custNo')" />
                </td>
            </tr>
        </tfoot>
    </table>
    </form>
</body>
</html>

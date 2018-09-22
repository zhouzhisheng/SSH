<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title></title>
    <link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
    <link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    function date(id){
    	if(confirm("真的确认删除该信息吗？")){
    	location.href="../cstCustomer.do?type=date&id="+id;
    	}
    }
    
    </script>
</head>
<body>
<div id="desDiv">
    <span>客户联系人管理</span><br />
    管理客户的相关联系人信息
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
                ${cstCustomer.custName }
            </td>
        </tr>
    </table>
    <div id="dataDiv">
    <div id="headDiv">
        <img src="../images/22.gif" />&nbsp;&nbsp;<a href="LinkManAdd.jsp?">新建</a>
    </div>
    <table class="dataTable">
                        <tr>
                            <th>
                                姓名
                            </th>
                            <th>
                                性别
                            </th>
                            <th>
                                职位
                            </th>
                            <th>
                                固定电话
                            </th>
                            <th>
                                手机号码
                            </th>
                            <th>备注</th>
                            <th>
                                操作
                            </th>
                        </tr>
                    <c:forEach items="${list }" var="cs">
                        <tr>
                            <td>
                                ${cs.lkmName }
                            </td>
                            <td>
                                ${cs.lkmSex }
                            </td>
                            <td>
                                ${cs.lkmPostion }
                            </td>
                            <td>
                                ${cs.lkmTel }
                            </td>
                            <td>
                                ${cs.lkmMobile }
                            </td>
                            <td></td>
                            <td>
                            <a href="../cstCustomer.do?type=inSe&lkmId=${cs. lkmId}"><img title="编辑" src="../images/33.gif" style="border:0px"/></a>&nbsp;
                            <img title="删除" src="../images/11.gif"  onclick="date('${cs.lkmId}')"/>
                            </td>
                        </tr>
                      </c:forEach>
       </table>
    </div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title></title>
    <link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
    <link href="../CSS/Style2.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    function date(id){
    	if(confirm("真的确认删除该信息吗？")){
    	location.href="../cstCustomer.do?type=datetm&id="+id;
    	}
    }
    </script>
</head>
<body>
<div id="desDiv">
    <span>客户交往记录</span><br />
    记录与客户之间的交往信息
</div>
    <table class="tableEdit">
        <tr>
            <th>
                客户编号：
            </th>
            <td>
                ${css.custNo }
            </td>
            <th>
                客户名称：
            </th>
            <td>
               ${css.custName }
            </td>
        </tr>
    </table>
<div id="dataDiv">
    <div id="headDiv">
        <img src="../images/22.gif" />&nbsp;&nbsp;<a href="ActivitysAdd.jsp">新建</a>
    </div>
 
    <table class="dataTable">
                        <tr>
                            <th>
                                时间
                            </th>
                            <th>
                                地点
                            </th>
                            <th>
                                概要
                            </th>
                            <th>
                                详细信息
                            </th>
                            <th>备注</th>
                            <th>
                                操作
                            </th>
                        </tr>
                        <c:forEach items="${list }" var="v">
                        <tr>
                            <td>
                              <fmt:formatDate value="${v.atvDate }" pattern="yyyy-MM-dd"/>
                            </td>
                            <td>
                               ${v.atvPlace }
                            </td>
                            <td>
                               ${v.atvTitle }
                            </td>
                            <td>
                              ${v.atvDesc }
                            </td>
                            <td>
                                ...
                            </td>
                            <td>
                            <a href="../cstCustomer.do?type=InCe&atvId=${v.atvId}"><img title="编辑" src="../images/33.gif" style="border:0px"/></a>&nbsp;
                            <img title="删除" src="../images/11.gif" onclick="date('${v.atvId}')"/>
                            </td>
                        </tr>
                      </c:forEach>
                    </table>
                    </div>
</body>
</html>

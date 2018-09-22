<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title></title>
     <link href="../CSS/Style4.css" rel="stylesheet" type="text/css" />
    <link href="../CSS/style2.css" rel="stylesheet" type="text/css" />
     <script type="text/javascript">
        function showMsg() {
            window.showModalDialog("LostMsg.htm?data=" + Math.random(), "参数", "dialogWidth:550px;dialogHeight:400px;help:no");
        }
        function show(){
        var page=document.getElementById("page").value;
        location.href="../cstlost.do?type=query&curPage="+page;
        }
 </script>
 <%
 
  String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
  session.setAttribute("datetime", datetime);
  %>
</head>
<body>
 <div id="desDiv">
        <span>客户流失管理</span><br />
        显示即将流失的客户信息，并制定挽救措施
    </div>
    <form action="../cstlost.do?type=query" method="post">
    <table class="tableEdit">
        <tr>
            <th>
                客户名称：
            </th>
            <td>
                <input type="text" name="lstCustName"/>
            </td>
            <th>
                客户经理：
            </th>
            <td>
                <input type="text"  name="lstCustManagerName"/>
            </td>
            <th>
                状态：
            </th>
            <td>
                <select>
                    <option selected="selected" name="lstStatus">全部</option>
                    <option>预警</option>
                    <option>暂缓流失</option>
                    <option>确认流失</option>
                </select>
            </td>
        </tr>
        <tfoot>
            <tr>
                <td colspan="8">
                    <input type="submit" value="查询" />
                </td>
            </tr>
        </tfoot>
    </table>
    </form>
    <div style="width: 1065px">
        <div>
            <table class="dataTable">
                <tr>
                    <th>
                        客户编号
                    </th>
                    <th>
                        客户名称
                    </th>
                    <th>
                        客户经理
                    </th>
                    <th>
                        最后下单时间
                    </th>
                    <th>
                        确认流失时间
                    </th>
                    <th>
                        状态
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                <c:forEach items="${list }" var="v">
                <tr>
                    <td>
                       ${v.cstCustomer.custNo }
                    </td>
                    <td>
                        ${v.lstCustName }
                    </td>
                    <td>
                     ${v.lstCustManagerName }
                    </td>
                    <td>
                        <fmt:formatDate value="${v.lstLastOrderDate }" pattern="yyyy-MM-dd" />
                    </td>
                    <td>
                  <fmt:formatDate value="${v.lstLostDate }" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>
                      <c:if test="${v.getLstStatus().trim().equals('1')}">预警</c:if>
                     <c:if test="${v.getLstStatus().trim().equals('2')}">暂缓流失</c:if>
                      <c:if test="${v.getLstStatus().trim().equals('3')}">确认流失</c:if>
                    </td>
                    <td>
                    <c:if test="${!v.getLstStatus().trim().equals('3')}" var="f">
                        <a href="../cstlost.do?type=Ad&lstId=${v.lstId}"><img src="../images/bt_relay.gif" title="暂缓流失" style="border:0px" /></a>
                        <a href="../cstlost.do?type=AC&lstId=${v.lstId}"><img src="../images/bt_confirm.gif" title="确认流失" style="border:0px" /></a>
                    </c:if>
                    <c:if test="${!f}">
                    <a href="../cstlost.do?type=ue&lstId=${v.lstId}"><img src="../images/bt_plan.gif" title="查看" style="border:0px" /></a>
                    </c:if>
                    </td>
                </tr>
        </c:forEach>
            </table>
            <div id="pageDiv">
                <div id="leftPage">
                    共有${maxPage }条记录，当前第${curPage }/${maxPage }页</div>
                <div id="rightPage">
                    <input type="image" src="../images/first.gif"  onclick="location.href='../cstlost.do?type=query&curPage=1'"/>&nbsp;&nbsp;
                    <input type="image" src="../images/back.gif"   onclick="location.href='../cstlost.do?type=query&curPage=${curPage-1}'" />&nbsp;&nbsp;
                    <input type="image" src="../images/next.gif"   onclick="location.href='../cstlost.do?type=query&curPage=${curPage+1}'"/>&nbsp;&nbsp;
                    <input type="image" src="../images/last.gif"   onclick="location.href='../cstlost.do?type=query&curPage=${maxPage}'"/>&nbsp;&nbsp; 
                    转到第<input type="text" size="1" id="page"/>&nbsp;&nbsp;
                        <input type="image" src="../images/go.gif" onclick="show()" />
                </div>
            </div>
        </div>
    </div>
</body>
</html>

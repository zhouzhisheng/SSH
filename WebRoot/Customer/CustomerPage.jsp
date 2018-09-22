<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.1.0  Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="../CSS/style2.css" rel="stylesheet" type="text/css" />
    <link href="../CSS/Style4.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
     function dosi(){
        var page=document.getElementById("page").value;    
        location.href="../cstCustomer.do?type=query&curpage="+page;
    }
   function date(custNo){
    	if(confirm("真的确认删除该信息吗？")){
    	location.href="../cstCustomer.do?type=datemcc&custNo="+custNo;
    	}
    }
    </script>
</head>
<body>
    <div id="desDiv">
        <span>客户信息管理</span><br />
        维护客户信息，记录客户联系电话和交往记录
    </div>
     <form action="../cstCustomer.do?type=query" method="post">
    <table class="tableEdit">
        <tr>
            <th>
                客户名称：
            </th>
            <td>
                <input type="text" name="custName" />
            </td>
            <th>
                客户编号：
            </th>
            <td>
                <input type="text"  name="custNo"/>
            </td>
            <th>
                地区：
            </th>
            <td>
                <select>
                    <option selected="selected" name="custRegion">全部</option>
                    <option>华北</option>
                    <option>华南</option>
                    <option>中南</option>
                    <option>西北</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>
                客户经理：
            </th>
            <td>
                <input type="text" name="custManagerName" />
            </td>
            <th>
                客户等级：
            </th>
            <td>
                <select>
                    <option selected="selected" name="custLevel">全部</option>
                    <option value="0">战略合作伙伴</option>
                    <option value="1">合作伙伴</option>
                    <option value="2">大客户</option>
                    <option value="3">普通客户</option>
                </select>
            </td>
            <th></th><td></td>
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
    <br />
            <table class="dataTable">
                <tr>
                    <th>
                        客户编号
                    </th>
                    <th>
                        客户名称
                    </th>
                    <th>
                        地区
                    </th>
                    <th>
                        客户经理
                    </th>
                    <th>
                        客户等级
                    </th>
                    <th>
                        建立时间
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                <c:forEach items="${list }" var="v">
                <tr>
                    <td>
                        ${v.custNo }
                    </td>
                    <td>
                        ${v.custName }
                    </td>
                    <td>
                        ${v.custRegion }
                    </td>
                    <td>
                        ${v.custManagerName}
                    </td>
                    <td>
                    ${v.custLevelLabel }
                    </td>
                    <td>
                     未知
                    </td>
                    <td>
                        <a href="../cstCustomer.do?type=AI&custNo=${v.custNo}"><img src="../images/33.gif" title="编辑" style="border:0px" /></a>
                        <a href="../cstCustomer.do?type=In&custNo=${v.custNo }"><img src="../images/bt_linkman.gif" title="联系人" style="border:0px;width:16px;height:16px" /></a>
                        <a href="../cstCustomer.do?type=Iv&custNo=${v.custNo }"><img src="../images/bt_acti.gif" title="交往记录" style="border:0px" /></a>
                        <a href="../cstCustomer.do?type=Or&custNo=${v.custNo }"><img src="../images/bt_orders.gif" title="历史订单" style="border:0px" /></a>
                        <img src="../images/bt_del.gif" title="删除" onclick="date('${v.custNo}')" style="border:0px" />
                    </td>
                </tr>
                </c:forEach>
            </table>
            <div id="pageDiv">
                <div id="leftPage">
                    共有${maxpage }条记录，当前第${curpage }/${maxpage }页</div>
                <div id="rightPage">
            <input type="image" src="../images/first.gif" onclick="location.href='../cstCustomer.do?type=query&curpage=1'" />&nbsp;&nbsp;
            <input type="image" src="../images/back.gif"  onclick="location.href='../cstCustomer.do?type=query&curpage=${curpage-1}'" />&nbsp;&nbsp;
            <input type="image" src="../images/next.gif"  onclick="location.href='../cstCustomer.do?type=query&curpage=${curpage+1}'"/>&nbsp;&nbsp;
            <input type="image" src="../images/last.gif"  onclick="location.href='../cstCustomer.do?type=query&curpage=${maxpage}'"/>&nbsp;&nbsp;
            转到第<input type="text" size="1" id="page" />&nbsp;&nbsp;
            <input type="image"  src="../images/go.gif" onclick="dosi()"/>
            </div>
            </div>
</body>
</html>

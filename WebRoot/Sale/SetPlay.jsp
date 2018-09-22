<%@page import="com.baidu.dao.CstlostDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 4.0.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="../CSS/style2.css" rel="stylesheet" type="text/css" />
    <link href="../CSS/Style1.css" rel="stylesheet" type="text/css" />
    
	<script type="text/javascript" src="../JS/jquery.js"></script>
	<script type="text/javascript" src="../JS/laydate/laydate.js"></script>
	<%
	 String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	pageContext.setAttribute("datetime", datetime);
	session.setAttribute("datetime", datetime);
	 %>
	 <script type="text/javascript">
	 function date(id){
	 if(confirm("真的确认删除该信息吗？")){
	 location.href="../salPlan.do?type=date&chcId="+id;
	 }
	 }
	 function show(chcId,index,plaId){
	 var podo=document.getElementById("todo"+index).value;
	 location.href="../salPlan.do?type=AddSpla&id="+chcId+"&todo="+podo+"&plaId="+plaId;
	 }
	 </script>
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
            <th>计划项</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${slist }" var="v" varStatus="i" >
        <tr>
            <td><fmt:formatDate value="${v.plaDate }" pattern="yyyy-MM-dd"/></td>
            <td><input type="text" style="width:500px" id="todo${i.index }" name="todo" value="${v.plaTodo }"/></td>
            <td>
                <a href="javascript:show(${sal.chcId },${i.index },${v.plaId })"><img title="保存" src="../images/edt.gif" style="border:0px" /></a>&nbsp;&nbsp;
                <img title="删除" src="../images/del.gif" onclick="date('${v.plaId}')" />
            </td>
        </tr>
        </c:forEach>
    </table>
    <p></p>
    <form action="../salPlan.do?type=AddSalPlan&id=${sal.chcId }" method="post">
    <table class="tableEdit">
        <thead>
            <tr>
                <td colspan="4">新增计划</td>
            </tr>
        </thead>
        <tr>
            <th>日期：</th>
            <td>
               <!-- <input type="text" id="Calendar1"/> -->
             <input type="text" name="datetime" /> 
            </td>
            <th>计划项</th>
            <td><input type="text" style="width:500px"  name="todo" /></td>
        </tr>
        <tfoot>
            <tr>
                <td colspan="4">
                    <input type="submit" value="添加" />&nbsp;&nbsp;
                    <input type="button" value="返回" />
                </td>
            </tr>
        </tfoot>
    </table>
    </form>
</body>
</html>

<script type="text/javascript">
	laydate.skin('molv');
    laydate({ elem: '#Calendar1' });
</script>

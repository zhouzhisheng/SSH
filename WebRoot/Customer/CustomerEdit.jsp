<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean"  prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title></title>
    <link href="../CSS/style2.css" rel="stylesheet" type="text/css" />
    <script>
    function show(obj){
    var lab=document.getElementById("Lab");
    	if(obj.value==1){
    		lab.value="战略合作伙伴";
    	}else if(obj.value==2){
    		lab.value="普通客户";
    	}else if(obj.value==3){
    		lab.value="大客户";
    	}else{
    		lab.value="合作伙伴";
    	}
    }
    </script>
</head>
<body>
<html:form action="cstCustomer.do?type=Ud" method="post">
<table class="tableEdit">
        <thead>
            <tr>
                <td colspan="4">客户基本信息</td>
            </tr>
        </thead>
        <tr>
            <th>客户编号：</th>
            <td>
                <bean:write name="sc" property="custNo"/></td>
            <th>客户经理：</th>
            <td><bean:write name="sc" property="custManagerName"/>
            </td>
        </tr>
        <tr>
            <th>客户名称：</th>
            <td>
                <html:text name="sc" property="custName"></html:text>
             </td>
            <th>地区：</th>
            <td>
                <html:select name="sc" property="custRegion">
                    <html:option value="华北">华北</html:option>
                    <html:option value="华南">华南</html:option>
                    <html:option value="中南">中南</html:option>
                    <html:option value="西北">西北</html:option>
                </html:select>
            </td>
        </tr>
        <tr>
            <th>客户等级：</th>
            <td>
            	<html:hidden property="custLevelLabel" styleId="Lab" value="" />
                <html:select name="sc" onchange="show(this)" property="custLevelLabel">
                    <html:option value="1">战略合作伙伴</html:option>
                    <html:option value="4">合作伙伴</html:option>
                    <html:option value="3">大客户</html:option>
                    <html:option value="2">普通客户</html:option>
                </html:select>
             </td>
            <th></th><td></td>
        </tr>
        <tr>
            <th>客户满意度：</th>
            <td>
                <html:select  name="sc" property="custSatisfy">
                    <html:option value="1">☆</html:option>
                    <html:option value="2">☆☆</html:option>
                    <html:option value="3">☆☆☆</html:option>
                    <html:option value="4">☆☆☆☆</html:option>
                    <html:option value="5">☆☆☆☆☆</html:option>
                </html:select>
             </td>
            <th>客户信用度：</th>
            <td>
                <html:select name="sc" property="custCredit">
                    <html:option value="1">☆</html:option>
                    <html:option value="2">☆☆</html:option>
                    <html:option value="3">☆☆☆</html:option>
                    <html:option value="4">☆☆☆☆</html:option>
                    <html:option value="5">☆☆☆☆☆</html:option>
                </html:select>
            </td>
        </tr>
    </table>
    <p></p>
    <table class="tableEdit">
        <thead>
            <tr>
                <td colspan="4">客户联系信息</td>
            </tr>
        </thead>
        <tr>
            <th>地址：</th>
            <td>
                <html:text name="sc" property="custAddr" style="300px"></html:text>
            </td>
            <th>邮编：</th>
            <td>
               <html:text name="sc" property="custZip"></html:text>
            </td>
        </tr>
        <tr>
            <th>电话：</th>
            <td>
               <html:text name="sc" property="custTel"></html:text>
            </td>
            <th>传真：</th>
            <td>
               <html:text name="sc" property="custFax"></html:text>
            </td> 
        </tr>
        <tr>
            <th>网咨：</th>
            <td>
               <html:text name="sc" property="custWebsite"></html:text>
            </td>
            <th></th><td></td>
        </tr>
    </table>
    <p></p>
    <table class="tableEdit">
        <thead>
            <tr>
                <td colspan="4">公司信息</td>
            </tr>
        </thead>
        <tr>
            <th>营业执照号：</th>
            <td>
               <html:text name="sc" property="custLicenceNo"></html:text>
            </td>
            <th>法人：</th>
            <td>
                <html:text name="sc" property="custChieftain"></html:text>
            </td>
        </tr>
        <tr>
            <th>注册资金(万元)：</th>
            <td>
               <html:text name="sc" property="custBankroll"></html:text>
            </td>
            <th>年营业额：</th>
            <td>
                <html:text name="sc" property="custTurnover"></html:text>
            </td>
        </tr>
        <tr>
            <th>开户银行：</th>
            <td>
                <html:text name="sc" property="custBank"></html:text>
            </td>
            <th>银行账号：</th>
            <td>
                <html:text name="sc" property="custBankAccount"></html:text>
            </td>
        </tr>
        <tr>
            <th>地税登记号：</th>
            <td>
               <html:text name="sc" property="custLocalTaxNo"></html:text>
            </td>
            <th>国税登记号：</th>
            <td>
                <html:text name="sc" property="custNationalTaxNo"></html:text>
            </td>
        </tr>
    </table>
    <p></p>
    <input type="submit" value="保存" />&nbsp;&nbsp;
    <input type="button" value="返回" />
</html:form>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
                <td colspan="4">订单信息</td>
            </tr>
        </thead>
        <tr>
            <th>日期：</th>
            <td>
                <input type="text"  id="" name=""/>
            </td>
            <th>状态：</th>
			<td>
				<select id="" name="">
					<option value="">未回款</option>
					<option value="">已回款</option>
				</select>
            </td>
        </tr>
        <tr>
            <th>总金额(元)：</th>
            <td>
				<input type="text"  id="" name="" readonly="true" value="666.66" style="background-color: #f4f4f4;"/>
			</td>
			<th>送货地址：</th>
            <td>
                <input type="text"  id="" name="" style="width:420px;"/>
            </td>
        </tr>
    </table>
    <p>
    </p>
    <table class="dataTable">
        <tr>
            <th>日期</th>
            <th>商品名</th>
			<th>数量</th>
			<th>单位</th>
			<th>单价(元)</th>
			<th>金额(元)</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>2016-1-1</td>
			<td><input type="text" style="width:500px" /></td>
            <td><input type="text" style="width:118px" /></td>
			<td><input type="text" style="width:118px" /></td>
            <td><input type="text" style="width:118px" /></td>
			<td><input type="text" style="width:118px" /></td>
            <td>
                <a href=""><img title="保存" src="../images/edt.gif" style="border:0px" /></a>&nbsp;&nbsp;
                <img title="删除" src="../images/del.gif" />
            </td>
        </tr>
        <tr>
            <td>2016-1-1</td>
			<td><input type="text" style="width:500px" /></td>
            <td><input type="text" style="width:118px" /></td>
			<td><input type="text" style="width:118px" /></td>
            <td><input type="text" style="width:118px" /></td>
			<td><input type="text" style="width:118px" /></td>
            <td>
                <a href=""><img title="保存" src="../images/edt.gif" style="border:0px" /></a>&nbsp;&nbsp;
                <img title="删除" src="../images/del.gif" />
            </td>
        </tr>
    </table>
    <p></p>
    <table class="tableEdit">
        <thead>
            <tr>
                <td colspan="12">新增计划</td>
            </tr>
        </thead>
        <tr>
            <th>日期：</th>
            <td>
                <input type="text"  style="width:100px" />
            </td>
            <th>商品名</th>
            <td><input type="text" style="width:200px" /></td>
			<th>数量</th>
            <td><input type="text" style="width:100px" /></td>
			<th>单位</th>
            <td><input type="text" style="width:100px" /></td>
			<th>单价(元)</th>
            <td><input type="text" style="width:100px" /></td>
			<th>金额(元)</th>
            <td><input type="text" style="width:100px" /></td>
        </tr>
        <tfoot>
            <tr>
                <td colspan="12">
                    <input type="button" value="添加" />&nbsp;&nbsp;
                    <input type="button" value="返回" />
                </td>
            </tr>
        </tfoot>
    </table>
</body>
</html>

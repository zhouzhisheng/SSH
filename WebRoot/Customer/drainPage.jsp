﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title></title>
    <link href="../CSS/Style4.css" rel="stylesheet" type="text/css" />
    <script src="../js/jquery-1.4.1-vsdoc.js" type="text/javascript"></script>
</head>
<body>
    <div id="desDiv">
        <span>客户信息管理</span><br />
        维护客户信息，记录客户联系电话和交往记录
    </div>
    <br />
    <div style="width: 1065px">
        <div id="dataLeft">
            <table class="dataTable">
                <tr>
                    <th>
                        客户编号
                    </th>
                    <th>
                        客户名称
                    </th>
                    <th>
                        建立时间
                    </th>
                    <th>
                        客户经理
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                <tr>
                    <td>
                        KH100101
                    </td>
                    <td>
                        睿智数码
                    </td>
                    <td>
                        2011年5月2日
                    </td>
                    <td>
                        张三
                    </td>
                    <td>
                        <img src="../images/33.gif" title="编辑" onclick="showCustomer()" />
                    </td>
                </tr>
                <tr>
                    <td>
                        KH110511
                    </td>
                    <td>
                        北京大学
                    </td>
                    <td>
                        2011年5月2日
                    </td>
                    <td>
                        张三
                    </td>
                    <td><img src="../images/33.gif" title="编辑" onclick="showCustomer()" />
                    </td>
                </tr>
                <tr>
                    <td>
                        KH090123
                    </td>
                    <td>
                        清华大学
                    </td>
                    <td>
                        2011年5月2日
                    </td>
                    <td>
                        张三
                    </td>
                    <td><img src="../images/33.gif" title="编辑" onclick="showCustomer()" />
                    </td>
                </tr>
            </table>
            <div id="pageDiv">
                <div id="leftPage">
                    共有120条记录，当前第1/10页</div>
                <div id="rightPage">
                    <input type="image" src="../images/first.gif" />&nbsp;&nbsp;
                    <input type="image" src="../images/back.gif" />&nbsp;&nbsp;
                    <input type="image" src="../images/next.gif" />&nbsp;&nbsp;
                    <input type="image" src="../images/last.gif" />&nbsp;&nbsp; 转到第<input type="text"
                        size="1" />&nbsp;&nbsp;<input type="image" src="../images/go.gif" />
                </div>
            </div>
        </div>
        <div id="dataRight">
            <div class="menuDiv">
                <div style="background-image:url(../images/bg.gif)">暂缓流失措施
                </div>
            </div>
            <div class="contentDiv">
                <div>
                    <a href="javascript:showLinkMan()">新建联系人</a>
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
                            <th>
                                操作
                            </th>
                        </tr>
                        <tr>
                            <td>
                                张大山
                            </td>
                            <td>
                                男
                            </td>
                            <td>
                                经理
                            </td>
                            <td>
                                0731-8998765
                            </td>
                            <td>
                                13890987653
                            </td>
                            <td><img title="编辑" src="../images/33.gif" onclick="showLinkMan()" />&nbsp;&nbsp;<img title="删除" src="../images/11.gif" />
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
